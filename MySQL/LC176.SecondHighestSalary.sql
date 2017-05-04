# Write your MySQL query statement below
# 1
SELECT (
        SELECT 
          DISTINCT Salary
        FROM Employee
        ORDER BY Salary DES LIMIT 1,1
        ) AS SecondHighestSalary

# 2
SELECT max(Salary)
FROM Employee
WHERE Salary < (
                  SELECT
                    max(Salary)
                  FROM Employee
                );
                
                