#Alexsandria Ryan
#Submitted: April 1, 2022
#Grade Received: 100%

USE sakila;

#1. Create a query that returns the email address for customer
# Alfred Casillas (1 record)
SELECT email
FROM customer
WHERE (first_name = 'Alfred' AND last_name = 'Casillas');


#2. Create a query that returns a list of all film categories, sorted in reverse alphabetical order. (16 records)


#3. Create a query that returns all movies that are about a lumberjack.  (72 records)
SELECT title
FROM film
WHERE description LIKE '%lumberjack%';

#4. Create a query that returns customers who shop at store #2.  (273 records)


#5. Create a query that returns a list of the names and ratings for all films rated R or
# NC-17, sorted by rating (NC-17 first, then R), then by film name in alphabetical order. (405 records)


#6. Create a query that returns only a list of city names, for
# all Canadian cities.  (7 records)
SELECT city
FROM city
WHERE country_id = 20;


#7. Create a query that returns any language with name ending in 'n'.  (3 records)
SELECT name
FROM language
WHERE name LIKE '%n';

#8. Create a query that returns any film name that begins with B, F or G   (155 records)


#9. Create a query that returns the 5 highest payment amounts.


#10. Create a query that returns the title and length of the 3 shortest movies in the db. Rename
# the title column as Shorts and the time column as Minutes.


#11. Create a query that returns all actors with a first name of Tom or a last name of Cruise.
#Display only the name fields, renamed as First and Last. (3 records)
SELECT first_name AS First, last_name AS Last
FROM actor
WHERE first_name = 'Tom' OR last_name = 'Cruise'


#12. Create a query to return a list containing the addresses, districts and postal codes for all
# addresses in the district of Buenos Aires, sorted by street number and postal code. (10 records)


#13. Create a query that displays a list of all unique district names from the address
# table, sorted alphabetically. (378 records)


#14. Create a query that returns all payment records made by customer 25 with an
# amount less than $8 but higher than $5. Sort from highest to lowest. (4 records)


#15. Create a query that returns addresses that do not have ANY value for the second
# address field.  (4 records)


#16. Create a query that returns a list of all cities from the country of Chile. Do NOT
# use any hard-coded country IDs!


#17. Create a query that returns a list of all actor records whose first name does NOT
# start with a vowel. Sort by first, then last name and rename the first name field
# as "Vowel-less Firsts".   (176 records)
