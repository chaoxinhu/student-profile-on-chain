package org.fiscobcos.quiz.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple5;
import org.fisco.bcos.web3j.tuples.generated.Tuple6;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.fiscobcos.quiz.base.IdInfo;
import org.fiscobcos.quiz.base.TrainingRecord;
import org.fiscobcos.quiz.constants.AddressConstants;
import org.fiscobcos.quiz.constants.GasConstants;
import org.fiscobcos.quiz.contracts.Id;
import org.fiscobcos.quiz.contracts.Id.BaseInfoChangedEventResponse;
import org.fiscobcos.quiz.contracts.Id.TrainingRecordChangedEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IdService {

    private Web3j web3j;

    public void setWeb3j(Web3j web3j) {
        this.web3j = web3j;
    }

    public Web3j getWeb3j() {
        return this.web3j;
    }

    // Deploy ID
    public String deployId(
        String owner,
        String name,
        String sid,
        Integer birthDate,
        Boolean gender,
        String privateKey
    ) {
        try {
            Credentials credentials = Credentials.create(privateKey);
            Id id = Id.deploy(web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT),
                owner, name, sid, new BigInteger(String.valueOf(birthDate), 10), gender).send();
            log.info("ID address is {}", id.getContractAddress());
            return id.getContractAddress();
        } catch (Exception e) {
            log.error("deploy id contract fail: {}", e.getMessage());
        }
        return StringUtils.EMPTY;
    }

    // Id load
    private Id loadId(String address, String privateKey) {
        Credentials credentials = Credentials.create(privateKey);
        return Id.load(address, web3j, credentials,
            new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
    }

    public IdInfo getBaseIdInfo(String address) {
        Id id = loadId(address, AddressConstants.DEFAULT_READ_PRIVATE_KEY);
        try {
            Tuple5<String, String, String, BigInteger, Boolean> tuple =
                id.getBaseInfo().send();
            IdInfo idInfo = new IdInfo();
            idInfo.setOwner(tuple.getValue1());
            idInfo.setName(tuple.getValue2());
            idInfo.setSid(tuple.getValue3());
            idInfo.setBirthDate(tuple.getValue4().intValue());
            idInfo.setGender(tuple.getValue5());
            return idInfo;
        } catch (Exception e) {
            log.error("get id base info fail: {}", e.getMessage());
        }
        return null;
    }

    public IdInfo getAllTrainingRecord(String address, IdInfo idInfo) {
        Id id = loadId(address, AddressConstants.DEFAULT_READ_PRIVATE_KEY);
        try {
            Tuple6<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<String>, List<BigInteger>>
                tuple = id.getAllTrainingRecord().send();
            int size = tuple.getValue1().size();
            Object[] issuerObjArray = tuple.getValue1().toArray();
            Object[] typeObjArray = tuple.getValue2().toArray();
            Object[] startDateObjArray = tuple.getValue3().toArray();
            Object[] endDateObjArray = tuple.getValue4().toArray();
            Object[] diplomaAddressObjArray = tuple.getValue5().toArray();
            Object[] timestampObjArray = tuple.getValue6().toArray();
            List<TrainingRecord> trs = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TrainingRecord tr = new TrainingRecord();
                tr.setIssuer(issuerObjArray[i].toString());
                tr.setType(((Uint256) typeObjArray[i]).getValue().intValue());
                tr.setStartDate(((Uint256) startDateObjArray[i]).getValue().intValue());
                tr.setEndDate(((Uint256) endDateObjArray[i]).getValue().intValue());
                tr.setDiplomaAddress(diplomaAddressObjArray[i].toString());
                tr.setTimestamp(((Uint256) timestampObjArray[i]).getValue().intValue());
                trs.add(tr);
            }
            idInfo.setTrainingRecords(trs);
            return idInfo;
        } catch (Exception e) {
            log.error("get id training info fail: {}", e.getMessage());
        }
        return null;
    }

    public Boolean setName(String address, String name, String privateKey) {
        try {
            Id id = loadId(address, privateKey);
            TransactionReceipt receipt = id.setName(name).send();
            List<BaseInfoChangedEventResponse> eventList =
                id.getBaseInfoChangedEvents(receipt);
            for (BaseInfoChangedEventResponse event : eventList) {
                if (event.retCode.intValue() == BigInteger.ZERO.intValue() &&
                    event.val.equalsIgnoreCase(name)) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("set name fail: {}", e.getMessage());
        }
        return false;
    }

    public Boolean addTrainingRecord(
        Integer timestamp,
        Integer type,
        Integer startDate,
        Integer endDate,
        String diplomaAddress,
        String address,
        String privateKey
    ) {
        try {
            Id id = loadId(address, privateKey);
            TransactionReceipt receipt = id.addTrainingRecord(
                new BigInteger(String.valueOf(timestamp), 10),
                new BigInteger(String.valueOf(type), 10),
                new BigInteger(String.valueOf(startDate), 10),
                new BigInteger(String.valueOf(endDate), 10),
                diplomaAddress
            ).send();
            List<TrainingRecordChangedEventResponse> eventList =
                id.getTrainingRecordChangedEvents(receipt);
            for (TrainingRecordChangedEventResponse event : eventList) {
                if (event.retCode.intValue() == BigInteger.ZERO.intValue()) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("add training record fail: {}", e.getMessage());
        }
        return false;
    }

    public Boolean modifyTrainingRecord(
        Integer timestamp,
        Integer type,
        Integer startDate,
        Integer endDate,
        String diplomaAddress,
        String address,
        String privateKey
    ) {
        try {
            Id id = loadId(address, privateKey);
            TransactionReceipt receipt = id.modifyTrainingRecord(
                new BigInteger(String.valueOf(timestamp), 10),
                new BigInteger(String.valueOf(type), 10),
                new BigInteger(String.valueOf(startDate), 10),
                new BigInteger(String.valueOf(endDate), 10),
                diplomaAddress
            ).send();
            List<TrainingRecordChangedEventResponse> eventList =
                id.getTrainingRecordChangedEvents(receipt);
            for (TrainingRecordChangedEventResponse event : eventList) {
                if (event.retCode.intValue() == BigInteger.ZERO.intValue()) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("add training record fail: {}", e.getMessage());
        }
        return false;
    }
}
