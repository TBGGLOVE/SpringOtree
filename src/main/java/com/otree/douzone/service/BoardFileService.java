package com.otree.douzone.service;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otree.douzone.dao.BoardCommentDao;
import com.otree.douzone.dao.BoardDao;
import com.otree.douzone.dao.BoardFileDao;
import com.otree.douzone.dao.EmpDao;
import com.otree.douzone.dto.Board;
import com.otree.douzone.dto.BoardComment;
import com.otree.douzone.dto.BoardFile;
import com.otree.douzone.dto.Emp;


@Service
public class BoardFileService {

	SqlSession sqlsession;
	
	@Autowired
	public BoardFileService(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
		//(C) �۾��� �Ҷ� ���� ����Ʈ �Ķ���� �Է¹ް� ���� ����.
		// ���⼭ ����÷�� ���� ��ƾߵ�.
		public boolean createFile(List<BoardFile> list) {
			boolean result = false;
			try {
				BoardFileDao boardFileDao = sqlsession.getMapper(BoardFileDao.class);
				boardFileDao.insertFile(list);
				result = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			return result;
		}
		
		//(R)
		// �Խ��� �󼼺��� ������ �� ���� ����Ʈ ��������
		public List<BoardFile> getFile(int boardId)  {
			List<BoardFile> listBoardFile = null;
			try {
				BoardFileDao boardFileDao = sqlsession.getMapper(BoardFileDao.class);
				listBoardFile = boardFileDao.getFile(boardId);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			return listBoardFile;
		}
		
		//(U)
		// �۾� ������ ���� ��  �Խ��� �󼼺��� ���� �� ÷������ ������Ʈ(����)
		public boolean modifyFile(BoardFile boardfile)  {
			boolean result = false;
			List<BoardFile> listBoardFile = null;
			try {
				BoardFileDao boardFileDao = sqlsession.getMapper(BoardFileDao.class);
				boardFileDao.updateFile(boardfile);
				result = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			return result;
		}
		
		//(D)
		// �۾� ������ ���� �� �Խ��� �󼼺��� ���� �� �� ����
		public boolean removeFile(int fileId)  {
			boolean result = false;
			try {
				BoardFileDao boardFileDao = sqlsession.getMapper(BoardFileDao.class);
				boardFileDao.deleteFile(fileId);
				result = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			return result;
		}
	
	
}
