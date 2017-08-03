package com.games.myapps.escapper;

import android.graphics.Canvas;
import android.provider.Settings;
import android.view.SurfaceHolder;

/**
 * Created by Arif on 8/2/2017.
 */

public class MainThread extends Thread {
    public static final int MAX_FPS = 30;
    private double avarageFPS;
    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;
    public static Canvas canvas;

    public void setRunning(boolean running)
    {
        this.running = running;
    }
    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {
        long startTime;
        long timeMillis = 1000/MAX_FPS;
        long waitTime;
        int frameCount = 0;
        long totalTime = 0;
        long targetTime = 1000/MAX_FPS;
        while(running)
        {
            startTime = System.nanoTime();
            canvas = null;
            try
            {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder)
                {
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }

            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            finally {
                if(canvas != null)
                {
                    try
                    {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
            timeMillis = (System.nanoTime() - startTime/1000000);
            waitTime = targetTime - timeMillis;
            try
            {
                if(waitTime > 0)
                {
                    this.sleep(waitTime);
                }

            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if(frameCount == MAX_FPS)
            {
                avarageFPS = 100/((totalTime/frameCount)/1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(avarageFPS);
            }
        }
    }
}
