package servlets;

import java.io.IOException;

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
 * Servlet implementation class UnosUlogeServlet
 */
@WebServlet("/UnosUlogeServlet")
public class UnosUlogeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosUlogeServlet() {
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
		
		String nazivUloge = request.getParameter("nazUloge");
		Integer idPredstava = Integer.parseInt(request.getParameter("predstave"));
		
		Glumac g = (Glumac)request.getSession().getAttribute("glumac");
		
		Predstava p = Controller.getPredstava(idPredstava);
		
		Uloga u = Controller.addUloga(nazivUloge, g, p);

		request.getSession().setAttribute("uloga", u);
		request.getRequestDispatcher("/ispis.jsp").forward(request, response);
		
	}

}
