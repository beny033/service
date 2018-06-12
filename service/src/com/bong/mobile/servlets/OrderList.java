package com.bong.mobile.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bong.mobile.model.MobileDAO;
import com.bong.mobile.model.MobileDTO;

@WebServlet("/orderlist")
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MobileDAO dao;
	
    public OrderList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String identifier = request.getParameter("identifier");
		
		dao = new MobileDAO();
		int count = dao.jobCount(identifier);

		List<MobileDTO> list = dao.showJobs(identifier);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mobile/OrderList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
