package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.stories.BadEnding;
import chaniagame.nanter1986.com.chaniagame.stories.GoodEnding;

/**
 * Created by nanter1986 on 14/11/2016.
 */
public class IntoBossCave extends RoomMaker{
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
        b.setImageResource(R.drawable.whirlpoolcave);
    }

    @Override
    public void setStartingTextOptions() {
        dialogCreator("Finally...\nYou made it.",R.drawable.blackcoat,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boss1();
            }
        });
    }

    private void boss1() {
        dialogCreator("Leave now, before you loss everything...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boss2();
            }
        });
    }

    private void boss2() {
        dialogCreator("Hahaha ok, just tell me my name and I will disappear.",R.drawable.blackcoat,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boss3();
            }
        });
    }

    private void boss3() {
        dialogCreator("There were clues about my name in the city.\nDid you notice?",R.drawable.blackcoat,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boss4();
            }
        });
    }

    private void boss4() {
        dialogCreator("You only have one chance...",R.drawable.blackcoat,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boss5();
            }
        });
    }

    private void boss5() {
        dialogCreator("Enter Name...", R.drawable.blackpic, "red");
        etState("on");
        bOpt1.setText("Confirm");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm();
            }
        });
    }

    private void confirm() {
        dialogCreator("", R.drawable.blackpic, "red");
        password = et.getText().toString();
        String lowpassword = toLower(password);
        if (lowpassword.equals("sinner")) {
            etState("off");
            et.setText("");
            esH.updateEvent("startingclass","goodend");
            esH.updateEvent("gotsinner", "yes");
            intentCreator(this,GoodEnding.class);


        } else {
            etState("off");
            et.setText("");
            esH.updateEvent("startingclass","badend");
            esH.updateEvent("gotsinner", "no");
            intentCreator(this,BadEnding.class);

        }
    }

    @Override
    public void onNavOn() {
        navigationAssigner(false,false,false,false);
    }

    @Override
    public void setAreaSong() {
        areasong = JukeBox.REALDANGER;
        esH.updateEvent("song", areasong.getName());
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.waves);
        effect2 = MediaPlayer.create(this, R.raw.emptysound);
        effect1.setLooping(true);
        effect1.setVolume(0.4f, 0.4f);
        effect1.start();
    }
}
