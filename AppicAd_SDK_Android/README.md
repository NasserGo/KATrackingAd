> [English Doc](https://github.com/KATracking/KATrackingAd/blob/master/AppicPlayAD_Android/README_EN.md)
# 当前版本 Ver 4.0

[更新日志](https://github.com/KATracking/KATrackingAd/blob/master/AppicAd_SDK_Android/ReleaseNote.md)

# AppicAd SDK接入说明

* [关于](#about)
* [基础SDK接入](#essential)
* [接入原生广告](#nativeAD)
* [接入开屏广告](#splashAD)
* [关于权限申请](#permissions)
* [其他](#others)


## <a name="about">关于</a>

* 支持广告类型：**开屏**、**原生**
* 下载 [AppicAd SDK](http://sayhey.oss-cn-shanghai.aliyuncs.com/sdk/android/APSDK_v3.7.2.9.aar)
* 下载 [android-gif-drawable-1.2.6.aar](https://github.com/KATracking/KATrackingAd/tree/master/AppicPlayAD_Android/android-gif-drawable-1.2.6.aar)
* 下载 [Demo](https://github.com/KATracking/KATrackingAd/tree/master/AppicPlayAD_Android/android-gif-drawable-1.2.6.aar)

## <a name="essential">基础SDK接入</a>

* 接入工程的`app module`的`build.gradle`中添加依赖：

	```
	  implementation 'com.android.volley:volley:1.1.0'
    implementation 'com.android.support:support-v4:26.1.0'
    implementation(name: 'android-gif-drawable-1.2.6', ext: 'aar')

	```

* `applicaton `或入口activity 的`onCreate`回调方法中执行初始化

	```
	APSDK.init(context, "appID");
	```
	**注**:`appID`的值将在您接入sdk时由我方相关对接人员提供。

* `applicaton`的`getBaseContext`方法修改：

	```
	@Override
    public Context getBaseContext() {
        return APApplication.getBaseContext(super.getBaseContext());
    }
	```

* `proguard`配置：

	```
	-keep class * extends com.ap.android.atom.sdk.core.base.ad.Ad
	-keep class * extends com.ap.android.atom.sdk.core.base.ad.AdSDK
	-keep class * implements com.ap.android.atom.sdk.core.base.lifecycle.IApplicationLifecycle
	```

## <a name="nativeAD">接入原生广告 - NativeExpress</a>
1. **创建原生广告实例：**

	```java
	APAdNativeExpress apNative = new APAdNativeExpress("slotID", listener);
	```
	| 参数	|	说明 |
	| ---	|	--- |
	| activity	|	创建该实例所处的activity |
	| slotID	|	广告位id |
	| listener	|	原生广告加载结果回调 |

1. **广告load：**

	```java
	apNative.load();
	```
1. **加载成功后（收到加载成功的回调），从APNative实例中获取广告相关内容：**

	| 说明	|	方法 | 备注 |
	| ---	|	--- | --- |
	| icon	|	`getAPAdIcon()` | |
	| image	|	`getAPAdScreenshot()` | |
	| 描述文字	|	`getAPAdDescription()` | |
	| 标题文字	|	`getAPAdTitle()` ||
	| 广告视频	|	`getAPAdVideo()` |可以通过此方法的返回值判断广告是否为`视频类型`，非视频返回`null`|

1. **接口-注册容器**
```java
public boolean registerContainerView(ViewGroup view);
```

5. **接口-设置Deeplink弹窗**
设置Deeplink弹窗 - 如果不调用此方法设置，则点击广告不弹窗，直接跳转目标应用。
```java
public void setDeeplinkTipWithTitle(String title);
```

### Listener
**`APAdNativeExpressListner`**

```java
// 当广告成功填充，并加载完成后触发此回调
// @param ad 加载成功的原生广告
public void onApAdNativeExpressDidLoadSuccess(APAdNativeExpress ad);

// 当广告填充或者加载失败后触发此回调
// @param ad 加载成功的原生广告
// @param err 加载失败原因
public void onApAdNativeExpressDidLoadFail(APAdNativeExpress ad, APAdError err);

// 当广告被点击后触发此回调
// @param ad 被点击的原生广告
public void onApAdNativeExpressDidClick(APAdNativeExpress ad);

// 当广点击后完成展示落地页
// @param ad 展示成功的原生广告
public void onApAdNativeExpressDidPresentLanding(APAdNativeExpress ad);

// 当广告加载完毕落地页后关闭落地页
// @param ad 展示失败的原生广告
public void onApAdNativeExpressDidDismissLanding(APAdNativeExpress ad);

// 当广告点击后将跳转出应用
// @param ad 展示成功的原生广告
public void onApAdNativeExpressApplicationWillEnterBackground(APAdNativeExpress ad);
```
**`APAdNativeExpressVideoView`**
```java
// 当视频播放完毕
// @param view 视频素材元件播放视图
public void onApAdNativeExpressVideoViewDidPlayFinish(APAdNativeExpressVideoView view);
```

**`APAdNativeExpressVideoState`**
| 名称	|	备注 |
| ---	|	--- |
| `APAdNativeExpressVideoStateDefault`	|	视频初始化默认状态 |
| `APAdNativeExpressVideoStateFailed`	| 播放失败 |
| `APAdNativeExpressVideoStateBuffering`	|	视频缓冲中 |
| `APAdNativeExpressVideoStatePlaying`	|	视频播放中 |
| `APAdNativeExpressVideoStateStop`	|	视频播放停止 |
| `APAdNativeExpressVideoStatePause`	|	视频播放暂停 |



## <a name="splashAD">接入开屏广告 - APAdSplash</a>
1. **创建开屏广告实例**：

	```java
	APAdSplash splash = new APAdSplash(slotID,listener);
	```

	| 参数	|	说明 |
	| --- | --- |
	| slotID	|	广告位id |
	| listener	|	开屏广告加载、展示、关闭等的结果回调 |



	### 加载广告
	调用下面方法加载广告

	```java
	public void load();
	```

	#### 展示广告
	调用下面方法展示广告

	```java
	public void presentWithViewContainer(ViewGroup container);
	```
	* **ViewGroup** - 用于展示开屏广告

	#### 加载 & 展示广告
	调用下面方法加载并展示开屏广告
	`APAdSplash`

	```java
	public void loadAndPresentWithViewContainer(ViewGroup container);
	```
	* **ViewGroup** - 用于展示开屏广告
	**注**:`loadAndPresent`与`load`不可同时使用。

	#### 设置加载时间
	调用下面方法设置广告加载时间，时长必须>=0，默认为3秒

	```java
	public boolean setSplashMaxLoadInterval(int interval); //单位秒
	```

	#### 设置广告显示时长
	调用下面方法设置广告显示时长

	```java
	public boolean setSplashShowInterval(int interval); //单位秒
	```

	#### 设置背景颜色
	调用下面方法设置广告背景颜色，默认：黑色。
	```java
	public void setSplashBackgroundColor(int color);
	```

	#### 设置背景图片
	调用下面方法设置广告背景图片，默认：不显示。
	```java
	public void setSplashBackgroundColor(Bitmap image);
	```
	**注** :`背景颜色`和`背景图片`同时使用时，背景图片会覆盖背景颜色

	#### 设置广告关闭按钮视图
	调用下面方法自定义指定关闭按钮样式
	```java
	public void setSplashCloseButtonView(View view);
	```

	#### 设置广告关闭按钮位置
	调用下面方法自定义指定关闭按钮的位置
	```java
	public void setSplashCloseButtonPosition(ViewGroup.LayoutParams params);
	```

	#### 设置Deeplink弹窗
	设置Deeplink弹窗 - 如果不调用此方法设置，则点击广告不弹窗，直接跳转目标应用。
	```java
	public void setDeeplinkTipWithTitle(String title);
	```

	#### 设置底部视图
	可自定义设置底部视图。
	```java
	public void setSplashBottomLayoutView(ViewGroup view, boolean autofit);
	```
	**注**:`autofit`为 `NO`强制添加底部视图，为`YES`时将根据素材大小自动适配底部视图。
	**注**:横屏模式下，此设置无效。

	#### 获取广告视图
	获取开屏广告view，可以自行添加到指定界面上进行展示。
	```java
	public View getSplashView();
	```

	### 广告回调
	使用以下回调接收加载广告的事件

	`APAdSplashListener`

	```java
	// 当广告成功填充，并加载完成后触发此回调
	public void onAPAdSplashLoadSuccess(APAdSplash ad);

	// 当广告填充或者加载失败后触发此回调
	public void onAPAdSplashLoadFail(APAdSplash ad, APAdError err);

	// 当构建广告视图失败后触发
	public void onAPAdSplashDidAssembleViewFail(APAdSplash ad, APAdError err);

	// 当广告成功展示后触发此回调
	public void onAPAdSplashPresentSuccess(APAdSplash ad);

	// 当广告成功展示失败后触发此回调
	public void onAPAdSplashPresentFail(APAdSplash ad, APAdError err);

	// 当广告被点击后触发此回调
	public void onAPAdSplashClick(APAdSplash ad);

	// 当广告被点击后完成展示落地页
	public void onApAdSplashDidPresentLanding(APAdSplash ad);

	// 当广告加载完毕落地页后关闭落地页
	public void onApAdSplashDidDismissLanding(APAdSplash ad);

	// 当广点关闭落地页后将跳转出应用
	public void onApAdSplashApplicationWillEnterBackground(APAdSplash ad)

	// 当广告将已经被关闭后触发此回调
	public void onAPAdSplashDismiss(APAdSplash ad);

	// 广告每展示1秒触发一次此回调
	// 广告自动关闭前一定触发最后一次并且time = 0;
	// @param time 广告展示停留剩余时间，单位：秒
	public void onAPAdSplashPresentTimeLeft(int time);
	```



## <a name="permissions">关于权限申请</a>

* sdk需要动态申请的权限：`android.permission.READ_PHONE_STATE`、`android.permission.WRITE_EXTERNAL_STORAGE`

* sdk在初始化（执行方法：`APAD.init(context,appID,channelID)`）时默认会申请所需要的权限（要保证传递的`context`参数为`Activity`类型）

* 调用方法：`APCore.setAutoRequestPermission(false)`可以让sdk在初始化时候不自动申请所需权限。


## <a name="others">其他</a>

* 如果想在用户在非wifi环境时点击下载类型广告时进行弹窗提醒，那么可以使用方法：`APAD.setIsMobileNetworkDirectlyDownload(boolean)`进行设置，如果不进行设置，那么默认为`true`（亦即在非wifi环境下点击下载类广告时不进行提示而直接下载）。**由于部分广告平台未提供设置方法，所以该设置只在部分广告平台上生效。**
* 支持架构：只支持：armeabi-v7a, armeabi, arm64-v8a
