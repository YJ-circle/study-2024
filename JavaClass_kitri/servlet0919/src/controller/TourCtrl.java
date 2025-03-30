package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TourDto;
import service.TourSvc;
import view.View;

@WebServlet("/tour")
public class TourCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int maxImageSeq = 3;
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		TourDto tour;
		try {
			String selParameter = req.getParameter("imgnum");

			if (selParameter == null) {
				return;
			}
			int select = Integer.parseInt(selParameter);
			int nextInt = select + 1;
			if (nextInt > maxImageSeq) {
				nextInt -= maxImageSeq +1;
			}
			int previousInt = select - 1;
			if (previousInt < 0) {
				previousInt += maxImageSeq +1;
			}

			tour = new TourSvc().getTour(select);
			req.setAttribute("tour", tour);
			req.setAttribute("next", nextInt);
			req.setAttribute("previous", previousInt);
			new View("/WEB-INF/views/tour.jsp").render(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
