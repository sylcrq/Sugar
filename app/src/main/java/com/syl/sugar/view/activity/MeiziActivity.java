package com.syl.sugar.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.syl.sugar.NavigationTool;
import com.syl.sugar.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MeiziActivity extends SwipeBackAppCompatActivity {

    @Bind(R.id.meizi)
    ImageView mMeizi;

    private String mImageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meizi);

        ButterKnife.bind(this);

        mImageUrl = getIntent().getStringExtra(NavigationTool.START_MEIZI_KEY_IMAGE_URL);

        showMeizi();
    }

    private void showMeizi() {
        if(!TextUtils.isEmpty(mImageUrl)) {
            Picasso.with(this).load(mImageUrl)
                    .placeholder(R.drawable.placeholder_image)
                    .into(mMeizi);
        }
    }
}
