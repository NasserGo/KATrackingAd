> [English Doc](https://github.com/KATracking/KATrackingAd/blob/master/KATrackingAd_iOS_new/README_EN.md)
# 当前版本 Ver.3.10.5.5
[ReleaseNote](https://github.com/KATracking/KATrackingAd/blob/master/KATrackingAd_iOS_new/ReleaseNote.md)
# 接入说明

SDK可以通过下文提到的两种方式获取

* 通过CocoaPods获取并集成
* 通过直接下载ZIP压缩包获取并集成
* 注意：我们推荐使用cocoapods进行sdk管理，以下将介绍cocoapods的基本用法，如果没有相关经验请在命令行窗口中顺序执行以下命令


## 准备工作
如果你尚未安装CocoaPods请根据下述流程安装

### CocoaPods安装
`sudo gem install -n /usr/local/bin cocoapods --pre`

### CocoaPods公有仓库安装
`pod setup`

## 通过CocoaPods集成
* 在命令行窗口中切换当前工作路径，到你的Xcode工程文件所在目录  

`cd projectPath`

* 创建Podfile文件

`pod init`

* 用文本编译器打开Podfile文件，添加需要依赖的sdk库

`  pod 'AppicSDK'`  
`  pod 'AppicAppLovinSDK'`  
`  pod 'AppicAppsFlyerLib'`  
`  pod 'AppicGDT'`   
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

如果需要集成AdMob广告SDK，请查阅下文中的[注意事项](#admob_note)

`  pod 'AppicGoogleMobileAds'` 


* 在命令行窗口执行cocoapods安装命令  

`pod install`

* 用Xcode通过新生成的xcworkspace打开项目，编译测试。此时sdk已经集成完毕

### 更新SDK版本
* 当SDK版本时，需要首先在命令行窗口中更新cocoapods代码仓库  

`pod repo update`

* 在命令行窗口中切换当前工作路径，到你的Xcode工程文件所在目录  

`cd projectPath`

* 在命令行窗口中执行以下指令进行更新  

`pod update`

### 获取SDK对接Demo [下载链接](https://github.com/KATracking/KATrackingAd/blob/master/KATrackingAd_iOS_new/Demo.zip)
Demo中已经配置了对所有第三方sdk的依赖库的引用，请按照上面的步骤安装cocoapods，并在工程路径执行`pod install`命令进行sdk安装，安装之后即可运行。

## 下载SDK压缩包进行集成
* 如果使用cocoapods方式集成，则不用手动下载sdk。
* 如果使用手工集成，请通过以下链接下载对应版本的sdk
  
#### 广告SDK依赖库
* AppicSDK [下载链接](https://img.atomhike.com/sdk/Mediation/KASDK/APSDK.v3.10.5.5.zip)

#### 广告平台依赖库
* AppicInMobiSDK [下载链接](https://img.atomhike.com/sdk/Mediation/InMobiSDK/InMobiSDK.v7.3.0.zip)
* AppicGoogleMobileAds [下载链接](https://img.atomhike.com/sdk/Mediation/GoogleMobileAds/GoogleMobileAds.v7.52.0.zip)
* AppicUnityAds [下载链接](https://img.atomhike.com/sdk/Mediation/UnityAds/UnityAds.v3.3.0.zip)
* AppicVungleSDK [下载链接](https://img.atomhike.com/sdk/Mediation/VungleSDK/VungleSDK.v0.0.4.zip)
* AppicAppLovinSDK [下载链接](https://img.atomhike.com/sdk/Mediation/AppLovinSDK/AppLovinSDK.v0.0.4.zip)
* AppicIronSource [下载链接](https://img.atomhike.com/sdk/Mediation/IronSource/IronSource.v6.10.0.0.zip)
* Appictoutiao [下载链接](https://img.atomhike.com/sdk/Mediation/toutiao/toutiao.v2.4.6.3.999.zip)
  * BUAdSDK.framework
  * BUAdSDK.bundle
* AppicGDT [下载链接](https://img.atomhike.com/sdk/Mediation/GDT/GDT.v4.10.13.zip)
  * libGDTMobSDK.a
* AppicTalkingData (选加，如果需要APSDK对接TD作为统计框架）[下载链接](https://img.atomhike.com/sdk/Mediation/TalkingData/TalkingData.v0.0.4.zip)
  * libTalkingData.a
* AppicUM (选加，如果需要APSDK对接UM作为统计框架）[下载链接](https://img.atomhike.com/sdk/Mediation/UM/UM.v0.0.4.zip)   
  * UMAnalytics.framework
  * UMCommon.framework
* AppicFirebase (选加，如果需要APSDK对接Firebase作为统计框架））[download path](https://img.atomhike.com/sdk/Mediation/Firebase/Firebase.v5.18.0.zip)   
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
* AppicAppsFlyerLib (选加，如果需要KASDK对接AppsFlyer作为统计框架) [下载链接](https://img.atomhike.com/sdk/Mediation/AppsFlyerLib/AppsFlyerLib.v0.0.4.zip)
* AppicFBAudienceNetwork [下载链接](https://img.atomhike.com/sdk/Mediation/FBAudienceNetwork/FBAudienceNetwork.v5.6.0.zip)
* AppicAdjustSdk [下载链接](https://img.atomhike.com/sdk/Mediation/AdjustSdk/AdjustSdk.v4.17.1.zip)
* BaiduSDK [下载链接](https://img.atomhike.com/sdk/Mediation/BaiduSDK/BaiduSDK.v4.64.zip)
   
### <a name="admob_note">接入admob注意事项</a>

```XML
<key>GADApplicationIdentifier</key>
<string>appId</string>
<key>GADIsAdManagerApp</key>
<true/>
```

![deployment target](https://github.com/KATracking/KATrackingAd/blob/master/README_Res/google_tips.png)
![deployment target](https://github.com/KATracking/KATrackingAd/blob/master/README_Res/google_tips_1.png)

### 加入其它依赖库
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
* ImageIO.framework（如果以上依赖库增加完仍旧报错，请添加ImageIO.framework）

### info.plist设置白名单
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


### 设置Deployment Target : iOS 8.0
![deployment target](https://github.com/KATracking/KATrackingAd/blob/master/README_Res/ios_deployment_target.png)

### 添加 -ObjC linker flag
![linker flag](https://github.com/KATracking/KATrackingAd/blob/master/README_Res/linker_flag.png)

### 设置 ATS
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

## 开始接入

### SDK 初始化
请在应用生命周期尽可能早的步骤中启动SDK初始化，这样SDK可以尽快开始预加载广告。

`AppDelegate`

```Objective-c
#import <APSDK/APPch.h>
```
`AppDelegate : application:didFinishLaunchingWithOptions:`

```Objective-c
[[APSDK sharedInstance] initWithAppId:@"<AppId>"];
```
请向运营人员索取

* **AppId** - 应用标识

### 重要！！！3.9.0以前的版本升级后请以"AppId-AppChannel"的形式传入SDK的初始化方法

# 原生模板广告 - NativeExpress
APAd
### 构建广告
创建一个原生模板广告的实例
`APAdNativeExpress`

```Objective-c
APAdNativeExpress *ad = [[APAdNativeExpress alloc] initWithSlot:<AdSlot> delegate:<Delegate>];
```
* **AdSlot** - 广告位SlotId，用于请求广告
* **Delegate** - id<APAdNativeDelegate> 实例，用于接收请求广告的回调

### 加载广告
调用load或loadWithoutCache方法来获取广告，并通过回调来判断广告是否请求成功
`APAdNativeExpress`

```Objective-c
此方法需要ka_adIcon和ka_adScreenShots来获取图片素材
[ad load];
```

### 广告素材信息
下列参数包含了其他广告相关的素材信息，请在load请求成功后再调用相应素材

* **ka_slot** - 广告为的SlotId
* **ka_adTitle** - 广告文字标题
* **ka_adDescription** - 广告文字说明
* **ka_adIcon** - 广告图标图片的UIImage
* **ka_adScreenShots** - 广告大图的UIView
* **ka_VideoAdView** - 广告视频的UIView

### rootviewController
`APAdNativeExpress`

```Objective-c
[ad setRootViewController:<controller>]
```

* **controller** - 广告位展示落地页通过rootviewController进行跳转，必传参数

### 注册可点击视图
`APAdNativeExpress`

```Objective-c
- (BOOL)registerContainer:(__kindof UIView *)containerView
```
* **containerView** - 注册原生广告的容器视图，必传参数

### 回收素材
当广告素材被从展示界面中移除后，请调用以下方法来回收素材
`APAdNativeExpress`

```Objective-c
[ad recyclePrimaryView];
```

### 广告回调
使用以下回调接收加载广告成功和失败的事件
`APAdNativeExpressDelegate`

```Objective-c
广告请求成功
- (void) nativeExpressAdRequestCompletedWithAd:(nonnull APAdNativeExpress *)nativeAd;

广告请求失败
- (void) nativeExpressAdRequestFailedWithAd:(nonnull APAdNativeExpress *)nativeAd
                                 withStatus:(nonnull NSError *)nativeAdStatus;

@optional

广告点击
- (void) nativeExpressAdDidClicked:(nonnull APAdNativeExpress *)native;

广告落地页展示
- (void) nativeExpressAdDidPresentScreen:(nonnull APAdNativeExpress *)nativeAd;

广告落地页关闭
- (void) nativeExpressAdDidDismissScreen:(nonnull APAdNativeExpress *)nativeAd;
```


# 开屏广告 - Splash

### 构建广告
创建一个开屏广告的实例
`APAdSplash`

```Objective-c
APAdSplash *splash = [[APAdSplash alloc] initWithSlot:<AdSlot> delegate:<Delegate>];
```
* **AdSlot** - 广告位SlotId，用于请求广告
* **Delegate** - id<APAdSplashDelegate> 实例，用于接收广告事件回调

### 设置加载时间
调用下面方法设置广告加载时间

```Objective-c
[aplash setTolerateTimeout:<NSTimeInterval>];
```

### 设置显示时长
调用下面方法设置广告显示时长

```Objective-c
[splash setShowInterval:<NSInteger>];
```

### 展示广告
调用下面方法加载并展示开屏广告
`APAdSplash`

```Objective-c
[splash loadAndPresentWithViewController:<Controller>];
```
* **Controller** - 用于展示开屏广告的UIViewController

### 暂停展示广告
使用以下方法来暂停展示广告，在load到开始展示的这段时间里，你认为不再适合展示开屏广告，可以调用此方法来暂停展示
`APAdSplash`

```Objective-c
[splash suspend];
```

### 展示广告并添加产品标识
调用下面方法加载并展示开屏广告，同时可以添加产品自定的标识View，用于填充当由于素材尺寸不足填充全屏情况下的空白位置
`APAdSplash`

```Objective-c
[splash loadAndPresentWithViewController:<Controller> andBackgroundColor:<Color> andBottomView:<View> andBottomViewAutoFitDisplay:<Auto>];
```

* **Controller** - 用于展示开屏广告的UIViewController
* **Color** - 标识填充区的背景颜色
* **View** - 用于展示在标识填充区的UIView
* **Auto** - 当希望SDK自动根据尺寸适应是否展示标识View的时候传入Yes, 否则传入No将始终显示标识View

### 标识区可用尺寸
调用下面方法来根据不同设备计算可以用于标识区的View大小
`APAdSplash`

```Objective-c
CGSize size = [APAdSplash getBottomViewSize];
```

### 广告回调
使用以下回调接收加载广告的事件

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

# 插屏广告 - Interstitial

### 构建广告
创建一个插屏广告的实例
`APAdInterstitial`

```Objective-c
APAdInterstitial *interstitial = [[APAdInterstitial alloc] initWithSlot:<AdSlot> delegate:<Delegate>];
```
* **AdSlot** - 广告位SlotId，用于请求广告
* **Delegate** - id<APAdInterstitialDelegate> 实例，用于接收广告事件回调

请求并加载广告
`APAdInterstitial`

```Objective-c
[interstitial load];
```

检测广告是否已经可以使用
`APAdInterstitial`

```Objective-c
BOOL ready = [interstitial isReady];
```

### 展示广告
调用下面方法加载并展示开屏广告
`APAdInterstitial`

```Objective-c
[interstitial presentFromRootViewController:<Controller>];
```
* **Controller** - 用于展示插屏广告的UIViewController

### 广告回调
使用以下回调接收加载广告的事件

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

// Interstitial Ad has been dismissed from screen
- (void) interstitialAdDidDismiss:(nonnull APAdInterstitial *) interstitial;
```

# 激励视频广告 - Incentivized

### 如何使用
激励视频广告在SDK中为单例，因此无需在创建新的实例，可以直接使用类方法展示广告，视频广告在SDK初始化成功后立即开始自动加载。

检测广告是否已经可以使用
`APAdIncentivized`

```Objective-c
BOOL ready = [APAdIncentivized isReady];
```

### 展示广告
调用下面方法加载并展示极力视频广告
`APAdIncentivized`

```Objective-c
[APAdIncentivized presentFromRootViewController:<Controller>];
```
* **Controller** - 用于展示激励视频广告的UIViewController

### 广告回调
设置一个激励视频的回调实例
`APAdIncentivized`

```Objective-c
[APAdIncentivized setDelegate:<Delegate>];
```
* **Delegate** - id<APAdIncentivizedDelegate> 实例，用于接收广告事件回调

### 广告回调
使用以下回调接收加载广告的事件

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

# 横幅广告 - Banner

### 构建广告
创建一个横幅广告的实例并将广告加到视图上
`APAdBanner`

```Objective-c
APAdBanner * banner = [[APAdBanner alloc] initWithSlot:<adSlot> withSize:<size> delegate:<delegate> currentController:<controller>];
[self.view addSubview:banner];
```
* **adSlot** - 广告位SlotId，用于请求广告
* **Size** - 广告尺寸<APAdBannerSize>枚举
* **Delegate** - id<APAdBannerDelegate> 实例，用于接收广告事件回调
* **controller** - 用于点击横幅广告后展示广告页的UIViewController

设置广告轮换的时间间隔，当该值小于等于0时广告不轮换
`APAdBanner`

```Objective-c
[banner setInterval:<NSInteger>];
```

请求并加载广告
`APAdBanner`

```Objective-c
[banner load];
```

设置广告的位置
`APAdBanner`
```Objective-c
[banner setPosition:<point>];
```

* **point** - 设置广告的中心点坐标

### 广告回调
使用以下回调接收加载广告的事件

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

### 兑换码

输入兑换码兑换礼物

`KAPub`

```Objective-c
[KAPub redeemCode:<code> withDelegate:<Delegate>]
```
* **code** - 兑换码 (相关配置请联系运营人员获取)
* **Delegate** - id<KAPubConfigManagerDelegate>实例，用于接收兑换是否成功

使用以下回调接收兑换事件

`KAPubConfigManagerDelegate`

```Objective-c
/**
 * 将成功兑换回的数据包返回给代理进行处理,并返回对应的兑换码
 */
- (void) redeemCodeSuccessWithData:(NSDictionary *)data withCode:(NSString *)code;
/**
 * 兑换失败，返回错误码和对应的兑换码
 */
- (void) redeemCodeFailedWithError:(NSError *)error withCode:(NSString *)code;
```
### 支付
`KAPub`

支付

```Objective-c
[KAPub payWithIAPId:<iapId> withOrderId:<orderId> withDelegate:<Delegate>]
```
恢复购买

```Objective-c
[KAPub restoreCompletedTransactionsWithDelegate:<Delegate>]
```


* **iapId** - 平台计费点
* **orderId** - 订单Id（请保证每次传入的订单Id为唯一Id）
* **Delegate** - id<KAPubConfigManagerDelegate>实例，用于接收是否支付成功

使用以下回调接收支付事件

`KAPubConfigManagerDelegate `

```Objective-c
/**
 * 支付成功并返回平台计费点id
 */
- (void)paymentSuccessWithIapId:(NSString *)iapId;
/**
 * 支付失败返回平台计费点id和错误信息
 */
- (void)paymentFailedIapId:(NSString *)iapId withErrorInfo:(NSError *)error;
/**
 * 恢复购买失败
 */
- (void)restorePaymentFailed;
/**
 * 恢复购买成功并返回Apple计费点id
 */
- (void)restorePaymentSuccessWithIdentifier:(NSString *)iapId;
```

### PUSH


`KAPub`

在`UIApplicationDelegate`的代理方法中获取deviceToken

```Objective-cAPAd
- (void)application:(UIApplication *)application didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken
{
	[KAPub setDeviceToken:deviceToken];
} 

- (void)application:(UIApplication *)application didReceiveRemoteNotification:(NSDictionary *)userInfo
{
    [KAPub handlePushMessage:userInfo];
}
```

### SDK错误码

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

### cocos2d-x播放广告崩溃问题
请检查`AppController`中是否有如下代码，没有请加上试试
```Objective-c
@property(nonatomic, readonly) UIWindow* window;
```
