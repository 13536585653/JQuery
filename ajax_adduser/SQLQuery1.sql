create database ajax_findUser;

use ajax_findUser;

create table myuser(
	id int primary key not null identity(1,1),
	name varchar(50),
	password varchar(50)not null,
	age int not null,
	address varchar(50)
)
insert into myuser values('zdd','123',23,'jx')
select * from myuser
drop table myuser 