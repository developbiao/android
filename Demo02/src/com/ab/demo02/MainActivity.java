package com.ab.demo02;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		private AutoCompleteTextView = acTextView;
		/**
		 * 第一步：初始化一个控件
		 * 第二步:需要一个适配器
		 * 第三步：初始化数据源--这个源去匹配输入文本框中的内容
		 * 第四步：将adpter与当前AutoComplieTextView绑定
		 */
		acTextView = findViewById(R.id.autoCompleteTextView1);
		
		

	}

}
