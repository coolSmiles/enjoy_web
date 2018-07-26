/**
 * 
 */
package com.spring.design.strategy;

/**
 * 初级会员
 * 
 * @author dushaohua 2018年7月26日 下午12:41:27
 */
public class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double discountPrice(double price) {
        return price;
    }

}
