<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${ user.name }! </h1>
        <h2>Seja bem vindo à area de recrutamento de candidatos.</h2>
        <b>Data:</b> <%= new java.util.Date() %><br>
    </body>
</html>
