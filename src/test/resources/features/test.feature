##
Scenario: Simple product search
Given the shoe store home page is displayed
When the search phrase "red pumps" is entered
Then results for "red pumps" are shown
When the user searches for images from the results page
Then image results for "red pumps" are shown

Scenario: Simple Web search
Given the shoe store home page is displayed
When the search phrase "red pumps" is entered
Then results for "red pumps" are shown

Scenario: Simple Web image search
Given shoe store search results for "red pumps" are displayed
When the user searches for images from the results page
Then image results for "red pumps" are shown

##uniaueness
Scenario Outline: Simple product search
Given the shoe store home page is displayed
When the search phrase "<phrase>" is entered
Then results for "<phrase>" are shown

Examples: Shoes
| phrase        |
| red pumps     |
| sneakers      |
| sandals       |
| flip flops    |
| flats         |
| slippers      |
| running shoes |




