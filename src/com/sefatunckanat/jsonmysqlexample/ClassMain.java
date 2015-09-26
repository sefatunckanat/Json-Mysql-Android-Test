package com.sefatunckanat.jsonmysqlexample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ClassMain extends Activity {

	/**
	 * 		SEFA TUNÇKANAT
	 * 		03.03.2015 18:23
	 */
	static ListView listUser;
	static ClassMain T;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		T = this;
		setContentView(R.layout.layout_main);
		listUser = (ListView)findViewById(R.id.listUser);
		listUser.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				String name = ((TextView)view.findViewById(R.id.item_name)).getText().toString();
				String phone = ((TextView)view.findViewById(R.id.item_phone)).getText().toString();
				String mail = ((TextView)view.findViewById(R.id.item_mail)).getText().toString();
				String idd =  ((TextView)view.findViewById(R.id.item_id)).getText().toString();
				Intent in = new Intent(ClassMain.this,ClassEdit.class);
				in.putExtra("name",name);
				in.putExtra("phone",phone);
				in.putExtra("mail",mail);
				in.putExtra("id",idd);
				startActivity(in);
			}
		});
		
		PostList classList = new PostList();
		classList.setup(this, listUser);
		classList.execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.layout_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent i  = new Intent(getApplicationContext(), ClassNew.class);
			startActivity(i);
			return true;
		}
		if (id == R.id.action_reflesh) {
			PostList classList = new PostList();
			classList.setup(this, listUser);
			classList.execute();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	static public void RUN(@SuppressWarnings("rawtypes") final ArrayList usersArray){
		T.runOnUiThread(new Runnable() {
			public void run() {
				@SuppressWarnings("unchecked")
				SimpleAdapter adapter = new SimpleAdapter(T,usersArray,R.layout.list_item, 			
						new String[] 	{ 	"name",				"phone"				,"mail"			,"id"},
						new int[] 		{	R.id.item_name,		R.id.item_phone		,R.id.item_mail	,R.id.item_id	});
				listUser.setAdapter(adapter);
			}
		});
	}
}
