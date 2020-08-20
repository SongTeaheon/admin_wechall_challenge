<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>File Upload</title>
</head>

<body>
    <form action="/form/post/upload" method="post" enctype="multipart/form-data">
         <input type="file" name="files" multiple> 
         <input type="number" name="challengeNo">
         <input type="text" name="cont">
         <input type="number" name="userNo">
         <button type="submit">보내기</button> </form>
</body>

</html>

