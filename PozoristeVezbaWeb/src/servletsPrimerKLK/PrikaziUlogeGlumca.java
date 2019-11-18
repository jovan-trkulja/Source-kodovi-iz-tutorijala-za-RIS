package servletsPrimerKLK;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Uloga;

/**
 * Servlet implementation class PrikaziUlogeGlumca
 */
@WebServlet("/PrikaziUlogeGlumca")
public class PrikaziUlogeGlumca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikaziUlogeGlumca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ime = request.getParameter("imeG");
		String prez = request.getParameter("prezG");
		
		List<Uloga> lista = Controller.getUloge(ime, prez);
		
		request.getSession().setAttribute("lista", lista);
		request.getRequestDispatcher("/primeriPrviKLK/prikazUloga.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
