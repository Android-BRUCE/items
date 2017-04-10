package cn.zrcx.dao;

import java.util.List;

import cn.zrcx.action.form.RoleAddInfo;
import cn.zrcx.action.form.RoleAndMenu;
import cn.zrcx.action.form.RoleDimForm;
import cn.zrcx.cutpage.PageView;
import cn.zrcx.entity.Role;

public interface RoleDao {
	/**
	 * 添加role信息不包含menu信息
	 * @param roleAddInfo
	 */
	public void addRole(RoleAddInfo roleAddInfo);
	
	public void addTheOfRoleMenuCenter(RoleAndMenu roleAndMenu);
	/**
	 * 获取所有role
	 */
	public List<Role> getAllRoles();
	/**
	 * 删除role根据r_id
	 * @param r_id
	 */
	public void deleteRole(int r_id);
	/**
	 * 根据r_id删除中间表数据
	 * @param r_id
	 */
	public void deleteRoleAndMenuFrom(int r_id);
	/**
	 * 通过r_id拿到除了权限之外所有信息
	 * @param r_id
	 * @return
	 */
	public Role getRoleInfoById(int r_id);
	/**
	 * 获取中间表role和menu信息
	 * @param r_id
	 * @return
	 */
	public List<RoleAndMenu> getRoleAndMenuInfoById(int r_id);
	/**
	 * 修改role信息不包含menu信息
	 * @param roleAddInfo
	 */
	public void saveEditRole(RoleAddInfo roleAddInfo);
	/**
	 * 分页查询
	 * @param <T>
	 * @param pageSize 每页多少条
	 * @param pageNum 第几页
	 * @return List<Role>
	 */
	public <T> List<Role> queryRoles(PageView<T> pageView);
	/**
	 * 查询总共多少条
	 * @return 
	 */
	public int queryToltleSize();
	/**
	 * 按条件查询
	 * @param pageView 
	 * @return
	 */
	public <T> List<Role> queryRolesByCondition(PageView<T> pageView); 
	/**
	 * 按条件查询条数
	 */
	public int queryToltleSizeByCondition(RoleDimForm roleDimForm);
	}
