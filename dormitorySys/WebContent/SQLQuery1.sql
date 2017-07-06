--创建数据库DormitoryDB
create database DormitoryDB;
use DormitoryDB;
drop database DormitoryDB
--创建表dormitory
create table dormitory(
	dormitoryId varchar(5) ,
	stuName varchar(20) not null,
	stuSex char(2)not null,
	clsName varchar(10) not null,
	inDate dateTime not null,
	bedNo int not null
)

--插入数据
insert into dormitory values('205','yw','男','sj128','2015-02-03',22);
insert into dormitory values('225','战神','女','sj118','2015-12-05',32);
insert into dormitory values('235','张三','男','sj138','2015-06-12',42);
insert into dormitory values('125','李四','女','sj128','2015-03-05',12);
insert into dormitory values('505','王五','女','sj168','2015-02-23',3);
insert into dormitory values('005','领带','男','sj98','2015-12-03',6);
insert into dormitory values('805','侠客','男','sj198','2015-02-25',8);

--清空表数据
truncate table dormitory


drop table dormitory 

select * from dormitory