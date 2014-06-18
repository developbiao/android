package learn.android.sdcard.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

public class LoginService {
	/**
	 * �����û������ҵ�񷽷�
	 * @param username �û���
	 * @param password �û�����
	 * @return ture saveok flase
	 */
	public static boolean saveUserInfo(Context context, String username, String password){
		try{
			//Environment ���ֻ��Ļ����ж�
			if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
			File file = new File(Environment.getExternalStorageDirectory(), "info.txt");
			
			FileOutputStream fos = new FileOutputStream(file);
			fos.write((username + "##" + password).getBytes());
			fos.close();
			return true;
			}else{
				Toast.makeText(context,"SD������������", 0);
				return false;
			}
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
		File file = new File(Environment.getExternalStorageDirectory(), "info.txt");
		
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
