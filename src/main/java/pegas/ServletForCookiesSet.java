package pegas;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="cookies-set", value ="/cookies_set")
public class ServletForCookiesSet extends HttpServlet {
    public void init(){}
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie1 = new Cookie("id","123456");
        Cookie cookie2 = new Cookie("name","Tom");
        cookie1.setMaxAge(24*60*60);
        cookie2.setMaxAge(24*60*60);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
    public void destroy(){
        System.out.println("destroy");
    }
}
