package com.gy.daemon.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by yang_gao on 2017/10/11.
 */
@Component
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public String getBeansName() {
        if (context != null) {
            String[] beansName = context.getBeanDefinitionNames();
            StringBuilder bNs = new StringBuilder(64);
            for (String beanName : beansName) {
                bNs.append(beanName).append("\n");
            }
            return bNs.toString();
        }
        return null;
    }
}
