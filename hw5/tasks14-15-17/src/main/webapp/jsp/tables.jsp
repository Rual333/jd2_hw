<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 <head>
  <title>Expenses tables</title>
 </head>
 <body>
  <table border="1" width="50%" cellpadding="5" align= "center">
   <caption>Expenses table:<caption/>
   <tr>
   <th>Num</th><th>Paydate</th><th>Receiver</th><th>Value</th>
   </tr>
   <c:forEach items="${requestScope.expenses}" var="exp">
       <tr>
       <td align="center"><c:out value="${exp.num}"/></td>
       <td align="center"><c:out value="${exp.payDate}"/></td>
       <td align="center"><c:out value="${exp.receiver}"/></td>
       <td align="center"><c:out value="${exp.value}"/></td>
       </tr>
   </c:forEach>
 </table>
 <br>
   <table border="1" width="30%" cellpadding="5" align= "center">
    <caption>Receiver table:<caption/>
    <tr>
    <th>Num</th><th>Name</th>
    </tr>
    <c:forEach items="${requestScope.receivers}" var="rec">
        <tr>
        <td align="center"><c:out value="${rec.num}"/></td>
        <td align="center"><c:out value="${rec.name}"/></td>
        </tr>
    </c:forEach>
  </table>
 </body>
</html>