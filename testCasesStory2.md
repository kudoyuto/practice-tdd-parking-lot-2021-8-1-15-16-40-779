#Test Cases Story 2
[X] Case 1
    Given a parking lot and unrecognized ticket   
    When fetch the car   
    Then return nothing with error message "Unrecognized parking ticket"   
[X] Case 2
    Given a parking lot and used ticket   
    When fetch the car   
    Then return nothing and give error message "Unrecognized parking ticket"   
[] Case 3
    Given a parking without any position and car
    When park the car   
    Then return nothing with error message "No available position"