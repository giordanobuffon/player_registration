package br.edu.ifrs.restinga;

import br.edu.ifrs.modelo.bean.Player;
import br.edu.ifrs.modelo.dao.PlayerDAO;

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

@WebServlet(name = "ProcessingInsertPlayer", urlPatterns = {"/ProcessingInsertPlayer"})
public class ProcessingInsertPlayer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Player player = new Player();

            player.setName(request.getParameter("name"));
            player.setTeam(request.getParameter("team"));
            player.setHeight(Double.parseDouble(request.getParameter("height")));
            player.setWeight(Double.parseDouble(request.getParameter("weight")));
            player.setAge(Integer.parseInt(request.getParameter("age")));

            PlayerDAO.insert(player);
        } catch (Exception e) {
            request.setAttribute("exc", e);
            RequestDispatcher r = request.getRequestDispatcher("error.jsp");
            r.forward(request, response);
        }

        RequestDispatcher r = request.getRequestDispatcher("successfully_registered.jsp");
        r.forward(request, response);
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
