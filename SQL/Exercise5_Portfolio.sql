#Alexsandria Ryan
#Submitted: March 31, 2022
#Grade Received: 100%

CREATE OR REPLACE DATABASE Countries_DDL;

USE Countries_DDL;

CREATE or REPLACE TABLE Country (
    Country_Number int PRIMARY KEY,
    Country_Name varchar (100) UNIQUE NOT NULL,
    Population int NOT NULL,
    Total_Land_Area int NOT NULL
);

INSERT INTO Country (Country_Number, Country_Name, Population, Total_Land_Area)
    VALUES (1, 'Greenland', 56968, 836109),
           (2, 'Japan', 126475664, 145882),
           (3, 'Lebanon', 4143101, 4015),
           (4, 'Mexico', 113724226, 761602),
           (5, 'Thailand',66720153,198455);

UPDATE Country
    SET Country_Name = 'Canada'
    WHERE Country_Name = 'Lebanon';

UPDATE Country
    Set Population = 34030589, Total_Land_Area = 3855081
    WHERE Country_Number = 3;

DELETE FROM Country
    WHERE Country_Number = 1;