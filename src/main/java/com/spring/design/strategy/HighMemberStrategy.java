/**
 * 
 */
package com.spring.design.strategy;

/**
 * 高级会员
 * 
 * @author dushaohua 2018年7月26日 下午12:45:27
 */
public class HighMemberStrategy implements MemberStrategy {

    @Override
    public double discountPrice(double price) {
        return price * 0.8;
    }

}
