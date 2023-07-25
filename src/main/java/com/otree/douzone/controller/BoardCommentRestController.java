package com.otree.douzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otree.douzone.dto.Board;
import com.otree.douzone.dto.BoardComment;
import com.otree.douzone.dto.BoardCommentVO;
import com.otree.douzone.service.BoardCommentService;
import com.otree.douzone.service.BoardService;

// �Խ��� ��� ó���� ���� �񵿱� ��Ʈ�ѷ�
@RestController 
@RequestMapping("/test")
public class BoardCommentRestController {

	private BoardCommentService boardCommentService;
	
	
	@Autowired
	public BoardCommentRestController(BoardCommentService boardCommentService) {
		this.boardCommentService = boardCommentService;
	}
	
	//��� ���� �� list ��������
	@PostMapping
	public ResponseEntity<List<BoardCommentVO>> createBoardComment(@RequestBody BoardComment boardComment) {
		List<BoardCommentVO> boardCommentList = null;
		try {
			boardCommentService.createComment(boardComment);  
			boardCommentList = boardCommentService.getCommentListVO(boardComment.getBoardId()); // ������ boardCommentList return 
			return new ResponseEntity<List<BoardCommentVO>>(boardCommentList, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<BoardCommentVO>>(boardCommentList, HttpStatus.BAD_REQUEST); // ���н� null ���� �������� list�����״�.
	}
	}
	

	
	//��� ���� ���� comment id�� ���� ��� ��������
	@GetMapping
	public ResponseEntity<BoardCommentVO> getBoardComment(@RequestParam("param") int commentId) {
		BoardCommentVO boardCommentVO = null;
		try {
			boardCommentVO = boardCommentService.getCommentVO(commentId); // ������ boardCommentList return 
			return new ResponseEntity<BoardCommentVO>(boardCommentVO, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<BoardCommentVO>(boardCommentVO, HttpStatus.BAD_REQUEST); 
	}
	}
	
	
	// ��� ���� �� ������ ������ ���  return
	@PutMapping
	public ResponseEntity<BoardCommentVO> modifyBoard(@RequestBody BoardComment boardComment) {
		BoardCommentVO boardComment1 = null;
		try {
			boardCommentService.modifyComment(boardComment.getBoardComment(), boardComment.getCommentId());
			boardComment1 = boardCommentService.getCommentVO(boardComment.getCommentId());
			return new ResponseEntity<BoardCommentVO>(boardComment1, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<BoardCommentVO>(boardComment1, HttpStatus.BAD_REQUEST);
	}
	}
	
	
	//��� �����ϱ� �� ������ ������ list return
	@DeleteMapping
	public ResponseEntity<List<BoardCommentVO>> deleteBoard(@RequestParam("commentId") int commentId, @RequestParam("boardId")int boardId) {
		List<BoardCommentVO> boardCommentList = null;
		try {
			boardCommentService.removeComment(commentId);
			boardCommentList = boardCommentService.getCommentListVO(boardId);
			return new ResponseEntity<List<BoardCommentVO>>(boardCommentList, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<List<BoardCommentVO>>(boardCommentList, HttpStatus.BAD_REQUEST);
	}
}
	
	
}

