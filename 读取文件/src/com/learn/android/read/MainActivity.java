package com.learn.android.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void readPrivate(View v){  //记得加入View 加载视图
		try{
		File file = new File("/data/data/learn.android.login/files/info.log");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader bufr = new BufferedReader(new InputStreamReader(fis));
		String result = bufr.readLine();
		Toast.makeText(this, result, 0);
		bufr.close();
		}catch (Exception e){
			
			e.printStackTrace();
			Toast.makeText(this, "读取私有文件失败", 0).show();
		}
		
		
	}


}
