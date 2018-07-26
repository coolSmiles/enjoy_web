/**
 * 
 */
package com.spring.design.strategy;

/**
 * @author dushaohua 2018年7月26日 下午12:47:08
 */
public class ContextMemberStrategy {

    private final MemberStrategy memberStrategy;

    /**
     * @param memberStrategy
     */
    public ContextMemberStrategy(MemberStrategy memberStrategy) {
        super();
        this.memberStrategy = memberStrategy;
    }

    public double discountPrice(double price) {
        return memberStrategy.discountPrice(price);
    }

    public static void main(String[] args) {

        // 出入具体的等级的会员
        MiddleMemberStrategy middle = new MiddleMemberStrategy();
        ContextMemberStrategy context = new ContextMemberStrategy(middle);

        double discountPrice = context.discountPrice(9);

        System.out.println(discountPrice);

    }

}
