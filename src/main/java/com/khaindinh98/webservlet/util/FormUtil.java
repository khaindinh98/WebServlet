package com.khaindinh98.webservlet.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class FormUtil {

    private BeanUtils beanUtils;

    public static FormUtil formUtil;

    private FormUtil(){
        //do nothing
        this.beanUtils = new BeanUtils();
    }
    public static FormUtil getInstance(){
        if(FormUtil.formUtil==null){
            FormUtil.formUtil = new FormUtil();
        }
        return FormUtil.formUtil;
    }

    public <T> T toModel(HttpServletRequest req, Class<T> tClass){
        try {
            T model = tClass.getConstructor().newInstance();
            this.beanUtils.populate(model, req.getParameterMap());
            return model;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
