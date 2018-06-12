package com.bong.service.model;

public class ServiceDTO {

	private int job_id;
	private String status;
	private String identifier;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String customer;
	private String product;
	private String productURL;
	private String comments;
	
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getProductURL() {
		return productURL;
	}
	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	 
	@Override
	public String toString() {
		return "<td>" + "<a href=updatejob?job_id="+job_id+">" + job_id +"</a>" +"</td> <td>" + 
				customer + "</td> <td>" + address + "</td> <td>" + city + "</td> <td>" + state + "</td> <td>" + zip + "</td> <td>" + product + "</td> <td>" +
				productURL + "</td> <td>" + comments + "</td> <td>" + status + "</td>";
	}
	
	
}
