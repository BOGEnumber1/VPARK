<template>
	<view style="overflow: hidden;" class="main-background" v-bind:style="{ backgroundColor: sec_bg_color  }   ">





		<view class="panel-top" style="" @tap="changeWallpaper()">
			<image v-bind:src="wallpaper" style="top: 0upx;left: 0upx;z-index: -999;width: 100%;height: 100%;"></image>
		</view>




		<view class="user-card-view" v-bind:style="{ backgroundColor: bg_color,animationName:muticolor } ">
			<image src="../../static/user_card_logo.png" class="user-card-litte-logo" v-bind:style="{mixBlendMode:icon_mode}"
			 @tap="open()"></image>
			<view class="user-card-avator-view">
				<image class="user-card-avator" v-bind:src="imghead" @tap="changeImgHead()"></image>
			</view>
			<text class="user-card-username-text">{{username}}</text>
			<text class="user-card-uid-text">UID:{{uid}}</text>
			<image src="../../static/user_card_style.png" class="usercard-background-image-style" v-bind:style="{mixBlendMode:icon_mode}"></image>



		</view>




		<view class="panel-bottom">

			<view style="width: 100%;margin-top: 200upx;">
				<view class="list-component-text-row" @tap="doChange()">
					<image src="../../static/list-component/list_icon_gear.png" class="list-component-icon-left" v-bind:style="{mixBlendMode:icon_menu_mode}"></image>
					<text class="list-component-text-back" v-bind:style="{color:font_color}">个人设置</text>
					<image src="../../static/list-component/list-right-button.png" class="list-component-icon-right"></image>
					<view class="list-component-view-bottom-border"></view>
				</view>
				<view class="list-component-text-row" @tap="domarket()">
					<image src="../../static/list-component/list_icon_collect.png" class="list-component-icon-left" v-bind:style="{mixBlendMode:icon_menu_mode}"></image>
					<text class="list-component-text-back" v-bind:style="{color:font_color}">给个好评</text>
					<image src="../../static/list-component/list-right-button.png" class="list-component-icon-right"></image>
					<view class="list-component-view-bottom-border"></view>
				</view>
				<view class="list-component-text-row" @tap="openWeb('https://jinshuju.net/f/cpEgCz')">
					<image src="../../static/list-component/list_icon_join.png" class="list-component-icon-left" v-bind:style="{mixBlendMode:icon_menu_mode}"></image>
					<text class="list-component-text-back" v-bind:style="{color:font_color}">加入我们</text>
					<image src="../../static/list-component/list-right-button.png" class="list-component-icon-right"></image>
					<view class="list-component-view-bottom-border"></view>
				</view>
				<view class="list-component-text-row" @tap="goto('/pages/user/services/about')">
					<image src="../../static/list-component/list_icon_about.png" class="list-component-icon-left" v-bind:style="{mixBlendMode:icon_menu_mode}"></image>
					<text class="list-component-text-back" v-bind:style="{color:font_color}">关于我们</text>
					<image src="../../static/list-component/list-right-button.png" class="list-component-icon-right"></image>
					<view class="list-component-view-bottom-border"></view>
				</view>
				<view class="list-component-text-row" @tap="goto('/pages/user/services/version')">
					<image src="../../static/list-component/list_icon_version.png" class="list-component-icon-left" v-bind:style="{mixBlendMode:icon_menu_mode}"></image>
					<text class="list-component-text-back" v-bind:style="{color:font_color}">版本信息</text>
					<image src="../../static/list-component/list-right-button.png" class="list-component-icon-right"></image>
					<view class="list-component-view-bottom-border"></view>
				</view>
				<view class="list-component-text-row" @tap="openWeb('https://jinshuju.net/f/5ayNlq')">
					<image src="../../static/list-component/list_icon_bug.png" class="list-component-icon-left" v-bind:style="{mixBlendMode:icon_menu_mode}"></image>
					<text class="list-component-text-back" v-bind:style="{color:font_color}">问题反馈</text>
					<image src="../../static/list-component/list-right-button.png" class="list-component-icon-right"></image>
					<view class="list-component-view-bottom-border"></view>
				</view>
			</view>

		</view>

		<view style="margin-top: 80upx;width: 100%;text-align: center;margin-bottom: 100upx;">

			<!-- border: #535353 solid 2upx; -->
			<view style="width: 60%;margin-left: auto;margin-right: auto;padding-top: 20upx;padding-bottom: 20upx;" class="user_button"
			 v-on:tap="doUserAction" v-bind:style="{borderColor:font_color}">
				<text v-bind:style="{color:font_color}">{{btn_desc}}</text>
			</view>

			<image src="../../static/user_bottom_text.png" style="width: 222upx;height: 25upx;margin-top: 100upx;"></image>

		</view>


		<t-color-picker ref="colorPicker" :color="color" @confirm="confirm"></t-color-picker>
	</view>


