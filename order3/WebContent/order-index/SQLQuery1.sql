use ordersystem
/*�˺������*/
create table help(
h_id int primary key identity(1,1),
h_type varchar(50) 
)
/*�������*/
insert into help values('�˺�����')
insert into help values('֧������')
insert into help values('��������')
insert into help values('��������')
insert into help values('��������')
insert into help values('��������')
delete from help where h_id=9
select  * from help

/*��ѡ�˵���*/
create table menu(
id int primary key identity(1,1),
m_name varchar(50) not null,
fname varchar(50) not null,
price float not null,
tecont varchar(100) not null,
mm_id int references dishes(d_id)
)
exec sp_rename 'menu','jxmenu'
delete from jxmenu
insert into menu values('�㹽����','1.jpg',7.6,'���������ͺͺͺͺͺͺǺǺͺͺ�',1)
insert into menu values('�㹽����','1.jpg',7.6,'���������ͺͺͺͺͺͺǺǺͺͺ�',2)
insert into menu values('�㹽����','1.jpg',7.6,'���������ͺͺͺͺͺͺǺǺͺͺ�',3)
insert into menu values('�㹽����','1.jpg',7.6,'���������ͺͺͺͺͺͺǺǺͺͺ�',4)
select * from jxmenu

/*�˵������*/
create table diahes(
d_id int primary key identity(1,1),
d_type varchar(50) not null
)
/*�޸ı���*/
exec sp_rename 'diahes','dishes'
select * from dishes
insert into diahes values('С����')
insert into diahes values('������')
insert into diahes values('�����')
insert into diahes values('�տ���')
insert into diahes values('С����')
insert into diahes values('������')
/*��ѡ�˺Ͳ˵���������ѯ*/
select m.id,m.m_name,m.fname,m.price,m.tecont,d.d_type from menu m inner join dishes d on m.mm_id=d.d_id where m.id=1
delete from menu where id=5

/*��ѡ�˺Ͳ˵������ҳ��ѯ*/
select count(b.id) as bcount from menu b left join dishes t on b.id=t.d_id
select * from(select ROW_NUMBER() over(order by b.id) as rownum,b.id,b.m_name,b.fname,b.price,b.tecont,t.d_type from menu b left join dishes t on b.mm_id=t.d_id ) as tt where tt.rownum between 1 and 3

/*�����*/
select  * from wenti
drop table wenti
create table wenti(
w_id int primary key identity(1,1),
w_wenti varchar(50) not null,
w_daan varchar(100) not null,
ww_id int references help(h_id)
)
insert into wenti values('���ǵ�¼��������ô�죿','ͨ����¼���������������롱��Ȼ��ҳ����ʾ��������.',1)
insert into wenti values('�ղ���/�Ҳ���/��ɾŴ��ȯ��ô�죿','�ҵ����Ź��Ķ���������Ʒ�Ҳ�����·����"��ȡŴ��ȯ".',2)
insert into wenti values(' ����ɹ�����δ������ô�죿','�µ��Ŵ�ͷ�4006-888-887�����ǻ�Э�������.',3)
insert into wenti values('�̼ҵ绰�Ƕ��١���ַ���ģ�','�鿴��Ʒ����ҳ"��������"���������̼ҵ绰�͵�ַ��',4)
insert into wenti values('��Щ�����������ۣ�','�����Ѷ����������ۣ�',5)

/*��������������������*/
select w.w_wenti,w.w_daan, h.h_type from wenti w inner join help h on w.ww_id=h.h_id
/*�������������������飬��ҳ��ѯ*/
select * from(select ROW_NUMBER() over(order by b.w_id) as rownum,
 b.w_wenti,b.w_daan,t.h_type from
 wenti b left join help t on b.ww_id=t.h_id ) as tt where tt.rownum between 1 and 4 
 /*��ҳ��ѯ���ܼ�¼��*/
 select count(b.w_id) as bcount from wenti b left join help t on b.ww_id=t.h_id
/*�������������������飬��ҳ��ѯ*/ 
 select * from(select ROW_NUMBER() over(order by b.w_id) as rownum,b.w_id,b.w_wenti,b.w_daan,t.h_type from wenti b left join help t on b.ww_id=t.h_id ) as tt where tt.rownum between 1 and 4 
 /*ɾ����������*/
 delete from wenti where w_id=22
 
 
 /*���еĲ˵ı�*/
