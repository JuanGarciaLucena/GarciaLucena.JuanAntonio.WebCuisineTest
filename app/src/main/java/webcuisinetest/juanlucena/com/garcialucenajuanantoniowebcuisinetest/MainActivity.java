package webcuisinetest.juanlucena.com.garcialucenajuanantoniowebcuisinetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import async.NASA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSONObject jsonObject = null;

        NASA nasa = new NASA(MainActivity.this);
        try {
            jsonObject = nasa.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        ListView mainListView = (ListView)findViewById(R.id.mainListView);
    }
}
