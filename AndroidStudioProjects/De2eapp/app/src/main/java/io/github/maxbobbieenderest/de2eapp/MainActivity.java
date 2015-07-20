package io.github.maxbobbieenderest.de2eapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSave(View view){



    }

    public void onClearTags(View view){

    }

    private void addRow (String shortname, String place){
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View newRow = layoutInflater.inflate (R.layout.rowlayout, null);

        Button button = (Button) newRow.findViewById(R.id.nameButton);
        button.setText(shortname);


        TableLayout tagsTableLayout = (TableLayout)
                findViewById(R.id.tableLayout);
        tagsTableLayout.addView(newRow);

    }

    private View.OnClickListener tagButtonListener
            = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String tag = ((Button)view).getText().toString();
            Toast.makeText(getApplicationContext(), tag,
                    Toast.LENGTH_LONG).show();
        }
    };

}
