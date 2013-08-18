

create database if not exists biketrail default character set utf8;

create table if not exists ct_text
(
	id_ char(32) primary key not null,
	content_ varchar(500) not null,
	user_id int not null
)

