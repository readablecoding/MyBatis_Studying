package board.vo;

public class BoardVO {
	
	//����
	private int	num;
	private	String	id;
	private	String	title;
	private	String	contents;
	private	String	inputdate;
	private	int	hits;
	private	int	likes;
	

	//������
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public BoardVO(int num, String title, String contents) {
		super();
		this.num = num;
		this.title = title;
		this.contents = contents;
	}




	//getter, setter
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getInputdate() {
		return inputdate;
	}


	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}


	public int getHits() {
		return hits;
	}


	public void setHits(int hits) {
		this.hits = hits;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}




	@Override
	public String toString() {
		return "�۹�ȣ: " + num + ", id: " + id + ", ����: " + title + ", ����: " + contents + ", �ۼ��ð�: "
				+ inputdate + ", ��ȸ��: " + hits + ", ��õ��: " + likes; }
	
	
	
}
