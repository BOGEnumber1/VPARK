<template>
	<view style="text-align: center;overflow: hidden;width: 100%;">

		<image src="../../../static/user_service_title.png" style="width: 250upx;height: 60upx;margin-top: 130upx;"></image>

		<!--<label>账号:</label>-->
		<view style="border-bottom-color: #ff0000;border-bottom-style: solid;border-bottom-width: 2upx;width: 250upx;margin: auto;padding-bottom: 25upx;margin-top: 100upx;">
			<text>用户设置</text>
		</view>
		<input type="text" placeholder="用户昵称" v-model="username" class="user_input" />
		<!--<label>密码:</label>-->
		<view style="border-bottom-color: #ff0000;border-bottom-style: solid;border-bottom-width: 2upx;width: 250upx;margin: auto;padding-bottom: 25upx;margin-top: 100upx;">
			<text>修改密码</text>
		</view>

		<input type="text" password="true" placeholder="新的密码" v-model="password" class="user_input" />
		<input type="text" password="true" placeholder="密码确认" v-model="passwordAgain" class="user_input" />

		<button @tap="change()" class="user_button" style="margin-top: 100upx;">修改</button>

		<image src="../../../static/user_service_bottom.png" style="position: absolute;bottom: 0upx;left: 0upx;width: 750upx;height: 162upx; z-index: -1;"></image>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				username: '',
				password: '',
				passwordAgain: '',
				locked: false,
			}
		},
		onLoad() {

			//this.local_id = uni.getStorageSync('local_id');


		},
		created: function() {

		},
		computed: {

		},
		methods: {


			back() {
				uni.navigateBack({
					delta: 1
				});
			},

			change() {

				if (this.locked) {
					uni.showToast({
						title: '请不要重复提交！耐心等待！',
						icon: 'none'
					})
					return;
				}

				this.locked = true;

				if (this.username.length <= 0 && (this.password.length <= 0 && this.passwordAgain.length <= 0)) {
					uni.showToast({
						title: '用户设置或密码修改不能为空！',
						icon: 'none'
					});
					this.locked = false;
					return;
				} else {







					if (this.username.length != 0) {


						uni.request({
							url: this.websiteUrl + '/user/changename',
							method: 'POST',
							header: {
								'Cookie': uni.getStorageSync('Cookie'),
								'Content-Type': 'application/x-www-form-urlencoded'
							},
							data: {
								username: this.username
							},
							dataType: 'json',
							success: res => {
								//console.log(res);
								if (res.data.code != 1) {

									uni.showToast({
										title: '修改用户名失败！请更换一个或者联系管理员！',
										icon: 'none'
									});
									return;
								}
								//uni.setStorageSync('Cookie', res["header"]["Set-Cookie "]);
								//plus.navigator.setCookie(this.websiteUrl,res["header"]["Set-Cookie "]);

								uni.showToast({
									title: '用户名修改成功！',
									icon: 'none',
								})

								//uni.setStorage('local_id',this.id);

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

										//this.back();
									}
								})


							},
							fail: res => {
								uni.showToast({
									title: '用户名修改请求失败！请检查网络',
									icon: 'none'
								});
							}
						})


					}

					if (this.password.length != 0 && this.passwordAgain.length != 0) {

						if (this.password != this.passwordAgain) {
							uni.showToast({
								title: '两次密码不一致！',
								icon: 'none'
							})
						} else {

							//console.log(this.websiteUrl+'/user/login');
							uni.request({
								url: this.websiteUrl + '/user/changepassword',
								method: 'POST',
								header: {
									'Cookie': uni.getStorageSync('Cookie'),
									'Content-Type': 'application/x-www-form-urlencoded'
								},
								data: {
									password: this.password
								},
								dataType: 'json',
								success: res => {
									//console.log(res);
									if (res.data.code != 1) {

										uni.showToast({
											title: '修改密码失败！请联系管理员！',
											icon: 'none'
										});
										return;
									}
									//uni.setStorageSync('Cookie', res["header"]["Set-Cookie "]);
									//plus.navigator.setCookie(this.websiteUrl,res["header"]["Set-Cookie "]);


									uni.showToast({
										title: '密码修改成功！',
										icon: 'none',
									})

									//uni.setStorage('local_id',this.id);




								},
								fail: res => {
									uni.showToast({
										title: '密码修改失败！请检查网络',
										icon: 'none'
									});
								}
							})

						}



					}




				}












				this.locked = false;
			}


		}
	}
</script>

<style>
	.user_button {

		background-color: #c63a34;
		color: #FFFFFF;
		width: 75%;
		padding-top: 10upx;
		padding-bottom: 10upx;
		border-radius: 60upx;
		margin-top: 40upx;
		font-size: 32upx;

	}

	.user_input {

		border-bottom: 2px solid #e9e9e9;
		width: 80%;
		padding-bottom: 10upx;
		margin-top: 50upx;
		margin-left: auto;
		margin-right: auto;
		text-align: left;
		font-size: 28upx;
		color: #000;

	}
</style>
