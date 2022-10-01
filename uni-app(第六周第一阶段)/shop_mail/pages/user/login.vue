<template>
    <view class="login">
        <view class="top_item">
            <text style="color: #000000;font-size: 22px;font-weight: bold;">密码登录</text>
          
        </view>
        <view class="input-item" style="margin-top: 80rpx;">
            <view class="title-content">
                <text class="title">账号</text>
            </view>
            <input class="input" v-model="input.username" placeholder="请输入账号" style="margin-left: 40rpx;" />
        </view>
        <view class="input-item">
            <view class="title-content">
                <text class="title">密码</text>
            </view>
            <input class="input" v-model="input.password" placeholder="请输入密码" style="margin-left: 40rpx;" />

        </view>
        <view class="button" @click="login">登录</view>
    </view>
</template>

<script>
    export default {
        data() {
            return {
				input:{
					username:'',
					password:''
				},
				user:{
					username:'admin',
					password:123456
				}
            }
        },
        onLoad() {

        },
        methods: {
			//调用后台方法获取用户数据
			async getProducts(){
				const res=await this.$myRequest({
					url:'/user/getUserByUsername'
				})
				this.user=res.data.message;
			},
            login() {
					
					console.log(this.user.password)
					console.log(this.input.password)
					if(this.user==null){
						alert('用户名不存在')
					}
					else if(this.user.password!=this.input.password){
						alert("密码错误")
					}
				else{
					uni.switchTab({
						url:'/pages/index/index'
					})
				}
            },
        }
    }
</script>

<style>
    .top_item {
        display: flex;
        margin-top: 40rpx;
        margin-left: 32rpx;
        margin-right: 32rpx;
        justify-content: space-between;
    }

    .input-item {
        display: flex;
        margin-left: 32rpx;
        margin-right: 32rpx;
        height: 50px;
        align-items: center;
        border-bottom: 1px solid #efeff4;
        margin-bottom: 20rpx;

        .title-content {
            display: flex;
            justify-content: flex-start;
            align-items: center;

            .title {
                font-size: 18px;
            }
        }

        .input {
            flex: 1;
        }
    }

    .button {
        height: 50px;
        line-height: 50px;
        margin-top: 60rpx;
        margin-left: 32rpx;
        margin-right: 32rpx;
        border-radius: 50rpx;
        font-size: 20px;
        background-color: #008AFE;
        color: #FFFFFF;
        text-align: center;
    }
</style>
