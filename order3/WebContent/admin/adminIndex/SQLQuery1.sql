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
select  * from help

/*��ѡ�˵���*/
create table menu(
id int primary key identity(1,1),
m_type varchar(50) not null,
m_name varchar(50) not null,
fname varchar(50) not null,
price float not null,
tecont varchar(100) not null
)
insert into menu values('С����','�㹽����','1.jpg',7.6,'���������ͺͺͺͺͺͺǺǺͺͺ�')
select * from menu

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
 
 
 