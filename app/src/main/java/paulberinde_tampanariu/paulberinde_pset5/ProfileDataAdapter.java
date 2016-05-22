/*
package paulberinde_tampanariu.paulberinde_pset5;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class ProfileDataAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<ProfileData> data;

    public ProfileDataAdapter(Context context ArrayList<ProfileData>data){
        this.context = context;
        this.data = data;
    }
    @Override
    public int getCount() {return this.data.size(); }

    @Override
    public Object getItem (int arg0) {return null;}

    @Override
    public long getItemId (int pos) {return pos;}


    @Override
    public View getView (int pos, View view, ViewGroup parent){
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate (R.layout.row_layout, parent, false);

        }

    }
}
*/