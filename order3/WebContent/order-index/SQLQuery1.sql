use ordersystem
/*账号问题表*/
create table help(
h_id int primary key identity(1,1),
h_type varchar(50) 
)
/*添加数据*/
insert into help values('账号问题')
insert into help values('支付问题')
insert into help values('订单问题')
insert into help values('消费问题')
insert into help values('评价问题')
insert into help values('评价问题')
delete from help where h_id=9
select  * from help

/*精选菜单表*/
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
insert into menu values('香菇炒肉','1.jpg',7.6,'哈哈哈哈和和和和和和呵呵和和和',1)
insert into menu values('香菇炒肉','1.jpg',7.6,'哈哈哈哈和和和和和和呵呵和和和',2)
insert into menu values('香菇炒肉','1.jpg',7.6,'哈哈哈哈和和和和和和呵呵和和和',3)
insert into menu values('香菇炒肉','1.jpg',7.6,'哈哈哈哈和和和和和和呵呵和和和',4)
select * from jxmenu

/*菜单种类表*/
create table diahes(
d_id int primary key identity(1,1),
d_type varchar(50) not null
)
/*修改表名*/
exec sp_rename 'diahes','dishes'
select * from dishes
insert into diahes values('小炒类')
insert into diahes values('爆炒类')
insert into diahes values('烹饪类')
insert into diahes values('烧烤类')
insert into diahes values('小吃类')
insert into diahes values('流量类')
/*精选菜和菜单种类连查询*/
select m.id,m.m_name,m.fname,m.price,m.tecont,d.d_type from menu m inner join dishes d on m.mm_id=d.d_id where m.id=1
delete from menu where id=5

/*精选菜和菜单种类分页查询*/
select count(b.id) as bcount from menu b left join dishes t on b.id=t.d_id
select * from(select ROW_NUMBER() over(order by b.id) as rownum,b.id,b.m_name,b.fname,b.price,b.tecont,t.d_type from menu b left join dishes t on b.mm_id=t.d_id ) as tt where tt.rownum between 1 and 3

/*问题表*/
select  * from wenti
drop table wenti
create table wenti(
w_id int primary key identity(1,1),
w_wenti varchar(50) not null,
w_daan varchar(100) not null,
ww_id int references help(h_id)
)
insert into wenti values('忘记登录密码了怎么办？','通过登录界面点击“忘记密码”，然后按页面提示操作即可.',1)
insert into wenti values('收不到/找不到/误删糯米券怎么办？','找到您团购的订单，在商品右侧操作下方点击"获取糯米券".',2)
insert into wenti values(' 付款成功订单未生成怎么办？','致电百糯客服4006-888-887，我们会协助您解决.',3)
insert into wenti values('商家电话是多少、地址在哪？','查看商品详情页"本单详情"，里面有商家电话和地址。',4)
insert into wenti values('哪些订单可以评价？','已消费订单即可评价；',5)

/*问题表与问题种类表连查*/
select w.w_wenti,w.w_daan, h.h_type from wenti w inner join help h on w.ww_id=h.h_id
/*问题表与问题种类表连查，分页查询*/
select * from(select ROW_NUMBER() over(order by b.w_id) as rownum,
 b.w_wenti,b.w_daan,t.h_type from
 wenti b left join help t on b.ww_id=t.h_id ) as tt where tt.rownum between 1 and 4 
 /*分页查询的总记录数*/
 select count(b.w_id) as bcount from wenti b left join help t on b.ww_id=t.h_id
/*问题表与问题种类表连查，分页查询*/ 
 select * from(select ROW_NUMBER() over(order by b.w_id) as rownum,b.w_id,b.w_wenti,b.w_daan,t.h_type from wenti b left join help t on b.ww_id=t.h_id ) as tt where tt.rownum between 1 and 4 
 /*删除问题数据*/
 delete from wenti where w_id=22
 
 
 /*所有的菜的表*/
