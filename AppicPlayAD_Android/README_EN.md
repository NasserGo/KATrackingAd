> [Chinese Doc](https://github.com/KATracking/KATrackingAd/blob/master/AppicPlayAD_Android/README.md)
# Current Ver.3.7.2.9 [ReleaseNote](https://github.com/KATracking/KATrackingAd/blob/master/AppicPlayAD_Android/ReleaseNote.md)
# AppicAd SDK Integration guide

* [Download](#Download)
* [Preparation](#Preparation)
* [Third party SDKs](#thirdPartySDK)
* [Native Ad](#nativeAD)
* [Splash Ad](#splashAD)
* [Interstitial Ad](#interstitialAD)
* [Banner Ad](#bannerAD)
* [Rewarded Video](#videoAD)
* [Permissions](#permissions)
* [More](#others)


## <a name="Download">Download</a>

* Download [AppicAd SDK](http://sayhey.oss-cn-shanghai.aliyuncs.com/sdk/android/APSDK_v3.7.2.9.aar)
* Download [com.liulishuo.filedownload-v1.7.4.aar](https://github.com/KATracking/KATrackingAd/tree/master/AppicPlayAD_Android/com.liulishuo.filedownload-v1.7.4.aar)

## <a name="Preparation">Preparation</a>

* Unzip downloaded file, import aar bundle to your project
* Add the following dependencies to your project `build.gradle`:

	```
	implementation 'com.android.volley:volley:1.1.0'
	implementation 'com.android.support:support-v4:26.1.0'
	implementation(name: 'com.liulishuo.filedownload-v1.7.4', ext: 'aar')
	implementation(name: 'android-gif-drawable-1.2.6', ext: 'aar')
	```
	If your App has already integrated android-gif-drawable-1.2.6, you can ignore this, or please download at: [android-gif-drawable-1.2.6.aar](https://github.com/KATracking/KATrackingAd/tree/master/AppicPlayAD_Android/android-gif-drawable-1.2.6.aar), and download `com.liulishuo.filedownload-v1.7.4.aar`from [here](https://github.com/KATracking/KATrackingAd/blob/master/AppicPlayAD_Android/com.liulishuo.filedownload-v1.7.4.aar)
		
* To initialize SDK, please add the follow line to onCreate delegate of your main activity or Application.

	```
	APSDK.init(this, "appID");
	```
	**Note**: `appID` is provided by our operator.
	
* Override the `getBaseContext` method of your app's `application`:

	```
	@Override
    public Context getBaseContext() {
        return APApplication.getBaseContext(super.getBaseContext());
    }
	```

* `proguard` configuration：

	```
	-keep class * extends com.ap.android.atom.sdk.core.base.ad.Ad
	-keep class * extends com.ap.android.atom.sdk.core.base.ad.AdSDK
	-keep class * implements com.ap.android.atom.sdk.core.base.lifecycle.IApplicationLifecycle
	```

## <a name="thirdPartySDK">Third party SDKs</a>
* See here for supported third party network [SDKs](https://github.com/KATracking/KATrackingAd/tree/master/AppicPlayAD_Android/ThirdParyADLibs)
	* `inmobi` - InMobi SDK v7.1.1
	* `gdt` - Tencent SDK v4.40.910
	* `tt` - Bytedance SDK v1.9.8.8
	* `unity` - Unity SDK v3.1.0
	* `vungle` - Vungle SDK v6.3.24
	* `admob` - AdMob SDK v8.4.0
	* `facebook` - Facebook Audience Networks SDK v5.3.1
* Each network SDK has build.gradle dependencies and permissions configuration, please find these information within each folder respectively.

	**Note**: If you do not want to mediate the SDKs above, simply ignore this secion.

## <a name="nativeAD">Native Ad</a>

There are two available modes to choose from for Native Ad integration: `Template` and `RAW`, select a suitable mode accordingly, Template provides a pre-set view containing main ad asset and attached touch event detection, where RAW offers assets in their original states for you to process and requires to call `registerViewForInteraction` method to inform SDK to add touch event detection.

Native Ad is set to be using Template mode by default, or call `apNativeInstance.setPattern(patternEnum)` method to change.

1. **Instantiation**
	
	To create an instance of Native Ad
	
	```
	APNative apNative = new APNative(activity, "slotID", listener);
	```
	
	Parameters	|	Description
	---	|	---
	activity	|	Activity that native ad is being created from
	slotID	|	Slot ID, provided by operator
	listener	|	Listener to received call backs
	
2. **Main asset size**
	
	Set prefered asset size
	
	```
	apNative.setPreferImageSize(width,height)
	```
	**Note**：Asset may not always be adjusted to preferred size
	
3. **Load ad**

	Load ad by calling this method
	
	```
	apNative.loadNative();
	```
	
4. **Access ad asset**

	Once ad is loaded succesfully by receiving load success call back, you can start using ad 	assets with the following getter methods.
	
	Assets	|	Getter
	---	|	---
	Image url of icon	|	`getIconUrl`
	Image url of main screenshot	|	`getImageUrl`
	Description	|	`getDesc`
	Title	|	`getTitle`
	Interation title |	`getActionText`
	Ad View	|	`getExposureView`
	
	**Note**: Title, Description and Icon are all nullable, please ensure verification 	before using them
	
		
1. **Check Ad Type（is video typ or not）**

	```
	apNative.isVideoTypeAD();
	```

	
5. **Ad View**

	Create the ad view
	
	```
	View v = apNative.getExposureView(viewContainer,viewWidth)
	```
	
	Parameters	|	Description
	---	|	---
	viewContainer	|	The view which will contain this Native ad
	viewWidth	| Use APNative.MATCH_PARENT or specific width in px to adjust ad view size
	
	**Note**: This method does NOT add ad view to contain view automatically
	
	**Note**: Please make sure that this view is added to container view before ad is about to 	show
	
6. **Report impression**

	Once ad is displayed to users, please call this method to report ad impression.
	```
	apNative.show();
	```
	
7. **Delegate methods of Native Ad**

	Please add the following calls to Activity callbacks respectively
	* `onPause`：`apNative.onPause();`
	* `onResume`：`apNative.onResume();`
	* `onDestroy`：`apNative.onDestroy();`
	
8. **Destroy Native**

	Once a Native ad is no longer needed, use this method to recycle its assets immediately.

	```
	apNative.destroy();
	```

## <a name="splashAD">Splash Ad</a>

1. **Instantiation**：

	To create an instance of Splash Ad
	```
	APSplash splash = new APSplash(activity,slotID,listener);
	```

	Parameters	|	Description
	---	|	---
	activity	|	Activity that native ad is being created from
	slotID	|	Slot ID, provided by operator
	listener	|	Listener to received call backs
	
2. **Load and Show**
	
	Splash allows you to call this method to load and display and ad.
	
	```
	splash.loadAndPresent(splashViewContainer,bottomViewLayoutID);
	```
	
	Parameters	|	Description
	---	|	---
	splashViewContainer	|	ViewGroup for which add ad will be displayed within, e.g. LinearLayout, please make sure that orientation of this view group is set to be vertical
	bottomViewLayoutID	|	Specify layout id to populate the bottom of screen, if asset is not big enough to fill the entire screen, please make sure your view is adjustable for height as asset height may vary. Use -1 if you do not wish to fill any empty space.

3. **Destroy Splash**
	
	Once a Splash ad is no longer needed, use this method to recycle its assets immediately.

	```
	splash.onDestroy()
	```

4. **AndroidManifest.xml config**

	Please add these following properties to Splash activty in menifest to ensure that Splash ad 	will not rotate while displayed.
	
	```
	android:configChanges="keyboard|keyboardHidden|orientation|screenSize"
	```
	
	
## <a name="interstitialAD">Interstitial Ad</a>

1. **Instantiation**

	`APInterstitial apInterstitial = new APInterstitial(activity, "slotID", interstitialListener`

2. **Main asset size**

	`apInterstitial.setPreferImageSize(width, height);`

3. **Load ad**

	`apInterstitial.loadInterstitial();`
	
4. **Show ad**

	`apInterstitial.show();`
	
5. **Destroy interstitial**

	Once a Interstitial ad is no longer needed, use this method to recycle its assets immediately.
	
	`apInterstitial.onDestroy();`

## <a name="bannerAD">Banner Ad</a>

1. **Instantiation**

	`APBanner banner = new APBanner(activity, "slotID", listener);`
	
2. **Load**

	`banner.loadBanner(bannerContainer);`
	
	**Note**: Currently the size of bannerContainer is required to be 300x50 dp
	
3. **Hide banner**

	`banner.hide();`
	
4. **Show banner**

	`banner.show()`
	
	**Note**: Banner ad will appear in bannerContainer automatically once load success, there is no need to call show method directly. Only use it to make it appear again after being hidden.
	
5. **Destroy banner**

	Once a Banner ad is no longer needed, use this method to recycle its assets immediately.
	
	`banner.onDestroy();`。
	

## <a name="videoAD">Rewarded Video</a>

Apart from other ad types, rewarded video uses singleton to automatically load ads after SDK successfully initialized.

1. **Set listener**

	`APIncentivized.setListener(apIncentivizedADListener);`
	
2. **Set activity**

	Use this method to set activity which is to display video ad
	
	`APIncentivized.setActivity(currentActivity);`
	
3. **Ad availability**

	Use this method to check if a ad is ready to display
	
	`APIncentivized.isReady();`
	
4. **Show ad**

	`APIncentivized.showVideoAD(currentActivity);`
		
## <a name="permissions">Permissions</a>

* SDK will request for these following permissions
	* `android.permission.READ_PHONE_STATE`
	* `android.permission.WRITE_EXTERNAL_STORAGE`
* SDK initialization (`APSDK.init(context,appID,channelID)`) triggers requesting for permissions as part of init process, call this `APCore.setAutoRequestPermission(false)` to stop SDK doing so automatically, please make sure that your code will request for the same permissions at later stage, otherwise SDK may not function properly


## <a name="others">etc</a>

* If you wishes to inform users before download starts under cellular network, use this method to enable this feature `APAD.setIsMobileNetworkDirectlyDownload(boolean)`, default is set to `true`
* supported cpu architecture: `armeabi-v7a`
