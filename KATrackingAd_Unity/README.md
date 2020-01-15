>[中文文档](https://github.com/KATracking/KATrackingAd/blob/master/KATrackingAd_Unity/README_zh_CN.md)


# Get Start with the KATracking Unity Plugin

* [Before you get started](#about)
* [Integrate](#step1)
* [Additional Settings for iOS](#step2)
* [Additional Settings for Android](#step3)

## <a name="about">Before you get started</a>


* Support `interstitial`、`splash`、`rewardVideo`、`banner`
* Support iOS 8.0+、Android 4.0+
* [Download unity plugin](http://sayhey.oss-cn-shanghai.aliyuncs.com/sdk/android/APSDKUnityPlugin.unitypackage)
* Download iOS Third Party AD SDKs from [here](https://github.com/KATracking/KATrackingAd/tree/master/SDK_iOS_3.x.x_deprecated)


## <a name="step1">Integrate</a>

* Import sdk plugin into your project

* Invoke sdk's initialization method at your game's entrance point:

	```
	APSDK.init("appID");
	```
	
* add callback methods for the ad events that you might be interested in like this:

	```
	void setupDelegates()
    {
        APSDK.interstitialADLoadSuccess += interstitialLoadSuccess;
        APSDK.interstitialADClick += interstitialADClick;
        APSDK.interstitialADLoadFail += interstitialLoadFailed;
        APSDK.interstitialADPresent += interstitialADPresent;
        APSDK.interstitialADDismiss += interstitialADDismiss;

        APSDK.splashADClick += splashADClick;
        APSDK.splashADDismiss += splashDismiss;
        APSDK.splashPresentFail += splashPresentFail;
        APSDK.splashPresentSuccess += splashPresentSuccess;

        APSDK.rewardVideoADPresentComplete += rewardVideoPresentComplete;
        APSDK.rewardVideoADPresentFail += rewardVideoADPresentFail;
        APSDK.rewardVideoADPresentSkip += rewardVideoADPresentSkip;
        APSDK.rewardVideoADPresentSuccess += rewardVideoADPresentSuccess;

        APSDK.bannerPresentScreen += bannerBeClicked;
        APSDK.bannerLoadFailed += bannerLoadFailed;
        APSDK.bannerLoadComplete += bannerLoadComplete;
        APSDK.bannerPresentScreenDismissed += bannerPresentScreenDismissed;
    }
	```
	
* remove callback methos when you do not need them:

	```
	void removeDelegates()
    {
        APSDK.interstitialADLoadSuccess -= interstitialLoadSuccess;
        APSDK.interstitialADClick -= interstitialADClick;
        APSDK.interstitialADLoadFail -= interstitialLoadFailed;
        APSDK.interstitialADPresent -= interstitialADPresent;

        APSDK.splashADClick -= splashADClick;
        APSDK.splashADDismiss -= splashDismiss;
        APSDK.splashPresentFail -= splashPresentFail;
        APSDK.splashPresentSuccess -= splashPresentSuccess;

        APSDK.rewardVideoADPresentComplete -= rewardVideoPresentComplete;
        APSDK.rewardVideoADPresentFail -= rewardVideoADPresentFail;
        APSDK.rewardVideoADPresentSkip -= rewardVideoADPresentSkip;
        APSDK.rewardVideoADPresentSuccess -= rewardVideoADPresentSuccess;
    }
	```
	
* load and show splash ad:

	```
	APSDK.showSplash("slotID");
	```
	
* load interstitial ad:

	```
	APSDK.loadInterstitial("slotID");
	```
	
	**Note**: Because it need time to complete the load stuff, so you should invoke the load method at a proper time before trying to display it.
	
	**Note**: Make sure not to invoke this method inside its loadFailed delegate method, for in some extreme cases(bad networks or current no ad fill temporarily), doing this will cause a frequent load interstitial request and result in a bad performance in the integrated game. The proper time to invoke this method should be the time when the 'interstitial show event' is triggered.
	
* check if interstitial ad is ready or not:

	```
	APSDK.isInterstitialAvaliable("slotID");
	```
	
* show interstitial ad:

	```
	APSDK.showInterstitial("slotID");
	```
	
* load and show banner ad:

	```
	APSDK.loadAndPresentBanner("slotID", bannerSize, x, y);
	```
	
	**Note:** `bannerSize` is an param of `Enum` type. Its option values are:`BANNER_SIZE_320_50 `、`BANNER_SIZE_480_60 `、`BANNER_SIZE_728_90`(`android` platform only support the size `BANNER_SIZE_320_50`)
	
	**Note:** `x` and `y` indicate a position on the device's screen that the banner ad's center point is located at, e.g. if you want the banner ad be positioned at the bottom of the screen, and center in horizontal, we assume that the variables `screenWidth` and `screenHeight` represent the screen size, and `bannerSize` is `BANNER_SIZE_320_50 `, then `x` should be `screenWidth/2` and `y` should be `screenHeight-50/2`.
	
	**Note:** you can get the device's screen size by invoking the method:`APSDK.getDeviceScreenSize();`
	
* hide banner ad:

	```
	APSDK.hideBanner("slotID");
	```
	
* show banner ad:

	```
	APSDK.showBanner("slotID");
	```
	
* remove banner ad and destroy it:

	```
	APSDK.removeAndDestroyBanner("slotID");
	```
	
* load reward video ad:

	```
	There is no need to invoke the reward video load method manually(and also, the plugin does not provide this function), sdk will handle the load stuff itself.
	```
	
* check if reward video ad is ready or not:

	```
	APSDK.isRewardVideoADAvaliable()
	```
	
* show reward video ad:

	```
	APSDK.showRewardVideoAD();
	```
	
* get channel id：

	```
	APSDK.getChannelID();
	```
	
## <a name="step2">Additional Settings for iOS</a>
* add third party ad sdks depend on your needs (you can put the third party ad sdks' files in directory: `Assets/Plugins/iOS/APSDK/libs` or any other subdir under `Assets/Plugins/iOS/` depending on your favor)
* export an ios project
* follow the instructions [here](https://github.com/KATracking/KATrackingAd/blob/master/SDK_iOS_3.x.x_deprecated/README_EN.md) to set your ios project (during the exporting in previous step, the plugin has already done some of the settings for you, that include [add dependicies](https://github.com/KATracking/KATrackingAd/blob/master/SDK_iOS_3.x.x_deprecated/README.md#infoplist%E8%AE%BE%E7%BD%AE%E7%99%BD%E5%90%8D%E5%8D%95)、[set white list](https://github.com/KATracking/KATrackingAd/blob/master/SDK_iOS_3.x.x_deprecated/README.md#infoplist%E8%AE%BE%E7%BD%AE%E7%99%BD%E5%90%8D%E5%8D%95)、[add -ObjC linker flag](https://github.com/KATracking/KATrackingAd/blob/master/SDK_iOS_3.x.x_deprecated/README.md#infoplist%E8%AE%BE%E7%BD%AE%E7%99%BD%E5%90%8D%E5%8D%95) and set `Enable Bitcode` to `No`)
* if you want to integrate `admob`, you need to add some extra information in your project's `info.plist` file, see more infos [here](https://github.com/KATracking/KATrackingAd/blob/master/SDK_iOS_3.x.x_deprecated/README_EN.md#%E6%8E%A5%E5%85%A5admob%E6%B3%A8%E6%84%8F%E4%BA%8B%E9%A1%B9)


## <a name="step3">Additional Settings for Android</a>
* enable `Custom Gradle Template` in `Unity Editor`'s android player settings.
* add dependency `implementation 'com.android.support:support-v4:26.1.0'` to the generated `gradle` file's `dependency` block 
* build an apk and run&test it. If everything goes well, send the apk file to us, and we'll generate the final `apk` file based on it.
