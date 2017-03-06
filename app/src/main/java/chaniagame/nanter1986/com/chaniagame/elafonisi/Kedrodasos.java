package chaniagame.nanter1986.com.chaniagame.elafonisi;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 12/8/2016.
 */
public class Kedrodasos extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this,WeirdRock.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,Limnaki.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.kerdodasos);
    }

    @Override
    public void setStartingTextOptions() {
        if(esH.readEvent("elafonisiFishingRod").equals("no")){
            if(esH.readEvent("elafonisiFreshWater").equals("no")){
                dialogCreator("You hear a voice coming from an old tree...\nPlease give me fresh water and I will make your hands longer...");
            }else if(esH.readEvent("elafonisiFreshWater").equals("yes")){
                givenRod();
            }

        }
    }

    private void givenRod() {

        dialogCreator("Thank you");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                givenRod2();
            }
        });
    }

    private void givenRod2() {
        dialogCreator("You see one of the branches turn into a fishing rod.\nIt falls to the floor.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                givenRod3();
            }
        });
    }

    private void givenRod3() {
        esH.updateEvent("elafonisiFreshWater","used");
        esH.updateEvent("elafonisiFishingRod","yes");
        dialogCreator("You obtained the fishing rod!.");
        exitForward();
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
        areasong= JukeBox.BITTERSWEET;
        esH.updateEvent("song",areasong.getName());
    }
}
