package addemo.android.appicplay.com.appicdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.ap.android.trunk.sdk.ad.APBaseAD;
import com.ap.android.trunk.sdk.ad.listener.APNativeADListener;
import com.ap.android.trunk.sdk.ad.nativ.APNative;
import com.ap.android.trunk.sdk.core.utils.LogUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NativActivity extends Activity {

    private static final String TAG = "NativActivity";

    private APNative ad;

    private Button loadBtn;
    private Button showBtn;

    public static String formatTime(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = "<" + simpleDateFormat.format(new Date(time)) + ">";
        return timeStr;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nativ);

        loadBtn = findViewById(R.id.load);
        showBtn = findViewById(R.id.show);

        findViewById(R.id.load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load();
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
        LogUtils.v(TAG, "开始进行原生广告load...");

        loadBtn.setEnabled(false);
        showBtn.setEnabled(false);

        if (this.ad != null) {
            this.ad.destroy();
            ViewGroup adContainer = this.findViewById(R.id.viewContainer);
            adContainer.removeAllViews();
        }

        //
        APNative x = new APNative(this, Config.NATIVE_SLOT_ID, new APNativeADListener() {
            @Override
            public void success(APBaseAD ad, String slotID) {
                NativActivity.this.ad = (APNative) ad;
                Toast.makeText(NativActivity.this, "load成功", Toast.LENGTH_SHORT).show();
                showBtn.setEnabled(true);
            }

            @Override
            public void fail(APBaseAD ad, String slotID, String errorMsg) {
                LogUtils.v(TAG, "失败：" + slotID + ",error:" + errorMsg);
                Toast.makeText(NativActivity.this, "load失败" + errorMsg, Toast.LENGTH_SHORT).show();
                loadBtn.setEnabled(true);
            }

            @Override
            public void close(APBaseAD ad, String slotID) {
                LogUtils.v(TAG, "被关闭：" + slotID);
            }

            @Override
            public void click(APBaseAD ad, String slotID) {
                LogUtils.v(TAG, "被点击：" + slotID);
            }

            @Override
            public void gotoDeeplink(APBaseAD apBaseAD) {

            }

            @Override
            public void gotoDownload(APBaseAD apBaseAD) {

            }

            @Override
            public void videoShowFailed(APBaseAD apBaseAD, String s) {
                Log.i(TAG, "videoShowFailed: " + s);

            }

            @Override
            public void videoShowCompleted(APBaseAD apBaseAD) {
                Log.i(TAG, "videoShowCompleted: ");

            }

            @Override
            public void videoShowCountDown(APBaseAD apBaseAD, int i) {
                Log.i(TAG, "videoShowCountDown: " + i);

            }
        });
        x.setPreferImageSize(640, 960);
        x.loadNative();
    }

    private void show() {
        showBtn.setEnabled(false);
        loadBtn.setEnabled(true);

        if (ad == null) return;

        String iconUrl = ad.getIconUrl();
        String imgUrl = ad.getImageUrl();
        String title = ad.getTitle();
        String desc = ad.getDesc();

        String action = ad.getActionText();
        boolean isVideoAD = ad.isVideoTypeAD();

        LogUtils.v(TAG, "icon:" + iconUrl + ",imageUrl:" + imgUrl + ",title:" + title + ",desc:" + desc + ",action:" + action + ",isVideoAD:" + isVideoAD);

        ViewGroup viewContainer = findViewById(R.id.viewContainer);
        viewContainer.removeAllViews();
        viewContainer.addView(ad.getExposureView(viewContainer, APNative.MATCH_PARENT));

        ad.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (this.ad != null) {
            this.ad.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (this.ad != null) {
            this.ad.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.ad != null) {
            this.ad.onDestroy();
        }
    }
}
