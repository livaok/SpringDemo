package com.example.demo.fruits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author liva
 */

public class Apple{

	private Banana banana;
	private String name;

	public void setBanana(Banana banana) {
		this.banana = banana;
	}

	@Autowired
	@Qualifier("1")
	public void eat(Banana banana) throws FruitNullException {
		if (banana == null){
			throw new FruitNullException("ERROR");
		}
		else System.out.println(banana.toString());
	}

	@Autowired
	public void printS(String banana) {
		System.out.println(banana);
	}

	@Autowired
	@Qualifier("b")
	public void see(Banana banana) {
		System.out.println(banana.toString());
	}

	public void print(){
		System.out.println("Print");
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}
