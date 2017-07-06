create database houseMovingSystem;

use houseMovingSystem;

create table house(
	h_id int primary key not null identity(1,1),
	h_area Nvarchar(50),
	h_cartype Nvarchar(50),
	h_movedate Datetime,
	h_contact Nvarchar(50),
	h_phone Nvarchar(50),
	h_status tinyint,
)

insert into house values('¸ÓÖİÑ°ÎÚ','Èü³µ','2014-07-24','Ô¬Íú','13546463633',2);

truncate table house

select * from house order by h_id desc