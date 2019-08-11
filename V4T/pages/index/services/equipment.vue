<template>
	<view>
		<view style="margin-top: 64upx;margin-left: 32upx;margin-bottom: 32upx;">
			<image src="../../../static/title_image.png" style="width: 651upx;height: 117upx;"></image>
		</view>
		<view style="text-align: center;">


			<image src="../../../static/box_2.png" class="box-style" @tap="openWeb('http://kq.teitc.cn:18070/dormitoryapp/static/dormtory/login.html?nsukey=FmLlHhRrAkZCZiQ%2FjTJOlzdTidiIz0kNc7ekPN%2Fj2u3GwHB1MUls447A2s2eVaFgTESzEDqZhQy9xKJ9IinJzChUcDfU89Iz1%2FiFrQRVr1rFB3ThEVjl%2BFrz5LgLs12E2eEugY4%2Ftr%2B%2BoiSOwhmmzYIAdGsVYncx6pKURzYB0NXrNNWOK8lNCwKdjVQRggKZcXBbTSDfRMHMMGr5DgC5Jw%3D%3D')"></image>

			

			


			


			<image src="../../../static/box_5.png" class="box-style" @tap="openWeb(0)"></image>
			
			<image src="../../../static/box_3.png" class="box-style" @tap="openWeb(0)"></image>

			<image src="../../../static/box_6.png" class="box-style" @tap="openWeb(0)"></image>

			
			
			
			
			<image src="../../../static/box_1.png" class="box-style" @tap="openWeb(0)"></image>
			
			<image src="../../../static/box_4.png" class="box-style" @tap="openWeb('http://www.tjl.tj.cn/Default.aspx')"></image>
			

		</view>
		
			<!--
			<image src="../../../static/user_service_bottom.png" style="position: absolute;bottom: 0upx;left: 0upx;width: 750upx;height: 162upx;"></image>
			-->
			<view style="width: 100%;text-align: center;margin-top: 100upx;">
			<text style="color: #004f99;font-weight: 700;font-size: 32upx;">去开拓·未知的未来</text>
			</view>
		
	</view>


</template>

<script>
	export default {
		data() {
			return {

			}
		},
		methods: {

			openWeb(address) {

				if (address == 0) {
					uni.showToast({
						title: '这个功能还未开放哦~',
						icon: 'none'
					});
					return;
				}
				
				plus.runtime.openWeb(address);
				
			},
		},
	}
</script>

<style>
	.box-style {
		width: 300upx;
		height: 246upx;
		margin-left: 24upx;
		margin-right: 24upx;
		margin-bottom: 24upx;

	}
</style>
