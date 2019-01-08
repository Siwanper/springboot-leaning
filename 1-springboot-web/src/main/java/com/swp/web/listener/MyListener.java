package com.swp.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 描述:
 * 1.ServletContextListener -- 监听servletContext对象的创建以及销毁
 * 2.HttpSessionListener  -- 监听session对象的创建以及销毁
 * 3.ServletRequestListener -- 监听request对象的创建以及销毁
 * 4.ServletContextAttributeListener  -- 监听servletContext对象中属性的改变
 * 5.HttpSessionAttributeListener  --监听session对象中属性的改变
 * 6.ServletRequestAttributeListener  --监听request对象中属性的改变
 * @outhor ios
 * @create 2019-01-03 3:00 PM
 */
public class MyListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("---------------------------->请求销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("---------------------------->请求创建");
    }
}
