package servletsPrimerKLK;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Karta;
import model.Posetilac;

/**
 * Servlet implementation class IdPosetilacServlet
 */
@WebServlet("/IdPosetilacServlet")
public class IdPosetilacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdPosetilacServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idPosetilac = Integer.parseInt(request.getParameter("idPosetilac"));
		
		Posetilac p = Controller.getPosetilac(idPosetilac);
		
		if(p != null) {
			
			List<Karta> karte = Controller.getRezervisaneKarte(idPosetilac);
			request.getSession().setAttribute("posetilac", p);
			request.getSession().setAttribute("karte", karte);
			request.getRequestDispatcher("/primeriPrviKLK/PosetilacId.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("neuspesno", true);
			request.getRequestDispatcher("/primeriPrviKLK/PosetilacId.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
