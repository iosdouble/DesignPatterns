package com.nihui.strategy;

public class StrategyPattern {
	public static void main(String[] args) {
		Context c = new Context();
		Strategy s = new ConcreteStrategyA();
		c.setStrategy(s);
		c.strategyMethod();
		System.out.println("-----------------");
		s = new ConcreteStrategyB();
		c.setStrategy(s);
		c.strategyMethod();
	}
}

/**
 * 抽闲策略类
 * @author nihui
 *
 */
interface Strategy{
	public void strategyMethod();
}

/**
 * 具体策略类A
 * @author nihui
 *
 */
class ConcreteStrategyA implements Strategy{
	public void strategyMethod() {
		System.out.println("具体策略A的策略方法被访问！");
	}
}

/***
 * 具体策略类B
 * @author nihui
 *
 */
class ConcreteStrategyB implements Strategy{
	public void strategyMethod() {
		System.out.println("具体策略B的策略方法被访问！");
	}
}

/***
 * 环境类
 * @author nihui
 *
 */
class Context{
	private Strategy strategy;

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void strategyMethod() {
		strategy.strategyMethod();
	}
	
}
