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
	 * �����û������ҵ�񷽷�
	 * @param username �û���
	 * @param password �û�����
	 * @return ture saveok flase
	 */
	public static boolean saveUserInfo(Context context, String username, String password){
		try{
			//String dir = context.getFilesDir().toString();
			//Context ������
			//File file = new File("/data/data/learn.android.login/info.log");
			File file = new File(context.getFilesDir(), "info.log");
			

			
			FileOutputStream fos = new FileOutputStream(file);
			fos.write((username + "##" + password).getBytes());
			fos.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * ��ȡ���������
	 * @param context
	 * @return
	 */
	public static  Map<String, String> getSavedUserInfo(Context context){
		File file = new File(context.getFilesDir(), "info.log");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String str = br.readLine();
			//zhangsan##123
			String[] infos = str.split("##");
			Map<String, String>map = new HashMap<String, String>();
			map.put("username", infos[0]);
			map.put("password", infos[1]);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
