package com.otogamidev.deidara.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AlgorithmBody extends Rectangle {

    public AlgorithmBody(final int bodyWidth, final int bodyHeight) {
        System.out.println("AlgorithmBody - AlgorithmBody(): BEGIN");
        setWidth(bodyWidth);
        setHeight(bodyHeight);
        final String bodyYellow = "#D6A700";
        final Color backgroundBarColor = Color.web(bodyYellow);
        setFill(backgroundBarColor);
        System.out.println("AlgorithmBody - AlgorithmBody(): END");
    }


}
