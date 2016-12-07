<%-- 2016 © Lane Peeler & Jasmine Jones --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.html"/>

<p>Thank you for your patronage of the Belk Library. You've successfully 
   checked out the book, ${user.bookTitle}. Please note that this book is due 
   back on ${user.formattedDate}. A friendly email reminder will be sent to 
   you if your book becomes overdue.</p>
<p><a href="library" title="Index">Return to front page</a></p>

  <c:import url="includes/footer.html"/>