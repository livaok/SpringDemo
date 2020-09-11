package com.example.demo.fruits;

import org.aspectj.lang.annotation.*;

/**
 * @author liva
 */


@Aspect
public class Audit {

	private String name;

	@Pointcut("execution(* com.example.demo.fruits.Apple.print(..))")
	public void audit(){            //имя среза

	}

	@Before("audit()")
	public void beforePrint() {
		System.out.println("Before print");
	}

	@AfterReturning("audit()")
	public void afterPrint(){
		System.out.println("After print");
	}

	@AfterThrowing("audit()")
	public void throwPrint(){
		System.out.println("Throw print");
	}

	@Pointcut("execution(* com.example.demo.fruits.Apple.setName(String)) && args(name))")
	public void printName(String name){

	}

	@Before(value = "printName(name)", argNames = "name")
	public void print(String name){
		this.name = name;
		System.out.println(name);
	}

}

