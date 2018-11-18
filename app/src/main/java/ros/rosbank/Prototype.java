package ros.rosbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Prototype extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prototype);
        //getSupportActionBar().hide();
        ImageView img = (ImageView)findViewById(R.id.imageprototype);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Prototype.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
