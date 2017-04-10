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
	 * ��ȡ���е�ְλ��Ϣ
	 * @return
	 */
	public List<Position> position();
	/**
	 * ���employee��Ա��Ϣ
	 * @param employeeForm ������û���ȡ
	 */
	public void saveUser(employeeForm employeeForm);
	/**
	 * ��ѯuser������
	 * @return ��������ѯ�������
	 */
	public int getTotleNum(UserDimForm userDimForm);
	/**
	 * user��ҳ��ѯ��ҳ
	 * @param pageView
	 * @return
	 */
	public <T> List<Employee> getEmployeeOrderLimit(PageView<T> pageView);
	/**
	 * ͨ��e_id��ȡemployee
	 * @param e_id
	 * @return
	 */
	public Employee getSingleEmployeeById(int e_id);
	/**
	 * ����༭���Ա����Ϣ
	 * @param employee
	 */
	public void saveEditEmployee(employeeForm employeeForm);
	/**
	 * 
	 */
	public String getPositionByEmployeeId(int e_id);
	/**
	 * employee_role�м��
	 * @param employeeAndRole
	 */
	public void insertIntoRoleAndEmployee(EmployeeAndRole employeeAndRole);
	public List<EmployeeRoles> getRoles(int e_id);
	public void deleteEmployeeAndRoles(int e_id);
	public void deleteEmployeeByID(int e_id);
	/**
	 * ��ȡ����employee�еľ���
	 * @return List<ProjectEmployeeFromItems>
	 */
	public List<ProjectEmployeeFromItems> getProjectEmployeeFromItems();
}
