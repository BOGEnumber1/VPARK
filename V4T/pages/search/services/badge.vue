<template>
	<view style="width: 100%;overflow: hidden;">
		<view style="width: 100%;background-color: #000;height: 300upx;text-align: center;">
			<image src="../../../static/badge_title.png" style="width: 500upx;height: 63upx;align-items: center;margin-top: 118.5upx;"></image>
		</view>
		<view style="margin-bottom: 200upx;margin-top: 25upx;">
			<view  v-for="(item,index) in badgeGroup" :key="item">
				<view class="badge-view" v-on:tap="doInf(item.getDate,item.badgeInf.description)">
					<view>
					<image v-bind:src="item.badgeInf.image" class="badge-style"></image>
					</view>
					<!--
					<view class="badge-text-view">
					<text class="badge-text">{{item.badgeInf.name}}</text>
					</view>
					-->
				</view>
				
			</view>
		</view>
		<!--
		<image src="../../../static/badge_discovery.png" style="width:900upx;height: 125upx;position: relative;bottom: 50upx;margin-top: 100upx;"></image>
		-->
	</view>
</template>


<style>
	
	.badge-text-view{
		margin-top: 25upx;
	}
	
	.badge-view{
		text-align: center;
		margin: 25upx auto 0upx auto;
		float: left;
		
	}
	
	.badge-style{
		width: 250upx;
		height: 250upx;
		
	}
	
	.badge-text{
		color: #e0a158;
		size: 12upx;
	}
	
</style>


<script>
	export default {
		data() {
			return{
			'badgeGroup':null,
			}
		},
		onLoad() {
			
			

				uni.request({
					url: this.websiteUrl + '/badge/getbadge',
					method: 'GET',
					header: {
						'Content-Type': 'application/x-www-form-urlencoded',
						'Cookie': uni.getStorageSync('Cookie')
					},
					dataType: 'json',
					success: res => {
						//console.log(e.hex);
						
						if(res.statusCode==200){
						/*
						uni.showToast({
							title: '徽章加载成功！',
							icon: 'none'
						})
						*/
						this.badgeGroup = res.data.data;
						//console.log(res);
						}else{
							
							uni.showToast({
								title: '徽章加载失败！请联系管理员！',
								icon:'none'
							});
							
						}
					},
					fail: (res) => {
						uni.showToast({
							title: '服务器未响应！请稍候再来~',
							icon: 'none'
						})
					}
				})
		
		

		},
		methods:{
			
			
			doInf(date,description){
				
				uni.showToast({
					title: date+"\n"+description,
					icon:'none'
				});
				
				
			}
			
			
		}
	}
</script>
