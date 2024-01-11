package org.example;

public class Main3 {
	public static void main(String[] args){
		Thread thread = new NewTread();
		thread.start();
	}

	private static class NewTread extends Thread{
		@Override
		public void run() {
			System.out.println("Hello from " + this.getName());
		}
	}
}
