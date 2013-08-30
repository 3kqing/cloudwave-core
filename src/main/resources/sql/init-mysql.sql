-- 创建数据库
create database if not exists biketrail default character set utf8;

create table if not exists app_user
(
	id_ char(36) primary key,
	name_ varchar(50),
	email_ varchar(50) not null,
	password_ varchar(64) not null,
	createtime_ datetime
);

create table if not exists app_user_sign_info
(
	id_ char(36) primary key,
	signtime_ datetime not null,
	signtype_ TINYINT(1) not null,
	user_id char(36) not null
);


create table if not exists ct_travel_message
(
	id_ char(36) primary key,
	title_ varchar(50) not null,
	text_ varchar(500) not null,
	path_ varchar(100) not null,
	sendtime_ datetime not null,
	travelnotes_id char(36),
	location_id char(36),
	file_id char(36),
	user_id int not null
);

create table if not exists ct_picture
(
	id_ char(36) primary key,
	title_ varchar(100),
	desc_ varchar(500),
	time_ datetime not null,
	path_ varchar(200) not null,
	user_id char(36)
);


create table if not exists ct_text
(
	id_ char(36) primary key,
	content_ varchar(500) not null,
	time_ datetime not null,
	user_id int not null
);




