package com.games.myapps.escapper;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

/**
 * Created by Arif on 8/2/2017.
 */

public class SceneManager {

    private ArrayList<IScene>scenes = new ArrayList<>();
    public static int ACTIVE_SCENE;

    public SceneManager()
    {
        ACTIVE_SCENE = 0;
        scenes.add(new GameplayScene());
    }

    public void recieveTouch(MotionEvent event)
    {
        scenes.get(ACTIVE_SCENE).recieveTouch(event);
    }

    public void update()
    {
        scenes.get(ACTIVE_SCENE).update();
    }

    public void draw(Canvas canvas)
    {
        scenes.get(ACTIVE_SCENE).draw(canvas);
    }

}
