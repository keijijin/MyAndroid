package com.sample.myfreedraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class SimpleSurface extends SurfaceView {
    private Path path;
    private Paint p;

    public SimpleSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint();
        p.setColor(Color.BLUE);
        p.setStrokeWidth(3);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeJoin(Paint.Join.ROUND);
        path = new Path();

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

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        for (int i = 0; i < event.getPointerCount(); i++) {
            Log.d("MultiTouch",
                    String.format("ID %s > [%s, %s]", event.getPointerId(i),
                            event.getX(i),
                            event.getY(i))
            );
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(event.getX(i), event.getY(i));
                    break;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(event.getX(i), event.getY(i));
                    break;
                case MotionEvent.ACTION_UP:
                    performClick();
                    path.lineTo(event.getX(i), event.getY(i));
                    break;
            }
        }
        draw(this.getHolder());
//        invalidate();
        return true;
    }

    private void draw(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();
        canvas.drawColor(Color.WHITE);
        //canvas.drawRect(100,100,400,400,p);
        canvas.drawPath(path,p);
        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }
}
