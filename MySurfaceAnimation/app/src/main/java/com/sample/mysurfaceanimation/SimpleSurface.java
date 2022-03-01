package com.sample.mysurfaceanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SimpleSurface extends SurfaceView {
    Paint p;
    ExecutorService service;

    public SimpleSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint();
        p.setColor(Color.BLUE);

        service = Executors.newSingleThreadExecutor();
        getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                draw(surfaceHolder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                SimpleSurface.this.service.shutdown();
            }
        });
    }

    private void draw(SurfaceHolder holder) {
        service.execute(() -> {
            for(int i = 0; i < 1000; i++) {
                Canvas canvas = holder.lockCanvas();
                canvas.drawColor(Color.WHITE);
                canvas.drawCircle(100+i, 100+i, 50, p);
                holder.unlockCanvasAndPost(canvas);
                try {
                    Thread.sleep(1);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
