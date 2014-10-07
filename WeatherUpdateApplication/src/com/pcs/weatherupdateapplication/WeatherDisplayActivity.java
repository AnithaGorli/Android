package com.pcs.weatherupdateapplication;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.example.weatherupdateapplication.R;

public class WeatherDisplayActivity extends Activity{
	private EditText cityEdt;
	private Context context;
	private TextView cityTxt;
	private TextView tempTxt;
	private TextView humiditytxt;
	private TextView maxTempTxt;
	private TextView minTempTxt;
	private StringBuilder builder;
	private String city;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.city);



		cityEdt=(EditText)findViewById(R.id.city_edt);

		cityTxt=(TextView)findViewById(R.id.citytxt);
		tempTxt=(TextView)findViewById(R.id.temperaturetxt);
		humiditytxt=(TextView)findViewById(R.id.humiditytxt);
		maxTempTxt=(TextView)findViewById(R.id.maxtemptxt);
		minTempTxt=(TextView)findViewById(R.id.mintemptxt);




		cityEdt.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				new Downloader(WeatherDisplayActivity.this).execute();
				return true;


			}
		});	


	}





	private  class Downloader extends AsyncTask<String, Integer, String>
	{
		private ProgressDialog progress;
		public Downloader(WeatherDisplayActivity weatherActivity) {
			context = weatherActivity;
			progress = new ProgressDialog(context);
			progress.setTitle(getResources().getString(R.string.app_name));


		}

		@Override
		protected void onPreExecute() {
			progress.setMessage(getResources().getString(R.string.download));
			progress.setProgressStyle(progress.STYLE_HORIZONTAL);
			progress.show();
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... args)
		{
			URL url;

			city=cityEdt.getText().toString();
			try {
				url = new URL( "http://api.openweathermap.org/data/2.5/weather?q="+city+"&mode=json");
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

			return builder.toString();

		}

		@Override
		protected void onProgressUpdate(Integer... values) {

			super.onProgressUpdate(values[0]);
		}
		/***
		 * Assigning received Data
		 * Throws JSONException
		 */
		@Override
		protected void onPostExecute(String result) {
			JSONObject jsonObject;
			String object = null;
			try {
				jsonObject = new JSONObject(result);
				if(jsonObject.has("name")){
					object = jsonObject.getString("name");
					cityTxt.setText(getResources().getString(R.string.city)+"\t\t\t\t\t\t :"+ object);

				}
				if(jsonObject.has("main")){


					JSONObject json_Object=jsonObject.getJSONObject("main");

					if(json_Object.has("humidity"))
					{
						object = json_Object.getString("humidity");
						humiditytxt.setText(getResources().getString(R.string.humadity)+"\t :"+ object);
					}
					if(json_Object.has("temp_min"))
					{
						object = json_Object.getString("temp_min");
						minTempTxt.setText(getResources().getString(R.string.mintemp)+":"+ object);
					}
					if(json_Object.has("temp_max"))
					{
						object = json_Object.getString("temp_max");
						maxTempTxt.setText(getResources().getString(R.string.maxtemp)+":"+ object+"\t");
					}
					if(json_Object.has("temp"))
					{
						object = json_Object.getString("temp");
						tempTxt.setText(getResources().getString(R.string.temparature)+"\t :"+ object);
					}

				}
			}catch (JSONException e) {
				e.printStackTrace();
			}
			progress.dismiss();
		}
	}
}