package dao;

import java.util.ArrayList;
import java.util.Date;

import vo.Database;
import vo.WordVO;

public class WordDaoImpl implements WordDao {


	@Override
	public WordVO selectWord2(int num) {
		for(int i=0;i<Database.tb_words.size();i++)
		{
			if(Database.tb_words.get(i).getWordNum()==num)
			{
				return Database.tb_words.get(i);
			}
		}
		return null;
	}

	@Override
	public void selectWordList(String alphabet) {
		// if (alphabet.length() >= 2) {
		// System.out.println("only one alphabet need");
		// } else {
		try {
			String str = alphabet.toUpperCase();
			char oneAlphabet = str.charAt(0);
			switch (oneAlphabet) {
			case 'a':
			case 'A':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'b':
			case 'B':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'c':
			case 'C':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'd':
			case 'D':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'e':
			case 'E':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'f':
			case 'F':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'g':
			case 'G':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'h':
			case 'H':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'i':
			case 'I':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'j':
			case 'J':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'k':
			case 'K':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'l':
			case 'L':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'm':
			case 'M':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'n':
			case 'N':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'o':
			case 'O':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'p':
			case 'P':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'q':
			case 'Q':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'r':
			case 'R':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 's':
			case 'S':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 't':
			case 'T':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'u':
			case 'U':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'v':
			case 'V':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'w':
			case 'W':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'x':
			case 'X':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'y':
			case 'Y':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			case 'z':
			case 'Z':
				for (int i = 0; i < Database.tb_words.size(); i++) {
					if (Database.tb_words.get(i).getWordName().length() == 0) {
						continue;
					} else if (oneAlphabet == Database.tb_words.get(i)
							.getWordName().charAt(0)) {
						Database.tb_alphabetWords.add(Database.tb_words.get(i));
					}
				}
				break;
			default:
				System.out.println("not alphabet");
				break;
			}
		} catch (Exception e) {
			System.out.println("Not exist");
		}
		// }
	}

	@Override
	public void appendInfo(int num) {

	}
	@Override
	public ArrayList<WordVO> selectDictionary()
	{
		return Database.tb_words;
	}
	@Override
	public ArrayList<WordVO> selectAlphabetDatabase() {
		return Database.tb_alphabetWords;
	}

	@Override
	public void deleteAlphabetDatabase() {
		Database.tb_alphabetWords.clear();
	}

	@Override
	public void appendHistory(WordVO wvo) {
		Date date=new Date();
		wvo.setReadDate(date);
		Database.tb_history.add(wvo);
	}

	public ArrayList<WordVO> selectHistoryList()
	{
		return Database.tb_history;
	}
	
	@Override
	public void deleteWord(int num) {
		for(int i=0;i<Database.tb_words.size();i++)
		{
			if(Database.tb_words.get(i).getWordNum()==num)
			{
				Database.tb_words.remove(i);
				break;
			}
		}		
	}

	@Override
	public void updateWord(WordVO wvo) {
		for(int i=0;i<Database.tb_words.size();i++)
		{
			if(Database.tb_words.get(i).getWordName().equals(wvo.getWordName()))
			{
				Database.tb_words.remove(i);
				Database.tb_words.add(wvo);
			}
		}
	}
}
