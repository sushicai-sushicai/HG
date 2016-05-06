package com.example.hg.view;

import java.util.Random;

import com.example.hg.activity.R;
import com.example.hg.utils.LogShow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**自定义view 生成验证码
 * @author yh
 * 2016.2.24
 * */
public class IndentfyingCode extends View {
	private static final char[] CHARS = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z' };
	/**验证码*/
	private String text;
	/**验证码颜色*/
	private int textColor;
	/**验证码大小*/
	private int textSize;
	private Rect rect;
	private Paint mPaint;
	private Random random;
	private int textCodeWid;
	private int textCodeHei;
	private Context context;
	/**默认噪线条数*/
	private int lines=3;
	/**验证码长度*/
	private int textLength=4;
	public IndentfyingCode(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	
	}

	public IndentfyingCode(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
		
	}

	public IndentfyingCode(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context=context;
		random = new Random();
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.IndentfyingCode, defStyle, 0);
		for (int i = 0; i < a.getIndexCount(); i++) {
			switch (a.getIndex(i)) {
			case R.styleable.IndentfyingCode_titleText:
//				text = a.getString(a.getIndex(i));
				text = text(textLength);
				LogShow.d(text);
				break;

			case R.styleable.IndentfyingCode_titleTextColor:
				textColor = a.getColor(a.getIndex(i), Color.BLACK);
				break;
			case R.styleable.IndentfyingCode_titleTextSize:
				textSize = a.getDimensionPixelSize(a.getIndex(i),
						(int) TypedValue.applyDimension(
								TypedValue.COMPLEX_UNIT_SP, 14, getResources()
										.getDisplayMetrics()));
				break;
			}
		}

		a.recycle();
		mPaint = new Paint();
		mPaint.setTextSize(textSize);
		mPaint.setColor(textColor);
		rect = new Rect();
		
		mPaint.getTextBounds(text, 0, text.length(), rect);
		textCodeWid=rect.width();
		textCodeHei=rect.height();
		
		this.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				text = text(textLength);
			
				postInvalidate();
			}
		});
	}

	private String text(int n) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sb.append(CHARS[random.nextInt(CHARS.length)]);
		}
		String s = sb.toString();
		sb = null;
		return s;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		setMeasuredDimension(
				setsize(widthMeasureSpec, rect.width(), getPaddingLeft(),
						getPaddingRight()),
				setsize(heightMeasureSpec, rect.height(), getPaddingTop(),
						getPaddingBottom()));
	}

	private int setsize(int widthMeasureSpec, int rectsize, int pading1,
			int pading2) {
		int measureMode = MeasureSpec.getMode(widthMeasureSpec);
		int measureSize = MeasureSpec.getSize(widthMeasureSpec);
		switch (measureMode) {
		case MeasureSpec.EXACTLY:

			break;

		case MeasureSpec.AT_MOST:
			measureSize = Math.min(measureSize, rectsize);
			break;
		}
		return measureSize + pading1 + pading2;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		mPaint.setColor(Color.WHITE);
	
		canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
		mPaint.setColor(textColor);
	for (int i = 0; i < text.length(); i++) {
		String s=text.substring(i, i+1);

		int textWid=px2dip( context, textSize);
	
		mPaint.setColor(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
		canvas.drawText(s,getWidth() / 2 - textCodeWid / 2+i*textWid, getHeight()
				/ 2 + textCodeHei/ 2, mPaint);
	}
	for (int i = 0; i <lines; i++) {
		mPaint.setColor(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
		int x1=random.nextInt(getWidth());
		int x2=random.nextInt(getWidth());
		int y1=random.nextInt(getHeight());
		int y2=random.nextInt(getHeight());
		canvas.drawLine(x1, x2, y1, y2, mPaint);
	}
	}
	/** 像素转dip */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f) ;
	}
	/**设置验证码*/
	public void setCode(){
		
		text=text(textLength);
		postInvalidate();
	}
	/**获取验证码*/
	public String getCode(){
		
		return text;
	}
	
	
}
