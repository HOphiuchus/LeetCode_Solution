# Write your MySQL query statement below

# 1 without using sum
select A.Request_at Day, round(B.Status/A.Status,2) "Cancellation Rate" 
from 
    (select count(Status) Status, Request_at from Trips,Users 
            where Client_Id=Users.Users_Id and Users.Banned='No'  group by Request_at
     ) A,
        
    (select B2.Request_at Request_at, ifnull(Status,0)  Status
            from
                (select count(Status) Status, Request_at from Trips,Users
                    where Status!='completed'  and Client_Id=Users.Users_Id and Users.Banned='No' group by Request_at) B1
            right join
                (select distinct Request_at from Trips) B2
            on B2.Request_at = B1.Request_at
    ) B
where A.Request_at=B.Request_at and date(A.Request_at) between date("2013-10-01") and date("2013-10-03") 


# 2 (Recommend)
SELECT Request_at Day, ROUND(SUM(IF(Status='completed', 0, 1))/COUNT(*),2) "Cancellation Rate"
FROM Trips A 
JOIN Users B 
ON A.Client_Id = B.Users_Id and B.Banned = 'No' AND Request_at BETWEEN '2013-10-01' AND '2013-10-03' GROUP BY A.Request_at;


