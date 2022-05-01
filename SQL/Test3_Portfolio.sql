#Alexsandria Ryan
#Submitted: March 23, 2022
#Grade Received: 85% (Missed a couple 'NOT NULL' statements)

CREATE OR REPLACE DATABASE ryanAlexTC_3;

USE ryanAlexTC_3;

CREATE OR REPLACE TABLE Employee(
    Employee_ID int PRIMARY KEY AUTO_INCREMENT,
    First_Name  varchar(50) NOT NULL,
    Last_Name   varchar(50) NOT NULL,
    Email_Address varchar(100) UNIQUE NOT NULL,
    Hire_Date datetime
);

CREATE OR REPLACE TABLE Employee_Project(
    Employee_Project_ID int PRIMARY KEY AUTO_INCREMENT,
    Project_ID int,
    Employee_ID int,
    Project_Lead bit
);

CREATE OR REPLACE TABLE Project(
    Project_ID int PRIMARY KEY AUTO_INCREMENT,
    Project_Name varchar(50) UNIQUE NOT NULL,
    Start_Date datetime NOT NULL,
    End_Date datetime NOT NULL,
    Budget decimal CHECK (Budget >= 0 AND Budget <= 59999.99),
    Category_ID int
);

CREATE OR REPLACE TABLE Project_Category(
    Category_ID int PRIMARY KEY AUTO_INCREMENT,
    Category_Name varchar(50) NOT NULL
);

ALTER TABLE Employee_Project
    ADD CONSTRAINT FK_Project_ID
    FOREIGN KEY (Project_ID) REFERENCES Project(Project_ID);

ALTER TABLE Employee_Project
    ADD CONSTRAINT FK_Employee_ID
    FOREIGN KEY (Employee_ID) REFERENCES Employee(Employee_ID);

ALTER TABLE Project
    ADD CONSTRAINT FK_Category_ID
    FOREIGN KEY (Category_ID) REFERENCES Project_Category(Category_ID);