package com.gy.daemon.config;

import com.gy.daemon.dto.MetricInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by yang_gao on 2017/10/11.
 */

@Component
public class RequestFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Long beginQuest = System.currentTimeMillis();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        String servletPath = request.getServletPath();
        MetricInfo metricInfo = new MetricInfo();
        metricInfo.setRequestPath(servletPath);
        metricInfo.setRequestParam(this.getRequestParam(servletRequest));

        filterChain.doFilter(servletRequest, servletResponse);
        metricInfo.setElapse(Long.toString(System.currentTimeMillis() - beginQuest));
        logger.info(metricInfo.toString());
    }

    @Override
    public void destroy() {

    }

    private String getRequestParam(ServletRequest request) {
        Enumeration<String> paramNames = request.getParameterNames();
        StringBuilder requestParam = new StringBuilder(64);
        if (null != paramNames) {
            requestParam.append("{");
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                if (null != paramName) {
                    requestParam
                            .append(paramName)
                            .append(":")
                            .append(request.getParameter(paramName));
                }
                requestParam.append(",");
            }
            if (requestParam.length() > 1) {
                requestParam.deleteCharAt(requestParam.length()-1);
            }
            requestParam.append("}");
        }
        return requestParam.toString();
    }
}
