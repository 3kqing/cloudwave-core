-- 创建数据库
CREATE DATABASE IF NOT EXISTS trailends DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS app_user
(
	id_ BIGINT(20) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	username_ VARCHAR(50) NOT NULL,
	nickname_ VARCHAR(50),
	email_ VARCHAR(50),
	password_ VARCHAR(64) NOT NULL,
	avatar_ VARCHAR(100),
	createtime_ DATETIME NOT NULL,
	status_ TINYINT NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS app_user_sign_info
(
	id_ BIGINT(20) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	signtime_ DATETIME NOT NULL,
	signtype_ TINYINT(1) NOT NULL,
	user_id BIGINT(20) UNSIGNED NOT NULL
);


CREATE TABLE IF NOT EXISTS ct_trip_message
(
	id_ BIGINT(20) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	text_ VARCHAR(500),
	path_ VARCHAR(100),
	sendtime_ DATETIME NOT NULL,
	receivetime_ DATETIME NOT NULL,
	travelnotes_id BIGINT(20) UNSIGNED,
	location_id BIGINT(20) UNSIGNED,
	file_id BIGINT(20) UNSIGNED ,
	user_id BIGINT(20) UNSIGNED  NOT NULL
);

CREATE TABLE IF NOT EXISTS ct_picture
(
	id_ BIGINT(20) UNSIGNED PRIMARY KEY,
	title_ VARCHAR(100),
	desc_ VARCHAR(500),
	time_ DATETIME NOT NULL,
	path_ VARCHAR(200) NOT NULL,
	user_id BIGINT(20) UNSIGNED NOT NULL
);


CREATE TABLE IF NOT EXISTS ct_text
(
	id_ BIGINT(20) UNSIGNED PRIMARY KEY,
	content_ VARCHAR(500) NOT NULL,
	time_ DATETIME NOT NULL,
	user_id BIGINT(20) UNSIGNED NOT NULL
);


CREATE TABLE IF NOT EXISTS ct_at_user
(
	id_ BIGINT(20) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	obj_id BIGINT(20) UNSIGNED NOT NULL,
	user_id BIGINT(20) UNSIGNED NOT NULL,
	hasread_ TINYINT NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS ct_loaction
(
	id_ BIGINT(20) UNSIGNED PRIMARY KEY,
	accuracy_ float,
	direction_ float,
	latitude_ double NOT NULL,
	longitude_ double NOT NULL,
	radius_ float,
	speed_ float,
	time_ datetime,
	satellitesnum_ int,
	
	country_ varchar(20),
	province_ varchar(20),
	district_ varchar(30),
	city_ varchar(30),
	town_ varchar(30),
	street_ varchar(60),
	address_ varchar(100),
	
	substance_ varchar(20),
	amend_ varchar(20)
);
