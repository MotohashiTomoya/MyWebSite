package beans;

public class UserDateBeans{
	private int id;
	private String loginId;
	private String name;
	private String password;
	private String createDate;


	// ログインセッションを保存するためのコンストラクタ
	public UserDateBeans(String loginId, String name,int id) {
		this.loginId = loginId;
		this.name = name;
		this.id=id;
	}

	// 全てのデータをセットするコンストラクタ
	public UserDateBeans(int id, String loginId, String name, String password, String createDate) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.password = password;
		this.createDate = createDate;

	}

	public UserDateBeans() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


}