<%-- 
    Document   : thanks
    Created on : Mar 5, 2022
    Author     : Natasha Borzakovskaia
--%>

<%@page import="edu.nbcc.user.User"%>
<%@page import="edu.nbcc.user.IUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AddToEmailListServlet</title>
    </head>
    <body>
        
        <h1>Thanks for joining our email list using MVC</h1>
        <p>Here is the information that you entered:</p>

        <p>${counter}</p>
        
        <table cellspacing="5" cellpadding="5" border="1">
            <tr>
                <td align="right">First name:</td>
                <td>${user.firstName}</td>
            </tr>
            <tr>
                <td align="right">Last name:</td>
                <td>${user.lastName}</td>
            </tr>
            <tr>
                <td align="right">Email Address:</td>
                <td>${user.emailAddress}</td>
            </tr>
        </table>
        <h2>
            To enter another email address, click on the Back <br>
            button in your browser or the Return button shown <br>
            below.
        </h2>
        <form action="index.jsp" method="post">
            <input type="submit" value="Return">
        </form>   
    </body>
</html>

