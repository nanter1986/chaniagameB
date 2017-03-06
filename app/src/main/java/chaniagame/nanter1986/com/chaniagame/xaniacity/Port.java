package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;

import java.util.Random;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.stories.BadEnding;
import chaniagame.nanter1986.com.chaniagame.stories.BadEndingB;

public class Port extends RoomMaker {


    public void setBack() {
        b.setImageResource(R.drawable.portday);
    }


    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this, AgoraAct.class);
    }


    @Override
    public void setStartingTextOptions() {
        if (esH.readEvent("allFiveDonesDone").equals("yes")) {
            dialogCreator("There is a boat that takes tourists on tours around the coast...");
        } else {
            dialogCreator("The port.\nThere are a lot of restaurants \nand coffee shops around.", R.drawable.blackpic, "red");

        }


    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
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
        areasong = JukeBox.AGORAANDROID;
        esH.updateEvent("song", areasong.getName());
    }

    @Override
    public void west(View west) {
        if (esH.readEvent("killedBarwoman").equals("yes")) {
            dialogCreator("The bar is closed.");
            Handler h = new Handler();
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    runOutside();
                }
            };
            h.postDelayed(r, 3000);
        } else {
            intentCreator(this, Bar.class);

        }


    }

    private void runOutside() {
        intentCreator(this, HandMonument.class);
    }

    @Override
    public void east(View east) {

        intentCreator(this, Tzami.class);


    }

    @Override
    public void investigate(View investigate) {
        if (esH.readEvent("allFiveDonesDone").equals("yes")) {
            boatMan();
        } else {
            guy();
        }

    }

    private void boatMan() {
        if(esH.readEvent("killedBoatman").equals("yes")) {
            killedBoatman();
        }else if (esH.readEvent("gotTzamiNecklace").equals("yes")) {
            if (esH.readEvent("killedBarwoman").equals("yes")) {
                killedBarWoman();
            }else{
                stoleNecklace();
            }


        }else if(esH.readEvent("handGun").equals("yes")){
            shootBoatmanOrNot();
        } else {
            talkToBoatman();

        }
    }

    private void shootBoatmanOrNot() {
        dialogCreator("Do you want to shoot the boatman?");
        bOpt1.setText("Yes");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                killingHim();
            }
        });
        bOpt2.setText("No");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStartingText();
            }
        });
    }

    private void killingHim() {
        esH.updateEvent("killedBoatman","yes");
        esH.updateEvent("handGun","used");
        dialogCreator("You shoot him 5 times.");
        exitForward();
    }


    private void stoleNecklace() {
        esH.updateEvent("gotTzamiNecklace","used");
        dialogCreator("Is this...\nOf course I will take you to Agioi Theodoroi. \n" +
                "My wife's gonna love this. ");
       Runnable r = new Runnable() {
           @Override
           public void run() {
               stoleNecklace2();
           }
       };
        Handler h = new Handler();
        h.postDelayed(r,4000);

    }



    private void stoleNecklace2() {
        intentCreator(this,ToTheSea.class);
    }

    private void killedBoatman() {
        dialogCreator("You enter the boat.");
        bOpt1.setText("Drive");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toTheSea();
            }
        });
        exitForward();
    }

    private void toTheSea() {
        intentCreator(this,ToTheSea.class);
    }

    private void killedBarWoman() {
        dialogCreator("The necklace is useless to me now.\nMy wife got murdered while doing her job at the bar.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBoatKeys();
            }
        });
    }

    private void getBoatKeys() {
        dialogCreator("Nooooooooooooo...........");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trapped();
            }
        });
    }

    private void trapped3() {
        esH.updateEvent("startingclass","badendB");
        intentCreator(this,BadEndingB.class);
    }

    private void trapped2() {
        dialogCreator("I will spend an eternity on this dream world....");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trapped3();
            }
        });
    }

    private void trapped1() {
        dialogCreator("OMG now I can't go to the island and save my brother.\nI'm trapped here.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trapped2();
            }
        });
    }

    private void trapped() {
        dialogCreator("[BOAT DRIVER]I sold my boat.\nIt's not in this island anymore.\nAnd it was the only one.\nIt was reminding me of my wife.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trapped1();
            }
        });
    }

    private void talkToBoatman() {
        esH.updateEvent("talkToBoatMan", "yes");
        dialogCreator("[BOAT DRIVER]To Agioi Theodoroi?\nNo this boat doesn't go there.");
        exitForward();
    }

    private void guy() {
        dialogCreator("There is a guy sitting on the bench.\nDo you want to sit next to him?");
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
                no();
            }
        });
        exitForward();
    }

    private void no() {
        setStartingText();
    }

    private void yes() {
        int portNumber;
        Random r = new Random();
        portNumber = r.nextInt(10);

        switch (portNumber) {
            case 0:
                dialogCreator("This city has a population around 50000", R.drawable.benchport, "green");
                exitForward();
                break;
            case 1:
                dialogCreator("The wine in the market is good, but you shouldn't buy it...\nperhaps I want it all for me", R.drawable.benchport, "green");
                exitForward();
                break;
            case 2:
                dialogCreator("I heard a guy the other night in the bar,\ntalking about having the key to the lighthouse\nbut Im not sure\nI was quite drunk", R.drawable.benchport, "green");
                exitForward();
                break;
            case 3:
                dialogCreator("Sometimes it gets really dark at night....", R.drawable.benchport, "green");
                exitForward();
                break;
            case 4:
                dialogCreator("There is an island called agioi theodwroi across the city\nonce i saw a weird light coming out of the big cave\nthat is there", R.drawable.benchport, "green");
                exitForward();
                break;
            case 5:
                dialogCreator("I have a friend in kounoupidiana\nhe is a professor...", R.drawable.benchport, "green");
                exitForward();
                break;
            case 6:
                dialogCreator("There was an ancient city here named Kydonia.", R.drawable.benchport, "green");
                exitForward();
                break;
            case 7:
                dialogCreator("If you ever need a gun...\nWell, I can't help you with that", R.drawable.benchport, "green");
                exitForward();
                break;
            case 8:
                dialogCreator("Have you ever visited the samaria gorge?", R.drawable.benchport, "green");
                exitForward();
                break;
            case 9:
                dialogCreator("The garden has all sorts of weird birds.", R.drawable.benchport, "green");
                exitForward();
                break;

        }
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.waves);
        effect2 = MediaPlayer.create(this, R.raw.emptysound);
        effect1.setLooping(true);
        effect1.setVolume(0.7f, 0.7f);
        effect1.start();
    }
}
