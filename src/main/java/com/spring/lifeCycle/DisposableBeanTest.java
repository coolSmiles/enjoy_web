/**
 * 
 */
package com.spring.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author dushaohua 2018年7月24日 下午3:58:07
 */
public class DisposableBeanTest implements DisposableBean, InitializingBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBeanTest is destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DisposableBeanTest is afterPropertiesSet");
    }

}
