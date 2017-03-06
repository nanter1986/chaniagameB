package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 13/11/2016.
 */
public class BossCave extends RoomMaker{
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
        b.setImageResource(R.drawable.theodoroi_cave);
    }

    @Override
    public void setStartingTextOptions() {
        if(esH.readEvent("killedTzamiDoor").equals("yes")){
            withBoatman();
        }else{
            withoutBoatman();
        }
    }

    private void withoutBoatman() {
        dialogCreator("What is this sound?",R.drawable.blackpic,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wtb2();
            }
        });
    }

    private void withBoatman() {
        dialogCreator("[BOATMAN]What is this sound?\nWill you go in there?\nAre you crazy?",R.drawable.blackpic,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wtb1();
            }
        });
    }

    private void wtb1() {
        dialogCreator("I have no other choice.\nGo back and forget everything...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wtb2();
            }
        });
    }

    private void wtb2() {
        intentCreator(this,IntoBossCave.class);
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
