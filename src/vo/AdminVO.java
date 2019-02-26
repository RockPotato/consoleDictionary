package vo;

import java.util.Date;

public class AdminVO {
	private final String privateKey="ljh";
	private Date date;
	public String getPrivateKey() {
		return privateKey;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
