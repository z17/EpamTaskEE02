package servlets;

import tariffs.Tariff;
import tariffs.TariffWorker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


    private void processRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id;
        boolean deleteStatus = false;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            deleteStatus = TariffWorker.delete(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        request.setAttribute("deleteStatus", deleteStatus);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/delete.jsp");
        requestDispatcher.forward(request, response);
    }
}
