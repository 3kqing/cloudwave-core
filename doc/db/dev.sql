
USE biketrail;

SELECT * FROM app_user;

SELECT * FROM ct_trip_message;

SELECT id_,name_,email_,password_ 
FROM app_user u 
WHERE u.email_ = '569141948@qq.com' 
OR u.name_ = '569141948@qq.com' 

DROP TABLE ct_trip_message;

SELECT  id_,text_,path_,sendtime_,receivetime_,user_id     FROM ct_trip_message tm ORDER BY tm.sendtime_ DESC LIMIT 0,15

SELECT * FROM ct_trip_message ;

SELECT COUNT(tm.id_) FROM ct_trip_message tm WHERE tm.id_ < 3 ORDER BY tm.sendtime_ DESC