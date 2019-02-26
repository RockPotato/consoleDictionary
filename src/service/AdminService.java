package service;

import vo.WordVO;


public interface AdminService {
	String adminLogin();
	int adminUI();
	void updateInfo(String word, int num);
	void appendWord();
	void deleteWord(String word,int num);
	int wordManageUI();
	int userManageUI();
	WordVO search(String word,int num);
	void deleteUser();
	void updateUserInfo();
	int boardManageUI();
	void readBoard();
	void deleteBoard(int num,int num1);
}
