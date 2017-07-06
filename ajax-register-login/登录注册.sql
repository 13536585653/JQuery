create database register_loginSystem;
use register_loginSystem;
drop table users
--用户表users
create table users(
	u_id int primary key not null identity(1,1),
	u_name varchar(50) not null,
	u_password varchar(50) not null,
	u_sex varchar(20) not null,
	u_age int,
	u_num varchar(20) not null,
	u_address varchar(50) not null,
	u_regTime datetime not null,
)
select * from users where u_id=1
insert into users values('YW','123','男',21,13536585653,'江西赣州','2015-10-24')
--清除数据
truncate table users
--查询用户表
select * from users