SET search_path = employee, pg_catalog;
create table employee(
  id SERIAL  primary key,
  employee_name varchar(255) NOT NULL
);

create table employee_record(
   id SERIAL  primary key,
   employee_id integer  references employee(id),
   details varchar(255)
);