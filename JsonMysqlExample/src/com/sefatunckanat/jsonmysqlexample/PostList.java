package com.sefatunckanat.jsonmysqlexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

public class PostList extends AsyncTask<String, String, String> {
	Context mContext;
	ListView mList;
	JSONParser jParser = new JSONParser();
	ArrayList<HashMap<String, String>> usersArray = new ArrayList<HashMap<String,String>>();
	
	private static final String url = "http://remind.6te.net/json_user.php";
	private static final String TAG_ID = "id";
	private static final String TAG_NAME = "name";
	private static final String TAG_PHONE = "phone";
	private static final String TAG_MAIL = "mail";
	private static final String TAG_USER = "users";
	private static final String TAG_EVENT = "success";
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}
	
	@Override
	protected String doInBackground(String... arg0) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = jParser.makeHttpRequest(url, "GET", params);
		try {
			int event = json.getInt(TAG_EVENT);
			if(event == 1){
				JSONArray users = null;
				users = json.getJSONArray(TAG_USER);
				for (int i = 0; i < users.length(); i++) {
					JSONObject u = users.getJSONObject(i);
					String name = u.getString(TAG_NAME);
					String phone = u.getString(TAG_PHONE);
					String mail = u.getString(TAG_MAIL);
					int id = u.getInt(TAG_ID);
					HashMap<String, String>map=new HashMap<String, String>();
					map.put(TAG_NAME,name);
					map.put(TAG_PHONE,phone);
					map.put(TAG_MAIL,mail);
					map.put(TAG_ID,""+id);
					
					usersArray.add(map);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		
		ClassMain.RUN(usersArray);
	}

	void setup(Context c,ListView l){
		mContext = c;
		mList = l;
	}
}
