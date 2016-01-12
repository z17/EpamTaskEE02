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

@WebServlet("/edit")
public class Edit extends HttpServlet {
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
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0; // 0 id в БД не будет (id начинаются с 1)
        }

        String submit = request.getParameter("submit");
        if (submit != null && id != 0) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String strMinutePrice = request.getParameter("minute_price");
            String strMonthPrice = request.getParameter("month_price");
            Tariff tariff = Tariff.newInstance(id, name, description, strMinutePrice, strMonthPrice);

            if (tariff != null) {
                boolean updateStatus = TariffWorker.update(tariff);
                request.setAttribute("updateStatus", updateStatus);
                request.setAttribute("validForm", true);
            } else {
                request.setAttribute("validForm", false);
            }
        }

        Tariff tariff = TariffWorker.get(id);
        request.setAttribute("tariff", tariff);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/edit.jsp");
        requestDispatcher.forward(request, response);
    }
}
