package com.learn.test;

import com.learn.junit.CalcService;

public class TestCalcService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalcService  service = new CalcService();
		int value = service.add(5, 8);
		System.out.println("value:" + value);

	}

}
