<template>

	<view style="overflow: hidden;width: 100%;height: 1377upx;">
		<image style="width: 750upx;height: 1377upx;position: absolute;left: 0upx;right: 0upx;z-index: -10;" src="../../static/lite_wallpaper.jpg">

		</image>
		<image src="../../static/blackboard.png" style="width: 354upx;height: 279upx;position: absolute;right: 45upx;top: 0upx;z-index: 5;"></image>


		<view style="width: 100%;height: 100%;position: absolute;">
			<view style="width: 85%;height: 350upx;margin-left: auto;margin-right: auto;margin-top: 500upx;box-shadow: 0px 0px 5px #777;">
				<map style="width: 100%;height: 100%;" :latitude="latitude" :longitude="longitude" :markers="covers"></map>
			</view>

			<view style="width: 100%;text-align: center;margin-top: 48upx;height: 125upx;">
				<image src="../../static/btn_1.png" class="four-button" @tap="getSchoolLocation()" ></image>
				<image src="../../static/btn_2.png" class="four-button" @tap="setMapLocation()"></image>
				<!--
				<image src="../../static/btn_3.png" class="four-button" @tap="getImageFromCarema()"></image>
				-->
			</view>
			
			
		<image style="width: 750upx;height: 177upx;margin-top: 142upx;" src="../../static/lite_bottom.png">

		</image>
		<view style="width: 100%;text-align: center;margin-top: 32upx;">
			<image style="width: 457upx;height: 47upx;" src="../../static/bottom_version.png" @tap="doSpecial()">

			</image>
		</view>
			
		</view>




	</view>
</template>

<script>
	export default {
		data() {
			return {
				specialNumber: 13,
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



			}
		},
		onLoad() {

		},
		methods: {

			doSpecial() {
				this.specialNumber--;
				if (this.specialNumber <= 0 ) {

					this.specialNumber = 13;

					uni.navigateTo({
						url: 'services/special',
						success: res => {},
						fail: () => {},
						complete: () => {}
					});

				} else {
					
				}

				if (this.specialNumber <3) {
					uni.showToast({
						title: '再点击' + this.specialNumber + '下进入彩蛋',
						icon: 'none'
					});
				}



			},

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

			}
		}
	}
</script>

<style>
	.four-button {
		width: 150upx;
		height: 150upx;
		margin-left: 64upx;
		margin-right: 64upx;
	}
</style>
