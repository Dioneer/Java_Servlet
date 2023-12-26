package pegas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name="helloServlet", value ="/hello-servlet")
public class FirstServlet extends HttpServlet {
    private String message;
    @Override
    public void init(){
        message = "Hello World!";
        System.out.println("init");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if(cart==null){
            cart = new Cart(name, quantity);
        }
        session.setAttribute("cart", cart);
        Integer count = (Integer) session.getAttribute("count");
        if(count == null){
            count = 1;
            session.setAttribute("count", count);
        }else{
            session.setAttribute("count",++count);
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        response.setHeader("MY_HEADER", "hi");
        out.println("<html><body>");
        out.println("<h1>" +message+"</h1>");
        String header = request.getHeader("user-agent");
        out.println("<h2>"+header+"<h2>");
        out.println("<h2> Your count is: "+count+"<h2>");
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()){
//            String s = headerNames.nextElement();
//            out.println("<p>"+s+" : "+request.getHeader(s)+"<p>");
//        }
        getServletContext().getRequestDispatcher("/shop.jsp").forward(request,response);
        out.println("</body></html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>"+request.getParameter("login")+"</p>");
        out.println("<p>"+request.getParameter("password")+"</p>");
    }
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.service(request,response);
//    }
    @Override
    public void destroy(){
        System.out.println("destroy");
    }
}
