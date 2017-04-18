# Without using variable
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.

    select max(salary) from Employee where case when n<=(select count(distinct salary) from Employee) then salary = (select min(salary) from     (select salary from Employee  group by salary order by salary desc limit N) as X) else false end
  
  );
END

# with additional rowid

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
RETURN (
SELECT Salary FROM (
    SELECT Salary, @r:=@r+1 as r FROM (
        SELECT Salary FROM Employee GROUP BY Salary ORDER BY Salary DESC
    ) AS A, (SELECT @r:=0) AS B
) AS C WHERE r=N
);
END
# change N 

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N=N-1;
  RETURN (
    # Write your MySQL query statement below.
    SELECT IFNULL((SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT N ,1), NULL)
  );
END