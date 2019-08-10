package tw.org.iii.appps.brad18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class Page2Activity extends AppCompatActivity {
    private MainApp mainApp;
    private EditText cname, tel, addr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        mainApp = (MainApp)getApplication();

        cname = findViewById(R.id.cname);
        tel = findViewById(R.id.tel);
        addr = findViewById(R.id.addr);

    }

    public void test1(View view) {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "https://www.bradchao.com/autumn/addCust.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                null
        );
        mainApp.queue.add(request);

    }
}
