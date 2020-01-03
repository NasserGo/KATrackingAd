package addemo.android.appicplay.com.appicdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.ap.android.trunk.sdk.ad.listener.APIncentivizedADListener;
import com.ap.android.trunk.sdk.ad.video.APIncentivized;


public class IncentivizedActivity extends Activity {


    private static final String TAG = "IncentivizedActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        APIncentivized.setActivity(this);
        APIncentivized.setListener(new APIncentivizedADListener() {
            @Override
            public void loadFailed(String s) {
                Log.i(TAG, "loadFailed: " + s);
            }

            @Override
            public void loadSuccess() {
                Log.i(TAG, "loadSuccess: ");
            }

            @Override
            public void showComplete() {
                Log.i(TAG, "showComplete: ");
            }

            @Override
            public void clicked() {
                Log.i(TAG, "clicked: ");
            }

            @Override
            public void showFailed(String s) {
                Log.i(TAG, "showFailed: ");
            }

            @Override
            public void showSkip() {

            }
        });


        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });

    }

    private void load() {

    }

    private void show() {
        if (APIncentivized.isReady()) {
            APIncentivized.showVideoAD(this);
        } else {
            Log.i(TAG, "show: video is not ready, show failed.");
        }
    }
}
