/*1. Write a query to display the lastname, department number, and department name
 for all employees. */
select lastname,employees.department_id,department_name from employees LEFT JOIN departments ON employees.department_id=departments.department_id;
/*2. Create a unique listing of all jobs that are in department 30. Include the location id in
 the output. */
select distinct job_id,location_id from employees e JOIN departments d ON d.department_i
d=e.department_id where e.department_id=30;
/*3. Write a query to display the employee lastname, department name, location id, and
 city of all employees who earn a commission. */
 select lastname,department_name,l.location_id,city from employees e,departments d,locations l where commission_pct IS NOT NULL AND e.department_id=d.department_id AND d.location_id=l.location_id;
/*4. Display the employee lastname, and department name for all employees who have
 an "a" in their lastname. */
select lastname,department_name from employees e JOIN departments d ON e.department_id=d.department_id where lastname LIKE "%a";    
/*5. Write a query to display the lastname, job, department number, and department
 name for all employees who work in Toronto. */
select lastname,job_id,d.department_id,d.department_name from employees e,departments d where e.department_id=d.department_id and d.location_id=(select location_id from locations where city="Toronto");
/*6. Display the employee lastname and employee number along with their manager's
 lastname and manager number. Label the columns "Employee", "Emp#", "Manager"
 and "Manager#" respectively. */
select e1.lastname as "Employee",e1.employee_id as "Emp#",e2.lastname as "Manager",e2.employee_id as"Manager#" from employees e1 JOIN employees e2 ON  e1.manager_id=e2.employee_id;
/*7. Modify the above to display the same columns for all employees (including "King",
 who has no manager). Order the result by the employee number. */
select e1.lastname as "Employee",e1.employee_id as "Emp#",e2.lastname as "Manager",e2.employee_id as"Manager#" from employees e1 LEFT JOIN employees e2 ON  e1.manager_id=e2.employee_id ORDER BY e1.employee_id;
/*8. Create query that displays employee lastnames, department numbers, and all the
 employees who work in the same department as a given employee. Give each
column an appropriate label. */
select lastname,d.department_id,department_name from employees e JOIN departments d ON e.department_id=d.department_id order by e.department_id;
/*9. Create a query that displays the name, job, department name, salary and grade for
 all employees.*/
select CONCAT(firstname,' ',lastname) as 'name',job_id,department_name,salary,grade_level from employees e,departments d,job_grades where e.department_id=d.department_id AND grade_level=(select grade_level from job_grades where e.salary BETWEEN lowest_sal AND highest_sal);
/* mysql> select CONCAT(firstname,' ',lastname) as 'name',job_id,department_name,salary,grade_level from employees e,departments d,job_grades where e.department_id=d.department_id AND grade_level=(select grade_level from job_grades where e.salary BETWEEN lowest_sal AND highest_sal);
Empty set (0.02 sec)
HAD TO UPDATE THE JOB_GRADES TABLE AS VALUES WERE OUT OF RANGE T.T */
drop table job_grades;
create table job_grades
(
    grade_level varchar(2) primary key,
    lowest_sal int,
    highest_sal int
);
 insert into job_grades values
     ('AS',2500,5500),
     ('E',5501,10000),
     ('M',10001,15000),
     ('MG',15001,20000),
     ('S',20001,24000);
/* 10. Create a query to display the name and hiredate of any employee hired after
 employee "Davies" */
select CONCAT(firstname,' ',lastname) as "name",hire_date from employees where hire_date>(select hire_date from employees where lastname='Davies') order by hire_date;
