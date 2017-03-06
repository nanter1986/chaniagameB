package chaniagame.nanter1986.com.chaniagame;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GameOver extends Activity {

    ImageView im;
    MediaPlayer mp;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.release();
        mp = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        mp = MediaPlayer.create(this, R.raw.sad);
        mp.setLooping(true);
        mp.start();

        im = (ImageView)findViewById(R.id.blood);
        im.setImageResource(R.drawable.blood);
        im.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void startScreen(View s){
        Intent startS = new Intent(this, MainMenuAct.class);
        startActivity(startS);
        overridePendingTransition(0, 0);
        finish();
    }
}
