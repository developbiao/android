package moblie.android.show.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DatetimeActivity extends Activity implements OnClickListener{
	
	@Override
	public void onClick(View v){
		switch (v.getId()) {
		case R.id.btnShowTime:
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//显示当前日期
			showDialog("当前日期",sdf.format(new Date()));
			break;
	
		case R.id.tt:
	
			SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
			//显示当前时间
			showDialog("当前时间", sdf2.format(new Date()));
			break;
		}
		
	}

	private void showDialog(String title, String msg){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		//设置对话框的图标
		builder.setIcon(android.R.drawable.ic_dialog_info);
		//设置对话框的标题
		builder.setTitle(title);
		//设置对话框显示的信息
		builder.setMessage(msg);
		//设置对话框的按钮
		builder.setPositiveButton("确定", null);
		//显示对话框
		builder.create().show();
	}
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_datetime);
		//获取两个按钮对象实例
		Button btnShowDate= (Button)findViewById(R.id.btnShowTime);
		Button btnShowTime = (Button)findViewById(R.id.tt);
		
		//为两个按钮添加单击事件
		btnShowDate.setOnClickListener(this);
		btnShowTime.setOnClickListener(this);
		
	}


}
