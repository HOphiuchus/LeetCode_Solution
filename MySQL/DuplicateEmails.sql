# Write your MySQL query statement below


# 1 
select Email from Person group by Email having count(*) > 1

# 2 
SELECT DISTINCT A.Email FROM Person A
LEFT JOIN (SELECT Id, Email from Person GROUP BY Email) B
ON (A.email = B.email) AND (A.Id = B.Id)
WHERE B.Email IS NULL

# 3 
SELECT DISTINCT A.Email
FROM Person A
WHERE EXISTS(
    SELECT null
    FROM Person B
    WHERE A.Email = B.Email
    LIMIT 1, 1
)