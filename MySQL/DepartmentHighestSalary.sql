# Write your MySQL query statement below
select B.Name, A.Name Department, A.Salary 
from Employee A, (select Department.Name, DepartmentId, max(Salary) Salary from Employee, Department where DepartmentId=Department.Id group by DepartmentId) B
where A.Salary=B.Salary and A.DepartmentId = B.DepartmentId