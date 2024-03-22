/*1. Write a query to display the lastname, department number, and department name
 for all employees. */
     select lastname,employees.department_id,department_name 
     from employees LEFT JOIN departments 
     ON employees.department_id=departments.department_id;
/*2. Create a unique listing of all jobs that are in department 30. Include the location id in
 the output. */
     select distinct job_id,location_id
     from employees e JOIN departments d 
     ON d.department_id=e.department_id where e.department_id=30;
/*3. Write a query to display the employee lastname, department name, location id, and
 city of all employees who earn a commission. */
     select lastname,department_name,l.location_id,city
     from employees e,departments d,locations l 
     where commission_pct IS NOT NULL AND e.department_id=d.department_id AND d.location_id=l.location_id;
/*4. Display the employee lastname, and department name for all employees who have
 an "a" in their lastname. */
     select lastname,department_name
     from employees e JOIN departments d 
     ON e.department_id=d.department_id where lastname LIKE "%a";    
/*5. Write a query to display the lastname, job, department number, and department
 name for all employees who work in Toronto. */  
     select lastname,job_id,d.department_id,d.department_name 
     from employees e,departments d 
     where e.department_id=d.department_id and d.location_id=(select location_id from locations where city="Toronto");
/*6. Display the employee lastname and employee number along with their manager's
 lastname and manager number. Label the columns "Employee", "Emp#", "Manager"
 and "Manager#" respectively. */
     select e1.lastname as "Employee",e1.employee_id as "Emp#",e2.lastname as "Manager",e2.employee_id as"Manager#"
     from employees e1 JOIN employees e2 
     ON  e1.manager_id=e2.employee_id;
/*7. Modify the above to display the same columns for all employees (including "King",
 who has no manager). Order the result by the employee number. */
     select e1.lastname as "Employee",e1.employee_id as "Emp#",e2.lastname as "Manager",e2.employee_id as"Manager#"
     from employees e1 LEFT JOIN employees e2
     ON  e1.manager_id=e2.employee_id ORDER BY e1.employee_id;
/*8. Create query that displays employee lastnames, department numbers, and all the
 employees who work in the same department as a given employee. Give each
column an appropriate label. */
     select lastname,d.department_id,department_name 
     from employees e JOIN departments d
     ON e.department_id=d.department_id order by e.department_id;
/*9. Create a query that displays the name, job, department name, salary and grade for
 all employees.*/
     select CONCAT(firstname,' ',lastname) as 'name',job_id,department_name,salary,grade_level
     from employees e,departments d,job_grades
     where e.department_id=d.department_id AND grade_level=(select grade_level from job_grades where e.salary BETWEEN lowest_sal AND highest_sal);
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
     select CONCAT(firstname,' ',lastname) as "name",hire_date
     from employees
     where hire_date>(select hire_date from employees where lastname='Davies')
     order by hire_date;
/*11. Display the names and hire dates for all employees who were hired before their
 managers, along with their manager's names and hiredates. Label the columns
 "Employee", "Emp hired", "Manager", and "Manager hired" respectively. */
     select CONCAT_WS(' ',e1.firstname,e1.lastname) as "Employee",e1.hire_date as "Emp hired",CONCAT_WS(' ',e2.firstname,e2.lastname) as "Manager",e2.hire_date as"Manager hired"
     from employees e1 JOIN employees e2 
     ON e1.manager_id=e2.employee_id
     where e1.hire_date<e2.hire_date;
/*12. Display the highest, lowest, sum and average salary of all employees. Label the
 columns "Maximum", "Minimum", "Sum", and "Average" respectively. */
     select MAX(salary) as 'Maximum',MIN(salary) as 'Minimum',SUM(salary) as 'Sum',AVG(salary) as 'Average'
     from employees;
/*13. Modify the above query to display the same data for each job type. */
     select job_id,MAX(salary) as 'Maximum',MIN(salary) as 'Minimum',SUM(salary) as 'Sum',AVG(salary) as 'Average'
     from employees
     group by job_id;
/* 14. Write a query to display the number of people with the same job. */
     select job_id, COUNT(job_id)
     from employees
     group by job_id;
/*15. Determine the number of managers without listing them. Label the column "Number
 of Managers". [Hint: use the MANAGER_ID column to determine the number of
 managers] */
     select COUNT(distinct manager_id) as 'Number of Managers'
     from employees;
