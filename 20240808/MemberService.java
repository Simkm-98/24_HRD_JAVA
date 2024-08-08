package day03;

public class MemberService {
	
	
	
	public boolean login(String id, String pw) {
		boolean result = false;
		if(id.equals("hong") && pw.equals("12345")) {
			result = true;
		}
		return result;
	}
	
	public void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}
}
