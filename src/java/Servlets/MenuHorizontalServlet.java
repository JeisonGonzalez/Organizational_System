package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Jeison González Cifuentes
 */

public class MenuHorizontalServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        if (session.getAttribute("correoInSession") != null && !session.getAttribute("correoInSession").equals("") && session.getAttribute("claveInSession") != null && !session.getAttribute("claveInSession").equals("")) {
            String submit = request.getParameter("submit");
            if (submit != null && !submit.isEmpty()) {
                switch (submit) {
                    case "cerrarSesion":
                        {
                            session.setAttribute("correoInSession", null);
                            session.setAttribute("claveInSession", null);
                            request.getRequestDispatcher("/index.jsp").forward(request, response);
                            break;
                        }
                }
            } else {
                request.setAttribute("userSessionName", session.getAttribute("userSessionName"));
            }
        } else {
            session.setAttribute("correoInSession", null);
            session.setAttribute("claveInSession", null);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        
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
