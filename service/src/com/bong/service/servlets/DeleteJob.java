package com.bong.service.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bong.service.model.ServiceDAO;

@WebServlet("/deletejob")
public class DeleteJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ServiceDAO dao;
	
    public DeleteJob() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int job_id = Integer.parseInt(request.getParameter("job_id"));
		String identifier = request.getParameter("id");
		
		dao = new ServiceDAO();
		dao.jobDelete(job_id);

		request.setAttribute("identifier", identifier);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/DeleteJobResult.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
