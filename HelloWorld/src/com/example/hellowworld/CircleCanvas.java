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

	//���������ʷ
	
	public List<CircleInfo> mCircleInfos = new ArrayList<CircleCanvas.CircleInfo>();
	
	//����ʵ��Բ�����Ϣ��
	public static class CircleInfo{
		private float x;  //Բ�ĺ�����
		private float y; //Բ��������
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

		private int color;  //���ʵ���ɫ
		
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
		//���ݱ���Ļ�����ʷ�ػ����е�ʵ��Բ
		for (CircleInfo circleInfo : mCircleInfos){
			Paint paint = new Paint();
			//����Բ����ɫ
			
			paint.setColor(circleInfo.getColor());
			//����ʵ��Բ
			
			canvas.drawCircle(circleInfo.getX(), circleInfo.getY(), circleInfo.getRadius(), paint);
		}
	}
	
	//�������ػ�ʱ���ø÷�����Canvas ��ʾ�������󣬿����ڸö��󣬻��ƻ���ͼ��
	
	

}
