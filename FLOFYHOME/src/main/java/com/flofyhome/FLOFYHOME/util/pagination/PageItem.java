package com.flofyhome.FLOFYHOME.util.pagination;

public class PageItem {

	private int num;
	private boolean current;
	
	public PageItem(int num, boolean current) {
		super();
		this.num = num;
		this.current = current;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}
	
	
	
}
