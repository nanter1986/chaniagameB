package chaniagame.nanter1986.com.chaniagame.mpalos;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class MpalosFive extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this,MpalosSix.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,MpalosFourOne.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        if(esH.readEvent("mpalosCrystalBallBlue").equals("no")) {
            dialogCreator("Do you want to swim to the wreck?");
            bOpt1.setText("Yes");
            bOpt2.setText("No");
            bOpt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    swim();
                }
            });
            bOpt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    noSwim();
                }
            });
        }else{
            dialogCreator("Nothing left to do here...");
            exitForward();
        }
    }

    private void noSwim() {
        setStartingText();
    }

    private void swim() {
        dialogCreator("There is a chest in the wreck.\nInside there is a crystal ball");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtainball();
            }
        });
    }

    private void obtainball() {
        esH.updateEvent("mpalosCrystalBallBlue","yes");
        dialogCreator("You obtained the blue crystal ball.");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.mpalosfivewreck);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        navigationAssigner(true,true,false,false);
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.WAR;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.waves);
        effect2 = MediaPlayer.create(this, R.raw.unlock);
        effect1.setLooping(true);
        effect1.setVolume(0.8f, 0.8f);
        effect1.start();
    }
}
