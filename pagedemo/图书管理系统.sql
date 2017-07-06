create database booksystem;
use booksystem;
create table users(
	u_id int primary key not null identity(1,1),
	u_name varchar(50),
	p_passward varchar(50)
);
insert into users values('Ԭ��','123');
select * from users where u_name='Ԭ��'
truncate table users

create table book_type(
	t_id int primary key not null identity (1,1),
	t_name varchar(50),
);
insert into book_type values('����');
select * from book_type
create table book_info(
	b_id int primary key not null identity(1,1),
	b_name varchar(50),
	create_time datetime,
	tid int references book_type(t_id)
);
insert into book_info values('ˮ��','2017-4-11',2)
select * from book_info

--�����Ӳ�ѯ
select  b.b_id,b.b_name,b.create_time,t.t_name from book_info b left join book_type t on b.tid=t.t_id order by b_id desc
--����idɾ����
delete from book_info where b_id=5;

--���²���
Update book_info set b_name='��Ϫ',create_time='2015-4-21',tid=1 where b_id=2

--��ѯ�ܼ�¼��
select count(b.b_id) as bcount from book_info b left join book_type t on b.tid=t.t_id;



--��ҳ��ѯ��SQLServer�ķֶβ�ѯ��,��һ��select�����ѯ���ڶ���select���ڲ�ѯ
select * from(select ROW_NUMBER() over(order by b.b_id) as rownum,
b.b_id,b.b_name,b.create_time,b.tid,t.t_name from
 book_info b left join book_type t on b.tid=t.t_id ) as books where books.rownum between 1 and 3  --���Ҫ���һҳ�����ݣ�0 x 3��+1 �Դ�����

 --��ҳ��ѯ��mysql�ķֶβ�ѯ��
 --select * from book_info limit 2,7;