package com.learn.drawcirel;

import java.util.Random;

import com.learn.drawcirel.CircleCanvas.CircleInfo;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.Layout;
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
		mCircleCanvas = new CircleCanvas(this);
		viewGroup.addView(mCircleCanvas, new LayoutParams(LayoutParams.MATCH_PARENT, 350));
		setContentView(viewGroup);
	}
	
	public void onClick_DrawRandomCircle(View view){
		Random random = new Random();
		float randomX = (float)(100 + random.nextInt(100));
		float randomY = (float)(100 + random.nextInt(100));
		float randomRadius = (float)(20 + random.nextInt(40));
		int randomColor = 0;
		
		if (random.nextInt(100) > 50){
			randomColor = Color.BLUE;
		}else{
			if (random.nextInt(100) > 50)
				randomColor = Color.RED;
			else
				randomColor = Color.GREEN;
		}
		
		CircleInfo circleInfo = new CircleInfo();
		circleInfo.setX(randomX);
		circleInfo.setY(randomY);
		circleInfo.setRadius(randomRadius);
		circleInfo.setColor(randomColor);
		mCircleCanvas.mCicleInfos.add(circleInfo);
		mCircleCanvas.invalidate();
	}
	
	public void onClick_Clear(View view){
		mCircleCanvas.mCicleInfos.clear();
		mCircleCanvas.invalidate();
	}


}
