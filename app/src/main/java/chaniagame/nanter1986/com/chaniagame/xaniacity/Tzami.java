package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class Tzami extends RoomMaker {


    @Override
    public void north(View north) {

        intentCreator(this, Faros.class);


    }

    @Override
    public void south(View south) {

        intentCreator(this, AgoraAct.class);


    }


    @Override
    public void setStartingTextOptions() {
        if (esH.readEvent("gotTzamiNecklace").equals("yes")) {
            dialogCreator("The door is locked again.");
        } else if (esH.readEvent("tzamiDoorUnlocked").equals("yes")) {
            enterUnlockedDoor();

        }else if(esH.readEvent("killedTzamiDoor").equals("yes")) {
            goInTzami();
        }else if (esH.readEvent("knowAboutNecklace").equals("yes")) {
            shootOrAsk();
        } else {
            dialogCreator("An old mosque.", R.drawable.blackpic, "red");

        }

    }

    private void enterUnlockedDoor() {
        dialogCreator("He really opened the door....");
        bOpt1.setText("Enter");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goInTzami();
            }
        });
    }

    private void goInTzami() {
        intentCreator(this,TzamiRoom.class);

    }

    private void shootOrAsk() {
        if (esH.readEvent("handGun").equals("yes")) {
            dialogCreator("Would you like to shoot the door?");
            bOpt1.setText("Yes");
            bOpt2.setText("No");
            bOpt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    yesShoot();
                }
            });
            bOpt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setStartingText();
                }
            });
        } else {
            dialogCreator("Why is this place always locked?\nI need to find a way to get in \nand take the necklace.");

        }
    }

    private void yesShoot() {
        esH.updateEvent("handGun","used");
        esH.updateEvent("killedTzamiDoor","yes");
        dialogCreator("You shoot and open the door");
        exitForward();
    }


    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("North");
            bSouth.setText("South");
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
        areasong = JukeBox.AGORAANDROID;
        esH.updateEvent("song", areasong.getName());
    }

    @Override
    public void west(View west) {

        intentCreator(this, Port.class);


    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.tzami);
    }
}
