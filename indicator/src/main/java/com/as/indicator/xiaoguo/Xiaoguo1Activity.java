package com.as.indicator.xiaoguo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.as.indicator.R;
import com.as.indicator.adapter.Adapter_image;
import com.as.indicator.other_library.View1.leochuan.CarouselLayoutManager;
import com.as.indicator.other_library.View1.leochuan.CircleLayoutManager;
import com.as.indicator.other_library.View1.leochuan.CircleScaleLayoutManager;
import com.as.indicator.other_library.View1.leochuan.GalleryLayoutManager;
import com.as.indicator.other_library.View1.leochuan.RotateLayoutManager;
import com.as.indicator.other_library.View1.leochuan.ScaleLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class Xiaoguo1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaoguo1);
        // https://github.com/leochuan/ViewPagerLayoutManager

        List<Integer> list = new ArrayList<Integer>() {{
            add(R.drawable.item1);
            add(R.drawable.item2);
            add(R.drawable.item3);
            add(R.drawable.item4);
            add(R.drawable.item5);
            add(R.drawable.item6);
            add(R.drawable.item7);
            add(R.drawable.item8);
            add(R.drawable.item9);
            add(R.drawable.item10);
        }};

        RecyclerView rv_circle = findViewById(R.id.rv_circle);
        RecyclerView rv_circleScale = findViewById(R.id.rv_circleScale);
        RecyclerView rv_Carousel = findViewById(R.id.rv_Carousel);
        RecyclerView rv_Gallery0 = findViewById(R.id.rv_Gallery0);
        RecyclerView rv_Gallery1 = findViewById(R.id.rv_Gallery1);
        RecyclerView rv_Rotate = findViewById(R.id.rv_Rotate);
        RecyclerView rv_Scale = findViewById(R.id.rv_Scale);

        Adapter_image adapter=new Adapter_image(R.layout.item_image, list);
        rv_circle.setAdapter(adapter);
        rv_circleScale.setAdapter(adapter);
        rv_Carousel.setAdapter(adapter);
        rv_Gallery0.setAdapter(adapter);
        rv_Gallery1.setAdapter(adapter);
        rv_Rotate.setAdapter(adapter);
        rv_Scale.setAdapter(adapter);

        /**************rv_circle****************/
        CircleLayoutManager circleLayoutManager = new CircleLayoutManager(this);
        rv_circle.setLayoutManager(circleLayoutManager);

        /**************rv_circleScale****************/
        CircleScaleLayoutManager circleScaleLayoutManager=new CircleScaleLayoutManager(this);
        rv_circleScale.setLayoutManager(circleScaleLayoutManager);

        /**************rv_Carousel****************/
        CarouselLayoutManager carouselLayoutManager=new CarouselLayoutManager(this,40);
        rv_Carousel.setLayoutManager(carouselLayoutManager);

        /**************rv_Gallery0****************/
        GalleryLayoutManager galleryLayoutManager = new GalleryLayoutManager(this, 40);
        rv_Gallery0.setLayoutManager(galleryLayoutManager);

        /**************rv_Gallery1****************/
        GalleryLayoutManager galleryLayoutManager1 = new GalleryLayoutManager(this, 40,GalleryLayoutManager.VERTICAL);
        rv_Gallery1.setLayoutManager(galleryLayoutManager1);

        /**************rv_Rotate****************/
        RotateLayoutManager rotateLayoutManager = new RotateLayoutManager(this, 40);
        rv_Rotate.setLayoutManager(rotateLayoutManager);

        /**************rv_Scale****************/
        ScaleLayoutManager scaleLayoutManager = new ScaleLayoutManager(this, 40);
        rv_Scale.setLayoutManager(scaleLayoutManager);
    }
}
