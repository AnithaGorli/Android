package com.pcs.serverrequestapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.JarException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.serverrequestapplication.R;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RequestActivity extends Activity{
private Button downloadBtn;
private StringBuilder builder;
private Context context;
private TextView nameTxt,genderTxt,cityTxt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.request);
		
		nameTxt =(TextView)findViewById(R.id.name);
		genderTxt =(TextView)findViewById(R.id.gender);
		cityTxt = (TextView)findViewById(R.id.city);
		downloadBtn=(Button)findViewById(R.id.download_btn);
		downloadBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Downloader(RequestActivity.this).execute();
			}
		});
		
	}
	private class Downloader extends AsyncTask<String, Integer, String>{

		
		
		public Downloader(RequestActivity request) {
			// TODO Auto-generated constructor stub
			
			context=request;
			
		}
		
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			Toast.makeText(context, getResources().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
			super.onPreExecute();
		}
		
		
		@Override
		protected String doInBackground(String... params) {

			URL url;
			try {
				url = new URL( "http://graph.facebook.com/591658927624314");
				URLConnection connectUrl = url.openConnection();
				connectUrl.connect();
				InputStream inputStream = connectUrl.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				builder = new StringBuilder();
				String line = null;
				
				while((line=bufferedReader.readLine())!=null)
				{
					
					builder.append(line);
				}

			} 
			catch (MalformedURLException e1) {
				e1.printStackTrace();
			}catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String facebookResponse=builder.toString();
			return builder.toString();

		}

		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			
			JSONObject jsonObject;
			String object=null;
			try {
				jsonObject = new JSONObject(result);
				if(jsonObject.has("name"))
				{
					object = jsonObject.getString("name");
					nameTxt.setText((getResources().getString(R.string.name)+"\t\t"+object));
				}
				
				if(jsonObject.has("gender"))
				{
					object = jsonObject.getString("gender");
					genderTxt.setText((getResources().getString(R.string.gender)+"\t\t"+object));
				}
				
				if(jsonObject.has("city"))
				{
					object = jsonObject.getString("city");
					cityTxt.setText((getResources().getString(R.string.city)+"\t\t"+object));
				}
				
			} catch (JSONException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		
		}
	}
}
