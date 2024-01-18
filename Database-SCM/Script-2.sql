-- working in database postgres

create table employees
(
id serial primary key,
name varchar(30) not null,
email varchar(30) not null unique,
salary int not null,
age int not null check(age>12),
created_at timestamp default current_timestamp
);

-- 
--email has been changes to emailid in future



insert into employees (name,email,salary,age) values
('Jytoi','jyoti@outlook.com',90000,36),
('Sanjay','Sanjay@outlook.com',27000,41),
('Sarthhak','sarthak@hotmail.com',18000,19);



--altering the table 

-- adding a column
alter table employees 
add column city varchar(30) not null default 'Mumbai';

--changing type of column 
alter table employees 
alter column name type varchar(40);

-- renaming a column
alter table employees
rename column oldname to newname;

-- renaming a table
alter table tablename 
rename to newname;



-- describing a tablre with query

SELECT
    column_name,
    data_type
FROM
    information_schema.columns
WHERE
    table_name = 'employees';




--fetch ops 

-- to get all columns
select * from employees ;

-- to get custom columns
select name as firstname,email from employees ;

select (salary*10)/100 as sal10 from employees ;


select * from employees 
where salary  > 40000 or age < 30  ;

select * from employees 
where age between 20 and 30;


select * from employees 
where age not in (20,28,30);

select * from employees 
where name like '%a%';

--sort 

select * from employees
where age <= 30
order by salary;

--limiting records

select * from employees
order by salary desc
limit 3 offset 2;


--update ops 

update employees 
set email = 'jyoti8@outlook.com' , salary = 95000
where id = 5;

-- delete ops 

delete from employees
where id = 7;


--math function / aggregate

--avg,min,max,sum,count

select avg(salary) from employees ;
select max(salary) from employees ;
select min(salary) from employees ;
select sum(salary) from employees ;
select count(*) from employees ;

-- group by

select max(salary),age from employees 
group by age
having age = 24;


-- creating a custom index

create index employee_name_index
on employees (name);


drop index name_index;


select * from employees ;


select * from employees where name = 'Saurabh' ;








--docs 


--relational ops 

--= > < >= <=  !=  <>

-- logical op
--and or 

--query format 

-- select [*,columns] from tablename
-- where condtion [and,or,in,not in,like]
-- group by column
-- having condition
-- order by column
-- limit value
-- offset value










