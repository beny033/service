package com.bong.service.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bong.service.model.ServiceDAO;
import com.bong.service.model.ServiceDTO;

@WebServlet("/showjobs")
public class ShowJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceDAO dao;
	
    public ShowJobs() {
        super();

    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String identifier = request.getParameter("id");
		
		dao = new ServiceDAO();
		List<ServiceDTO> list = dao.showJobs(identifier);
		
		HttpSession session = request.getSession();
		session.setAttribute("identifier", identifier);
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/ShowJobs.jsp");
		dispatcher.forward(request, response);
	}
}
