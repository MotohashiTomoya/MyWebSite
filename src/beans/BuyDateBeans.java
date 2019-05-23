package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuyDateBeans  implements Serializable {
	private int id;
	private int userId;
	private Date buyDate;



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(buyDate);
	}
}