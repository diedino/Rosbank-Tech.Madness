package ros.rosbank;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ros.rosbank.R;

public class Referals extends AppCompatActivity {
    private ActionBar toolbar;
    private List<Men> men = new ArrayList();
    private Intent intent1;

    public static int oddev = 0;
    ListView menList;
    TextView bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referals);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.referalactionbar);
        toolbar = getSupportActionBar();


        men.add(new Men("Sergy", "credit", false, 0, "0sece621sq","10.10.10"));
        men.add(new Men("Max", "credit", true, 10000, "80ksffj435","12.08.12"));
        men.add(new Men("Tema", "credit", true, 1000, "93jfnv4","08.07.14"));
        men.add(new Men("Egor", "credit", false, 0, "1kfd4ls2","10.11.05"));
        men.add(new Men("Sergy", "credit", true, 500, "l03fm12","18.07.12"));

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationRef);
        //BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        menList = (ListView) findViewById(R.id.men);

        // создаем адаптер
        MenAdapter menAdapter = new MenAdapter(this, R.layout.men_layout, men);
        // устанавливаем адаптер
        menList.setAdapter(menAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                Men selectedState = (Men)parent.getItemAtPosition(position);

                ManActivity.man = selectedState;

                Intent manInfo = new Intent(Referals.this, ManActivity.class);
                startActivity(manInfo);
            }
        };
        menList.setOnItemClickListener(itemListener);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mylink:
                        toolbar.setTitle("My link");
                        bar = (TextView)findViewById(R.id.action_bar_title);
                        intent1 = new Intent(Referals.this, MainActivity.class);
                        startActivity(intent1);
                        return true;
                    case R.id.referals:
                        toolbar.setTitle("Referals");
                        bar = (TextView)findViewById(R.id.action_bar_title);
                        //intent1 = new Intent(Referals.this, Referals.class);
                        //startActivity(intent1);
                        return true;
                    case R.id.news:
                        toolbar.setTitle("News");
                        bar = (TextView)findViewById(R.id.action_bar_title);
                        intent1 = new Intent(Referals.this, News.class);
                        startActivity(intent1);
                        return true;
                    case R.id.docs:
                        toolbar.setTitle("Docs");
                        bar = (TextView)findViewById(R.id.action_bar_title);
                        intent1 = new Intent(Referals.this, Documents.class);
                        startActivity(intent1);
                        return true;
                }
                return false;
            }
        });
    }
}
