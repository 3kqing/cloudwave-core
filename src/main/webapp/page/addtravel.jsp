<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
    <title>测试 | 新增消息</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<form action="/tripmsg/save" method="post" enctype="multipart/form-data">
    内容：<input id="text" type="text" name="text" /><br/>
    用户：<input type="text" name="user.id" value="3"/><br/>
     照片：<input type="file" name="picture" /><br/>
    发送时间：<input id="st" type="text" name="sendTime" /><br/>
    <input type="submit" />
</form>
<script>
function  randomChar(l)  {
	  var  x="0123456789qwertyuioplkjhgfdsazxcvbnm";
	  var  tmp="";
	  for(var  i=0;i<  l;i++)  {
	  tmp  +=  x.charAt(Math.ceil(Math.random()*100000000)%x.length);
	  }
	  return  tmp;
}
var text = document.getElementById("text");
text.value = "随机测试内容"+randomChar(50);
	
var myDate = new Date();
var t = document.getElementById("st");

var datetime = myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate()+" "+
myDate.getHours()+":"+myDate.getMinutes()+":"+myDate.getSeconds();
t.value = datetime;
</script>
</body>
</html>
