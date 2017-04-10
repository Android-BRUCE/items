package cn.zrcx.dao;

import java.util.List;

import cn.zrcx.action.form.RoleAddInfo;
import cn.zrcx.action.form.RoleAndMenu;
import cn.zrcx.action.form.RoleDimForm;
import cn.zrcx.cutpage.PageView;
import cn.zrcx.entity.Role;

public interface RoleDao {
	/**
	 * ���role��Ϣ������menu��Ϣ
	 * @param roleAddInfo
	 */
	public void addRole(RoleAddInfo roleAddInfo);
	
	public void addTheOfRoleMenuCenter(RoleAndMenu roleAndMenu);
	/**
	 * ��ȡ����role
	 */
	public List<Role> getAllRoles();
	/**
	 * ɾ��role����r_id
	 * @param r_id
	 */
	public void deleteRole(int r_id);
	/**
	 * ����r_idɾ���м������
	 * @param r_id
	 */
	public void deleteRoleAndMenuFrom(int r_id);
	/**
	 * ͨ��r_id�õ�����Ȩ��֮��������Ϣ
	 * @param r_id
	 * @return
	 */
	public Role getRoleInfoById(int r_id);
	/**
	 * ��ȡ�м��role��menu��Ϣ
	 * @param r_id
	 * @return
	 */
	public List<RoleAndMenu> getRoleAndMenuInfoById(int r_id);
	/**
	 * �޸�role��Ϣ������menu��Ϣ
	 * @param roleAddInfo
	 */
	public void saveEditRole(RoleAddInfo roleAddInfo);
	/**
	 * ��ҳ��ѯ
	 * @param <T>
	 * @param pageSize ÿҳ������
	 * @param pageNum �ڼ�ҳ
	 * @return List<Role>
	 */
	public <T> List<Role> queryRoles(PageView<T> pageView);
	/**
	 * ��ѯ�ܹ�������
	 * @return 
	 */
	public int queryToltleSize();
	/**
	 * ��������ѯ
	 * @param pageView 
	 * @return
	 */
	public <T> List<Role> queryRolesByCondition(PageView<T> pageView); 
	/**
	 * ��������ѯ����
	 */
	public int queryToltleSizeByCondition(RoleDimForm roleDimForm);
	}
