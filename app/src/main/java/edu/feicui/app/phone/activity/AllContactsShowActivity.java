package edu.feicui.app.phone.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.biz.SqliteRead;
import edu.feicui.app.phone.entity.PhoneNumber;

public class AllContactsShowActivity extends AppCompatActivity {
    ListView mLtvAllContactsShow;
    Context mCtx;
    List<PhoneNumber> mPhoneNumbers;
    SqliteRead mSRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_contacts_show);
        mCtx=this;
        mLtvAllContactsShow=(ListView) findViewById(R.id.lv_allcontacts_show);
        mSRead=new SqliteRead();
        Intent intent=getIntent();
        String str=intent.getExtras().getString("idx");
        mPhoneNumbers=mSRead.readTables(mCtx,str);
        mLtvAllContactsShow.setAdapter(new CustomAdapter());
        mLtvAllContactsShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_CALL);
                PhoneNumber pn1=mPhoneNumbers.get(position);
                intent.setData(Uri.parse("tel:"+pn1.getNumber()));
                startActivity(intent);
            }
        });
    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mPhoneNumbers.size();
        }

        @Override
        public Object getItem(int position) {
            return mPhoneNumbers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=convertView;
            if(v==null){
                LayoutInflater layoutInflater=(LayoutInflater)mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v=layoutInflater.inflate(R.layout.item_listview_cell,null);

            }
            TextView name=(TextView) v.findViewById(R.id.txt_listview_cell1);
            TextView number=(TextView) v.findViewById(R.id.txt_listview_cell2);
            PhoneNumber pn=mPhoneNumbers.get(position);
            name.setText(pn.getName());
            number.setText(pn.getNumber());
            return v;
        }
    }
}
