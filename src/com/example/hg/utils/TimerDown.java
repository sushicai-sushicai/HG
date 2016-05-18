package com.example.hg.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

public class TimerDown {
	public static void setTimerDown(final TextView smscode){
		smscode.setClickable(false);
		new CountDownTimer(1000*3,1000) {			
			@Override
			public void onTick(long millis) {
				smscode.setText(""+millis/1000+"s重发");
				
			}
			
			@Override
			public void onFinish() {
				smscode.setText("获取验证码");
				smscode.setClickable(true);
				
			}
		}.start();
	}
}
