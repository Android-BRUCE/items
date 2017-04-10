package cn.zrcx.action;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.zrcx.action.form.ProjectAddFrom;
import cn.zrcx.action.form.ProjectBaseDimForm;
import cn.zrcx.cutpage.PageView;
import cn.zrcx.cutpage.RecordResult;
import cn.zrcx.dao.ProjectBaseDao;
import cn.zrcx.entity.CompanyAddJson;
import cn.zrcx.entity.CompanyNameJson;
import cn.zrcx.entity.ProjectBaseShow;
import cn.zrcx.entity.ProjectEmployeeFromItems;
import cn.zrcx.entity.Role;
import cn.zrcx.service.CustomerService;
import cn.zrcx.service.Employee_RoleService;
import cn.zrcx.service.ProjectBaseService;
import cn.zrcx.utils.JsonDateValueProcessor;

@Controller
@Scope("prototype")
@RequestMapping("/project")
public class ProjectAction{
	@Resource
	private CustomerService customerService;
	@Resource
	private Employee_RoleService employee_RoleService;
	@Resource
	private ProjectBaseService baseService;
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/project-base.do")
	public String jumpToBassInfo(){return "project-base";}
	@RequestMapping("/project-base-add.do")
	public String jumpToBassADD(){
		return "project-bass-add";
	}
	
