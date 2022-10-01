<template>
	<view>
	<!-- 购物车没商品出现的页面 -->
		<view class="empty" v-if="show==false">
			<image src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F01%2F82%2F40%2F596fa6dc00bb4_610.jpg&refer=http%3A%2F%2Fpic.51yuansu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633499781&t=d37222e32213957ddbdd01d62e071309" mode="widthFix" style="width: 400rpx;"></image>
		<view class="empty-text">空空如也的购物</view>
		<view class="empty-button" @click="goshopping">去选购</view>
		</view>
		<!-- 购物车加购商品的东西 -->
		<view v-if="show==true">
		<!-- 通过循环商品呈现出每个商品 -->
			<view class="goods-detail" v-for="(item,index) in goods" :key="index">
				<view class="detail-left">
					<view class="goods-left">
					<!-- //商品的选择框 -->
						<checkbox-group @change="selected(item)">
							<label>
								<checkbox  class="selected" color="#555555" :checked="checked"/>
							</label>
						</checkbox-group>
						  <image :src="item.url" mode="widthFix" style="width: 150rpx;"></image>
					</view>
					<view class="size">
					    <text style="font-size: 25rpx;">{{item.name}}</text>
					    <text class="goods-price">￥{{item.price}}/件</text>
					</view>
				</view>
				<view class="detail-right">
					<text class="subtract" @click="reduce(item)">-</text>
					<text class="num">{{item.num}}</text>
					<text @click="add(item)" class="add">+</text>
				</view>
			</view>
		</view>
		<!-- //全选总计 -->
		<view class="end">
			<view class="end-left">
				<checkbox-group @change="selectgoods()">
					<label>
						<checkbox  :checked="allchecked" />全选
					</label>
				</checkbox-group>
				<view>
					总计：<text style="color: #f00;font-weight: bold;">￥ {{totalPrice}}</text>
				</view>
				</view>
				<view class="end-right">
				    结算({{totalNum}})
				</view>
			
			
		</view>
	</view>
</template>


<script>
	export default{
		data(){
			return{
			//购物车有无商品
				show:true,
				//全选是否选中
				 allchecked:true,
				    checked:true,
				    //商品
					goods:[{
					id:1,
					url:'../../static/products/phone01.jpg',
					price:'8999',
					name:'iphone 13Pro Max',
					detail:'苹果iPhone 13 Pro Max搭载全新一代苹果A15处理器，拥有5核心GPU，首次支持ProMotion 120Hz高刷新率显示屏，影像系统支持传感器位移式光学图像防抖功能。'
				}
					],
			}
		},
		method:{},
		computed:{}
		}
	</script>	

	export default {
		data() {
			return {
				show:false
			}
		},
		methods: {
			
		}
	}
</script>

<style lang="scss">
	.goods{
		line-height: 80rpx;
		background-color: #FFFFFF;
		&-detail{
		    display: flex;
		    padding: 30rpx 15rpx 30rpx 30rpx;
		    background-color: #fff;
		    justify-content: space-between;
		    border-bottom: 5rpx solid #F1F1F1;
		    align-items: center;
		    .detail-left{
		        display: flex;
		        .goods-left{
		            display: flex;
		            align-items: center;
		        }
		    }
		    .size{
		        display: flex;
		        justify-content: space-around;
		        flex-direction: column;
		        margin-left: 30rpx;
		        .goods-price{
		            font-size: 25rpx;
		            color: #F44545;
		            
		        }
		    }
		    .detail-right{
		        text{
		            width: 50rpx;
		            line-height: 50rpx;
		            text-align: center;
		            display: inline-block;
		            background-color: #F7F7F7;
		            margin-right: 10rpx;
		        }
		        .add {
		            color: #FA4305;
		            border-radius: 10rpx 30rpx 30rpx 10rpx;
		            margin-right: 20rpx;
		        }
		        .subtract{
		            border-radius: 30rpx 10rpx 10rpx 30rpx;
		        }
		    }
		}
	}
	.empty{
		
		    position: relative;
		    top: 220rpx;
		    text-align: center;
		    display: flex;
		    align-items: center;
		    flex-direction: column;
		    &-text{
		        color: #808080;
		        margin-bottom: 50rpx;
		    }
		    &-button{
		        width: 300rpx;
		        height: 90rpx;
		        color:orange;
		        border: 1rpx solid orange;
		        text-align: center;
		        line-height: 90rpx;
		        border-radius: 48rpx;
		    }		
	}
	.end{
	    width: 100%;
	    height: 90rpx;
	    background-color:#fff;
	    position: fixed;
	    bottom: 100rpx;
	    left: 0;
	    display: flex;
	    align-items: center;
	    &-left{
	        width: 70%;
	        display: flex;
	        justify-content: space-between;
	        padding: 0 30rpx;
	        .end-flex{
	            display: flex;
	            align-items: center;
	        }
	    }
	    &-right{
	        width: 30%;
	        line-height: 90rpx;
	        background-color: #F44545;
	        text-align: center;
	        color: #fff;
	    }
	}
</style>


.goods{
        line-height: 80rpx;
        background-color: #fff;
        &-top{
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 30rpx;
            border-bottom: 8rpx solid #F1F1F1;
            .name{
                color: #333;
                font-size: 31rpx;
                font-weight: bold;
            }
        }
        &-detail{
            display: flex;
            padding: 30rpx 15rpx 30rpx 30rpx;
            background-color: #fff;
            justify-content: space-between;
            border-bottom: 5rpx solid #F1F1F1;
            align-items: center;
            .detail-left{
                display: flex;
                .left{
                    display: flex;
                    align-items: center;
                }
            }
            .size{
                display: flex;
                justify-content: space-around;
                flex-direction: column;
                margin-left: 30rpx;
                .goods-price{
                    font-size: 25rpx;
                    color: #F44545;
                    
                }
            }
            .right{
                text{
                    width: 50rpx;
                    line-height: 50rpx;
                    text-align: center;
                    display: inline-block;
                    background-color: #F7F7F7;
                    margin-right: 10rpx;
                }
                .add {
                    color: #FA4305;
                    border-radius: 10rpx 30rpx 30rpx 10rpx;
                    margin-right: 20rpx;
                }
                .subtract{
                    border-radius: 30rpx 10rpx 10rpx 30rpx;
                }
            }
        }
        
    }
    .notGoods{
        position: relative;
        top: 220rpx;
        text-align: center;
        display: flex;
        align-items: center;
        flex-direction: column;
        // line-height: 1334rpx;
        &-text{
            color: #808080;
            margin-bottom: 50rpx;
        }
        &-button{
            width: 260rpx;
            height: 70rpx;
            color:#F44545;
            border: 1rpx solid #F44545;
            text-align: center;
            line-height: 70rpx;
            border-radius: 48rpx;
        }
    }
    .end{
        width: 100%;
        height: 90rpx;
        background-color:#fff;
        position: fixed;
        bottom: 100rpx;
        left: 0;
        display: flex;
        align-items: center;
        &-left{
            width: 70%;
            display: flex;
            justify-content: space-between;
            padding: 0 30rpx;
            .end-flex{
                display: flex;
                align-items: center;
            }
        }
        &-right{
            width: 30%;
            line-height: 90rpx;
            background-color: #F44545;
            text-align: center;
            color: #fff;
        }
    }
</style>
