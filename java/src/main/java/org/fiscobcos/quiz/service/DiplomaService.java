/*
 * Copyright 2014-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fiscobcos.quiz.service;

import java.math.BigInteger;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple11;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.fiscobcos.quiz.base.DiplomaInfo;
import org.fiscobcos.quiz.constants.AddressConstants;
import org.fiscobcos.quiz.constants.GasConstants;
import org.fiscobcos.quiz.contracts.Diploma;
import org.fiscobcos.quiz.contracts.Diploma.StateChangedEventResponse;
import org.fiscobcos.quiz.contracts.DiplomaFactory;
import org.fiscobcos.quiz.contracts.DiplomaFactory.CreateLogEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DiplomaService
 *
 * @author chaoxinhu
 * @Description: CreditLetterService
 */
@Service
@Slf4j
public class DiplomaService {

    @Autowired
    private Web3j web3j;

    // Factory related methods starts here

    // Factory init
    public String deployDiplomaFactory() {
        try {
            Credentials credentials = Credentials.create(AddressConstants.DEFAULT_READ_PRIVATE_KEY);
            DiplomaFactory diplomaFactory = DiplomaFactory.deploy(web3j,
                credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT)).send();
            log.info("Factory address is {}", diplomaFactory.getContractAddress());
            return diplomaFactory.getContractAddress();
        } catch (Exception e) {
            log.error("deploy factory contract fail: {}", e.getMessage());
        }
        return StringUtils.EMPTY;
    }

    // Factory load
    private DiplomaFactory loadDiplomaFactory(String address, String privateKey) {
        Credentials credentials = Credentials.create(privateKey);
        return DiplomaFactory.load(address, web3j, credentials,
            new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
    }

    // Diploma create
    public String createDiploma(
        String factoryAddress,
        String owner,
        Integer timestamp,
        Integer type,
        String name,
        String sid,
        Integer startDate,
        Integer endDate,
        String department,
        String major,
        String privateKey
    ) {
        try {
            DiplomaFactory diplomaFactory = loadDiplomaFactory(factoryAddress, privateKey);
            TransactionReceipt receipt = diplomaFactory.createBasicDiploma(
                owner,
                new BigInteger(String.valueOf(timestamp), 10),
                new BigInteger(String.valueOf(type), 10),
                name,
                sid,
                new BigInteger(String.valueOf(startDate), 10),
                new BigInteger(String.valueOf(endDate), 10),
                department,
                major
            ).send();
            List<CreateLogEventResponse> eventList =
                diplomaFactory.getCreateLogEvents(receipt);
            for (CreateLogEventResponse event : eventList) {
                if (StringUtils.isEmpty(event.addr)) {
                    continue;
                }
                return event.addr;
            }
        } catch (Exception e) {
            log.error("create letter contract fail: {}", e.getMessage());
        }
        return StringUtils.EMPTY;
    }

    // Diploma load
    private Diploma loadDiploma(String address, String privateKey) {
        Credentials credentials = Credentials.create(privateKey);
        return Diploma.load(address, web3j, credentials,
            new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
    }

    // Letter getInfo
    public DiplomaInfo getAllDiplomaInfo(String address) {
        Diploma diploma = loadDiploma(address, AddressConstants.DEFAULT_READ_PRIVATE_KEY);
        try {
            Tuple11<String, String, BigInteger, BigInteger, String, String, String, String,
                BigInteger, BigInteger, Boolean> tuple = diploma.getAllInfo().send();
            DiplomaInfo diplomaInfo = new DiplomaInfo();
            diplomaInfo.setOwner(tuple.getValue1());
            diplomaInfo.setIssuer(tuple.getValue2());
            diplomaInfo.setTimestamp(tuple.getValue3().longValue());
            diplomaInfo.setType(tuple.getValue4().intValue());
            diplomaInfo.setName(tuple.getValue5());
            diplomaInfo.setSid(tuple.getValue6());
            diplomaInfo.setDepartment(tuple.getValue7());
            diplomaInfo.setMajor(tuple.getValue8());
            diplomaInfo.setStartDate(tuple.getValue9().intValue());
            diplomaInfo.setEndDate(tuple.getValue10().intValue());
            diplomaInfo.setRevoked(tuple.getValue11());
            return diplomaInfo;
        } catch (Exception e) {
            log.error("get diploma info fail: {}", e.getMessage());
        }
        return null;
    }

    public Boolean setRevoked(String address, Boolean status, String privateKey) {
        try {
            Diploma diploma = loadDiploma(address, privateKey);
            TransactionReceipt receipt = diploma.setRevoked(status).send();
            List<StateChangedEventResponse> eventList =
                diploma.getStateChangedEvents(receipt);
            for (StateChangedEventResponse event : eventList) {
                if (event.retCode.intValue() == BigInteger.ZERO.intValue() &&
                    event.stateNew.equals(status)) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("set status fail: {}", e.getMessage());
        }
        return false;
    }
}
