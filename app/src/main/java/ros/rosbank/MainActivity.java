package ros.rosbank;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;
    TextView bar;
    private Intent intent1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView linkText = (TextView) findViewById(R.id.shareLink);
        FragmentId.id = linkText;

        //getSupportActionBar().hide();
        //Custom Action Bar with centring text(this bar can be found in res)
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("2343");

        Button button = (Button)findViewById(R.id.button);
        //event for Share button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInvite = new Intent(Intent.ACTION_SEND);
                intentInvite.setType("text/plain");
                TextView tv = (TextView)findViewById(R.id.shareLink);
                String body = tv.getText()+"";
                String subject = "Your Subject";
                intentInvite.putExtra(Intent.EXTRA_SUBJECT, subject);
                intentInvite.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(intentInvite, "Share using"));
            }
        });
    }

    //moving in navigation bottom
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mylink:
                    toolbar.setTitle("My link");
                    bar = (TextView)findViewById(R.id.action_bar_title);
                    bar.setText("My Link");
                    return true;
                case R.id.referals:
                    toolbar.setTitle("Referals");
                    bar = (TextView)findViewById(R.id.action_bar_title);
                    intent1 = new Intent(MainActivity.this, Referals.class);
                    startActivity(intent1);
                    return true;
                case R.id.news:
                    toolbar.setTitle("News");
                    bar = (TextView)findViewById(R.id.action_bar_title);
                    intent1 = new Intent(MainActivity.this, News.class);
                    startActivity(intent1);
                    return true;
                case R.id.docs:
                    toolbar.setTitle("Documents");
                    bar = (TextView)findViewById(R.id.action_bar_title);
                    bar.setText("Documents");
                    intent1 = new Intent(MainActivity.this, Documents.class);
                    startActivity(intent1);
                    return true;
            }
            return false;
        }
    };
}