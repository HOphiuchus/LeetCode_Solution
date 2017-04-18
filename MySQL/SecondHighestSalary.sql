# Write your MySQL query statement below
# 1
SELECT (
        SELECT 
                distinct Salary as SecondHighestSalary 
        FROM Employee
        order by Salary desc limit 1,1)


# 2
SELECT max(Salary)
FROM Employee
WHERE Salary < (SELECT max(Salary)
                FROM Employee);
                
                