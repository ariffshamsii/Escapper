package com.games.myapps.escapper;

import android.graphics.Canvas;

/**
 * Created by Arif on 8/2/2017.
 */

public interface IScene {

    public void update();
    public void draw(Canvas canvas);
    public void terminate();
}
