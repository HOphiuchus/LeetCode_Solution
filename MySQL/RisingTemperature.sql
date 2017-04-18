# Write your MySQL query statement below
# 1 data_sub or subdate
select A.Id from Weather A, Weather B where  A.Temperature>B.Temperature and date_sub(A.Date,interval 1 DAY)=date(B.Date)

# 2 using datadiff 
select A.Id from Weather A, Weather B where  A.Temperature>B.Temperature and datediff(A.Date,B.Date)=1