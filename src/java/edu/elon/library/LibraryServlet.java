/* 2016 © Lane Peeler & Jasmine Jones */

package edu.elon.library;

import edu.elon.bean.User;
import edu.elon.data.UserDB;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LibraryServlet extends HttpServlet {


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
       String url = "/index.jsp";

        // get current action
        String action = request.getParameter("action");

        if (action == null) {
            action = "input";  // default action
        }

        // if comes from another source, redirect to index.jsp
        if (action.equals("input")) {
            url = "/index.jsp";
        } // if comes from form, extract info, add to request, send to 
          // "submitted" page
        else if (action.equals("checkout")) {
            // direct to confirm.jsp
            url = "/confirm.jsp";
//            ArrayList<User> users = UserDB.getUsers();
//            System.out.println(users.get(0));
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String bookTitle = request.getParameter("bookTitle");

            // store data in Bean object
            User user = new User(firstName, lastName, email, bookTitle);

            // set Bean object in request object
            request.setAttribute("user", user);

        } else if (action.equals("display")) {
            url = "/manage.jsp";
           
            ArrayList<User> users = UserDB.getUsers();
            
            request.setAttribute("users", users);
        }
        
        getServletContext().getRequestDispatcher(url).
                forward(request, response);

  }
  
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        doPost(request, response);
  }

}
