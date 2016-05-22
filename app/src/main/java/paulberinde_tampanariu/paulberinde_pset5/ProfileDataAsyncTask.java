package paulberinde_tampanariu.paulberinde_pset5;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;

public class ProfileDataAsyncTask extends AsyncTask <String, Integer, String> {

    Context context;
    MainActivity activity;

    public ProfileDataAsyncTask(MainActivity activity){
        this.activity = activity;
        this.context = this.activity.getApplicationContext();
    }

    @Override
    protected String doInBackground(String... params) {
        return DestinyHelper.serverDownload(params[0]);
    }

    @Override
    protected void onPreExecute(){
        Toast.makeText(context, "Fetching Profile Data from server", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPostExecute (String result) {
        super.onPostExecute(result);
        if (result.length() == 0) {
            Toast.makeText(context, "No Data found", Toast.LENGTH_SHORT).show();
        }
        else{

            try {
                //JSONArray resultArray = new JSONArray(result);
                JSONObject resultObj = new JSONObject(result);
                JSONArray responseArray = resultObj.getJSONArray("Response");
                JSONObject memIdObj = responseArray.getJSONObject(0);
                String membershipID = memIdObj.getString("membershipId");
                this.activity.setData(membershipID);


            }
            catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }
}
