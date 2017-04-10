package cn.zrcx.dao;

import cn.zrcx.action.form.LoginInfo;
import cn.zrcx.entity.Employee;

public interface CheckLoginDao {
	public Employee getEmployee(Employee info);
	public Employee getEmployee2(LoginInfo info);
	public String getENameById(int id);
}
