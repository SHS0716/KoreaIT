package com.koreait.vo;

import java.util.Arrays;

public class MemberVO {
	
	private int idx;						// 회원 번호
	private String id;						// ID
	private String password;				// PW
	private String name;					// 이름
	private String gender;					// 성별
	private String email;					// 이메일
	private String phone;					// 휴대폰번호
	private String dateofbirthday;			// 생년월일
	
	public MemberVO() { }

	public MemberVO(int idx, String id, String password, String name, String gender, String email, String phone, String dateofbirthday) {
		super();
		this.idx = idx;
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.dateofbirthday = dateofbirthday;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender.equals("true") ? "남자" : "여자";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDateofbirthday() {
		return dateofbirthday;
	}
	public void setDateofbirthday(String dateofbirthday) {
		this.dateofbirthday = dateofbirthday;
	}
	@Override
	public String toString() {
		return "MemberVO [idx=" + idx + ", id=" + id + ", password=" + password + ", name=" + name + ", gender="
				+ gender + ", email=" + email + ", phone=" + phone + ", dateofbirthday=" + dateofbirthday + "]";
	}
	
	
}
