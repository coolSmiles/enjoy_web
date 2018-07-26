/**
 * 
 */
package com.spring.design.strategy;

/**
 * 算法一：对初级会员没有折扣。 　　
 * 算法二：对中级会员提供10%的促销折扣。 　　
 * 算法三：对高级会员提供20%的促销折扣。
 * 
 * @author dushaohua 2018年7月26日 下午12:37:53
 */
public interface MemberStrategy {

    double discountPrice(double price);

}
