package com.otree.douzone.dao;

import java.sql.SQLException;
import java.util.List;

import com.otree.douzone.dto.BoardFile;

public interface BoardFileDao {

	void insertFile(List<BoardFile> list) throws ClassNotFoundException, SQLException; //���� ���� ( ÷�� ���� ���)
	List<BoardFile> getFile(int boardId) throws  ClassNotFoundException, SQLException; //���� ��ȸ(�� �󼼺���)
	void updateFile(BoardFile boardfile) throws ClassNotFoundException, SQLException; //���� ���� 
	void deleteFile(int fileId) throws ClassNotFoundException, SQLException; //���� ���� (�ۻ�����)
}
