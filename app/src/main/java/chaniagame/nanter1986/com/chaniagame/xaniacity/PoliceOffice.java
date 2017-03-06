package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class PoliceOffice extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this,policeStation.class);
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
        if (esH.readEvent("sleepingpills").equals("used")) {
            bOpt1.setText("Door");
            bOpt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doorclear();
                }
            });
            exitForward();
        } else {
            bOpt1.setText("Door");
            bOpt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    door();
                }
            });

            bOpt2.setText("Safety");
            bOpt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    safety();
                }
            });

            bOpt3.setText("Deaths");
            bOpt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deaths();
                }
            });
            if (esH.readEvent("sleepingpills").equals("yes")) {
                bOpt4.setText("Pills");
                bOpt4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        usepills();
                    }
                });
                exitForward();

            }
        }
    }

    private void usepills() {
        dialogCreator("You put the pills into his coffee", R.drawable.blackpic,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirty();
            }
        });
    }

    private void thirty() {
        dialogCreator("30 minutes later...",R.drawable.blackpic,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asleep();
            }
        });
    }

    private void asleep() {
        dialogCreator("He fell asleep.",R.drawable.blackpic,"red");
        esH.updateEvent("sleepingpills","used");
        exitForward();

    }



    private void safety() {
        dialogCreator("We do everything we can to keep you safe.",R.drawable.blackpic,"red");
        exitForward();
    }

    private void door() {
        dialogCreator("I can't let you pass ,sir.\nThis is for police officers only.",R.drawable.blackpic,"red");
        exitForward();
    }

    private void deaths() {
        dialogCreator("We are not allowed to talk about that\nwith civilians.",R.drawable.blackpic,"red");
        exitForward();
    }

    private void doorclear() {
        intentCreator(this,PoliceGarage.class);
    }



    @Override
    public void setBack() {
        b.setImageResource(R.drawable.policeoffice);
    }



    @Override
    public void setStartingTextOptions() {
        dialogCreator("Offices in the police station.",R.drawable.blackpic,"red");

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("North");
        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.DANGER;
        esH.updateEvent("song",areasong.getName());
    }
}
