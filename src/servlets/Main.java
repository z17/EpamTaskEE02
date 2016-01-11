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
import java.util.ArrayList;

@WebServlet("/index.jsp")
public class Main extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


    private void processRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ArrayList<Tariff> list = TariffWorker.get();
        request.setAttribute("tariffs", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/main.jsp");
        requestDispatcher.forward(request, response);
    }
}
