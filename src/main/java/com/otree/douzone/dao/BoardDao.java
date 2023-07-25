package com.otree.douzone.dao;

import java.sql.SQLException;
import java.util.List;

import com.otree.douzone.dto.Board;


public interface BoardDao {
		void insertBoard(Board board) throws ClassNotFoundException, SQLException; // �Խù� ����
		int getBoardCount() throws ClassNotFoundException, SQLException; // �Խù� ���� ��������
		List<Board> getBoardList(int workspaceId) throws ClassNotFoundException, SQLException; //ù��° ȭ�� �Խù� ��������
		List<Board> getBoardListForPaging(int second,int first, int workspaceId) throws ClassNotFoundException, SQLException; // ����¡�� ��ü �Խù� ��������
		List<Board> getBoardListByBoardTitle(String boardTitle) throws ClassNotFoundException, SQLException; // boardTitle�� �Խù� �˻�
		Board getBoardByBoardId(int boardId) throws ClassNotFoundException, SQLException; // boardId�� �Խù� �󼼺���
		int updateBoardReadCountByBoardId(int boardId) throws ClassNotFoundException, SQLException; // boardId�� �Խù� �󼼺���
	    void updateBoard(Board board ) throws ClassNotFoundException, SQLException; // �Խù� ������Ʈ
	    void deleteBoard(int boardId) throws ClassNotFoundException, SQLException; // �Խù� ����
	    
	    String getUserNameByUserId(int userId) throws ClassNotFoundException, SQLException; //otreeuser�� �ִ� table ����
}
