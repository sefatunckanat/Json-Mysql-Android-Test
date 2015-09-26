package com.sefatunckanat.jsonmysqlexample;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

public class PostEdit extends AsyncTask<String, String, String> {
	ProgressDialog pDialog;
	Context mContext;
	String name,phone,mail,o;
	JSONParser jParser = new JSONParser();
	
	private static final String url = "http://remind.6te.net/json_edit_user.php";
	private static final String TAG_EVENT = "success";
	int event;
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		pDialog = new ProgressDialog(mContext);
		pDialog.setMessage("Kiþi Güncelleniyor");
		pDialog.setIndeterminate(false);
		pDialog.setCancelable(false);
		pDialog.show();
	}
	
	@Override
	protected String doInBackground(String... arg0) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("name",name));
		params.add(new BasicNameValuePair("phone",phone));
		params.add(new BasicNameValuePair("mail",mail));
		params.add(new BasicNameValuePair("old",o));
		JSONObject json = jParser.makeHttpRequest(url, "GET", params);
		try {
			event = json.getInt(TAG_EVENT);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(String result) { 
		super.onPostExecute(result);
		pDialog.dismiss();
		if(event == 1){
			Toast.makeText(mContext, "Kiþi güncelleme iþlemi tamamlandý.",Toast.LENGTH_SHORT).show();
			mContext.startActivity(new Intent(mContext, ClassMain.class));
		}else{
			Toast.makeText(mContext, "Bilinmeyen bir sorun oluþtu.",Toast.LENGTH_SHORT).show();
		}
	}


	void setup(Context c,String n,String p,String m,String oo){
		mContext = c;
		name = n;
		phone = p;
		mail = m;
		o = oo;
	}
}
