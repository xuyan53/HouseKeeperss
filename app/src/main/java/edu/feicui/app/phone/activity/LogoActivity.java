package edu.feicui.app.phone.activity;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.base.BaseActivity;
import edu.feicui.app.phone.biz.DbWriter;

import static java.lang.Thread.sleep;

public class LogoActivity extends BaseActivity {
    ImageView mImgLogo;
    AnimationDrawable mAmdLogo;
    DbWriter sr=new DbWriter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        sr.read(this);

        mImgLogo=(ImageView) findViewById(R.id.iv_logo);
        mImgLogo.setImageResource(R.drawable.logo);
        mAmdLogo=(AnimationDrawable) mImgLogo.getDrawable();
//        mAmdLogo.start();
//        Animation mRttAmt= AnimationUtils.loadAnimation(this,R.anim.totate);
//        mImgLogo.startAnimation(mRttAmt);
        RotateAnimation mRa=new RotateAnimation(0,-360,0.5f,0.5f);
        mRa.setDuration(4000);

//        mRa.start();
        mImgLogo.startAnimation(mRa);

        mRa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mAmdLogo.start();

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                startActivity(HomeActivity.class);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    sleep(6000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                startActivity(HomeActivity.class);
//            }
//        }
//
//        );
//        thread.start();







    }
}
