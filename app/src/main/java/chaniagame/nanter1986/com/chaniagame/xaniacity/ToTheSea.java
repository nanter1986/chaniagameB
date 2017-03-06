package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 13/11/2016.
 */
public class ToTheSea extends RoomMaker{
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

    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.stormysea);
    }

    @Override
    public void setStartingTextOptions() {
        if(esH.readEvent("killedTzamiDoor").equals("yes")){
            withBoatman();
        }else{
            withoutBoatman();
        }

    }

    private void withBoatman() {
        dialogCreator("[BOATMAN]What's on the island sir?",R.drawable.blackpic,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boatman1();
            }
        });
    }

    private void boatman1() {
        dialogCreator("It's better if you don't know.\nJust leave me there and return.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boatman2();
            }
        });
    }

    private void boatman2() {
        intentCreator(this,BossCave.class);
    }

    private void withoutBoatman() {
        dialogCreator("This is it.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sea1();
            }
        });
    }

    private void sea1() {
        dialogCreator("I'll save my brother or stay here for ever...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sea2();
            }
        });
    }

    private void sea2() {
        intentCreator(this,BossCave.class);
    }

    @Override
    public void onNavOn() {
        navigationAssigner(false,false,false,false);
    }

    @Override
    public void setAreaSong() {
        areasong = JukeBox.DANGER;
        esH.updateEvent("song", areasong.getName());
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.waves);
        effect2 = MediaPlayer.create(this, R.raw.emptysound);
        effect1.setLooping(true);
        effect1.setVolume(0.9f, 0.9f);
        effect1.start();
    }
}