</template>

<script>
	import tColorPicker from '@/components/t-color-picker/t-color-picker.vue';
	import {
		pathToBase64,
		base64ToPath
	} from '../../js_sdk/gsq-image-tools/image-tools/index.js';
	export default {
		components: {
			tColorPicker
		},
		data() {
			return {
				title: 'Hello',
				uid: '00000',
				username: '工坊用户',
				imghead: '../../static/logo.png',
				wallpaper: null,
				bg_color: null,
				icon_mode: null,
				sec_bg_color: null,
				font_color: null,
				icon_menu_mode: null,
				btn_desc: "登录",
				muticolor: null,
				color: {
					r: 72,
					g: 72,
					b: 72,
					a: 1
				}
			}
		},
		onShow() {

			/*
			uni.request({
				url:this.websiteUrl+'/user/getUser',
				data:{id:this.id},
				dataType:'json',
				success:res => {
					console.log(res.data);
					this.imghead = res.data.imghead;
					this.uid = res.data.id;
					this.username = res.data.username;
				},
				fail: res => {
					uni.showToast({
						title:'请登录以获得用户资料！',
						icon:'none'
					});
				}
			})*/

			this.doUserStyle();

		},
		methods: {
		openWeb(address) {
		
			plus.runtime.openWeb(address);
		},
			doChange() {


				if (uni.getStorageSync('localuser') == null) {
					uni.showToast({
						title: '请先登录！',
						icon: 'none'
					});
					return;
				} else {

					this.goto('/pages/user/services/change');


				}
			},
			doUserStyle() {
				let localuser = uni.getStorageSync('localuser');
				//console.log(localuser.id);
				if (localuser != null && localuser.id >= 10000) {
					//console.log("Custom style!")

					if (localuser.imghead != null) {
						this.imghead = localuser.imghead;
					}
					this.uid = localuser.id;
					this.username = localuser.username;
					this.wallpaper = localuser.wallpaper;
					//console.log(localuser.color);
					if (localuser.color != null) {
						this.bg_color = localuser.color;
						//console.log(this.bg_color);
						if (localuser.color != "#484848") {
							this.icon_mode = 'hard-light';
						}

						uni.setBackgroundColor({
							backgroundColor: localuser.color,
							backgroundColorBottom: localuser.color,
							backgroundColorTop: localuser.color
						})

						if (localuser.color == "100000") {
							this.muticolor = "MutiColor"
						} else {
							this.muticolor = null
						}
					}
					this.btn_desc = "注销";


				} else {
					this.btn_desc = "登录";

					uni.setBackgroundColor({
						backgroundColor: "#484848",
						backgroundColorBottom: "#484848",
						backgroundColorTop: "#484848"
					})




				}


			},


			open(item) {
				// 打开颜色选择器
				let localuser = uni.getStorageSync('localuser');
				if (localuser == null) {
					uni.showToast({
						title: '你必须先登录才能修改卡片颜色！',
						icon: 'none'
					});
					return;





				}
				this.$refs.colorPicker.open();
			},
			confirm(e) {
				//console.log('颜色选择器返回值：' + e)
				uni.request({
					url: this.websiteUrl + '/user/changecolor',
					method: 'POST',
					header: {
						'Content-Type': 'application/x-www-form-urlencoded',
						'Cookie': uni.getStorageSync('Cookie')
					},
					data: {
						'color': e.hex
					},
					dataType: 'json',
					success: res => {
						//console.log(e.hex);
						//console.log(res);
						uni.showToast({
							title: '修改成功！',
							icon: 'none'
						})
						this.refreshUser();

					},
					fail: (res) => {
						uni.showToast({
							title: '服务器未响应！',
							icon: 'none'
						})
					}
				})

			},


			changeImgHead() {

				if (uni.getStorageSync('localuser') == null) {

					uni.showToast({
						title: '请先登录再修改头像',
						icon: 'none'
					})
					return ;
				}


				uni.chooseImage({
					count: 1,
					sizeType: ['compressed'],
					sourceType: ['album'],
					success: (res) => {


						pathToBase64(res.tempFilePaths[0])
							.then(base64 => {
								//console.log(base64)

								uni.request({
									url: this.websiteUrl + '/user/changeimghead',
									method: 'POST',
									header: {
										'Content-Type': 'application/x-www-form-urlencoded',
										'Cookie': uni.getStorageSync('Cookie')
									},
									data: {
										'imghead': base64
									},
									dataType: 'json',
									success: res => {
										//console.log(e.hex);
										//console.log(res);
										if (res.data.code == 1) {
											uni.showToast({
												title: '修改成功！',
												icon: 'none'
											})
											this.refreshUser();
										} else {
											uni.showToast({
												title: '上传错误！请换一张图片！',
												icon: 'none'
											})
										}
									},
									fail: (res) => {
										uni.showToast({
											title: '服务器未响应！',
											icon: 'none'
										})
									}

								})

							})
							.catch(error => {

								uni.showToast({
									title: '图像转换错误！',
									icon: 'none'
								})

							})



					}

				})
			},

			changeWallpaper() {

				if (uni.getStorageSync('localuser') == null) {

				uni.showToast({
					title: '请先登录再修改壁纸',
					icon: 'none'
				})
					return ;
				}




				uni.chooseImage({
					count: 1,
					sizeType: ['compressed'],
					sourceType: ['album'],
					success: (res) => {


						pathToBase64(res.tempFilePaths[0])
							.then(base64 => {
								//console.log(base64)
								//console.log(base64);
								uni.request({
									url: this.websiteUrl + '/user/changewallpaper',
									method: 'POST',
									header: {
										'Content-Type': 'application/x-www-form-urlencoded',
										'Cookie': uni.getStorageSync('Cookie')
									},
									data: {
										'wallpaper': base64
									},
									dataType: 'json',
									success: res => {
										//console.log(e.hex);
										//console.log(res);
										if (res.data.code == 1) {
											uni.showToast({
												title: '修改成功！',
												icon: 'none'
											})
											this.refreshUser();
										} else {
											uni.showToast({
												title: '上传错误！请换一张图片！',
												icon: 'none'
											})
										}
									},
									fail: (res) => {
										uni.showToast({
											title: '服务器未响应！',
											icon: 'none'
										})
									}

								})

							})
							.catch(error => {

								uni.showToast({
									title: '图像转换错误！',
									icon: 'none'
								})

							})



					}

				})


			},






			domarket() {
				console.log("Open Market!")
				var url;
				if (plus.os.name == "Android") {

					url = "market://details?id=io.dcloud.UNI74AE070";



				} else {

					uni.showToast({
						title: '目前只限Android哦！',
						icon: 'none'
					})

					//url = "itms-apps://itunes.apple.com/cn/app/hello-uni-app/id1417078253?mt=8";

				}

				plus.runtime.openURL(url, function(res) {
					uni.showToast({
						title: "打开失败！请检查是否包含应用商店！",
						icon: 'none'
					})
				});


			},

			refreshUser() {

				uni.request({
					url: this.websiteUrl + '/user/getUser',
					method: 'GET',
					header: {
						'Cookie': uni.getStorageSync('Cookie'),
					},
					dataType: 'json',


					success: resx => {
						//console.log(resx);
						let localuser = resx.data.data;
						//console.log(localuser);
						uni.setStorageSync('localuser', localuser);
						//this.back();
						this.doUserStyle();
					}
				})


			},


			goto(location) {

				if (location == 0) {
					uni.showToast({
						title: '施工中……',
						icon: "none",
						mask: false,
						duration: 1500
					});
				}


				uni.navigateTo({
					url: location
				})
			},

			doUserAction: function() {
				if (uni.getStorageSync('localuser') == null) {
					this.goto('/pages/user/services/login');
				} else {
					uni.setStorageSync('localuser', null);

					this.imghead = '../../static/logo.png';
					this.uid = '00000';
					this.username = '工坊用户';
					this.wallpaper = null;
					this.bg_color = null;
					this.icon_mode = null;


					this.btn_desc = "登录";
					uni.removeStorageSync('sign_date');
					uni.removeStorageSync('localsignnumber');

					uni.request({
						url: this.websiteUrl + '/user/logout',
						method: 'POST',
						header: {
							'Content-Type': 'application/x-www-form-urlencoded'
						},
						dataType: 'json',
						success: res => {
							uni.showToast({
								title: '注销成功！',
								icon: 'none'
							})
						},
					})


				}
			}

		},
		computed: {

		}
	}
