<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
        <div style="border-bottom:2px solid gray;"><tiles:insertAttribute name="header" /></div>
        <div style="float:left;padding:10px;width:15%;height:90%;"><tiles:insertAttribute name="menu" /></div>
        <div style="float:left;padding:20px;width:80%;height:400px;border-left:2px solid gray;">
        <tiles:insertAttribute name="body" /></div>
        <div style="clear:both; border-top:2px solid gray;"><tiles:insertAttribute name="footer" /></div>
</body>
</html>