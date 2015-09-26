package com.sefatunckanat.jsonmysqlexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClassNew extends Activity {
	
	EditText txName,txPhone,txMail;
	Button buttonSave;
	
	static public int duration = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_new);
		
		buttonSave = (Button) findViewById(R.id.buttonKaydet);
		txName = (EditText)findViewById(R.id.editName);
		txPhone = (EditText)findViewById(R.id.editPhone);
		txMail = (EditText)findViewById(R.id.editMail);
		
		buttonSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(txName.getText().length()>0 && txPhone.getText().length()>0 && txMail.getText().length()>0){
					PostSave c = new PostSave();
					c.setup(ClassNew.this,txName.getText().toString(),txPhone.getText().toString(),txMail.getText().toString());
					c.execute();
				}else{
					Toast.makeText(getApplicationContext(), "Bilgileri boþ býrakmayýnýz.",duration).show();
				}
			}
		});
	}
}
