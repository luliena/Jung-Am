package com.jungam.manage.vo;

public class FileVO {
	int index;
	int fileNo;
	String path;
	String fileName;
	String contentType;

	public FileVO(String path, String fileName, String type) {
		this.path = path;
		this.fileName = fileName;
		this.contentType = type;
	}
	
	public FileVO() {
		
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
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

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contenttype) {
		this.contentType = contenttype;
	}
}
