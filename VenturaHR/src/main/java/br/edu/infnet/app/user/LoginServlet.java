package br.edu.infnet.app.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/user/login"})
public class LoginServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String inbox = "";
        String email = request.getRemoteUser();
        request.setAttribute("email", email); // acessar o microserviço de usuario
        
        if(request.isUserInRole("company")) {
            inbox = "/company/index.jsp";
        } else if (request.isUserInRole("candidate")) {
            inbox = "/candidate/index.jsp";
        } else {
            inbox = "/administrator/index.jsp";
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(inbox);
        rd.forward(request, response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
