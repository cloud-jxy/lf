package com.jocker.jlife.adapters;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jocker.jlife.db.CastBean;

import java.io.File;
import java.util.List;

import androidx.databinding.BindingAdapter;

/**
 *  只能在 Java 文件时 BindingAdapter 才能生效 ，Kotlin 中无效，
 *  2018/7/26 找到原因：
 *  需要添加  implementation 'androidx.core:core-ktx:1.0.0-alpha1'
 *
 *
 *
 */
public class MyBindingAdapter {
    @BindingAdapter("loadImageFromUrl")
    public static void loadImage(ImageView view, String url) {
        if (!url.isEmpty()) {
            Glide.with(view.getContext()).load(url).into(view);
        }
    }

    @BindingAdapter("setGenres")
    public static void setGenres(TextView view, List<String> genres) {
        if (!genres.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < genres.size(); i++) {
                String s = genres.get(i);
                if (i==0){
                    sb.append(s);
                }else {
                    sb.append(File.separator).append(s);
                }
            }

            view.setText(sb.toString());
        }
    }

    @BindingAdapter("castName")
    public static void setCastsNames(TextView view, List<CastBean> casts) {
        if (!casts.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < casts.size(); i++) {
                CastBean cast = casts.get(i);
                if (i == 0) {
                    sb.append(cast.getName());
                } else {
                    sb.append(File.separatorChar).append(cast.getName());
                }
            }

            view.setText(sb.toString());
        } else {
            view.setText("未获取到数据！");
        }
    }

    @BindingAdapter("average")
    public static void setAverage(TextView view, Float average) {
        if (average > 0) {
            view.setText(String.valueOf(average));
        }
    }
}
