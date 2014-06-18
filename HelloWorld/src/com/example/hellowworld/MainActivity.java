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
        mCircleCanvas = new CircleCanvas(this);  //创建CircleCanvas（画布类）对象
        //将CircleCanvas对象添加到当前界面的视图中(两个按键的下方)
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
    
    
    //开始随机绘制圆形(第一个按钮的单击事件)
    
   public void onClick_DrawRandomXCircle(View view){
	   Random random = new Random();
	    float randomX = (float)(100 + random.nextInt(100));  //随机生成圆心横坐标(100至200)
	    float randomY = (float)(100 + random.nextInt(100));
	    float randomRadius = (float)(20 + random.nextInt(40));  //随机生成圆的半径(20-60)
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
   
   //清空画布（第二个按钮）
   
   public void onClick_Clear(View view){
	   mCircleCanvas.mCircleInfos.clear(); //清除绘制历史
	   
	   mCircleCanvas.invalidate();
   }
    
    
    
} 
