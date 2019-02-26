package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import vo.AdminVO;
import vo.WordVO;
import dao.AdminDao;
import dao.AdminDaoImpl;
import dao.BoardDao;
import dao.BoardDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import dao.WordDao;
import dao.WordDaoImpl;

public class AdminServiceImpl implements AdminService {
	AdminDao ad = new AdminDaoImpl();
	UserDao ud = new UserDaoImpl();
	WordDao wd = new WordDaoImpl();
	BoardDao bd = new BoardDaoImpl();

	@Override
	public int wordManageUI() {
		System.out.println("Menu");
		System.out.println("1. Word UpdateInfo");
		System.out.println("2. Word append");
		System.out.println("3. Word delete");
		System.out.println("etc. back");
		return intScan();
	}

	@Override
	public int adminUI() {
		System.out.println("Menu");
		System.out.println("1. Word management");
		System.out.println("2. User management");
		System.out.println("3. Board management");
		System.out.println("etc. logout");
		return intScan();
		
	}
	
	@Override
	public int userManageUI() {
		System.out.println("Menu");
		System.out.println("1. User updateInfo");
		System.out.println("2. User delete");
		return intScan();
	}
	@Override
	public void deleteUser() {
		for(int i=0;i<ud.selectUserList().size();i++)
		{
			System.out.println("------------------------");
			System.out.println("UserNum : "+ ud.selectUser2(i).getUserNum());
			System.out.println("ID : "+ ud.selectUser2(i).getId());
			System.out.println("NAME : "+ ud.selectUser2(i).getName());
			System.out.println("PW : "+ ud.selectUser2(i).getPassword());
		}
		System.out.println("choice user's num");
		int num = intScan();
		if(ud.selectUserList().size()>num&&ud.selectUser2(num)!=null&&num>0)
		{
			ud.removeUser(ud.selectUser2(num));
		}
		else
		{
			System.out.println("user delete error");
		}
	}

	@Override
	public void updateUserInfo() {
		for(int i=0;i<ud.selectUserList().size();i++)
		{
			System.out.println("------------------------");
			System.out.println("UserNum : "+ ud.selectUser2(i).getUserNum());
			System.out.println("ID : "+ ud.selectUser2(i).getId());
			System.out.println("NAME : "+ ud.selectUser2(i).getName());
			System.out.println("PW : "+ ud.selectUser2(i).getPassword());
		}
		System.out.print("choise user's num >");
		int num = intScan();
		clearScreen();
		if(ud.selectUserList().size()>num&&ud.selectUser2(num)!=null&&num>0)
		{
			System.out.println("------------------------");
			System.out.println("UserNum : "+ ud.selectUser2(num).getUserNum());
			System.out.println("ID : "+ ud.selectUser2(num).getId());
			System.out.println("NAME : "+ ud.selectUser2(num).getName());
			System.out.println("PW : "+ ud.selectUser2(num).getPassword());
			System.out.println("------------------------");
			System.out.println("1.PW 2.NAME etc. back");
			System.out.print("Choose change num > ");
			int num1 = intScan();
			switch(num1)
			{
				case 1:
					System.out.print("password input >");
					String pw= strScan();
					ud.selectUser2(num).setPassword(pw);
					break;
				case 2:
					System.out.print("Name input >");
					String name= strScan();
					ud.selectUser2(num).setName(name);
					break;
				default:
					break;
			}
			
		}
		else
		{
			System.out.println("user choose error");
		}
	}
	@Override
	public void updateInfo(String word, int num) {
		System.out.println("UpdateInfo");
		WordVO wvo = search(word, num);
		if(wvo!=null)
		{
			System.out.print("Input info > ");
			String str=strScan();
			wvo.setWordInfo(str);
			wd.updateWord(wvo);
		}
		else
		{
			System.out.println("Not exist");
		}
	}

	@Override
	public void appendWord() {
		WordVO wvo = new WordVO();
		System.out.print("Word name input > ");
		String str= strScan();
		System.out.print("Word information input > ");
		String str1= strScan();
		str=str.substring(0, 1).toUpperCase()+str.substring(1);
		wvo.setWordName(str+" "+str1);
		Date date=new Date();
		wvo.setUpdateDate(date);
		wvo.setWordNum(wd.selectDictionary().size());
		wd.selectDictionary().add(wvo);
	}

	@Override
	public void deleteWord(String word, int num) {
		try {
			int num1 =search(word, num).getWordNum();
			wd.deleteWord(num1);	
			System.out.println("delete success");
		} catch (Exception e) {
			System.out.println("Not exist");
		}
		
	}

	@Override
	public String adminLogin() {
		System.out.println("Admin Login");
		System.out.print("Key > ");
		Scanner sc =new Scanner(System.in);
		String key=sc.nextLine();
		AdminVO avo = ad.SelectAdmin(key);
		if(avo!=null)
		{
			return avo.getPrivateKey();
		}
		return null;
	}

	public static void clearScreen(){
		 for (int i = 0; i < 30; i++)
		   System.out.println("");
	}
	
	static String strScan() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	static Integer intScan()
	{
		try {
			Scanner sc = new Scanner(System.in);
			return sc.nextInt();
		}catch (Exception e) {
			System.out.println("Wrong input");
			return 0;
		}
	}
	@Override
	public  WordVO search(String word,int num) {
		wd.selectWordList(word.substring(0));
		ArrayList<WordVO> words=wd.selectAlphabetDatabase();
		String wordTemp=word.substring(0,1).toUpperCase()+word.substring(1);
		for(int i=0;i<words.size();i++)
		{
			if(words.get(i).getWordName().length()
					>word.length()&&wordTemp.equals(words.get(i).getWordName().substring(0,word.length())))
			{
				wd.appendHistory(words.get(i));
				return words.get(i);
			}
		}
		return null;
	}

	@Override
	public int boardManageUI() {
		System.out.println("Menu");
		System.out.println("1. Read board");
		System.out.println("2. Board delete");
		System.out.println("etc. back");
		return intScan();
	}

	@Override
	public void readBoard() {
		System.out.println("Input category num");
		System.out.println("1 :Notice");
		System.out.println("2 :Board");
		int num =intScan();
		if(num==1)
		{
			for(int i=0 ; i<bd.selectCategoryList(0).size();i++)
			{
				System.out.println("==================================");
				System.out.println("Title : "+bd.selectCategoryList(0).get(i).getTitle());
				System.out.println("Text : "+bd.selectCategoryList(0).get(i).getText());
				System.out.println("==================================");
			}	
		}
		else if(num==2)
		{
			for(int i=0 ; i<bd.selectCategoryList(1).size();i++)
			{
				System.out.println("==================================");
				System.out.println("Title : "+bd.selectCategoryList(0).get(i).getTitle());
				System.out.println("Text : "+bd.selectCategoryList(0).get(i).getText());
				System.out.println("==================================");
			}	
		}
		
	}

	@Override
	public void deleteBoard(int num,int num1) {
		ad.deleteBoard(num, num1);
	}
	
	
}
