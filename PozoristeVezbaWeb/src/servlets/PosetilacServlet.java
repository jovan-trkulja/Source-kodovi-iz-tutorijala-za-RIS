package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Posetilac;

/**
 * Servlet implementation class PosetilacServlet
 */
@WebServlet("/PosetilacServlet")
public class PosetilacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PosetilacServlet() {
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
		
		String ime = request.getParameter("imeP");
		String prezime = request.getParameter("prezimeP");
		
		Posetilac p = Controller.addPosetilac(ime, prezime);
		
		if(p != null) {
			
			request.getSession().setAttribute("posetilac", p);

		} else {
			
			request.getSession().setAttribute("neuspesno", true);
			
		}
		
		request.getRequestDispatcher("/unosPosetioca.jsp")
		   .forward(request, response);
	}

}
