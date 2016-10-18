package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import webcuisinetest.juanlucena.com.garcialucenajuanantoniowebcuisinetest.R;

/**
 * Created by juanlucena on 17/10/16.
 */
public class MainListViewAdapter extends BaseAdapter{

    private Context context;
    private JSONArray jsonArray;

    public MainListViewAdapter(Context context, JSONArray jsonArray){
        this.context = context;
        this.jsonArray = jsonArray;
    }

    @Override
    public int getCount() {
        return jsonArray.length();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = rowView = inflater.inflate(R.layout.adapter_main_list_view, viewGroup, false);

        TextView earthDateTextView = (TextView)rowView.findViewById(R.id.earthDateTextView);
        TextView fullNameTextView = (TextView)rowView.findViewById(R.id.fullNameTextView);
        ImageView nasaImageView = (ImageView)rowView.findViewById(R.id.nasaImageView);

        try {

            JSONObject jsonArrayObject = jsonArray.getJSONObject(position);

            String earthDate = jsonArrayObject.getString("earth_date");
            String fullName = jsonArrayObject.getJSONObject("camera").getString("full_name");
            String imageUrl = jsonArrayObject.getString("img_src");

            earthDateTextView.setText(earthDate);
            fullNameTextView.setText(fullName);
            Picasso.with(context)
                    .load(imageUrl)
                    .resize(50, 50)
                    .centerCrop()
                    .into(nasaImageView);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return rowView;
    }
}
