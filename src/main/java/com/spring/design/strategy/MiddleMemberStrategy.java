/**
 * 
 */
package com.spring.design.strategy;

/**
 * 中级会员
 * 
 * @author dushaohua 2018年7月26日 下午12:43:31
 */
public class MiddleMemberStrategy implements MemberStrategy {

    @Override
    public double discountPrice(double price) {
        return price * 0.9;
    }

}
