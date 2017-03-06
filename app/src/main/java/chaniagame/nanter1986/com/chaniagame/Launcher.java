package chaniagame.nanter1986.com.chaniagame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class Launcher extends Activity {

    ImageView im;
    Handler h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_launcher);

        im = (ImageView)findViewById(R.id.imLauncher);

        im.setImageResource(R.drawable.nanter1986);
        moveToMenu();
    }

    public void moveToMenu(){
        h = new Handler();
        Runnable rn = new Runnable() {
            @Override
            public void run() {
                intentForMenu();
            }
        };
        h.postDelayed(rn,2000);
    }

    public void intentForMenu(){
        Intent mn = new Intent(this, MainMenuAct.class);
        startActivity(mn);
        overridePendingTransition(0, 0);
        finish();
    }
}
