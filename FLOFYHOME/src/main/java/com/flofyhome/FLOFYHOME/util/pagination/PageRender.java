package com.flofyhome.FLOFYHOME.util.pagination;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {

	private String url;
	private Page<T> page;
	private int totalPages;
	private int numElementsForPage;
	private int actualPage;
	private List<PageItem> pages;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.pages = new ArrayList<PageItem>();
		
		numElementsForPage = 5;
		totalPages = page.getTotalPages();
		actualPage = page.getNumber() + 1;
		
		int from, to;
		if(totalPages <= numElementsForPage) {
			from = 1;
			to = totalPages;
		}else {
			if(actualPage <= numElementsForPage/2){
				from = 1;
				to = numElementsForPage;
			}else if(actualPage >= totalPages - numElementsForPage/2) {
				from = totalPages - numElementsForPage + 1;
				to = numElementsForPage;
			}else {
				from = actualPage - numElementsForPage/2;
				to = numElementsForPage;
			}
			
		}
		
		for(int i = 0; i < to; i++) {
			pages.add(new PageItem(from + i, actualPage == from + i));
		}
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getActualPage() {
		return actualPage;
	}

	public void setActualPage(int actualPage) {
		this.actualPage = actualPage;
	}

	public List<PageItem> getPages() {
		return pages;
	}

	public void setPages(List<PageItem> pages) {
		this.pages = pages;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}

	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	public boolean isHasPrevius() {
		return page.hasPrevious();	
	}

	
	
	
	
	
	
}
