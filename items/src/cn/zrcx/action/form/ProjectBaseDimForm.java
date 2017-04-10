package cn.zrcx.action.form;

public class ProjectBaseDimForm {
	private int eid;
	private String keyword;
	public final static int QUERY_NAME = 1;
	public final static int QUERY_POSITION = 2;
	public final static int QUERY_SEX= 3;
	public final static int QUERY_STATE= 4;
	//select * form role where  condition = result
	private String condition;
	private String result;
	private int time;
	private String sort;
	
	
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		
		if(time==1){
			this.sort="e_startdate";
		}
		else if(time==2){
			this.sort="e_afterdate";
		}
		this.time = time;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getCondition() {
		return condition;
	}
	public String getResult() {
		return result;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		if(eid==QUERY_NAME){condition="e_name";}
		else if(eid==QUERY_POSITION){condition="position_id";}
		else if(eid==QUERY_SEX){condition="e_sex";}
		else if(eid==QUERY_STATE){condition="e_state";}
		this.eid = eid;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		result = "'%"+keyword+"%'";
		this.keyword = keyword;
	}
	
	
}
