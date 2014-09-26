package com.pcs.jsonapplication;

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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.jsonapplication.R;
/**
 * This Activity will deal with JSON parsing
 * when i click on Download it will show progress dialog of downloading,
 * And then get the JSON Object ,parsed it and then shows result  in the same Activity
 */
public class MainActivity extends Activity{
	private Button downloadBtn;
	private TextView idTxt;
	private TextView genderTxt;
	private TextView lastNameTxt;
	private TextView firstNameTxt;
	private TextView nameTxt;
	private TextView linkTxt;
	private TextView usernameTxt;
	private TextView localTxt;
	private StringBuilder builder;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		idTxt = (TextView)findViewById(R.id.id_display);
		nameTxt = (TextView)findViewById(R.id.name_display);
		firstNameTxt = (TextView)findViewById(R.id.firstname_display);
		lastNameTxt = (TextView)findViewById(R.id.lastname_display);
		genderTxt = (TextView)findViewById(R.id.gender_display);
		localTxt=(TextView)findViewById(R.id.locale_display);
		linkTxt=(TextView)findViewById(R.id.link_display);
		usernameTxt=(TextView)findViewById(R.id.username_display);
		downloadBtn = (Button)findViewById(R.id.download_btn);


		downloadBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Downloader(MainActivity.this).execute();

			}
		});
	}
	/**
	 * for Downloading data in background for long time we have to extends AsyncTask

	 */

	private  class Downloader extends AsyncTask<String, Integer, String>
	{

		//for  Displaying the Dialog
		private ProgressDialog progress;
		public Downloader(MainActivity mainActivity) {
			context = mainActivity;
			progress = new ProgressDialog(context);
			progress.setTitle(getResources().getString(R.string.download_json));


		}
	
		@Override
		protected void onPreExecute() {
			progress.setMessage(getResources().getString(R.string.download));
			progress.setProgressStyle(progress.STYLE_HORIZONTAL);
			progress.setMax(100);
			progress.setIcon(R.drawable.ic_launcher);
			progress.setProgress(80);
			progress.show();
			super.onPreExecute();
		}
		/***
		 * Retrieves FaceBook User Details from Server
		 * URL should not be null
		 * URL should not be incorrect
		 * Throws MalformedURLException
		 * Throws ClientProtocolException
		 * Throws IOException
		 */
		@Override
		protected String doInBackground(String... args)
		{
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
				int i=1;
				while((line=bufferedReader.readLine())!=null)
				{
					progress.setProgress(i*100/10);
					builder.append(line);
				}

			} //Handling Exceptions
			catch (MalformedURLException e1) {
				e1.printStackTrace();
			}catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(builder.toString()==null)
			{

				progress.dismiss();
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

				//checking JSON object for data availability 
				if(jsonObject.has("first_name"))
				{
					object = jsonObject.getString("first_name");
					firstNameTxt.setText(getResources().getString(R.string.first_name)+"\t"+ object);
				}
				if(jsonObject.has("gender"))
				{
					object = jsonObject.getString("gender");
					genderTxt.setText((getResources().getString(R.string.gender)+"\t\t"+object));
				}
				if(jsonObject.has("last_name"))
				{
					object = jsonObject.getString("last_name");
					lastNameTxt.setText((getResources().getString(R.string.last_name)+"\t"+object));
				}
				if(jsonObject.has("link"))
				{
					object = jsonObject.getString("link");
					linkTxt.setText((getResources().getString(R.string.link)+"\t"+object));
				}
				if(jsonObject.has("name"))
				{
					object = jsonObject.getString("name");
					nameTxt.setText((getResources().getString(R.string.name)+"\t\t"+object));
				}
				if(jsonObject.has("username"))
				{
					object = jsonObject.getString("username");
					usernameTxt.setText((getResources().getString(R.string.username)+"\t"+object));
				}
				if(jsonObject.has("locale"))
				{
					object = jsonObject.getString("locale");
					localTxt.setText((getResources().getString(R.string.locale)+"\t\t"+object));
				}
				if(jsonObject.has("id"))
				{
					object = jsonObject.getString("id");
					idTxt.setText((getResources().getString(R.string.id)+""+object));
				}
			}
			//Handling Exception
			catch (JSONException e) {
				e.printStackTrace();
			}
			progress.dismiss();
		}
	}
}