(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/search/search"],{"203e":function(t,e,o){"use strict";(function(t){function o(t,e,o,n,i,a,s,c){var l=t+i,u=t-s,r=e+a,d=e-c;return o>=u&&o<=l&&n>=d&&n<=r}Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n={data:function(){return{hasChooseImg:"",blackboard_url:"../../static/blackboard_empty.png",day:"请先登录",number:null,board_title:"标题",board_text:"我们要改变世界！",title:"天津市仪表无线电工业学学校",latitude:39.005678,longitude:117.370796,covers:[{title:"华实楼",latitude:39.006362,longitude:117.368574,iconPath:"/static/location32.png"},{title:"辑志楼",latitude:39.006238,longitude:117.370292,iconPath:"/static/location32.png"},{title:"工丽楼",latitude:39.007496,longitude:117.37087,iconPath:"/static/location32.png"},{title:"学生食堂",latitude:39.006146,longitude:117.371879,iconPath:"/static/location32.png"},{title:"报本楼",latitude:39.005551,longitude:117.372187,iconPath:"/static/location32.png"},{title:"一号宿舍",latitude:39.005341,longitude:117.372839,iconPath:"/static/location32.png"},{title:"二号宿舍",latitude:39.004978,longitude:117.372546,iconPath:"/static/location32.png"},{title:"三号宿舍",latitude:39.004349,longitude:117.371868,iconPath:"/static/location32.png"}],localdate:null,signdate:null,isReady:!1,locked:!1}},onReady:function(){var e=this,o=new Date;this.localdate=o.getFullYear()+"-"+Number(o.getMonth()+1)+"-"+o.getDate(),this.signdate=t.getStorageSync("sign_date"),this.isReady=!0,null==t.getStorageSync("localuser")?this.day="请先登录":this.getsign(),t.request({url:this.resourceUrl+"/img/blackboard.png",method:"GET",success:function(t){200==t.statusCode&&(e.blackboard_url=e.resourceUrl+"/img/blackboard.png")},fail:function(){},complete:function(){}})},onShow:function(){this.isReady&&(null==t.getStorageSync("localuser")?this.day="请先登录":this.getsign())},methods:{getSchoolLocation:function(){t.openLocation({latitude:39.005678,longitude:117.370796,scale:18,name:"天津市仪表无线电工业学校",address:"天津市津南区咸水沽镇海河教育园区雅深路6号",success:function(){},fail:function(){t.showToast({title:"打开失败！请检查地图和GPS功能是否可以用！",icon:"none"})}})},setMapLocation:function(){t.navigateTo({url:"services/map",success:function(t){},fail:function(){},complete:function(){}})},getsign:function(){var e=this;if(this.localdate==this.signdate&&t.getStorageInfoSync("localsignnumber").length>0)return this.number=t.getStorageSync("localsignnumber"),void(this.day="打卡"+this.number+"天");t.removeStorageSync("localsignnumber"),t.request({url:this.websiteUrl+"/sign/getSign",method:"GET",header:{Cookie:t.getStorageSync("Cookie")},dataType:"json",success:function(o){e.number=o.data.data,t.setStorageSync("localsignnumber",o.data.data),null!=e.number?e.day="打卡"+e.number+"天":e.day="请重试！"}})},dosign:function(){var e=this;return this.locked&&t.showToast({title:"请等一下再点击哦",icon:"none"}),this.locked=!0,null==t.getStorageSync("localuser")?(t.showToast({title:"请先登录哦再签到哦！",icon:"none"}),void(this.locked=!1)):this.localdate==this.signdate?(t.showToast({title:"今天已经签到啦！明天再来吧~",icon:"none"}),void(this.locked=!1)):(t.removeStorageSync("sign_date"),this.signdate=null,t.request({url:this.websiteUrl+"/sign/doSign",method:"POST",header:{Cookie:t.getStorageSync("Cookie")},dataType:"json",success:function(o){switch(o.data.data){case 100:t.showToast({title:"签到成功！",icon:"none"});var n=new Date,i=n.getFullYear()+"-"+Number(n.getMonth()+1)+"-"+n.getDate();t.setStorageSync("sign_date",i),t.removeStorageSync("localsignnumber"),e.getsign();break;case 101:t.showToast({title:"签到发生错误！",icon:"none"});break;case 102:t.showToast({title:"您已经签到了哦！",icon:"none"});n=new Date,i=n.getFullYear()+"-"+Number(n.getMonth()+1)+"-"+n.getDate();t.setStorageSync("sign_date",i),t.removeStorageSync("localsignnumber"),e.getsign();break;default:t.showToast({title:"啊哦，服务器好像出错了！",icon:"none"});break}},fail:function(e){t.showToast({title:"啊哦，服务器好像有点问题？",icon:"none"})}}),void(this.locked=!1))},goto:function(e){t.navigateTo({url:e,success:function(t){},fail:function(){t.showToast({title:"打开失败！请检查网络是否良好！",icon:"none",mask:!1,duration:1500})}})},openBadge:function(){null!=t.getStorageSync("localuser")?t.navigateTo({url:"services/badge",success:function(t){},fail:function(){},complete:function(){}}):t.showToast({title:"请先登录！",icon:"none"})},openVR:function(){plus.runtime.openWeb("https://720yun.com/t/2f9jOOsuvv7")},getImageFromCarema:function(){var e,n,i=this;null!=t.getStorageSync("localuser")?t.getLocation({type:"gcj02",success:function(a){e=a.latitude,n=a.longitude,t.chooseImage({count:1,sizeType:["original"],sourceType:["camera"],success:function(a){return a.tempFilePaths,o(39.006362,117.368574,e,n,.001,.001,.001,.001)?(t.showToast({title:"这里是华实楼"}),void"华实楼"):o(39.004637,117.3635329,e,n,.001,.001,.001,.001)?(t.showToast({title:"这里是辑志楼"}),void"辑志楼"):o(39.007496,117.37087,e,n,.001,.001,.001,.001)?(t.showToast({title:"这里是工丽楼"}),void"工丽楼"):o(39.006146,117.371879,e,n,.001,.001,.001,.001)?(t.showToast({title:"这里是学生食堂"}),void"学生食堂"):o(39.005551,117.372187,e,n,.001,.001,.001,.001)?(t.showToast({title:"这里是报本楼"}),void"报本楼"):o(39.005341,117.372839,e,n,.001,.001,.001,.001)?(t.showToast({title:"这里是一号宿舍"}),void"一号宿舍"):o(39.004978,117.372546,e,n,.001,.001,.001,.001)?(t.showToast({title:"这里是二号宿舍"}),void"二号宿舍"):o(39.004349,117.371868,e,n,.001,.001,.001,.001)?(t.showToast({title:"这里是三号宿舍"}),void"三号宿舍"):(t.showToast({title:"你没有在学校里哦",icon:"none"}),"未知",void i.chooseImage(a.tempFilePaths))}})},fail:function(e){t.showToast({title:"请打开GPS定位功能！",icon:"none"})}}):t.showToast({title:"请先登录哦！",icon:"none"})}}};e.default=n}).call(this,o("6e42")["default"])},"26df":function(t,e,o){"use strict";o.r(e);var n=o("c103"),i=o("fce5");for(var a in i)"default"!==a&&function(t){o.d(e,t,function(){return i[t]})}(a);o("c320");var s=o("2877"),c=Object(s["a"])(i["default"],n["a"],n["b"],!1,null,null,null);e["default"]=c.exports},3921:function(t,e,o){},c103:function(t,e,o){"use strict";var n=function(){var t=this,e=t.$createElement;t._self._c},i=[];o.d(e,"a",function(){return n}),o.d(e,"b",function(){return i})},c320:function(t,e,o){"use strict";var n=o("3921"),i=o.n(n);i.a},fce5:function(t,e,o){"use strict";o.r(e);var n=o("203e"),i=o.n(n);for(var a in n)"default"!==a&&function(t){o.d(e,t,function(){return n[t]})}(a);e["default"]=i.a}},[["057a","common/runtime","common/vendor"]]]);