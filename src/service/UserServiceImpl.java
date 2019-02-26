package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import vo.BoardVO;
import vo.Database;
import vo.UserVO;
import vo.WordVO;
import dao.AdminDao;
import dao.AdminDaoImpl;
import dao.BoardDao;
import dao.BoardDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import dao.WordDao;
import dao.WordDaoImpl;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();
	AdminDao ad = new AdminDaoImpl();
	WordDao wd = new WordDaoImpl();
	BoardDao bd = new BoardDaoImpl();

	@Override
	public void join() {
		boolean idcheck=false;
		Scanner s = new Scanner(System.in);
		System.out.print("ID >");
		String id=s.nextLine();
		System.out.println("PW >");
		String pw=s.nextLine();
		for(int i=0;i<ud.selectUserList().size();i++)
		{
			if(ud.selectUser(id, pw)!=null)
			{
				idcheck=true;
			}
		}
		if(idcheck)
		{
			System.out.println("존재하는 ID입니다.");
		}
		else if(!(ud.patternChecker(id)))
		{
			System.out.println("ID 형식이 올바르지 않습니다.");
		}
		else if (!(ud.patternChecker2(pw)))
		{
			System.out.println("PW 형식이 올바르지 않습니다.");
		}
		else
		{
			UserVO user = new UserVO();
			user.setId(id);
			user.setPassword(pw);
			Date date = new Date();
			user.setDate(date);
			user.setUserNum(ud.selectUserList().size());
			System.out.println("이름 입력 > ");
			String name = s.nextLine();
			user.setName(name);
			ud.insertUser(user);
			System.out.println("가입 날짜 : "+ date);
		}
	}

	@Override
	public String[] login() {
		String[] idpw=new String[3];
		System.out.println("ID > ");
		String id=strScan();
		System.out.println("PW > ");
		String pw=strScan();
		if(ud.selectUser(id, pw)==null)
		{
			System.out.println("Wrong ID");
			clearScreen();
			return null;
		}
		else if(!(ud.selectUser(id, pw).getPassword().equals(pw)))
		{
			System.out.println("Wrong Password");
			clearScreen();
			return null;
		}
		else
		{
			System.out.println("User Login");
			idpw[0]=id;
			idpw[1]=pw;
			idpw[2]=Integer.toString(ud.selectUser(id, pw).getUserNum());
			clearScreen();
			return idpw;
		}
	}

	@Override
	public int userUI() {
		System.out.println("=================");
		System.out.println("    Menu");
		System.out.println("1. Word Search");
		System.out.println("2. Board");
		System.out.println("3. My page");
		System.out.println("etc. logout");
		System.out.println("=================");
		System.out.print("Input >");
		return intScan();
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
	public void showHistory()
	{
		ArrayList<WordVO> wvos=wd.selectHistoryList();
		if(wvos.size()!=0)
		{
			for(int i=0;i<wvos.size();i++)
			{
				System.out.println(wvos.get(i).getReadDate());
				System.out.println(wvos.get(i).getWordName());
				System.out.println();
			}
			System.out.print("You can get history.");
			System.out.println("Want?(y|Y)");
			String str = strScan();
			if(str.equals("y")||str.equals("Y"))
			{
				fileOut();
			}
		}
		else
		{
			System.out.println("Not hava history");
		}
	}
	
	private void fileOut() {
		FileWriter fw = null;

		BufferedWriter bw = null;

		try {

			// "ReadFile.txt" 파일을 읽는 FileReader 객체 생성
			// BufferedReader 객체 생성
			fw = new FileWriter("d://CopyFile2.txt");
			bw = new BufferedWriter(fw);

			String s = null;
			Date date = new Date();
			WordVO wvo = new WordVO();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			// ReadFile.txt 에서 한줄씩 읽어서 BufferedRaeder에 저장한다.
			int index = 0;
			ArrayList<WordVO> avos = wd.selectHistoryList();
			while (avos.size() != 0) {
				bw.write(sdf.format(avos.get(index).getReadDate()));
				bw.newLine();
				bw.write(avos.get(index).getWordName());
				bw.newLine();
				avos.remove(index);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// BufferedReader FileReader를 닫아준다.
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
				}
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
				}
			wd.selectHistoryList().clear();

		}
	}

	@Override
	public int boardUI() {
		System.out.println("=================");
		System.out.println("    Menu");
		System.out.println("1. Notice");
		System.out.println("2. readboard");
		System.out.println("3. writeboard");
		System.out.println("etc. before");
		System.out.println("=================");
		System.out.print("Input >");
		return intScan();
	}
	
	@Override
	public void readNotice() {
		ud.readnotice();
		System.out.println(Database.tb_boards.get(0).size());
		
	}
	
	@Override
	public void readBoard() {
		ud.readBoard();
	}

	
	@Override
	public int My_Page() {//키값으로 유저를 받아오기 위해 매개변수 num 삽입
		clearScreen();
		System.out.println("1. History");
		System.out.println("2. Modify");
		System.out.println("0. Back");
		System.out.println();
		System.out.print("Choose Number >");
		int ns = intScan();
		return ns;
	}
	
	@Override
	public int modify()
	{
		System.out.println("Menu");
		System.out.println("1. Change password");
		System.out.println("2. Delete Account");
		System.out.println("etc. Back");
		System.out.print("Choose Number >");
		return intScan();
	}
	
	@Override
	public boolean changePassword(String id,String pw)
	{
		System.out.println("Id >");
		String str=strScan();
		if(str.equals(id))
		{
			System.out.println("Pw >");
			String str1=strScan();
			if(str1.equals(pw))
			{
				System.out.print("After Pw > ");
				String chpw=strScan();
				ud.selectUser(id, pw).setPassword(chpw);
				return false;
			}
			else
			{
				System.out.println("Wrong Pw");
			}
		}
		else
		{
			System.out.println("Wrong ID");
		}
		return true;
	}
	
	@Override
	public boolean deleteAccount(String id,String pw)
	{
		System.out.println("Id >");
		String str=strScan();
		if(str.equals(id))
		{
			System.out.println("Pw >");
			String str1=strScan();
			if(str1.equals(pw))
			{
				for(int i=0;i<ud.selectUserList().size();i++)
				{
					if(ud.selectUserList().get(i).getId().equals(id))
					{
						ud.selectUserList().remove(i);
						return false;
					}
				}
				
			}
			else
			{
				System.out.println("Wrong Pw");
			}
		}
		else
		{
			System.out.println("Wrong ID");
		}
		return true;
		
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
		} catch (Exception e) {
			System.out.println("Wrong input");
			return 0;
		}
	}

	@Override
	public void deleteHistory() {
		wd.selectHistoryList().clear();
	}

	@Override
	public void writeBoard(String id) {
		BoardVO bvo = new BoardVO();
		System.out.print("Title input >");
		String str=strScan();
		bvo.setTitle(str);
		System.out.println("Text input > ");
		String text=strScan();
		bvo.setText(text);
		bvo.setCreaterID(id);
		bvo.setCategory("Board");
		Date date = new Date(); 
		bvo.setDate(date);
		System.out.print("Complete? (y|Y)");
		String ans = strScan();
		if(ans.equals("y")||ans.equals("Y"))
		{
			bd.insertBoard(bvo);
		}
	}

}
