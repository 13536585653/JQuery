package com.test.filter;

import java.io.IOException;

import javax.print.attribute.standard.Severity;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {

    /**
     *  字符编码过滤. 
     */
	
	private String encoding;
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		
		
	}
                        
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig cfg) throws ServletException {
		
		//读取web.xml 里的EncodingFilter里的配置信息
		 this.encoding=cfg.getInitParameter("encoding");
		//System.out.println(encoding);
	}

	

}
