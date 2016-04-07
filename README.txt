ReadMe
------
This is a really interesting assignment which has given me the opportunity to work on diverse and upto date tools and technologies.
The solution is implemented in Java 1.8 with Maven 3.3 as build tool.
I used Mars version of Eclipse IDE since it provides JDK 8 Runtime environment support and in-built integration with Maven, Git and ability to create Web Applications easily.

This week being a Production Deployment Release cycle in my current project, I wasn't able to complete this Ticketing Service Assignment. I was however able to model key components and bring up a working simulation of a Ticketing Service run on CLI.

The project is named TicketServiceProject. 
I used the maven archetype quickstart to form my project structure.
Once downloaded, please run the maven commands only after you are inside the project directory.
Eg: "C:\eclipse-jee-mars-2-win32-x86_64\eclipse\workspace\TicketHomework\TicketServiceProject" would be my project working folder where I run the following maven commands.


1) mvn clean install

2) mvn exec:java
This is going to execute the java Main() and begin the prompt which asks the user to input values, sort of auto start.
(I have included the Main executor class in pom.xml, which kicks off the program)


Assumptions
-----------
MinLevel has a greater preference than MaxLevel. What I mean is, minLevel of 2 and maxLevel of 3 suggests Seats would be booked starting from MainLevel going upto and including Balcony 1 Level.
Also, both these values are optional. User may:
- enter neither minLevel nor maxLevel
- enter only minLevel
- enter both minLevel and maxLevel

For example, Orchestra level has 1250 seats available.
If the user specifies (2000, 1, name@email.com), 2000 seats would be held starting from Orchestra Level until the seats are filled.
1250 at Orchestra level would be filled, then 750 at the next level which is Main.

Ticket Hold would fail when 
 - Seats are all full
 - User requests for seats at a specific level exceed the number of seats available at that level
 - Validation check failure (Yes, right now the system is designed for a ticket booking agent assuming all inputs are valid)

Ticket Reservation would fail when 
- The seatID mentioned doesn't exist
- User doesnt have any seats held.
- Ofcourse, validation checks such as inputing an alphabet incase of number :-)


Future Work
-----------
Due to time crunch, I wasn't able to accomplish 100% as given in the problem statement.
Below are the tasks I would have worked or wanted to incorporate in my project.

- JUnit Testing: Whole lot is pending :-) I wanted to write unit test cases for all my methods and possible user input scenarios.
- Holding a ticket for specified time. Right now, the solution implemented puts a ticket on HOLD until it gets reserved.
I thought of including Threading feature to include timeout and release of Held seats. Have the SeatHold class behave as a thread.
The seatHold object would wait with the timeout argument inside its run() method. Next would be to release the seatHold object after the timeout expires.
A reservation thread would notify on this seatHold thread and convert the seats into "Reserved" status; else after the timeout, would become Available.
- A front-end UI. Convert the existing jar file to war file; build a simple front end with html/css and some js for validation. Use Angular and Ajax so that response is fast.
- Rest webservice to wire my front-end with java code
- Put my application on cloud, AWS or google cloud so that everyone may have easy access with a URL.
- Refactor code with Code Coverage and plugins like FindBugs to ensure code quality
- ReStructure my code with proper package and modularize my MainClass.

Really appreciate if you could let me know your feedback on how to improve my code.
Thanks for reading.

