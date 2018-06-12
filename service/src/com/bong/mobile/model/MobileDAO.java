package com.bong.mobile.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MobileDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	 
	public MobileDAO() {
       	try {
    			Class.forName("com.mysql.jdbc.Driver");
    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/service","root","9217");
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
	}
	
	public int jobCount(String identifier) {
		try {
			String sql = "SELECT COUNT(*) AS JOB_ID FROM JOBS WHERE IDENTIFIER = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, identifier);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("JOB_ID");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{if(rs != null) rs.close();} catch(Exception e) {}
			try{if(pstmt != null) pstmt.close();} catch(Exception e) {}
		}
		return 0;
	}
	
	public List<MobileDTO> showJobs(String identifier) {
		try {
			String sql = "SELECT * FROM JOBS WHERE IDENTIFIER = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, identifier);
			rs = pstmt.executeQuery();
			
			List<MobileDTO> list = new ArrayList<MobileDTO>();
			
				if(rs.isBeforeFirst()){
					while(rs.next()) {
						MobileDTO dto = new MobileDTO();
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
	
	public void signResult(int job_id) {
		try {
			String sql = "UPDATE JOBS SET STATUS = ? WHERE JOB_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "CLOSE");
			pstmt.setInt(2, job_id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{if(pstmt != null) pstmt.close();} catch(Exception e) {}
		}
	}
	
	
	
}
