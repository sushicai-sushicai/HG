package com.example.hg.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * 剪切圆形图片
 * @author ssc
 *
 */
public class RoundleDrawable extends Drawable{
	Bitmap bitmap;
	Paint paint;
	RectF recf;
	int wid;
	int hei;
	public RoundleDrawable(Bitmap bitmap){
		this.bitmap = bitmap;
		paint=new Paint();
		recf=new RectF();
		paint.setAntiAlias(true);//设置锯齿 就是图像边缘相对清晰一点，锯齿痕迹不那么明显
		paint.setDither(true);//设置防抖动。 
		 //TitleMode有三种方式：CLAMP如果渲染超过原始范围边界，会复制范围内边缘染色
		 //repeat横向和纵向重复渲染图片
		 //mirror 横向和镜像重复渲染翻转后的图片   mirror：镜子
		BitmapShader shader=new BitmapShader(this.bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
		paint.setShader(shader);
		wid=bitmap.getWidth();
		hei=bitmap.getHeight();
	}
	@Override
	public void draw(Canvas canvas) {
		canvas.drawOval(recf, paint);
		
	}
	@Override
	public int getOpacity() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setAlpha(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setColorFilter(ColorFilter arg0) {
		// TODO Auto-generated method stub
		
	}
}
