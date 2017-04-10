package cn.zrcx.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.zrcx.action.form.EmailForm;
import cn.zrcx.action.form.EmailparameterType;
import cn.zrcx.action.form.RoleDimForm;
import cn.zrcx.cutpage.PageView;
import cn.zrcx.cutpage.RecordResult;
import cn.zrcx.entity.Email;
import cn.zrcx.entity.Role;
import cn.zrcx.service.EmailService;
import cn.zrcx.service.EmployeeService;
import cn.zrcx.service.RoleService;
import cn.zrcx.utils.JsonDateValueProcessor;

@Controller
@Scope("prototype")
@RequestMapping("/Email")
public class EmailAction {
	
	@Resource
	private EmailService eamilService;
	@Resource
	private RoleService roleService;
	@Resource
	private EmployeeService employeeService;
	@RequestMapping(value="/Email_save.action",method=RequestMethod.POST)
	public String save(@RequestParam("imageFile") MultipartFile  imageFile,EmailForm ef,HttpServletRequest request){
		String filepath=null;
		System.out.println("*******************************************888");
		try{
			String path=request.getSession().getServletContext().getRealPath("/upload/images");
			File saveDir=new File(path);
			if(!saveDir.exists()) saveDir.mkdirs();
			String originalFilename=imageFile.getOriginalFilename();
			String extName=originalFilename.substring(originalFilename.lastIndexOf("."));
			String fileName=UUID.randomUUID().toString()+extName;
			File saveFile=new File(saveDir,fileName);
			InputStream fis=imageFile.getInputStream();
			FileOutputStream fos=new FileOutputStream(saveFile);
			byte[] buffer=new byte[1024];
			int len=0;
			while((len=fis.read(buffer))!=-1)
			{
				fos.write(buffer,0,len);
			}
			fos.close();
			fis.close();
		 filepath= "/upload/icon/"+fileName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int send1 = ef.getR_id();
		int send = 1;
		Email eamil = new Email(ef.getEmail_state(),send,send1,ef.getEmail_title(),filepath,ef.getEmail_content(),new Date());
		eamilService.save(eamil);
		System.out.println("**************************");
		return "forward:/My.jsp";
	}
	@RequestMapping(value="/Email_query.action")
	public String query(HttpServletRequest request,EmailForm ef,HttpServletResponse response,EmailparameterType ea) throws IOException{
		
		PageView<Email> pageView = new PageView<Email>(ef.getCurrentPage(), 5);
		ea.setPageSize(pageView.getPageSize());
		ea.setEmail_sendman(1);
		List<Email> listEmail= eamilService.getEmailById(ea);
		for (int i = 0; i < listEmail.size(); i++) {
			Email email =new Email();
			 email = listEmail.get(i);
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 String Email_senddate = sdf.format(email.getEmail_senddate());
			 email.setEmail_senDate(Email_senddate);
			int receive =email.getEmail_receive();
			String receivename = eamilService.getEmialreceive(receive);
			email.setReceivename(receivename);
		}
		RecordResult<Email> recordResult = new RecordResult<Email>();
		recordResult.setRecords(listEmail);
		int totalRecord = eamilService.queryToltleSize();
		pageView.setTotalRecords(totalRecord);
		request.setAttribute("listEmail", listEmail);
		request.setAttribute("pageView", pageView);
		return "forward:/message.jsp";
		
	}
	@RequestMapping(value="/Email_delete.action")
	public String delete(EmailForm ef){
		int ids = ef.getEmail_id();
		eamilService.delete(ids); 
		return "forward:/Email/Email_query.action";
	}
	@RequestMapping(value="/Email_receive.action")
	public String receive(HttpServletRequest request,EmailForm ef,HttpServletResponse response,EmailparameterType ea){
		PageView<Email> pageView = new PageView<Email>(ef.getCurrentPage(), 5);
		ea.setPageSize(pageView.getPageSize());
		ea.setEmail_sendman(1);
		List<Email> listEmail= eamilService.getByIdreceive(ea);
		for (int i = 0; i < listEmail.size(); i++) {
			Email email =new Email();
			 email = listEmail.get(i);
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 String Email_senddate = sdf.format(email.getEmail_senddate());
			 email.setEmail_senDate(Email_senddate);
			int sendman =email.getEmail_sendman();
			String sendman1 = eamilService.getEmialreceive(sendman);
			email.setSendman(sendman1);
		}
		RecordResult<Email> recordResult = new RecordResult<Email>();
		recordResult.setRecords(listEmail);
		int totalRecord = eamilService.queryToltleSize1();
		pageView.setTotalRecords(totalRecord);
		request.setAttribute("listEmail", listEmail);
		request.setAttribute("pageView", pageView);
		return "forward:/message-give.jsp";
	}
	//获取发件人的下拉框
	@RequestMapping(value="/Email_box.action")
	public String box(HttpServletRequest request,EmailForm ef,HttpServletResponse response,EmailparameterType ea){
		List<Role> role = roleService.getAllRoles();
		for (Role role2 : role) {
			int rid = role2.getR_id();
			String rname = role2.getR_name();
			String employeeName = employeeService.getENameById(rid);
			String boxname = employeeName+"--"+rname;
			role2.setBoxname(boxname);
		}
		request.setAttribute("role", role);
		return "forward:/message-seed.jsp";
	}
	@RequestMapping(value="/Email_replybox.action")
	public String replybox(HttpServletRequest request,EmailForm ef){
		int rid =  ef.getEmail_sendman();
		String employeeName = employeeService.getENameById(rid);
		Role role1 =roleService.getRoleInfoById(rid);
		String boxname = employeeName+"--"+role1.getR_name();
		role1.setBoxname(boxname);
		List<Role> role = new ArrayList<Role>();
		role.add(role1);
		request.setAttribute("role", role);
		return "forward:/message-seed.jsp";
		
	}
}
