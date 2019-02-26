package dao;

import java.util.ArrayList;

import vo.BoardVO;
import vo.Database;

public class BoardDaoImpl implements BoardDao {

	@Override
	public ArrayList<BoardVO> selectCategoryList(int num) {
		if(num==0)
		{
			return Database.tb_boards.get(0);
		}
		else if(num==1)
		{
			return Database.tb_boards.get(1);
		}
		return null;
	}

	@Override
	public BoardVO selectBoard(int num,int num1) {
		return Database.tb_boards.get(num).get(num1);
	}

	@Override
	public void insertBoard(BoardVO bvo) {
		Database.tb_boards.get(1).add(bvo);
	}

	@Override
	public void insertNotice(BoardVO bvo) {
		Database.tb_boards.get(0).add(bvo);		
	}

}
