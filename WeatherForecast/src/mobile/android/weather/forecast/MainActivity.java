package mobile.android.weather.forecast;

import static moblie.android.weather.forecast.service.WeatherService.getWeatherInfos;

import java.util.List;

import moblie.android.weather.forecast.service.WeatherService;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView tv = (TextView) this.findViewById(R.id.tv);
		try{
			//类加载器方法获取镜像资源
			List<WeatherInfo> infos = WeatherService.getWeatherInfos(MainActivity.class.getClassLoader().getResourceAsStream("weather.xml")
					);
			StringBuffer sb = new StringBuffer();
			for (WeatherInfo info:infos){
				String str = info.toString();
				sb.append(str);
				sb.append("\n\n");
			}
			
			tv.setText(sb.toString());
			
		}catch(Exception e){
			e.printStackTrace();
			Toast.makeText(this, "解析信息失败",0).show();
}
		
	}

	
}
