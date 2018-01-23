package com.bridgeLabz.LoginRegistrationWithSpringBoot.service;

public class Abc implements Runnable {

	@Override
	public void run() {
		System.out.println("jhsdbflkusgdfbh");
		
	}
	
	public static void main(String[] args) {
		Abc abc = new Abc();
		Thread thread = new Thread(abc);
		thread.start();
		Thread thread31 = new Thread(abc);
		thread31.start();
		Thread thread13 = new Thread(abc);
		thread13.start();
		Thread thread2 = new Thread(abc);
		Thread thread3= new Thread(abc);
		Thread thread4 = new Thread(abc);
		Thread thread5 = new Thread(abc);
		
	}
	
}
