package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hackathon.fragment.pageframent1;
import com.example.hackathon.fragment.pageframent2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int images[] = {R.drawable.cat, R.drawable.music, R.drawable.bulid, R.drawable.dark};
    //定义一个View的数组
    private List<View> views = new ArrayList<>();
    private ViewPager2 pager;
    private RecyclerView.Adapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager2) findViewById(R.id.pager);


        //将images数组中的图片放入ImageView
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            views.add(imageView);
        }

        //为ViewPager设置适配器
        pager.setAdapter(pagerAdapter);

        class pagerAdapter extends PagerAdapter {

            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View v = views.get(position);
                container.addView(v);

                return v;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                View v = views.get(position);
                //前一张图片划过后删除该View
                container.removeView(v);
            }
        }

    /*private ViewPager2 pager;
    private PagerAdapter pagerAdapter;
    @Override
    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            /*List<Fragment> list=new ArrayList<>();
            list.add(new pageframent1());
            list.add(new pageframent2());

            pager = findViewById(R.id.pager);
            pagerAdapter=new sliderpage(getSupportFragmentManager(),list);

            //pager.setAdapter(pagerAdapter);*/

            setContentView(R.layout.activity_main);

            Button button4 = (Button) findViewById(R.id.button4);
            Button button5 = (Button) findViewById(R.id.button5);
            Button button6 = (Button) findViewById(R.id.button6);
            Button button7 = (Button) findViewById(R.id.button7);

        button4.setOnClickListener(new View.OnClickListener()

            {

                @Override
                public void onClick (View v){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main1.class);
                startActivity(intent);
            }
            });
        button5.setOnClickListener(new View.OnClickListener()

            {

                @Override
                public void onClick (View v){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main2.class);
                startActivity(intent);
            }
            });
        button6.setOnClickListener(new View.OnClickListener()

            {

                @Override
                public void onClick (View v){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main3.class);
                startActivity(intent);
            }
            });
        button7.setOnClickListener(new View.OnClickListener()

            {

                @Override
                public void onClick (View v){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main4.class);
                startActivity(intent);
            }
            });

        /*@Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }*/
        }
    }
