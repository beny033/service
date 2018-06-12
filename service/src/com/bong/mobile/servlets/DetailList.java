package com.bong.mobile.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bong.mobile.model.MobileDAO;

@WebServlet("/details")
public class DetailList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MobileDAO dao;
	
    public DetailList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int job_id = Integer.parseInt(request.getParameter("job_id"));
		
		dao = new MobileDAO();
		String[] jobsInfo = dao.jobsInfo(job_id);
		request.setAttribute("job_id", job_id);
		request.setAttribute("identifier", jobsInfo[0]);
		request.setAttribute("status", jobsInfo[1]);
		request.setAttribute("customer", jobsInfo[2]);
		request.setAttribute("address", jobsInfo[3]);
		request.setAttribute("city", jobsInfo[4]);
		request.setAttribute("state", jobsInfo[5]);
		request.setAttribute("zip", jobsInfo[6]);
		request.setAttribute("product", jobsInfo[7]);
		request.setAttribute("product_url", jobsInfo[8]);
		request.setAttribute("comments", jobsInfo[9]);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("mobile/DetailList.jsp");
		dispatcher.forward(request, response);
		
	}

}
