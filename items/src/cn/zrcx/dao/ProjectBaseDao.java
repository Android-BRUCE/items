package cn.zrcx.dao;

import java.util.List;

import cn.zrcx.action.form.ProjectAddFrom;
import cn.zrcx.action.form.ProjectBaseDimForm;
import cn.zrcx.cutpage.PageView;
import cn.zrcx.entity.ProjectBaseShow;
import cn.zrcx.service.impl.ProjectBaseServiceImpl;

public interface ProjectBaseDao {
	/**
	 * 保存items基本信息
	 * @param projectAddFrom
	 */
	public void saveProjectItems(ProjectAddFrom projectAddFrom);
	/**
	 * 获取所有的project（带模糊查询分页）
	 * @return List<ProjectBaseShow>
	 */
	public <T> List<ProjectBaseShow> getAllProjectItems(PageView<T> pageView);
	/**
	 * 查询一共多少数据(带模糊查询)
	 * @return int
	 */
	public int getToltalNum(ProjectBaseDimForm baseDimForm);
}
