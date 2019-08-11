<template>
	<view class="content" style="">








		<view style="position: absolute;right: 50upx;top: 0upx;">
			<image :src="blackboard_url" style="position: relative;z-index: 1;width: 331.5upx;height: 240.75upx;transform-origin: 50% 0% 0;"
			 class=".blackboard"></image>
			<!--
		<view style="height: 100%;color: #fff;position: absolute;z-index: 2;top: 100upx;overflow: hidden;word-break: break-all;padding-left: 10upx;padding-right: 10upx;padding-bottom: 10upx;">
		
		<text>【{{board_title}}】</text>
		<rich-text style="font-size: 30upx;overflow: hidden;">{{board_text}}</rich-text>
		
		</view>
		-->


		</view>



		<view style="width: 100%;height: 100%; position: fixed;top: 0upx;left: 0upx;  overflow: hidden;">

			<image src="../../static/anim/fire_balloon.png" class="fire-balloon"></image>
			<image src="../../static/anim/cloud1.png" class="cloud" style="top: 200upx;transform: scale(1.0);animation-name: cloud-right-1;animation-duration: 35s;z-index: -1;"></image>
			<image src="../../static/anim/cloud2.png" class="cloud" style="top: 160upx;transform: scale(0.84);animation-name: cloud-left-1;animation-duration: 30s;z-index: -2;"></image>
			<image src="../../static/anim/cloud3.png" class="cloud" style="top: 153upx;transform: scale(0.79);animation-name: cloud-left-1;animation-duration: 33s;z-index: -3;"></image>
			<image src="../../static/anim/cloud1.png" class="cloud" style="top: 71upx;transform: scale(0.78);animation-name: cloud-right-1;animation-duration: 32s;z-index: -4;"></image>
			<image src="../../static/anim/cloud2.png" class="cloud" style="top: 88upx;transform: scale(0.99);animation-name: cloud-left-1;animation-duration: 37s;z-index: -6;"></image>
			<image src="../../static/anim/cloud3.png" class="cloud" style="top: 24upx;transform: scale(0.74);animation-name: cloud-right-1;animation-duration: 35s;z-index: -7;"></image>
			<image src="../../static/anim/cloud1.png" class="cloud" style="top: 237upx;transform: scale(0.68);animation-name: cloud-right-1;animation-duration: 39s;z-index: -8;"></image>
			<image src="../../static/anim/cloud2.png" class="cloud" style="top: 353upx;transform: scale(0.92);animation-name: cloud-left-1;animation-duration: 34s;z-index: -9;"></image>
			<image src="../../static/anim/cloud3.png" class="cloud" style="top: 400upx;transform: scale(0.78);animation-name: cloud-right-1;animation-duration: 33s;z-index: -10;"></image>
		</view>



		<image style="z-index: -999;position: absolute;left: 0upx;top: 0upx;width: 100%;height: 1377upx;" src="../../static/index/wallpaper.png"></image>
		<view style="width: 100%;height: 100%;position: absolute;">
			<view style="width: 85%;height: 350upx;margin-left: auto;margin-right: auto;margin-top: 450upx;box-shadow: 0px 0px 5px #777;">
				<map style="width: 100%;height: 100%;" :latitude="latitude" :longitude="longitude" :markers="covers"></map>
			</view>

			<view style="width: 100%;text-align: center;margin-top: 50upx;height: 125upx;">
				<image src="../../static/button/search_button_1.png" class="four-button" @tap="getSchoolLocation()"></image>
				<image src="../../static/button/search_button_2.png" class="four-button" @tap="setMapLocation()"></image>
				<image src="../../static/button/search_button_3.png" class="four-button" @tap="getImageFromCarema()"></image>
				<image src="../../static/button/search_button_4.png" class="four-button" @tap="openVR()"></image>
			</view>
			<view style="width: 100%;height: 50upx;text-align: center;margin-top: 100upx;">
				<text class="text-button" @tap="dosign()">{{day}}</text>
				<text class="text-button" @tap="openBadge()">勋章墙</text>
			</view>
		</view>


	</view>
