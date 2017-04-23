package com.kokodylapolana.pogodynka.ui;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.renderscript.Int2;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kokodylapolana.pogodynka.R;
import com.kokodylapolana.pogodynka.adapters.DayAdapter;
import com.kokodylapolana.pogodynka.weather.Day;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

//extends ListActivity - list Activity
public class DailyForecastActivity extends Activity {

    private Day[] mDays;

    @BindView(android.R.id.list) ListView mListView; // regular Activity
    @BindView(android.R.id.empty) TextView mEmptyTextView; // regular Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        ButterKnife.bind(this); // regular Activity
        /*
        String[] daysOfTheWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                daysOfTheWeek);
        setListAdapter(adapter);
        */

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

        DayAdapter adapter = new DayAdapter(this, mDays);
        //setListAdapter(adapter); //list activity
        mListView.setAdapter(adapter); // regular activiy
        mListView.setEmptyView(mEmptyTextView); // regular activiy
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dayOfTheWeek = mDays[position].getDayOfTheWeek();
                String conditions = mDays[position].getSummary();
                String highTemp = mDays[position].getTemperatureMax() + "";

                String message = String.format("W %s będzie max %s stopni. %s",
                        dayOfTheWeek,
                        highTemp,
                        conditions);
                Toast.makeText(DailyForecastActivity.this, message, Toast.LENGTH_LONG).show();
            } // onItemClicListiner user in regular Activity
        });

    }
    //Kod poniżej używany jest przy List Activity
    /*@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String dayOfTheWeek = mDays[position].getDayOfTheWeek();
        String conditions = mDays[position].getSummary();
        String highTemp = mDays[position].getTemperatureMax() + "";

        String message = String.format("W %s będzie max %s stopni. %s",
                dayOfTheWeek,
                highTemp,
                conditions);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }*/

}





