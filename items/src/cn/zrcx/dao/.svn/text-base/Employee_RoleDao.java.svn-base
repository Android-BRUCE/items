package cn.zrcx.dao;

import java.util.List;

import cn.zrcx.action.form.EmployeeAndRole;
import cn.zrcx.action.form.EmployeeRoles;
import cn.zrcx.action.form.UserDimForm;
import cn.zrcx.action.form.employeeForm;
import cn.zrcx.cutpage.PageView;
import cn.zrcx.entity.Employee;
import cn.zrcx.entity.Position;
import cn.zrcx.entity.ProjectEmployeeFromItems;

public interface Employee_RoleDao {
	/**
	 * 获取所有的职位信息
	 * @return
	 */
	public List<Position> position();
	/**
	 * 添加employee雇员信息
	 * @param employeeForm 从添加用户获取
	 */
	public void saveUser(employeeForm employeeForm);
	/**
	 * 查询user总条数
	 * @return 带参数查询条数或空
	 */
	public int getTotleNum(UserDimForm userDimForm);
	/**
	 * user首页查询分页
	 * @param pageView
	 * @return
	 */
	public <T> List<Employee> getEmployeeOrderLimit(PageView<T> pageView);
	/**
	 * 通过e_id获取employee
	 * @param e_id
	 * @return
	 */
	public Employee getSingleEmployeeById(int e_id);
	/**
	 * 保存编辑后的员工信息
	 * @param employee
	 */
	public void saveEditEmployee(employeeForm employeeForm);
	/**
	 * 
	 */
	public String getPositionByEmployeeId(int e_id);
	/**
	 * employee_role中间表
	 * @param employeeAndRole
	 */
	public void insertIntoRoleAndEmployee(EmployeeAndRole employeeAndRole);
	public List<EmployeeRoles> getRoles(int e_id);
	public void deleteEmployeeAndRoles(int e_id);
	public void deleteEmployeeByID(int e_id);
	/**
	 * 获取所有employee中的经理
	 * @return List<ProjectEmployeeFromItems>
	 */
	public List<ProjectEmployeeFromItems> getProjectEmployeeFromItems();
}
