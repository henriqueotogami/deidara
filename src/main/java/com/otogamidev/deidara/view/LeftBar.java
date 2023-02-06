package com.otogamidev.deidara.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LeftBar extends Rectangle {

    public LeftBar(final int barWidth, final int barHeight){
        System.out.println("LeftBar - LeftBar(): BEGIN");
        setWidth(barWidth);
        setHeight(barHeight);
        final String leftBarYellow = "#A88610";
        final Color backgroundBarColor = Color.web(leftBarYellow);
        setFill(backgroundBarColor);
        System.out.println("LeftBar - LeftBar(): END");
    }
}
