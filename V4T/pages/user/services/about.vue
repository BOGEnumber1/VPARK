<template>
	<view style="background-color: #fff;overflow: hidden;">
		<view  style="text-align: center;width: 100%;margin-top: 200upx;">
			<image  src="../../../static/image_about.png" style=" width: 269upx;height: 226upx;position: relative;" class="image-anim" @tap="goto()"></image>
		</view>
		<view style="text-align: center;margin-top: 50upx;">
			<text style="font-size: 30upx;">SINCE 2013</text>
		</view>
		<view style="text-align: center;position: absolute;bottom: 100upx;width: 100%;">
			<view>
				<text style="font-size: 20upx;">VagaryPark</text>
			</view>
			<view>
				<text style="font-size: 20upx;">Copyright © 2019 V4-TSteam Workshop .ALL Rights Reserved.</text>
			</view>
		</view>
	</view>
</template>

<script>
	let number = 0;

	export default {
		data() {
			return {
			}
		},
		onLoad() {

		},
		onReady: function() {
			/*
			var animx = uni.createAnimation({
				duration: 100,
				timingFunction: "ease-out",
				transformOrigin: "center center",


			})
			this.animx=animx;
			
			*/ /*
			var next = 0;
			
			
			setInterval(function(){
				console.log(next);
				switch(next){
					case 0:
					this.anim.scale(1.0).step();
					break;
					case 1:
					this.anim.scale(1.25).step();
					break;
					case 2:
					this.anim.scale(1.5).step();
					break;
					case 3:
					this.anim.scale(1.25).step();
					break;
					case 4:
					this.anim.scale(1.5).step();
						next=-1;
						break;
				}
				
				next++;
				
			}.bind(this),500)
			
			
			*/
		},
		methods: {

			goto() {
				/*
				if(number%2!=0){
					this.animx.scale(1.5).step();
				}else{
					this.animx.scale(1.0).step();
				}
				console.log(number%2);
				*/
				
				if (number < 10 - 1) {
					number++;
					if (10 - number <= 5) {
						uni.showToast({
							title: '再点击' + (10 - number) + '下进入彩蛋',
							mask: false,
							icon: 'none',
							duration: 500
						});
					}
					return;
				}
				uni.navigateTo({
					url: '/pages/first/first',
					success: res => {
						number = 0
					},
					fail: () => {},
					complete: () => {}
				});
			}
		},
		computed: {

		}
	}
</script>

<style>
	.image-anim{
		animation-name: xfirst;
		animation-duration: 2s;
		animation-delay: 30s;
		animation-iteration-count: infinite;
		animation-timing-function: ease-in-out;
		animation-direction: alternate;
	}
	
	/*
	@keyframes xfirst{
		0% {left: 0%;bottom: 0upx;transform: rotate(0deg);}
		25% {left: 25%;bottom: 40upx;transform: rotate(60deg);}
		50% {left: -25%;bottom:80upx;transform: rotate(-60deg);}
		75% {left: 50%;bottom: 120upx;transform: rotate(180deg);}
		100% {left: -50%;bottom: 160upx;transform: rotate(-180deg);}
		}
	*/
	
   @keyframes xfirst{
   	from{transform: rotateY(0deg);}
   	to{transform: rotateY(360deg);}
   }
	
	
	
</style>
