package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountService();
        
         String path = getServletContext().getRealPath("/WEB-INF");
        if(accountService.forgotPassword(request.getParameter("email"), path)) {
            request.setAttribute("message", "If the address you entered is value, you will recieve an email very soon. Please check your email for your password");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
   
    }
}
