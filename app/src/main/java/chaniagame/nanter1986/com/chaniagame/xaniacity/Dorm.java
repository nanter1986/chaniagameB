package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class Dorm extends RoomMaker {


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
        bOpt1.setText("Building");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                building();
            }
        });
        bOpt2.setText("Area");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                area();
            }
        });
        bOpt3.setText("People");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people();
            }
        });
        exitForward();
    }

    private void people() {
        if(esH.readEvent("knowAboutNecklace").equals("yes")){
            exlposives();
        }else{
            people0();
        }

    }

    private void exlposives() {
        dialogCreator("You want to enter the mosque as soon as possible?\n" +
                "I know someone that can open any door.", R.drawable.travelagent, "green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explosives1();
            }
        });
    }

    private void explosives1() {
        dialogCreator("You should find the big hand monument in the city. It's south of the port,\nafter the bar", R.drawable.travelagent, "green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explosives2();
            }
        });
    }

    private void explosives2() {
        dialogCreator("Sit to the right of the monument, with your hands crossed.\nHe will come to you.\nIn his question you should answer:\nticket", R.drawable.travelagent, "green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explosives3();
            }
        });
    }

    private void explosives3() {
        esH.updateEvent("knowHandMonument","yes");
        dialogCreator("No matter wat the question is.", R.drawable.travelagent, "green");
        bForward.setText(">>");
        exitForward();
    }


    private void people0() {
        if(esH.readEvent("mpalosticket").equals("no")) {
            dialogCreator("We are volunteering to plant trees and flowers around,to make the dorm beautiful.", R.drawable.travelagent, "green");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    people1();
                }
            });
        }else if(esH.readEvent("mpalosticket").equals("yes")){
            esH.updateEvent("shovel","yes");
            esH.updateEvent("mpalosticket","given");
            dialogCreator("You have a ticket to Mpalos?\nOf course I want to trade.",R.drawable.travelagent,"green");
            exitForward();
        }else if(esH.readEvent("mpalosticket").equals("given")){
            dialogCreator("Isn't the dorm beautiful with the new plants?\nThanks for the ticket.",R.drawable.travelagent,"green");
            exitForward();
        }
    }

    private void people1() {
        dialogCreator("I bought that shovel for today.\nThen I realized that it's gonna be of no use to me later.\nSigh...",R.drawable.travelagent,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people2();
            }
        });
    }

    private void people2() {
        esH.updateEvent("knowmpalos","yes");
        dialogCreator("Maybe I'll be able to trade it \nfor a bus ticket to Mpalos.\n My friends will go there next week.",R.drawable.travelagent,"green");
        exitForward();
    }

    private void area() {
        dialogCreator("The building is surrounded by rocks, bushes,\nand a few trees.\nThere is some digging going on.");
        exitForward();
    }

    private void building() {
        dialogCreator("A rather impressive building for a dorm.");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.dorm);
    }



    @Override
    public void setStartingTextOptions() {
        dialogCreator("The dorm of the university",R.drawable.blackpic,"red");

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
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
        areasong= JukeBox.GOODBYE;
        esH.updateEvent("song",areasong.getName());
    }
}
