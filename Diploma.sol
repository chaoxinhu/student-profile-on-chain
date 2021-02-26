pragma solidity ^0.4.25;

/**
 * @title Student ID
 * Student ID on chain, including all schooling record history.
 */

contract Diploma {
    address private owner;
    address private issuer;

    uint256 private timestamp;
    uint256 private type;
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
    ) {
        issuer = tx.origin;
        owner = ownerValue;
        timestamp = timestampValue;
        type = typeValue;
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
        if (msg.sender != issuer) {
            return;
        }
        department = departmentValue;
        major = majorValue;
    }
    
    function setRevoked(bool status) {
        if (msg.sender != issuer) {
            return;
        }
        revoked = status;
    }
}
         
                        