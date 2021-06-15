package com.icia.membership.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.membership.dto.BoardDTO;
import com.icia.membership.dto.PageDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	public void boardWriteFile(BoardDTO board) {
		 sql.insert("bm.boardwritefile",board);
		
	}

	public List<BoardDTO> boardList() {
		return sql.selectList("bm.boardlist");
	}

	public BoardDTO boardView(int bnumber) {
		return sql.selectOne("bm.boardview", bnumber);
	}

	public int updateProcess(BoardDTO board) {
		return sql.update("bm.boardupdate", board);
		}

	public int boardDelete(int bnumber) {
		return sql.delete("bm.boarddelete", bnumber);
		}

	public int listCount() {
		return sql.selectOne("bm.listcount");
		}

	public List<BoardDTO> boardPaging(PageDTO paging) {
		return sql.selectList("bm.boardpaging", paging);
		}

	public List<BoardDTO> boardSearch(Map<String, String> searchMap) {
		return sql.selectList("bm.boardsearch", searchMap);
		}
	
	
	
	
	
	
	
}
