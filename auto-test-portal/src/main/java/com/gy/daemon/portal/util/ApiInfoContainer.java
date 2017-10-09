package com.gy.daemon.portal.util;

import com.gy.daemon.portal.annotaion.Api;
import com.gy.daemon.portal.annotaion.ApiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yang_gao on 2017/10/5.
 */

@Component
public class ApiInfoContainer implements ApplicationListener<ContextRefreshedEvent> {


    public ApiInfoContainer() {

    }

    private static int RUN_TIMES = 0;

    @Autowired
    private ContextHelper contextHelper;

    private static List<ApiInfo> API_LIST = new ArrayList<>();

    public List<ApiInfo> getAPIList() {
        return API_LIST;
    }

    private void getApiInfoFromContext() {
        ApplicationContext context = contextHelper.getContext();
        LocalVariableTableParameterNameDiscoverer nameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

        String[] controllers = context.getBeanNamesForAnnotation(RestController.class);

        for (String controller : controllers) {
            Class _class = context.getBean(controller).getClass();
            Method[] methods = _class.getDeclaredMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                String desc;
                Object response = null;
                Map<String, Object> requestParam = new HashMap<>();

                if (method.isAnnotationPresent(Api.class)) {
                    Api apiAnnotation = method.getAnnotation(Api.class);
                    desc = apiAnnotation.desc();
                    Class[] parameterTypes = method.getParameterTypes();
                    String[] requestNames = nameDiscoverer.getParameterNames(method);
                    for (int i = 0; i < requestNames.length; i++) {
                        try {
                            requestParam.put(requestNames[i], parameterTypes[i].newInstance());
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        response = method.getReturnType().newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    ApiInfo apiInfo = new ApiInfo(this.getHttpRequestMethod(method), methodName, desc, requestParam, response);
                    API_LIST.add(apiInfo);
                }
            }
        }
    }

    private String getHttpRequestMethod(Method method) {
        if (method.isAnnotationPresent(GetMapping.class)) {
            return "GET";
        } else if (method.isAnnotationPresent(PostMapping.class)) {
            return "POST";
        } else if (method.isAnnotationPresent(PutMapping.class)) {
            return "PUT";
        } else if (method.isAnnotationPresent(DeleteMapping.class)) {
            return "DELETE";
        } else {
            if (method.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                RequestMethod[] methods = requestMapping.method();
                StringBuilder md = new StringBuilder();
                for (RequestMethod requestMethod : methods) {
                    md.append(requestMapping.toString()).append("|");
                }
                md.deleteCharAt(md.length() - 1);
                return md.toString();
            } else {
                return "UNKNOWN";
            }
        }

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        RUN_TIMES++;
        if (RUN_TIMES == 1) {
            // make sure only run once!
            this.getApiInfoFromContext();
        }
        
        // todo [yang_gao] update or insert apiInfo into dataBase
    }
}
