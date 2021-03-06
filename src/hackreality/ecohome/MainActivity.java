package hackreality.ecohome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String SERVER_URL = "http://date.jsontest.com/"; //"http://smartecohome.cloudapp.net/getJson.php";

	// JSON Node names
	private static final String TAG_HUMIN = "umidita_interna";
	private static final String TAG_HUMOUT = "umidita_esterna";
	private static final String TAG_TEMPIN = "temperatura_interna";
	private static final String TAG_TEMPOUT = "temperatura_esterna";

	private static final String TAG1 = "time";
	private static final String TAG2 = "milliseconds_since_epoch";
	private static final String TAG3 = "date";

	private static final String DEBUG = "DEBUG";
	
	String tempinString = "";
	String tempoutString="";
	String huminString="";
	String humoutString="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Creating JSON Parser instance
		JSONParser jParser = new JSONParser();
		 
		// getting JSON string from URL
		JSONObject date = jParser.getJSONFromUrl(SERVER_URL);
		try {			
			//JSONObject json =json.getJSONObject("current");
			Log.e(DEBUG,"OK");

			// Storing each json item in variable
			String huminString = date.getString(TAG_HUMIN);
			String humoutString = date.getString(TAG_HUMOUT);
			String tempoutString = date.getString(TAG_TEMPOUT);
			String tempinString = date.getString(TAG_TEMPIN);
		} 
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e(DEBUG, "ERROR!!");
		}
		

		TextView humin = (TextView) findViewById(R.id.viewHumIn);
		TextView tempin = (TextView) findViewById(R.id.viewTempIn);
		TextView humout = (TextView) findViewById(R.id.viewHumOut);
		TextView tempout = (TextView) findViewById(R.id.viewTempOut);

		humin.setText(huminString);
		humout.setText(humoutString);
		tempin.setText(tempinString);
		tempout.setText(tempoutString);

		

	}
}
	






