# Write your MySQL query statement below
select E1.name , B1.bonus from Employee E1 left join Bonus B1 on E1.empId = B1.empId where B1.bonus <1000 or bonus is null ;