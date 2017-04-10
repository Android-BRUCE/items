package cn.zrcx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zrcx.action.form.MybatisChoose;
import cn.zrcx.dao.MenuDao;
import cn.zrcx.entity.Menu;
import cn.zrcx.service.MenuService;
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

	@Resource
	private MenuDao menuDao;	
	@Override
	public List<Menu> getListOfMenu() {
		return menuDao.getListOfMenu();
	}
	@Override
	public List<Menu> getListOfMenus(MybatisChoose list) {
		// TODO Auto-generated method stub
		return menuDao.getListOfMenus(list);
	}

}
