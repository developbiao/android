package com.example.hellowworld;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class CircleCanvas  extends View{
	
	public CircleCanvas(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	//保存绘制历史
	
	public List<CircleInfo> mCircleInfos = new ArrayList<CircleCanvas.CircleInfo>();
	
	//保存实心圆相关信息类
	public static class CircleInfo{
		private float x;  //圆心横坐标
		private float y; //圆心纵坐标
		private float radius;
		public float getRadius() {
			return radius;
		}

		public void setRadius(float radius) {
			this.radius = radius;
		}

		public int getColor() {
			return color;
		}

		public void setColor(int color) {
			this.color = color;
		}

		public void setY(float y) {
			this.y = y;
		}

		private int color;  //画笔的着色
		
		public float getX(){
			return x;
		}
		
		public void setX(float x){
			this.x = x;
		}
		
		public float getY(){
			return y;
		}
		
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		//根据保存的绘制历史重绘所有的实心圆
		for (CircleInfo circleInfo : mCircleInfos){
			Paint paint = new Paint();
			//设置圆画笔色
			
			paint.setColor(circleInfo.getColor());
			//绘制实心圆
			
			canvas.drawCircle(circleInfo.getX(), circleInfo.getY(), circleInfo.getRadius(), paint);
		}
	}
	
	//当画布重绘时调用该方法，Canvas 表示画布对象，可以在该对象，绘制基本图形
	
	

}
