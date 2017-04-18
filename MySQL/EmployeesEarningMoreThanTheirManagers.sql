# Write your MySQL query statement below
select A.Name as Employee from Employee as A, Employee as B where A.Salary > B.Salary and A.ManagerId=B.Id