</script>

<style>
	
	
	
	.user_button{
		
		background-color: #c63a34;
		color: #FFFFFF;
		width: 75%;
		padding-top: 10upx;
		padding-bottom: 10upx;
		border-radius: 60upx;
		margin-top: 40upx;
		font-size: 32upx;
		
		}
	
	.main-background {
		background-color: #FFFFFF;

	}

	.list-component-icon-left {
		margin-left: 25upx;
		width: 48upx;
		height: 48upx;
		position: relative;
		top: 11.5upx;

	}

	.list-component-icon-right {
		width: 48upx;
		height: 48upx;
		position: relative;
		top: 11.5upx;
		left: 60upx;
		float: right;


	}

	.list-component-text-row {
		width: 88%;
		align-content: center;

		margin-top: 20upx;

	}

	.list-component-view-bottom-border {
		border-bottom: #f0f0f0 solid 1px;
		color: #666666;
		width: 100%;
		margin-left: 15%;
		margin-top: 30upx;
	}

	.list-component-text-back {
		padding-left: 30upx;

	}


	.user-card-uid-text {
		color: #fff;
		width: 100%;
		position: absolute;
		top: 230upx;
		font-size: 22.5upx;
		text-align: center;
	}

	.user-card-username-text {
		color: #fff;
		width: 100%;
		position: absolute;
		top: 180upx;
		font-size: 40upx;
		text-align: center;
	}

	.usercard-background-image-style {
		position: absolute;
		bottom: -50upx;
		left: 0upx;
		width: 100%;
		/* 658upx */
		height: 127upx;
	}

	.user-card-litte-logo {
		width: 50upx;
		height: 50upx;
		position: absolute;
		left: 25upx;
		top: 25upx;
		animation-name: xfirst;
		animation-duration: 1s;
		animation-timing-function: linear;
		animation-delay: 10s;
		animation-iteration-count: 1;
		animation-direction: alternate-reverse;
	}

	@keyframes xfirst {
		from {
			transform: rotate(0deg);
		}

		to {
			transform: rotate(360deg);
		}
	}

	.user-card-avator {
		width: 120upx;
		height: 120upx;
		border-radius: 60upx;
		border: 2upx solid #e8cba1;
	}

	.user-card-avator-view {
		width: 100%;
		position: absolute;
		top: 45upx;
		text-align: center;
	}

	.panel-top {
		height: 348upx;
		width: 100%;
		background-color: #000;
		/*box-shadow: 0px 0px 5px #000;*/

	}

	.panel-bottom {
		width: 100%;


	}

	.user-card-view {
		height: 342upx;
		width: 88%;
		/* 658upx */
		left: 6%;
		top: 108upx;
		position: absolute;
		background-color: #484848;
		border-radius: 34upx;
		overflow: hidden;
		transition: all 1s ease-in-out 0s;
		animation-duration: 30s;
		animation-timing-function: linear;
		animation-iteration-count: infinite;
	}

	@keyframes MutiColor {
		0% {
			background-color: #FF3030;
		}

		10% {
			background-color: #FFA500;
		}

		20% {
			background-color: #EEEE00;
		}

		30% {
			background-color: #32CD32;
		}

		40% {
			background-color: #7FFFD4;
		}

		50% {
			background-color: #00BFFF;
		}

		60% {
			background-color: #6A5ACD;
		}

		70% {
			background-color: #FF00FF;
		}

		80% {
			background-color: #8B3626;
		}

		90% {
			background-color: #363636;
		}

		100% {
			background-color: #FF3030;
		}
	}
</style>
