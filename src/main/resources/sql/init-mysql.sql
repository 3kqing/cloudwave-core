-- 创建数据库
create database if not exists biketrail default character set utf8;

create table if not exists app_user
(
	id_ char(32) primary key not null,
	name_ varchar(50),
	email_ varchar(50) not null,
	password_ varchar(64) not null,
	create_time_ datetime
);

create table if not exists bt_text
(
	id_ char(32) primary key not null,
	content_ varchar(500) not null,
	time_ datetime not null,
	user_id int not null
);