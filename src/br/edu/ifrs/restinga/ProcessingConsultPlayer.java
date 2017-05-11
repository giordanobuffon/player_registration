package br.edu.ifrs.restinga;

import br.edu.ifrs.modelo.bean.Player;
import br.edu.ifrs.modelo.dao.PlayerDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProcessingConsultPlayer", urlPatterns = {"/ProcessingConsultPlayer"})
public class ProcessingConsultPlayer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Player player = new Player();

            player.setName(request.getParameter("name"));
            player.setTeam(request.getParameter("team"));

            Player[] players = PlayerDAO.consult(player);
            request.setAttribute("players", players);
        } catch (Exception e) {
            request.setAttribute("exc", e);
            RequestDispatcher r = request.getRequestDispatcher("error.jsp");
            r.forward(request, response);
        }

        RequestDispatcher r = request.getRequestDispatcher("list_registered_players.jsp");
        r.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
