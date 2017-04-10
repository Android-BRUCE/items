package cn.zrcx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zrcx.action.form.RoleAddInfo;
import cn.zrcx.action.form.RoleAndMenu;
import cn.zrcx.action.form.RoleDimForm;
import cn.zrcx.cutpage.PageView;
import cn.zrcx.dao.RoleDao;
import cn.zrcx.entity.Role;
import cn.zrcx.service.RoleService;


@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleDao roleDaol;
	@Override
	public void addRole(RoleAddInfo roleAddInfo) {
		// TODO Auto-generated method stub
		roleDaol.addRole(roleAddInfo);
	}
	@Override
	public void addTheOfRoleMenuCenter(RoleAndMenu roleAndMenu) {
		roleDaol.addTheOfRoleMenuCenter(roleAndMenu);
		
	}
	@Override
	public List<Role> getAllRoles() {
		return roleDaol.getAllRoles();
	}
	@Override
	public void deleteRole(int r_id) {
		// TODO Auto-generated method stub
		roleDaol.deleteRole(r_id);
	}
	@Override
	public void deleteRoleAndMenuFrom(int r_id) {
		roleDaol.deleteRoleAndMenuFrom(r_id);
		
	}
	@Override
	public Role getRoleInfoById(int r_id) {
		// TODO Auto-generated method stub
		return roleDaol.getRoleInfoById(r_id);
	}
	@Override
	public List<RoleAndMenu> getRoleAndMenuInfoById(int r_id) {
		// TODO Auto-generated method stub
		return roleDaol.getRoleAndMenuInfoById(r_id);
	}
	@Override
	public void saveEditRole(RoleAddInfo roleAddInfo) {
		roleDaol.saveEditRole(roleAddInfo);
		
	}
	@Override
	public <T> List<Role> queryRoles(PageView<T> pageView) {
		// TODO Auto-generated method stub
		return roleDaol.queryRoles(pageView);
	}
	@Override
	public int queryToltleSize() {
		// TODO Auto-generated method stub
		return roleDaol.queryToltleSize();
	}
	@Override
	public <T> List<Role> queryRolesByCondition(PageView<T> pageView) {
		// TODO Auto-generated method stub
		return roleDaol.queryRolesByCondition(pageView);
	}
	@Override
	public int queryToltleSizeByCondition(RoleDimForm roleDimForm) {
		// TODO Auto-generated method stub
		return roleDaol.queryToltleSizeByCondition(roleDimForm);
	}
}
