<%-- 2016 © Lane Peeler & Jasmine Jones --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.html"/>

<h2>Checkout a book</h2>

    <form action="library" method="post">
    <input type="hidden" name="action" value="checkout">
    <p><label>First Name:</label> 
      <input type="text" name="firstName" 
             title="First Name"
             required></p>
    <p><label>Last Name:</label>
      <input type="text" name="lastName" 
             title="Last Name"
             required></p>
    <p><label>Email Address:</label>
      <input type="email" name="email"
             title="Email Address"
             pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
             required></p>
    <p><label>Book Title:</label> 
      <input type="text" name="bookTitle" 
             title="Book Title"
             required></p>
    <p><label>&nbsp;</label>
      <input type="submit" name="submit" value="Checkout"></p>
  </form>
    
 <c:import url="includes/footer.html"/>
