 SELECT sal
    FROM emp
    WHERE ename = 'SCOTT';
    
SELECT ename
FROM emp
WHERE sal > 3000.00;

SELECT ename
FROM emp
WHERE sal > (
    SELECT sal
    FROM emp
    WHERE ename = 'SCOTT'
);

-- scott 와 같은 부서에 근무하는 사원의 이름, 부서번호, 급여를 출력하세요. 

SELECT ename, deptno, sal
FROM emp
WHERE deptno > (
    SELECT deptno
    FROM emp
    WHERE ename = 'SCOTT'
);

select avg(sal) from emp;
select ename, sal 
from emp 
where sal < (select avg(sal) from emp);

SELECT MIN(hiredate)
    FROM emp;
    
    SELECT ename, hiredate
FROM emp
WHERE hiredate = (
    SELECT MIN(hiredate)
    FROM emp
);


 SELECT deptno
    FROM dept
    WHERE loc IN ('NEW YORK', 'DALLAS');
    
select deptno, avg(sal) from emp 
group by deptno;

-- in  = or의 결합!!!  
select * from emp 
where deptno in (10,20);
select * from emp
where deptno = 10 or deptno = 20;

-- in 은 =  만 가능!!!    > < >= <=  이런 연산은 in으로는 불가능!!!  

-- any  (or결합) , all  (and 결합)     > any,   < any,  = any,  <= any  

select * from emp 
where sal  >any (950, 2000, 3000);   

select * from emp 
where sal > 950 or sal > 3000 or sal > 2000;

SELECT ename, sal
FROM emp
WHERE sal > ANY (
   100,300,400
);

SELECT ename, sal
FROM emp
WHERE sal > ALL (
    SELECT sal
    FROM emp
    WHERE deptno = 30
);

select * from emp 
where sal > 950 and sal > 3000 and sal > 2000;

SELECT sal
    FROM emp
    WHERE deptno = 30;
    
SELECT ename, sal
FROM emp
WHERE sal > ANY (
    SELECT sal
    FROM emp
    WHERE deptno = 30
);

SELECT ename, sal
FROM emp
WHERE sal > 1600 or sal > 1250 or sal > 2850 or sal > 1500 or sal > 950; 



SELECT ename, sal
FROM emp
WHERE sal = ANY (
    SELECT sal
    FROM emp
    WHERE deptno = 30
);

SELECT ename, sal
FROM emp
WHERE sal in (
    SELECT sal
    FROM emp
    WHERE deptno = 30
);


select * from emp ;

select * from emp 
where sal > 2000;

SELECT AVG(i.sal)
    FROM emp i
    WHERE i.deptno = 20;
    
    
SELECT o.ename, o.sal, o.deptno
FROM emp o
WHERE o.sal > (
    SELECT AVG(i.sal)
    FROM emp i
    WHERE i.deptno = o.deptno
);

-- 각 부서별 최고 급여를 받는 사원의 부서번호, 사원번호, 이름, 급여를 출력하세요. 

select deptno, empno, ename, sal 
from emp e
where sal = (select max(sal) from emp where deptno = e.deptno);


select deptno, empno, ename, sal 
from emp 
where (deptno, sal) in (select deptno, max(sal) from emp group by deptno);


select deptno, max(sal) from emp group by deptno;


select e.deptno,e.empno, e.ename, e.sal 
from emp e, (select deptno, max(sal) msal from emp group by deptno) m 
where e.deptno = m.deptno and e.sal = m.msal;


select 1 from emp where sal > 3000;

create table a (name int); -- 테이블 생성  테이블이름은 a  컬럼은 int 타입으로  name 으로 
desc a;  -- a 테이블의 구조보여주세요.
insert into a values (1); -- a 테이블에 데이터 1 를 입력해주세요.
select * from a;
insert into a values(2); -- a 테이블에 데이터 2 를 입력해주세요.
delete from a where name = 1;  -- name의 값이 1인 데이터를 삭제해주세요. 
set sql_safe_updates = 0;  -- mysql dbms 가 안전모드를 가지고 있는데, 기본적으로 워크벤치 설정에서 1 로 설정을 켜둠. 
drop table a; -- 테이블 삭제
show tables;

CREATE TABLE A (name INT);
CREATE TABLE B (name INT);

INSERT INTO A VALUES (1), (2), (3);
INSERT INTO B VALUES (2), (3), (4);

select name from a
union all
select name from b;

SELECT DISTINCT A.name 
FROM A 
INNER JOIN B ON A.name = B.name;

SELECT name FROM A
WHERE name NOT IN (
    SELECT name FROM B
);

SELECT 
    sal,
    ename,
    RANK() OVER(ORDER BY sal DESC) AS ranking
FROM emp;

SELECT 
    deptno,
    ename,
    sal,
    RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) AS dept_rank
FROM emp;

SELECT 
    sal,
    ename,
    DENSE_RANK() OVER(ORDER BY sal DESC) AS dense_ranking
FROM emp;

SELECT 
    ROW_NUMBER() OVER(ORDER BY sal DESC) AS row_num,
    ename,
    sal
FROM emp;

select * from emp 
where empno = 8000;

SHOW INDEX FROM employees;
