**vuecli-elementui实现商品的增删改查**

1. [ CORS跨域问题](https://www.jianshu.com/p/98d4bc7565b2)

2. 遇到的问题

   - webpack版本冲突

     解决：版本组合 **webpack 4.41.5webpack-cli 3.3.10webpack-dev-server 3.10.1**

   - vuecli组件中国Vue.set()   Vue is not define()

     解决:使用this.$set（）代替