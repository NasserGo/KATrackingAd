> [中文文档](https://github.com/KATracking/KATrackingAd/blob/master/AppicPlayAD_Android/README_EN.md)
# Current Version 4.0

[ReleaseNote](https://github.com/KATracking/KATrackingAd/blob/master/AppicAd_SDK_Android/ReleaseNote.md)

# AppicAd SDK Integration guide

* [Overview](#Overview)
* [Preparation](#essential)
* [NativeExpress](#nativeAD)
* [Splash](#splashAD)
* [Permissions](#permissions)
* [More](#others)


## <a name="Overview">Overview</a>

* The SDK provides two different advertisement formats: **Splash**,**Native**
* Download [AppicAd SDK](http://sayhey.oss-cn-shanghai.aliyuncs.com/sdk/android/APSDK_v3.7.2.9.aar)
* Download [android-gif-drawable-1.2.6.aar](https://github.com/KATracking/KATrackingAd/tree/master/AppicPlayAD_Android/android-gif-drawable-1.2.6.aar)
* Download [Demo](https://github.com/KATracking/KATrackingAd/tree/master/AppicPlayAD_Android/android-gif-drawable-1.2.6.aar)

## <a name="essential">Preparation</a>
* Unzip downloaded file, import aar bundle to your project

* Add the following dependencies to your project `build.gradle`:

	```
	implementation 'com.android.volley:volley:1.1.0'
  implementation 'com.android.support:support-v4:26.1.0'
  implementation(name: 'android-gif-drawable-1.2.6', ext: 'aar')
	```


* To initialize SDK, please add the follow line to onCreate delegate of your main activity or Application.

	```
	APSDK.init(context, "appID");
	```
	**Note**:`appID` is provided by our operator.

* Override the `getBaseContext` method of your app's `application`:

	```
	@Override
    public Context getBaseContext() {
        return APApplication.getBaseContext(super.getBaseContext());
    }
	```

* `proguard` configuration:

	```
	-keep class * extends com.ap.android.atom.sdk.core.base.ad.Ad
	-keep class * extends com.ap.android.atom.sdk.core.base.ad.AdSDK
	-keep class * implements com.ap.android.atom.sdk.core.base.lifecycle.IApplicationLifecycle
	```

## <a name="nativeAD">NativeExpress</a>
1. **Instantiation**

	```java
	APAdNativeExpress apNative = new APAdNativeExpress("slotID", listener);
	```
	| Parameters	|	Description |
	| ---	|	--- |
	| slotID	|	Slot ID, provided by operator |
	| listener	|	Listener to received call backs |

1. **load**

	```java
	apNative.load();
	```
1. **Once ad is loaded succesfully by receiving load success call back, you can start using ad assets with the following getter methods.**

	| Description	|	Getter | Note |
	| ---	|	--- | --- |
	| icon	|	`getAPAdIcon()` | |
	| image	|	`getAPAdScreenshot()` | |
	| description	|	`getAPAdDescription()` | |
	| title	|	`getAPAdTitle()` ||
	| video	|	`getAPAdVideo()` |if ad type is not `video`, The return value is null|

1. **Regist containerView**
```java
public boolean registerContainerView(ViewGroup view);
```

5. **Set deeplink tip**
If this method is not called, the deeplink alert will not show
```java
public void setDeeplinkTipWithTitle(String title);
```

### Listener
**`APAdNativeExpressListner`**

```java
// when NativeExpress ad slot loaded successfully.
// @param ad: ad for NativeExpress
public void onApAdNativeExpressDidLoadSuccess(APAdNativeExpress ad);

// when NativeExpress ad slot failed to load.
// @param ad: the ad for NativeExpress
// @param err the reason of error
public void onApAdNativeExpressDidLoadFail(APAdNativeExpress ad, APAdError err);

// when NativeExpress is clicked.
// @param ad the ad for NativeExpress
public void onApAdNativeExpressDidClick(APAdNativeExpress ad);

// when NativeExpress  landing  is presented.
// @param ad: the ad for NativeExpress
public void onApAdNativeExpressDidPresentLanding(APAdNativeExpress ad);

// when NativeExpress  landing is dismissed.
// @param ad: the ad for NativeExpress
public void onApAdNativeExpressDidDismissLanding(APAdNativeExpress ad);

// when NativeExpress will enter background.
// @param ad: the ad for NativeExpress
public void onApAdNativeExpressApplicationWillEnterBackground(APAdNativeExpress ad);
```
**`APAdNativeExpressVideoView`**
```java
// When the video finishes
// @param view NativeExpressVideo View
public void onApAdNativeExpressVideoViewDidPlayFinish(APAdNativeExpressVideoView view);
```

**`APAdNativeExpressVideoState`**
| State	|	Description |
| ---	|	--- |
| `APAdNativeExpressVideoStateDefault`	|	video default state |
| `APAdNativeExpressVideoStateFailed`	| video play failed |
| `APAdNativeExpressVideoStateBuffering`	|	video buffering |
| `APAdNativeExpressVideoStatePlaying`	|	video playing |
| `APAdNativeExpressVideoStateStop`	|	video playback stopped |
| `APAdNativeExpressVideoStatePause`	|	video playback paused |



## <a name="splashAD">APAdSplash</a>
1. **Instantiation**：

	```java
	APAdSplash splash = new APAdSplash(slotID,listener);
	```

	| Parameters	|	Description |
	| --- | --- |
	| slotID	|	Slot ID, provided by operator |
	| listener	|	Listener to received call backs |



	### Load Splash ad

	```java
	public void load();
	```

	#### Show Splash ad

	```java
	public void presentWithViewContainer(ViewGroup container);
	```
	* **ViewGroup** - ViewGroup for which add ad will be displayed within

	#### Load & Show
	`APAdSplash`

	```java
	public void loadAndPresentWithViewContainer(ViewGroup container);
	```
	* **ViewGroup** - ViewGroup for which add ad will be displayed within
	* **Note**:`loadAndPresent` and `load`cannot be used at the same time.

	#### Set load duration
	duration >=0 ，default is 3s.

	```java
	public boolean setSplashMaxLoadInterval(int interval); //单位秒
	```

	#### Set display duration

	```java
	public boolean setSplashShowInterval(int interval); //单位秒
	```

	#### Set backgroundColor
	default:black.
	```java
	public void setSplashBackgroundColor(int color);
	```

	#### Set backgroung image
	default: None
	```java
	public void setSplashBackgroundColor(Bitmap image);
	```
	**Note** :The background image will cover the background color

	#### Customize the close button style
	```java
	public void setSplashCloseButtonView(View view);
	```

	#### Customize the close button position
	```java
	public void setSplashCloseButtonPosition(ViewGroup.LayoutParams params);
	```

	#### Set deeplink tip
	If this method is not called, the deeplink alert will not show
	```java
	public void setDeeplinkTipWithTitle(String title);
	```

	#### Set botomView
	```java
	public void setSplashBottomLayoutView(ViewGroup view, boolean autofit);
	```
	**Note**:`NO`:Force display bottomView,`YES`:Automatically adapt according to the size of the material.
	**Note**:BotomView is invalid in landscape mode

	#### Get splash view
	```java
	public View getSplashView();
	```

	### Listener

	`APAdSplashListener`

	```java
	// when Splash ad slot loaded successfully.
	// @param ad: ad for Splash
	public void onAPAdSplashLoadSuccess(APAdSplash ad);

	// when Splash ad slot failed to load.
	// @param ad: the ad for Splash
	// @param err the reason of error
	public void onAPAdSplashLoadFail(APAdSplash ad, APAdError err);

	// when Splash ad slot failed to assemble.
	// @param ad: the ad for Splash
	// @param err the reason of error
	public void onAPAdSplashDidAssembleViewFail(APAdSplash ad, APAdError err);

	// When splash ad slot presented successfully.
	// @param ad : the ad for splash
	public void onAPAdSplashPresentSuccess(APAdSplash ad);

	// When splash ad slot failed to present.
	// @param ad : the ad for splash
	// @param err : the reason of error
	public void onAPAdSplashPresentFail(APAdSplash ad, APAdError err);

	// When splash is clicked.
	// @param ad : the ad for splash
	public void onAPAdSplashClick(APAdSplash ad);

	// When splash landing is presented.
	// @param ad : the ad for splash
	public void onApAdSplashDidPresentLanding(APAdSplash ad);

	// When splash landing is dismissed.
	// @param ad : the ad for splash
	public void onApAdSplashDidDismissLanding(APAdSplash ad);

	// When application will enter background.
	// @param ad : the ad for splash
	public void onApAdSplashApplicationWillEnterBackground(APAdSplash ad)

	// When splash is dismissed.
	// @param ad the ad for splash
	public void onAPAdSplashDismiss(APAdSplash ad);

	// When splash did present time left.
	// @param time : the time for splash to present,  unit s.
	public void onAPAdSplashPresentTimeLeft(int time);
	```

## <a name="permissions">Permissions</a>

* SDK will request for these following permissions
	* `android.permission.READ_PHONE_STATE`
	* `android.permission.WRITE_EXTERNAL_STORAGE`
* SDK initialization (`APSDK.init(context,appID,channelID)`) triggers requesting for permissions as part of init process, call this `APCore.setAutoRequestPermission(false)` to stop SDK doing so automatically, please make sure that your code will request for the same permissions at later stage, otherwise SDK may not function properly

## <a name="others">etc</a>
* If you wishes to inform users before download starts under cellular network, use this method to enable this feature `APAD.setIsMobileNetworkDirectlyDownload(boolean)`, default is set to `true`
* supported cpu architecture: `armeabi-v7a`、`armeabi`、`arm64-v8a`
