package com.example.optimus.icartoonist;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {


    //String URL = "https://dry-badlands-50154.herokuapp.com/api/test";
    String URL = "https://radiant-mountain-79308.herokuapp.com/";
    String result = "";
    String deviceId = "xxxxx" ;
    final String tag = "Your Logcat tag: ";


    Button button;
    TextView textView;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ImageView image =(ImageView)findViewById(R.id.imageView1);
        //TextView textView = (TextView) findViewById( R.id.textView1);

        /*
        final EditText txtSearch = (EditText)findViewById(R.id.txtSearch);
        txtSearch.setOnClickListener(new EditText.OnClickListener(){
            public void onClick(View v){txtSearch.setText("");}
        });
        */

        /*
        final Button btnSearch = (Button)findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                //String query = txtSearch.getText().toString();
                callWebService(query);

            }
        });
        */


        button = (Button) findViewById( R.id.button1 );
        textView = (TextView) findViewById( R.id.textView1 );
        imageView = (ImageView) findViewById( R.id.imageView1);

        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL,null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                textView.setText(response.toString());

                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }


                );

            }
        });
        */



        button.setOnClickListener( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,

                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView.setText(response);
                                requestQueue.stop();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                textView.setText("Something went wrong !");
                                error.printStackTrace();
                                requestQueue.stop();
                            }
                        }

                );

                requestQueue.add(stringRequest);
            }
        });


        /*

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.index2);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);


        //textView.setText(imageString);

        imageBytes = Base64.decode(imageString, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        image.setImageBitmap(decodedImage);


        */

    }

    /*
    public void callWebService(String q){
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet request = new HttpGet(URL + q);
        request.addHeader("deviceId", deviceId);
        ResponseHandler<string> handler = new BasicResponseHandler();
        try {
            result = httpclient.execute(request, handler);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpclient.getConnectionManager().shutdown();
        Log.i(tag, result);
    } // end callWebService()
    */

}
