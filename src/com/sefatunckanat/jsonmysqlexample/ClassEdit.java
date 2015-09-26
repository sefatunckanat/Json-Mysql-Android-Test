package com.sefatunckanat.jsonmysqlexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ClassEdit extends Activity {
	
	EditText txName,txPhone,txMail;
	Button btDelete,btUpdate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_user);
		
		btUpdate = (Button)findViewById(R.id.buttonUpdate);
		btDelete = (Button)findViewById(R.id.buttonDelete);
		txName = (EditText)findViewById(R.id.updateName);
		txPhone = (EditText)findViewById(R.id.updatePhone);
		txMail = (EditText)findViewById(R.id.updateMail);
		
		Intent i = getIntent();
		
		final String name = i.getStringExtra("name");
		final String mail = i.getStringExtra("mail");
		final String phone = i.getStringExtra("phone");
		final String id = i.getStringExtra("id");
		
		txName.setText(name);
		txPhone.setText(phone);
		txMail.setText(mail);
		
		btDelete.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PostDelete classList = new PostDelete();
				classList.setup(ClassEdit.this,name);
				classList.execute();
			}
		});
		
		btUpdate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PostEdit classList = new PostEdit();
				classList.setup(ClassEdit.this,txName.getText().toString(),txPhone.getText().toString(),txMail.getText().toString(),id);
				classList.execute();
			}
		});
		
		
		
	}
}
