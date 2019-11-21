package servletsZarko;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Izvodjenje;

/**
 * Servlet implementation class IzvodjenjaScenaServlet
 */
@WebServlet("/IzvodjenjaScenaServlet")
public class IzvodjenjaScenaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzvodjenjaScenaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idScena = Integer.parseInt(request.getParameter("comboScene"));
		
		List<Izvodjenje> lista = Controller.getIzvodjenjaNaSceni(idScena);
		
		request.getSession().setAttribute("izvodjenja", lista);
		request.getRequestDispatcher("/zarkovZadatak/prikazIzvodjenje.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
