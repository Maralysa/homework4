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
    <c:forEach var="item" items="${users}">
        <tr>
          <td>${item.firstName} ${item.lastName}</td>
          <td>${item.email}</td>
          <td>${item.bookTitle}</td>
          <td>${item.formattedDate}</td>
          <td><c:if test="${item.overdue}">overdue</c:if></td>
          <td>
              <a href="library?action=checkIn&amp;email=${item.email}">
                <input type="submit" name="CheckIn" value="Check In">
              </a>
          </td>
        </tr>
    </c:forEach>
  </table>

<p><a href="library" title="Index">Return to front page</a></p>

<c:import url="includes/footer.html"/>
