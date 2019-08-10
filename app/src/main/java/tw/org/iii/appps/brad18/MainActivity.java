package tw.org.iii.appps.brad18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {
    private MainApp mainApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainApp = (MainApp) getApplication();

    }

    public void test1(View view) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                "https://www.iii.org.tw",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("brad", response);
                    }
                },
                null
        );
        mainApp.queue.add(request);
    }



    public void test2(View view) {
    }

    public void test3(View view) {
    }

    public void test4(View view) {
    }

}
