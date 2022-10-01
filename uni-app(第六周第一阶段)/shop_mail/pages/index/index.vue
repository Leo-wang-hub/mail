<template>
	<view >
		<!-- 商品列表 -->
		<view class="productSList">
			<view class="title">商品列表</view>
			<view class="products">
				<!--调用挂载接口可以从后台获取商品数据 -->
				<!-- v-for循环展示商品 -->
				<!-- -->
				<view class="products-item" v-for="product in products"	@click="goProductDetail(product.id)">
					<image :src=product.url></image>
					<view class="price">
						<text>￥</text><text >{{product.price}}</text>
					</view>
					<view class="name">
						{{product.name}}
					</view>
				</view>

			
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				products:[{
					id:1,
					url:'../../static/products/phone01.jpg',
					price:'8999',
					name:'Iphone 13Pro Max'
				},{
					id:2,
					url:'../../static/products/phone03.jpg',
					price:'7999',
					name:'	iphone13 Pro'
				},
				{
					id:3,
					url:'../../static/products/phone01.jpg',
					price:'8999',
					name:'Iphone 13Pro Max'
				},
				{
					id:4,
					url:'../../static/products/phone01.jpg',
					price:'8999',
					name:'Iphone 13Pro Max'
				}]
			}
		},
		onLoad() {

		},
		methods: {
			//获取商品列表数据接口
			async getProducts(){
				const res=await this.$myRequest({
					url:'/products/getProdects'
				})
				this.products=res.data.message;
			},
			
				//跳转商品详情	
				goProductDetail(id){
					console.log("进入了方法"+id);
					uni.navigateTo({
						url:'/pages/prodcutDetail/prodcutDetail?id='+id
					})
				
				}
			
		},
		
	}
</script>

<style>
	.productSList{
		background:#eee;
		/* 解决margin塌陷 */
		overflow: hidden;
		
	}
	.title{
		text-align: center;
		color: darkred;
		letter-spacing: 20px;
		background-color: #fff;
		margin: 5px 5px;
	}
	.products{
		margin:0 5px;
		background-color: #fff;
	}
	.products-item{
		background-color: #fff;
		width:355rpx;
		float: left;
		text-align: center;
	}
	.products-item image{
		width: 100%;
		height: 150px;
	}
	.products-item text{
		color: red;
	}
</style>
