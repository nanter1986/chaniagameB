package chaniagame.nanter1986.com.chaniagame.akrotiri;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class AkrotiriThree extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this,AkrotiriTwo.class);
    }

    @Override
    public void east(View east) {
        intentCreator(this,AkrotiriFour.class);
    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.akrotirithree);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        navigationAssigner(false,false,true,true);
    }



    @Override
    public void setAreaSong() {
        areasong= JukeBox.HELPINGHAND;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.waves);
        effect2 = MediaPlayer.create(this, R.raw.emptysound);
        effect1.setLooping(true);
        effect1.setVolume(0.5f, 0.5f);
        effect1.start();
    }
}
