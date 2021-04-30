package com.example.practice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    String[] tt={"shiva","shivam","sanchit","tushar"};
    String[] tt1={"sriva","solanki","aggarwak","v"};
    int [] img={R.drawable.logo,R.drawable.mail,R.drawable.mess,R.drawable.nexti};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView) findViewById(R.id.listview);
        myAdapter adapter=new myAdapter(this,tt,tt1,img);
        myListView.setAdapter(adapter);
    }

    class myAdapter extends ArrayAdapter<String>{
        Context context;
        String[] tt;
        String[] tt1;
        int [] img;


        public myAdapter( Context context, String[] tt,String[] tt1,int[] img) {
            super(context, R.layout.row,R.id.textView2,tt);
            this.context=context;
            this.img=img;
            this.tt=tt;
            this.tt1=tt1;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=inflater.inflate(R.layout.row,parent,false);
            ImageView imageView=row.findViewById(R.id.imageView);
            TextView textView=row.findViewById(R.id.textView);
            TextView textView1=row.findViewById(R.id.textView2);


            imageView.setImageResource(img[position]);
            textView.setText(tt[position]);
            textView1.setText(tt1[position]);
            return row;
        }
    }}