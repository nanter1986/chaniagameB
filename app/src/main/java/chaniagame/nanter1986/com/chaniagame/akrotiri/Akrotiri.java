package chaniagame.nanter1986.com.chaniagame.akrotiri;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class Akrotiri extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {
        intentCreator(this,AkrotiriTwo.class);
    }

    @Override
    public void investigate(View investigate) {
        if(esH.readEvent("akrotiriknowfisherman").equals("yes")){
            esH.updateEvent("akrotiriknowfisherman","done");
            esH.updateEvent("akrotirimonasterykey","yes");
            esH.updateEvent("akrotiriairportfirst","stop");
            dialogCreator("I have this for you,from your brother.");
        }else{
            dialogCreator("Just a guy fishing.");
            exitForward();
        }
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.akrotirione);
    }

    @Override
    public void setStartingTextOptions() {
        esH.updateEvent("startingclass","akrotiri");
    }


    @Override
    public void onNavOn() {
        navigationAssigner(false,false,true,false);
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
