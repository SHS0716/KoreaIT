package com.koreait.vo;

import java.util.Date;

public class BoardVO {

	private int bidx;			// 게시글 번호
	private String name;		// 작성자 이름
	private String category;	// 카테고리
	private int ref;			// 카테고리 번호
	private String subject;		// 글 제목
	private String content;		// 글 내용
	private Date writeDate;		// 작성일
	private int hit;			// 조회수
	private int replycnt;		// 댓글수
	
	public BoardVO() { }
	public BoardVO(String name, String category, int ref, String subject, String content) {
		super();
		this.name = name;
		this.category = category;
		this.ref = ref;
		this.subject = subject;
		this.content = content;
	}
	public int getBidx() {
		return bidx;
	}
	public void setBidx(int bidx) {
		this.bidx = bidx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bidx=" + bidx + ", name=" + name + ", category=" + category + ", ref=" + ref + ", subject="
				+ subject + ", content=" + content + ", writeDate=" + writeDate + ", hit=" + hit + ", replycnt="
				+ replycnt + "]";
	}
	
	
	
}
