import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false
Vue.prototype.websiteUrl = 'http://vpark.tukan.studio:8080/VparkAppServer/'
Vue.prototype.resourceUrl = 'http://vpark.tukan.studio:9090/'
//Vue.prototype.websiteUrl = 'http://192.168.18.5:8080/'
App.mpType = 'app'

const app = new Vue({
    ...App
})
app.$mount()
