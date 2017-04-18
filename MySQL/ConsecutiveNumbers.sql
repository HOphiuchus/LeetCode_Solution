# Write your MySQL query statement below

# 1
select distinct Num 
from 
	(select 
		if(@prev=(@prev:=Num), @count:=@count+1, @count:=1) Count, 
		if(@count=3, Num, null)  Num
	from Logs, (select @prev:='',@count:=0) X) A 
where Num is not null 

# 2
select distinct X.num  from 
    (select num,
        case when @last = num then @count:=@count+1
            when @last<>@last:=num then @count:=1
            end as count
        from Logs
    ) X ,(select @count:=0,@last:=(select num from Logs limit 0,1)) Y
where X.count>=3


# 3 
select distinct(a.Num) from Logs a, Logs b,Logs c 
where a.Id=b.Id+1 and a.Num=b.Num and b.Id=c.Id+1 and b.Num=c.Num