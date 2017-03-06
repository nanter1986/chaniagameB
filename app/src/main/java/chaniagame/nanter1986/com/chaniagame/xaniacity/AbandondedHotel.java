package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class AbandondedHotel extends RoomMaker {


    @Override
    public void north(View north) {


    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this, AgioiApostoloi.class);
    }

    @Override
    public void east(View east) {
        intentCreator(this, NeaXwra.class);
    }

    @Override
    public void investigate(View investigate) {
        bOpt1.setText("Pool");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool();
            }
        });

        bOpt2.setText("Basement");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basement();
            }
        });

        bOpt3.setText("Walls");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                walls();
            }
        });
        exitForward();
    }

    private void walls() {
        dialogCreator("Something is written in color:\nINSIDE THE MIRROR IS THE SKY", R.drawable.blackpic, "red");
        exitForward();
    }

    private void basement() {
    }

    private void pool() {
        if (esH.readEvent("hoteldoor").equals("unlocked")) {
            unlocked();
        } else if (esH.readEvent("crowbar").equals("yes")) {
            esH.updateEvent("hoteldoor", "unlocked");
            esH.updateEvent("crowbar", "used");
            dialogCreator("You opened the trapdoor with the crowbar.", R.drawable.blackpic, "red");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    trapdoor();
                }
            });
        } else {
            dialogCreator("There is a trapdoor in the water.\nI can't open it with my hands.", R.drawable.blackpic, "red");
            exitForward();
        }
    }

    private void unlocked() {
        intentCreator(this, UnderPool.class);
    }

    private void trapdoor() {
        intentCreator(this, UnderPool.class);
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.abandonded);
    }


    @Override
    public void setStartingTextOptions() {
        dialogCreator("The ruins of a hotel", R.drawable.blackpic, "red");


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
        areasong = JukeBox.DROP;
        esH.updateEvent("song", areasong.getName());
    }
}
