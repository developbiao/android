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
 * Bug :空指针异常
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
		
		//寻找控件
		et_username = (EditText) this.findViewById(R.id.et_username);
		et_password = (EditText) this.findViewById(R.id.et_password);
		cb = (CheckBox) this.findViewById(R.id.cb_remember_pwd);
		
		//检查是否有保存的用户名 密码信息
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
			Toast.makeText(this, "用户名或者密码不能为空", Toast.LENGTH_SHORT).show();
			
		}else {
			//判断是否保存密码
			if (cb.isChecked()){
				//保存用户名密码
				Log.i(TAG, "需要保存用户名密码");
				boolean result = LoginService.saveUserInfo(this, username, password);
				if (result){
					Toast.makeText(this, "密码已保存", 0).show();
				}else{
					Toast.makeText(this, "密码没有存", 0).show();
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
