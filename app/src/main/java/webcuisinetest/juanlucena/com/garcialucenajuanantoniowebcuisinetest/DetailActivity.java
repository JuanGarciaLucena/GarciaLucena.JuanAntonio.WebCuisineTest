package webcuisinetest.juanlucena.com.garcialucenajuanantoniowebcuisinetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private boolean zoomOut =  false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detail);



        Intent intent = getIntent();
        String imageUrl = intent.getExtras().getString("imageUrl");

        final ImageView detailImageView = (ImageView)findViewById(R.id.detailImageView);
        Picasso.with(DetailActivity.this)
                .load(imageUrl)
                .into(detailImageView);
    }
}
