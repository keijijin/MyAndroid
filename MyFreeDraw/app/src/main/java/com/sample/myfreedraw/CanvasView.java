package com.sample.myfreedraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class CanvasView extends View {
    private Path path;
    private Paint p;

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        p = new Paint();
        p.setColor(Color.BLUE);
        p.setStrokeWidth(3);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeJoin(Paint.Join.ROUND);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //if(event.getPointerCount() > 1) {
            for (int i = 0; i < event.getPointerCount(); i++) {
                Log.d("MultiTouch",
                        String.format("ID %s > [%s, %s]", event.getPointerId(i),
                                event.getX(i),
                                event.getY(i))
                );
                //}
                //}
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
        invalidate();
        return true;
    }

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }
}
