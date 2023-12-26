<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="format-detection" content="telephone=no">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSP-Hello World</title>
</head>
<body>
<h1>Test<h1>
<h2>Hello World!</h2>
<p>
<%="Hello from Hell"%>
</p>
<p>
<%@ page import = "java.time.format.DateTimeFormatter, java.time.LocalDate, pegas.TestForJsp"%>
<%
DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate date = LocalDate.now();
String str = format.format(date);
TestForJsp test = new TestForJsp();
%>
<%=str%>
</p>
<p>
<%=test.getInfo()%>
</p>
<p>
<%
for(int i = 0; i<10; i++){
out.println("<p>"+"Second start "+i+"</p>");
}
%>
</p>
<a href="hello-servlet">Hello Servlet</a>
<a href="second-servlet">Hello Servlet</a>
</body>
</html>