	@RequestMapping("/project-getCompanyName.do")
	public void getCompanyNames(HttpServletResponse response) throws IOException{
		//CompanyNameJson 
		List<CompanyAddJson> addJsons = new ArrayList<CompanyAddJson>();
		
		List<CompanyNameJson> namesjson = customerService.getCompanyNameJson();
		for(int i=0;i<namesjson.size();i++){
			CompanyAddJson addJson = new CompanyAddJson();
			addJson.setC_id(namesjson.get(i).getC_id());
			addJson.setCompanyNameJson(namesjson.get(i));
			addJsons.add(addJson);
		}
		JSONArray json = JSONArray.fromObject(namesjson);
		response.getWriter().println(json);
	}
	/**
	 * 所有职位是经理的名字
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/project_getPosition.do")
	public void getss(HttpServletResponse response) throws IOException{
		List<ProjectEmployeeFromItems> employeeFromItems = employee_RoleService.getProjectEmployeeFromItems();
		JSONArray json = JSONArray.fromObject(employeeFromItems);
		response.getWriter().println(json);
	}
	@RequestMapping("/project-saveProject.do")
	public String projectADD(ProjectAddFrom projectAddFrom){
		//i_update
		projectAddFrom.setI_update(new java.util.Date());
		baseService.saveProjectItems(projectAddFrom);
		return "project-base";
	}
	
	@RequestMapping("/project_query_items.do")
	public void getproject_query_items(HttpServletResponse response,HttpServletRequest request) throws IOException{
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		
		PageView<ProjectBaseShow> pageView = new PageView<ProjectBaseShow>(currentPage, pageSize);
		List<ProjectBaseShow> baseShows = baseService.getAllProjectItems(pageView);
		
		RecordResult<ProjectBaseShow> recordResult = new RecordResult<ProjectBaseShow>();
		recordResult.setRecords(baseShows);
		ProjectBaseDimForm baseDimForm = new ProjectBaseDimForm();
		int num = baseService.getToltalNum(baseDimForm);
		recordResult.setTotalRecord(num);
		
	    JsonConfig jsonConfig = new JsonConfig();
	    jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor()); 
		JSONArray jsonArray=JSONArray.fromObject(recordResult.getRecords(),jsonConfig);
		
		response.getWriter().println("{\"total\":"+recordResult.getTotalRecord()+",\"rows\":"+jsonArray.toString()+"}");
	}
	//导出数据到excel
		@SuppressWarnings("deprecation")
		@RequestMapping("/exportExcel.do")
		public String export(HttpServletResponse response) throws Exception{
			//System.out.println("+++");
			PageView<ProjectBaseShow> pageView = new PageView<ProjectBaseShow>(0, 0);
			List<ProjectBaseShow> companyList = baseService.getAllProjectItems(pageView);
			//String aa = companyList.get(0).getI_finishdate().toLocalDate().toString();
			//System.out.println(aa);
			//如果是从数据库里面取数据 userList
			//List<Company_information> companyList = companyService.findAllUser(lis);// 用户集合
			//System.out.println("CompanyAction导出数据的内容:"+lis);
			/*
			 * 设置表头：对Excel每列取名(必须根据你取的数据编写)
			 */
			String[] tableHeader = { "客户方负责人", "公司名称", "立项时间", "项目经理", "状态", "项目名称", "更新时间",
			"计划完成时间","开发人员数"};
			/*
			 * 下面的都可以拷贝不用编写
			 */
			short cellNumber = (short) tableHeader.length;// 表的列数
			HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel
			HSSFCell cell = null; // Excel的列
			HSSFRow row = null; // Excel的行
			HSSFCellStyle style = workbook.createCellStyle(); // 设置表头的类型
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCellStyle style1 = workbook.createCellStyle(); // 设置数据类型
			style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFFont font = workbook.createFont(); // 设置字体
			HSSFSheet sheet = workbook.createSheet("sheet1"); // 创建一个sheet
			HSSFHeader header = sheet.getHeader();// 设置sheet的头
			try {
				/**
				 * 根据是否取出数据，设置header信息
				 * 
				 */
				if (companyList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					//System.out.println("导出表格的尺寸="+companyList);
					header.setCenter("公司表");
					row = sheet.createRow(0);
					row.setHeight((short) 400);
					for (int k = 0; k < cellNumber; k++) {
						cell = row.createCell(k);// 创建第0行第k列
						cell.setCellValue(tableHeader[k]);// 设置第0行第k列的值
						sheet.setColumnWidth(k, 5000);// 设置列的宽度
						font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色.
						font.setFontHeight((short) 200); // 设置单元字体高度
						style1.setFont(font);// 设置字体风格
						cell.setCellStyle(style1);
					}
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < companyList.size(); i++) {
						ProjectBaseShow lis = (ProjectBaseShow) companyList.get(i);// 获取company对象
						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						if (lis.getC_linkman() != null) {
							cell = row.createCell(0);// 创建第i+1行第0列
							cell.setCellValue(lis.getC_linkman());// 设置第i+1行第0列的值
							cell.setCellStyle(style);// 设置风格
						}
						if (lis.getC_companyname() != null) {//自己设置 的联系人不能为空
							cell = row.createCell(1); // 创建第i+1行第1列

							cell.setCellValue(lis.getC_companyname());// 设置第i+1行第1列的值

							cell.setCellStyle(style); // 设置风格
						}
						// 由于下面的和上面的基本相同，就不加注释了
						if (lis.getI_builddate() != null) {
							cell = row.createCell(2);
							cell.setCellValue(lis.getI_builddate().toLocalDate().toString());
							cell.setCellStyle(style);
						}
						if (lis.getE_name() != null) {  
							cell = row.createCell(3);
							cell.setCellValue(lis.getE_name());
							cell.setCellStyle(style);
						}
						if (lis.getI_state() !=-1) {
							cell = row.createCell(4);
							cell.setCellValue(lis.getI_state());
							cell.setCellStyle(style);
						}
						if (lis.getI_name() != null) {
							cell = row.createCell(5);
							cell.setCellValue(lis.getI_name());
							cell.setCellStyle(style);
						}
						if (lis.getI_update() != null) {
							cell = row.createCell(6);
							cell.setCellValue(lis.getI_update().toLocalDate().toString());
							cell.setCellStyle(style);
						}
						if (lis.getI_finishdate().toLocalDate().toString() != null) {
							cell = row.createCell(7);
							cell.setCellValue(lis.getI_finishdate().toLocalDate().toString());
							cell.setCellStyle(style);
						}
						if (lis.getI_number() != 0) {
							cell = row.createCell(8);
							cell.setCellValue(lis.getI_number());
							cell.setCellStyle(style);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*
			 * 下面的可以不用编写，直接拷贝
			 */
			//HttpServletResponse response = null;// 创建一个HttpServletResponse对象
				OutputStream out = null;// 创建一个输出流对象
				try {
				//response = ServletActionContext.getResponse();// 初始化HttpServletResponse对象
					out = response.getOutputStream();//
					response.setHeader("Content-disposition", "attachment; filename="
							+ "company.xls");// filename是下载的xls的名，建议最好用英文
					response.setContentType("application/msexcel;charset=UTF-8");// 设置类型
					response.setHeader("Pragma", "No-cache");// 设置头
					response.setHeader("Cache-Control", "no-cache");// 设置头
					response.setDateHeader("Expires", 0);// 设置日期头
					workbook.write(out);
					out.flush();
					workbook.write(out);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (out != null) {
							out.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return null;
				
		}
}
