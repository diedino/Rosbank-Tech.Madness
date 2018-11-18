package ros.rosbank;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewsContentActivity extends AppCompatActivity {

    static public OneNews news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView title = (TextView) findViewById(R.id.newsTitle);
        title.setText(news.getHeader());

        TextView about = (TextView) findViewById(R.id.aboutNews);
        about.setText(news.getTextMesssage());

        LinearLayout titleImg = (LinearLayout) findViewById(R.id.titleImg);
        titleImg.setBackgroundResource(news.getIconResource());
    }
}
