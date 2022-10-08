package com.board.boardprac.dto;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Setter @Getter
@Data  // 왼쪽 structure 탭에서 outline 확인 가능 
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
		
	@Override
	public String toString() {
		return "Member DTO : name=" + name 
				+ ", email=" + email + ", org=" + organization;
	}
}
