package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class AgioiApostoloi extends RoomMaker {


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
        intentCreator(this,AbandondedHotel.class);
    }

    @Override
    public void investigate(View investigate) {
        dialogCreator("What do you want to investigate?", R.drawable.blackpic, "red");
        bOpt1.setText("Cross");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cross();
            }
        });
        bOpt2.setText("Church");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                church();
            }
        });
        bOpt3.setText("Walls");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                walls();
            }
        });
        bOpt4.setText("Tourist");
        bOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tourist();
            }
        });
        exitForward();
    }

    private void tourist() {
        dialogCreator("Do you know what is in the church?\nI come here often and I start to wonder.",R.drawable.tourist,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tourist1();
            }
        });
    }

    private void tourist1() {
        dialogCreator("3 days ago I saw someone unlocking it and entering.\nI knew this guy from before.\nWe have some common friends and I heard\n that he is a professor at the university",R.drawable.tourist,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tourist2();
            }
        });
    }

    private void tourist2() {
        esH.updateEvent("knowoffice","yes");
        dialogCreator("But I don't know him well enough to ask.\nHis name was Mpakakis I think.",R.drawable.tourist,"green");
        exitForward();
    }

    private void cross() {
        dialogCreator("A regular cross,\nexcept...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cross1();
            }
        });
    }

    private void cross1() {
        dialogCreator("A stone looks out of place.\nI can't move it but it is carved in a sloppy way.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cross2();
            }
        });
    }

    private void cross2() {
        dialogCreator("The carvings are some symbols:\na greek flag,a cake,a present, \nthe flag of england and...\n an office desk?");
        exitForward();
    }

    private void walls() {
        dialogCreator("Something is written on the wall:\nSWIMMING IN THE TAR");
        exitForward();
    }

    private void church() {
        if(esH.readEvent("apostoloidoor").equals("unlocked")){
            unlocked();
        }else if(esH.readEvent("apostoloikey").equals("yes")) {
            unlock();
        }else if(esH.readEvent("apostoloikey").equals("no")){
            keyno();
        }
    }

    private void unlocked() {
        intentCreator(this,InsideApostoloi.class);
    }

    private void unlock() {
        effect2.start();
        esH.updateEvent("apostoloikey","used");
        esH.updateEvent("apostoloidoor","unlocked");
        dialogCreator("You unlocked the door");
        Handler handlerkey = new Handler();
        Runnable rkey = new Runnable() {
            @Override
            public void run() {
                goin();
            }
        };
        handlerkey.postDelayed(rkey,2000);
    }

    private void goin() {
        intentCreator(this,InsideApostoloi.class);
    }

    private void keyno() {
        dialogCreator("It's locked");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.agioiapostoloi);
    }



    @Override
    public void setStartingTextOptions() {
        dialogCreator("A church on a small hill",R.drawable.blackpic,"red");

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
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
        areasong= JukeBox.DROP;
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
