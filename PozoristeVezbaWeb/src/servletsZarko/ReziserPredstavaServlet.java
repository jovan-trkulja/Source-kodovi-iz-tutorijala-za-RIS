package servletsZarko;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Glumac;
import model.Predstava;
import model.Uloga;

/**
 * Servlet implementation class ReziserPredstavaServlet
 */
@WebServlet("/ReziserPredstavaServlet")
public class ReziserPredstavaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReziserPredstavaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idPredstava = Integer.parseInt(request.getParameter("idP"));
		
		Predstava p = Controller.getPredstava(idPredstava);
		List<Glumac> glumci = Controller.getGlumciZaPredstavu(idPredstava);
		List<Uloga> uloge = Controller.getUloge(idPredstava);
		
		request.getSession().setAttribute("glumci", glumci);
		request.getSession().setAttribute("uloge", uloge);
		request.getSession().setAttribute("p", p);
		
		request.getRequestDispatcher("/zarkovZadatak/prikazGlumci.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
