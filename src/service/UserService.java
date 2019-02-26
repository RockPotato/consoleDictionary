package service;

import vo.WordVO;

public interface UserService {
	WordVO search(String word,int num);
	String[] login();
	int userUI();
	int boardUI();
	void readBoard();
	void join();
	int My_Page();
	boolean deleteAccount(String id,String pw);
	boolean changePassword(String id,String pw);
	int modify();
	void showHistory();
	void deleteHistory();
	void readNotice();
	void writeBoard(String id);
}