create table menu
(
	m_id int primary key identity(1,1),
	m_name varchar(20) not null,  -- ����
	m_price float not null, 	-- �۸�
	m_img varchar(20) not null,	-- ͼƬ
	m_description text not null,	-- ���
	d_id int REFERENCES dishes(d_id)	-- ����������
)
drop table menu
delete from menu
insert into menu values('�Ըе�',32,'1.JPG','�й��򻹰��淶',1)
insert into menu values('�Ըе�',32,'1.JPG','�й��򻹰��淶',1)
insert into menu values('�Ըе�',32,'1.JPG','�й��򻹰��淶',1)
insert into menu values('�Ըе�',32,'1.JPG','�й��򻹰��淶',1)
insert into menu values('�Ըе�',32,'1.JPG','�й��򻹰��淶',1)
insert into menu values('��������',39,'8.jpg','��������,��ζ�ɿ�!',2)
insert into menu values('������',76,'9.jpg','������,��ζ�ɿ�!',1)
insert into menu values('ľ����Ƭ',77,'7.jpg','ľ����Ƭ,��ζ�ɿ�!',2)
insert into menu values('֧����Ѽ',45,'6.jpg','֧����Ѽ,��ζ�ɿ�!',3)
insert into menu values('��������',73,'7.jpg','��������,��ζ�ɿ�!',3)
insert into menu values('�ҳ�����',23,'9.jpg','�ҳ�����,��ζ�ɿ�!',4)
insert into menu values('��ϳ���',45,'10.jpg','��ϳ���,��ζ�ɿ�!',3)

select * from menu

/*���еĲ˵ķ�ҳ��ѯ*/
select count(b.m_id) as bcount from menu b left join dishes t on b.d_id=t.d_id
select * from(select ROW_NUMBER () over(order by m.m_id)as rownum,m.m_id ,m.m_name,m.m_price ,m.m_img , m.d_id ,d.d_type from  menu m left join dishes d on  m.d_id=d.d_id)as tt where tt.rownum between 0 and 2 


/*������Ϣ��*/
create table indent
(
	i_id int primary key identity(1,1),
	i_nunber varchar(20) not null,	-- �������
	i_time datetime not null,	-- ����ʱ��
	i_num int not null,	-- ����
	i_way varchar(20) not null,	-- ֧����ʽ
	i_sun FLOAT not null,	-- ���
	i_start varchar(20) not null,	-- ����״̬
	i_m_id int REFERENCES menu(m_id),	-- ������˵���
	i_u_id int REFERENCES users(u_id),	-- ������û���
)
insert into indent values('000001','2016-9-10',4,'֧����',434.0,'�ɹ�',1,2)
insert into indent values('000002','2016-9-10',5,'΢��',437.0,'ʧ��',1,5)
insert into indent values('000003','2016-9-10',6,'����',444.0,'ʧ��',1,4)
insert into indent values('000004','2016-9-10',7,'΢��',666.0,'�ɹ�',1,3)
insert into indent values('000005','2016-6-10',8,'֧����',222.0,'�ɹ�',1,6)

select * from indent

/**��ѯ���ж���*/
Select o.o_id,o.o_m_id, o.o_u_id, o.o_number,o.o_time,o.o_way,o.o_state,o.o_sum, m.m_name, u.u_addr,u.u_tel, u.u_email ,u.u_name
from indent as o  inner join menu as m on o.o_m_id=m.m_id inner join  u_user as u  where o.o_u_id=u.u_id


select i.i_id,i.i_num,i.i_nunber,i.i_start,i.i_sun,i.i_time,i.i_way,u.u_id,i.i_u_id ,u.u_addr,u.u_name ,m.m_name
from  indent as i  inner join menu as m on i.i_m_id=m.m_id inner join users as u on u.u_id=i.i_u_id

/*��ʱ�䶩������*/
select i.i_id,i.i_m_id, i.i_u_id, i.i_num,i.i_time,i.i_way,i.i_nunber,i.i_start,i.i_sun, m.m_name, u.u_addr,u.u_tel, u.u_email ,u.u_name
from indent as i  inner join menu as m on i.i_m_id=m.m_id inner join  users as u  on i.i_u_id=u.u_id ORDER BY i_time DESC

select * from users
select * from users where rid=1

select *from role
insert into role values('��ͨ�û�')
select * from users u LEFT JOIN role r on u.rid=r.r_id where u_id=2
select * from users u LEFT JOIN role r on u.rid=r.r_id where u_id=2
update users set u_name='XXF' , u_email='11111' ,u_tel='11111' ,u_addr='11111' ,u_sex='��',rid=2 where u_id =2

insert into users values('zs','123','��','����','123','123353535',null,'1');

update users set u_name='2222' , u_email='232323',u_tel='323232323' ,u_addr='323232323' ,u_sex='��',rid=1 where u_id =2