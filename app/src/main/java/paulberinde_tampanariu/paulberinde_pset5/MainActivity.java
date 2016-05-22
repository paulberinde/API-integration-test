package paulberinde_tampanariu.paulberinde_pset5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText user_input;
    ListView result_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_input = (EditText) findViewById (R.id.userIDField);
        result_view = (ListView) findViewById(R.id.resultView);
    }
    public void get_data (View view) {
        String input = user_input.getText().toString();

        ProfileDataAsyncTask profileTask = new ProfileDataAsyncTask(this);
        profileTask.execute(input);
    }

    public void setData(String param) {
        TextView view1 = (TextView) findViewById(R.id.textView);
        view1.setText("MemberID: "+param);
    }
}
    //public void SetData( ArrayList<ProfileData> profiledata ) {


