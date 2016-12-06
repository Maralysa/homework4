/* 2016 © Lane Peeler & Jasmine Jones */

package edu.elon.bean;

import edu.elon.data.UserDB;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String bookTitle;
    private Date dueDate;
    private boolean overdue;
    
    public User() {
    firstName = "";
    lastName = "";
    email = "";
    bookTitle = "";
    dueDate = null;
    overdue = false;
    }
    
    public User(String first, String last, String eml, String book) {
    firstName = first;
    lastName = last;
    email = eml;
    bookTitle = book;
    dueDate = calculateDueDate();
    overdue = reallyOverdue();
    }
    
    private Date calculateDueDate() {
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.WEEK_OF_YEAR, 2);
        
        Date date = cal.getTime();
        
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        
        return sqlDate;
    }
    
    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String formatted = sdf.format(dueDate);
        return formatted;
    }
    
    public boolean reallyOverdue() {
        Calendar cal = GregorianCalendar.getInstance();
        Date today = cal.getTime();
        if (today.after(dueDate)) {
            return true;
        }
        return false;
    }
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the bookTitle
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * @param bookTitle the bookTitle to set
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the overdue
     */
    public boolean isOverdue() {
        return overdue;
    }
    
    /**
     * @param overdue the overdue to set
     */
    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    
    
}
