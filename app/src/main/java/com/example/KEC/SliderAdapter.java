package com.example.KEC;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter
{
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context)
    {
        this.context = context;
    }

    //Array
    public int[] slide_images = {
            R.drawable.logo,
            R.drawable.swami,
            R.drawable.br
    };

    public String[] slide_heading = {
            "KATIHAR ENGINEERING COLLEGE",
            "SWAMI VIVEKANANDA",
            "B. R. AMBEDKAR"
    };

    public String [] slide_desc = {
            "Katihar Engineering College (KEC), Katihar with the advent of technology and the emergence of notable education in our society, had decided to adapt the prevailing need of light.",
            "Arise,awake and donot stop until the goal is reached.",
            "Life should be great rather than long.\n" +
                    "I measure the progress of a community by the degree of progress which women have achieved.\n" +
                    "I like the religion that teaches liberty, equality and fraternity."
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_Image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescView = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescView.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);

    }
}

