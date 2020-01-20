> [中文文档](https://github.com/KATracking/KATrackingAd/blob/master/AppicAd_SDK_Android/README.md)
# Current Version 4.0.1

[ReleaseNote](https://github.com/KATracking/KATrackingAd/blob/master/AppicAd_SDK_Android/ReleaseNote.md)

# AppicAd SDK Integration guide

* [Overview](#Overview)
* [Preparation](#essential)
* [Native](#nativeAD)
* [Splash](#splashAD)
* [Interstitial Ad](#interstitialAD)
* [Banner Ad](#bannerAD)
* [Rewarded Video](#videoAD)
* [Permissions](#permissions)
* [More](#others)


## <a name="Overview">Overview</a>

* The SDK provides two different advertisement formats: **Splash**,**Native**
* Download [AppicAd SDK](https://sayhey.oss-cn-shanghai.aliyuncs.com/sdk/android/APSDK_AD_v4.0.1.aar)
* Download [android-gif-drawable-1.2.6.aar](https://github.com/KATracking/KATrackingAd/tree/master/AppicAd_SDK_Android/android-gif-drawable-1.2.6.aar)
* Download [Demo](https://github.com/KATracking/KATrackingAd/blob/master/AppicAd_SDK_Android/AppicAd-SDK-Android-Demo.zip

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
	-keep class * extends com.ap.android.trunk.sdk.core.base.ad.Ad
	-keep class * extends com.ap.android.trunk.sdk.core.base.ad.AdSDK
	-keep class * implements com.ap.android.trunk.sdk.core.base.lifecycle.IApplicationLifecycle
	```

## <a name="nativeAD">Native</a>
### Instantiation

	```java
	APAdNative apNative = new APAdNative("slotID", listener);
	```
	| Parameters	|	Description |
	| ---	|	--- |
	| slotID	|	Slot ID, provided by operator |
	| listener	|	Listener to received call backs |

### load

```java
apNative.load();
```
**Once ad is loaded succesfully by receiving load success call back, you can start using ad assets with the following getter methods.**

| Description	|	Getter | Note |
| ---	|	--- | --- |
| icon	|	`getAPAdIcon()` | |
| image	|	`getAPAdScreenshot()` | |
| description	|	`getAPAdDescription()` | |
| title	|	`getAPAdTitle()` ||
| video	|	`getAPAdVideo()` |if ad type is not `video`, The return value is null|

**Regist containerView**
```java
public boolean registerContainerView(ViewGroup view);
```

**Set deeplink tip**
If this method is not called, the deeplink alert is default to set to Off
```java
public void setDeeplinkTipWithTitle(String title);
```

### Listener
`APAdNativeListner`

```java
// when Native ad slot loaded successfully.
// @param ad: ad for Native
public void onApAdNativeDidLoadSuccess(APAdNative ad);

// when Native ad slot failed to load.
// @param ad: the ad for Native
// @param err the reason of error
public void onApAdNativeDidLoadFail(APAdNative ad, APAdError err);

// when Native is clicked.
// @param ad the ad for Native
public void onApAdNativeDidClick(APAdNative ad);

// when Native  landing  is presented.
// @param ad: the ad for Native
public void onApAdNativeDidPresentLanding(APAdNative ad);

// when Native  landing is dismissed.
// @param ad: the ad for Native
public void onApAdNativeDidDismissLanding(APAdNative ad);

// when Native will enter background.
// @param ad: the ad for Native
public void onApAdNativeApplicationWillEnterBackground(APAdNative ad);
```
**`APAdNativeVideoView`**
```java
// When the video finishes
// @param view NativeVideo View
public void onApAdNativeVideoViewDidPlayFinish(APAdNativeVideoView view);
```

**`APAdNativeVideoState`**
| State	|	Description |
| ---	|	--- |
| `APAdNativeVideoStateDefault`	|	video default state |
| `APAdNativeVideoStateFailed`	| video play failed |
| `APAdNativeVideoStateBuffering`	|	video buffering |
| `APAdNativeVideoStatePlaying`	|	video playing |
| `APAdNativeVideoStateStop`	|	video playback stopped |
| `APAdNativeVideoStatePause`	|	video playback paused |



## <a name="splashAD">APAdSplash</a>
### Instantiation

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
* supported cpu architecture: `armeabi-v7a`、`armeabi`、`arm64-v8a`
