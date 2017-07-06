create database shopsystem;
use shopsystem;
create table users(
	u_id int primary key not null identity (1,1),
	u_name varchar(50),
	u_password varchar(50)
);
insert into users values('yw','123')
truncate table users
select * from users
select * from users where u_name='yw'