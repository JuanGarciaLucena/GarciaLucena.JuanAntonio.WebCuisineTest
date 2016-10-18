package webcuisinetest.juanlucena.com.garcialucenajuanantoniowebcuisinetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

    private JSONArray jsonArray;

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
            jsonArray = jsonObject.getJSONArray("photos");

            MainListViewAdapter mainListViewAdapter = new MainListViewAdapter(MainActivity.this, jsonArray);
            mainListView.setAdapter(mainListViewAdapter);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                try {
                    String imageUrl = jsonArray.getJSONObject(position).getString("img_src");
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    i.putExtra("imageUrl", imageUrl);
                    startActivity(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });



    }
}
