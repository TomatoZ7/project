(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-502601af"],{"159b":function(t,a,e){var r=e("da84"),o=e("fdbc"),i=e("17c2"),n=e("9112");for(var s in o){var c=r[s],l=c&&c.prototype;if(l&&l.forEach!==i)try{n(l,"forEach",i)}catch(u){l.forEach=i}}},"17c2":function(t,a,e){"use strict";var r=e("b727").forEach,o=e("a640"),i=e("ae40"),n=o("forEach"),s=i("forEach");t.exports=n&&s?[].forEach:function(t){return r(this,t,arguments.length>1?arguments[1]:void 0)}},4160:function(t,a,e){"use strict";var r=e("23e7"),o=e("17c2");r({target:"Array",proto:!0,forced:[].forEach!=o},{forEach:o})},"4de4":function(t,a,e){"use strict";var r=e("23e7"),o=e("b727").filter,i=e("1dde"),n=e("ae40"),s=i("filter"),c=n("filter");r({target:"Array",proto:!0,forced:!s||!c},{filter:function(t){return o(this,t,arguments.length>1?arguments[1]:void 0)}})},5530:function(t,a,e){"use strict";e.d(a,"a",(function(){return i}));e("a4d3"),e("4de4"),e("4160"),e("e439"),e("dbb4"),e("b64b"),e("159b");var r=e("ade3");function o(t,a){var e=Object.keys(t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(t);a&&(r=r.filter((function(a){return Object.getOwnPropertyDescriptor(t,a).enumerable}))),e.push.apply(e,r)}return e}function i(t){for(var a=1;a<arguments.length;a++){var e=null!=arguments[a]?arguments[a]:{};a%2?o(Object(e),!0).forEach((function(a){Object(r["a"])(t,a,e[a])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(e)):o(Object(e)).forEach((function(a){Object.defineProperty(t,a,Object.getOwnPropertyDescriptor(e,a))}))}return t}},7339:function(t,a,e){},a2c2:function(t,a,e){"use strict";var r=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"book_info"},[e("h2",[t._v("书籍信息")]),e("a-form",{attrs:{labelAlign:"right"}},[e("a-row",{staticClass:"layout_row",attrs:{type:"flex",gutter:[32]}},[t._l(t.formItem,(function(a,r){return["classify"===a.val?[e("a-col",{key:r,attrs:{sm:24,lg:12,xl:8}},[e("a-form-item",{attrs:{label:a.label,required:""}},[e("a-select",{attrs:{options:t.firstCateOptions,placeholder:"一级分类",allowClear:""},model:{value:t.params[a.first],callback:function(e){t.$set(t.params,a.first,e)},expression:"params[item.first]"}}),e("a-select",{attrs:{options:t.secondCateOptions,placeholder:"二级分类",allowClear:""},model:{value:t.params[a.second],callback:function(e){t.$set(t.params,a.second,e)},expression:"params[item.second]"}})],1)],1)]:"image"===a.val?[e("a-col",{key:r,attrs:{sm:24}},[e("a-form-item",{attrs:{label:a.label,required:""}},[e("a-upload",{staticClass:"avatar-uploader",attrs:{name:"file","list-type":"picture-card","show-upload-list":!1,action:""+t.proxy+t.prefix+"/upload/upload"},on:{change:t.handleImageChange}},[t.params.image?e("div",{staticClass:"bg_img book_img",style:"background-image: url("+t.prefix+"/cbh_file/"+t.params.image+");"}):e("div",[e("a-icon",{attrs:{type:t.imgLoading?"loading":"plus"}}),e("div",{staticClass:"ant-upload-text"},[t._v(" Upload ")])],1)])],1)],1)]:"introduction"===a.val?[e("a-col",{key:r,attrs:{sm:24,lg:12,xl:8}},[e("a-form-item",{attrs:{label:a.label,required:""}},[e("a-input",{attrs:{type:"textarea",rows:5},model:{value:t.params[a.val],callback:function(e){t.$set(t.params,a.val,e)},expression:"params[item.val]"}})],1)],1)]:[e("a-col",{key:r,attrs:{sm:24,lg:12,xl:8}},[e("a-form-item",{attrs:{label:a.label,required:""}},[e("a-input",{model:{value:t.params[a.val],callback:function(e){t.$set(t.params,a.val,e)},expression:"params[item.val]"}})],1)],1)]]}))],2)],1),e("div",{staticStyle:{padding:"0 30px"}},[e("a-button",{staticStyle:{"margin-right":"20px"},attrs:{type:"primary"},on:{click:t.handleSubmit}},[t._v(" 创建 ")]),e("a-button",{attrs:{type:"danger"},on:{click:t.cancleSubmit}},[t._v("取消")])],1)],1)},o=[],i=(e("4de4"),e("d81d"),e("5530")),n=e("2f62"),s={name:"BookForm",components:{},props:{detail:{type:Object,default:function(){}}},data:function(){var t={book_name:"",author:"",first_category_id:void 0,second_category_id:void 0,stock:"",book_code:"",place:"",image:"",introduction:""},a=[{label:"书籍名称",val:"book_name"},{label:"书籍作者",val:"author"},{label:"书籍分类",val:"classify",first:"first_category_id",second:"second_category_id"},{label:"馆藏量",val:"stock"},{label:"书籍编码",val:"book_code"},{label:"书籍位置",val:"place"},{label:"书籍图片",val:"image"},{label:"书籍简介",val:"introduction"}];return{params:t,formItem:a,imageUrl:"",imgLoading:!1,proxy:"/city_book",prefix:""}},computed:Object(i["a"])(Object(i["a"])({},Object(n["c"])("booksManage",["allCategoryList"])),{},{secondCateOptions:function(){var t=this;return this.allCategoryList&&this.allCategoryList.second&&this.allCategoryList.second.filter((function(a){return a.pid===t.params.first_category_id})).map((function(t){return{label:t.category_name,value:t.id}}))},firstCateOptions:function(){return this.allCategoryList&&this.allCategoryList.first&&this.allCategoryList.first.map((function(t){return{label:t.category_name,value:t.id}}))}}),watch:{detail:function(){this.params=Object.assign({},this.params,this.detail)}},methods:{handleSubmit:function(){this.$emit("submit",this.params)},cancleSubmit:function(){this.$router.push("/admin/book/manage"),console.log("cancel submit")},handleImageChange:function(t){"uploading"===t.file.status&&(this.params.image="",this.imgLoading=!0),"done"===t.file.status&&(this.params.image=t.file.response.data,this.imgLoading=!1)}},created:function(){this.params=Object.assign({},this.params,this.detail)}},c=s,l=(e("f7f7"),e("2877")),u=Object(l["a"])(c,r,o,!1,null,"ac41d7fa",null);a["a"]=u.exports},ade3:function(t,a,e){"use strict";function r(t,a,e){return a in t?Object.defineProperty(t,a,{value:e,enumerable:!0,configurable:!0,writable:!0}):t[a]=e,t}e.d(a,"a",(function(){return r}))},b64b:function(t,a,e){var r=e("23e7"),o=e("7b0b"),i=e("df75"),n=e("d039"),s=n((function(){i(1)}));r({target:"Object",stat:!0,forced:s},{keys:function(t){return i(o(t))}})},c69a:function(t,a,e){"use strict";e.r(a);var r=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"create_book"},[e("div",{staticClass:"nav"},[e("a-breadcrumb",[e("a-breadcrumb-item",[e("router-link",{attrs:{to:"/admin/home"}},[t._v("首页")])],1),e("a-breadcrumb-item",[e("router-link",{attrs:{to:"/admin/book/manage"}},[t._v("书籍管理")])],1),e("a-breadcrumb-item",[t._v("创建书籍")])],1)],1),e("book-form",{on:{submit:t.handleSubmit}})],1)},o=[],i=e("5530"),n=e("a2c2"),s=e("2f62"),c={name:"CreateBook",components:{BookForm:n["a"]},methods:Object(i["a"])(Object(i["a"])({},Object(s["b"])("booksManage",{addBooks:"addBooks"})),{},{handleSubmit:function(t){var a=this;this.addBooks(t).then((function(t){a.$message.success(t.message),a.$router.push({name:"Book Manage"})}))}})},l=c,u=e("2877"),f=Object(u["a"])(l,r,o,!1,null,null,null);a["default"]=f.exports},d81d:function(t,a,e){"use strict";var r=e("23e7"),o=e("b727").map,i=e("1dde"),n=e("ae40"),s=i("map"),c=n("map");r({target:"Array",proto:!0,forced:!s||!c},{map:function(t){return o(this,t,arguments.length>1?arguments[1]:void 0)}})},dbb4:function(t,a,e){var r=e("23e7"),o=e("83ab"),i=e("56ef"),n=e("fc6a"),s=e("06cf"),c=e("8418");r({target:"Object",stat:!0,sham:!o},{getOwnPropertyDescriptors:function(t){var a,e,r=n(t),o=s.f,l=i(r),u={},f=0;while(l.length>f)e=o(r,a=l[f++]),void 0!==e&&c(u,a,e);return u}})},e439:function(t,a,e){var r=e("23e7"),o=e("d039"),i=e("fc6a"),n=e("06cf").f,s=e("83ab"),c=o((function(){n(1)})),l=!s||c;r({target:"Object",stat:!0,forced:l,sham:!s},{getOwnPropertyDescriptor:function(t,a){return n(i(t),a)}})},f7f7:function(t,a,e){"use strict";e("7339")}}]);
//# sourceMappingURL=chunk-502601af.e932838d.js.map