package cn.zrcx.filter;

import java.io.IOException;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class EcodingFilter implements Filter
{
	private String encoding;

	public void init(FilterConfig config) throws ServletException 
	{
		encoding = config.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//System.out.println("处理乱码");
		// 转换成带http协议
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// POST中文乱码
		request.setCharacterEncoding(encoding);
		// Response输出乱码问题
		response.setContentType("text/html;charset=" + encoding);
		request = new EncodingRequest(request);
		chain.doFilter(request, response);
	}

	class EncodingRequest extends HttpServletRequestWrapper
	{
		private HttpServletRequest request;
		private boolean hasEncode = false;

		public EncodingRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
		}

		public String getParameter(String name) {
			// 通过getParameterMap方法完成
			String[] values = getParameterValues(name);
			if (values == null) {
				return null;
			}
			return values[0];
		}

		public String[] getParameterValues(String name) {
			// 通过getParameterMap方法完成
			Map<String, String[]> parameterMap = getParameterMap();
			String[] values = parameterMap.get(name);
			return values;
		}

		public Map getParameterMap() {
			Map<String, String[]> parameterMap = request.getParameterMap();
			String method = request.getMethod();
			if (method.equalsIgnoreCase("post")) {
				return parameterMap;
			}
			return parameterMap;
		}
	}

	public void destroy()
	{
	}

}
