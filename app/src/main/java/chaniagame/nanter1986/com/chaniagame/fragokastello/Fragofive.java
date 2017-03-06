package chaniagame.nanter1986.com.chaniagame.fragokastello;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 17/8/2016.
 */
public class Fragofive extends RoomMaker {
    private String riddleFive;

    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this,FragoFour.class);
    }

    @Override
    public void east(View east) {
        intentCreator(this,FragoSix.class);
    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.fragofive);
    }

    @Override
    public void setStartingTextOptions() {
        if(esH.readEvent("firsttalktostatue").equals("no")  || esH.readEvent("riddle5").equals("yes")){

        }else{
            dialogCreator("Answer with a single word...");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    riddle();
                }
            });
        }
    }

    private void riddle() {
        dialogCreator("What gets broken without being held?");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer();
            }
        });
    }

    private void answer() {
        dialogCreator("Enter answer...", R.drawable.blackpic, "red");
        etState("on");
        bOpt1.setText("Confirm");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm();
            }
        });
        exitForward();
    }

    private void confirm() {
        dialogCreator("", R.drawable.blackpic, "red");
        riddleFive = et.getText().toString();
        String lowpassword = toLower(riddleFive);
        if (lowpassword.equals("promise")) {
            effect1.start();
            etState("off");
            et.setText("");
            esH.updateEvent("riddle5", "yes");
            dialogCreator("Correct Answer.", R.drawable.blackpic, "red");

            exitForward();


        } else {
            etState("off");
            et.setText("");
            dialogCreator("Incorrect answer", R.drawable.blackpic, "red");
            exitForward();
        }
    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bWest.setText("West");
            bEast.setText("East");
        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.MEMORIES;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.bells);
        effect2 = MediaPlayer.create(this, R.raw.unlock);

    }
}
