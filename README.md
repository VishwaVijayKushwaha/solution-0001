# Streps to build and run the application.

1. Use following command to build the application.
mvn clean install
(note: java 8 and maven is reuired)

2. To run the application.
 2.1 goto target folder
 2.2 run following command
   java -jar solution.jar



## Question....
In Java, you will be building a simple application that requires input information from a Rest API posted in googlesheets. The submission should include the source code, contain instructions for running the application, and be clear and easy to understand.

	1.	Total number of fruit
	2.	Total types of fruit
	3.	The number of each type of fruit in descending order
	4.	The characteristics (size, color, shape, etc.) of each fruit by type
	5.	Have any fruit been in the basket for over 3 days

The executable program should fetch the details using Rest APIs from the following location https://sheets.googleapis.com/v4/spreadsheets/1lpiyYeEEv91_pphMkmgO48gkTix2a4NcSQ2kzzVR7w8/values/test!A1:D23?key=AIzaSyC_DzMrJ8GhRamRnuBjAGpakryrw_HoOdw

For example:  solution.java 

Total number of fruit: 123
Types of fruit: 7
The number of each type of fruit in descending order
apple: 33
pear: 23
orange: 22
grapefruit: 21
pineapple: 15
watermelon: 7
peach: 2
The characteristics (size, color, shape, etc.) of each fruit by type
4 apples: sweet, red
5 oranges: round, sweet
10 grapefruits: bitter, yellow
3 pineapple: prickly, sweet
Have any fruit been in the basket for over 3 days
4 oranges and 5 pineapples are over 3 days old


##Solution Screen
![alt text](https://github.com/VishwaVijayKushwaha/solution-0001/raw/master/screen.jpg)
