package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static com.pluralsight.candycoded.DetailActivity.HASHTAG_CANDYCODED;
import static com.pluralsight.candycoded.DetailActivity.SHARE_DESCRIPTION;

public class InfoActivity extends AppCompatActivity {

    private final Uri mCandyImageUrl = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(mCandyImageUrl).
                into(candyStoreImageView);


    }

    public void createMapIntent(View view){
        Uri uri = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");

        Intent mapIntent = new Intent(Intent.ACTION_VIEW,uri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void createPhoneIntent(View view){
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse("tel:0123456789"));
        startActivity(phoneIntent);
    }
}
