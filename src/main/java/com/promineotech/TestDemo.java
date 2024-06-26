package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException ("Both parameters must be positive!");			
		} return a + b;
	} 
	
	public double multiplyPositive(double a, double b) {
		if(a <= 0 || b <= 0) {
			throw new IllegalArgumentException ("Both numbers must be positive!");
		} return a * b;
	}
	
	public int randomNumberSquared() {
		int num = getRandomInt();
		return num * num;
	}
	
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
