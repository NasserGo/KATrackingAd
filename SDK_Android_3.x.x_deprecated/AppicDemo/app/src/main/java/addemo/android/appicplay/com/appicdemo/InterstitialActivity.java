package addemo.android.appicplay.com.appicdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ap.android.trunk.sdk.ad.APBaseAD;
import com.ap.android.trunk.sdk.ad.interstitial.APInterstitial;
import com.ap.android.trunk.sdk.ad.listener.APInterstitialADListener;

public class InterstitialActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "InterstitialActivity";

    Button loadBtn;
    Button showBtn;

    private APInterstitial apInterstitial;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interstitial);


        loadBtn = findViewById(R.id.load);
        showBtn = findViewById(R.id.show);

        loadBtn.setEnabled(true);
        showBtn.setEnabled(false);

        findViewById(R.id.load).setOnClickListener(this);
        findViewById(R.id.show).setOnClickListener(this);
    }


    private void load() {

        loadBtn.setEnabled(false);
        showBtn.setEnabled(false);

        if (apInterstitial != null) {
            apInterstitial.onDestroy();
        }

        apInterstitial = new APInterstitial(this, Config.INTERSTITIAL_SLOT_ID, new APInterstitialADListener() {
            @Override
            public void success(APBaseAD apBaseAD, String s) {
                Log.i(TAG, "success: ");
                showBtn.setEnabled(true);
            }

            @Override
            public void fail(APBaseAD apBaseAD, String s, String s1) {
                Log.i(TAG, "fail: " + s1);
                loadBtn.setEnabled(true);
            }

            @Override
            public void close(APBaseAD apBaseAD, String s) {
                Log.i(TAG, "close: ");
                loadBtn.setEnabled(true);
                showBtn.setEnabled(false);
            }

            @Override
            public void click(APBaseAD apBaseAD, String s) {
                Log.i(TAG, "click: ");
            }

            @Override
            public void showFailed(APBaseAD apBaseAD, String s, String s1) {

            }

            @Override
            public void show(APBaseAD apBaseAD, String s) {

            }
        });

        apInterstitial.setPreferImageSize(1080, 1920);
        apInterstitial.loadInterstitial();
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.load:
                loadBtn.setEnabled(false);
                showBtn.setEnabled(false);

                load();
                break;
            case R.id.show:

                showBtn.setEnabled(false);
                if (apInterstitial != null) {
                    apInterstitial.show();
                    loadBtn.setEnabled(true);
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (apInterstitial != null) {
            apInterstitial.onDestroy();
        }
    }
}
