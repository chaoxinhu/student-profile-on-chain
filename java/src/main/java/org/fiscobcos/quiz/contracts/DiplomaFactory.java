package org.fiscobcos.quiz.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple9;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version null.
 */
@SuppressWarnings("unchecked")
public class DiplomaFactory extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b5061104c806100206000396000f300608060405260043610610041576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063fc4e585b14610046575b600080fd5b34801561005257600080fd5b506101c7600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192908035906020019092919080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506101c9565b005b6000898989898989896101da6104f3565b808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018781526020018681526020018060200180602001858152602001848152602001838103835287818151815260200191508051906020019080838360005b8381101561026557808201518184015260208101905061024a565b50505050905090810190601f1680156102925780820380516001836020036101000a031916815260200191505b50838103825286818151815260200191508051906020019080838360005b838110156102cb5780820151818401526020810190506102b0565b50505050905090810190601f1680156102f85780820380516001836020036101000a031916815260200191505b509950505050505050505050604051809103906000f080158015610320573d6000803e3d6000fd5b5090508073ffffffffffffffffffffffffffffffffffffffff1663bc7f666884846040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835285818151815260200191508051906020019080838360005b838110156103b0578082015181840152602081019050610395565b50505050905090810190601f1680156103dd5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156104165780820151818401526020810190506103fb565b50505050905090810190601f1680156104435780820380516001836020036101000a031916815260200191505b50945050505050600060405180830381600087803b15801561046457600080fd5b505af1158015610478573d6000803e3d6000fd5b505050507f4481db8423b8eae544e932e436f55884c6487e4d3ca295a3ca992ecf84ecc695818a604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a150505050505050505050565b604051610b1d8061050483390190560060806040526000600b5534801561001557600080fd5b50604051610b1d380380610b1d8339810180604052810190808051906020019092919080519060200190929190805190602001909291908051820192919060200180518201929190602001805190602001909291908051906020019092919050505032600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550866000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508560028190555084600381905550836004908051906020019061011c929190610169565b508260059080519060200190610133929190610169565b5081600881905550806009819055506000600a60006101000a81548160ff0219169083151502179055505050505050505061020e565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106101aa57805160ff19168380011785556101d8565b828001600101855582156101d8579182015b828111156101d75782518255916020019190600101906101bc565b5b5090506101e591906101e9565b5090565b61020b91905b808211156102075760008160009055506001016101ef565b5090565b90565b6109008061021d6000396000f300608060405260043610610057576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063b18e15bd1461005c578063b5e7f0b2146102bd578063bc7f6668146102ec575b600080fd5b34801561006857600080fd5b5061007161039b565b604051808c73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018a8152602001898152602001806020018060200180602001806020018881526020018781526020018615151515815260200185810385528c818151815260200191508051906020019080838360005b83811015610143578082015181840152602081019050610128565b50505050905090810190601f1680156101705780820380516001836020036101000a031916815260200191505b5085810384528b818151815260200191508051906020019080838360005b838110156101a957808201518184015260208101905061018e565b50505050905090810190601f1680156101d65780820380516001836020036101000a031916815260200191505b5085810383528a818151815260200191508051906020019080838360005b8381101561020f5780820151818401526020810190506101f4565b50505050905090810190601f16801561023c5780820380516001836020036101000a031916815260200191505b50858103825289818151815260200191508051906020019080838360005b8381101561027557808201518184015260208101905061025a565b50505050905090810190601f1680156102a25780820380516001836020036101000a031916815260200191505b509f5050505050505050505050505050505060405180910390f35b3480156102c957600080fd5b506102ea6004803603810190808035151590602001909291905050506106a8565b005b3480156102f857600080fd5b50610399600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506107a0565b005b60008060008060608060608060008060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166002546003546004600560066007600854600954600a60009054906101000a900460ff16868054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104aa5780601f1061047f576101008083540402835291602001916104aa565b820191906000526020600020905b81548152906001019060200180831161048d57829003601f168201915b50505050509650858054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105465780601f1061051b57610100808354040283529160200191610546565b820191906000526020600020905b81548152906001019060200180831161052957829003601f168201915b50505050509550848054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105e25780601f106105b7576101008083540402835291602001916105e2565b820191906000526020600020905b8154815290600101906020018083116105c557829003601f168201915b50505050509450838054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561067e5780601f106106535761010080835404028352916020019161067e565b820191906000526020600020905b81548152906001019060200180831161066157829003601f168201915b505050505093509a509a509a509a509a509a509a509a509a509a509a50909192939495969798999a565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156107045761079d565b80600a60006101000a81548160ff0219169083151502179055507fda27f9e73c12bc81c835e231fddf98dfc63222165f366c047231d89f9a627f3e600b5482604051808381526020018060200183151515158152602001828103825260068152602001807f7265766f6b650000000000000000000000000000000000000000000000000000815250602001935050505060405180910390a15b50565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff161415156107fc5761082b565b816006908051906020019061081292919061082f565b50806007908051906020019061082992919061082f565b505b5050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061087057805160ff191683800117855561089e565b8280016001018555821561089e579182015b8281111561089d578251825591602001919060010190610882565b5b5090506108ab91906108af565b5090565b6108d191905b808211156108cd5760","008160009055506001016108b5565b5090565b905600a165627a7a72305820dd35f8850121dd672d0822e79f8bd5ffa983ff98c31f8594781bcd7e1054c5610029a165627a7a7230582052da32ed0441bbf64988f027f4f513432b2f06ec75dcb86480f8286b5adf0cef0029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"ownerValue\",\"type\":\"address\",\"type0\":null,\"indexed\":false},{\"name\":\"timestampValue\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"typeValue\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"nameValue\",\"type\":\"string\",\"type0\":null,\"indexed\":false},{\"name\":\"sidValue\",\"type\":\"string\",\"type0\":null,\"indexed\":false},{\"name\":\"startDateValue\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"endDateValue\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"departmentValue\",\"type\":\"string\",\"type0\":null,\"indexed\":false},{\"name\":\"majorValue\",\"type\":\"string\",\"type0\":null,\"indexed\":false}],\"name\":\"createBasicDiploma\",\"outputs\":[],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"nonpayable\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\",\"type0\":null,\"indexed\":false},{\"name\":\"timestamp\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false}],\"name\":\"CreateLog\",\"outputs\":null,\"type\":\"event\",\"payable\":false,\"stateMutability\":null}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_CREATEBASICDIPLOMA = "createBasicDiploma";

    public static final Event CREATELOG_EVENT = new Event("CreateLog", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected DiplomaFactory(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DiplomaFactory(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DiplomaFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DiplomaFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> createBasicDiploma(String ownerValue, BigInteger timestampValue, BigInteger typeValue, String nameValue, String sidValue, BigInteger startDateValue, BigInteger endDateValue, String departmentValue, String majorValue) {
        final Function function = new Function(
                FUNC_CREATEBASICDIPLOMA, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(ownerValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestampValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(typeValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(nameValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(sidValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(startDateValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(endDateValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(departmentValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(majorValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void createBasicDiploma(String ownerValue, BigInteger timestampValue, BigInteger typeValue, String nameValue, String sidValue, BigInteger startDateValue, BigInteger endDateValue, String departmentValue, String majorValue, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATEBASICDIPLOMA, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(ownerValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestampValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(typeValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(nameValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(sidValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(startDateValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(endDateValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(departmentValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(majorValue)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String createBasicDiplomaSeq(String ownerValue, BigInteger timestampValue, BigInteger typeValue, String nameValue, String sidValue, BigInteger startDateValue, BigInteger endDateValue, String departmentValue, String majorValue) {
        final Function function = new Function(
                FUNC_CREATEBASICDIPLOMA, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(ownerValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestampValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(typeValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(nameValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(sidValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(startDateValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(endDateValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(departmentValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(majorValue)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple9<String, BigInteger, BigInteger, String, String, BigInteger, BigInteger, String, String> getCreateBasicDiplomaInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CREATEBASICDIPLOMA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple9<String, BigInteger, BigInteger, String, String, BigInteger, BigInteger, String, String>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue(), 
                (String) results.get(3).getValue(), 
                (String) results.get(4).getValue(), 
                (BigInteger) results.get(5).getValue(), 
                (BigInteger) results.get(6).getValue(), 
                (String) results.get(7).getValue(), 
                (String) results.get(8).getValue()
                );
    }

    public List<CreateLogEventResponse> getCreateLogEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CREATELOG_EVENT, transactionReceipt);
        ArrayList<CreateLogEventResponse> responses = new ArrayList<CreateLogEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CreateLogEventResponse typedResponse = new CreateLogEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerCreateLogEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATELOG_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerCreateLogEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATELOG_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static DiplomaFactory load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DiplomaFactory(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DiplomaFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DiplomaFactory(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DiplomaFactory load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DiplomaFactory(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DiplomaFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DiplomaFactory(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DiplomaFactory> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DiplomaFactory.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DiplomaFactory> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DiplomaFactory.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DiplomaFactory> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DiplomaFactory.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DiplomaFactory> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DiplomaFactory.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CreateLogEventResponse {
        public Log log;

        public String addr;

        public BigInteger timestamp;
    }
}
