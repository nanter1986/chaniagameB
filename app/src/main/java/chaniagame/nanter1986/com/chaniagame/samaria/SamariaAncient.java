package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class SamariaAncient extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this, SamariaRanger.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this, SamariaRocks.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        dialogCreator("There are 3 buildings.\nWhat do you want to investigate?", R.drawable.blackpic, "red");
        bOpt1.setText("Large");
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                large();
            }
        });
        bOpt2.setText("Medium");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medium();
            }
        });
        bOpt3.setText("Small");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                small();
            }
        });
        exitForward();
    }

    private void medium() {
        dialogCreator("It's a new building with iron bars on the small windows.\nNothing can be heard from the inside.\nDo you want to enter?");
        bOpt1.setText("Yes");
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                yesenter();
            }
        });
        bOpt2.setText("No");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noenter();
            }
        });
    }

    private void noenter() {
        setStartingText();
    }

    private void yesenter() {
        if (esH.readEvent("bluekey").equals("yes")) {
            esH.updateEvent("bluekey", "used");
            dialogCreator("You unlocked the door.");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intentCreator(getBaseContext(),SamariaControlRoom.class);
                }
            });
        } else if (esH.readEvent("bluekey").equals("used")) {
            intentCreator(this, SamariaControlRoom.class);
        } else if (esH.readEvent("bluekey").equals("no")) {
            dialogCreator("It's locked");
            exitForward();
        }
    }

    private void large() {
        dialogCreator("It's an old building and it looks at least 100 years old.\nNothing useful here.");
        exitForward();
    }

    private void small() {
        dialogCreator("It looks like a storage room for tools.\nI can see hammers, saws and shovels.\nKinda creepy..");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.samariaancient);
    }


    @Override
    public void setStartingTextOptions() {
        dialogCreator("Ancient ruins.", R.drawable.blackpic, "red");

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("North");
            bSouth.setText("South");
        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.HOTEL;
        esH.updateEvent("song",areasong.getName());
    }
}
