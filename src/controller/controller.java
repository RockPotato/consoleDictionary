package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import service.AdminService;
import service.AdminServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import vo.WordVO;
import dao.firstInput;

public class controller {

	public static void main(String args[]) {
		UserService us = new UserServiceImpl();
		AdminService as = new AdminServiceImpl();
		firstInput.input();
		String[] idpw = null;
		while (true) {
			FirstMenu();
			switch (intScan()) {
			case 1:
				idpw = us.login();
				break;
			case 2:
				us.join();
				break;
			default:
				System.out.println("shut down");
				System.exit(0);
				break;
			}
			if (idpw != null) {
				if (Integer.parseInt(idpw[2]) == 0) {
					String temp = as.adminLogin();
					if (temp != null) {
						boolean flag = true;
						while (flag) {
							switch (as.adminUI()) {
							case 1:
								switch (as.wordManageUI()) {
								case 1:
									System.out.println("Word input");
									String word = strScan();
									as.updateInfo(word,
											Integer.parseInt(idpw[2]));
									break;
								case 2:
									as.appendWord();
									break;
								case 3:
									System.out.println("Word input");
									String word1 = strScan();
									as.deleteWord(word1,
											Integer.parseInt(idpw[2]));
								default:
									clearScreen();
									break;
								}
								break;
							case 2:
								switch (as.userManageUI()) {
								case 1:
									as.updateUserInfo();
									break;
								case 2:
									as.deleteUser();
									break;
								}
								break;
							case 3:
								switch(as.boardManageUI())
								{
									case 1:
										as.readBoard();
										break;
									case 2:
										as.readBoard();
										System.out.println("Input category num");
										int num=intScan();
										System.out.println("Input Board num");
										int num1=intScan();
										as.deleteBoard(num, num1);
										break;
								}
								break;
							default:
								flag = false;
								break;
							}
						}
					}
				} else {
					boolean flag = true;
					while (flag)
						switch (us.userUI()) {
						case 1:
							clearScreen();
							System.out.print("Search > ");
							WordVO wvo = us.search(strScan(),
									Integer.parseInt(idpw[2]));
							clearScreen();
							if (wvo != null) {
								System.out.println(wvo.getWordName());
							} else {
								System.out.println("Not exist");
							}
							break;
						case 2:
							switch (us.boardUI()) {
							case 1:
								us.readNotice();
								break;
							case 2:
								us.readBoard();
								break;
							case 3:
								us.writeBoard(idpw[0]);
								break;
							}
							break;
						case 3:
							switch (us.My_Page()) {
							case 1:
								clearScreen();
								us.showHistory();
								break;
							case 2:
								clearScreen();
								switch (us.modify()) {
								case 1:
									flag = us.changePassword(idpw[0], idpw[1]);
									System.out.println("try login again");
									break;
								case 2:
									flag = us.deleteAccount(idpw[0], idpw[1]);
									break;
								default:
									break;
								}
								break;
							default:
								break;
							}
							break;
						default:
							clearScreen();
							flag = false;
							us.deleteHistory();
							break;
						}
				}
			}
			idpw = null;
		}
	}

	static String strScan() {
		try {
			Scanner sc = new Scanner(System.in);
			return sc.nextLine();
		} catch (Exception e) {
			System.out.println("Wrong input");
			return "";
		}
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

	static void FirstMenu() {
		Date today = new Date();
		SimpleDateFormat todayFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		System.out.println(todayFormat.format(today));
		System.out.println("Welcome to lee's dictionary");
		System.out.println("     1. Login");
		System.out.println("     2. Join");
		System.out.println("     0. exit");
		System.out.println();
		System.out.print("번호 입력 > ");
	}

	public static void clearScreen() {
		for (int i = 0; i < 30; i++)
			System.out.println("");
	}
}
