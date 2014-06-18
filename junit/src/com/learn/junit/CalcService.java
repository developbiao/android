package com.learn.junit;

import android.util.Log;
import junit.framework.TestCase;

public class CalcService extends TestCase {
	private String tag = "CalcService";
	public int add(int x, int y){
		/**
		 * 计算器相加简单业务
		 * @param x
		 * @param y
		 * 
		 */
		Log.v(tag, "x=" + x);
		Log.d(tag, "y=" + y);
		int result = x + y;
		Log.i(tag, "resutl" + result);
		Log.w(tag, "result" + result);
		Log.e(tag, "result" + result);
		return result;
		
	}
}
