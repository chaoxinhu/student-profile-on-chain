package org.fiscobcos.quiz.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
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
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple5;
import org.fisco.bcos.web3j.tuples.generated.Tuple6;
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
public class Id extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405260006005556103e96006556103ea6007556103eb6008553480156200002857600080fd5b506040516200141f3803806200141f8339810180604052810190808051906020019092919080518201929190602001805182019291906020018051906020019092919080519060200190929190505050846000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508360019080519060200190620000d092919062000116565b508260029080519060200190620000e992919062000116565b508160038190555080600460006101000a81548160ff0219169083151502179055505050505050620001c5565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200015957805160ff19168380011785556200018a565b828001600101855582156200018a579182015b82811115620001895782518255916020019190600101906200016c565b5b5090506200019991906200019d565b5090565b620001c291905b80821115620001be576000816000905550600101620001a4565b5090565b90565b61124a80620001d56000396000f30060806040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806355714a86146100725780635cfad9a0146102465780639551ae44146102b1578063a5ca9546146103f2578063c47f00271461045d575b600080fd5b34801561007e57600080fd5b506100876104c6565b6040518080602001806020018060200180602001806020018060200187810387528d818151815260200191508051906020019060200280838360005b838110156100de5780820151818401526020810190506100c3565b5050505090500187810386528c818151815260200191508051906020019060200280838360005b83811015610120578082015181840152602081019050610105565b5050505090500187810385528b818151815260200191508051906020019060200280838360005b83811015610162578082015181840152602081019050610147565b5050505090500187810384528a818151815260200191508051906020019060200280838360005b838110156101a4578082015181840152602081019050610189565b50505050905001878103835289818151815260200191508051906020019060200280838360005b838110156101e65780820151818401526020810190506101cb565b50505050905001878103825288818151815260200191508051906020019060200280838360005b8381101561022857808201518184015260208101905061020d565b505050509050019c5050505050505050505050505060405180910390f35b34801561025257600080fd5b506102af60048036038101908080359060200190929190803590602001909291908035906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506107cf565b005b3480156102bd57600080fd5b506102c66109ea565b604051808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018060200185815260200184151515158152602001838103835287818151815260200191508051906020019080838360005b8381101561034c578082015181840152602081019050610331565b50505050905090810190601f1680156103795780820380516001836020036101000a031916815260200191505b50838103825286818151815260200191508051906020019080838360005b838110156103b2578082015181840152602081019050610397565b50505050905090810190601f1680156103df5780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b3480156103fe57600080fd5b5061045b60048036038101908080359060200190929190803590602001909291908035906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b74565b005b34801561046957600080fd5b506104c4600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610e7f565b005b60608060608060608060006060806060806060806000806009805490509850886040519080825280602002602001820160405280156105145781602001602082028038833980820191505090505b509750886040519080825280602002602001820160405280156105465781602001602082028038833980820191505090505b509650886040519080825280602002602001820160405280156105785781602001602082028038833980820191505090505b509550886040519080825280602002602001820160405280156105aa5781602001602082028038833980820191505090505b509450886040519080825280602002602001820160405280156105dc5781602001602082028038833980820191505090505b5093508860405190808252806020026020018201604052801561060e5781602001602082028038833980820191505090505b509250600091505b888210156107ac5760098281548110151561062d57fe5b906000526020600020906006020190508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16888381518110151561067057fe5b9060200190602002019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050806001015486838151811015156106bf57fe5b9060200190602002018181525050806002015485838151811015156106e057fe5b90602001906020020181815250508060030154848381518110151561070157fe5b90602001906020020181815250508060040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16878381518110151561074257fe5b9060200190602002019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff16815250508060050154838381518110151561079157fe5b90602001906020020181815250508180600101925050610616565b878686868a879e509e509e509e509e509e50505050505050505050909192939495565b6000806000803393506009805490509250600091505b82821015610960576009828154811015156107fc57fe5b906000526020600020906006020190508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614801561086e5750806001015488145b1561095357868160020181905550858160030181905550848160040160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508881600501819055507f9a3a9ee4bd7684ea0b97c9bedba159d930f77440b5cf24b2e88324b259ce6dec600554858b85604051808581526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200182815260200194505050505060405180910390a16109df565b81806001019250506107e5565b7f9a3a9ee4bd7684ea0b97c9bedba159d930f77440b5cf24b2e88324b259ce6dec600754858b6000604051808581526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200182815260200194505050505060405180910390a15b505050505050505050565b60006060806000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1660016002600354600460009054906101000a900460ff16838054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ac05780601f10610a9557610100808354040283529160200191610ac0565b820191906000526020600020905b815481529060010190602001808311610aa357829003601f168201915b50505050509350828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b5c5780601f10610b3157610100808354040283529160200191610b5c565b820191906000526020600020905b815481529060010190602001808311610b3f57829003601f168201915b50505050509250945094509450945094509091929394565b600080600080610b82611116565b3394506009805490509350600092505b83831015610caf57600983815481101515610ba957fe5b906000526020600020906006020191508160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16148015610c1b5750816001015489145b15610ca2577f9a3a9ee4bd7684ea0b97c9bedba159d930f77440b5cf24b2e88324b259ce6dec600654868c86604051808581526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200182815260200194505050505060405180910390a1610e73565b8280600101935050610b92565b60c0604051908101604052808673ffffffffffffffffffffffffffffffffffffffff1681526020018a81526020018981526020018881526020018773ffffffffffffffffffffffffffffffffffffffff1681526020018b81525090506009819080600181540180825580915050906001820390600052602060002090600602016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010155604082015181600201556060820151816003015560808201518160040160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060a082015181600501555050507f9a3a9ee4bd7684ea0b97c9bedba159d930f77440b5cf24b2e88324b259ce6dec600554868c60018801604051808581526020018473ffff","ffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200182815260200194505050505060405180910390a15b50505050505050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610fe9577ff7122270d5cf33b40e94f9273011490e45f81b82a0c794108b8f3ffeef50a95860085482336040518084815260200180602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835260048152602001807f6e616d6500000000000000000000000000000000000000000000000000000000815250602001838103825285818151815260200191508051906020019080838360005b83811015610fab578082015181840152602081019050610f90565b50505050905090810190601f168015610fd85780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a15b8060019080519060200190610fff929190611179565b507ff7122270d5cf33b40e94f9273011490e45f81b82a0c794108b8f3ffeef50a95860055482336040518084815260200180602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835260048152602001807f6e616d6500000000000000000000000000000000000000000000000000000000815250602001838103825285818151815260200191508051906020019080838360005b838110156110d65780820151818401526020810190506110bb565b50505050905090810190601f1680156111035780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a150565b60c060405190810160405280600073ffffffffffffffffffffffffffffffffffffffff168152602001600081526020016000815260200160008152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106111ba57805160ff19168380011785556111e8565b828001600101855582156111e8579182015b828111156111e75782518255916020019190600101906111cc565b5b5090506111f591906111f9565b5090565b61121b91905b808211156112175760008160009055506001016111ff565b5090565b905600a165627a7a723058208ce01e41352568c6fd66cb981d1d38c339d61d44830992585c930858dc0b3e850029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":true,\"inputs\":[],\"name\":\"getAllTrainingRecord\",\"outputs\":[{\"name\":\"\",\"type\":\"address[]\",\"type0\":null,\"indexed\":false},{\"name\":\"\",\"type\":\"uint256[]\",\"type0\":null,\"indexed\":false},{\"name\":\"\",\"type\":\"uint256[]\",\"type0\":null,\"indexed\":false},{\"name\":\"\",\"type\":\"uint256[]\",\"type0\":null,\"indexed\":false},{\"name\":\"\",\"type\":\"address[]\",\"type0\":null,\"indexed\":false},{\"name\":\"\",\"type\":\"uint256[]\",\"type0\":null,\"indexed\":false}],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"view\"},{\"constant\":false,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"trtype\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"startDate\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"endDate\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"diplomaAddress\",\"type\":\"address\",\"type0\":null,\"indexed\":false}],\"name\":\"modifyTrainingRecord\",\"outputs\":[],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"nonpayable\"},{\"constant\":true,\"inputs\":[],\"name\":\"getBaseInfo\",\"outputs\":[{\"name\":\"ownerValue\",\"type\":\"address\",\"type0\":null,\"indexed\":false},{\"name\":\"nameValue\",\"type\":\"string\",\"type0\":null,\"indexed\":false},{\"name\":\"sidValue\",\"type\":\"string\",\"type0\":null,\"indexed\":false},{\"name\":\"birthDateValue\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"genderValue\",\"type\":\"bool\",\"type0\":null,\"indexed\":false}],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"view\"},{\"constant\":false,\"inputs\":[{\"name\":\"timestamp\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"trtype\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"startDate\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"endDate\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"diplomaAddress\",\"type\":\"address\",\"type0\":null,\"indexed\":false}],\"name\":\"addTrainingRecord\",\"outputs\":[],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"nonpayable\"},{\"constant\":false,\"inputs\":[{\"name\":\"nameValue\",\"type\":\"string\",\"type0\":null,\"indexed\":false}],\"name\":\"setName\",\"outputs\":[],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"nonpayable\"},{\"constant\":false,\"inputs\":[{\"name\":\"ownerValue\",\"type\":\"address\",\"type0\":null,\"indexed\":false},{\"name\":\"nameValue\",\"type\":\"string\",\"type0\":null,\"indexed\":false},{\"name\":\"sidValue\",\"type\":\"string\",\"type0\":null,\"indexed\":false},{\"name\":\"birthDateValue\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"genderValue\",\"type\":\"bool\",\"type0\":null,\"indexed\":false}],\"name\":null,\"outputs\":null,\"type\":\"constructor\",\"payable\":false,\"stateMutability\":\"nonpayable\"},{\"constant\":false,\"inputs\":[{\"name\":\"retCode\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"changer\",\"type\":\"address\",\"type0\":null,\"indexed\":false},{\"name\":\"timestamp\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"changedId\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false}],\"name\":\"TrainingRecordChanged\",\"outputs\":null,\"type\":\"event\",\"payable\":false,\"stateMutability\":null},{\"constant\":false,\"inputs\":[{\"name\":\"retCode\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"info\",\"type\":\"string\",\"type0\":null,\"indexed\":false},{\"name\":\"val\",\"type\":\"string\",\"type0\":null,\"indexed\":false},{\"name\":\"changer\",\"type\":\"address\",\"type0\":null,\"indexed\":false}],\"name\":\"BaseInfoChanged\",\"outputs\":null,\"type\":\"event\",\"payable\":false,\"stateMutability\":null}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_GETALLTRAININGRECORD = "getAllTrainingRecord";

    public static final String FUNC_MODIFYTRAININGRECORD = "modifyTrainingRecord";

    public static final String FUNC_GETBASEINFO = "getBaseInfo";

    public static final String FUNC_ADDTRAININGRECORD = "addTrainingRecord";

    public static final String FUNC_SETNAME = "setName";

    public static final Event TRAININGRECORDCHANGED_EVENT = new Event("TrainingRecordChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event BASEINFOCHANGED_EVENT = new Event("BaseInfoChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected Id(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Id(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Id(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Id(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<Tuple6<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<String>, List<BigInteger>>> getAllTrainingRecord() {
        final Function function = new Function(FUNC_GETALLTRAININGRECORD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Address>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<Tuple6<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<String>, List<BigInteger>>>(
                new Callable<Tuple6<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<String>, List<BigInteger>>>() {
                    @Override
                    public Tuple6<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<String>, List<BigInteger>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<String>, List<BigInteger>>(
                                convertToNative((List<Address>) results.get(0).getValue()), 
                                convertToNative((List<Uint256>) results.get(1).getValue()), 
                                convertToNative((List<Uint256>) results.get(2).getValue()), 
                                convertToNative((List<Uint256>) results.get(3).getValue()), 
                                convertToNative((List<Address>) results.get(4).getValue()), 
                                convertToNative((List<Uint256>) results.get(5).getValue()));
                    }
                });
    }

    public RemoteCall<TransactionReceipt> modifyTrainingRecord(BigInteger timestamp, BigInteger trtype, BigInteger startDate, BigInteger endDate, String diplomaAddress) {
        final Function function = new Function(
                FUNC_MODIFYTRAININGRECORD, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(trtype), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(startDate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(endDate), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(diplomaAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void modifyTrainingRecord(BigInteger timestamp, BigInteger trtype, BigInteger startDate, BigInteger endDate, String diplomaAddress, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_MODIFYTRAININGRECORD, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(trtype), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(startDate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(endDate), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(diplomaAddress)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String modifyTrainingRecordSeq(BigInteger timestamp, BigInteger trtype, BigInteger startDate, BigInteger endDate, String diplomaAddress) {
        final Function function = new Function(
                FUNC_MODIFYTRAININGRECORD, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(trtype), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(startDate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(endDate), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(diplomaAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, String> getModifyTrainingRecordInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_MODIFYTRAININGRECORD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, String>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue(), 
                (String) results.get(4).getValue()
                );
    }

    public RemoteCall<Tuple5<String, String, String, BigInteger, Boolean>> getBaseInfo() {
        final Function function = new Function(FUNC_GETBASEINFO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple5<String, String, String, BigInteger, Boolean>>(
                new Callable<Tuple5<String, String, String, BigInteger, Boolean>>() {
                    @Override
                    public Tuple5<String, String, String, BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, String, BigInteger, Boolean>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addTrainingRecord(BigInteger timestamp, BigInteger trtype, BigInteger startDate, BigInteger endDate, String diplomaAddress) {
        final Function function = new Function(
                FUNC_ADDTRAININGRECORD, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(trtype), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(startDate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(endDate), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(diplomaAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addTrainingRecord(BigInteger timestamp, BigInteger trtype, BigInteger startDate, BigInteger endDate, String diplomaAddress, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDTRAININGRECORD, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(trtype), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(startDate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(endDate), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(diplomaAddress)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addTrainingRecordSeq(BigInteger timestamp, BigInteger trtype, BigInteger startDate, BigInteger endDate, String diplomaAddress) {
        final Function function = new Function(
                FUNC_ADDTRAININGRECORD, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(timestamp), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(trtype), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(startDate), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(endDate), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(diplomaAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, String> getAddTrainingRecordInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDTRAININGRECORD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, String>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue(), 
                (String) results.get(4).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setName(String nameValue) {
        final Function function = new Function(
                FUNC_SETNAME, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(nameValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setName(String nameValue, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETNAME, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(nameValue)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setNameSeq(String nameValue) {
        final Function function = new Function(
                FUNC_SETNAME, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(nameValue)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetNameInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public List<TrainingRecordChangedEventResponse> getTrainingRecordChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRAININGRECORDCHANGED_EVENT, transactionReceipt);
        ArrayList<TrainingRecordChangedEventResponse> responses = new ArrayList<TrainingRecordChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TrainingRecordChangedEventResponse typedResponse = new TrainingRecordChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.retCode = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.changer = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.changedId = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerTrainingRecordChangedEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(TRAININGRECORDCHANGED_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerTrainingRecordChangedEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(TRAININGRECORDCHANGED_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<BaseInfoChangedEventResponse> getBaseInfoChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(BASEINFOCHANGED_EVENT, transactionReceipt);
        ArrayList<BaseInfoChangedEventResponse> responses = new ArrayList<BaseInfoChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BaseInfoChangedEventResponse typedResponse = new BaseInfoChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.retCode = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.info = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.val = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.changer = (String) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerBaseInfoChangedEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(BASEINFOCHANGED_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerBaseInfoChangedEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(BASEINFOCHANGED_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static Id load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Id(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Id load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Id(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Id load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Id(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Id load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Id(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Id> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String ownerValue, String nameValue, String sidValue, BigInteger birthDateValue, Boolean genderValue) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(ownerValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(nameValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(sidValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(birthDateValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Bool(genderValue)));
        return deployRemoteCall(Id.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Id> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String ownerValue, String nameValue, String sidValue, BigInteger birthDateValue, Boolean genderValue) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(ownerValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(nameValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(sidValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(birthDateValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Bool(genderValue)));
        return deployRemoteCall(Id.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Id> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String ownerValue, String nameValue, String sidValue, BigInteger birthDateValue, Boolean genderValue) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(ownerValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(nameValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(sidValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(birthDateValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Bool(genderValue)));
        return deployRemoteCall(Id.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Id> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String ownerValue, String nameValue, String sidValue, BigInteger birthDateValue, Boolean genderValue) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(ownerValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(nameValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(sidValue), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(birthDateValue), 
                new org.fisco.bcos.web3j.abi.datatypes.Bool(genderValue)));
        return deployRemoteCall(Id.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class TrainingRecordChangedEventResponse {
        public Log log;

        public BigInteger retCode;

        public String changer;

        public BigInteger timestamp;

        public BigInteger changedId;
    }

    public static class BaseInfoChangedEventResponse {
        public Log log;

        public BigInteger retCode;

        public String info;

        public String val;

        public String changer;
    }
}
