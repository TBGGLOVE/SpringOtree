package com.otree.douzone.util;

import lombok.Data;

@Data
public class Pager {
	
	 //우선 동기로
	 private int pageSize = 11;
	 private int boardListCount;
	 private int pageNum;
	 

	 public int firstPartPageCal(int pageSize, int pageNum) {
		 int result = 0;
		 result = (pageSize*(pageNum-1))+1;  
		 return result;
	 }
	
	 public int secondPartPageCal(int pageSize, int pageNum) {
		 int result = 0;
		 result = (pageSize*(pageNum));  
		 return result;
	 }
	
	 // 1번 페이지 누르면  
	 // between 1(firstPartPageCal) ~ 11(secondPartPageCal) 가져와야되고
	 
	 // 2번 페이지 누르면  between 12~ 22 
	 
	 
	 
	}



