package com.jungam.manage.vo;

public class FileVO {
	int index;
	int fileNo;
	String path;
	String fileName;

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
}
