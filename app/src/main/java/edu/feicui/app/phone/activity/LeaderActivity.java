package edu.feicui.app.phone.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import edu.feicui.app.phone.R;

public class LeaderActivity extends AppCompatActivity {
    ImageView mImgScale,mImgAlpha,mImgRotate,mImgTranslate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);
        System.out.println();
        mImgScale=(ImageView) findViewById(R.id.iv_scale);
        mImgAlpha=(ImageView) findViewById(R.id.iv_alpha);
        mImgRotate=(ImageView) findViewById(R.id.iv_rotate);
        mImgTranslate=(ImageView) findViewById(R.id.iv_translate);
        Animation animScale= AnimationUtils.loadAnimation(LeaderActivity.this,R.anim.scale);
        mImgScale.startAnimation(animScale);

//        Animation animAlpha= AnimationUtils.loadAnimation(LeaderActivity.this,R.anim.alpha);
//        mImgAlpha.startAnimation(animAlpha);
//        Animation animRotate= AnimationUtils.loadAnimation(LeaderActivity.this,R.anim.totate);
//        mImgRotate.startAnimation(animRotate);
//        Animation animTranslate= AnimationUtils.loadAnimation(LeaderActivity.this,R.anim.translate);
//        mImgTranslate.startAnimation(animTranslate);

//        ScaleAnimation scaleAnimation=new ScaleAnimation(0f,5.4f,0f,5.4f,0.5f,0.5f);
//        scaleAnimation.setDuration(5000);
//        scaleAnimation.setRepeatCount(Animation.INFINITE);
//        mImgScale.startAnimation(scaleAnimation);
//        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
//        alphaAnimation.setDuration(5000);
//        alphaAnimation.setRepeatCount(Animation.INFINITE);
//        mImgAlpha.startAnimation(alphaAnimation);
//        RotateAnimation rotateAnimation=new RotateAnimation(0,-360,1,1);
//        rotateAnimation.setDuration(5000);
//        rotateAnimation.setRepeatCount(Animation.INFINITE);
//        mImgRotate.startAnimation(rotateAnimation);
//        TranslateAnimation translateAnimation=new TranslateAnimation(0,100,0,100);
//        translateAnimation.setDuration(5000);
//        translateAnimation.setRepeatCount(Animation.INFINITE);
//        mImgTranslate.startAnimation(translateAnimation);

    }
}
