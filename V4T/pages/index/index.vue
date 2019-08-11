<template>
	<view style="width: 100%;overflow: hidden;text-align: center;">

		<view style="margin-left: auto;margin-right: auto;width: 677upx;height: 284upx;margin-top: 40upx;">
			<swiper :indicator-dots="false" :autoplay="true" :interval="3000" :duration="1000" style="width: 100%;height: 100%;">
				<swiper-item v-for="(item,index) in swipterData" :key="item.id" >
					<view class="swiper-view" v-on:tap="openWeb(item.href)">
						<image class="swiperImageStyle" v-bind:src="item.img" mode="aspectFill" lazy-load></image>
						<text class="swiperTextStyle">{{item.text}}</text>
					</view>
				</swiper-item>
			</swiper>
		</view>
		
		<text style="font-size: 24upx;line-height: 64upx;">常用工具</text>
		<view>
			<image src="../../static/index/card/equipment.png" class="card-style" style="margin-top: 0upx;width: 682upx;height: 223upx;" @tap="goto('./services/equipment')"></image>
		</view>

		<text style="font-size: 24upx;line-height: 64upx;">消息知道</text>

		<view>
			<image src="../../static/index/card/1.png" class="card-style" style="margin-top: 0upx;" @tap="openWeb('https://mp.weixin.qq.com/mp/homepage?__biz=MzU0OTM5Nzg0Nw==&hid=2&sn=482d1569593320ea0e307f13073d1050')"></image>
			<image src="../../static/index/card/2.png" class="card-style" @tap="openWeb('http://mp.weixin.qq.com/mp/homepage?__biz=MzU0OTM5Nzg0Nw==&hid=1&sn=4ce9d6bd740de7f635d20c680b5b680b&scene=18#wechat_redirect')"></image>
			<image src="../../static/index/card/3.png" class="card-style" @tap="openWeb('http://www.ccyl.org.cn/')"></image>
			<image src="../../static/index/card/4.png" class="card-style" @tap="openWeb(0)"></image>
			<image src="../../static/index/card/5.png" class="card-style" @tap="openWeb(0)"></image>
			<!--
			<image src="../../static/index/card/6.png" class="card-style" @tap="openWeb(0)"></image>
			-->
			<image src="../../static/index/card/6_1.png" class="card-style" @tap="openWeb('http://111.33.71.66:7000/Yearbook/2018/mobile/#p=1')"></image>
		</view>

	</view>
</template>
<style>

	.swiper-view{
		width: 100%;
		height: 100%;
		
	}
	
	.swiperImageStyle {
		
	width: 100%;  
    height: 100%;
		
	}
	
	.swiperTextStyle{
		position: absolute;
		bottom: 20upx;
		left: 20upx;
		color: #FFFFFF;
		z-index: 999;
		font-size: 24upx;
	}

	.card-style {
		margin-top: 10upx;
		margin-bottom: 10upx;
		width: 681upx;
		height: 167upx;
	}
</style>

<script>
	
	export default {
		data() {
			return {
				swipterData: null
			}

		},
		onLoad() {

		
		
		uni.request({
			url:this.resourceUrl+"json/news.json",
			method:'GET',
			dataType:'json',
			success: (res) => {
				//console.log(res);
				this.swipterData=res.data;
			}
		})
		
		

		},
		onReady() {

			this.getServerUserTime();


		},
		onShow() {




		},
		methods: {


		openWeb(address) {
		
		if(address==0){
			uni.showToast({
				title: '这个卡片还未开放哦~',
				icon: 'none'
			});
			return ;
		}
		
		
		
		
			plus.runtime.openWeb(address);
		},



			goto(location) {
				uni.navigateTo({
					url: location,
					success: res => {},
					fail: () => {
						uni.showToast({
							title: '打开失败！请检查网络是否良好！',
							icon: "none",
							mask: false,
							duration: 1500
						})
					}
				});
			},

			getServerUserTime() {
				var servertime;
				uni.request({
					url: this.websiteUrl + '/user/time',
					method: 'GET',
					header: {
						'Cookie': uni.getStorageSync('Cookie'),
					},
					dataType: 'json',

					success: resx => {
						//console.log(resx);
						//console.log(resx);
						servertime = resx.data.data;
						//console.log(servertime);
						//console.log(time);
						//console.log("save:"+localuser);
						//uni.setStorageSync('localtime', time);


						if (uni.getStorageSync('localuser') != null) {
							let localtime = uni.getStorageSync('localtime');
							//console.log("server:"+servertime);
							//console.log("local:"+localtime);
							if (servertime != localtime) {
								uni.removeStorageSync("localuser", null);
								uni.showToast({
									title: '服务器更新，请重新登录！',
									icon: 'none'
								})
							}
						}


					},
					fail: res => {
						uni.showToast({
							title: '服务器可能睡着了……',
							icon: 'none'
						});
						uni.removeStorageSync("localuser", null);
					}

				});

				return servertime;

			},







		}
	}
</script>
