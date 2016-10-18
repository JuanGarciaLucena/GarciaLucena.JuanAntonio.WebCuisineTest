package async;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONObject;
import java.util.HashMap;
import utils.JSONUtil;

/**
 * Created by juanlucena on 17/10/16.
 */
public class NASA extends AsyncTask<String, String, JSONObject> {

    private static final String LOGIN_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY\n";
    private Context context;

    JSONUtil jsonUtil = new JSONUtil();

    public NASA(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context, "Loading List", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected JSONObject doInBackground(String... args) {

        try {

            HashMap<String, String> params = new HashMap<>();
            JSONObject json = jsonUtil.makeHttpRequest(LOGIN_URL, "GET", params);

            if (json != null) {
                Log.d("JSON result", json.toString());
                return json;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(JSONObject json) {
        Toast.makeText(context, "List Loaded", Toast.LENGTH_SHORT).show();

    }

}