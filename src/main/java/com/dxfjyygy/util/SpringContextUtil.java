package com.dxfjyygy.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取Spring Bean的Utils类.
 * <p>
 * <br/>
 * <br/>
 * <b>Date:</b> 17/12/2017 16:47:25<br/>
 *
 * @author Jim
 * @version 1.0
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> List<T> getBeans(Class<T> clazz) {
        String[] beanNamesForType = applicationContext.getBeanNamesForType(clazz);
        ArrayList<T> ts = new ArrayList<>();
        for (String s : beanNamesForType) {
            ts.add((T) applicationContext.getBean(s));
        }
        return ts;
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }
}
