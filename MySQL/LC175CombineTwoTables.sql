# Write your MySQL query statement below

# 1
SELECT
  FirstName,
  LastName,
  City,
  State
FROM Person
  LEFT JOIN Address ON Person.PersonId = Address.PersonId;

# 2
SELECT
  FirstName,
  LastName,
  City,
  State
FROM Person
  NATURAL LEFT JOIN
  Address