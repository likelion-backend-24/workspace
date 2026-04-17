show tables;

select * from jobs;

select * from emp;

desc emp;

select empno, ename, job from emp;

desc dept;

select deptno, dname, loc from dept;
select dname from dept;

select * from emp;
select * from dept;

select version() ;
select current_date;
select 3+3; select version();
select 
deptno, dname
from 
dept;

desc emp;

select * from emp;
select distinct job from emp;
select ename, sal * 18 "연 봉" from emp;

select * from emp 
where sal > 2000;
select * from emp where job='MANAGER';
desc employees;
select * from emp where job='MANAGER' order by sal desc;
show tables;
SELECT CONCAT(employee_id,'사원의 이름은 ',first_name, ' ', last_name,' 입니다.') AS full_name
FROM employees;

