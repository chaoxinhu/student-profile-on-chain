pragma solidity ^0.4.25;

import "./Diploma.sol";

/**
 * @title Diploma Factory
 */

contract DiplomaFactory {
    event CreateLog(address addr, uint256 timestamp);
    
    function createBasicDiploma(
        address ownerValue,
        uint256 timestampValue,
        uint256 typeValue,
        string nameValue,
        string sidValue,
        uint256 startDateValue,
        uint256 endDateValue,
        string departmentValue,
        string majorValue
    ) public {
        Diploma diploma = new Diploma(ownerValue, timestampValue, typeValue,
            nameValue, sidValue, startDateValue, endDateValue);
        diploma.setDiplomaData(departmentValue, majorValue);
        emit CreateLog(diploma, timestampValue);
    }
}