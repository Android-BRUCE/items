package cn.zrcx.dao;

import java.util.List;

import cn.zrcx.action.form.MybatisChoose;
import cn.zrcx.entity.Menu;

public interface MenuDao {
	
	public List<Menu> getListOfMenu();
	/**
	 * ����menu_id���飬��ȡmenu������
	 * @param arry
	 * @return
	 */
	public List<Menu> getListOfMenus(MybatisChoose list);
	
	//public List<>
	 
}
