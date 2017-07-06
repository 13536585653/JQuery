create database booksystem;
use booksystem;
create table users(
	u_id int primary key not null identity(1,1),
	u_name varchar(50),
	p_passward varchar(50)
);
insert into users values('袁旺','123');
select * from users where u_name='袁旺'
truncate table users

create table book_type(
	t_id int primary key not null identity (1,1),
	t_name varchar(50),
);
insert into book_type values('综艺');
select * from book_type
create table book_info(
	b_id int primary key not null identity(1,1),
	b_name varchar(50),
	create_time datetime,
	tid int references book_type(t_id)
);
insert into book_info values('水乡','2017-4-11',2)
select * from book_info

--左连接查询
select  b.b_id,b.b_name,b.create_time,t.t_name from book_info b left join book_type t on b.tid=t.t_id order by b_id desc
--根据id删除行
delete from book_info where b_id=5;

--更新操作
Update book_info set b_name='夏溪',create_time='2015-4-21',tid=1 where b_id=2

--查询总记录数
select count(b.b_id) as bcount from book_info b left join book_type t on b.tid=t.t_id;



--分页查询（SQLServer的分段查询）,第一个select是外查询，第二个select是内查询
select * from(select ROW_NUMBER() over(order by b.b_id) as rownum,
b.b_id,b.b_name,b.create_time,b.tid,t.t_name from
 book_info b left join book_type t on b.tid=t.t_id ) as books where books.rownum between 1 and 3  --如果要查第一页的内容（0 x 3）+1 以次类推

 --分页查询（mysql的分段查询）
 --select * from book_info limit 2,7;