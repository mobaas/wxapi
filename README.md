# wxapi

#### 项目介绍
微信公众号API Java实现。

#### 软件架构
软件架构说明

![软件架构说明](https://images.gitee.com/uploads/images/2018/1028/233148_897fe1d5_1595980.png "architecture.png")

#### 使用示例

`WxApiClient apiClient = WxApiClient.create("your_app_id", "your_app_secret");`

`UserInfoRequest request = new UserInfoRequest();`

`request.setOpenId("user_openid");`

`UserInfoResponse response = apiClient.execute(request);`

`......`

