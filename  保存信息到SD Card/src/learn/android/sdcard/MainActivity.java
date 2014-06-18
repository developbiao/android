package learn.android.sdcard;

import java.util.Map;

import learn.android.sdcard.service.LoginService;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Bug :��ָ���쳣
 * @author GONGBIAO
 *
 */
public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private EditText et_username;
	private EditText et_password;
	private CheckBox cb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Ѱ�ҿؼ�
		et_username = (EditText) this.findViewById(R.id.et_username);
		et_password = (EditText) this.findViewById(R.id.et_password);
		cb = (CheckBox) this.findViewById(R.id.cb_remember_pwd);
		
		//����Ƿ��б�����û��� ������Ϣ
		Map<String, String> map = LoginService.getSavedUserInfo(this);
		et_username.setText(map.get("username"));
		et_password.setText(map.get("password"));
	}
	/**
	 * login
	 * @param view
	 */
	public void login(View view){
		String username = et_username.getText().toString().trim();
		String password = et_password.getText().toString().trim();
		if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
			Toast.makeText(this, "�û����������벻��Ϊ��", Toast.LENGTH_SHORT).show();
			
		}else {
			//�ж��Ƿ񱣴�����
			if (cb.isChecked()){
				//�����û�������
				Log.i(TAG, "��Ҫ�����û�������");
				boolean result = LoginService.saveUserInfo(this, username, password);
				if (result){
					Toast.makeText(this, "�����ѱ���", 0).show();
				}else{
					Toast.makeText(this, "����û�д�", 0).show();
				}
			}
			//��½������Ϣ������������������֤�Ƿ���ȷ
			
			if ("zhangsan".equals(username) && "123".equals(password)){
				Toast.makeText(this, "��½�ɹ�", 0).show();
			}else{
				Toast.makeText(this, "��½ʧ�ܣ��û��������������", 0).show();
			}
			
			
		}
	}


}
