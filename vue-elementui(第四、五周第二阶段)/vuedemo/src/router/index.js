import Vue from 'vue'
import Router from 'vue-router'
import ProductList from '../view/ProductList.vue'
import NotFound from '../view/NotFound.vue'
Vue.use(Router)

export default new Router({
  // 路由模式设置
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'productList',
      component:ProductList
    },
    {
    path:'*',
    component:NotFound,
    }
  ]
})
