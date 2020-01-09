> [English Doc](https://github.com/KATracking/KATrackingAd/blob/master/AppicAd_SDK_iOS/README_EN.md)
# 当前版本 Ver 4.0

[更新日志](https://github.com/KATracking/KATrackingAd/blob/master/AppicAd_SDK_iOS/ReleaseNote.md)


* [概要](#Overview)
* [【推荐】Cocoapods集成](#cocoapods)
* [手动集成](#manually)
* [白名单设置](#whitelist)
* [允许http连接](#ats)
* [获取SDK对接Demo](#demo)
* [SDK初始化](#initialization)
* [接入 开屏广告-Splash](#splash)
* [接入 原生广告-Native](#native)
* [SDK错误码](#errorCode)
* [cocos2d-x播放广告崩溃问题](#cocos2d)

# <a name="Overview">概要</a>
本文描述了iOS开发者如何集成SDK，SDK提供了两种广告形式，包括：Splash(开屏广告)、Native(原生广告)
# 接入说明
## 获取账号信息
#### AppId - 应用标识
在初始化的时候需要使用，请联系运营人员获取。

## 要求
- iOS 9.0+
## 获取SDK
我们提供两种方式去集成iOS SDK：使用Cocoapods和手动添加方式。
>我们推荐使用cocoapods进行sdk管理

## <a name="cocoapods">使用CocoaPods</a>
1. 安装[CocoaPods](https://guides.cocoapods.org/using/getting-started.html)
2. 执行 `pod repo update`，从而让 CocoaPods 更新至目前最新可用的 AppicSDK 版本；
3. 修改Podfile文件，将`pod 'AppicSDK', '~> 4.0'`添加到Podfile中，如下所示：
```ruby
platform :ios, '9.0'
use_frameworks!

target 'MyApp' do
    pod 'AppicSDK', '~> 4.0'
end
```
4. 执行`pod initall`;
5. 使用由 CocoaPods 生成的 `.xcworkspace` 文件来编写工程。
## <a name="manually">手动集成</manually>
### 导入SDK
* AppicSDK [下载链接](https://img.atomhike.com/sdk/Mediation/KASDK/APSDK.v3.10.5.9.zip)

下载SDK后，将`APSDK.framework`文件拖入工程即可，升级SDK时，需要替换更新`APSDK.framework`
拖入时，请按以下方式选择：
![XcodeSetting](https://github.com/KATracking/KATrackingAd/blob/master/README_Res/XcodeSetting4.png)

### Xcode编译选项设置

* Build Settings中Other Linker Flags 增加参数`-ObjC`
具体操作如图：
![objc](https://github.com/KATracking/KATrackingAd/blob/master/README_Res/objc4.png)

#### 添加依赖库
工程需要在TARGETS -> Build Phases中找到Link Binary With Libraries，点击“+”，依次添加下列依赖库
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

# <a name="whitelist">info.plist设置白名单</a>
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

# <a name="ats">允许http连接的操作</a>
在工程的 Info.plist 文件中，设置 App Transport Security Settings 选项下 Allow Arbitrary Loads 值为 YES，对应 plist 内容为:
```xml
<key>NSAppTransportSecurity</key>
<dict>
    <key>NSAllowsArbitraryLoads</key>
    <true/>
</dict>
```
具体操作如图：
![ats](https://github.com/KATracking/KATrackingAd/blob/master/README_Res/ats4.png)

# <a name="demo">获取SDK对接Demo</a>
[下载链接](https://github.com/KATracking/KATrackingAd/blob/master/KATrackingAd_iOS_new/Demo.zip)
Demo中已经配置了对所有第三方sdk的依赖库的引用，请按照上面的步骤安装cocoapods，并在工程路径执行`pod install`命令进行sdk安装，安装之后即可运行。

# <a name="initialization">SDK初始化</a>
请在应用生命周期尽可能早的步骤中启动SDK初始化，这样SDK可以尽快开始预加载广告。
在`AppDelegate`中初始化SDK

```Objectivec
#import <APSDK/APPch.h>
```

```objectivec
- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    // SDK初始化
    [[APSDK sharedInstance] initWithAppId:@"AppId"];
    return YES;
}
```
请向运营人员索取: **AppId** - 应用标识

# <a name="solash">开屏广告 - Splash</a>

#### 构建广告
创建一个开屏广告的实例：`APAdSplash`

```ObjectiveC
APAdSplash *splash = [[APAdSplash alloc] initWithSlot:@"SlotId" delegate:<Delegate>];
```
* **SlotId** - 广告位id，用于请求广告
* **Delegate** - id<APAdSplashDelegate> 实例，用于接收广告事件回调

#### 加载广告
调用下面方法加载广告

```Objectivec
[aplash load];
```

#### 展示广告
调用下面方法展示广告

```Objectivec
[aplash presentWithViewController:<Controller>];
```
* **Controller** - 用于展示开屏广告的UIViewController

#### 加载 & 展示广告
调用下面方法加载并展示开屏广告
`APAdSplash`

```Objective-c
[splash loadAndPresentWithViewController:<Controller>];
```
* **Controller** - 用于展示开屏广告的UIViewController
**注**:`loadAndPresent`与`load`不可同时使用。

#### 设置加载时间
调用下面方法设置广告加载时间，时长必须>=0，默认为3秒

```Objectivec
[aplash setSplashMaxLoadInterval:<NSTimeInterval>];
```

#### 设置广告显示时长
调用下面方法设置广告显示时长

```Objectivec
[splash setSplashShowInterval:<NSInteger>];
```

#### 设置背景颜色
调用下面方法设置广告背景颜色，默认：黑色。
```Objectivec
[splash setSplashBackgroundColor:<UIColor>];
```

#### 设置背景图片
调用下面方法设置广告背景图片，默认：不显示。
```Objectivec
[splash setSplashBackgroundImage:<UIImage>];
```
**注** :`背景颜色`和`背景图片`同时使用时，背景图片会覆盖背景颜色

#### 设置广告关闭按钮视图
调用下面方法自定义指定关闭按钮样式
```Objectivec
[splash setSplashCloseButtonView:<UIImage>];
```

#### 设置广告关闭按钮位置
调用下面方法自定义指定关闭按钮的位置
```Objectivec
[splash setSplashCloseButtonCenter:<CGPoint>];
```

#### 设置Deeplink弹窗
设置Deeplink弹窗 - 如果不调用此方法设置，则点击广告不弹窗，直接跳转目标应用。
```Objectivec
[splash setDeeplinkTipWithTitle:<NSString>];
```

#### 设置底部视图
可自定义设置底部视图。
```Objective-c
[splash setSplashBottomView:<UIView> autoFitForDisplay:<BOOL>];
```
**注**:`autoFitForDisplay`为 `NO`强制添加底部视图，为`YES`时将根据素材大小自动适配底部视图。
**注**:横屏模式下，此设置无效。

#### 获取广告视图
获取开屏广告view，可以自行添加到指定界面上进行展示。
```Objective-c
[splash getSplashView];
```

### 广告回调
使用以下回调接收加载广告的事件

`APAdSplashDelegate`

```ObjectiveC
@optional

// 当广告成功填充，并加载完成后触发此回调
// 调用load来加载广告时有效，loadAndPresent不触发此回调
- (void) apAdSplashDidLoadSuccess:(nonnull APAdSplash *)ad;

// 当广告填充或者加载失败后触发此回调
- (void) apAdSplashDidLoadFail:(nonnull APAdSplash *)ad withError:(nonnull NSError *)err;

// 当构建广告视图失败后触发
- (void) apAdSplashDidAssembleViewFail:(nonnull APAdSplash *)ad withError:(nonnull NSError *)err;

// 当广告成功展示后触发此回调
- (void) apAdSplashDidPresentSuccess:(nonnull APAdSplash *)ad;

// 当广告展示失败后触发此回调
- (void) apAdSplashDidPresentFail:(nonnull APAdSplash *)ad withError:(nonnull NSError *)err;

// 当广告被点击后触发此回调
- (void) apAdSplashDidClick:(nonnull APAdSplash *)ad;

// 当广告击后完成展示落地页
- (void) apAdSplashDidPresentLanding:(nonnull APAdSplash *)ad;

// 当广告加载完毕落地页后关闭落地页
- (void) apAdSplashDidDismissLanding:(nonnull APAdSplash *)ad;

// 当广告关闭落地页后将跳转出应用
- (void) apAdSplashApplicationWillEnterBackground:(nonnull APAdSplash *)ad;

// 当广告将已经被关闭后触发此回调
- (void) apAdSplashDidDismiss:(nonnull APAdSplash *)ad;

// 广告每展示1秒触发一次此回调
// 广告自动关闭前一定触发最后一次并且time = 0;
// @param time 广告展示停留剩余时间，单位：秒
- (void) apAdSplashDidPresentTimeLeft:(NSUInteger)time;
```

# <a name="native">原生广告 - NativeExpress </a>
### 构建广告
创建一个原生广告的实例
`APAdNativeExpress`

```Objectivec
APAdNativeExpress *nativeAd = [[APAdNativeExpress alloc] initWithSlot:@"SlotId" andDelegate:<Delegate>];
```
* **SlotId** - 广告位Id，用于请求广告
* **Delegate** - APAdNativeExpressDelegate 实例，用于接收请求广告的回调

### 加载广告
调用load方法来获取广告，并通过回调来判断广告是否请求成功
```Objective-c
[nativeAd load];
```

### 广告素材信息
下列参数包含了其他广告相关的素材信息，请在load请求成功后再调用相应素材

* **ap_slot** - 广告位的SlotId
* **ap_adTitle** - 广告文字标题
* **ap_adDescription** - 广告文字说明
* **ap_adIcon** - 广告图标图片的UIImage
* **ap_adScreenshot** - 广告大图的UIImage
* **ap_adVideo** - 广告视频的APAdNativeExpressVideoView
* **ap_adPresentLandingController** - 广告位展示落地页通过rootviewController进行跳转

### 注册可点击视图
`APAdNativeExpress`

```ObjectiveC
- (BOOL)registerContainer:(__kindof UIView *)view;
```
* **view** - 注册原生广告的容器视图，必传参数

#### 设置Deeplink弹窗
设置Deeplink弹窗 - 如果不调用此方法设置，则点击广告不弹窗，直接跳转目标应用。
```Objectivec
[nativeAd setDeeplinkTipWithTitle:<NSString>];
```

## APAdNativeExpressVideoView - 接口
原生广告视频素材元件对接接口

| 接口	|	说明 | 备注 |
| ---	|	--- | --- |
| `- (void) setMute:(BOOL)mute;`	|	设置播放器静音 |mute YES：开启静音，NO：关闭静音 |
| `- (void) play;`	|	开始播放视频 | |
| `- (void) pause;`	|	暂停播放视频 | |
| `- (void) setRepeat:(BOOL)repeat;`	|	设置播放器自动重播 |repeat YES：开启重播，NO：关闭重播 |


# 回调
使用以下回调接收加载广告成功和失败的事件
## `APAdNativeExpressDelegate`

```Objectivec
@optional

// 当广告成功填充，并加载完成后触发此回调
// @param ad 加载成功的原生广告
- (void) apAdNativeExpressDidLoadSuccess:(nonnull APAdNativeExpress *)ad;

// 当广告填充或者加载失败后触发此回调
// @param ad 加载成功的原生广告
// @param err 加载失败原因
- (void) apAdNativeExpressDidLoadFail:(nonnull APAdNativeExpress *)ad withError:(nonnull NSError *)err;

// 当广告被点击后触发此回调
// @param ad 被点击的原生广告
- (void) apAdNativeExpressDidClick:(nonnull APAdNativeExpress *)ad;

// 当广点击后完成展示落地页
// @param ad 展示成功的原生广告
- (void) apAdNativeExpressDidPresentLanding:(nonnull APAdNativeExpress *)ad;

// 当广告加载完毕落地页后关闭落地页
// @param ad 展示失败的原生广告
- (void) apAdNativeExpressDidDismissLanding:(nonnull APAdNativeExpress *)ad;

// 当广告关闭落地页后将跳转出应用
// @param ad 展示成功的原生广告
- (void) apAdNativeExpressApplicationWillEnterBackground:(nonnull APAdNativeExpress *)ad;

```

## `APAdNativeExpressVideoViewDelegate`

```Objectivec
@optional
// 当视频播放状态产生变化
// @param view 视频素材元件播放视图
// @param state 改变后的播放状态
- (void) apAdNativeExpressVideoView:(nonnull APAdNativeExpressVideoView *)view didChangeState:(APAdNativeExpressVideoState)state;

// 当视频播放完毕
// @param view 视频素材元件播放视图
- (void) apAdNativeExpressVideoViewDidPlayFinish:(nonnull APAdNativeExpressVideoView *)view;
```

### `APAdNativeExpressVideoState`
| 名称	|	备注 |
| ---	|	--- |
| `APAdNativeExpressVideoStateDefault`	|	视频初始化默认状态 |
| `APAdNativeExpressVideoStateFailed`	| 播放失败 |
| `APAdNativeExpressVideoStateBuffering`	|	视频缓冲中 |
| `APAdNativeExpressVideoStatePlaying`	|	视频播放中 |
| `APAdNativeExpressVideoStateStop`	|	视频播放停止 |
| `APAdNativeExpressVideoStatePause`	|	视频播放暂停 |






# <a name="errorCode">SDK错误码</a>

```Objectivec
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

# <a name="cocos2d">cocos2d-x播放广告崩溃问题</a>
请检查`AppController`中是否有如下代码，没有请加上试试
```Objective-c
@property(nonatomic, readonly) UIWindow* window;
```
