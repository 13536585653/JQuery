--�������ݿ�DormitoryDB
create database DormitoryDB;
use DormitoryDB;
drop database DormitoryDB
--������dormitory
create table dormitory(
	dormitoryId varchar(5) ,
	stuName varchar(20) not null,
	stuSex char(2)not null,
	clsName varchar(10) not null,
	inDate dateTime not null,
	bedNo int not null
)

--��������
insert into dormitory values('205','yw','��','sj128','2015-02-03',22);
insert into dormitory values('225','ս��','Ů','sj118','2015-12-05',32);
insert into dormitory values('235','����','��','sj138','2015-06-12',42);
insert into dormitory values('125','����','Ů','sj128','2015-03-05',12);
insert into dormitory values('505','����','Ů','sj168','2015-02-23',3);
insert into dormitory values('005','���','��','sj98','2015-12-03',6);
insert into dormitory values('805','����','��','sj198','2015-02-25',8);

--��ձ�����
truncate table dormitory


drop table dormitory 

select * from dormitory