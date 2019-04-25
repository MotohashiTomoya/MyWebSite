package beans;

public class ItemDateBeans{
	private int id;
	private String name;
	private String detail;
	private String price;
	private String fileName;


	public ItemDateBeans(int id, String name, String detail, String price, String fileName) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.fileName = fileName;

	}

	public ItemDateBeans() {

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
