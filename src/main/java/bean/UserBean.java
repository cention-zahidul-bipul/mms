
package bean;


public class UserBean{

	private String uName;
	private String password;
	private String fullName;
	private String role;
	private int uid;
	
	public void setUserID(int uid){
		this.uid=uid;
	}
	
	public void setUserName(String uName){
		this.uName=uName;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setFullName(String fullName){
		this.fullName=fullName;
	}
	public void setRole(String role){
		this.role=role;
	}

	public String getUserName(){
		return this.uName;
	}
	public String getPassword(){
		return this.password;
	}
	public String getFullName(){
		return this.fullName;
	}
	public String getRole(){
		return this.role;
	}
	public int getUserID(){
		return this.uid;
	}

}