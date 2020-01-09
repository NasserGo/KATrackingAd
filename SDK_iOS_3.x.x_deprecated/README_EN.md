> [中文文档](https://github.com/KATracking/KATrackingAd/blob/master/SDK_iOS_3.x.x_deprecated/README.md)
# Current Ver.3.11.1.4 [ReleaseNote](https://github.com/KATracking/KATrackingAd/blob/master/SDK_iOS_3.x.x_deprecated/ReleaseNote.md)
# Integration Guideline

SDK can be obtained in two ways as mentioned below.

* Get and integrate via CocoaPods
* Get and integrate by downloading the ZIP archive
* Note: We recommend to use CocoaPods for sdk management.  The following describes the basic usage of cocoapods. If you don't have relevant experience, please execute the following commands sequentially in the command line window.


## Preparation
If you have not installed CocoaPods, please follow the process below.

### CocoaPods installation
`sudo gem install -n /usr/local/bin cocoapods --pre`

### CocoaPods public warehouse installation
`pod setup`

### Add private AppicSDK pod repo
pod repo add AppicAdSpecs https://github.com/KATracking/AppicAdSpecs

## Integrated with CocoaPods
* Switch the current working path in the command line window to the directory where your Xcode project file is located. 

`cd projectPath`

* Create a Podfile

`pod init`

* Open the Podfile with a text editor
* Add AppicSDK pod repo to the top
`source 'https://github.com/KATracking/AppicAdSpecs`
* Adding private repo will cause pod stop using public repo, add this if you still need to use pub repo
`source 'https://github.com/CocoaPods/Specs.git`
* **OPTIONAL**: Adding other libs if needed

`  pod 'AppicSDK'`  
`  pod 'AppicAppLovinSDK'`  
`  pod 'AppicAppsFlyerLib'`  
`  pod 'AppicGDT'`  
`  pod 'AppicGoogleMobileAds'`  
`  pod 'AppicInMobiSDK'`  
`  pod 'AppicIronSource'`  
`  pod 'AppicTalkingData'`  
`  pod 'Appictoutiao'`  
`  pod 'AppicUM'`  
`  pod 'AppicFirebase'`   
`  pod 'AppicUnityAds'`  
`  pod 'AppicVungleSDK'`  
`  pod 'AppicFBAudienceNetwork'`  
`  pod 'AppicAdjustSdk'` 

* Execute the CocoaPods install command in the command line window.  

`pod install`

* Use Xcode to open the project with the newly generated xcworkspace, compile and test. At this point sdk has been integrated.

### Update SDK version

* When updating the SDK version, execute the following command.  

`pod repo update AppicAdSpecs`

* Switch the current working path in the command line window to the directory where your Xcode project file is located. 

`cd projectPath`

* Execute the following instructions in the command line window to update。

`pod update`

### Get the SDK docking demo [Download Path](https://github.com/KATracking/KATrackingAd/blob/master/KATrackingAd_iOS_new/Demo.zip)
A reference to all third-party sdk dependent libraries has been configured in Demo. Please follow the steps above to install cocoapods, and execute the `pod install` command on the project path to install sdk. After installation, you can run it.

## Download the SDK zip package for integration
* If you use cocoapods to integrate, you don't have to manually download sdk.
* If integrate manually, please download the corresponding version of sdk via the link below.
  
#### Advertising SDK dependency library
* AppicSDK [download path](https://img.atomhike.com/sdk/Mediation/KASDK/KASDK.v3.11.1.4.zip)

#### Advertising platform dependency library
* AppicInMobiSDK [download path](https://img.atomhike.com/sdk/Mediation/InMobiSDK/InMobiSDK.v7.3.0.zip)
* AppicGoogleMobileAds [download path](https://img.atomhike.com/sdk/Mediation/GoogleMobileAds/GoogleMobileAds.v7.52.0.zip)
* AppicUnityAds [download path](https://img.atomhike.com/sdk/Mediation/UnityAds/UnityAds.v3.3.0.zip)
* AppicVungleSDK [download path](https://img.atomhike.com/sdk/Mediation/VungleSDK/VungleSDK.v0.0.4.zip)
* AppicAppLovinSDK [download path](https://img.atomhike.com/sdk/Mediation/AppLovinSDK/AppLovinSDK.v0.0.4.zip)
* AppicIronSource [download path](https://img.atomhike.com/sdk/Mediation/IronSource/IronSource.v6.10.0.0.zip)
* Appictoutiao [download path](https://img.atomhike.com/sdk/Mediation/toutiao/toutiao.v2.4.6.3.999.zip)
  * BUAdSDK.framework
  * BUAdSDK.bundle
* AppicGDT [download path](https://img.atomhike.com/sdk/Mediation/GDT/GDT.v4.10.13.zip)
  * libGDTMobSDK.a
* AppicTalkingData (Optional, if you need KASDK to dock TD as a statistical framework）[download path](https://img.atomhike.com/sdk/Mediation/TalkingData/TalkingData.v0.0.4.zip)
  * libTalkingData.a
* AppicUM (Optional, if you need KASDK to dock UM as a statistical framework）[download path](https://img.atomhike.com/sdk/Mediation/UM/UM.v0.0.4.zip)   
  * UMAnalytics.framework
  * UMCommon.framework
* AppicFirebase (Optional, if you need KASDK to dock AppicFirebase as a statistical framework）[download path](https://img.atomhike.com/sdk/Mediation/Firebase/Firebase.v5.18.0.zip)   
  * Crashlytics.framework
  * Fabric.framework
  * FIRAnalyticsConnector.framework
  * FirebaseAnalytics.framework
  * FirebaseCore.framework
  * FirebaseCoreDiagnostics.framework
  * FirebaseCrash.framework
  * FirebaseInstanceID.framework
  * GoogleAppMeasurement.framework
  * GoogleToolboxForMac.framework
  * GoogleUtilities.framework
  * nanopb.framework
  * Protobuf.framework
* AppicAppsFlyerLib (Optional, if you need APSDK to dock AppsFlyer as a statistical framework) [download path](https://img.atomhike.com/sdk/Mediation/AppsFlyerLib/AppsFlyerLib.v0.0.4.zip)

* AppicFBAudienceNetwork [download path](https://img.atomhike.com/sdk/Mediation/FBAudienceNetwork/FBAudienceNetwork.v5.6.0.zip)
* AppicAdjustSdk [download path](https://img.atomhike.com/sdk/Mediation/AdjustSdk/AdjustSdk.v4.17.1.zip)
* BaiduSDK [download path](https://img.atomhike.com/sdk/Mediation/BaiduSDK/BaiduSDK.v4.64.zip)

   
### Join other dependency libraries
* SystemConfiguration.framework
* CoreTelephony.framework
* QuartzCore.framework
* GLKit.framework
* AdSupport.framework
* UIKit.framework
* StoreKit.framework
* CoreLocation.framework
* CFNetwork.framework
* CoreMotion.framework
* AVFoundation.framework
* CoreData.framework
* CoreText.framework
* WebKit.framework
* JavaScriptCore.framework
* libsqlite3.0.tbd
* libxml2.2.tbd
* libz.tbd
* libc++.tbd
* MessageUI.framework
* SafariServices.framework
* CoreMedia.framework
* MobileCoreServices.framework
* MediaPlayer.framework
* libresolv.9.tbd
* libresolv.tbd
* ImageIO.framework

### 接入admob注意事项

```XML
<key>GADApplicationIdentifier</key>
<string>appId</string>
<key>GADIsAdManagerApp</key>
<true/>
```

![deployment target](https://github.com/KATracking/KATrackingAd/blob/master/README_Res/google_tips_en.png)
![deployment target](https://github.com/KATracking/KATrackingAd/blob/master/README_Res/google_tips_1.png)

### info.plist Set whitelist
```XML
	<key>LSApplicationQueriesSchemes</key>
	<array>
		<string>dianping</string>
		<string>imeituan</string>
		<string>com.suning.SuningEBuy</string>
		<string>openapp.jdmobile</string>
		<string>vipshop</string>
		<string>snssdk141</string>
		<string>ctrip</string>
		<string>suning</string>
		<string>qunariphone</string>
		<string>QunarAlipay</string>
		<string>qunaraphone</string>
		<string>yohobuy</string>
		<string>kaola</string>
		<string>agoda</string>
		<string>openapp.xzdz</string>
		<string>beibeiapp</string>
		<string>taobao</string>
		<string>tmall</string>
		<string>openjd</string>
		<string>jhs</string>
		<string>yhd</string>
		<string>wireless1688</string>
		<string>GomeEShop</string>
		<string>wbmain</string>
		<string>xhsdiscover</string>
		<string>douyin</string>
		<string>pinduoduo</string>
		<string>jdmobile</string>
		<string>tbopen</string>
		<string>pddopen</string>
		<string>mogujie</string>
		<string>koubei</string>
		<string>eleme</string>
	</array>
```


### Setup deployment target to: iOS 8.0
![deployment target](https://github.com/KATracking/KATrackingAd/blob/master/README_Res/ios_deployment_target.png)

### Add the -ObjC linker flag
![linker flag](https://github.com/KATracking/KATrackingAd/blob/master/README_Res/linker_flag.png)

### Setup ATS
![linker flag](https://github.com/KATracking/KATrackingAd/blob/master/README_Res/ats.png)

| ATS 设定  	   						| 使用的组件  | iOS 9 HTTP | iOS 10 HTTP | 备注 |
|:-------------------------------|:---------------:|:-------------:|:-------------:|-------------:|
| NSAllowsArbitraryLoads: NO      | WebView |         ❌ | ❌ | 默认行为 |
|       |    URLSession    |      ❌     | ❌ |  |
| NSAllowsArbitraryLoads: YES     |    WebView    |      ✅      | ✅ | 彻底禁用 ATS |
|       |   URLSession     |           ✅ | ✅ | 审核时需要说明理由 |
| NSAllowsArbitraryLoads: NO & NSAllowsArbitraryLoadsInWebContent: YES | WebView |  ❌ | ✅ | 只对网页内容禁用 ATS |
|       |   URLSession |  ❌ | ❌ | 保证 API 的安全性 |
| NSAllowsArbitraryLoads: NO & NSAllowsArbitraryLoadsInWebContent: NO | WebView | ❌ | ❌ |  |
|       | URLSession | ❌ | ❌ |  |
| NSAllowsArbitraryLoads: YES & NSAllowsArbitraryLoadsInWebContent: NO | WebView | ✅ | ❌ | 对于 iOS 10，NSAllowsArbitraryLoadsInWebContent 存在时忽略 NSAllowsArbitraryLoads 的设置 |
|  | URLSession | ✅ | ❌ | iOS 9 将继续使用 NSAllowsArbitraryLoads |
| NSAllowsArbitraryLoads: YES & NSAllowsArbitraryLoadsInWebContent: YES | WebView | ✅ | ✅ | 对于 iOS 10，NSAllowsArbitraryLoadsInWebContent 存在时忽略 NSAllowsArbitraryLoads 的设置 |
|  | URLSession | ✅ | ❌ | iOS 9 将继续使用 NSAllowsArbitraryLoads |

## Let's code!

### SDK initialization
Please initialize SDK as early into app lifecycle as possible, as once SDK initilized it will automatically pre-cashe ads.

`AppDelegate`

```Objective-c
#import <APSDK/APPch.h>
```
`AppDelegate : application:didFinishLaunchingWithOptions:`

```Objective-c
[[APSDK sharedInstance] initWithAppId:@"<AppId>"];
```
Provided by operator

* **AppId** - Application ID

### Important Note!! Since SDK ver.3.9.0, initialization takes only one parameter, in the form of "appid-appchannel", or use the auto generated appid string from dashboard when you create your app.

# Native template ad - NativeExpress

### Create an ad
Create an instance of a native template ad
`APAdNativeExpress`

```Objective-c
APAdNativeExpress *ad = [[APAdNativeExpress alloc] initWithSlot:<AdSlot> delegate:<Delegate>];
```
* **AdSlot** - Slot ID to request ad with
* **Delegate** - id<APAdNativeDelegate> object to receive delegate calls

### Load Native ad
Simple call this method to load an ad, then wait for delegates to be tricked for load succes or fail
`APAdNativeExpress`

```Objective-c
[ad load];
```

### Properties of Native Ad
Each native ad also have the following properties 

* **ka_slot** - SlotId of the ad slot
* **ka_adTitle** - Ad title text
* **ka_adDescription** - Ad text description
* **ka_adIcon** - UIImageView containing the icon image of Ad
* **ka_adScreenShots** - UIImageView containing the big picture of Ad
* **ka_VideoAdView** - UIImageView containing the video of Ad

### rootviewController
`APAdNativeExpress`

```Objective-c
[ad setRootViewController:<controller>]
```

* **controller** - Advertising display landing page redirects via rootviewController, which must pass parameters

### Register clickable view
`APAdNativeExpress`

```Objective-c
- (BOOL)registerContainer:(__kindof UIView *)containerView
```
* **containerView** - Register the container view of the native ad, must pass parameters

### Recycling material
When the advertising materials are removed from the display interface, please call the following method to reclaim the material
`APAdNativeExpress`

```Objective-c
[ad recyclePrimaryView];
```

### Delegates of Native Ad
Use these delegates to receive events of request native ad complete or fail
`APAdNativeExpressDelegate`

```Objective-c
// Request has completed with nativeAd
- (void) nativeExpressAdRequestCompletedWithAd:(nonnull APAdNativeExpress *)nativeAd;

// Request has failed
- (void) nativeExpressAdRequestFailedWithAd:(nonnull APAdNativeExpress *)nativeAd
                                 withStatus:(nonnull NSError *)nativeAdStatus;

@optional

Ad click
- (void) nativeExpressAdDidClicked:(nonnull APAdNativeExpress *)native;

- (void) nativeExpressAdDidPresentScreen:(nonnull APAdNativeExpress *)nativeAd;

- (void) nativeExpressAdDidDismissScreen:(nonnull APAdNativeExpress *)nativeAd;
```


# Splash Ad

### Create a Splash Ad
To create a Splash ad instance

`APAdSplash`

```Objective-c
APAdSplash *splash = [[APAdSplash alloc] initWithSlot:<AdSlot> delegate:<Delegate>];
```
* **AdSlot** - Slot ID to request ad with
* **Delegate** - id<APAdSplashDelegate> object to receive delegate calls


### Present a Splash Ad
To load and present Splash Ad

`APAdSplash`

```Objective-c
[splash loadAndPresentWithViewController:<Controller>];
```
* **Controller** - UIViewController for which the splash is presented from


### Show ads and add product IDs
Call the following method to load and display the open screen advertisement, and at the same time you can add the product custom logo view to fill the blank position when the full screen is filled due to insufficient material size.

`APAdSplash`

```Objective-c
[splash loadAndPresentWithViewController:<Controller> andBackgroundColor:<Color> andBottomView:<View> andBottomViewAutoFitDisplay:<Auto>];
```

* **Controller** - UIViewController for which the Splash is presented from
* **Color** - Identifies the background color of the fill area
* **View** - Used to display the View in the fill area
* **Auto** - When you want the SDK to automatically adapt to the size according to whether the display is displayed, otherwise it will be displayed.

### Logo area available size
Call the following method to calculate the View size that can be used to identify the zone based on different devices.

`APAdSplash`

```Objective-c
CGSize size = [APAdSplash getBottomViewSize];
```

### Delegates of Splash Ad
Use these delegates to receive events of splash Ad

`APAdSplashDelegate`

```Objective-c
// Ad is successfully presented
- (void) splashAdPresentDidSuccess:(nonnull APAdSplash *)splashAd;

// Ad present has failed
- (void) splashAdPresentDidFail:(nonnull NSString *)splashAdSlot
withError:(nonnull NSError *)error;

// Ad has been clicked
- (void) splashAdDidClick:(APAdSplash *)splashAd;

// Ad view has been dismissed from screen
- (void) splashAdDidDismiss:(APAdSplash *)splashAd;

// Splash ad will dismissed
- (void) splashAdWillDismiss:(nonnull APAdSplash *)splashAd;
```

# Interstitial Ad

### Create a Interstitial Ad
To create a Interstitial ad instance

`APAdInterstitial`

```Objective-c
APAdInterstitial *interstitial = [[APAdInterstitial alloc] initWithSlot:<AdSlot> delegate:<Delegate>];
```
* **AdSlot** - Slot ID to request ad with
* **Delegate** - id<APAdInterstitialDelegate> object to receive delegate calls

To load an interstitial Ad
`APAdInterstitial`

```Objective-c
[interstitial load];
```

Test availability of the Ad
`APAdInterstitial`

```Objective-c
BOOL ready = [interstitial isReady];
```

### Present a Interstitial Ad
To load and present Interstitial Ad
`APAdInterstitial`

```Objective-c
[interstitial presentFromRootViewController:<Controller>];
```
* **Controller** - UIViewController for which the Interstitial is presented from

### Delegates of Interstitial Ad
Use these delegates to receive events of Interstitial Ad

`APAdInterstitialDelegate`

```Objective-c
// Interstitial Ad load success
- (void) interstitialAdLoadDidSuccess:(nonnull APAdInterstitial *) interstitialAd;

// Interstitial Ad load fail
- (void) interstitialAdLoadDidFailForSlot:(nonnull NSString *) interstitialAdSlot
withError:(nonnull NSError *) interstitialAdStatus;

// Interstitial Ad presented successful
- (void) interstitialAdDidPresent:(nonnull APAdInterstitial *) interstitial;


// Interstitial Ad has been clicked
- (void) interstitialAdDidClick:(nonnull APAdInterstitial *) splashAd;

// Interstitial Ad has been dismissed
- (void) interstitialAdDidDismiss:(nonnull APAdInterstitial *) interstitial;

// Interstitial Ad has been dismissed from screen
- (void) interstitialAdDidDismiss:(nonnull APAdInterstitial *) interstitial;
```

# Incentivized Video Ad

### How does it work
Incentive video ads are singletoned in the SDK, so there's no need to create new instances, you can use the class method to display ads directly, and the video ads start to load automatically as soon as the SDK is successfully initialized.

Check if the ad is ready for use
`APAdIncentivized`

```Objective-c
BOOL ready = [APAdIncentivized isReady];
```

### Present a Incentivized video Ad
Call the following method to load and display the incentive video ad

`APAdIncentivized`

```Objective-c
[APAdIncentivized presentFromRootViewController:<Controller>];
```
* **Controller** - UIViewController for which the Incentivized video Ad is presented from

### Delegates of Incentivized video Ad
To set a delegate to receive events

`APAdIncentivized`

```Objective-c
[APAdIncentivized setDelegate:<Delegate>];
```
* **Delegate** - The id<APAdIncentivizedDelegate> object
Use these delegates to receive events of Incentivized video Ad

### Ad callback
Receive events that load ads using the following callbacks 

`APAdIncentivizedDelegate`

```Objective-c
// Incentvized video Ad has failed to present
- (void) incentivizedAdPresentDidFailWithError:(NSError *)error;

// Incentivized video Ad has presented successful
- (void) incentivizedAdPresentDidSuccess;

// Incentivized video Ad has complete without skip 
- (void) incentivizedAdPresentDidComplete;

// Incentivized video Ad has complete with skip 
- (void) incentivizedAdPresentDidSkip;
```

# Banner Ad

### Create a Banner Ad
Create an instance of a banner and add the ad to the view

`APAdBanner`

```Objective-c
APAdBanner * banner = [[APAdBanner alloc] initWithSlot:<adSlot> withSize:<size> delegate:<delegate> currentController:<controller>];
[self.view addSubview:banner];
```
* **adSlot** - Slot ID to request ad with
* **Size** - <APAdBannerSize> banner size
* **Delegate** - id<APAdBannerDelegate> object to receive delegate calls
* **controller** - UIViewController for displaying ad pages after clicking on a banner ad

load Ad
`APAdBanner`

```Objective-c
[banner load];
```

Setting Ad Positon
`APAdBanner`
```Objective-c
[banner setPosition:<point>];
```

* **point** - setting ad center point

### Ad callback
Receive events that load ads using the following callbacks

`APAdBannerDelegate`

```Objective-c
/**
 * Notifies the delegate that the banner has finished loading
 */
- (void) bannerAdCompleteLoadingWithAd:(nonnull APAdBanner *)bannerAd;
/**
 * Notifies the delegate that the banner has failed to load with some error.
 */
- (void) bannerAdFailedLoadingForSlot:(nonnull NSString *)adSlot
                           withStatus:(nonnull NSError *)nativeAdStatus
                            andBanner:(nonnull APAdBanner *)bannerAd;
/**
 * Notifies the delegate that the banner has finished presenting screen.
 */
- (void) bannerDidPresentScreen:(nonnull APAdBanner *)bannerAd;

/**
 * Notifies the delegate that the banner has dismissed the presented screen.
 */
- (void) bannerDidDismissScreen:(nonnull APAdBanner *)bannerAd;

- (void) bannerDidClick:(nonnull APAdBanner *)bannerAd
```

### Redemption code

Enter redemption code to redeem gifts

`APPub`

```Objective-c
[APPub redeemCode:<code> withDelegate:<Delegate>]
```
* **code** - Redemption code (contact the operator for the relevant configuration)
* **Delegate** - id<APPubConfigManagerDelegate> instances，Used to receive redemption is successfull or not.

Receive redemption events using the following callbacks

`APPubConfigManagerDelegate`

```Objective-c
/**
 * Return the successfully redeemed packet to the agent for processing and return the corresponding redemption code.
 */
- (void) redeemCodeSuccessWithData:(NSDictionary *)data withCode:(NSString *)code;
/**
 * Redemption failed, return error code and corresponding redemption code
 */
- (void) redeemCodeFailedWithError:(NSError *)error withCode:(NSString *)code;
```
### Payment
`APPub`

Payment

```Objective-c
[APPub payWithIAPId:<iapId> withOrderId:<orderId> withDelegate:<Delegate>]
```
Restore purchase

```Objective-c
[APPub restoreCompletedTransactionsWithDelegate:<Delegate>]
```


* **iapId** - Platform billing point
* **orderId** - Order Id (please ensure that each incoming order Id is a unique Id)
* **Delegate** - id<APPubConfigManagerDelegate>instance，Used to receive whether payment is successful

Receive payment events using the following callbacks

`APPubConfigManagerDelegate `

```Objective-c
/**
 * The payment is successful and returns to the platform billing point id
 */
- (void)paymentSuccessWithIapId:(NSString *)iapId;
/**
 * Payment failure returns platform billing point id and error message
 */
- (void)paymentFailedIapId:(NSString *)iapId withErrorInfo:(NSError *)error;
/**
 * Restored purchase failed
 */
- (void)restorePaymentFailed;
/**
 * Restore purchase success and return Apple billing point id
 */
- (void)restorePaymentSuccessWithIdentifier:(NSString *)iapId;
```

### PUSH


`APPub`

Get the deviceToken in the proxy method of `UIApplicationDelegate`

```Objective-c
- (void)application:(UIApplication *)application didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken
{
	[APPub setDeviceToken:deviceToken];
} 

- (void)application:(UIApplication *)application didReceiveRemoteNotification:(NSDictionary *)userInfo
{
    [APPub handlePushMessage:userInfo];
}
```

### SDK Error Code

```Objective-c
    APAdStatusCodeMissingResourceBundle        = 51001,    // Resource bundle is not present
    APAdStatusCodeNoFill                       = 51002,    // Ad is not filled at this time
    APAdStatusCodeDuplicateRequest             = 51003,    // Instance of ad is already served, usually caused duplicated request on same instance of ad
    APAdStatusCodeSDKNotInitialized            = 51004,
    APAdStatusCodeMediationRequestFailed       = 51101,    // General mediation platform failed to receive ad in time or returned mediation error
    APAdStatusCodeMediationInvalidRequest      = 51102,    // Mediation platform return invalid request error
    APAdStatusCodeMediationInvalidConfig       = 51103,     
    APAdStatusCodeFailToPresent                = 51104,
    APAdStatusCodeAdSwitchClose                = 51105,    // Ad closed
    APAdStatusCodeInvalidRequestPath           = 59994,    // Incorrect server address
    APAdStatusCodeNetworkUnavailable           = 59995,    // Network is currently not available
    APAdStatusCodeNetworkTimeout               = 59996,    // Network request timeout
    APAdStatusCodeInternalError                = 59997,    // SDK internal process error
    APAdStatusCodeServerError                  = 59998,    // Server has return an error
    APAdStatusCodeUnknown                      = 59999
```

### cocos2d-x present ad crash
Please check if there is the following code in `AppController`, please add it.

```Objective-c
@property(nonatomic, readonly) UIWindow* window;
```
