package edu.feicui.app.phone.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.biz.SqliteRead;

public class AllContactsActivity extends AppCompatActivity {
    GridView mGdvAllContacts;
    Context mCtx;
    SqliteRead mSReader;
    List<String> mStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_contacts);
        mGdvAllContacts=(GridView) findViewById(R.id.gv_all_contacts);
        mSReader=new SqliteRead();

        mCtx=this;
        mStrings=mSReader.readClassList(mCtx);
        int[] to=new int[]{R.id.txt_cell};
        String [] from={"textview"};
        List<Map<String,String>>listItems=getAllData();
        SimpleAdapter adapter=new SimpleAdapter(mCtx,listItems,R.layout.item_grid_all_contacts_cell,from,to);
        mGdvAllContacts.setAdapter(adapter);
        mGdvAllContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mStrings=mSReader.readClassId(mCtx);
                Intent intent=new Intent(AllContactsActivity.this,AllContactsShowActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("idx",mStrings.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
    public List<Map<String,String>>getAllData(){
        List<Map<String,String>>listItems=new ArrayList<Map<String,String>>();
        for(int i=0;i<mStrings.size();i++){
            Map<String,String> listItem=new HashMap<String,String>();
            listItem.put("textview",mStrings.get(i));
            listItems.add(listItem);
        }
        return listItems;
    }
}
