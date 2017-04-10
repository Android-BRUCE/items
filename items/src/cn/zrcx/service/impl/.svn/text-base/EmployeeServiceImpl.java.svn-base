package cn.zrcx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zrcx.action.form.LoginInfo;
import cn.zrcx.dao.CheckLoginDao;
import cn.zrcx.entity.Employee;
import cn.zrcx.service.EmployeeService;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	
	
	@Resource
	private CheckLoginDao checkLoginDao;

	@Override
	public Employee getEmployee(Employee info) {
		// TODO Auto-generated method stub
		return checkLoginDao.getEmployee(info);
	}

	@Override
	public Employee getEmployee2(LoginInfo info) {
		// TODO Auto-generated method stub
		return checkLoginDao.getEmployee2(info);
	}

	/**
	 * 
	 */
	public String getENameById(int id) {
		
		return checkLoginDao.getENameById(id);
	}

}
