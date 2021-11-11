package org.duongnhieu.utils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class FormUtil {
    public static <T> T toClass(Class<T> tClass, HttpServletRequest request) {
        T object = null;
        try {
            object = tClass.newInstance();
            BeanUtils.populate(object, request.getParameterMap());
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            System.out.println("Form util error " + e.getMessage());
        }
        return object;
    }
}
