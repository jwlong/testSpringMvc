package com.dxfjyygy.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class WebUtil {
    

    public static Object getSessionAttribute(String name) {
        return getRequest().getSession().getAttribute(name);
    }
    
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
    }
    
    public static boolean isAjaxRequest(HttpServletRequest request) {
        if (request.getHeader("content-type") != null && request.getHeader("content-type").contains("application/json")) {
            return true;
        }
        
        if (StringUtils.equalsIgnoreCase("XMLHttpRequest", request.getHeader("X-Requested-With"))) {
            return true;
        }
        
        return false;
    }
    
    public static Locale getUserLocale(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Locale)session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
    }
    
}
