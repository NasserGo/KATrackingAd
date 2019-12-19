# 版本发布记录
## Ver.3.7.2.8
## Release Date: 2019-12-19
* 优化插屏关闭回调

## Ver.3.7.2.6
## Release Date: 2019-12-11
* 优化激励视频播放问题
* 插屏添加展示回调
* 优化原生展示效果

## Ver.3.7.2.2
## Release Date: 2019-11-27
* 依赖的FileDownloader库修改以防跟接入应用冲突

## Ver.3.7.2.1
## Release Date: 2019-11-22
* 修复了开屏广告由于sdk未初始化完成而导致的加载失败问题
* 修复了非模板原生广告在部分情况下点击无效的bug

## Ver.3.7.2
## Release Date: 2019-11-21
* sdk性能优化

## Ver.3.7.1
## Release Date: 2019-11-15
* sdk性能优化


## Ver.3.7.0
## Release Date: 2019-11-14
* 增加广告归因追踪

## Ver.3.6.5
## Release Date: 2019-10-22
* 已知bug修复

## Ver.3.6.4.2
## Release Date: 2019-09-24
* 更新头条sdk
* 部分已知bug修复

## Ver.3.6.3
## Release Date: 2019-07-23
* 部分已知bug修复
* 增加api激励视频类型广告


## Ver.3.6.2
## Release Date: 2019-05-27
* 部分已知bug修复

## Ver.3.6.1
## Release Date: 2019-05-08
* 崩溃追踪功能

## Ver.3.6.0
## Release Date: 2019-04-26
* 已知bug修复

## Ver.3.5.6
## Release Date: 2019-04-25
* 已知bug修复：在第一次初始化时候，立刻请求视频广告会导致视频广告一直失败。

## Ver.3.5.5
## Release Date: 2019-04-22
* 添加任务墙功能
* 已知bug修复

## Ver.3.5.3
## Release Date: 2019-03-27
* 支持百度sdk、更新小米sdk
* 已知bug修复

## Ver.3.5.2
## Release Date: 2019-03-14
* 支持更多的三方平台sdk
* 已知bug修复

## Ver.3.5.0
## Release Date: 2019-03-11
* 支持更多的三方平台sdk
* 已知bug修复

## Ver.3.3.0
## Release Date: 2018-12-18
* 支持更多的三方平台sdk
* 已知bug修复

## Ver.3.2.5
## Release Date: 2018-11-28
* 开屏逻辑修改
* 已知bug修复

## Ver.3.2.4
## Release Date: 2018-09-11
* 原生广告类型增加'RAW'模式，方便希望使用更加灵活的接入方式的接入方使用
* 已知bug修复

## Ver.3.2.3
## Release Date: 2018-09-06
* 增加接口，判断sdk是否曾初始化成功过
* 已知bug修复

## Ver.3.2.2
## Release Date: 2018-08-27
* 增加接口可控制是否在非wifi下直接进行apk下载
* 已知bug修复

## Ver.3.2.1
## Release Date: 2018-08-15

* 加入对插屏、banner、激励视频广告类型的支持
* bug修复

## Ver.3.1.6
## Release Date: 2018-07-20

* 修复了APAD初始化方法导致的BroadcastReceiver泄露

## Ver.3.1.5
## Release Date: 2018-07-19

* `APAD`的初始化方法`init（activity,appID,channelID）`中的`activity`参数修改为`Context`类型（注：如果要sdk在初始化时自动请求所需要的权限，那么`context`参数必须要为`activity`的实例）
* `APSplash`支持`api`类型广告

## Ver.3.1.4
## Release Date: 2018-07-18

* `APSplash`增加实例方法：`onDestroy`来由接入应用决定何时释放sdk所占用资源（之前该方法由sdk内部在onDismiss回调之前调用，如果当前展示的是inmobi的开屏，会导致adContainer移除广告内容，用户体验不好）

## Ver.3.1.3
## Release Date: 2018-07-13

* 增加方法可以控制sdk在初始化时是否自动请求所需的权限

## Ver.3.1.2
## Release Date: 2018-07-12

* 修复了在点击非下载类型的开屏广告时（inmobi）倒计时依然继续的bug

## Ver.3.1.1
## Release Date: 2018-07-06

* 内部代码结构调整
* 支持开屏广告形式

## Ver.3.1
## Release Date: 2018-07-04

* 加入事件追踪
* 原生广告形式加入api广告（gdt、inmobi）

## Ver.3.0
## Release Date: 2018-06-05

* 初版提交

