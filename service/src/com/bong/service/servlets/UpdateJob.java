package com.bong.service.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bong.service.model.ServiceDAO;
import com.bong.service.model.ServiceDTO;

@WebServlet("/updatejob")
public class UpdateJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ServiceDAO dao;
	
    public UpdateJob() {
        super();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
    	int job_id = Integer.parseInt(request.getParameter("job_id"));
    	
    	dao = new ServiceDAO();

    	String[] jobsinfo = dao.jobsInfo(job_id);
    		request.setAttribute("job_id", job_id);
    		request.setAttribute("identifier", jobsinfo[0]);
    		request.setAttribute("status", jobsinfo[1]);
    		request.setAttribute("customer", jobsinfo[2]);
    		request.setAttribute("address", jobsinfo[3]);
    		request.setAttribute("city", jobsinfo[4]);
    		request.setAttribute("state", jobsinfo[5]);
    		request.setAttribute("zip", jobsinfo[6]);
    		request.setAttribute("product", jobsinfo[7]);
    		request.setAttribute("product_url", jobsinfo[8]);
    		request.setAttribute("comments", jobsinfo[9]);
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("view/UpdateJob.jsp");
    		dispatcher.forward(request, response);

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
    	String identifier = request.getParameter("id");
    	int job_id = Integer.parseInt(request.getParameter("job_id"));
    	String status = request.getParameter("status");
    	String customer = request.getParameter("customer");
    	String address = request.getParameter("address");
    	String city = request.getParameter("city");
    	String state = request.getParameter("state");
    	String zip = request.getParameter("zip");
    	String product = request.getParameter("product");
    	String productURL = request.getParameter("producturl");
    	String comments = request.getParameter("comments");
    	
    	ServiceDTO dto = new ServiceDTO();
    	dto.setJob_id(job_id);
    	dto.setIdentifier(identifier);
    	dto.setStatus(status);
    	dto.setCustomer(customer);
    	dto.setAddress(address);
    	dto.setCity(city);
    	dto.setState(state);
    	dto.setZip(zip);
    	dto.setProduct(product);
    	dto.setProductURL(productURL);
    	dto.setComments(comments);
    	
    	dao = new ServiceDAO();
    	dao.jobUpdate(dto);
    	
    	request.setAttribute("identifier", dto.getIdentifier());
    	RequestDispatcher dispatcher = request.getRequestDispatcher("view/UpdateJobResult.jsp");
    	dispatcher.forward(request, response);
    }
}