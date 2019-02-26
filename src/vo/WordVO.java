package vo;

import java.util.ArrayList;
import java.util.Date;

public class WordVO {
	private int wordNum;
	private String wordName;
	private ArrayList<String> wordInfo=new ArrayList<String>();
	private ArrayList<Date> updateDate=new ArrayList<Date>();
	private Date readDate;
	private int lastUserNum;
	public int getLastUserNum() {
		return lastUserNum;
	}
	public void setLastUserNum(int lastUserNum) {
		this.lastUserNum = lastUserNum;
	}
	public Date getReadDate() {
		return readDate;
	}
	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
	public int getWordNum() {
		return wordNum;
	}
	public void setWordNum(int wordNum) {
		this.wordNum = wordNum;
	}
	public String getWordName() {
		return wordName;
	}
	public void setWordName(String wordName) {
		this.wordName = wordName;
	}
	public ArrayList<String> getWordInfo() {
		return wordInfo;
	}
	public void setWordInfo(String wordInfo) {
		this.wordInfo.add(wordInfo);
	}
	public ArrayList<Date> getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date date) {
		updateDate.add(date);
	}
}
