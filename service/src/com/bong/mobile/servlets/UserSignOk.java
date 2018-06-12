package com.bong.mobile.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bong.mobile.model.MobileDAO;

@WebServlet("/signok")
public class UserSignOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MobileDAO dao;
	
    public UserSignOk() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int job_id = Integer.parseInt(request.getParameter("job_id"));
		
		dao = new MobileDAO();
		dao.signResult(job_id);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('배송이 완료되었습니다.');");
		out.println("</script>");
		
		request.setAttribute("job_id", job_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("details");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
}
