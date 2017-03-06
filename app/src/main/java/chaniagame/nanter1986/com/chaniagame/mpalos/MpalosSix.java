package chaniagame.nanter1986.com.chaniagame.mpalos;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class MpalosSix extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this,MpalosSeven.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,MpalosFive.class);
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

    private void findKey() {
        dialogCreator("There is a key in the tomb.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtainkey();
            }
        });
    }

    private void obtainkey() {
        esH.updateEvent("mpalosChurchOneKey","yes");
        dialogCreator("You obtained the first church key.");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.mlalossixtomb);
    }

    @Override
    public void setStartingTextOptions() {
        if(esH.readEvent("mpalosChurchOneKey").equals("no")){
            findKey();

        }else{
            dialogCreator("Nothing left to do here...");
            exitForward();
        }
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
        effect1.setVolume(0.5f, 0.5f);
        effect1.start();
    }
}
