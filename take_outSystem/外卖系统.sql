create database take_outDB;

use take_outDB;

--创建角色表
create table role(
	r_id int primary key not null identity(1,1),
	r_type varchar(20)
)
drop table role
insert into role values('超级VIP')
select * from role

--创建用户表
create table users(
	u_id int primary key not null identity(1,1),
	u_name varchar(50) not null,
	u_pwd varchar(50) not null,
	u_sex varchar(50) not null,
	u_addr varchar(100) not null,
	u_email varchar(50) not null,
	u_tel varchar(50) not null,
	u_monetary float,
	rid int references role(r_id)
);
drop table users
insert into users values('zs','123','男','江西','123','123353535',null,'2');
Update users set u_pwd='123',u_addr='广东',u_email='786091203',u_tel='12243' where u_id=1

truncate table users
select * from users where u_name='wz'
select * from users left join role on rid=r_id
select * from users

