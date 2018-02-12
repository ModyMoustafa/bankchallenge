# Lendico Rate Calculation system

## Problem Statement
TIn order to to inform borrowers about the final repayment schedule, we need to have
pre-calculated repayment plans throughout the life time of a loan.
To be able to calculate a repayment plan specific input parameters are necessary:
• duration (number of instalments in months)
• nominal interest rate
• total loan amount ("total principal amount")
• Date of Disbursement/Payout

These four parameters need to be input parameters.
The goal is to calculate a repayment plan for an annuity loan. Therefor the amount
that the borrower has to payback every month, consisting principal and interest
repayments, does not change (the last instalment might be an exception).
The annuity amount has to be derived from three of the input parameters (duration,
nominal interest rate, total loan amount) before starting the plan calculation.
(use http://financeformulas.net/Annuity_Payment_Formula.html as reference)


## Solution
The technical intention is to build a loosely coupled system using Spring.


## Getting Started
See deployment for notes on how to deploy the project on a live system.

## Prerequisites
You need to install the following tools

* [Java 1.8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) - Lambda and Annotation were used in the code
* [Maven](https://maven.apache.org/) - Dependency Management

## Building the code:
* Clone from git or unzip the supplied zip file
* Navigate to the root of application

```
mvn clean install
```

## Running the App

* We can export runnable jar from the application
```
Navigate to the root path, run the following commands:

* mvn assembly:assembly
```

* Navigate to targe dir from root application, you will find the Executable Jar "loanquotecalculation-1.0-SNAPSHOT-jar-with-dependencies.jar" , run the following command:
```
java -jar loanquotecalculation-1.0-SNAPSHOT-jar-with-dependencies.jar  5000 5 24 01/01/2018
```
## Running the tests
```
mvn test
```

## Test driven development (TDD) using jUnit
