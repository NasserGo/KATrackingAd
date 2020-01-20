> [中文文档](https://github.com/KATracking/KATrackingAd/blob/master/AppicAd_SDK_iOS/README.md)
# Current Version 4.0.1.0

[ReleaseNote](https://github.com/KATracking/KATrackingAd/blob/master/AppicAd_SDK_iOS/ReleaseNote.md)

* [Overview](#Overview)
* [CocoaPods](#cocoapods)
* [Manually](#manually)
* [Whitelist](#whitelist)
* [Set ats](#ats)
* [Get SDK Demo](#demo)
* [Initialization](#initialization)
* [Splash](#splash)
* [Native](#native)
* [ErrorCode](#errorCode)
* [cocos2d-x present ad crash](#cocos2d)

# <span name="Overview">Overview</span>
This document provides instructions on how to integrate the SDK for iOS developers.
The SDK provides two different advertisement formats: Splash,Native

# Intgration Guideline
## Retrieve AppId Information
#### AppId - Application ID
Initialize with this ID,Provided by operator.

## Requirement
- iOS 9.0+
## Get the SDK
There are two ways to add iOS-SDK to your Xcode project: using Cocoapods or manual integration.
>Note: We recommend to use `CocoaPods` for sdk management.

## <a name="cocoaPods">CocoaPods</a>
Run `pod repo update` to make CocoaPods aware of the latest available AppicSDK versions.
You can user [cocoaPods](https://cocoapods.org/) to install `AppicSDK` by adding it to your `Podfile`:
```ruby
platform :ios, '9.0'
use_frameworks!

target 'MyApp' do
    pod 'AppicSDK', '~> 4.0'
end
```
## <a name="manually">Manually</a>
### Download SDK
* The first step download the [AppicSDK](https://img.atomhike.com/sdk/Mediation/KASDK/APSDK.v4.0.2.1.zip)


 just drag `APSDK.framework` to the project tree,`APSDK.framework` need to be replaced when upgrading the SDK

### Parameter configuration before initialization on manual integration

#### Import basic static libraries on manual integration
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

#### Add linker parameter for XCode Find Other Linker Flags in build settings and add flag: `-ObjC` (case sensitive).

#### <a name="whitelist">info.plist Set whitelist</a>
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
		<string>yohobuy</string>
		<string>kaola</string>
		<string>agoda</string>
		<string>beibeiapp</string>
		<string>taobao</string>
		<string>tmall</string>
		<string>jhs</string>
		<string>yhd</string>
		<string>douyin</string>
		<string>pinduoduo</string>
		<string>jdmobile</string>
		<string>mogujie</string>
		<string>koubei</string>
		<string>eleme</string>
	</array>
```

# <a name="demo">Get the SDK docking demo</a>
[Download Path](https://github.com/KATracking/KATrackingAd/blob/master/AppicAd_SDK_iOS/AppicAd-SDK-iOS-Demo.zip)
A reference to all third-party sdk dependent libraries has been configured in Demo. Please follow the steps above to install cocoapods, and execute the `pod install` command on the project path to install sdk. After installation, you can run it.

# <a name="ats">Setup ATS</a>
Allow the operation of the HTTP connection
```xml
<key>NSAppTransportSecurity</key>
<dict>
    <key>NSAllowsArbitraryLoads</key>
    <true/>
</dict>
```

# <a name="initialization">Initialization</a>
Please initialize SDK as early into app lifecycle as possible, as once SDK initilized it will automatically pre-cashe ads.
Call for the `APSDK` initialization method in `AppDelegate`

```Objective-c
#import <APSDK/APPch.h>
```

```objectivec
- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    // SDK初始化
    [[APSDK sharedInstance] initWithAppId:@"<AppId>"];
    return YES;
}
```
**AppId** - Initialize with this ID,Provided by operator.

# <a name="solash">Splash</a>

#### Create a Splash Ad
To create a Splash ad instance：`APAdSplash`

```ObjectiveC
APAdSplash *splash = [[APAdSplash alloc] initWithSlot:@"SlotId" andDelegate:<Delegate>];
```
* **SlotId** - Slot ID to request ad with
* **Delegate** - APAdSplashDelegate，receive delegate calls

#### Load Splash ad
```Objectivec
[splash load];
```

#### Show Splash Ad
```Objectivec
[splash presentWithViewController:<Controller>];
```
* **Controller** - UIViewController for which the splash is presented from

#### Load & Show
Call the following method to load and display the open screen advertisement
```Objective-c
[splash loadAndPresentWithViewController:<Controller>];
```
* **Controller** - UIViewController for which the splash is presented from
* **Note**:`loadAndPresent` and `load`cannot be used at the same time.

#### Set load duration
duration >=0 ，default is 3s.

```Objectivec
[splash setSplashMaxLoadInterval:<NSTimeInterval>];
```

#### Set display duration

```Objectivec
[splash setSplashShowInterval:<NSInteger>];
```

#### Set backgroundColor
default:black.
```Objectivec
[splash setSplashBackgroundColor:<UIColor>];
```

#### Set backgroung image
default: None
```Objectivec
[splash setSplashBackgroundImage:<UIImage>];
```
**Note** :The background image will cover the background color

#### Customize the close button style
```Objectivec
[splash setSplashCloseButtonView:<UIImage>];
```

#### Customize the close button position
```Objectivec
[splash setSplashCloseButtonCenter:<CGPoint>];
```

#### Set deeplink tip

If this method is not called, the deeplink alert will not show
```Objectivec
[splash setDeeplinkTipWithTitle:<NSString>];
```

#### Set botomView
```Objective-c
[splash setSplashBottomView:<UIView> autoFitForDisplay:<BOOL>];
```
**Note**: `NO`:Force display bottomView,`YES`:Automatically adapt according to the size of the material.

#### Get splash view
```Objective-c
[splash getSplashViewWithViewController:<controller>];
```
**Note**:`controller` The root view controller for handling ad actions.

### APAdSplashDelegate

`APAdSplashDelegate`

```ObjectiveC
@optional
/**
 * Splash ad slot loaded successfully.
 * @param ad : the ad for splash
 */
- (void) apAdSplashDidLoadSuccess:(nonnull APAdSplash *)ad;

/**
 * Splash ad slot failed to load.
 * @param ad : the ad for splash
 * @param err : the reason of error
 */
- (void) apAdSplashDidLoadFail:(nonnull APAdSplash *)ad withError:(nonnull NSError *)err;

/**
 * Splash ad slot failed to create view for impression.
 * @param ad : the ad for splash
 * @param err : the reason of error
 */
- (void) apAdSplashDidAssembleViewFail:(nonnull APAdSplash *)ad withError:(nonnull NSError *)err;

/**
 * Splash ad slot presented successfully.
 * @param ad : the ad for splash
 */
- (void) apAdSplashDidPresentSuccess:(nonnull APAdSplash *)ad;

/**
 * Splash ad slot failed to present.
 * @param ad : the ad for splash
 * @param err : the reason of error
 */
- (void) apAdSplashDidPresentFail:(nonnull APAdSplash *)ad withError:(nonnull NSError *)err;

/**
 * Splash ad is clicked.
 * @param ad : the ad for splash
 */
- (void) apAdSplashDidClick:(nonnull APAdSplash *)ad;

/**
 * Splash ad landing is presented.
 * @param ad : the ad for splash
 */
- (void) apAdSplashDidPresentLanding:(nonnull APAdSplash *)ad;

/**
 * Splash ad landing is dismissed.
 * @param ad : the ad for splash
 */
- (void) apAdSplashDidDismissLanding:(nonnull APAdSplash *)ad;

/**
 * After ad is clicked, splash ad application will enter background.
 * @param ad : the ad for splash
 */
- (void) apAdSplashApplicationWillEnterBackground:(nonnull APAdSplash *)ad;

/**
 * Splash ad is dismissed.
 * @param ad : the ad for splash
 */
- (void) apAdSplashDidDismiss:(nonnull APAdSplash *)ad;

/**
 * Splash ad periodically reports time left for splash impression.
 * @param time : the time for splash to present,  unit s.
 */
- (void) apAdSplashDidPresentTimeLeft:(NSUInteger)time;

```

# <a name="native"> Native </a>
### Create a Native Ad
`APAdNative`

```Objectivec
APAdNative *nativeAd = [[APAdNative alloc] initWithSlot:@"SlotId" andDelegate:<Delegate>];
```
* **SlotId** - Slot ID to request ad with
* **Delegate** - APAdNativeDelegate，receive delegate calls

### Load Native ad
```Objective-c
[nativeAd load];
```

### Material information

* **ap_slot** - ad Slot Id
* **ap_adTitle** - ad title
* **ap_adDescription** - ad description
* **ap_adIcon** - ad icon
* **ap_adScreenshot** - ad image
* **ap_adVideo** - ad vide(APAdNativeVideoView)
* **ap_adPresentLandingController** -  The root view controller for handling ad actions.

### Register clickable view
`APAdNative`

```ObjectiveC
- (BOOL)registerContainerView:(__kindof UIView *)view;
```
* **view** - Register the container view of the native ad, must pass parameters

#### Set deeplink tip
If this method is not called, the deeplink alert will not show
```Objectivec
[nativeAd setDeeplinkTipWithTitle:<NSString>];
```

## APAdNativeVideoView - methods


| Method	|	Feature | Note |
| ---	|	--- | --- |
| `- (void) setMute:(BOOL)mute;`	|	Mute player |mute: `YES`mute on，`NO`：mute off |
| `- (void) play;`	|	Play video | |
| `- (void) pause;`	|	Pause video | |
| `- (void) setRepeat:(BOOL)repeat;`	|	Auto repeat |repeat: `YES`auto repeat，`NO`no repeat |

# Delegates

## `APAdNativeDelegate`

```Objectivec
@optional

/**
 * Native ad slot loaded successfully.
 * @param ad : the ad for native
 */
- (void) apAdNativeDidLoadSuccess:(nonnull APAdNative *)ad;

/**
 * Native ad slot failed to load.
 * @param ad : the ad for native
 * @param err : the reason of error
 */
- (void) apAdNativeDidLoadFail:(nonnull APAdNative *)ad withError:(nonnull NSError *)err;

/**
 * Native ad is clicked.
 * @param ad : the ad for native
 */
- (void) apAdNativeDidClick:(nonnull APAdNative *)ad;

/**
 * Native ad landing page is presented.
 * @param ad : the ad for native
 */
- (void) apAdNativeDidPresentLanding:(nonnull APAdNative *)ad;

/**
 * Native ad landing page is dismissed.
 * @param ad : the ad for native
 */
- (void) apAdNativeDidDismissLanding:(nonnull APAdNative *)ad;

/**
 * After ad is clicked, native ad will enter background.
 * @param ad : the ad for native
 */
- (void) apAdNativeApplicationWillEnterBackground:(nonnull APAdNative *)ad;

```

## `APAdNativeVideoViewDelegate`

```Objectivec
@optional
// Video playback status changes
// @param view NativeVideo View
// @param state APAdNativeVideoState
- (void) apAdNativeVideoView:(nonnull APAdNativeVideoView *)view didChangeState:(APAdNativeVideoState)state;

// Video finishes
// @param view NativeVideo View
- (void) apAdNativeVideoViewDidPlayFinish:(nonnull APAdNativeVideoView *)view;
```

### `APAdNativeVideoState`
| State	|	Description |
| ---	|	--- |
| `APAdNativeVideoStateDefault`	|	video default state |
| `APAdNativeVideoStateFailed`	| video play failed |
| `APAdNativeVideoStateBuffering`	|	video buffering |
| `APAdNativeVideoStatePlaying`	|	video playing |
| `APAdNativeVideoStateStop`	|	video playback stopped |
| `APAdNativeVideoStatePause`	|	video playback paused |


# <a name="errorCode">SDK Error Code</a>

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

# <a name="cocos2d">cocos2d-x present ad crash</a>
Please check if there is the following code in `AppController`, please add it.
```Objective-c
@property(nonatomic, readonly) UIWindow* window;
```
