package tw.org.iii.appps.brad18;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private MainApp mainApp;
    private TextView tv;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainApp = (MainApp) getApplication();

        tv = findViewById(R.id.tv);
        img = findViewById(R.id.img);
    }

    public void test1(View view) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                "https://www.iii.org.tw",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("brad", response);
                        tv.setText(response);
                    }
                },
                null
        );
        mainApp.queue.add(request);
    }


    public void test2(View view) {
        String url = "http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx";

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseJSON(response);
                    }
                },
                null
        );
        mainApp.queue.add(request);
    }

    private void parseJSON(String json){
        try{
            JSONArray root = new JSONArray(json);
            for (int i=0; i<root.length(); i++){
                JSONObject row = root.getJSONObject(i);
                Log.v("brad", row.getString("Name") +
                        ":" +row.getString("Tel"));
            }
        }catch (Exception e){
            Log.v("brad", e.toString());
        }
    }


    public void test3(View view) {
        ImageRequest request = new ImageRequest(
                "https://ezgo.coa.gov.tw/Uploads/opendata/TainmaMain01/APPLY_D/20151007173924.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        img.setImageBitmap(response);
                    }
                },
                0, 0,
                Bitmap.Config.ARGB_8888,
                null
        );
        mainApp.queue.add(request);
    }

    public void test4(View view) {
        String url = "http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx";
        JsonArrayRequest request = new JsonArrayRequest(
                url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parseJSON2(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("brad", error.toString());
                    }
                }
        );
        mainApp.queue.add(request);
    }

    private void parseJSON2(JSONArray root){
        try{
            for (int i=0; i<root.length(); i++){
                JSONObject row = root.getJSONObject(i);
                Log.v("brad", row.getString("Name") +
                        ":" +row.getString("Tel"));
            }
        }catch (Exception e){

        }
    }


    public void test5(View view) {
        BradInputStreamRequest request = new BradInputStreamRequest(
                Request.Method.GET,
                "https://ezgo.coa.gov.tw/Uploads/opendata/TainmaMain01/APPLY_D/20151007173924.jpg",
                new Response.Listener<byte[]>() {
                    @Override
                    public void onResponse(byte[] response) {
                        Log.v("brad", "len = " + response.length);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("brad", error.toString());
                    }
                },
                null
        );
        mainApp.queue.add(request);
    }
}
