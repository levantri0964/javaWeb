package vantri.ued.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vantri.ued.model.Book;
import vantri.ued.model.BookDAO;

/**
 * Servlet implementation class Load
 */
@WebServlet(description = "Load", urlPatterns = { "/Load" })
public class Load extends HttpServlet {
	private static final long serialVersionUID = 1L;
  BookDAO bd=new BookDAO();
    /**
     * Default constructor. 
     */
    public Load() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getServletPath();
	
		try {
			switch(action) {
			case "/list":listbook(request,response);break;
			default:listbook(request,response);break;
			}
		}catch(Exception e) {
			System.out.println("Loi doGet "+e);
		}
		System.out.println(action);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void listbook(HttpServletRequest request,HttpServletResponse response)
	throws SQLException, IOException, ServletException{
		List<Book> book=new ArrayList<Book>();
		book=bd.listALL();
		request.setAttribute("book",book);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/BookList.jsp");
		dispatcher.forward(request, response);
	}
	public void hienthi(HttpServletRequest request,HttpServletResponse response)
    throws SQLException, Exception,ServletException{
		
	}
}
