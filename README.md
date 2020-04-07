# wxapi

#### 介绍
微信公众号API Java实现。

#### 架构
![架构说明](https://raw.githubusercontent.com/mobaas/wxapi/master/architecture.png "architecture.png")

#### 使用示例

`WxApiClient apiClient = WxApiClient.create("your_app_id", "your_app_secret");`

`UserInfoRequest request = new UserInfoRequest();`

`request.setOpenId("user_openid");`

`UserInfoResponse response = apiClient.execute(request);`

`......`

