package cn.zrcx.action.form;

public class RoleDimForm {
	private int cid;
	private String keyword;
	public final static int QUERY_NUMBER = 1;
	public final static int QUERY_NAME = 2;
	public final static int QUERY_STATE= 3;
	//select * form role where  condition = result
	private String condition;
	private String result;
	
	
	
	
	public String getCondition() {
		return condition;
	}
	public String getResult() {
		return result;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		if(cid==QUERY_NUMBER){condition="r_number";}
		else if(cid==QUERY_NAME){condition="r_name";}
		else if(cid==QUERY_STATE){condition="r_state";}
		this.cid = cid;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		result = "'%"+keyword+"%'";
		this.keyword = keyword;
	}
	
	
}
