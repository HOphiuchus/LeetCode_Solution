# Write your MySQL query statement below
select Name Customers from Customers where not exists (select null from Orders where Orders.CustomerId=Customers.Id)