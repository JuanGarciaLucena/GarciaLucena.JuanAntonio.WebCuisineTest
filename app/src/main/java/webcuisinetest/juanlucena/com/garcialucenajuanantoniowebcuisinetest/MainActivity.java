package webcuisinetest.juanlucena.com.garcialucenajuanantoniowebcuisinetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.concurrent.ExecutionException;

import adapters.MainListViewAdapter;
import async.NASA;
import objects.NasaItem;
import utils.JSONUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing variables
        ListView mainListView = (ListView)findViewById(R.id.mainListView);
        JSONObject jsonObject = null;

        //Getting information from service
        try {
            NASA nasa = new NASA(MainActivity.this);
            jsonObject = nasa.execute().get();
            JSONArray jsonArray = jsonObject.getJSONArray("photos");

            MainListViewAdapter mainListViewAdapter = new MainListViewAdapter(MainActivity.this, jsonArray);
            mainListView.setAdapter(mainListViewAdapter);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
