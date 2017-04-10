package cn.zrcx.action;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cn.zrcx.action.form.LoginInfo;
import cn.zrcx.entity.Employee;
import cn.zrcx.service.EmployeeService;
import cn.zrcx.service.MenuService;


@Controller
@Scope("prototype")
@RequestMapping("/login")
public class LoginAction {
	@Resource
	private EmployeeService employeeService;

	
	@RequestMapping("/Login_check.do")
	public String checkLogin(LoginInfo info,HttpSession httpSession){
		Employee employee = employeeService.getEmployee2(info);
		if(employee != null){
			httpSession.setAttribute("employee",employee);
			return "index";
			//return new ModelAndView(new RedirectView("/items/WEB-INF/main/index.jsp"));
		}
	//	ModelAndView view = new ModelAndView();
	//	view.addObject("{\"message\":", "\"保存成功\"}");
		return "redirect: /items/login.jsp";
	}
	
	/*@RequestMapping("/Login_check.do")
	public void checkLogin(LoginInfo info,HttpSession httpSession,HttpServletResponse response) throws IOException{
		Employee emp = new Employee();
		emp.setE_name(info.getName());
		emp.setE_password(info.getPassword());
		Employee employee = employeeService.getEmployee(emp);
		if(employee == null){
			httpSession.setAttribute("employee",employee);
			//进入
			System.out.println("++++++++++++++++++++++++");
			
		}
		System.out.println("###############################");
		System.out.println(info.getName()+"/t" + info.getPassword());
	     response.setContentType("text/html;charset=utf-8");
	     response.getWriter().println("{\"message\":\"保存成功\"}");
	}*/
	@RequestMapping("/exit.do")
	public String exit(HttpSession httpSession){
		httpSession.removeAttribute("employee");
		return "redirect: /items/login.jsp";
	}
}
