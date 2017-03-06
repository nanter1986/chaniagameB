package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class AgoraAct extends RoomMaker {


    public void investigate(View investigate) {
        dialogCreator("What do you want to investigate?", R.drawable.blackpic, "red");
        bOpt1.setText("Clock");
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clock();
            }
        });
        bOpt2.setText("Statue");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statue();
            }
        });
        bOpt3.setText("Toilets");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toilets();
            }
        });
        exitForward();
    }

    private void statue() {
        keyopen = esH.readEvent("lighthousekey");
        dialogCreator("", R.drawable.blackpic, "red");
        if (keyopen.equals("no")) {
            passwordEnter();
        } else {
            redlight();
        }
    }

    private void redlight() {
        dialogCreator("A red light is blinking",R.drawable.blackpic,"red");
        resetOptions();
        exitForward();
    }

    private void passwordEnter() {
        dialogCreator("There is a password panel behind the statue.\n" +
                "Do you want to enter the password?", R.drawable.blackpic, "red");
        bOpt1.setText("YES");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yes();
            }
        });
        bOpt2.setText("NO");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no();
            }
        });
        exitForward();
    }

    private void no() {
        etState("off");
        et.setText("");
        dialogCreator("", R.drawable.blackpic, "red");
        exitForward();
    }

    private void clock() {
        dialogCreator("It's stopped at 05:40", R.drawable.blackpic, "red");
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
        password = et.getText().toString();
        String lowpassword = toLower(password);
        if (lowpassword.equals("venizelos")) {
            etState("off");
            et.setText("");
            dialogCreator("Correct password.\nYou obtained the lighthouse key", R.drawable.blackpic, "red");
            esH.updateEvent("lighthousekey", "yes");
            exitForward();


        } else {
            etState("off");
            et.setText("");
            dialogCreator("Incorrect password", R.drawable.blackpic, "red");
            exitForward();
        }
    }

    private void toilets() {
        resetOptions();
        dialogCreator("The city's public toilets.\nThey are quite clean actually.\nNoone is here", R.drawable.blackpic, "red");
        exitForward();
    }


    @Override
    public void setBack() {
        b.setImageResource(R.drawable.agora);
    }


    public void north(View north) {
        if (nav.equals("on")) {
            intentCreator(this, insideAgora.class);


        } else {

        }


    }


    @Override
    public void setStartingTextOptions() {
        dialogCreator("The market square of the city.\nIt's full of people.", R.drawable.blackpic, "red");

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("North");
            bSouth.setText("South");
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
        areasong= JukeBox.AGORAANDROID;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void south(View south) {

        intentCreator(this, sq1866.class);

    }

    @Override
    public void west(View west) {

        intentCreator(this, Port.class);


    }

    @Override
    public void east(View east) {

        intentCreator(this, Garden.class);

    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.crowssquare);
        effect2 = MediaPlayer.create(this, R.raw.emptysound);
        effect1.setLooping(true);
        effect1.setVolume(0.5f, 0.5f);
        effect1.start();
    }
}
