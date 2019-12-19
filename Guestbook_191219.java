package guestbook.vo;

/**
 * 방명록 VO
 */
public class Guestbook {

	private int sn;
	private String author;
	private String content;
	private String indate;
	
	public Guestbook() {}
	
	public Guestbook(int sn, String author, String content, String indate) {
		super();
		this.sn = sn;
		this.author = author;
		this.content = content;
		this.indate = indate;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	@Override
	public String toString() {
		return String.format("글 번호: %d    작성자: %s    내용: %s    작성일: %s\n", sn, author, content, indate);
	}
}