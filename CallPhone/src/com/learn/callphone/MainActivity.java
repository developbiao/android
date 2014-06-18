package com.learn.callphone;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
private EditText et_number;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//加载布局
		setContentView(R.layout.activity_main);
		//查找到按钮
		Button bt_dail = (Button) this.findViewById(R.id.bt_dail);
		//查找文本框
		et_number = (EditText) MainActivity.this.findViewById(R.id.et_number);
		//给按钮注册点点击事件 //1、创建一个内部定义点击事件
		
		/**
		 * 按钮事件的四种写法
		 */
		//第一种写法内部类的方式
		//bt_dail.setOnClickListener(new MyListener());  //MyListener
		
		//第二种方法new 接口的匿名内部类
		
//		bt_dail.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				String number = et_number.getText().toString().trim();
//				if (TextUtils.isEmpty(number)){
//					Toast toast = Toast.makeText(MainActivity.this, "号码不能为空", Toast.LENGTH_SHORT);
//					toast.show();
//					return;
//				}
//				//意图想做一件事情
//				Intent intent = new Intent();
//				//打人，泡茶
//				intent.setAction(Intent.ACTION_CALL);
//				//url uri  统一资源标识定位符
//				intent.setData(Uri.parse("tel:" + number));
//				startActivity(intent);
//				
//			}
//			
//		});
		
		
		//第三种方法
		bt_dail.setOnClickListener(this);
		
		
	}

	private class MyListener implements OnClickListener{
		/**
		 * 当按钮被点击的时候调用的方法
		 */
		@Override
		public void onClick(View v) {
			//EditText et_number =(EditText) MainActivity.this.findViewById(R.id.et_number);
			//获取输入的号码
			callPhone();

		}

		private void callPhone() {
			String number = et_number.getText().toString().trim();
			if (TextUtils.isEmpty(number)){
				Toast toast = Toast.makeText(MainActivity.this, "号码不能为空", Toast.LENGTH_SHORT);
				toast.show();
				return;
			}
			//意图想做一件事情
			Intent intent = new Intent();
			//打人，泡茶
			intent.setAction(Intent.ACTION_CALL);
			//url uri  统一资源标识定位符
			intent.setData(Uri.parse("tel:" + number));
			startActivity(intent);
		}
		
	}

	@Override 
	public void onClick(View v) {
		// 实现点击事件
		
			String number = et_number.getText().toString().trim();
			if (TextUtils.isEmpty(number)){
				Toast toast = Toast.makeText(MainActivity.this, "号码不能为空", Toast.LENGTH_SHORT);
				toast.show();
				return;
			}
			//意图想做一件事情
			Intent intent = new Intent();
			//打人，泡茶
			intent.setAction(Intent.ACTION_CALL);
			//url uri  统一资源标识定位符
			intent.setData(Uri.parse("tel:" + number));
			startActivity(intent);
		
	}
}
