# story 4
[x] Case1  
    Given a standard parking boy, manage two parking lots, both with available position and a car    
    When park the car   
    Then return car to the first parking lot  
[x] Case2  
    Given a standard parking boy, manage two parking lots, first parking slots are full and second with available positions and a car       
    When park the car       
    Then return car to the second parking lot   
[x] Case3  
    Given a standard parking boy, manage two parking lots, both with  parked car, and two parking ticket,     
    When fetch  car twice    
    Then return right car with corresponding ticket    
[x] Case4    
    Given a standard parking boy, manages two parking lots and  unrecognized ticket     
    When fetch car   
    Then return nothing with error message "Unrecognized parking ticket”    
[x] Case5  
    Given a standard parking boy manages two parking lots and a used ticket,  
    When fetch car     
    Then return nothing with error message "Unrecognized parking ticket."   
[x] Case6  
    Given a standard parking boy, manages two parking lots, both no position and a car     
    When park car    
    Then return nothing with error message "No available position"   