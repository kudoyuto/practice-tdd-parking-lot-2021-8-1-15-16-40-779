#Story 1
[] Case1  
    Given a parking lot, and a car  
    When park the car  
    Then return a parking ticket.
[] Case2  
    Given a parking ticket
    When customer wants fetch a car
    Then return corresponding car with the right ticket
[] Case3  
    Given a wrong ticket or no ticket
    When customer wants fetch a car
    Then return no car should be fetched
[] Case4
    Given a wrong ticket
    When customer wants fetch a car
    Then return no car should be fetched