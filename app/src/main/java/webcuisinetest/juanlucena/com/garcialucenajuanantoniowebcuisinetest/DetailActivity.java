package webcuisinetest.juanlucena.com.garcialucenajuanantoniowebcuisinetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private boolean zoomOut =  false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getExtras().getString("imageUrl");

        final ImageView detailImageView = (ImageView)findViewById(R.id.detailImageView);
        Picasso.with(DetailActivity.this)
                .load(imageUrl)
                .into(detailImageView);


        detailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(zoomOut) {
                    detailImageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                    detailImageView.setAdjustViewBounds(true);
                    zoomOut =false;
                }else{
                    detailImageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                    detailImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    zoomOut = true;
                }
            }
        });


    }
}