</template>

<script>
	function doCheckPointer(latitude, longitude, self_latitude, self_longitude, offset_latitude_max,
		offset_longitude_max,
		offset_latitude_min, offset_longitude_min) {
		//console.log(latitude + "," + longitude + "," + self_latitude + "," + self_longitude + "," + offset_latitude_max + "," + offset_longitude_max + "," + offset_latitude_min + "," + offset_latitude_max)
		var target_latitude_max = latitude + offset_latitude_max;
		var target_latitude_min = latitude - offset_latitude_min;
		var target_longitude_max = longitude + offset_longitude_max;
		var target_longitude_min = longitude - offset_longitude_min;

		if (self_latitude >= target_latitude_min && self_latitude <= target_latitude_max && self_longitude >=
			target_longitude_min && self_longitude <= target_longitude_max) {

			return true;


		} else {
			return false;
		}
	}


	export default {

		data() {
			return {
				hasChooseImg: '',
				blackboard_url: "../../static/blackboard_empty.png",
				day: '请先登录',
				number: null,
				board_title: "标题",
				board_text: "我们要改变世界！",
				title: '天津市仪表无线电工业学学校',
				latitude: 39.005678,
				longitude: 117.370796,
				covers: [{
					title: "华实楼",
					latitude: 39.006362,
					longitude: 117.368574,
					iconPath: '/static/location32.png'
				}, {
					title: "辑志楼",
					latitude: 39.006238,
					longitude: 117.370292,
					iconPath: '/static/location32.png'
				}, {
					title: "工丽楼",
					latitude: 39.007496,
					longitude: 117.370870,
					iconPath: '/static/location32.png'
				}, {
					title: "学生食堂",
					latitude: 39.006146,
					longitude: 117.371879,
					iconPath: '/static/location32.png'
				}, {
					title: "报本楼",
					latitude: 39.005551,
					longitude: 117.372187,
					iconPath: '/static/location32.png'
				}, {
					title: "一号宿舍",
					latitude: 39.005341,
					longitude: 117.372839,
					iconPath: '/static/location32.png'
				}, {
					title: "二号宿舍",
					latitude: 39.004978,
					longitude: 117.372546,
					iconPath: '/static/location32.png'
				}, {
					title: "三号宿舍",
					latitude: 39.004349,
					longitude: 117.371868,
					iconPath: '/static/location32.png'
				}],
				'localdate': null,
				'signdate': null,
				'isReady': false,
				'locked': false
			}
		},
		onReady() {


			var datex = new Date();
			this.localdate = datex.getFullYear() + "-" + Number(datex.getMonth() + 1) + "-" + datex.getDate();
			this.signdate = uni.getStorageSync('sign_date');
			//console.log(this.signdate);
			this.isReady = true;

			if (uni.getStorageSync('localuser') == null) {
				this.day = "请先登录";
			} else {
				this.getsign();
			}

			uni.request({
				url: this.resourceUrl + '/img/blackboard.png',
				method: 'GET',
				success: res => {
					//console.log(res.statusCode);
					if (res.statusCode == 200) {
						this.blackboard_url = this.resourceUrl + '/img/blackboard.png';
					}

				},
				fail: () => {},
				complete: () => {}
			});



		},
		onShow() {

			if (this.isReady) {
				if (uni.getStorageSync('localuser') == null) {
					this.day = "请先登录";
				} else {
					this.getsign();
				}
			}
		},
		methods: {
			getSchoolLocation() {

				uni.openLocation({
					latitude: 39.005678,
					longitude: 117.370796,
					scale: 18,
					name: "天津市仪表无线电工业学校",
					address: "天津市津南区咸水沽镇海河教育园区雅深路6号",
					success: function() {
						//console.log('success');
					},
					fail: function() {
						uni.showToast({
							title: '打开失败！请检查地图和GPS功能是否可以用！',
							icon: 'none'
						});
					}
				});



			},
			setMapLocation() {



				uni.navigateTo({
					url: 'services/map',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});




				// 				uni.getLocation({
				// 					type: 'gcj02',
				// 					success: (res) => {
				// 						const latitude = res.latitude;
				// 						const longitude = res.longitude;
				// 
				// 						uni.openLocation({
				// 							latitude: latitude,
				// 							longitude: longitude,
				// 							success: function() {
				// 								//console.log('success');
				// 							},
				// 							fail: function() {
				// 								uni.showToast({
				// 									title: '打开失败！请检查地图和GPS功能是否可以用！',
				// 									icon: 'none'
				// 								});
				// 							}
				// 						});
				// 
				// 
				// 
				// 					},
				// 					fail: function() {
				// 						uni.showToast({
				// 							title: '打开失败！请检查地图和GPS功能是否可以用！',
				// 							icon: 'none'
				// 						});
				// 					}
				// 				})
				// 


			},
			getsign() {


				if (this.localdate == this.signdate && uni.getStorageInfoSync('localsignnumber').length > 0) {
					this.number = uni.getStorageSync('localsignnumber');
					this.day = '打卡' + this.number + '天'
					return;
				} else {
					uni.removeStorageSync('localsignnumber');
				}


				uni.request({
					url: this.websiteUrl + '/sign/getSign',
					method: 'GET',
					header: {
						'Cookie': uni.getStorageSync('Cookie'),
					},
					dataType: 'json',

					success: resx => {
						//console.log(resx);
						//console.log(resx);
						//console.log(resx);
						this.number = resx.data.data;
						//console.log(servertime);
						//console.log(time);
						//console.log("save:"+localuser);
						//uni.setStorageSync('localtime', time);
						uni.setStorageSync('localsignnumber', resx.data.data);
						if (this.number != null) {
							this.day = '打卡' + this.number + '天'
						} else {
							this.day = "请重试！";
						}
					}




				});


			},

			dosign() {
				//console.log(this.localdate+","+this.signdate);

				if (this.locked) {
					uni.showToast({
						title: '请等一下再点击哦',
						icon: 'none'
					});
				}
				this.locked = true;

				if (uni.getStorageSync('localuser') == null) {
					uni.showToast({
						title: '请先登录哦再签到哦！',
						icon: 'none'
					});
					this.locked = false;
					return;
				}

				//console.log(this.localdate+","+this.signdate);
				if (this.localdate == this.signdate) {
					uni.showToast({
						title: '今天已经签到啦！明天再来吧~',
						icon: 'none'
					});
					this.locked = false;
					return;

				} else {
					//console.log(this.localdate+","+this.signdate);
					uni.removeStorageSync('sign_date');
					this.signdate = null;


				}


				uni.request({
					url: this.websiteUrl + '/sign/doSign',
					method: 'POST',
					header: {
						'Cookie': uni.getStorageSync('Cookie'),
					},
					dataType: 'json',

					success: resx => {
						//console.log(resx);
						//console.log(resx);

						//console.log(servertime);
						//console.log(time);
						//console.log("save:"+localuser);
						//uni.setStorageSync('localtime', time);


						//100 SUCCESS 102 HASBEEN 101 ERROR
						//console.log(resx);
						switch (resx.data.data) {
							case 100:
								uni.showToast({
									title: '签到成功！',
									icon: 'none'
								});
								var datex = new Date();
								var tempxdate = datex.getFullYear() + "-" + Number(datex.getMonth() + 1) + "-" + datex.getDate();
								//console.log(tempxdate);
								uni.setStorageSync('sign_date', tempxdate);
								//console.log(uni.getStorageSync('sign_date'));
								uni.removeStorageSync('localsignnumber');
								this.getsign();
								break;
							case 101:
								uni.showToast({
									title: '签到发生错误！',
									icon: 'none',

								});
								break;
							case 102:
								uni.showToast({
									title: '您已经签到了哦！',
									icon: 'none',

								});
								var datex = new Date();
								var tempxdate = datex.getFullYear() + "-" + Number(datex.getMonth() + 1) + "-" + datex.getDate();
								uni.setStorageSync('sign_date', tempxdate);
								uni.removeStorageSync('localsignnumber');
								this.getsign();
								break;
							default:
								uni.showToast({
									title: '啊哦，服务器好像出错了！',
									icon: 'none'
								});
								break;
						}

					},
					fail: res => {
						uni.showToast({
							title: '啊哦，服务器好像有点问题？',
							icon: 'none'
						});
					}

				});


				this.locked = false;

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

			openBadge() {

				if (uni.getStorageSync('localuser') == null) {
					uni.showToast({
						title: '请先登录！',
						icon: 'none'
					});
					return;
				}

				uni.navigateTo({
					url: 'services/badge',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},

			openVR() {

				plus.runtime.openWeb('https://720yun.com/t/2f9jOOsuvv7');
			},

			getImageFromCarema() {
				var imageLocation = null;
				var imageName = null;
				var pageThis = this;
				if (uni.getStorageSync('localuser') == null) {
					uni.showToast({
						title: '请先登录哦！',
						icon: 'none'
					})
					return;
				}


				var self_latitude;
				var self_longitude;

				uni.getLocation({
					type: 'gcj02',
					success: (res) => {
						self_latitude = res.latitude;
						self_longitude = res.longitude;
						//console.log(self_latitude + "|" + self_longitude)
						//latitude,longitude,self_latitude,self_longitude,offset_latitude_max,offset_longitude_max,offset_latitude_min,offset_longitude_min


						// 				
						// 扫楼经纬度计算 保留小数点后六位
						// 
						// 辑志楼中心点：经度：117.370292 纬度：39.006238
						// 辑志楼定点1：经度：117.369670 纬度：39.006193 偏移经度：0.000622 偏移纬度：0.000045
						// 辑志楼定点2：经度：117.370625 纬度：39.006639 偏移经度：0.000333 偏移纬度：0.000401
						// 辑志楼定点3：经度：117.370147 纬度：39.005697 偏移经度：0.000145 偏移纬度：0.000541
						// 辑志楼定点4：经度：117.370936 纬度：39.006084 偏移经度：0.000644 偏移纬度：0.000154
						// 
						// 华实楼中心点：经度：117.368672 纬度：39.006343
						// 华实楼定点1：经度：117.368103 纬度：39.006426 偏移经度：0.000569 偏移纬度：0.000083
						// 华实楼定点2：经度：117.368811 纬度：39.006760 偏移经度：0.000139 偏移纬度：0.000417
						// 华实楼定点3：经度：117.368452 纬度：39.005947 偏移经度：0.00022 偏移纬度：0.000396
						// 华实楼定点4：经度：117.369165 纬度：39.006259 偏移经度：0.000493 偏移纬度：0.000084
						// 
						// 工丽楼中心点：经度：117.370925 纬度：39.007456
						// 工丽楼定点1：经度：117.370356 纬度：39.007539 偏移经度：0.000569 偏移纬度：0.000083
						// 工丽楼定点2：经度：117.371091 纬度：39.007864 偏移经度：0.000166 偏移纬度：0.000408
						// 工丽楼定点3：经度：117.370785 纬度：39.007014 偏移经度：0.00014 偏移纬度：0.000442
						// 工丽楼定点4：经度：117.371515 纬度：39.007339 偏移经度：0.00059 偏移纬度：0.000117
						// 
						// 学生食堂中心点：经度：117.372009 纬度：39.006113
						// 学生食堂定点1：经度：117.371488 纬度：39.006093 偏移经度：0.000521 偏移纬度：0.00002
						// 学生食堂定点2：经度：117.372212 纬度：39.006443 偏移经度：0.000203 偏移纬度：0.00033
						// 学生食堂定点3：经度：117.371719 纬度：39.005876 偏移经度：0.00029 偏移纬度：0.000237
						// 学生食堂定点4：经度：117.372406 纬度：39.006159 偏移经度：0.000397 偏移纬度：0.000046
						// 
						// 报本楼中心点：经度：117.372910 纬度：39.005513
						// 报本楼定点1：经度：117.372556 纬度：39.005430 偏移经度：0.000354 偏移纬度：0.000083
						// 报本楼定点2：经度：117.373189 纬度：39.005738 偏移经度：0.000279 偏移纬度：0.000225
						// 报本楼定点3：经度：117.372599 纬度：39.005321 偏移经度：0.000311 偏移纬度：0.000192
						// 报本楼定点4：经度：117.373291 纬度：39.005617 偏移经度：0.000381 偏移纬度：0.000104
						// 
						// 一号公寓中心点：经度：117.373232 纬度：39.005109
						// 一号公寓定点1：经度：117.372888 纬度：39.005017 偏移经度：0.000344 偏移纬度：0.000092
						// 一号公寓定点2：经度：117.373446 纬度：39.005396 偏移经度：0.000214 偏移纬度：0.000287
						// 一号公寓定点3：经度：117.373591 纬度：39.005238 偏移经度：0.000359 偏移纬度：0.000129
						// 一号公寓定点4：经度：117.372974 纬度：39.004917 偏移经度：0.000258 偏移纬度：0.000192
						// 
						// 二号公寓中心点：经度：117.372545 纬度：39.004496
						// 二号公寓定点1：经度：117.372089 纬度：39.004400 偏移经度：0.000456 偏移纬度：0.000096
						// 二号公寓定点2：经度：117.372572 纬度：39.004796 偏移经度：0.000027 偏移纬度：0.0003
						// 二号公寓定点3：经度：117.372910 纬度：39.004596 偏移经度：0.000365 偏移纬度：0.0001
						// 二号公寓定点4：经度：117.372218 纬度：39.004258 偏移经度：0.000327 偏移纬度：0.000238
						// 
						// 三号公寓中心点：经度：117.371837 纬度：39.003900
						// 三号公寓定点1：经度：117.371359 纬度：39.003800 偏移经度：0.000478 偏移纬度：0.0001
						// 三号公寓定点2：经度：117.371896 纬度：39.004179 偏移经度：0.000059 偏移纬度：0.000279
						// 三号公寓定点3：经度：117.372186 纬度：39.004017 偏移经度：0.000349 偏移纬度：0.000117
						// 三号公寓定点4：经度：117.371504 纬度：39.003666 偏移经度：0.000333 偏移纬度：0.000234
						// 



						uni.chooseImage({
							count: 1,
							sizeType: ['original'],
							sourceType: ['camera'],
							success: function(res) {
								imageLocation = res.tempFilePaths;
								//console.log(searchMethods.doCheckPointer(39.006362, 117.368574, self_latitude, self_longitude, 0.0005, 0.0005,
								//	0.0005, 0.0005));

								//华实楼
								if (doCheckPointer(39.006362, 117.368574, self_latitude, self_longitude, 0.001, 0.001, 0.001,
										0.001)) {
									uni.showToast({
										title: '这里是华实楼',
									});
									imageName = "华实楼";
									return;
								} else
									//辑志楼
									if (doCheckPointer(39.0046370, 117.3635329, self_latitude, self_longitude, 0.001, 0.001, 0.001,
											0.001)) {
										uni.showToast({
											title: '这里是辑志楼',
										});
										imageName = "辑志楼";
										return;
									} else
										//工丽楼
										if (doCheckPointer(39.007496, 117.370870, self_latitude, self_longitude, 0.001, 0.001, 0.001,
												0.001)) {
											uni.showToast({
												title: '这里是工丽楼',
											});
											imageName = "工丽楼";
											return;
										} else
											//学生食堂
											if (doCheckPointer(39.006146, 117.371879, self_latitude, self_longitude, 0.001, 0.001, 0.001,
													0.001)) {
												uni.showToast({
													title: '这里是学生食堂',
												});
												imageName = "学生食堂";
												return;
											} else
												//报本楼
												if (doCheckPointer(39.005551, 117.372187, self_latitude, self_longitude, 0.001, 0.001, 0.001,
														0.001)) {
													uni.showToast({
														title: '这里是报本楼',
													});
													imageName = "报本楼";
													return;
												} else
													//一号宿舍
													if (doCheckPointer(39.005341, 117.372839, self_latitude, self_longitude, 0.001, 0.001, 0.001,
															0.001)) {
														uni.showToast({
															title: '这里是一号宿舍',
														});
														imageName = "一号宿舍";
														return;
													} else
														//二号宿舍
														if (doCheckPointer(39.004978, 117.372546, self_latitude, self_longitude, 0.001, 0.001, 0.001,
																0.001)) {
															uni.showToast({
																title: '这里是二号宿舍',
															});
															imageName = "二号宿舍";
															return;
														} else
															//三号宿舍
															if (doCheckPointer(39.004349, 117.371868, self_latitude, self_longitude, 0.001, 0.001,
																	0.001,
																	0.001)) {
																uni.showToast({
																	title: '这里是三号宿舍',
																});
																imageName = "三号宿舍";
																return;
															} else {
																uni.showToast({
																	title: '你没有在学校里哦',
																	icon: 'none'
																});
																imageName = "未知";




															}

								pageThis.chooseImage(res.tempFilePaths);

							}
						});
					},
					fail: (res) => {
						uni.showToast({
							title: '请打开GPS定位功能！',
							icon: 'none'
						})
					}


				});








			}
		}
	}
</script>

<style>
	.text-button {
		background-color: #c63a34;
		border-radius: 50upx;
		padding: 5upx 50upx 5upx 50upx;
		color: #fff;
		margin: auto;
		margin-left: 25upx;
		margin-right: 25upx;
		font-size: 30upx;
	}

	.four-button {
		width: 150upx;
		height: 150upx;
	}

	.cloud {
		width: 123upx;
		height: 71upx;
		position: absolute;
		animation-iteration-count: infinite;
		animation-timing-function: linear;
		animation-direction: normal;

	}

	.reverse {}

	.fire-balloon {
		position: absolute;
		left: 50upx;
		top: 100upx;
		width: 268upx;
		height: 379upx;
		transform: scale(1.0);
		z-index: -5;

		animation-name: fire-balloon-anim;
		animation-duration: 60s;
		animation-iteration-count: infinite;
		animation-timing-function: ease-out;
		animation-direction: normal;


	}

	@keyframes fire-balloon-anim {
		from {
			left: -512upx;
			top: 400upx;
		}

		to {
			left: 100%;
			top: -400upx;
		}
	}

	@keyframes cloud-right-1 {
		from {
			right: -500upx;
		}

		to {
			right: 1000upx;
		}
	}

	@keyframes cloud-left-1 {
		from {
			left: -500upx;
		}

		to {
			left: 1000upx;
		}
	}

	@keyframes blackboard-anim {
		from {
			transform: rotate(10deg);
		}

		to {
			transform: rotate(-10deg);
		}
	}

	.blackboard {
		animation-name: blackboard-anim;
		animation-duration: 6s;
		animation-iteration-count: infinite;
		animation-timing-function: ease-in-out;
		animation-direction: alternate;
	}

	.content {}

	.logo {}

	.title {}
</style>
