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
select  * from help

/*精选菜单表*/
create table menu(
id int primary key identity(1,1),
m_type varchar(50) not null,
m_name varchar(50) not null,
fname varchar(50) not null,
price float not null,
tecont varchar(100) not null
)
insert into menu values('小炒类','香菇炒肉','1.jpg',7.6,'哈哈哈哈和和和和和和呵呵和和和')
select * from menu

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
 
 
 