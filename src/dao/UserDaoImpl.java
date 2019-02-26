package dao;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vo.Database;
import vo.UserVO;

public class UserDaoImpl implements UserDao {

	@Override
	public UserVO selectUser(String id, String pw) {
		for (int i = 0; i < Database.tb_user.size(); i++) {
			UserVO user = Database.tb_user.get(i);
			if (user.getId().equals(id) && user.getPassword().equals(pw)) {
				return user;
			} else if (user.getId().equals(id)
					&& !(user.getPassword().equals(pw))) {
				user.setPassword(" ");
				return user;
			}
		}
		return null;
	}

	@Override
	public UserVO selectUser2(int num) {
		return Database.tb_user.get(num);
	}

	@Override
	public void insertUser(UserVO user) {
		Database.tb_user.add(user);
	}

	@Override
	public ArrayList<UserVO> selectUserList() {
		return Database.tb_user;
	}

	@Override
	public void removeUser(UserVO uvo) {
		for(int i=0;i<selectUserList().size();i++)
		{
			if(selectUser2(i).getId().equals(uvo.getId())&&
					selectUser2(i).getPassword().equals(uvo.getPassword()))
			{
				Database.tb_user.remove(i);
			}
		}
	}

	@Override
	public boolean patternChecker(String inputId) {

		Pattern id = Pattern.compile("[A-Za-z0-9]{5,15}");
		Matcher a = id.matcher(inputId);
		if (a.matches() == true) {
			return true;
		}
		return false;
	}

	@Override
	public boolean patternChecker2(String pw) {
		Pattern ps = Pattern
				.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=-])(?=.*[0-9]).{8,20}");
		Matcher b = ps.matcher(pw);

		if (b.matches() == true) {
			return true;
		}
		return false;
	}

	@Override
	public void readnotice() {
		for(int i=0 ; i<Database.tb_boards.get(0).size();i++)
		{
			System.out.println("==================================");
			System.out.println("Title : "+Database.tb_boards.get(0).get(i).getTitle());
			System.out.println("Text : "+Database.tb_boards.get(0).get(i).getText());
			System.out.println("==================================");
		}
		
	}

	@Override
	public void readBoard() {
		for(int i=0 ; i<Database.tb_boards.get(1).size();i++)
		{
			System.out.println("==================================");
			System.out.println("ID :"+Database.tb_boards.get(1).get(i).getCreaterID());
			System.out.println("Date :"+Database.tb_boards.get(1).get(i).getDate());
			System.out.println("Title : "+Database.tb_boards.get(1).get(i).getTitle());
			System.out.println("Text : "+Database.tb_boards.get(1).get(i).getText());
			if(Database.tb_boards.get(1).get(i).getComment()!=null)
			{
				for(int j=0;j<Database.tb_boards.get(1).get(i).getComment().length;j++)
				{
					System.out.println("Comment : "+Database.tb_boards.get(1).get(i).getComment()[j]);
				}
			}
			System.out.println("==================================");
		}		
	}

	@Override
	public void writeBoard() {
		
	}
}
