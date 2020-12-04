package com.koreait.vo;

import java.util.Arrays;

public class InterestVO {
	
	private int interidx;				// 관심분야 번호
	private String id;					// ID
	private String interests;			// 관심분야 String값
	private String[] interests_list;	// 관심분야 배열
	
	public InterestVO() { }
	public InterestVO(int interidx, String id, String interests) {
		this.interidx = interidx;
		this.id = id;
		this.interests = interests;
	}

	public int getInteridx() {
		return interidx;
	}
	public void setInteridx(int interidx) {
		this.interidx = interidx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String[] getInterests_list() {
		return interests_list;
	}
	public void setInterests_list(String[] interests_list) {
		this.interests_list = interests_list;
	}
	
	@Override
	public String toString() {
		return "InterestVO [interidx=" + interidx + ", id=" + id + ", interests=" + interests + ", interests_list="
				+ Arrays.toString(interests_list) + "]";
	}

	
}
