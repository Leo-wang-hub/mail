<template>
	
	<view >
		
		<view class="title">商品详情</view>
		<!-- 以编号为1的商品为例进行展示 -->
		<view>
			<view >
				
				<image :src="product.url" ></image>
			</view>
		<view class="box1">
				
			
			<view class="price">
				<text>￥</text><text>{{product.price}}</text>
			</view>
			<view class="name">
				<text>{{product.name}}</text>
			</view>
			<view class="detail">
				<view class="title">
					商品简介
				</view>
				<view class="body">
					{{product.detail}}
				</view>
				
			</view>
		</view>
		</view>
		<view class="nav">
			<uni-goods-nav :fill="true"  :options="options" :buttonGroup="buttonGroup"  @click="onClick" @buttonClick="buttonClick" />
		</view>
		
	</view>
</template>

<script>
	import uniGoodsNav from '@/uni_modules/uni-goods-nav/components/uni-goods-nav/i18n/index.js'
	export default {
		data() {
			return {
				id:0,
				product:{
					id:1,
					url:'../../static/products/phone01.jpg',
					price:'8999',
					name:'iphone 13Pro Max',
					detail:'苹果iPhone 13 Pro Max搭载全新一代苹果A15处理器，拥有5核心GPU，首次支持ProMotion 120Hz高刷新率显示屏，影像系统支持传感器位移式光学图像防抖功能。'
				},
				 options: [{
							icon: 'headphones',
							text: '客服'
						}, {
							icon: 'shop',
							text: '店铺',
							info: '',
							infoBackgroundColor:'#007aff',
							infoColor:"red"
						}, {
							icon: 'cart',
							text: '购物车',
							info: ''
						}],
					    buttonGroup: [{
					      text: '加入购物车',
					      backgroundColor: '#ff0000',
					      color: '#fff'
					    },
					    {
					      text: '立即购买',
					      backgroundColor: '#ffa200',
					      color: '#fff'
					    }
					    ]
			}
		},
	
		methods: {
			//根据商品id获取商品信息
			async getProductById(){
				const res=await this.$myRequest({
					url:'/products/getProdects'
				})
				this.product=res.data.message;
			},
		},
		onLoad(options){
			console.log(options.id),
			this.id=options.id
		}
	}
</script>

<style>
.title{
		text-align: center;
		color: darkred;
		letter-spacing: 20px;
		background-color: #fff;
		margin: 5px 5px;
	}
	image{
		width: 100%;
	}
	.box1{
		padding: 10px;
	}
	.price text{
		font-size: 25px;
		color: red;
	}
	.name text{
		padding: 10px;
		font-size: 20px;
	}
	.detail .title{
		text-align: center;
		color: lightslategray;
		font:10px
	}
	.detail .body{
		padding: 7px;
		color:#333
	}
	.nav{
		position: fixed;
		bottom: 0;
		width: 100%;
	}
</style>
