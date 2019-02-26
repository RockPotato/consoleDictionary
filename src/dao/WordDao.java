package dao;

import java.util.ArrayList;

import vo.WordVO;

public interface WordDao {
	WordVO selectWord2(int num);
	void selectWordList(String alphabet);
	void appendInfo(int num);
	ArrayList<WordVO> selectAlphabetDatabase();
	void deleteAlphabetDatabase();
	void appendHistory(WordVO wvo);
	ArrayList<WordVO> selectDictionary();
	ArrayList<WordVO> selectHistoryList();
	void deleteWord(int num);
	void updateWord(WordVO wvo);
}
