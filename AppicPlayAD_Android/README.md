> [English Doc](https://github.com/KATracking/KATrackingAd/blob/master/AppicPlayAD_Android/README_EN.md)
# 当前版本Ver.3.7.2.6 [ReleaseNote](https://github.com/KATracking/KATrackingAd/blob/master/AppicPlayAD_Android/ReleaseNote.md)
# AppicAd SDK接入说明

* [关于](#about)
* [基础SDK接入](#essential)
* [加入第三方平台SDK](#thirdPartySDK)
* [加入第三方归因平台SDK](#thirdPartyTrackSDK)
* [接入原生广告](#nativeAD)
* [接入开屏广告](#splashAD)
* [接入插屏广告](#interstitialAD)
* [接入横幅广告](#bannerAD)
* [接入激励视频广告](#videoAD)
* [接入任务墙](#wall)
* [关于权限申请](#permissions)
* [其他](#others)


## <a name="about">关于</a>

* 支持广告类型：**原生**、**开屏**、**插屏**、**横幅**、**激励视频**
* 下载[AppicAd SDK](http://sayhey.oss-cn-shanghai.aliyuncs.com/sdk/android/APSDK_v3.7.2.6.aar)

## <a name="essential">基础SDK接入</a>

* 接入工程的`app module`的`build.gradle`中添加依赖：

	```
	implementation 'com.android.volley:volley:1.1.0'
    implementation 'com.android.support:support-v4:26.1.0'
    implementation(name: 'com.liulishuo.filedownload-v1.7.4', ext: 'aar')
    implementation(name: 'android-gif-drawable-1.2.6', ext: 'aar')
    
	```
	点击下载：[android-gif-drawable-1.2.6.aar](https://github.com/KATracking/KATrackingAd/tree/master/AppicPlayAD_Android/android-gif-drawable-1.2.6.aar)、[com.liulishuo.filedownload-v1.7.4.aar](https://github.com/KATracking/KATrackingAd/tree/master/AppicPlayAD_Android/com.liulishuo.filedownload-v1.7.4.aar)
		
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

## <a name="thirdPartySDK">加入第三方平台SDK</a>
* 受支持的第三方平台sdk在[这里](https://github.com/KATracking/KATrackingAd/tree/master/AppicPlayAD_Android/ThirdParyADLibs)查看
* `inmobi `文件夹内包含接入`inmobi`平台需要的所有配置，相应的：`gdt`对应`广点通`广告平台、`tt`对应`头条`广告平台、`unity`对应`unity`广告平台、`vungle`对应`vungle`广告平台、`admob`对应`admob`广告平台
* 第三方广告平台所需要的配置可能包含有：`jar、aar`依赖项（在`libs`文件夹内）、`build.gradle`文件中的依赖项（在`dependicies`文件夹内）、需要配置的权限（在`permissions`文件内）、`AndroidMnifest.xml`中需要添加的组件（`activity`、`service`、`receiver`、`provider`等内容）（在`components`文件内）、混淆配置项（在`proguard`文件内）、res资源文件项（在`res`文件夹内）
* 将需要支持的广告平台的所有内容加入到待接入工程中即可

## <a name="thirdPartyTrackSDK">加入第三方归因平台SDK</a>
* 受支持的第三方平台归因sdk在[这里](https://github.com/KATracking/KATrackingAd/tree/master/AppicPlayAD_Android/ThirdParyTrackLibs)查看
* 例如：`adjust` 文件夹内包含接入该平台需要的配置，目前有：`Adjust`、`AppsFlyer`、`TalkingData`、`toutiao(头条巨量引擎)`、`umeng(友盟)`
* 第三方归因平台所需要的配置可能包含有：`jar、aar`依赖项（在`libs`文件夹内）、`build.gradle`文件中的依赖项（在`dependicies`文件夹内）、需要配置的权限（在`permissions`文件内）、`AndroidMnifest.xml`中需要添加的组件（`activity`、`service`、`receiver`、`provider`等内容）（在`components`文件内）、混淆配置项（在`proguard`文件内）、res资源文件项（在`res`文件夹内）
* 将需要支持的归因平台的所有内容加入到待接入工程中即可

## <a name="nativeAD">接入原生广告</a>

**注**：原生广告有两种接入方式：`模板方式`、`非模板模式`，在`模板模式`下，原生广告会提供方法来很方便的获取一个`view`，同时该view会处理相应的touch事件，方便开发者接入。而在`非模板模式`下，需要开发者自行处理原生广告的布局，同时sdk会提供相应方法来处理开发者自行进行的广告布局的touch事件。

**注**：默认接入方式为：`模板方式`，可以通过调用方法：`apNativeInstance.setPattern(patternEnum)`来进行设置。

1. **创建原生广告实例：**

	```
	APNative apNative = new APNative(activity, "slotID", listener);
	```
	参数	|	说明
	---	|	---
	activity	|	创建该实例所处的activity
	slotID	|	广告位id
	listener	|	原生广告加载结果回调
1. **设置期望返回广告大图尺寸：**

	```
	apNative.setPreferImageSize(width,height)
	```
	**注**：实际返回图片尺寸可能与期望尺寸不同
1. **广告load：**

	```
	apNative.loadNative();
	```
1. **加载成功后（收到加载成功的回调），从APNative实例中获取广告相关内容：**

	说明	|	获取方法
	---	|	---
	icon地址	|	`getIconUrl`
	image地址	|	`getImageUrl`
	描述文字	|	`getDesc`
	标题文字	|	`getTitle`
	响应按钮的文字（可能包含的值：“查看详情”、“下载”等）	|	`getActionText`
	获取包含广告内容的view	|	`getExposureView`
	
1. **检查原生广告类型（是否视频）：**

	```
	apNative.isVideoTypeAD();
	```
	
1. **将广告内容添加到容器中：**

	使用方法：`getExposureView(viewContainer,viewWidth)`来获得待添加到广告容器中的view
	
	参数	|	说明
	---	|	---
	viewContainer	|	广告容器
	viewWidth	|	待展示view的宽度，如果传值`APNative.MATCH_PARENT`，那么宽将于`viewContainer`相同，否则将按实际传的值来设置view的宽（单位px），返回view的高度将按照广告物料宽高比自行设置
	
	**注**：返回的view并不会自动添加到`viewContainer`中，需自行处理。
	
1. **当原生广告由adContainer展示出来之后（可以被用户看到）：**

	调用方法：`apNative.show();`
1. **在创建广告实例的activity的以下回调方法中分别执行`APNative`实例的相应方法：**

	* `onPause`回调方法中执行：`apNative.onPause();`
	* `onResume`回调方法中执行：`apNative.onResume();`
	* `onDestroy`回调方法中执行：`apNative.onDestroy();`
1. **当不再需要APNative实例时执行：**

	```
	apNative.destroy();
	```
	**注**：广告展示时必须将`getExposureView `返回的view添加到容器中，其他内容（如`adTitle`、`adDesc`、`adIcon`，返回内容可能为`null`）由开发者自行决定是否展示以及如何展示。
	

## <a name="splashAD">接入开屏广告</a>
1. **创建开屏广告实例**：

	```
	APSplash splash = new APSplash(activity,slotID,listener);
	```

	参数	|	说明
	--- | ---
	activity	|	所处activity实例
	slotID	|	广告位id
	listener	|	开屏广告加载、展示、关闭等的结果回调
2. **加载&展示**

	```
	splash.loadAndPresent(splashViewContainer,bottomViewLayoutID);
	```
	
	参数	|	说明
	---	|	---
	splashViewContainer	|	承载广告内容的容器（容器类型为LinearLayout，要保证其`orientation`属性为`vertical`）
	bottomViewLayoutID	|	布局文件的id，如果广告平台返回的物料内容不足以填充全部广告容器，那么将由该布局填充，由于剩余空间高度不确定，请确保该布局能按高度自适应

3. **释放占用资源**
	
	开屏广告展示完毕之后，在合适的时机（绝对大多数情况应该是在展示开屏广告的activity的onDestroy回调方法中）调用方法：`splash.onDestroy()`

	
	
## <a name="interstitialAD">接入插屏广告</a>
1. **创建插屏实例**

	`APInterstitial apInterstitial = new APInterstitial(activity, "slotID", interstitialListener`
2. **设置期望尺寸**

	`apInterstitial.setPreferImageSize(width, height);`

3. **加载插屏**

	`apInterstitial.loadInterstitial();`
	
4. **展示插屏**

	`apInterstitial.show();`
	
5. **释放资源**

	在不需要改插屏实例时（每次插屏展示完毕，需要再次展示时需要重新创建插屏实例），需要调用方法：`apInterstitial.onDestroy();`来释放所占用的资源。

## <a name="bannerAD">接入横幅广告</a>

1. **创建横幅广告实例**

	`APBanner banner = new APBanner(activity, "slotID", listener);`
	
1. **加载广告**

	`banner.loadBanner(bannerContainer);`
	
	**注**：bannerContainer尺寸：300dp*50dp
	
1. **释放资源**

	在不需要该横幅广告实例时（一般情况下，应该是在创建该实例所处的`activity`的`onDestroy`方法回调时）,调用方法：`banner.onDestroy();`来释放该实例所占用的资源。
	
1. **隐藏banner**

	`banner.hide();`
	
1. **展示banner**

	`banner.show()`
	
	**注**：banner加载成功之后会立即显示，不需额外调用`show`方法，该方法对应于`hide`方法，用于在调用`hide`方法后，要继续显示banner时使用。
	

## <a name="videoAD">接入激励视频广告</a>

**注**：激励视频不同于其他广告形式，使用单例模式，无需创建额外实例。

1. **设置激励视频回调**

	`APIncentivized.setListener(apIncentivizedListener);`
	
1. **设置当前需要使用激励视频相关功能的activity**

	`APIncentivized.setActivity(currentActivity);`
	
1. **检查是否有可用的激励视频**

	`APIncentivized.isReady();`
	
1. **展示激励视频广告**

	`APIncentivized.showVideoAD(currentActivity);`
	

## <a name="wall">接入任务墙</a>

1. **展示任务墙**：

	`APWall.showWall(activity,listener);`

1. **回调说明**：

	方法	|	说明
	---	|	---
	onShowSuccess(wallID)	|	任务墙展示成功，`wallID`为展示的任务墙的id
	onShowFailed(wallID,errorMsg)	|	任务墙展示失败
	onJumpToApp(wallID,pkgName,rewardJson)	|	点击任务，跳到指定应用前回调该方法；`pkgName`为要跳转到应用的包名；`rewardJson`为`JSONObject`，内部字段由接入方提供，并由我方配置在任务墙后台，接入方根据该json决定完成该任务后具体给予用户什么奖励
	onBackToWall(wallID,pkgName,rewardJson)	|	从跳转应用回到任务墙之后回调该方法，参数含义同`onJumpToApp `，接入方应该在收到该回调时给予用户奖励
	onWallClosed	|	任务墙关闭
	
	


## <a name="permissions">关于权限申请</a>

* sdk需要动态申请的权限：`android.permission.READ_PHONE_STATE`、`android.permission.WRITE_EXTERNAL_STORAGE`

* sdk在初始化（执行方法：`APAD.init(context,appID,channelID)`）时默认会申请所需要的权限（要保证传递的`context`参数为`Activity`类型）

* 调用方法：`APCore.setAutoRequestPermission(false)`可以让sdk在初始化时候不自动申请所需权限。


## <a name="others">其他</a>

* 如果想在用户在非wifi环境时点击下载类型广告时进行弹窗提醒，那么可以使用方法：`APAD.setIsMobileNetworkDirectlyDownload(boolean)`进行设置，如果不进行设置，那么默认为`true`（亦即在非wifi环境下点击下载类广告时不进行提示而直接下载）。**由于部分广告平台未提供设置方法，所以该设置只在部分广告平台上生效。**
* 支持架构：只支持：armeabi-v7a, arm64-v8a
