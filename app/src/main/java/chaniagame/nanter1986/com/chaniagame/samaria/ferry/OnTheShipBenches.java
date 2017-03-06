package chaniagame.nanter1986.com.chaniagame.samaria.ferry;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 10/8/2016.
 */
public class OnTheShipBenches extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this,OnTheShipCabin.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,OnTheShip.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        bOpt1.setText("Sit");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sit();
            }
        });
    }

    private void sit() {
        esH.updateEvent("knoworder","yes");
        dialogCreator("If you ever want to get off this boat,\nyou have to order at the restaurant.", R.drawable.creepyoldlady,"red");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.ferrytwo);
    }

    @Override
    public void setStartingTextOptions() {
        dialogCreator("Passengers sitting");
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

    }
}
