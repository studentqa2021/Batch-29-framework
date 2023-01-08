package com.regression;

import org.testng.annotations.Factory;

public class ConstructorPractice {
	
	//int salary = 10000;//global>> also not good
	int salary;//4000=3rd
	
	@Factory(dataProvider = "")//value from data provider== 4000
	public ConstructorPractice(int salary){//4000 =1st
		this.salary=salary;//4000=2nd
	}
	
	
	
	public void getSalary() {//good way
		//int salary = 5000;//local
		System.out.println("My salary method = "+salary);//not good==4th
	}

	public void getIncome() {//good way
		
		System.out.println("My income method = "+salary);//not good==5th
	}
	
	public static void main(String[] args) {
		ConstructorPractice obj = new ConstructorPractice(4000);//better way
		obj.getSalary();//good way
		obj.getIncome();
		
	}
}
