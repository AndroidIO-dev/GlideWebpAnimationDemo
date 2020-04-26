package com.androidio.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.Rotate;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class MainActivity extends AppCompatActivity {

    private static final String WEBP_URL = "https://mathiasbynens.be/demo/animated-webp-supported.webp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView _webpImageView = findViewById(R.id.webp_iv);
        Glide.with(this)
                .load(WEBP_URL)
                .optionalTransform(WebpDrawable.class, new WebpDrawableTransformation(new RoundedCorners(20)))
                .into(_webpImageView);

        ImageView _webpMultiTransImageView = findViewById(R.id.webp_multi_trans_iv);
        Glide.with(this)
                .load(WEBP_URL)
                .optionalTransform(WebpDrawable.class, new WebpDrawableTransformation(new MultiTransformation<Bitmap>(new CircleCrop(), new Rotate(90))))
                .into(_webpMultiTransImageView);

    }


}
