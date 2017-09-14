package ssl.dto;

public class BoardDTO
{
	private int ss_no;
	private int user_no;
	private String title;
	private String writer_comment;
	private String main_content;
	private String writer_day;
	private int hit;
	private int recommend;
	private int visiable;
	
	public BoardDTO () {}

	public BoardDTO(int ss_no, int user_no, String title, String writer_comment, String main_content, String writer_day,
			int hit, int recommend, int visiable) {
		super();
		this.ss_no = ss_no;
		this.user_no = user_no;
		this.title = title;
		this.writer_comment = writer_comment;
		this.main_content = main_content;
		this.writer_day = writer_day;
		this.hit = hit;
		this.recommend = recommend;
		this.visiable = visiable;
	}

	public BoardDTO(int user_no, String title, String writer_comment, String main_content) {
		super();
		this.user_no = user_no;
		this.title = title;
		this.writer_comment = writer_comment;
		this.main_content = main_content;
	}

	public int getSs_no() {
		return ss_no;
	}

	public void setSs_no(int ss_no) {
		this.ss_no = ss_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter_comment() {
		return writer_comment;
	}

	public void setWriter_comment(String writer_comment) {
		this.writer_comment = writer_comment;
	}

	public String getMain_content() {
		return main_content;
	}

	public void setMain_content(String main_content) {
		this.main_content = main_content;
	}

	public String getWriter_day() {
		return writer_day;
	}

	public void setWriter_day(String writer_day) {
		this.writer_day = writer_day;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public int getVisiable() {
		return visiable;
	}

	public void setVisiable(int visiable) {
		this.visiable = visiable;
	}
	
	
}
