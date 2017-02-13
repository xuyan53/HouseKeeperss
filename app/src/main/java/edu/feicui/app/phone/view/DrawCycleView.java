package edu.feicui.app.phone.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by xy on 2017/1/9.
 */

public class DrawCycleView extends View {
    RectF sf=null;
    float f1=0;
    float f2=0;
    float f1a=0;
    float f2a=0;
    boolean flag=true;
    public DrawCycleView(Context context){
        super(context);

    }
    public DrawCycleView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }
    public void setff(float f1o,float f2o){
        this.f1=f1o;
        this.f2=f2o;
        flag=true;
    }
    public void setParamWithAnim(float f11,float f22){
        this.f1a=f11;
        this.f2a=f22;
        Thread thread=new Thread(){
            @Override
            public void run() {
                super.run();
                while(flag){
                    f1=f1+4;
                    postInvalidate();
                    if(f1>=f1a){
                        f1=f1a;
                        f2=f2-4;
                        if(f2<=f2a){
                            f2=f2a;
                        }
                    }
                    if(f1==f1a&&f2==f2a){
                        flag=false;
                    }
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        thread.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int viewWidth=MeasureSpec.getSize(widthMeasureSpec);
        int viewHeight=MeasureSpec.getSize(heightMeasureSpec);
        Log.i("onMeasure#######","viewWidth"+viewWidth);
        Log.i("onMeasure#######","viewHeight"+viewHeight);
        sf=new RectF(0,0,viewWidth,viewHeight);
        setMeasuredDimension(viewWidth,viewHeight);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("onDraw####","huahuahuaahuahuahauha");
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        canvas.drawArc(sf,-90,f1,true,paint);
        paint.setColor(Color.BLUE);
        canvas.drawArc(sf,-90,f2,true,paint);

    }
}
