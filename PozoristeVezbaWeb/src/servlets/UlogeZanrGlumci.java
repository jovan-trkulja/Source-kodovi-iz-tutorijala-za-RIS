package servlets;

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
 * Servlet implementation class UlogeZanrGlumci
 */
@WebServlet("/UlogeZanrGlumci")
public class UlogeZanrGlumci extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UlogeZanrGlumci() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idPredstava = Integer.parseInt(request.getParameter("idPredstava"));
		
		List<Uloga> uloge = Controller.getUlogeZaPredstavu(idPredstava);
		
		request.getSession().setAttribute("uloge", uloge);
		request.getRequestDispatcher("/pripremaKLK/ispisGlumciUloga.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
