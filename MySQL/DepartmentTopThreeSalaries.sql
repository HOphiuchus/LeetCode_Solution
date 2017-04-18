# Write your MySQL query statement below
select  Department.Name, F.Name, F.Salary 
from Employee F, 
    (select C.DepartmentId, ifnull(max(D.Salary), C.Salary)  Salary from Employee D
     right join
        (select A.DepartmentId, ifnull(max(B.Salary), A.Salary)  Salary from Employee B
            right join
            (select DepartmentId,max(Salary) Salary from Employee  group by DepartmentId)  A 
            on B.Salary<A.Salary and  A.DepartmentId = B.DepartmentId  group by A.DepartmentId ) C
    on  D.Salary<C.Salary and  C.DepartmentId = D.DepartmentId  group by C.DepartmentId) E,
    Department
where F.Salary >= E.Salary and F.DepartmentId=E.DepartmentId and F.DepartmentId = Department.Id