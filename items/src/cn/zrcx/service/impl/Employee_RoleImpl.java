package cn.zrcx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zrcx.action.form.EmployeeAndRole;
import cn.zrcx.action.form.EmployeeRoles;
import cn.zrcx.action.form.UserDimForm;
import cn.zrcx.action.form.employeeForm;
import cn.zrcx.cutpage.PageView;
import cn.zrcx.dao.Employee_RoleDao;
import cn.zrcx.entity.Employee;
import cn.zrcx.entity.Position;
import cn.zrcx.entity.ProjectEmployeeFromItems;
import cn.zrcx.service.Employee_RoleService;

@Service("employee_Role")
@Transactional
public class Employee_RoleImpl implements Employee_RoleService {
	
	@Resource
	private Employee_RoleDao employee_RoleDao;
	@Override
	public List<Position> position() {
		// TODO Auto-generated method stub
		return employee_RoleDao.position();
	}
	@Override
	public void saveUser(employeeForm employeeForm) {
		// TODO Auto-generated method stub
		employee_RoleDao.saveUser(employeeForm);
	}
	@Override
	public int getTotleNum(UserDimForm
			userDimForm) {
		// TODO Auto-generated method stub
		return employee_RoleDao.getTotleNum(userDimForm);
	}
	@Override
	public <T> List<Employee> getEmployeeOrderLimit(PageView<T> pageView) {
		// TODO Auto-generated method stub
		return employee_RoleDao.getEmployeeOrderLimit(pageView);
	}
	@Override
	public Employee getSingleEmployeeById(int e_id) {
		// TODO Auto-generated method stub
		return employee_RoleDao.getSingleEmployeeById(e_id);
	}
	@Override
	public String getPositionByEmployeeId(int e_id) {
		// TODO Auto-generated method stub
		return employee_RoleDao.getPositionByEmployeeId(e_id);
	}
	@Override
	public void saveEditEmployee(employeeForm employeeForm) {
		// TODO Auto-generated method stub
		employee_RoleDao.saveEditEmployee(employeeForm);
	}
	@Override
	public void insertIntoRoleAndEmployee(EmployeeAndRole employeeAndRole) {
		// TODO Auto-generated method stub
		employee_RoleDao.insertIntoRoleAndEmployee(employeeAndRole);
	}
	@Override
	public List<EmployeeRoles> getRoles(int e_id) {
		// TODO Auto-generated method stub
		return employee_RoleDao.getRoles(e_id);
	}
	@Override
	public void deleteEmployeeAndRoles(int e_id) {
		// TODO Auto-generated method stub
		employee_RoleDao.deleteEmployeeAndRoles(e_id);
	}
	@Override
	public void deleteEmployeeByID(int e_id) {
		// TODO Auto-generated method stub
		employee_RoleDao.deleteEmployeeByID(e_id);
	}
	@Override
	public List<ProjectEmployeeFromItems> getProjectEmployeeFromItems() {
		// TODO Auto-generated method stub getProjectEmployeeFromItems
		return employee_RoleDao.getProjectEmployeeFromItems();
	}

}
