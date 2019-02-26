package dao;

import vo.AdminVO;
import vo.BoardVO;

public interface AdminDao {
	AdminVO SelectAdmin(String key);
	void deleteBoard(int num,int num1);
}
