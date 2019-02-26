package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import firstdata.*;
import vo.BoardVO;
import vo.UserVO;
import vo.WordVO;
import vo.Database;

public class firstInput {

	public static void input() {
		String[] names = { "관리자", "이준호", "박정권" };
		String[] ids = { "leejunho", "wnsgh", "wjdrnjs" };
		String[] pws = { "leejunho", "wnsgh1!", "wjdrnjs1!" };
		ArrayList<UserVO> users = new ArrayList<UserVO>();
		for (int i = 0; i < 3; i++) {
			users.add(new UserVO());
		}
		for (int i = 0; i < users.size(); i++) {
			users.get(i).setName(names[i]);
			users.get(i).setId(ids[i]);
			users.get(i).setPassword(pws[i]);
			users.get(i).setUserNum(i);
			Database.tb_user.add(users.get(i));
		}
		FileReader fr = null;

		BufferedReader br = null;
		String path = firstInput.class.getResource("").getPath();
		try {

			// "ReadFile.txt" 파일을 읽는 FileReader 객체 생성
			// BufferedReader 객체 생성
			fr = new FileReader(path+"Dictionay_words.txt");
			br = new BufferedReader(fr);

			String s = null;
			Date date = new Date();
			WordVO wvo = new WordVO();
			// ReadFile.txt 에서 한줄씩 읽어서 BufferedRaeder에 저장한다.
			while ((s = br.readLine()) != null) {
				wvo = new WordVO();
				wvo.setWordNum(Database.tb_words.size());
				wvo.setWordName(s);
				wvo.setUpdateDate(date);
				Database.tb_words.add(wvo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// BufferedReader FileReader를 닫아준다.
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
				}
		}
		try {

			// "ReadFile.txt" 파일을 읽는 FileReader 객체 생성
			// BufferedReader 객체 생성
			fr = new FileReader(path+"Notice.txt");
			br = new BufferedReader(fr);

			String s = null;
			Date date = new Date();
			BoardVO bvo = new BoardVO();
			int i=1;
			Database.tb_boards.add(new ArrayList<BoardVO>());
			Database.tb_boards.add(new ArrayList<BoardVO>());
			// ReadFile.txt 에서 한줄씩 읽어서 BufferedRaeder에 저장한다.
			while ((s = br.readLine()) != null) {
				switch(i)
				{
					case 1:
						bvo.setTitle(s);
						break;
					case 2:
						bvo.setText(s);
						break;
					case 3:
						bvo.setCategory(s);
						bvo.setCreaterID("leejunho");
						bvo.setDate(date);
						Database.tb_boards.get(0).add(bvo);
						bvo = new BoardVO();
						i=0;
						break;
					default:
						break;
				}
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// BufferedReader FileReader를 닫아준다.
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
				}
			if(Database.tb_words.size()>0)
			{
				System.out.println("First data input success");
			}
		}

	}
}
