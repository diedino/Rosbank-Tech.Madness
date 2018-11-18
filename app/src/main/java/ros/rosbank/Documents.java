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
import org.eazegraph.lib.models.BarModel;


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

        mBarChart.addBar(new BarModel(2.3f, 0xFF123456));
        mBarChart.addBar(new BarModel(2.f,  0xFF343456));
        mBarChart.addBar(new BarModel(3.3f, 0xFF563456));
        mBarChart.addBar(new BarModel(1.1f, 0xFF873F56));
        mBarChart.addBar(new BarModel(2.7f, 0xFF56B7F1));
        mBarChart.addBar(new BarModel(2.f,  0xFF343456));
        mBarChart.addBar(new BarModel(0.4f, 0xFF1FF4AC));
        mBarChart.addBar(new BarModel(4.f,  0xFF1BA4E6));

        mBarChart.startAnimation();

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
