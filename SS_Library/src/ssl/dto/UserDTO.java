package ssl.dto;

public class UserDTO
{
	private int user_no;
	private String email;
	private String password;
	private String nickname;
	private int visiable;
	private int admin;
	
	public UserDTO() {} // 기본 생성자
	
	// 이메일, 패스워드, 닉네임만 있는 생성자.
	// 회원 가입 시 이용함.
	public UserDTO(String email, String password, String nickname) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}
	
	// 회원 번호, 이메일, 닉네임, 정지여부, 관리자 여부만 가지고 있는 생성자.
	// 사이트 내부에서 세션으로 가지고 있는 객체.
	public UserDTO(int user_no, String email, String nickname, int visiable, int admin) {
		super();
		this.user_no = user_no;
		this.email = email;
		this.nickname = nickname;
		this.admin = admin;
		this.visiable = visiable;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public int getVisiable() {
		return visiable;
	}

	public void setVisiable(int visiable) {
		this.visiable = visiable;
	}
	
}
