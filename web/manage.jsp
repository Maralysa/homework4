<%-- 2016 © Lane Peeler & Jasmine Jones --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.html"/>
    
<table>
    <tr>
      <th>Patron Name</th>
      <th>Email</th>
      <th>Book Title</th>
      <th>Due Date</th>
      <th>Overdue</th>
      <th></th>
    </tr>
    <c:forEach var="item" items="">
        <tr>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
    </c:forEach>
  </table>

<c:import url="includes/footer.html"/>