/*16. Write a query that displays the di erence between the highest and the lowes salaries.
 Label the column as "Di erence". */
     select (MAX(salary)-MIN(salary)) as 'Difference'
     from employees;
/* 17. Display the manager number and the salary of the lowest paid employee for that
 manager. Exclude anyone whose manager is not known. Exclude any group where
 the minimum salary is less than $6000. Sort the output in descending order of salary. */
     select e2.employee_id as 'Manager ID',MIN(e1.salary) as 'Lowest Salary'
     from employees e1 JOIN employees e2 
     ON  e1.manager_id=e2.employee_id
     group by e2.employee_id       --CAN'T USE WHERE HERE!!!!! GROUP BY IS ALWAYS FOLLOWED BY HAVING NOT WHERE!!
     having MIN(e1.salary)>=6000   --CAN'T USE ALIAS HERE
     order by MIN(e1.salary) DESC; --CAN'T USE ALIAS HERE
/* 18. Write a query to display each department's name, location, number of employees,
 and the average salary for all employees in that department. Label the columns
 "Name", "Location", "No.of people", and "SAlary" respectively. Round the average
 salary to two decimal places. */
     select department_name as 'Name',CONCAT_WS(',',city,state_province) as 'Location',COUNT(employee_id) as 'No. of people',ROUND(AVG(salary),2) as 'Salary'
     from departments d LEFT JOIN employees e
     ON d.department_id=e.department_id
     JOIN locations l
     ON d.location_id=l.location_id
     group by Name,Location;
/* 19. Write a query to display the lastname, and hiredate of any employee in the
 department as the employee "Zlotkey". Exclude "Zlotkey". */
     select lastname,hire_date 
     from employees 
     where department_id=(select department_id from employees where lastname='Zlotkey')
     AND lastname NOT LIKE 'Zlotkey';
/* 20. Create a query to display the employee numbers and lastnames of all employees
 who earn more than the average salary. Sort the result in ascending order of salary */
     select employee_id,lastname
     from employees
     where salary>(select AVG(salary) from employees)
     order by salary ASC;
/* 21. Write a query that displays the employee number and lastname of all employees who
 work in a department with any employee whose lastname contains a "u". */
     select employee_id,lastname,department_id
     from employees
     where department_id IN (select department_id from employees where lastname like '%u%')
     order by department_id;
/* 22. Display the lastname, department number, and job id of all employees whose
 department location id is 1700. */
     select lastname,e.department_id,job_id
     from employees e,departments d 
     where e.department_id=d.department_id 
     AND location_id=1700;
/* 23. Display the lastname and salary of every employee who reports to "King". */
     select lastname,salary
     from employees 
     where manager_id IN (select employee_id from employees where lastname='King');
/*24. Display the department number, lastname, and job id for every employee in the
 "Executive" department. */
     select e.department_id,lastname,job_id 
     from employees e JOIN departments d
     ON  e.department_id=d.department_id
     where d.department_name='Executive';
/* 25. Display the employee number, lastname, and salary of all employees who earn more
 than the average salary and who work in a department with any employee with a "u"
 in their lastname. */
     select employee_id,lastname,salary
     from employees
     where department_id IN (select department_id from employees where lastname like '%u%')
     AND salary>(select AVG(salary) from employees);
/* 26. Write a query to get unique department ID from employee table. */
     select distinct department_id 
     from employees
     where department_id IS NOT NULL;
/* 27. Write a query to get all employee details from the employee table order by rst
 name, descending */
     select *from employees
     order by firstname DESC;
/* 28. Write a query to get the names ( rst_name, last_name), salary, PF of all the
 employees (PF is calculated as 15% of salary). */
     select CONCAT_WS(' ',firstname,lastname) as 'name',salary,(0.15*salary) as 'PF'
     from employees;
/*29. Write a query to get the employee ID, names ( rst_name, last_name), salary in
 ascending order of salary. */
     select employee_id, CONCAT_WS(' ',firstname,lastname) as 'name',salary
     from employees
     order by salary;
/* 30. Write a query to get the total salaries payable to employees. */
     select SUM(salary) as 'Total Salaries Payable'
     from employees;
/* 31. Write a query to get the maximum and minimum salary from employees table. */
     select MAX(salary),MIN(salary) from employees;
