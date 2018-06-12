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

@WebServlet("/addjob")
public class AddJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ServiceDAO dao;
	
    public AddJob() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String identifier = request.getParameter("id");
		String customer = request.getParameter("customer");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String product = request.getParameter("product");
		String productURL = request.getParameter("producturl");
		String comments = request.getParameter("comments");

		dao = new ServiceDAO();

		ServiceDTO dto = new ServiceDTO();
		dto.setIdentifier(identifier);
		dto.setCustomer(customer);
		dto.setAddress(address);
		dto.setCity(city);
		dto.setState(state);
		dto.setZip(zip);
		dto.setProduct(product);
		dto.setProductURL(productURL);
		dto.setComments(comments);
			
		dao.jobInsert(dto);

		
		request.setAttribute("id", identifier);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/AddJobResult.jsp");
		dispatcher.forward(request, response);
		
	}

}
