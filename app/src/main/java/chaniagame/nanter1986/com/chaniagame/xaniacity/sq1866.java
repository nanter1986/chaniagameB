package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class sq1866 extends RoomMaker {


    @Override
    public void north(View north) {

        intentCreator(this,AgoraAct.class);

    }

    @Override
    public void south(View south) {

    }



    @Override
    public void setStartingTextOptions() {

        dialogCreator("A square with trees and statues.", R.drawable.blackpic, "red");
    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("North");
            bWest.setText("West");
        } else {

            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.AGORAANDROID;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void west(View west) {

        intentCreator(this,Ktel.class);

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        dialogCreator("What do you want to investigate?", R.drawable.blackpic, "red");
        bOpt1.setText("Statue 1");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statue1();
            }
        });
        bOpt2.setText("Statue 2");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statue2();
            }
        });
        bOpt3.setText("Statue 3");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statue3();
            }
        });
        bOpt4.setText("Benches");
        bOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                benches();
            }
        });

    }

    private void statue3() {
        dialogCreator("A statue with a phrase carved on the front plate.\n'One cannot kick against geography!'", R.drawable.blackpic, "red");
        exitForward();
    }

    private void benches() {
        dialogCreator("No one of interest sits here.", R.drawable.blackpic, "red");
        exitForward();
    }

    private void statue2() {
        dialogCreator("A statue with some letters carved on the front plate.\nS E N O", R.drawable.blackpic, "red");
        exitForward();
    }

    private void statue1() {
        dialogCreator("A statue with some letters carved on the front plate.\nL E V I Z", R.drawable.blackpic, "red");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.sq1866);
    }
}
