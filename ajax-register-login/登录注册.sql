create database register_loginSystem;
use register_loginSystem;
drop table users
--�û���users
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
insert into users values('YW','123','��',21,13536585653,'��������','2015-10-24')
--�������
truncate table users
--��ѯ�û���
select * from users