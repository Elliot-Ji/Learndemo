package com.example.pattern.state;

/**
 * 状态模式:
 * 1.状态模式的角色与职责
 *      1.1)Context类为环境角色,用于维护State实例,这个实例定义当前状态;
 *      1.2)State是抽象状态角色,定义一个接口封装与Context的一个特定接口 相关行为;
 *      1.3)ConcreteState具体的状态角色,每个子类实现一个与Context的一个状态相关行为;
 * Created by Elliot Ji on 2019/9/17.
 */
public abstract class State {

    //扣除积分
    public abstract void deductMoney();

    //是否抽中奖品
    public abstract boolean raffle();

    //发放奖品
    public abstract void dispensePrize();

}
