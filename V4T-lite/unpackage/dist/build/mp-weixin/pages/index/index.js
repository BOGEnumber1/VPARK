(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/index/index"],{"03dd":function(t,n,i){"use strict";i.r(n);var e=i("5b10"),o=i("5252");for(var a in o)"default"!==a&&function(t){i.d(n,t,function(){return o[t]})}(a);i("202b");var c=i("2877"),u=Object(c["a"])(o["default"],e["a"],e["b"],!1,null,null,null);n["default"]=u.exports},"202b":function(t,n,i){"use strict";var e=i("df80"),o=i.n(e);o.a},5252:function(t,n,i){"use strict";i.r(n);var e=i("5a47"),o=i.n(e);for(var a in e)"default"!==a&&function(t){i.d(n,t,function(){return e[t]})}(a);n["default"]=o.a},"5a47":function(t,n,i){"use strict";(function(t){Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var i={data:function(){return{specialNumber:13,title:"天津市仪表无线电工业学学校",latitude:39.005678,longitude:117.370796,covers:[{title:"华实楼",latitude:39.006362,longitude:117.368574,iconPath:"/static/location32.png"},{title:"辑志楼",latitude:39.006238,longitude:117.370292,iconPath:"/static/location32.png"},{title:"工丽楼",latitude:39.007496,longitude:117.37087,iconPath:"/static/location32.png"},{title:"学生食堂",latitude:39.006146,longitude:117.371879,iconPath:"/static/location32.png"},{title:"报本楼",latitude:39.005551,longitude:117.372187,iconPath:"/static/location32.png"},{title:"一号宿舍",latitude:39.005341,longitude:117.372839,iconPath:"/static/location32.png"},{title:"二号宿舍",latitude:39.004978,longitude:117.372546,iconPath:"/static/location32.png"},{title:"三号宿舍",latitude:39.004349,longitude:117.371868,iconPath:"/static/location32.png"}]}},onLoad:function(){},methods:{doSpecial:function(){this.specialNumber--,this.specialNumber<=0&&(this.specialNumber=13,t.navigateTo({url:"services/special",success:function(t){},fail:function(){},complete:function(){}})),this.specialNumber<3&&t.showToast({title:"再点击"+this.specialNumber+"下进入彩蛋",icon:"none"})},getSchoolLocation:function(){t.openLocation({latitude:39.005678,longitude:117.370796,scale:18,name:"天津市仪表无线电工业学校",address:"天津市津南区咸水沽镇海河教育园区雅深路6号",success:function(){},fail:function(){t.showToast({title:"打开失败！请检查地图和GPS功能是否可以用！",icon:"none"})}})},setMapLocation:function(){t.navigateTo({url:"services/map",success:function(t){},fail:function(){},complete:function(){}})}}};n.default=i}).call(this,i("543d")["default"])},"5b10":function(t,n,i){"use strict";var e=function(){var t=this,n=t.$createElement;t._self._c},o=[];i.d(n,"a",function(){return e}),i.d(n,"b",function(){return o})},df80:function(t,n,i){}},[["14fa","common/runtime","common/vendor"]]]);