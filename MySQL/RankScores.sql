# Write your MySQL query statement below
# 1
select B.Score Score, B.Rank Rank 
from Scores A, 
	(select @Rank:=@Rank+1 Rank, Score from (select distinct Score from Scores order by Score Desc ) X , (select @Rank:=0) Y ) B 
where A.Score = B.Score 
order by Rank


# 2 
SELECT
  Score,
  @rank := @rank + (@prev <> (@prev := Score)) Rank
FROM
  Scores,
  (SELECT @rank := 0, @prev := -1) X
ORDER BY Score desc


# 3
SELECT A.Score, count(distinct B.score) Rank
FROM Scores A JOIN Scores B ON A.Score <= B.score
GROUP BY A.Id
ORDER BY A.Score desc

# 4 
SELECT  Score,
	(SELECT count(*) FROM (SELECT distinct Score FROM Scores) X WHERE X.Score >= A.Score) Rank
FROM Scores A
ORDER BY Score desc