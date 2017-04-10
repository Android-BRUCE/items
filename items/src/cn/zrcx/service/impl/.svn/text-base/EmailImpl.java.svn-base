package cn.zrcx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zrcx.action.form.EmailparameterType;
import cn.zrcx.cutpage.PageView;
import cn.zrcx.dao.EmailDao;
import cn.zrcx.entity.Email;
import cn.zrcx.service.EmailService;
@Service("eamilService")
@Transactional
public class EmailImpl implements EmailService {

	@Resource
	private EmailDao emaildao;
	
	@Override
	public void save(Email eamil) {
		
		emaildao.save(eamil);
	}
	@Override
	public String getEmialreceive(int id) {
		
		return emaildao.getEmialreceive(id);
	}
	
	public void delete(int id) {
		
		emaildao.delete(id);
	}
	@Override
	public List<Email> getEmailById( EmailparameterType ea) {
		
		return emaildao.getEmailById(ea);
	}
	@Override
	public int queryToltleSize() {
		return emaildao.queryToltleSize();
	}
	@Override
	public List<Email> getByIdreceive(EmailparameterType ea) {
		
		return emaildao.getByIdreceive(ea);
	}
	@Override
	public int queryToltleSize1() {
		
		return emaildao.queryToltleSize1();
	}
}
