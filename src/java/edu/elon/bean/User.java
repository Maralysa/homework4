/* 2016 © Lane Peeler & Jasmine Jones */

package edu.elon.bean;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String bookTitle;
    private Date dueDate;
    
    public User() {
    firstName = "";
    lastName = "";
    email = "";
    bookTitle = "";
    dueDate = null;
    }
    
    public User(String first, String last, String eml, String book) {
    firstName = first;
    lastName = last;
    email = eml;
    bookTitle = book;
    dueDate = calculateDueDate();
    }
    
    private Date calculateDueDate() {
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.WEEK_OF_YEAR, 2);
        return new java.sql.Date(cal.getTime().getTime());
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
}
