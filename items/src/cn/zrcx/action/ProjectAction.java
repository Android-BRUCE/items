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
	 * ����ְλ�Ǿ��������
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
	//�������ݵ�excel
		@SuppressWarnings("deprecation")
		@RequestMapping("/exportExcel.do")
		public String export(HttpServletResponse response) throws Exception{
			//System.out.println("+++");
			PageView<ProjectBaseShow> pageView = new PageView<ProjectBaseShow>(0, 0);
			List<ProjectBaseShow> companyList = baseService.getAllProjectItems(pageView);
			//String aa = companyList.get(0).getI_finishdate().toLocalDate().toString();
			//System.out.println(aa);
			//����Ǵ����ݿ�����ȡ���� userList
			//List<Company_information> companyList = companyService.findAllUser(lis);// �û�����
			//System.out.println("CompanyAction�������ݵ�����:"+lis);
			/*
			 * ���ñ�ͷ����Excelÿ��ȡ��(���������ȡ�����ݱ�д)
			 */
			String[] tableHeader = { "�ͻ���������", "��˾����", "����ʱ��", "��Ŀ����", "״̬", "��Ŀ����", "����ʱ��",
			"�ƻ����ʱ��","������Ա��"};
			/*
			 * ����Ķ����Կ������ñ�д
			 */
			short cellNumber = (short) tableHeader.length;// �������
			HSSFWorkbook workbook = new HSSFWorkbook(); // ����һ��excel
			HSSFCell cell = null; // Excel����
			HSSFRow row = null; // Excel����
			HSSFCellStyle style = workbook.createCellStyle(); // ���ñ�ͷ������
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCellStyle style1 = workbook.createCellStyle(); // ������������
			style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFFont font = workbook.createFont(); // ��������
			HSSFSheet sheet = workbook.createSheet("sheet1"); // ����һ��sheet
			HSSFHeader header = sheet.getHeader();// ����sheet��ͷ
			try {
				/**
				 * �����Ƿ�ȡ�����ݣ�����header��Ϣ
				 * 
				 */
				if (companyList.size() < 1) {
					header.setCenter("��������");
				} else {
					//System.out.println("�������ĳߴ�="+companyList);
					header.setCenter("��˾��");
					row = sheet.createRow(0);
					row.setHeight((short) 400);
					for (int k = 0; k < cellNumber; k++) {
						cell = row.createCell(k);// ������0�е�k��
						cell.setCellValue(tableHeader[k]);// ���õ�0�е�k�е�ֵ
						sheet.setColumnWidth(k, 5000);// �����еĿ��
						font.setColor(HSSFFont.COLOR_NORMAL); // ���õ�Ԫ���������ɫ.
						font.setFontHeight((short) 200); // ���õ�Ԫ����߶�
						style1.setFont(font);// ����������
						cell.setCellStyle(style1);
					}
					/*
					 * // ��excel�������������Ҫ��д
					 */
					for (int i = 0; i < companyList.size(); i++) {
						ProjectBaseShow lis = (ProjectBaseShow) companyList.get(i);// ��ȡcompany����
						row = sheet.createRow((short) (i + 1));// ������i+1��
						row.setHeight((short) 400);// �����и�

						if (lis.getC_linkman() != null) {
							cell = row.createCell(0);// ������i+1�е�0��
							cell.setCellValue(lis.getC_linkman());// ���õ�i+1�е�0�е�ֵ
							cell.setCellStyle(style);// ���÷��
						}
						if (lis.getC_companyname() != null) {//�Լ����� ����ϵ�˲���Ϊ��
							cell = row.createCell(1); // ������i+1�е�1��

							cell.setCellValue(lis.getC_companyname());// ���õ�i+1�е�1�е�ֵ

							cell.setCellStyle(style); // ���÷��
						}
						// ��������ĺ�����Ļ�����ͬ���Ͳ���ע����
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
			 * ����Ŀ��Բ��ñ�д��ֱ�ӿ���
			 */
			//HttpServletResponse response = null;// ����һ��HttpServletResponse����
				OutputStream out = null;// ����һ�����������
				try {
				//response = ServletActionContext.getResponse();// ��ʼ��HttpServletResponse����
					out = response.getOutputStream();//
					response.setHeader("Content-disposition", "attachment; filename="
							+ "company.xls");// filename�����ص�xls���������������Ӣ��
					response.setContentType("application/msexcel;charset=UTF-8");// ��������
					response.setHeader("Pragma", "No-cache");// ����ͷ
					response.setHeader("Cache-Control", "no-cache");// ����ͷ
					response.setDateHeader("Expires", 0);// ��������ͷ
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
