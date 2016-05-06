package com.example.hg.utils;

public class Contacts {
/**
 * ISTEST=true 测试状态
 * ISTEST=false 正式
 */
	public final static boolean ISTEST=true;
	/**
	 * isPutLog 
	 * true 输出日志
	 * false 不输出日志
	 */
	public final static boolean isPutLog=true;
	/**
	 * 网络类型
	 * 0:无网络
	 */
	public static final int NETTYPE_NO=0x00;
	/**
	 * 网络类型
	 * 1：WIFI网络
	 * 
	 */
	public static final int NETTYPE_WIFI=0x01;
	/**
	 * 网络类型
	 * 2，wap网络
	 */
	public static final int NETTYPE_CMWAP=0x02;
	/**
	 * 数据请求成功
	 */
	public static final int SUCCESS_1=1;
	/**连接失败0*/
	public static final int FAIL_0 = 0;
	/**请求失败失败2*/
	public static final int FAIL_2= 2;
	public static final String STATUS= "status";
	/**
	 * 网络类型 <br>
	 * 3：NET网络 <br>
	 */
	public static final int NETTYPE_CMNET = 0x03;
	/***百度ak*/
	public static final String BDAK="Ne0PplGabT9wPC0G88KcCmpG";

	/**拍照请求码10*/
	public static final int TAKE_IMGAE_REQUESTCOD=10;
	/**读取相册请求码20*/
	public static final int READ_IMGAE_REQUESTCOD=20;
	/**裁剪请求码30*/
	public static final int CROP_IMGAE_REQUESTCOD=30;
}
