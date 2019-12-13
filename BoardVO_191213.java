package global.sesoc.board.vo;

//게시슬 정보를 저장할 VO클래스
public class BoardVO 
{
	//변수
	private int num;				//글번호
	private String id;				//작성자ID
	private String title;			//제목
	private String contents;		//내용
	private String inputdate;		//작성시간
	private int hits;			//조회수
	private int likes;			//추천수
	
	//생성자
	public BoardVO() 
	{
		
	}
	
	
	
	public BoardVO(String id, String title, String contents) 
	{
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
	}



	public BoardVO(int num, String id, String title, String contents, String inputdate, int hits, int likes) 
	{
		super();
		this.num = num;
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.inputdate = inputdate;
		this.hits = hits;
		this.likes = likes;
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

	//toString
	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", id=" + id + ", title=" + title + ", contents=" + contents + ", inputdate="
				+ inputdate + ", hits=" + hits + ", likes=" + likes + "]";
	}

}
