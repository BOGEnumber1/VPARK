<template style="overflow: hidden;">
	<view>
		<view>
			<map style="width: 750upx;height: 1000upx;" :latitude="latitude" :longitude="longitude" :markers="covers"></map>
		</view>
		<!--
		<view style="width: 100%;height: 64upx;text-align: center;background-color: #00BFFF;">
			<text style="color: #FFFFFF;">快速导航</text>
		</view>
		-->
		<view v-for="(item,index) in covers" :key="item">
			<view style="width: 100%;height: 64upx;text-align: center;border-bottom: 1upx solid #F0F0F0;padding-top: 16upx;padding-bottom: 16upx;" v-on:tap="getSchoolLocation(item.latitude,item.longitude,item.title)">
			 
			<!--<image src="../../../static/location64.png" style="position: absolute;left: 64upx;width: 32upx;height: 32upx;"></image>-->
			 <text>{{item.title}}</text>


			</view>
		</view>


	</view>

</template>

<script>
	export default {

		data() {
			return {
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
		methods: {
			getSchoolLocation(la, lo,na) {

				uni.openLocation({
					latitude: la,
					longitude: lo,
					scale:18,
					name:"天津市仪表无线电工业学校-"+na,
					address:"天津市津南区咸水沽镇海河教育园区雅深路6号-"+na,
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



			}
		}
	}
</script>

<style>
</style>
