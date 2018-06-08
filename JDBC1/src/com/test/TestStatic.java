package com.test;

public class TestStatic {

	public static void main(String[] args) throws Exception {
		new MyStatic();
		Class.forName("com.test.MyStatic");

	}

}
