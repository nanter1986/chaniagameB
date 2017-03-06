package chaniagame.nanter1986.com.chaniagame;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemsMenu extends Activity {

    String loc;
    ArrayList<Item> menuList = new ArrayList<Item>();

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b10;
    Button b11;
    Button b12;
    Button b13;
    Button b14;
    Button b15;
    Button b16;
    Button b17;
    Button b18;
    Button b19;
    Button b20;

    Button bExit;

    TextView t;
    ImageView im;

    eventSaver esH;

    Item lighthousekey;
    Item bracelet;
    Item drinkgarden;
    Item crowbar;
    Item ring;
    Item pills;
    Item watch;
    Item apostoloikey;
    Item earring;
    Item mpalosticket;
    Item shovel;
    Item necklace;
    Item samariashovel;
    Item bluekey;
    Item keyforblue;
    Item cabinkey;
    Item closetkey;
    Item talisman;
    Item akrotirichurchkey;
    Item akrotirimonasterykey;
    Item akrotiriring;
    Item elafonisiFishingRod;
    Item elafonisiFreshWater;
    Item elafonisiBlueStone;
    Item elafonisiGreenStone;
    Item elafonisiRedStone;
    Item elafonisiBlackStone;
    Item mpalosChurchOneKey;
    Item mpalosChurchTwoKey;
    Item mpalosCrystalBallBlue;
    Item mpalosCrystalBallGreen;
    Item mpalosCrystalBallRed;
    Item handGun;
    Item tzamiNecklace;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_items_menu);

        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);
        b10 = (Button)findViewById(R.id.b10);
        b11 = (Button)findViewById(R.id.b11);
        b12 = (Button)findViewById(R.id.b12);
        b13 = (Button)findViewById(R.id.b13);
        b14 = (Button)findViewById(R.id.b14);
        b15 = (Button)findViewById(R.id.b15);
        b16 = (Button)findViewById(R.id.b16);
        b17 = (Button)findViewById(R.id.b17);
        b18 = (Button)findViewById(R.id.b18);
        b19 = (Button)findViewById(R.id.b19);
        b20 = (Button)findViewById(R.id.b20);

        bExit = (Button)findViewById(R.id.bExit);

        t = (TextView)findViewById(R.id.t);
        im = (ImageView)findViewById(R.id.im);

        esH = new eventSaver(this);
        loc=esH.readEvent("currentLocation");

        //CHANIA ITEMS *************************************************************************

        lighthousekey = new Item("Lighthouse Key",R.drawable.lighthousekey,"A key with the word LIGHTHOUSE on it.");
        bracelet = new Item("Bracelet",R.drawable.bracelet,"A bracelet found inside the Lighthouse.");
        crowbar = new Item("Crowbar",R.drawable.crowbar,"A crowbar taken from the garden.");
        ring = new Item("Ring",R.drawable.ring,"A ring found under the abandoned hotel.");
        drinkgarden = new Item("Bottle of Wine",R.drawable.wine,"A bottle of wine bought at the bar.");
        pills = new Item("Pills",R.drawable.pills,"Sleeping pills stolen from the bar.");
        watch = new Item("Watch",R.drawable.watch,"A watch found in the police station garage.");
        apostoloikey = new Item("Agioi Apostoloi Key",R.drawable.apostoloikey,"A key with the word CHURCH on it.");
        earring = new Item("Earring",R.drawable.earring,"A pair of earrings found in the church in Agioi Apostoloi.");
        mpalosticket = new Item("Mpalos Ticket",R.drawable.ticket,"A ticket bought from the bus station.");
        shovel = new Item("Shovel",R.drawable.shovel,"A shovel taken from a student at the dorm.");
        necklace = new Item("Necklace",R.drawable.necklace,"A necklace found in the empty child grave.");

        //SAMARIA ITEMS *****************************************************************************

        samariashovel = new Item("Shovel",R.drawable.shovelsamaria,"A shovel taken from a guy near Roumeli.");
        bluekey = new Item("Blue key",R.drawable.bluekey,"A key found in the old house with blue windows in Samaria.\nIt says CONTROL ROOM on it.");
        keyforblue = new Item("Old key",R.drawable.keyforblue,"A key found under the stone bridge at samaria.");

        cabinkey = new Item("Cabin Key",R.drawable.cabinkey,"A key ordered from the restaurant(?)");
        closetkey = new Item("Closet Key",R.drawable.closetkey,"A key found behind the TV.");

        //AKROTIRI ITEMS
        talisman=new Item("Talisman",R.drawable.zodiactalisman,"Found isnise a church in Akrotiri.\nA talisman is an object that supposedly  bring good luck\n and protects from evil.");
        akrotirichurchkey=new Item("Church Key",R.drawable.akrotirichurchkey,"A key with the worrd church on it.\nFound in seitan port in the water.");

        akrotirimonasterykey=new Item("Monastery key",R.drawable.akrotirimonasterykey,"A key given to you by the fisherman\n in Stavros.");
        akrotiriring=new Item("Stone hand ring",R.drawable.akrotiriring,"A ring taken from the stone hand\nin Devil's port.");

        //ELAFONISI ITEMS
        elafonisiFishingRod=new Item("Fishing Rod",R.drawable.elafonisifishingrod,"A fishing rod taken from a tree in Kedrodasos.");
        elafonisiFreshWater=new Item("Fresh Water",R.drawable.elafonisiwaterbottle,"A water bottle taken from a tourist at Elafonisi.");
        elafonisiBlueStone=new Item("Blue Stone",R.drawable.elafonisibluestone,"A blue Stone found in Palaiochora");
        elafonisiGreenStone=new Item("Green Stone",R.drawable.elafonisigreenstone,"A green stone found in the lake of Gialos.");
        elafonisiRedStone=new Item("Red Stone",R.drawable.elafonisiredstone,"A red stone found in Karavopetra beach.");
        elafonisiBlackStone=new Item("Black Stone",R.drawable.elafonisiblackstone,"A black stone found in a small lagoon.");


        //MPALOS ITEMS
        mpalosChurchOneKey=new Item("Church 1 key",R.drawable.mpaloskeyone,"A key found in a tomb in Gramvousa.");
        mpalosChurchTwoKey=new Item("Church 2 key",R.drawable.mpaloskeytwo,"A key found in some church ruins in Gramvousa.");
        mpalosCrystalBallBlue=new Item("Blue Crystal Ball",R.drawable.mpalosblueball,"A blue crystal ball found in the shipwreck in Gramvousa.");
        mpalosCrystalBallGreen=new Item("Green Crystal Ball",R.drawable.mpalosgreenball,"A green crystal ball found in a church");
        mpalosCrystalBallRed=new Item("Red Crystal Ball",R.drawable.mpalosredball,"A red crystal ball found in a church");

        //CHANIA AFTER
        handGun=new Item("Handgun",R.drawable.handgun,"A handgun loaded with bullets.");
        tzamiNecklace=new Item("Necklace",R.drawable.tzaminecklace,"An expensive old necklace stolen from the mosque.");


        fillArray();
        displayArray();
    }

    public void exitToGame(View v){
        finish();
    }

    private void displayArray() {
        if(menuList.size()>0){
            b1.setText(menuList.get(0).name);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(0).description);
                    im.setImageResource(menuList.get(0).image);
                }
            });

        }
        if(menuList.size()>1){
            b2.setText(menuList.get(1).name);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(1).description);
                    im.setImageResource(menuList.get(1).image);
                }
            });

        }
        if(menuList.size()>2){
            b3.setText(menuList.get(2).name);
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(2).description);
                    im.setImageResource(menuList.get(2).image);
                }
            });

        }
        if(menuList.size()>3){
            b4.setText(menuList.get(3).name);
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(3).description);
                    im.setImageResource(menuList.get(3).image);
                }
            });

        }
        if(menuList.size()>4){
            b5.setText(menuList.get(4).name);
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(4).description);
                    im.setImageResource(menuList.get(4).image);
                }
            });

        }
        if(menuList.size()>5){
            b6.setText(menuList.get(5).name);
            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(5).description);
                    im.setImageResource(menuList.get(5).image);
                }
            });

        }
        if(menuList.size()>6){
            b7.setText(menuList.get(6).name);
            b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(6).description);
                    im.setImageResource(menuList.get(6).image);
                }
            });

        }
        if(menuList.size()>7){
            b8.setText(menuList.get(7).name);
            b8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(7).description);
                    im.setImageResource(menuList.get(7).image);
                }
            });

        }
        if(menuList.size()>8){
            b9.setText(menuList.get(8).name);
            b9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(8).description);
                    im.setImageResource(menuList.get(8).image);
                }
            });

        }
        if(menuList.size()>9){
            b10.setText(menuList.get(9).name);
            b10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(9).description);
                    im.setImageResource(menuList.get(9).image);
                }
            });

        }
        if(menuList.size()>10){
            b11.setText(menuList.get(10).name);
            b11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(10).description);
                    im.setImageResource(menuList.get(10).image);
                }
            });

        }
        if(menuList.size()>11){
            b12.setText(menuList.get(11).name);
            b12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(11).description);
                    im.setImageResource(menuList.get(11).image);
                }
            });

        }
        if(menuList.size()>12){
            b13.setText(menuList.get(12).name);
            b13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(12).description);
                    im.setImageResource(menuList.get(12).image);
                }
            });

        }
        if(menuList.size()>13){
            b14.setText(menuList.get(13).name);
            b14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(13).description);
                    im.setImageResource(menuList.get(13).image);
                }
            });

        }
        if(menuList.size()>14){
            b15.setText(menuList.get(14).name);
            b15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(14).description);
                    im.setImageResource(menuList.get(14).image);
                }
            });

        }
        if(menuList.size()>15){
            b16.setText(menuList.get(15).name);
            b16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(15).description);
                    im.setImageResource(menuList.get(15).image);
                }
            });

        }
        if(menuList.size()>16){
            b17.setText(menuList.get(16).name);
            b17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(16).description);
                    im.setImageResource(menuList.get(16).image);
                }
            });

        }
        if(menuList.size()>17){
            b18.setText(menuList.get(17).name);
            b18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(17).description);
                    im.setImageResource(menuList.get(17).image);
                }
            });

        }
        if(menuList.size()>18){
            b19.setText(menuList.get(18).name);
            b19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.setText(menuList.get(18).description);
                    im.setImageResource(menuList.get(18).image);
                }
            });

        }
        if(esH.readEvent("gotMagicNotebook").equals("yes")){
            b20.setText("Magic Notebook");

            b20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MagicNotebook mn=new MagicNotebook("Magic Notebook",R.drawable.magicnotebook,"A book obtained by the demon in the market.");
                    String text=mn.giveAdvice(loc);
                    t.setText(text);
                    im.setImageResource(mn.image);
                }
            });

        }

    }

    private void fillArray() {
        if(esH.readEvent("lighthousekey").equals("yes")){
            menuList.add(lighthousekey);
        }
        if(esH.readEvent("bracelet").equals("yes")){
            menuList.add(bracelet);
        }
        if(esH.readEvent("drinkgarden").equals("yes")){
            menuList.add(drinkgarden);
        }
        if(esH.readEvent("crowbar").equals("yes")){
            menuList.add(crowbar);
        }
        if(esH.readEvent("ring").equals("yes")){
            menuList.add(ring);
        }
        if(esH.readEvent("sleepingpills").equals("yes")){
            menuList.add(pills);
        }
        if(esH.readEvent("watch").equals("yes")){
            menuList.add(watch);
        }
        if(esH.readEvent("apostoloikey").equals("yes")){
            menuList.add(apostoloikey);
        }
        if(esH.readEvent("earring").equals("yes")){
            menuList.add(earring);
        }
        if(esH.readEvent("mpalosticket").equals("yes")){
            menuList.add(mpalosticket);
        }
        if(esH.readEvent("shovel").equals("yes")){
            menuList.add(shovel);
        }
        if(esH.readEvent("necklace").equals("yes")){
            menuList.add(necklace);
        }
        if(esH.readEvent("bluekey").equals("yes")){
            menuList.add(bluekey);
        }
        if(esH.readEvent("keyforblue").equals("yes")){
            menuList.add(keyforblue);
        }
        if(esH.readEvent("samariashovel").equals("yes")){
            menuList.add(samariashovel);
        }
        if(esH.readEvent("cabinkey").equals("yes")){
            menuList.add(cabinkey);
        }
        if(esH.readEvent("closetkey").equals("yes")){
            menuList.add(closetkey);
        }
        if(esH.readEvent("talisman").equals("yes")){
            menuList.add(talisman);
        }
        if(esH.readEvent("akrotirichurchkey").equals("yes")){
            menuList.add(akrotirichurchkey);
        }
        if(esH.readEvent("akrotirimonasterykey").equals("yes")){
            menuList.add(akrotirimonasterykey);
        }
        if(esH.readEvent("akrotiriring").equals("yes")){
            menuList.add(akrotiriring);
        }
        if(esH.readEvent("elafonisiFishingRod").equals("yes")){
            menuList.add(elafonisiFishingRod);
        }
        if(esH.readEvent("elafonisiFreshWater").equals("yes")){
            menuList.add(elafonisiFreshWater);
        }
        if(esH.readEvent("elafonisiBlueStone").equals("yes")){
            menuList.add(elafonisiBlueStone);
        }
        if(esH.readEvent("elafonisiGreenStone").equals("yes")){
            menuList.add(elafonisiGreenStone);
        }
        if(esH.readEvent("elafonisiRedStone").equals("yes")){
            menuList.add(elafonisiRedStone);
        }
        if(esH.readEvent("elafonisiBlackStone").equals("yes")){
            menuList.add(elafonisiBlackStone);
        }
        if(esH.readEvent("mpalosChurchOneKey").equals("yes")){
            menuList.add(mpalosChurchOneKey);
        }
        if(esH.readEvent("mpalosChurchTwoKey").equals("yes")){
            menuList.add(mpalosChurchTwoKey);
        }
        if(esH.readEvent("mpalosCrystalBallBlue").equals("yes")){
            menuList.add(mpalosCrystalBallBlue);
        }
        if(esH.readEvent("mpalosCrystalBallGreen").equals("yes")){
            menuList.add(mpalosCrystalBallGreen);
        }
        if(esH.readEvent("mpalosCrystalBallRed").equals("yes")){
            menuList.add(mpalosCrystalBallRed);
        }
        if(esH.readEvent("handGun").equals("yes")){
            menuList.add(handGun);
        }
        if(esH.readEvent("gotTzamiNecklace").equals("yes")){
            menuList.add(tzamiNecklace);
        }







    }
}
