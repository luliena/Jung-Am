package com.jungam.manage.vo;

import java.util.ArrayList;

public class BoardVO {
	// Board
	int index;
	String title;
	String writer;
	String content;
	String regiDate;
	int hitCount;
	
	// Files
	ArrayList<FileVO> files;
	
	// board files
	int fileNo;
	String path;
	String fileName;
	
	// not table mumbers
	int offset;
	int limit;
	
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
	public String getRegiDate() {
		return regiDate;
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
	public void setRegiDate(String regiDate) {
		this.regiDate = regiDate;
	}
	public int getFileNo() {
		return fileNo;
	}
	public String getPath() {
		return path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public ArrayList<FileVO> getFiles() {
		return files;
	}
	public void setFiles(ArrayList<FileVO> arrayList) {
		this.files = arrayList;
	}
	
	public int getOffset() {
		return offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
