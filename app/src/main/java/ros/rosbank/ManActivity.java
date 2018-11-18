package ros.rosbank;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ManActivity extends AppCompatActivity {
    // Class describes page on one Agent
    static public Men man;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView name = (TextView) findViewById(R.id.nameMan);
        name.setText(man.getName());

        TextView id = (TextView) findViewById(R.id.idMan);
        id.setText("id: " + man.getId());

        TextView status = (TextView) findViewById(R.id.statusMan);
        status.setText(man.getStatus());

        TextView date = (TextView) findViewById(R.id.dateMan);
        date.setText(man.getDate());

        TextView profit = (TextView) findViewById(R.id.profitMan);
        profit.setText(man.getProfit()+" $");

    }
}
