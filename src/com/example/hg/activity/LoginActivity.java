package com.example.hg.activity;


import com.example.hg.action.LoginM;
import com.example.hg.utils.Contacts;
import com.example.hg.utils.ProgressBar;
import com.example.hg.utils.TimerDown;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements OnCheckedChangeListener{
	@ViewInject(R.id.title)
	private TextView title;
	@ViewInject(R.id.sms_code)
	private TextView sms_code;
	@ViewInject(R.id.tv_rigth)
	private TextView tv_rihth;
	@ViewInject(R.id.more)
	private ImageView more;
	@ViewInject(R.id.turn)
	private ImageView turn;
	@ViewInject(R.id.cb)
	private CheckBox checkbox;
	@ViewInject(R.id.et_username)
	private EditText et_username;
	@ViewInject(R.id.et_password)
	private EditText et_password;
	
	private boolean isChecked=true;
	private String sessionid="";
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
		title.setText("登录");
		sms_code.setVisibility(View.GONE);
		tv_rihth.setVisibility(View.VISIBLE);
		tv_rihth.setTextColor(this.getResources().getColor(R.color.red1));
		tv_rihth.setText("注册");
		more.setVisibility(View.INVISIBLE);
		turn.setImageResource(R.drawable.login_bakc);
		checkbox.setOnCheckedChangeListener(this);
		et_username.setText(getPreferenceString("userinfo"));
		et_password.setText(getPreferenceString("password"));	
		
	}
	@OnClick({R.id.turn,R.id.tv_login,R.id.tv_forgettpassword,R.id.tv_rigth,R.id.sms_code})
	public void myClick(View v){
		switch (v.getId()) {
		case R.id.turn:
			finish();
			break;
		case R.id.more:
			Toast.makeText(this,"更多去处敬请期待",Toast.LENGTH_SHORT).show();
			break;
		case R.id.tv_login:
			if(!appContext.isNetWorkConnected()){
				Toast.makeText(this,R.string.connection_error,Toast.LENGTH_SHORT).show();
			}
			if(et_username.getText().toString().length()!=11){
				Toast.makeText(this,"请输入11位手机号",Toast.LENGTH_SHORT).show();
				return ;
			}
			savePreferenceString("username", et_username.getText().toString());
			if(et_password.getText().toString().length()<6){
				Toast.makeText(this,"密码不能小于6位",Toast.LENGTH_SHORT).show();
			}
			savePreferenceString("password", et_password.getText().toString());
			new LoginM(this, handler, null,et_username.getText().toString(),et_password.getText().toString(),isChecked,sessionid);
			break;
		case R.id.sms_code:
			TimerDown.setTimerDown(sms_code);
			Toast.makeText(this,"发送短信",Toast.LENGTH_SHORT).show();
		case R.id.tv_forgettpassword:
			Toast.makeText(this,"忘记短信",Toast.LENGTH_SHORT).show();
			break;
		case R.id.tv_rigth:
			Toast.makeText(this,"注册",Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		
	}
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			ProgressBar.dismmisProgress();//关闭进度条
			switch (msg.what) {
			case Contacts.SUCCESS_1:
				toast("登录成功");
				finish();
				break;
			case Contacts.FAIL_2:
				break;
			case Contacts.FAIL_0:
				toast(R.string.connection_error);
				break;
			}
		};
	};
}
