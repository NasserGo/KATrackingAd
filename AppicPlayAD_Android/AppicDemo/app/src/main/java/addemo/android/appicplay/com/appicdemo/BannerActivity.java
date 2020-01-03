package addemo.android.appicplay.com.appicdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.ap.android.trunk.sdk.ad.APBaseAD;
import com.ap.android.trunk.sdk.ad.banner.APBanner;
import com.ap.android.trunk.sdk.ad.listener.APBannerADListener;


public class BannerActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "BannerActivity";

    private APBanner banner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banner);

        bannerLoad();

        findViewById(R.id.show).setOnClickListener(this);
        findViewById(R.id.hide).setOnClickListener(this);
    }

    private void bannerLoad() {
        banner = new APBanner(this, Config.BANNER_SLOT_ID, new APBannerADListener() {
            @Override
            public void success(APBaseAD apBaseAD, String s) {
                Log.i(TAG, "success: ");
            }

            @Override
            public void fail(APBaseAD apBaseAD, String s, String s1) {
                Log.i(TAG, "fail: " + s1);
            }

            @Override
            public void click(APBaseAD apBaseAD, String s) {
                Log.i(TAG, "click: ");
            }
        });
        banner.loadBanner((ViewGroup) findViewById(R.id.bannerContainer));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        banner.onDestroy();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.hide:
                banner.hide();
                break;
            case R.id.show:
                banner.show();
                break;
        }

    }
}
