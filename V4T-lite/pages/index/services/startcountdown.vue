<template>
	<view style="width: 100%;overflow: hidden;">
		<image src="../../../static/countdown_wallpaper.png" style="width: 750upx;height: 1551upx;position: absolute;left: 0upx;top: 0upx;z-index: -1;"></image>
		<view style="width: 100%;height: 200upx;background-color: #cc3333;position: absolute;top: 800upx;left: 0upx;z-index: 0;text-align: center;"
 v-show="isNotEnd">
			<view style="color: #FFFFFF;margin-top: 32upx;">
				<text>上线倒计时</text>
			</view>
			<view style="color: #FFFFFF;font-size: 64upx;margin-top: 8upx;">
				<text>{{countdown}}</text>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {

			return {
				countdown: '00 : 00 : 00 : 00',
				timer: null,
				isNotEnd: false
			}
		},
		created() {
			

			
			
			var dataThis = this;



			var checkTime = function(i) {
				if (i < 10) {
					i = "0" + i;
				}
				return i;
			}


			var leftTimeX = (new Date(2019, 9 - 1, 9, 20, 0, 0)) - (new Date());
			if (leftTimeX <= 0) {
				
				console.log('Pass Countdown!');
				this.isNotEnd=false;
				
					uni.redirectTo({
						url: '../index'
					});
				
				return;
			} else {
				this.isNotEnd = true;
				console.log('Do Countdown!');
			}


			var leftTimer = function(year, month, day, hour, minute, second) {
				var leftTime = (new Date(year, month - 1, day, hour, minute, second)) - (new Date()); //计算剩余毫秒数
				var days = parseInt(leftTime / 1000 / 60 / 60 / 24, 10); //计算剩余天数
				var hours = parseInt(leftTime / 1000 / 60 / 60 % 24, 10); //计算剩余小时数
				var minutes = parseInt(leftTime / 1000 / 60 % 60, 10); //计算剩分钟数
				var seconds = parseInt(leftTime / 1000 % 60, 10); //计算剩余秒数




				days = checkTime(days).toString();
				hours = checkTime(hours).toString();
				minutes = checkTime(minutes).toString();
				seconds = checkTime(seconds).toString();
				
				if (leftTime <= 0) {


					clearInterval(dataThis.timer);
					uni.redirectTo({
						url: '../index'
					});

					return;
				} else {

					return days + ' : ' + hours + ' : ' + minutes + ' : ' + seconds
				}
				

			}

			dataThis.countdown = leftTimer(2019, 9, 9, 20, 0, 0);
			dataThis.timer = setInterval(function() {
				dataThis.countdown = leftTimer(2019, 9, 9, 20, 0, 0);




			}, 1000)
			

			

		},



		methods: {



		}
	}
</script>

<style>
	page {
		background-color: #fff;
	}
</style>
