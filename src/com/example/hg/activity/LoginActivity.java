package com.example.hg.activity;

import com.example.hg.view.IndentfyingCode;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends BaseActivity implements OnCheckedChangeListener{
	/** 返回按钮 */
	@ViewInject(R.id.turn)
	private ImageView turn;
	@ViewInject(R.id.more)
	private ImageView more;
	/** 标题 */
	@ViewInject(R.id.title)
	private TextView title;

	/** 登录按钮 */
	@ViewInject(R.id.tv_login)
	private TextView tv_login;
	/** 获取验证码 */
	@ViewInject(R.id.sms_code)
	private TextView sms_code;
	
	@ViewInject(R.id.tv_p)
	private TextView tv_p;
	/** 跳到注册页 */
	//@ViewInject(R.id.tv_right)
	private TextView tv_right;

	@ViewInject(R.id.mv)
	private View mv;
	/** 用户名输入框 */
	@ViewInject(R.id.et_username)
	private EditText et_username;
	/** 密码输入框 */
	@ViewInject(R.id.et_password)
	private EditText et_password;
	/** 密码输入框 */
	@ViewInject(R.id.et_code)
	private EditText et_code;
	/**验证码 容器 */
	@ViewInject(R.id.ll_code)
	private LinearLayout ll_code;
	/** 验证码 */
	//@ViewInject(R.id.fresh_code)
	private IndentfyingCode fresh_code;
	/** 是否记住密码*/
	@ViewInject(R.id.cb)
	private CheckBox cb;
	private boolean isChecked=true;
	private String sessionid="";
	//private LoginM loginM;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		
		
	}
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		setContentView(R.layout.login);
		ViewUtils.inject(this);
		title.setText("登陆");
		
	}
	
}
