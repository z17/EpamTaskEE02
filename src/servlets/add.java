package servlets;

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
        request.setCharacterEncoding("UTF-8");

        String submit = request.getParameter("submit");

        if (submit != null) {
            int minutePrice = 0;
            int monthPrice = 0;
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            boolean validIn = true;
            try {
                minutePrice = Integer.parseInt(request.getParameter("minute_price"));
                monthPrice = Integer.parseInt(request.getParameter("month_price"));
            } catch (NumberFormatException e) {
                validIn = false;
            }
            if (name == null || description == null || minutePrice < 0 || monthPrice < 0) {
                validIn = false;
            }
            request.setAttribute("validForm", validIn);

            if (validIn) {
                boolean insertStatus = TariffWorker.add(name, description, minutePrice, monthPrice);
                request.setAttribute("insertStatus", insertStatus);
            }
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/add.jsp");
        requestDispatcher.forward(request, response);
    }
}
