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
		//���ز���
		setContentView(R.layout.activity_main);
		//���ҵ���ť
		Button bt_dail = (Button) this.findViewById(R.id.bt_dail);
		//�����ı���
		et_number = (EditText) MainActivity.this.findViewById(R.id.et_number);
		//����ťע������¼� //1������һ���ڲ��������¼�
		
		/**
		 * ��ť�¼�������д��
		 */
		//��һ��д���ڲ���ķ�ʽ
		//bt_dail.setOnClickListener(new MyListener());  //MyListener
		
		//�ڶ��ַ���new �ӿڵ������ڲ���
		
//		bt_dail.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				String number = et_number.getText().toString().trim();
//				if (TextUtils.isEmpty(number)){
//					Toast toast = Toast.makeText(MainActivity.this, "���벻��Ϊ��", Toast.LENGTH_SHORT);
//					toast.show();
//					return;
//				}
//				//��ͼ����һ������
//				Intent intent = new Intent();
//				//���ˣ��ݲ�
//				intent.setAction(Intent.ACTION_CALL);
//				//url uri  ͳһ��Դ��ʶ��λ��
//				intent.setData(Uri.parse("tel:" + number));
//				startActivity(intent);
//				
//			}
//			
//		});
		
		
		//�����ַ���
		bt_dail.setOnClickListener(this);
		
		
	}

	private class MyListener implements OnClickListener{
		/**
		 * ����ť�������ʱ����õķ���
		 */
		@Override
		public void onClick(View v) {
			//EditText et_number =(EditText) MainActivity.this.findViewById(R.id.et_number);
			//��ȡ����ĺ���
			callPhone();

		}

		private void callPhone() {
			String number = et_number.getText().toString().trim();
			if (TextUtils.isEmpty(number)){
				Toast toast = Toast.makeText(MainActivity.this, "���벻��Ϊ��", Toast.LENGTH_SHORT);
				toast.show();
				return;
			}
			//��ͼ����һ������
			Intent intent = new Intent();
			//���ˣ��ݲ�
			intent.setAction(Intent.ACTION_CALL);
			//url uri  ͳһ��Դ��ʶ��λ��
			intent.setData(Uri.parse("tel:" + number));
			startActivity(intent);
		}
		
	}

	@Override 
	public void onClick(View v) {
		// ʵ�ֵ���¼�
		
			String number = et_number.getText().toString().trim();
			if (TextUtils.isEmpty(number)){
				Toast toast = Toast.makeText(MainActivity.this, "���벻��Ϊ��", Toast.LENGTH_SHORT);
				toast.show();
				return;
			}
			//��ͼ����һ������
			Intent intent = new Intent();
			//���ˣ��ݲ�
			intent.setAction(Intent.ACTION_CALL);
			//url uri  ͳһ��Դ��ʶ��λ��
			intent.setData(Uri.parse("tel:" + number));
			startActivity(intent);
		
	}
}
