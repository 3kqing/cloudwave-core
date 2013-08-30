-- 创建数据库
create database if not exists biketrail default character set utf8;

create table if not exists app_user
(
	id_ char(36) primary key,
	name_ varchar(50),
	email_ varchar(50) not null,
	password_ varchar(64) not null,
	create_time_ datetime
);

create table if not exists ct_travel_message
(
	id_ char(36) primary key,
	title_ varchar(50),
	text_ varchar(500),
	path_ varchar(100),
	sendtime_ datetime not null,
	timestamp_ long not null,
	travelnotes_id char(36),
	location_id char(36),
	file_id char(36),
	user_id int not null
);

create table if not exists ct_text
(
	id_ char(36) primary key,
	content_ varchar(500) not null,
	time_ datetime not null,
	user_id int not null
);