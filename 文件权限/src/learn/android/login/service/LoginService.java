package learn.android.login.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;

public class LoginService {
	/**
	 * 保存用户密码的业务方法
	 * @param username 用户名
	 * @param password 用户密码
	 * @param mode 1 私有 2可读 3可写  4公开
	 * @return ture saveok flase
	 */
	public static boolean saveUserInfo(Context context, String username, 
			String password, int mode){
		try{
			
			
			// FileOutputStream fos = context.openFileOutput("private.txt", Context.MODE_PRIVATE);
			FileOutputStream fos = null;
			switch (mode){
			case 1:
				fos = context.openFileOutput("private.txt", Context.MODE_PRIVATE);
			case 2:
				fos = context.openFileOutput("readble.txt", 
						Context.MODE_WORLD_READABLE);
			case 3:
				fos = context.openFileOutput("writeable.txt", Context.MODE_WORLD_WRITEABLE);
			case 4:
				fos = context.openFileOutput("public.txt", Context.MODE_WORLD_READABLE + 
						Context.MODE_WORLD_WRITEABLE);
				break;
			}
			fos.write((username + "##" + password).getBytes());
			fos.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
}
