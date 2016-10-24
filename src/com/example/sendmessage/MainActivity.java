package com.example.sendmessage;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText num,mess;
    Button myBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myBtn=(Button)findViewById(R.id.myBtn);
		num=(EditText)findViewById(R.id.num);
		mess=(EditText)findViewById(R.id.mess);
		myBtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				String mobile=num.getText().toString();//获取收件人号码
				String content=mess.getText().toString();//获取短信内容
				Intent intent=new Intent();
				intent.setData(Uri.parse("smsto:"+mobile));//设置Intent数据
				intent.putExtra("sms_body", content);
				startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