create table menu
(
	m_id int primary key identity(1,1),
	m_name varchar(20) not null,  -- 菜名
	m_price float not null, 	-- 价格
	m_img varchar(20) not null,	-- 图片
	m_description text not null,	-- 简介
	d_id int REFERENCES dishes(d_id)	-- 外键，分类表
)
drop table menu
delete from menu
insert into menu values('性感的',32,'1.JPG','有功夫还按规范',1)
insert into menu values('性感的',32,'1.JPG','有功夫还按规范',1)
insert into menu values('性感的',32,'1.JPG','有功夫还按规范',1)
insert into menu values('性感的',32,'1.JPG','有功夫还按规范',1)
insert into menu values('性感的',32,'1.JPG','有功夫还按规范',1)
insert into menu values('花生猪手',39,'8.jpg','花生猪手,香味可口!',2)
insert into menu values('红烧肉',76,'9.jpg','红烧肉,香味可口!',1)
insert into menu values('木耳肉片',77,'7.jpg','木耳肉片,香味可口!',2)
insert into menu values('支竹焖鸭',45,'6.jpg','支竹焖鸭,香味可口!',3)
insert into menu values('红烧茄子',73,'7.jpg','红烧茄子,香味可口!',3)
insert into menu values('家常豆腐',23,'9.jpg','家常豆腐,香味可口!',4)
insert into menu values('青瓜炒肉',45,'10.jpg','青瓜炒肉,香味可口!',3)

select * from menu

/*所有的菜的分页查询*/
select count(b.m_id) as bcount from menu b left join dishes t on b.d_id=t.d_id
select * from(select ROW_NUMBER () over(order by m.m_id)as rownum,m.m_id ,m.m_name,m.m_price ,m.m_img , m.d_id ,d.d_type from  menu m left join dishes d on  m.d_id=d.d_id)as tt where tt.rownum between 0 and 2 


/*订单信息表*/
create table indent
(
	i_id int primary key identity(1,1),
	i_nunber varchar(20) not null,	-- 订单编号
	i_time datetime not null,	-- 订单时间
	i_num int not null,	-- 数量
	i_way varchar(20) not null,	-- 支付方式
	i_sun FLOAT not null,	-- 金额
	i_start varchar(20) not null,	-- 订单状态
	i_m_id int REFERENCES menu(m_id),	-- 外键，菜单表
	i_u_id int REFERENCES users(u_id),	-- 外键，用户表
)
insert into indent values('000001','2016-9-10',4,'支付宝',434.0,'成功',1,2)
insert into indent values('000002','2016-9-10',5,'微信',437.0,'失败',1,5)
insert into indent values('000003','2016-9-10',6,'到付',444.0,'失败',1,4)
insert into indent values('000004','2016-9-10',7,'微信',666.0,'成功',1,3)
insert into indent values('000005','2016-6-10',8,'支付宝',222.0,'成功',1,6)

select * from indent

/**查询所有订单*/
Select o.o_id,o.o_m_id, o.o_u_id, o.o_number,o.o_time,o.o_way,o.o_state,o.o_sum, m.m_name, u.u_addr,u.u_tel, u.u_email ,u.u_name
from indent as o  inner join menu as m on o.o_m_id=m.m_id inner join  u_user as u  where o.o_u_id=u.u_id


select i.i_id,i.i_num,i.i_nunber,i.i_start,i.i_sun,i.i_time,i.i_way,u.u_id,i.i_u_id ,u.u_addr,u.u_name ,m.m_name
from  indent as i  inner join menu as m on i.i_m_id=m.m_id inner join users as u on u.u_id=i.i_u_id

/*按时间订单排序*/
select i.i_id,i.i_m_id, i.i_u_id, i.i_num,i.i_time,i.i_way,i.i_nunber,i.i_start,i.i_sun, m.m_name, u.u_addr,u.u_tel, u.u_email ,u.u_name
from indent as i  inner join menu as m on i.i_m_id=m.m_id inner join  users as u  on i.i_u_id=u.u_id ORDER BY i_time DESC

select * from users
select * from users where rid=1

select *from role
insert into role values('普通用户')
select * from users u LEFT JOIN role r on u.rid=r.r_id where u_id=2
select * from users u LEFT JOIN role r on u.rid=r.r_id where u_id=2
update users set u_name='XXF' , u_email='11111' ,u_tel='11111' ,u_addr='11111' ,u_sex='男',rid=2 where u_id =2

insert into users values('zs','123','男','江西','123','123353535',null,'1');

update users set u_name='2222' , u_email='232323',u_tel='323232323' ,u_addr='323232323' ,u_sex='男',rid=1 where u_id =2