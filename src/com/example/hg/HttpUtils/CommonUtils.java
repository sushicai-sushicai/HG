package com.example.hg.HttpUtils;

import java.io.File;

import com.example.hg.utils.LogShow;

import android.os.Environment;
import android.text.TextUtils;

public class CommonUtils {
	/**
	 * 判断是否有SD卡，true标示有，false标示没有
	 */
	public static boolean hasSD(){
		return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);		
	}
	/**
	 * 创建并返回缓存路径
	 */
	public static final String SdCachePath(){
		if(!hasSD()){
			LogShow.e("没有找到有效的SD卡");
			return null;
		}
		File file=Environment.getExternalStorageDirectory();//读取SD卡上的文件、
		String filePath=file.getPath()+"/sp/hg/file/";
		System.out.println("filePath:"+filePath);
		File path=new File(filePath);
		if(!path.exists()) path.mkdirs();
		return filePath;
		
		
	}
	/**
	 * 头像路径
	 * @return
	 */
	public static final String headPath(){
		String filePath=SdCachePath();
		if(TextUtils.isEmpty(filePath)) return null;//判断路径是否为空
		File path=new File(filePath+"head/");
		if(!path.exists()) path.mkdirs();
		System.out.println("SD卡Head的绝对路径:"+path.getAbsolutePath());
		return path.getAbsolutePath();
	}
	/**缓存头像图片*/
	public static String HEADCACHE=headPath()+"/headcache.jpg";
}
