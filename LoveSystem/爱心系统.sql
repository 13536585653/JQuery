create database LoveDB;
use LoveDB;

create table LoveInHeart(
	lid int primary key not null identity(1,1),
	lname varchar(50),
	lsex varchar(50),
	ltime datetime,
	lmoney money,
)
--修改用户表，添加一个约束
Alter  table  LoveInHeart  add  constraint  ck_lmoney  CHECK(lmoney>0)
--插入一条数据
insert into LoveInHeart values('yw','男','2015-05-25',300)

truncate table LoveInHeart;


select * from LoveInHeart order by lid desc;