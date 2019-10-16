package com.nihui.proxy;

public class ProxyTest {

	public static void main(String[] args) {
		Proxy proxy = new Proxy();
		proxy.Request();
	}
}

/**
 * 抽象主题
 * @author nihui
 *
 */
interface Subject{
	void Request();
}

class RealSubject implements Subject{

	@Override
	public void Request() {
		System.out.println("调用真实主题方法！");		
	}
	
}

class Proxy implements Subject{

	private RealSubject realSubject;
	
	@Override
	public void Request() {
		if(realSubject==null) {
			realSubject = new RealSubject();
		}
		preRequest();
		realSubject.Request();
		postRequest();
		
	}
	
	public void preRequest() {
		System.out.println("访问真实对象之前的预处理");
	}
	
	public void postRequest() {
		System.out.println("访问真实对象之后的后处理");
	}
	
}


