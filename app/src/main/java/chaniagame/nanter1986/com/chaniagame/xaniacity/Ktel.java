package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;

import java.util.Random;

import chaniagame.nanter1986.com.chaniagame.fragokastello.Fragokastello;
import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.mpalos.Mpalos;
import chaniagame.nanter1986.com.chaniagame.elafonisi.Palaioxwra;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.samaria.SamariaEntrance;
import chaniagame.nanter1986.com.chaniagame.stories.StoryCollected5;
import chaniagame.nanter1986.com.chaniagame.akrotiri.Akrotiri;

public class Ktel extends RoomMaker {


    @Override
    public void setStartingTextOptions() {
        if (esH.readEvent("storycollected5").equals("yes")) {
            esH.updateEvent("startingclass", "ktel");
        } else if (esH.readEvent("earring").equals("yes") && esH.readEvent("bracelet").equals("yes") && esH.readEvent("necklace").equals("yes") && esH.readEvent("ring").equals("yes") && esH.readEvent("watch").equals("yes")) {
            dialogCreator("Well done.........");
            bForward.setText(">>");
            intentCreator(this, StoryCollected5.class);
        }

        if (esH.readEvent("allFiveDonesDone").equals("yes")) {
                    demon();

        } else {

            dialogCreator("The bus station.", R.drawable.blackpic, "red");
        }
        Log.i("info",esH.readEvent("allFiveDonesDone"));

    }

    private void demon() {
        dialogCreator("I have no choice but to go meet that demon\nor whatever it is.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                demon1();
            }
        });
    }

    private void demon1() {
        dialogCreator("The island across the city...\nHow do I get there?");
        exitForward();
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
        areasong = JukeBox.AGORAANDROID;
        esH.updateEvent("song", areasong.getName());
    }

    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this, SamariaEntrance.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {
        intentCreator(this, sq1866.class);
    }

    @Override
    public void investigate(View investigate) {
        bOpt1.setText("Tickets");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tickets();
            }
        });
        bOpt2.setText("Waiting\nRoom");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waitingroom();
            }
        });
        if (esH.readEvent("storycollected5").equals("yes")) {
            bOpt3.setText("Memories");
            bOpt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    memories();
                }
            });
        }
        exitForward();
    }

    private void memories() {
        dialogCreator("Choose your destination:");
        if (esH.readEvent("donesamaria").equals("no")) {
            bOpt1.setText("Samaria");
            bOpt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    samaria();
                }
            });
        }
        if (esH.readEvent("doneelafonisi").equals("no") && esH.readEvent("donefragokastello").equals("yes")) {
            bOpt2.setText("Elafonisi");
            bOpt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    elafonisi();
                }
            });
        }
        if (esH.readEvent("donempalos").equals("no") && esH.readEvent("doneelafonisi").equals("yes")) {
            bOpt3.setText("Mpalos");
            bOpt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mpalos();
                }
            });
        }
        if (esH.readEvent("doneakrotiri").equals("no") && esH.readEvent("donesamaria").equals("yes")) {
            bOpt4.setText("Akrotiri");
            bOpt4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    akrotiri();
                }
            });
        }
        if (esH.readEvent("donefragokastello").equals("no") && esH.readEvent("doneakrotiri").equals("yes")) {
            bOpt5.setText("Fragokastello");
            bOpt5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragokastello();
                }
            });
        }
        exitForward();
    }

    private void fragokastello() {
        intentCreator(this, Fragokastello.class);
    }

    private void akrotiri() {
        intentCreator(this, Akrotiri.class);
    }

    private void mpalos() {
        intentCreator(this, Mpalos.class);
    }

    private void elafonisi() {
        intentCreator(this, Palaioxwra.class);
    }

    private void samaria() {
        intentCreator(this, SamariaEntrance.class);
    }

    private void waitingroom() {
        int ktelNumber;
        Random r = new Random();
        ktelNumber = r.nextInt(12);

        switch (ktelNumber) {
            case 0:
                dialogCreator("Voice from speakers says:\nThe history of Crete is more ancient \nthan the history of the European continent.");
                exitForward();
                break;
            case 1:
                dialogCreator("Voice from speakers says:\nHippocrates prescribed the air of Crete \nfor the healing of many illnesses;\n this has carried on throughout today.");
                exitForward();
                break;
            case 2:
                dialogCreator("Voice from speakers says:\nCrete was only united with the rest of Greece in 1913.");
                exitForward();
                break;
            case 3:
                dialogCreator("Voice from speakers says:\nAccording to the Legends and Greek Myths, \nthe mighty God Zeus was born in Crete,\n hidden in a cave (dikteon andron) by his mother Rhea,\nso his father Cronus could not find him and kill him.");
                exitForward();
                break;
            case 4:
                dialogCreator("Voice from speakers says:\nCrete is the only region of Greece \nwhere there still occur a large number\nof vernacular buildings of the 16th, 17th, 18th Centuries.");
                exitForward();
                break;
            case 5:
                dialogCreator("Voice from speakers says:\nKnossos is the second most visited \nArchaeological site in Greece\nafter the Acropolis with over 1 million visitors per year.");
                exitForward();
                break;
            case 6:
                dialogCreator("Voice from speakers says:\nCrete was described by Homer in Odyssey,\nas an island abundant with people where in ninety different\ncities different languages are spoken.");
                exitForward();
                break;
            case 7:
                dialogCreator("Voice from speakers says:\nCrete is located on the cross-road between,\nthe paths of the light Europe,\nAfrica and Asia, practically at the identical distance\nfrom these three continents.");
                exitForward();
                break;
            case 8:
                dialogCreator("Voice from speakers says:\nThe highest mountain of Crete \nis Psiloritis reaching up to 2456 meters");
                exitForward();
                break;
            case 9:
                dialogCreator("Voice from speakers says:\nOne of the finest cannabis sold \nin Amsterdam is of Cretan origin.");
                exitForward();
                break;
            case 10:
                dialogCreator("Voice from speakers says:\nThe Minoans apart from being the first Europeans,\nwhere also the first to create a sewage system,\napproximately 4000 years ago.");
                exitForward();
                break;
            case 11:
                dialogCreator("Voice from speakers says:\nCrete has more than 3000 caves.");
                exitForward();
                break;


        }
    }

    private void tickets() {
        if (esH.readEvent("knowmpalos").equals("no")) {
            dialogCreator("You can buy tickets here.\nHow can I help you?", R.drawable.ticketwoman, "green");
            exitForward();
        } else if (esH.readEvent("knowmpalos").equals("given") && esH.readEvent("mpalosticket").equals("yes")) {
            dialogCreator("You can buy tickets here.\nHow can I help you?", R.drawable.ticketwoman, "green");
            exitForward();
        } else if (esH.readEvent("knowmpalos").equals("yes") && esH.readEvent("mpalosticket").equals("no")) {
            esH.updateEvent("mpalosticket", "yes");
            dialogCreator("A ticket to Mpalos?\nHere you go.", R.drawable.ticketwoman, "green");
            exitForward();
        }
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.ktel);
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.busstation);
        effect2 = MediaPlayer.create(this, R.raw.emptysound);
        effect1.setLooping(true);
        effect1.setVolume(0.5f, 0.5f);
        effect1.start();
    }
}
