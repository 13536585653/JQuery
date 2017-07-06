create database MS_space

use MS_space

create table users
(
	ID char(32) primary key not null ,						--�û�ID
	username varchar(50) not null ,							--�û���
	[password] varchar(50) not null ,						--����
	sex char(2) default '��' ,								--�Ա�
	birth date,												--��������
	[signature] varchar(50),								--����ǩ��
	[address] varchar(200),									--��ַ
	regTime datetime default getdate() ,					--�û�ע��ʱ��
	[email] varchar(50) not null ,							--����
	state int default 1	,									--״̬
	grade int default '0' check(grade>=0 and grade<=60 ),	--�ȼ�	
	micro_blog varchar(50),									--΢��
	label varchar(30),										--��ǩ
	follow int, 											--��ע��
	fans long,												--��˿��
	collection int, 										--�ղ���
	letterID char(32),										--˽��ID
)