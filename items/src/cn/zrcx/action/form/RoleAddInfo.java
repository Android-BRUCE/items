package cn.zrcx.action.form;

public class RoleAddInfo {
	
	private int r_id;
	private String r_name;
	private int r_state;
	private String r_comment;
	private String r_number;
	
	private int menu_id;
	private int menu_location;
	
	
	
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getMenu_location() {
		return menu_location;
	}
	public void setMenu_location(int menu_location) {
		this.menu_location = menu_location;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public int getR_state() {
		return r_state;
	}
	public void setR_state(int r_state) {
		this.r_state = r_state;
	}
	public String getR_comment() {
		return r_comment;
	}
	public void setR_comment(String r_comment) {
		this.r_comment = r_comment;
	}
	public String getR_number() {
		return r_number;
	}
	public void setR_number(String r_number) {
		this.r_number = r_number;
	}
	
}
