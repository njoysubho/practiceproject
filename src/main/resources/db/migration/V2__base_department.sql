SET search_path = department, pg_catalog;
create table department(
  id SERIAL  primary key,
  department_name varchar(255) NOT NULL
);