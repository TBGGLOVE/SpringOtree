package com.otree.douzone.util;

import lombok.Data;

@Data
public class Pager {
	
	 //�켱 �����
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
	
	 // 1�� ������ ������  
	 // between 1(firstPartPageCal) ~ 11(secondPartPageCal) �����;ߵǰ�
	 
	 // 2�� ������ ������  between 12~ 22 
	 
	 
	 
	}



