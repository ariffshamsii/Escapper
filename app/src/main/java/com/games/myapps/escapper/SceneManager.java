package com.games.myapps.escapper;

import java.util.ArrayList;

/**
 * Created by Arif on 8/2/2017.
 */

public class SceneManager {

    private ArrayList<IScene>scenes = new ArrayList<>();
    private int activeScene;

    public SceneManager()
    {
        activeScene = 0;
    }
}
