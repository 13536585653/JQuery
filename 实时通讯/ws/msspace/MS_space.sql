create database MS_space

use MS_space

create table users
(
	ID char(32) primary key not null ,						--用户ID
	username varchar(50) not null ,							--用户名
	[password] varchar(50) not null ,						--密码
	sex char(2) default '男' ,								--性别
	birth date,												--出生日期
	[signature] varchar(50),								--个人签名
	[address] varchar(200),									--地址
	regTime datetime default getdate() ,					--用户注册时间
	[email] varchar(50) not null ,							--邮箱
	state int default 1	,									--状态
	grade int default '0' check(grade>=0 and grade<=60 ),	--等级	
	micro_blog varchar(50),									--微博
	label varchar(30),										--标签
	follow int, 											--关注量
	fans long,												--粉丝量
	collection int, 										--收藏量
	letterID char(32),										--私信ID
)