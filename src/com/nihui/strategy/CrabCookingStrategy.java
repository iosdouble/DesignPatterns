package com.nihui.strategy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CrabCookingStrategy implements ItemListener {

	private JFrame f;
	private JRadioButton qz,hs;
	private JPanel CenterJP,SouthJP;
	private Kitchen cf;
	private CrabCooking qzx,hsx;
	
	CrabCookingStrategy(){
		f = new JFrame("策略模式在制作大闸蟹中的应用");
		f.setBounds(100, 100, 500, 400);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SouthJP = new JPanel();
		CenterJP = new JPanel();
		f.add("South",SouthJP);
		f.add("Center",CenterJP);
		
		qz = new JRadioButton("清蒸大闸蟹");
		hs = new JRadioButton("红烧大闸蟹");
		
		qz.addItemListener(this);
		hs.addItemListener(this);
		
		ButtonGroup group =new ButtonGroup();
		
		group.add(qz);
		group.add(qz);
		
		SouthJP.add(qz);
		SouthJP.add(hs);
		
		cf = new Kitchen();
		qzx =new SteamedCrabs();
		hsx = new BraisedCrabs();
		
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {

		JRadioButton jc = (JRadioButton) e.getSource();
		if(jc==qz) {
			cf.setStrategy(qzx);
			cf.CookingMethod();
		}
		else if(jc == hs) {
			cf.setStrategy(hsx);
			cf.CookingMethod();
		}
		CenterJP.removeAll();
		CenterJP.repaint();
		CenterJP.add((Component)cf.getStrategy());
		f.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new CrabCookingStrategy();
	}

}


/**
 * 抽象策略类
 * @author nihui
 *
 */
interface CrabCooking{
	public void CookingMethod();
}

/**
 * 实现大闸蟹做法一
 * @author nihui
 *
 */
class SteamedCrabs extends JLabel implements CrabCooking{

	@Override
	public void CookingMethod() {
		this.setIcon(new ImageIcon("src/com/nihui/strategy/image/SteamedCrabs.jpg"));
		this.setHorizontalAlignment(CENTER);
		
	}
	
}
/***
 * 实现大闸蟹做法二
 * @author nihui
 *
 */
class BraisedCrabs extends JLabel implements CrabCooking{

	@Override
	public void CookingMethod() {
		this.setIcon(new ImageIcon("src/com/nihui/strategy/image/BraisedCrabs.jpg"));
		this.setHorizontalAlignment(CENTER);
		
	}
	
}


class Kitchen{
	private CrabCooking  strategy;// 抽象策略

	public CrabCooking getStrategy() {
		return strategy;
	}

	public void setStrategy(CrabCooking strategy) {
		this.strategy = strategy;
	}
	
	
	public void CookingMethod(){
		strategy.CookingMethod();
	}
	
}
