package com.example.hellowworld;

import android.os.Bundle;
import java.util.Random;

import com.example.hellowworld.CircleCanvas.CircleInfo;

import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends Activity {

	private CircleCanvas mCircleCanvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup viewGroup = (ViewGroup)getLayoutInflater().inflate(R.layout.activity_main, null);
        mCircleCanvas = new CircleCanvas(this);  //����CircleCanvas�������ࣩ����
        //��CircleCanvas������ӵ���ǰ�������ͼ��(�����������·�)
        viewGroup.addView(mCircleCanvas, new LayoutParams(LayoutParams.FILL_PARENT,350));
        setContentView(viewGroup);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    //��ʼ�������Բ��(��һ����ť�ĵ����¼�)
    
   public void onClick_DrawRandomXCircle(View view){
	   Random random = new Random();
	    float randomX = (float)(100 + random.nextInt(100));  //�������Բ�ĺ�����(100��200)
	    float randomY = (float)(100 + random.nextInt(100));
	    float randomRadius = (float)(20 + random.nextInt(40));  //�������Բ�İ뾶(20-60)
	    int randomColor = 0;
	    
	    if (random.nextInt(100) > 50){
	    	randomColor = Color.BLUE;
	    }
	    else{
	    	if (random.nextInt(100) > 50){
	    		randomColor = Color.RED;
	    	}
	    	else{
	    		randomColor = Color.GREEN;
	    	}
	    	
	    }
	   CircleInfo circleInfo = new CircleInfo();
	   circleInfo.setX(randomX);
	   circleInfo.setY(randomY);
	   circleInfo.setRadius(randomRadius);
	   circleInfo.setColor(randomColor);
	   mCircleCanvas.mCircleInfos.add(circleInfo);
	   mCircleCanvas.invalidate();
	    
   }
   
   //��ջ������ڶ�����ť��
   
   public void onClick_Clear(View view){
	   mCircleCanvas.mCircleInfos.clear(); //���������ʷ
	   
	   mCircleCanvas.invalidate();
   }
    
    
    
} 
