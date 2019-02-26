package dao;

import java.util.ArrayList;

import vo.BoardVO;

public interface BoardDao {
	ArrayList<BoardVO> selectCategoryList(int num);
	BoardVO selectBoard(int num,int num1);
	void insertBoard(BoardVO bvo);
	void insertNotice(BoardVO bvo);
}
