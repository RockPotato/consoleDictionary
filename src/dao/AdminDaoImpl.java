package dao;

import vo.AdminVO;
import vo.Database;

public class AdminDaoImpl implements AdminDao {
	
	@Override
	public AdminVO SelectAdmin(String key) {
		AdminVO admin = new AdminVO();
		if(key.equals(admin.getPrivateKey()))
		{
			return admin;
		}
		return null;
	}

	@Override
	public void deleteBoard(int num,int num1) {
		Database.tb_boards.get(num).remove(num1);
	}
}
