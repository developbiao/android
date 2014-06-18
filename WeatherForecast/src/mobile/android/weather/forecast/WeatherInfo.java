package mobile.android.weather.forecast;

public class WeatherInfo {
	private int id;
	
	private String name;
	private String wind;
	private String weather;
	private String temp;
	private String pm;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	@Override
	public String toString() {
		return "[城市id= "+ id +", 名称="+ name +", 风力=" + wind +" " +
				", + 天气状况=" + weather + ", 温度= " + temp +",pm2.5 = "+ pm +"]";
	}
	
	
}
