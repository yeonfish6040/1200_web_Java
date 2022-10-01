package com.Spring.board.dto;

public class MemberDto {
	private String name;
	private String email;
	private String organization;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getOrganization() {return organization;}
	public void setOrganization(String organization) {this.organization = organization;}
	
	public String toString() {
		return "Member DTO : name="+name+
				", email="+email+", organization="+organization;
	}
}
