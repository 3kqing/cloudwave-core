<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
    <title>测试 | 文件上传</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<h1>选择上传文件</h1>
<form action="/picture/upload" method="post" enctype="multipart/form-data">
    文件名：<input type="text" name="name" /><br/>
    <input type="file" name="file" /><br/>
    <input type="submit" />
</form>
</body>
</html>