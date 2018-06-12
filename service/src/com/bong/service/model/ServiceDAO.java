package com.bong.service.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ServiceDAO() {
       	try {
    			Class.forName("com.mysql.jdbc.Driver");
    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/service","root","9217");
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
	}
	
	public List<ServiceDTO> showJobs(String identifier) {
		try {
			String sql = "SELECT * FROM JOBS WHERE IDENTIFIER = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, identifier);
			rs = pstmt.executeQuery();
			
			List<ServiceDTO> list = new ArrayList<ServiceDTO>();
			
				if(rs.isBeforeFirst()){
					while(rs.next()) {
						ServiceDTO dto = new ServiceDTO();
						dto.setJob_id(rs.getInt("JOB_ID"));
						dto.setIdentifier(rs.getString("IDENTIFIER"));
						dto.setState(rs.getString("STATE"));
						dto.setAddress(rs.getString("ADDRESS"));
						dto.setCity(rs.getString("CITY"));
						dto.setStatus(rs.getString("STATUS"));
						dto.setZip(rs.getString("ZIP"));
						dto.setCustomer(rs.getString("CUSTOMER"));
						dto.setProduct(rs.getString("PRODUCT"));
						dto.setProductURL(rs.getString("PRODUCT_URL"));
						dto.setComments(rs.getString("COMMENTS"));
						list.add(dto);
					}
					return list;
				} else {
					return null;
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{if(rs != null) rs.close();} catch(Exception e) {}
			try{if(pstmt != null) pstmt.close();} catch(Exception e) {}
		}
		return null;
	}
	
	public void jobInsert(ServiceDTO dto) {
		try {
			String sql = "INSERT INTO JOBS(IDENTIFIER,CUSTOMER,ADDRESS,CITY,STATE,ZIP,PRODUCT,PRODUCT_URL,COMMENTS)" +
					" VALUES(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getIdentifier());
			pstmt.setString(2, dto.getCustomer());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getCity());
			pstmt.setString(5, dto.getState());
			pstmt.setString(6, dto.getZip());
			pstmt.setString(7, dto.getProduct());
			pstmt.setString(8, dto.getProductURL());
			pstmt.setString(9, dto.getComments());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{if(pstmt != null) pstmt.close();} catch(Exception e) {}
		}
		
	}
	
	public String[] jobsInfo(int job_id) {
		try {
			String sql = "SELECT * FROM JOBS WHERE JOB_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, job_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String[] jobsInfo = { 
							rs.getString("IDENTIFIER"), rs.getString("STATUS"), rs.getString("CUSTOMER"),
							rs.getString("ADDRESS"), rs.getString("CITY"), rs.getString("STATE"), rs.getString("ZIP"), 
							rs.getString("PRODUCT"),  rs.getString("PRODUCT_URL"), rs.getString("COMMENTS")};
				
				return jobsInfo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{if(rs != null) rs.close();} catch(Exception e) {}
			try{if(pstmt != null) pstmt.close();} catch(Exception e) {}
		}
		
		return null;
	}
	
	public void jobUpdate(ServiceDTO dto) {
		try {
			String sql = "UPDATE JOBS SET STATUS = ?, CUSTOMER = ?, ADDRESS = ?, CITY = ?, STATE = ?, ZIP = ?," + 
						" PRODUCT = ?, PRODUCT_URL = ?, COMMENTS = ? WHERE JOB_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getStatus());
			pstmt.setString(2, dto.getCustomer());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getCity());
			pstmt.setString(5, dto.getState());
			pstmt.setString(6, dto.getZip());
			pstmt.setString(7, dto.getProduct());
			pstmt.setString(8, dto.getProductURL());
			pstmt.setString(9, dto.getComments());
			pstmt.setInt(10, dto.getJob_id());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{if(pstmt != null) pstmt.close();} catch(Exception e) {}
		}
	}
	
	public void jobDelete(int job_id) {
		try {
			String sql = "DELETE FROM JOBS WHERE JOB_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, job_id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{if(pstmt != null) pstmt.close();} catch(Exception e) {}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
