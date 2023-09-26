
*** Test Cases ***
# will match Zephyr Scale test case named Calculator.User can clear the display
User can clear the display
    Input number    10
    Press operator    +
    Input number    1
    Press clear 
    Display should be empty

*** Test Cases ***
# will match Zephyr Scale test case with key VIC-T14
VIC-T9 User can calculate with wrong result 
    Input number    1
    Press operator    +
    Input number    1
    Press enter 
    Result should be     3

*** Test Cases ***
# will match Zephyr Scale test case with key VIC-T9
User can calculate two numbers - VIC-T9
    [Template]    Calculate two numbers should pass
    10    +    5    15
    10    -    5    5
    10    /    5    2
    10    *    5    50


*** Keywords ***
Calculate two numbers should pass
    [Arguments]    ${number1}    ${operator}    ${number2}    ${result}
    Input number    ${number1}
    Press operator    ${operator}
    Input number    ${number2}
    Press enter
    Result should be    ${result}

Press enter
    Calculate

Press clear
    Clear 

Clear Calculator
    Clear


*** Settings ***
Library           app/Calculator.py


*** Settings ***
Suite Setup       Clear Calculator
Test Teardown     Clear Calculator

