package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class TucOffices extends RoomMaker {


    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,Tuc.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        if(esH.readEvent("officeunlocked").equals("no")){
            passwordEnter();
        }else if(esH.readEvent("officeunlocked").equals("yes")){
            invoffice();
        }
    }

    private void invoffice() {
        dialogCreator("What do you want to investigate?", R.drawable.blackpic, "red");
        bOpt1.setText("Drawers");
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                drawers();
            }
        });
        bOpt2.setText("Books");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                books();
            }
        });
        bOpt3.setText("Desktop");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desktop();
            }
        });
        exitForward();
    }

    private void desktop() {
        dialogCreator("A note is on the desk:\nBLACK,BLUE,GREEN,RED,YELLOW,WHITE");
        exitForward();
    }

    private void books() {

    }

    private void drawers() {
        if(esH.readEvent("apostoloikey").equals("no")){
            esH.updateEvent("apostoloikey","yes");
            dialogCreator("You obtained the church key");
            exitForward();
        }else if(esH.readEvent("apostoloikey").equals("yes")){
            dialogCreator("Just useless things");
            exitForward();
        }
    }

    private void passwordEnter() {
        dialogCreator("Do you want to enter the password?");
        bOpt1.setText("Yes");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yes();
            }
        });
        bOpt2.setText("No");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStartingText();
            }
        });
        exitForward();
    }

    private void yes() {
        dialogCreator("Enter Password...", R.drawable.blackpic, "red");
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
        passwordOffice = et.getText().toString();
        String lowpassword = toLower(passwordOffice);
        if (lowpassword.equals("321830")) {
            effect2.start();
            etState("off");
            et.setText("");
            dialogCreator("Correct password.\nOffice unlocked.", R.drawable.blackpic, "red");
            esH.updateEvent("officeunlocked", "yes");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    unlock();
                }
            });


        } else {
            etState("off");
            et.setText("");
            dialogCreator("Incorrect password", R.drawable.blackpic, "red");
            exitForward();
        }
    }

    private void unlock() {
        intentCreator(this,TucOffices.class);
    }


    @Override
    public void setBack() {
        if(esH.readEvent("officeunlocked").equals("no")){
            b.setImageResource(R.drawable.tucofficedoor);
        }else if(esH.readEvent("officeunlocked").equals("yes")){
            b.setImageResource(R.drawable.mpakakisoffice);
        }
    }

    @Override
    public void setStartingTextOptions() {

        if(esH.readEvent("officeunlocked").equals("no")){
            dialogCreator("This is the office of professor Mpakakis.\nIt's locked with a password.");
        }else if(esH.readEvent("officeunlocked").equals("yes")){
            dialogCreator("This is the office of professor Mpakakis.");
        }
    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bSouth.setText("Exit");
        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.REALDANGER;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.waves);
        effect2 = MediaPlayer.create(this, R.raw.unlock);

    }
}
