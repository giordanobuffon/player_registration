package br.edu.ifrs.restinga;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Processing", urlPatterns = {"/Processing"})
public class Processing extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Processamento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Esta funcionalidade não está disponível para o método GET. </h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("successfully_registered.jsp");

        if (Integer.parseInt(request.getParameter("age")) < 18 || Integer.parseInt(request.getParameter("age")) > 36) {
            String error = "A idade deve ser maior que 18 e menor que 36 anos. Tente novamente!";
            request.setAttribute("error_message", error);
            requestDispatcher = request.getRequestDispatcher("registration_failed.jsp");
        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/player_registration", "root", "2534");

                PreparedStatement ps = conn.prepareStatement("INSERT INTO player_registration.players (name, team, height, weight, age) VALUES (?, ?, ?, ?, ?)");
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("team"));
                ps.setFloat(3, Float.parseFloat(request.getParameter("height")));
                ps.setFloat(4, Float.parseFloat(request.getParameter("weight")));
                ps.setInt(5, Integer.parseInt(request.getParameter("age")));

                ps.execute();

                ps.close();
                conn.close();
            } catch (Exception e) {
                String error = "Falha no cadastro! (" + e.getMessage() + ") Tente novamente!";
                request.setAttribute("error_message", error);
                requestDispatcher = request.getRequestDispatcher("registration_failed.jsp");
            }
        }
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
