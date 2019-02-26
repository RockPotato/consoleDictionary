package dao;

import java.util.ArrayList;

import vo.UserVO;

public interface UserDao {
	UserVO selectUser(String id, String pw);
	UserVO selectUser2(int num); // 키값으로 유저를 가져옴
	void insertUser(UserVO user);
	ArrayList<UserVO> selectUserList();
	void removeUser(UserVO uvo);	
	boolean patternChecker(String inputId);
	boolean patternChecker2(String pw);
	void readnotice();
	void readBoard();
	void writeBoard();
}
