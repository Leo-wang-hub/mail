技术选型： springboot+mybaits+thymeleaf

1. 注册登录
   - 使用bootstrap 
   - 用户名输入框失去焦点时ajax异步查询用户是否存在
   - 设置主页地址映射 registry.addViewController("/main.html").setViewName("index");
   - 实现HandlerIntercepter接口进行登录拦截
   - 主页取得sesstion值展示用户名称
   
2. 商品详情
   
   - 向后台传入productId  获取商品信息
   
3. 购物车
   
   - 可在首页右上方查看购物车
   
   - 购物车和商品以及用户关联   购物车实体类将关联的字段设置为需要关联的实体 Product product
   -  **添加购物车** 商品下方点击购物车图标即可将商品加入到购物车（非初次添加只更改商品的数目）   可在首页查看点击购物车图标查看我的购物车 右上角会显示购物车内商品数量
   - 购物车页面对产品数目的添加     数量减少至0相当于删除
   - 删除  包括单条删除和全部删除
   - 计算总金额    对购物车遍历 
   
4. 订单
   - 订单预览     先添加地址  地址添加后结合购物车信息生成订单预览
   - 提交订单      编写工具类根据当前时间生成随机数作为订单编号 将订单信息保存在order中 订单生成后清空购物车      
   
     
   



