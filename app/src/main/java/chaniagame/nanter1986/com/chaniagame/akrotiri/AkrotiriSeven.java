package chaniagame.nanter1986.com.chaniagame.akrotiri;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class AkrotiriSeven extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this, AkrotiriSix.class);
    }

    @Override
    public void east(View east) {
        intentCreator(this, AkrotiriEight.class);
    }

    @Override
    public void investigate(View investigate) {
        if (esH.readEvent("akrotirimonasterydoor").equals("yes")){
            goIn();
        } else if (esH.readEvent("akrotirimonasterykey").equals("yes")) {
            unlock();
        } else {
            dialogCreator("A huge monastery.\nThe doors are locked.");
            exitForward();
        }
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.unlock);
        effect2 = MediaPlayer.create(this, R.raw.emptysound);
        effect1.setVolume(0.5f, 0.5f);

    }

    private void unlock() {
        effect1.start();
        esH.updateEvent("akrotirimonasterydoor","yes");
        esH.updateEvent("akrotirimonasterykey","used");
        dialogCreator("You unlocked one of the doors,\nusing the monastery key.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goIn();
            }
        });
    }

    private void goIn() {
        intentCreator(getApplicationContext(),AkrotiriMonastery.class);
    }


    @Override
    public void setBack() {
        b.setImageResource(R.drawable.akrotiriseven);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        navigationAssigner(false, false, true, true);
    }



    @Override
    public void setAreaSong() {
        areasong = JukeBox.HELPINGHAND;
        esH.updateEvent("song", areasong.getName());
    }
}
