<template>
	<view style="text-align: center;overflow: hidden;width: 100%;">

		<image src="../../../static/user_service_title.png" style="width: 250upx;height: 60upx;margin-top: 180upx;" mode="aspectFill"></image>

		<!--<label>账号:</label>-->
		<view style="border-bottom-color: #ff0000;border-bottom-style: solid;border-bottom-width: 2upx;width: 250upx;margin: auto;padding-bottom: 25upx;margin-top: 100upx;">
			<text>登陆</text>
		</view>
		<input type="number" placeholder="请输入账号" v-model="id" class="user_input" />
		<!--<label>密码:</label>-->
		<input type="text" password="true" placeholder="请输入密码" v-model="password" class="user_input" />

		<button @tap="login()" class="user_button" style="margin-top: 100upx;">登陆</button>
		<button @tap="gotoRegister()" class="user_button">注册</button>

		<image src="../../../static/user_service_bottom.png" style="position: absolute;bottom: 0upx;left: 0upx;width: 750upx;height: 162upx;"></image>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				password: '',
				islocked:false,
			}
		},
		onLoad() {

			let local_id = uni.getStorageSync('local_id');
				
			if(local_id.length!=0){
				
				this.id = local_id;
				
				
			}


		},
		onShow() {
			
			let new_local_id = uni.getStorageSync('new_local_id');
			
			if(new_local_id.length!=0){
				
				this.id = new_local_id;
				uni.setStorageSync('local_id',new_local_id);
				uni.removeStorageSync('new_local_id');
				
			}
			
		},
		created: function() {

		},
		computed: {

		},
		methods: {

			gotoRegister(){
				
				uni.navigateTo({
					url: './register',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
				
				
				
			},

			back() {
				uni.navigateBack({
					delta: 1
				});
			},

			login() {
				
				if(this.islocked){
					uni.showToast({
						title: '请不要多次点击！',
						icon: 'none'
					});
					return ;
				}
				
				this.islocked=true;
				
				if (this.id.length <= 0 || this.password.length <= 0) {
					uni.showToast({
						title: '账号或密码不能为空！',
						icon: 'none'
					});
					this.islocked=false;
					return;
				} else {
					//console.log(this.websiteUrl+'/user/login');
					uni.request({
						url: this.websiteUrl + '/user/login',
						method: 'POST',
						header: {
							'Content-Type': 'application/x-www-form-urlencoded'
						},
						data: {
							id: this.id,
							password: this.password
						},
						dataType: 'json',
						success: res => {
							//console.log(res);
							if (res.data.code != 1) {
								//console.log(res);
								uni.showToast({
									title: '登陆失败！请检查用户名与密码是否正确！',
									icon: 'none'
								});
								this.islocked=false;
								return;
							}
							uni.showToast({
								title: '登陆成功！',
								icon: 'none'
							})
							uni.setStorageSync('Cookie', res["header"]["Set-Cookie "]);
							//plus.navigator.setCookie(this.websiteUrl,res["header"]["Set-Cookie "]);


							uni.setStorageSync('local_id',this.id);


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
									//console.log("save:"+localuser);
									uni.setStorageSync('localuser', localuser);

									uni.request({
										url: this.websiteUrl + '/user/time',
										method: 'GET',
										header: {
											'Cookie': uni.getStorageSync('Cookie'),
										},
										dataType: 'json',

										success: resx => {
											//console.log(resx);
											let time = resx.data.data;
											//console.log("save:"+localuser);
											uni.setStorageSync('localtime', time);
										}

									});

									this.islocked=false;
									this.back();
								}
							})




						},
						fail: res => {
							uni.showToast({
								title: '登陆请求失败！请检查网络',
								icon: 'none'
							});
						}
					})

				}

			}


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
		
		.user_input{
			
			border-bottom: 2px solid #e9e9e9;
			width: 80%;
			padding-bottom: 10upx;
			margin-top: 50upx ;
			margin-left: auto;
			margin-right: auto;
			text-align: left;
			font-size: 28upx;
			color: #000;
			
		}
	
	
</style>
