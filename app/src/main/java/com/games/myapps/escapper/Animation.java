package com.games.myapps.escapper;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Arif on 8/6/2017.
 */

public class Animation {

    private Bitmap[] frames;
    private int frameIndex;
    private float frameTime;
    private long lastFrame;

    private boolean isPlaying = false;

    public Animation(Bitmap[] frames, float animTime)
    {
        this.frames = frames;
        frameIndex = 0;
        frameTime = animTime/frames.length;
        lastFrame = System.currentTimeMillis();
    }

    private boolean isPlaying()
    {
        return isPlaying;
    }

    public void update()
    {
        if(!isPlaying)
            return;

        if(System.currentTimeMillis() - lastFrame > frameTime * 1000)
        {
            frameIndex++;
            frameIndex = frameIndex >= frames.length ? 0 : frameIndex;
            lastFrame = System.currentTimeMillis();
        }
    }

    public void play()
    {
        isPlaying = true;
        frameIndex = 0;
        lastFrame = System.currentTimeMillis();
    }

    public void stop()
    {
        isPlaying = false;
        frameIndex = 0;
    }

    public void draw(Canvas canvas, Rect destination)
    {
        canvas.drawBitmap(frames[frameIndex], null, destination, new Paint());
    }



}
