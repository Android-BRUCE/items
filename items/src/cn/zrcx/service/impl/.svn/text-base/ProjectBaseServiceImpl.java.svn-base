package cn.zrcx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zrcx.action.form.ProjectAddFrom;
import cn.zrcx.action.form.ProjectBaseDimForm;
import cn.zrcx.cutpage.PageView;
import cn.zrcx.dao.ProjectBaseDao;
import cn.zrcx.entity.ProjectBaseShow;
import cn.zrcx.service.ProjectBaseService;

@Service("ProjectBaseService")
@Transactional
public class ProjectBaseServiceImpl implements ProjectBaseService {
	
	@Resource
	private ProjectBaseDao baseDao;

	@Override
	public void saveProjectItems(ProjectAddFrom projectAddFrom) {
		// TODO Auto-generated method stub
		baseDao.saveProjectItems(projectAddFrom);
	}

	@Override
	public <T> List<ProjectBaseShow> getAllProjectItems(PageView<T> pageView) {
		// TODO Auto-generated method stub
		return baseDao.getAllProjectItems(pageView);
	}
	@Override
	public int getToltalNum(ProjectBaseDimForm baseDimForm) {
		// TODO Auto-generated method stub
		return baseDao.getToltalNum(baseDimForm);
	}
}
