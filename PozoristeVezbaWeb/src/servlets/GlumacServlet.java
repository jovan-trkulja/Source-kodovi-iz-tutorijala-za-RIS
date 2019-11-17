package servlets;

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

/**
 * Servlet implementation class GlumacServlet
 */
@WebServlet("/GlumacServlet")
public class GlumacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlumacServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ime = request.getParameter("imeG");
		String prezime = request.getParameter("prezG");
		String jmbg = request.getParameter("jmbg");
		
		Glumac g = Controller.addGlumac(ime, prezime, jmbg);
		
		if(g != null) {
			
			List<Predstava> lista = Controller.getSvePredstave();
			
			request.getSession().setAttribute("glumac", g);
			request.getSession().setAttribute("listaPredstave", lista);
			
			request.getRequestDispatcher("/unosUloge.jsp").forward(request, response);
			
		} else {
			
			request.getSession().setAttribute("greska", true);
			
			request.getRequestDispatcher("/unosGlumca.jsp").forward(request, response);
		}
		
	}

}
