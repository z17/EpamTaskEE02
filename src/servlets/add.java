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

@WebServlet("/add")
public class Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


    private void processRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String submit = request.getParameter("submit");

        if (submit != null) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String strMinutePrice = request.getParameter("minute_price");
            String strMonthPrice = request.getParameter("month_price");
            Tariff tariff = Tariff.newInstance(name, description, strMinutePrice, strMonthPrice);

            if (tariff != null) {
                boolean insertStatus = TariffWorker.add(tariff);
                request.setAttribute("insertStatus", insertStatus);
                request.setAttribute("validForm", true);
            } else {
                request.setAttribute("validForm", false);

            }
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/add.jsp");
        requestDispatcher.forward(request, response);
    }
}
