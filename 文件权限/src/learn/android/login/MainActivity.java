package learn.android.login;

import java.util.Map;

import learn.android.login.service.LoginService;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private EditText et_username;
	private EditText et_password;
	private CheckBox cb;
	private RadioGroup rg_mode;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//寻找控件
		et_username = (EditText) this.findViewById(R.id.et_username);
		et_password = (EditText) this.findViewById(R.id.et_password);
		cb = (CheckBox) this.findViewById(R.id.cb_remember_pwd);
		rg_mode = (RadioGroup) findViewById(R.id.rg_mode);
		
	}
	/**
	 * login
	 * @param view
	 */
	public void login(View view){
		String username = et_username.getText().toString().trim();
		String password = et_password.getText().toString().trim();
		if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
			Toast.makeText(this, "用户名或者密码不能为空", Toast.LENGTH_SHORT).show();
			
		}else {
			//判断是否保存密码
			if (cb.isChecked()){
				//保存用户名密码
				Log.i(TAG, "需要保存用户名密码");
				boolean result = false;
				int id = rg_mode.getCheckedRadioButtonId();
				switch (id){
				case R.id.rd_private:
					result = LoginService.saveUserInfo(this, username, password, 1);
					break;
				case R.id.rd_writeable:
					result = LoginService.saveUserInfo(this, username, password, 2);
					break;
				case R.id.rd_readble:
					result = LoginService.saveUserInfo(this, username, password, 3);
					break;
				case R.id.rd_public:
					result = LoginService.saveUserInfo(this, username, password, 4);
					break;
				}
				
				if (result){
					Toast.makeText(this, "密码已保存", 0);
				}else{
					Toast.makeText(this, "密码没有存", 0);
				}
			}
			//登陆发送消息到服务器，服务器验证是否正确
			
			if ("zhangsan".equals(username) && "123".equals(password)){
				Toast.makeText(this, "登陆成功", 0).show();
			}else{
				Toast.makeText(this, "登陆失败，用户名或者密码错误", 0).show();
			}
			
			
		}
	}


}
