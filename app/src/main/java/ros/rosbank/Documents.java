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

    private Intent intent1;
    private ActionBar toolbar;
    TextView bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.docsactionbar);
        toolbar = getSupportActionBar();

        BarChart mBarChart = (BarChart) findViewById(R.id.barchart);

        mBarChart.addBar(new BarModel(1f, 0xFF123456));
        mBarChart.addBar(new BarModel(2f,  0xFF343456));
        mBarChart.addBar(new BarModel(3f, 0xFF563456));
        mBarChart.addBar(new BarModel(4f, 0xFF873F56));
        mBarChart.addBar(new BarModel(5f, 0xFF56B7F1));
        mBarChart.addBar(new BarModel(6f,  0xFF343456));
        mBarChart.addBar(new BarModel(7f, 0xFF1FF4AC));
        mBarChart.addBar(new BarModel(8f,  0xFF1BA4E6));

        mBarChart.startAnimation();

        PieChart mPieChart = (PieChart) findViewById(R.id.piechart);

        mPieChart.addPieSlice(new PieModel("Business", 40, Color.parseColor("#FE6DA8")));
        mPieChart.addPieSlice(new PieModel("Mortage", 25, Color.parseColor("#56B7F1")));
        mPieChart.addPieSlice(new PieModel("Consumer Loan", 35, Color.parseColor("#CDA67F")));

        mPieChart.startAnimation();

        StackedBarChart mStackedBarChart = (StackedBarChart) findViewById(R.id.stackedbarchart);

        StackedBarModel s1 = new StackedBarModel("12.4");

        s1.addBar(new BarModel(5f, 0xFF63CBB0));
        s1.addBar(new BarModel(6f, 0xFF56B7F1));
        s1.addBar(new BarModel(2f, 0xFFCDA67F));

        StackedBarModel s2 = new StackedBarModel("13.4");
        s2.addBar(new BarModel(5f, 0xFF63CBB0));
        s2.addBar(new BarModel(2f, 0xFF56B7F1));
        s2.addBar(new BarModel(6f, 0xFFCDA67F));

        StackedBarModel s3 = new StackedBarModel("14.4");

        s3.addBar(new BarModel(7f, 0xFF63CBB0));
        s3.addBar(new BarModel(6f, 0xFF56B7F1));
        s3.addBar(new BarModel(3f, 0xFFCDA67F));

        StackedBarModel s4 = new StackedBarModel("15.4");
        s4.addBar(new BarModel(4f, 0xFF63CBB0));
        s4.addBar(new BarModel(3f, 0xFF56B7F1));
        s4.addBar(new BarModel(4f, 0xFFCDA67F));

        mStackedBarChart.addBar(s1);
        mStackedBarChart.addBar(s2);
        mStackedBarChart.addBar(s3);
        mStackedBarChart.addBar(s4);

        mStackedBarChart.startAnimation();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationdocs);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationdocs);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

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
