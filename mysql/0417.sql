desc emp;

desc employees;
select empno, ename, job from emp;

select distinct job as "직 업" from emp;
select * from emp;
select * from emp where deptno=10;
select * from emp where deptno = 20 order by sal;

select * from emp where deptno = 10 or deptno = 20;
select * from emp where deptno in (10,20);
select * from emp where deptno not in (10,20);

select * from emp where sal between 500 and 950;
select * from emp;

select * from emp where hiredate between '1981-01-01' and '1981-12-31';

select * from emp where ename = 'SMITH';
select * from emp where ename like 'SMITH%';
select * from emp where ename like 'SM%';
select * from emp where ename like 'SMITH_'; -- SMITH(?) 한글자가 반드시 있어야 찾는다. 
select * from emp where ename like '_____';
select * from emp where hiredate like '1981%';

select * from emp where mgr is not null;

select * from emp where comm is not null;

select empno, sal, comm,sal + ifnull(comm,0) from emp; 

select empno, ename, sal from emp order by sal, ename desc;

select empno, ename, sal from emp order by 3, 2 desc;
select empno, ename e, sal s from emp order by e, s desc;
select * from emp order by sal desc limit 3,3;
