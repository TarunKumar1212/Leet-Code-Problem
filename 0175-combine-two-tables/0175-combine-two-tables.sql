# Write your MySQL query statement below

select p.firstName, p.lastName, A.city , A.state from Person p
Left Join Address A 
On p.personId = A.personId;
