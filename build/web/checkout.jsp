<%-- 2016 © Lane Peeler & Jasmine Jones --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.html"/>

    <form action="lib" method="post">
    <input type="hidden" name="action" value="checkout">
    <p><label>First Name</label> 
      <input type="text" name="firstName" 
             title="First Name"
             required value="${sessionScope.invest}"> </p>
    <p><label>Last Name</label>
      <input type="text" name="lastName" 
             title="Last Name"
             required value="${sessionScope.interest}"></p>
    <p><label>Email Address</label>
      <input type="email" name="email"
             title="Email Address" required > </p>
    <p><label>Book Title</label> 
      <input type="text" name="bookTitle" 
             title="Book Title"
             required value="${sessionScope.invest}"> </p>
    <p><label id="blank-label">&nbsp;</label>
      <input type="submit" name="submit" value="Checkout"></p>
  </form>
    
 <c:import url="includes/footer.html"/>
