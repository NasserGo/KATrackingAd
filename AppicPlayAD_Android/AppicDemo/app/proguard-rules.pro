-allowaccessmodification
# 是否使用大小写混合
-dontusemixedcaseclassnames
# 混淆时是否做预校验
-dontpreverify
# 屏蔽warning
-ignorewarnings
# 混淆时是否记录日志
-verbose
# 混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-dontwarn
-keepattributes InnerClasses,LineNumberTable,Exceptions,SourceFile
-renamesourcefileattribute SourceFile
-dontskipnonpubliclibraryclassmembers
# 是否混淆第三方jar

-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService
-keep class **.R$* {*;}
-keep class android.net.http.SslError
-keep class android.webkit.**{*;}
-keepclasseswithmembernames class * {
    native <methods>;
}
-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
-keepclassmembers class * {
   public <init>(org.json.JSONObject);
}
-keep class * extends android.os.AsyncTask { *;}

-keepnames class * implements java.io.Serializable
##support
-keep class android.support.**{*;}
-dontwarn android.support.**

#############################基本配置#############################

#gdt
-keep class com.qq.e.** { public protected *; }
-keep class android.support.v4.**{ public *; }
-keep class android.support.v7.**{ public *; }

#头条
-keep class com.bytedance.sdk.openadsdk.** { *; }
-keep class com.androidquery.callback.** {*;}
-keep class com.bytedance.sdk.openadsdk.service.TTDownloadProvider
-keep public interface com.bytedance.sdk.openadsdk.downloadnew.** {*;}
-keep class com.ss.sys.ces.* {*;}

#vungle
-keep class com.vungle.warren.** { *; }
-dontwarn com.vungle.warren.error.VungleError$ErrorCode
-keep class com.moat.** { *; }
-dontwarn com.moat.**
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn okio.**
-dontwarn retrofit2.Platform$Java8
-keepattributes Signature
-keepattributes *Annotation*
-dontwarn sun.misc.**
-keep class com.google.gson.examples.android.model.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
-keep class com.google.android.gms.internal.** { *; }
-dontwarn com.google.android.gms.ads.identifier.**


#inmobi
-keepattributes SourceFile,LineNumberTable 
-keep class com.inmobi.** { *; } 
-keep public class com.google.android.gms.** 
-dontwarn com.google.android.gms.** 
-dontwarn com.squareup.picasso.** 
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient{  public *; 
} 
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info{ 
public *;  } 
-keep class com.squareup.picasso.** {*;} 
-dontwarn com.squareup.picasso.** 
-dontwarn com.squareup.okhttp.** 
-keep class com.moat.** {*;} 
-dontwarn com.moat.**
-keep class com.integralads.avid.library.* {*;}

#cloudmobi
 #for sdk
-keep public class com.cloudtech.**{*;}
#for gaid
-keep class **.AdvertisingIdClient$** { *; }
#for not group facebook/admob ads
-dontwarn com.google.android.**
-dontwarn com.facebook.ads.**



#rqsdk
-dontusemixedcaseclassnames
-verbose
-ignorewarnings
-dontoptimize
-dontshrink

-keepattributes SourceFile,LineNumberTable
-keepattributes Signature,EnclosingMethod
-keepattributes *Annotation*,InnerClasses
-keepattributes *JavascriptInterface*
-keepattributes *$JavaScriptInterface
-keep public class *$JavaScriptInterface

-keep public class * extends android.os.Binder
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.support.v4.**

-keepclassmembers class * implements java.io.Serializable {*;}
-keepclassmembers class * implements android.io.Parcelable {*;}
-keep class * implements android.os.Parcelable {*;}
-keep class * implements android.io.Parcelable{*;}

-keep class android.**{*;}

-keep class org.apache.** {*;}

-keep class **.RqSdk {*;}

# adsdk
-keep class com.main.** {*;}


#apsdk
-keep class * extends com.ap.android.trunk.sdk.core.base.ad.Ad
-keep class * extends com.ap.android.trunk.sdk.core.base.ad.AdSDK
-keep class * implements com.ap.android.trunk.sdk.core.base.lifecycle.IApplicationLifecycle