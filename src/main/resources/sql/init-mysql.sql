-- 鍒涘缓鏁版嵁搴�
CREATE DATABASE IF NOT EXISTS biketrail DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS app_user
(
	id_ BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name_ VARCHAR(50),
	email_ VARCHAR(50) NOT NULL,
	password_ VARCHAR(64) NOT NULL,
	createtime_ DATETIME
);

CREATE TABLE IF NOT EXISTS app_user_sign_info
(
	id_ BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	signtime_ DATETIME NOT NULL,
	signtype_ TINYINT(1) NOT NULL,
	user_id CHAR(36) NOT NULL
);


CREATE TABLE IF NOT EXISTS ct_trip_message
(
	id_ BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	text_ VARCHAR(500),
	path_ VARCHAR(100),
	sendtime_ DATETIME NOT NULL,
	receivetime_ DATETIME NOT NULL,
	travelnotes_id BIGINT(36),
	location_id BIGINT(36),
	file_id BIGINT(36),
	user_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS ct_picture
(
	id_ CHAR(36) PRIMARY KEY,
	title_ VARCHAR(100),
	desc_ VARCHAR(500),
	time_ DATETIME NOT NULL,
	path_ VARCHAR(200) NOT NULL,
	user_id CHAR(36)
);


CREATE TABLE IF NOT EXISTS ct_text
(
	id_ CHAR(36) PRIMARY KEY,
	content_ VARCHAR(500) NOT NULL,
	time_ DATETIME NOT NULL,
	user_id int not null
);




