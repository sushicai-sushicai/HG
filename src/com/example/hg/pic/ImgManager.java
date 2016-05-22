package com.example.hg.pic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.example.hg.HttpUtils.CommonUtils;
import com.example.hg.HttpUtils.StringUtil;
import com.example.hg.utils.Contacts;
import com.example.hg.view.RoundleDrawable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

/**
 * 头像文件的保存和读取
 * @author Administrator
 *
 */
public class ImgManager {
	/**
	 * 参见图片方法实现，当height<width 可任意调节比例裁剪，当height>=width 按固定比例裁剪
	 */
	public void startPhotoZoom(Context context,Uri uri,int width,int height){
		Intent intent=new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		//这个crop=true是设置在开启的intent中设置显示的VIEW可裁剪、
		intent.putExtra("crop", "true");
		//aspectX aspectY是高宽的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", height/width);
		intent.putExtra("return-data", true);
		((Activity)context).startActivityForResult(intent, Contacts.CROP_IMGAE_REQUESTCOD);		
	}
	public void getHead(ImageView head){
		File file=new File(CommonUtils.HEADCACHE);
		if(null==file) return ;
		Bitmap bitmap=BitmapFactory.decodeFile(CommonUtils.HEADCACHE);
		if(null==bitmap)return;
		
	}
	/** 设置圆形头像 */
	private void setRoundHead(Bitmap bitmap, ImageView head) {
		if(head==null) return;
		BitmapFactory.Options  options=new BitmapFactory.Options();
		options.inMutable=false;//不可改变 false表示可改变
		Drawable drawable=new RoundleDrawable(bitmap);
		head.setImageDrawable(drawable);
		
		
		/*if (head == null) {
			return;
		}
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inMutable = false;

		Drawable drawable = new RoundleDrawable(bitmap);
		head.setImageDrawable(drawable);*/
	}
	/**
	 * 
	 * @param imgurl
	 * @param head
	 */
	public void readWebImg(final String imgurl,final ImageView head){
		if(imgurl==null || imgurl.equals("null"))return ;
		new Thread(){
			@Override
			public void run(){
				super.run();
				try {
					URL url=new URL(imgurl);
					URLConnection con=url.openConnection();
					InputStream is=con.getInputStream();
					byte[] bt=new byte[1024];
					int len;
					File file=new File(CommonUtils.HEADCACHE);
					FileOutputStream fos=new FileOutputStream(file);
					while ((len=bt.length)!=-1) {
						fos.write(bt,0,len);					
					}
					fos.flush();
					fos.close();
					is.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				getHead(head);
			}
		};
	}
}
