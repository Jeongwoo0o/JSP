package info.beans;

public class InfoBean {
	// property(멤버변수)명은 소문자로 시작
	private String name;
	private String id;
	
	// 추가함수
	public String getGender() {
		String gender = "";
		
		char sung = id.charAt(7);
		if		(sung == '1' || sung == '3') gender = "남성";
		else if	(sung == '2' || sung == '4') gender = "여성";
		else 	gender = "모름";
		
		return gender;
	}
	
	// setter, getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
