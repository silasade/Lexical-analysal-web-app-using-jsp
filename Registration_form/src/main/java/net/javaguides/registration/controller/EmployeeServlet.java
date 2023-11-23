// EmployeeServlet.java
package net.javaguides.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.dao.EmployeeDao;
import net.javaguides.registration.model.Employee;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmployeeDao employeeDao = new EmployeeDao();

    public EmployeeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeeregister.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String address = request.getParameter("address");
        String email_address = request.getParameter("email_address");
        String password = request.getParameter("password");
        String comment = request.getParameter("comment");
        String otherName = request.getParameter("OtherName");

        if (containsSuspiciousInput(firstName) || containsSuspiciousInput(lastName) || containsSuspiciousInput(otherName) ||
                containsSuspiciousInput(email_address) || containsSuspiciousInput(password) || containsSuspiciousInput(comment)) {
            sendAlertAndRedirect(response, "One of the inputs contains a SQL or JavaScript script!");
            return;
        }

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setOtherName(otherName);
        employee.setAddress(address);
        employee.setComment(comment);
        employee.setEmail_address(email_address);
        employee.setPassword(password);

        try {
            boolean registrationSuccessful = employeeDao.registerEmployee(employee);
            if (registrationSuccessful) {
                sendAlertAndRedirect(response, "Registration successful!");
            } else {
                sendAlertAndRedirect(response, "Registration failed. Please try again.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            sendAlertAndRedirect(response, "An error occurred during registration. Please try again.");
        }
    }

    private void sendAlertAndRedirect(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<script>");
        out.println("alert('" + message + "');");
        out.println("window.location.href = '/Registration_form/register';");
        out.println("</script>");
        out.close();
    }

    private boolean containsSuspiciousInput(String input) {
        // Define regular expressions to detect SQL queries, JavaScript, and common programming keywords
        String sqlPattern = ".*\\b(SELECT|INSERT|UPDATE|DELETE|FROM|WHERE|OR|AND|CREATE|DROP|ALTER|EXEC|INTO|VALUES|UNION|ORDER BY|GROUP BY|HAVING|TRUNCATE|DECLARE|DECLARE @|xp_cmdshell|sp_executesql)\\b.*";
        String javascriptPattern = ".*<\\s*script\\s*\\b[^>]*>|.*javascript:.*|.*\\balert\\b.*|.*\\bconfirm\\b.*|.*\\bprompt\\b.*|.*\\bconsole\\b.*|.*\\bdocument\\b.*|.*\\blocation\\b.*|.*\\beval\\b.*|.*\\bFunction\\b.*|.*\\bsetTimeout\\b.*|.*\\bsetInterval\\b.*|.*\\bsetImmediate\\b.*|.*\\bexecCommand\\b.*|.*\\bexecScript\\b.*|.*\\bmsSetImmediate\\b.*|.*\\brange\\.createContextualFragment\\b.*|.*\\bcrypto\\.generateCRMFRequest\\b.*|.*<\\s*SCRIPT\\s*>.*|.*<\\s*OBJECT\\s*>.*|.*<\\s*APPLET\\s*>.*|.*<\\s*EMBED\\s*>.*|.*<\\s*FK\\s*>.*|.*<\\s*LI\\s*>.*|.*<\\s*BR\\s*>.*|.*<\\s*DIV\\s*>.*|.*<\\s*TITLE\\s*>.*|\\b(let|const|var)\\b.*|\\/\\*.*?\\*\\/|\\/\\/.*";

        Pattern sqlRegex = Pattern.compile(sqlPattern, Pattern.CASE_INSENSITIVE);
        Pattern javascriptRegex = Pattern.compile(javascriptPattern, Pattern.CASE_INSENSITIVE);
        
        Matcher sqlMatcher = sqlRegex.matcher(input);
        Matcher javascriptMatcher = javascriptRegex.matcher(input);
        
        return sqlMatcher.find() || javascriptMatcher.find();
    }

   
}
