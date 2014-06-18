package moblie.android.weather.forecast.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

import mobile.android.weather.forecast.WeatherInfo;

public class WeatherService {
	public static List<WeatherInfo> getWeatherInfos(InputStream is) throws Exception{
		XmlPullParser parser = Xml.newPullParser();
		//��ʼ��������
		parser.setInput(is, "utf-8");
		List<WeatherInfo> weatherInofs = null;
		WeatherInfo weatherInfo = null;
		//�¼�����
		int type = parser.getEventType();
		while (type != XmlPullParser.END_DOCUMENT){
			switch (type){
			case XmlPullParser.START_TAG:
				if ("infos".equals(parser.getName())){
					//������ȫ�ֿ�ʼ�ı�ǩ
					weatherInofs = new ArrayList<WeatherInfo>();
				}else if("city".equals(parser.getName())){
					weatherInfo = new WeatherInfo();
					String idStr = parser.getAttributeValue(0);
					weatherInfo.setId(Integer.parseInt(idStr));
				}else if ("temp".equals(parser.getName())){
					String temp = parser.nextText();
					weatherInfo.setTemp(temp);
				}else if ("weather".equals(parser.getName())){
					String weather = parser.nextText();
					weatherInfo.setWeather(weather);
				}else if ("wind".equals(parser.getName())){
					String wind = parser.nextText();
					weatherInfo.setWind(wind);
				}else if ("pm".equals(parser.getName())){
					String pm = parser.nextText();
					weatherInfo.setPm(pm);
				}
				break;
			case XmlPullParser.END_TAG:
				if ("city".equals(parser.getName())){
					//һ�����е���Ϣ�Ѿ����������
					weatherInofs.add(weatherInfo);
					weatherInfo = null;
				}
				break;
				
			}
			type = parser.next();
			
		}
		return weatherInofs;
	}
}
