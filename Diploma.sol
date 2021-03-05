pragma solidity ^0.4.25;

/**
 * @title Student ID
 * Student ID on chain, including all schooling record history.
 */

contract Diploma {
    address private owner;
    address private issuer;

    uint256 private timestamp;
    uint256 private trtype;
    string private name;
    string private sid;
    string private department;
    string private major;
    uint256 private startDate;
    uint256 private endDate;
    
    bool private revoked;
    
    constructor (
        address ownerValue,
        uint256 timestampValue,
        uint256 typeValue,
        string nameValue,
        string sidValue,
        uint256 startDateValue,
        uint256 endDateValue
    ) public {
        issuer = tx.origin;
        owner = ownerValue;
        timestamp = timestampValue;
        trtype = typeValue;
        name = nameValue;
        sid = sidValue;
        startDate = startDateValue;
        endDate = endDateValue;
        revoked = false;
    }
    
    function setDiplomaData(
        string departmentValue,
        string majorValue
    ) public {
        if (tx.origin != issuer) {
            return;
        }
        department = departmentValue;
        major = majorValue;
    }
    
    function setRevoked(bool status) public {
        if (msg.sender != issuer) {
            return;
        }
        revoked = status;
    }
    
    function getAllInfo() public view returns (address, address, uint256, uint256, string, string, string, string, uint256, uint256, bool) {
        return (owner, issuer, timestamp, trtype, name, sid, department, major, startDate, endDate, revoked);
    }
}
         
                        