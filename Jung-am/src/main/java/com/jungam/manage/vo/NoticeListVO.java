package com.jungam.manage.vo;

public class NoticeListVO {
	int index;
	String title;
	String writer;
	String content;
	int hitCount;
	
	public int getIndex() {
		return index;
	}
	public String getTitle() {
		return title;
	}
	public String getWriter() { 
		return writer;
	}
	public String getContent() {
		return content;
	}
	public int getHitCount() {
		return hitCount;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
}
