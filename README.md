# assignment

This container will have all the class files required to run automation test cases on transavia.com/home website.

## Setup

This assignment uses Testng framework on selenium webdriver.

This project is a maven project with dependencies : selenium webdriver; log4j; testng

As part of additional testing with chromedriver and IEdriver seperate folder named"libraries" is used as reference, this can also be done with maven.

## Approach

Using pageObject methodology ("https://martinfowler.com/bliki/PageObject.html") each webpage is represented by a java class 

Test/java > BaseTest class represents 