package com.example.hg.view;

import java.util.Random;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
/**
 * 自定义View 生成验证码
 * @author ssc
 *
 */
public class IndentfyingCode extends View {
	
	private static final char[] CHARS={ '0', '1', '2', '3', '4', '5', '6',
		'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
		'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
		'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
		'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
		'X', 'Y', 'Z' };
	/**
	 * 验证码
	 */
	private String text;
	/**
	 * 验证码颜色
	 */
	private int textColor;
	/**
	 * 验证码大小
	 */
	private int textSize;
	private Rect rect;
	private Paint mPaint;
	private Random randon;
	private int textCodeWid;
	private int textCodeHei;
	private Context context;
	/**
	 * 默认噪线条数
	 */
	private int lines=3;
	/**
	 * 验证码长度
	 */
	private int textLenth=4;
	
	/**
	 * 
	 * @param context
	 * @param attrs
	 * @param defStyleAttr
	 */
	public IndentfyingCode(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		this.context=context;
		randon=new Random();
		//TypedArray typeArray=context.getTheme().obtainStyledAttributes(attrs, defStyleAttr, defStyleRes)
	}

}
