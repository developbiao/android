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
			//��ʾ��ǰ����
			showDialog("��ǰ����",sdf.format(new Date()));
			break;
	
		case R.id.tt:
	
			SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
			//��ʾ��ǰʱ��
			showDialog("��ǰʱ��", sdf2.format(new Date()));
			break;
		}
		
	}

	private void showDialog(String title, String msg){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		//���öԻ����ͼ��
		builder.setIcon(android.R.drawable.ic_dialog_info);
		//���öԻ���ı���
		builder.setTitle(title);
		//���öԻ�����ʾ����Ϣ
		builder.setMessage(msg);
		//���öԻ���İ�ť
		builder.setPositiveButton("ȷ��", null);
		//��ʾ�Ի���
		builder.create().show();
	}
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_datetime);
		//��ȡ������ť����ʵ��
		Button btnShowDate= (Button)findViewById(R.id.btnShowTime);
		Button btnShowTime = (Button)findViewById(R.id.tt);
		
		//Ϊ������ť��ӵ����¼�
		btnShowDate.setOnClickListener(this);
		btnShowTime.setOnClickListener(this);
		
	}


}
