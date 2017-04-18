# Write your MySQL query statement below

# 1
delete A from Person A, Person B where A.Id > B.Id and A.Email=B.Email


# 2 temp database
# If you declare an alias for a table, you must use the alias when referring to the table:
# DELETE t1 FROM test AS t1, test2 WHERE ...
delete A from Person A where not exists (select null from (select min(Id) Id from Person group by Email) B where A.Id=B.Id)