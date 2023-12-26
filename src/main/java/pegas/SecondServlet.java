package pegas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name="secondServlet", value ="/second-servlet")

public class SecondServlet extends HttpServlet {
    public void init(){}
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String param1 = request.getParameter("param1");
        PrintWriter out = response.getWriter();
        out.println("<h1>" +param1+"</h1>");
        Map<String,String[]> parametrMap = request.getParameterMap();
        parametrMap.entrySet().forEach(i-> out.println("<p>"+i.getKey()+" : "+i.getValue()+"</p>"));
//        response.sendRedirect("https://www.google.com");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Back</h1>");
        out.println("<a href=\"hello-servlet\">Hello servlet</a>");
    }
    public void destroy(){}
}
