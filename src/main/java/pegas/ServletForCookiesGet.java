package pegas;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="cookies-get", value ="/cookies_get")
public class ServletForCookiesGet extends HttpServlet {
    public void init(){}
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>");
        for (Cookie item : cookies) {
            pw.println("<p>"+item.getName()+" : "+item.getValue()+"<p>");
        }
        pw.println("</body></html>");
    }
    public void destroy(){
        System.out.println("destroy");
    }
}
