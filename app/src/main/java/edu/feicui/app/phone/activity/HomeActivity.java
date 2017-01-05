package edu.feicui.app.phone.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import edu.feicui.app.phone.R;

public class HomeActivity extends AppCompatActivity {
    ImageView mIgvAllContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mIgvAllContacts=(ImageView) findViewById(R.id.iv_allcontacts);
        mIgvAllContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,AllContactsActivity.class);
                startActivity(intent);
            }
        });
    }
}
