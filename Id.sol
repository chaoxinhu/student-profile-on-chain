pragma solidity ^0.4.25;

/**
 * @title Student ID
 * 链上学生证.
 */

contract Id {
    // 学生证持有人（地址）
    address private owner;

    // 学生基本信息（日期以八位数字整形表示）
    string private name;
    string private sid;
    uint256 private birthDate;
    bool private gender;

    // 修改记录相关
    event TrainingRecordChanged(uint256 retCode, address changer, uint256 timestamp, uint256 changedId);
    event BaseInfoChanged(uint256 retCode, string info, string val, address changer);
    
    // 错误码
    uint256 private RET_SUCCESS = 0;
    uint256 private RET_ALREADY_EXISTED = 1001;
    uint256 private RET_NOT_EXIST = 1002;
    uint256 private RET_NO_PERMISSION = 1003;
    
    // 学历记录
    struct TrainingRecord {
        // 颁发机构
        address issuer;
        // 学历证明类型
        uint256 type;
        uint256 startDate;
        uint256 endDate;
        address diplomaAddress;
        // 本次修改时间
        uint256 timestamp;
    }
    TrainingRecord[] private trs;

    constructor (
        address ownerValue,
        string nameValue,
        string sidValue,
        uint256 birthDateValue,
        bool genderValue
    ) public {
        // 允许任何人为别人创建ID，但是创建好了以后的修改只能由本人进行
        owner = ownerValue;
        name = nameValue;
        sid = sidValue;
        birthDate = birthDateValue;
        gender = genderValue;
    }
    
    function getBaseInfo() public view returns (
        address ownerValue,
        string nameValue,
        string sidValue,
        uint256 birthDateValue,
        bool genderValue
    ) {
        return (owner, name, sid, birthDate, gender);
    }
    
    function setName(string nameValue) public {
        // 修改姓名必须由本人进行
        // this is a sample which you can enroll other attribute modification
        if (msg.sender != owner) {
            emit BaseInfoChanged(RET_NO_PERMISSION, "name", nameValue, msg.sender);
        }
        name = nameValue;
        emit BaseInfoChanged(RET_SUCCESS, "name", nameValue, msg.sender);
    }
    
    function addTrainingRecord(
        uint256 timestamp,
        uint256 type,
        uint256 startDate,
        uint256 endDate,
        address diplomaAddress
    ) public {
        address issuer = msg.sender;
        uint dataLength = tr.length;
        for (uint index = 0; index < dataLength; index++) {
            TrainingRecord tr = trs[index];
            if (msg.sender == tr.issuer && type == tr.type) {
                // 已有相关记录，不加返回直接抛出
                emit TrainingRecordChanged(RET_ALREADY_EXISTED, issuer, timestamp, index);
                return;
            }
        }
        // 未找到已有学历，则增添一个
        TrainingRecord _tr = TrainingRecord(issuer, type, startDate, endDate, diplomaAddress, timestamp);
        trs.push(_tr);
        emit TrainingRecordChanged(RET_SUCCESS, issuer, timestamp, dataLength + 1);
    }
    
    function modifyTrainingRecord(
        uint256 timestamp,
        uint256 type,
        uint256 startDate,
        uint256 endDate,
        address diplomaAddress
    ) public {
        address issuer = msg.sender;
        uint dataLength = tr.length;
        for (uint index = 0; index < dataLength; index++) {
            TrainingRecord tr = trs[index];
            if (msg.sender == tr.issuer && type == tr.type) {
                // 已有相关记录，进行修改即可
                tr.startDate = startDate;
                tr.endDate = endDate;
                tr.diplomaAddress = diplomaAddress;
                tr.timestamp = timestamp;
                emit TrainingRecordChanged(RET_SUCCESS, issuer, timestamp, index);
                return;
            }
        }
        // 未找到已有学历，则返回错误不存在
        emit TrainingRecordChanged(RET_NOT_EXIST, issuer, timestamp, 0);
    }
}