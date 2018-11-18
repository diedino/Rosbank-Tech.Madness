package ros.rosbank;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.charts.StackedBarChart;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.PieModel;
import org.eazegraph.lib.models.StackedBarModel;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;


public class Documents extends AppCompatActivity {

    private Intent intent1; // intent for moving on new activity
    private ActionBar toolbar; // own action bar
    TextView bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.docsactionbar);
        toolbar = getSupportActionBar();

        //creating Bar Chart and adding some elements
        BarChart mBarChart = (BarChart) findViewById(R.id.barchart);
        mBarChart.addBar(new BarModel("Jan",4f, 0xFFE60028));
        mBarChart.addBar(new BarModel("Feb",2f,  0xFFF3B90E));
        mBarChart.addBar(new BarModel("March",8f, 0xFFE2516B));
        mBarChart.addBar(new BarModel("April",2f, 0xFF1BA4E6));
        mBarChart.addBar(new BarModel("May",5f, 0xFF7BAD45));
        mBarChart.addBar(new BarModel("June",  3f,0xFFFFFFFF));
        mBarChart.addBar(new BarModel("July",4f, 0xFFF3B90E));
        mBarChart.addBar(new BarModel("Aug",8f,  0xFF38908C));
        mBarChart.startAnimation();

        //Creating Pi Chart and adding elements
        PieChart mPieChart = (PieChart) findViewById(R.id.piechart);
        mPieChart.addPieSlice(new PieModel("Business", 40, Color.parseColor("#ADC116")));
        mPieChart.addPieSlice(new PieModel("Mortage", 25, Color.parseColor("#E60028")));
        mPieChart.addPieSlice(new PieModel("Consumer Loan", 35, Color.parseColor("#F3B90E")));
        mPieChart.startAnimation();

        //Stack Bar Chart
        StackedBarChart mStackedBarChart = (StackedBarChart) findViewById(R.id.stackedbarchart);
        StackedBarModel s1 = new StackedBarModel("12.4");
        s1.addBar(new BarModel(5f, 0xFFE60028));
        s1.addBar(new BarModel(6f, 0xFFF3B90E));
        s1.addBar(new BarModel(2f, 0xFFADC116));
        StackedBarModel s2 = new StackedBarModel("13.4");
        s2.addBar(new BarModel(5f, 0xFFE60028));
        s2.addBar(new BarModel(2f, 0xFFF3B90E));
        s2.addBar(new BarModel(6f, 0xFFADC116));
        StackedBarModel s3 = new StackedBarModel("14.4");
        s3.addBar(new BarModel(7f, 0xFFE60028));
        s3.addBar(new BarModel(6f, 0xFFF3B90E));
        s3.addBar(new BarModel(3f, 0xFFADC116));
        StackedBarModel s4 = new StackedBarModel("15.4");
        s4.addBar(new BarModel(4f, 0xFFE60028));
        s4.addBar(new BarModel(3f, 0xFFF3B90E));
        s4.addBar(new BarModel(4f, 0xFFADC116));
        mStackedBarChart.addBar(s1);
        mStackedBarChart.addBar(s2);
        mStackedBarChart.addBar(s3);
        mStackedBarChart.addBar(s4);
        mStackedBarChart.startAnimation(); // animation which chart is showing

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationdocs);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationdocs);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        //moving on navigation bottom
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mylink:
                        toolbar.setTitle("My link");
                        bar = (TextView)findViewById(R.id.action_bar_title);
                        intent1 = new Intent(Documents.this, MainActivity.class);
                        startActivity(intent1);
                        return true;
                    case R.id.referals:
                        toolbar.setTitle("Referals");
                        bar = (TextView)findViewById(R.id.action_bar_title);
                        intent1 = new Intent(Documents.this, Referals.class);
                        startActivity(intent1);
                        return true;
                    case R.id.news:
                        toolbar.setTitle("News");
                        bar = (TextView)findViewById(R.id.action_bar_title);
                        intent1 = new Intent(Documents.this, News.class);
                        startActivity(intent1);
                        return true;
                    case R.id.docs:
                        toolbar.setTitle("Docs");
                        bar = (TextView)findViewById(R.id.action_bar_title);
                        //intent1 = new Intent(Documents.this, Documents.class);
                        //startActivity(intent1);
                        return true;
                }
                return false;
            }
        });
    }
}
