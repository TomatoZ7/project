# -*- coding:utf-8 -*-

import re
import os
import requests
from lxml import etree

str = """
<!DOCTYPE html>
<!--[if IE 6]><html class="ie lt-ie8"><![endif]-->
<!--[if IE 7]><html class="ie lt-ie8"><![endif]-->
<!--[if IE 8]><html class="ie ie8"><![endif]-->
<!--[if IE 9]><html class="ie ie9"><![endif]-->
<!--[if !IE]><!--> <html> <!--<![endif]-->

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">

  <!-- Start of Baidu Transcode -->
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <meta http-equiv="Cache-Control" content="no-transform" />
  <meta name="applicable-device" content="pc,mobile">
  <meta name="MobileOptimized" content="width"/>
  <meta name="HandheldFriendly" content="true"/>
  <meta name="mobile-agent" content="format=html5;url=https://www.jianshu.com/c/bDHhpK?order_by=commented_at&amp;page=1">
  <!-- End of Baidu Transcode -->

    <meta name="description"  content="原首页投稿专题

现暂停使用。

具体请查看：简书新版发现页文章推荐系统上线公告 https://www.jianshu.com/p/6c47b3244644">

  <meta name="tencent-site-verification" content="39a5ed77a02c0103af6ac08addbc3851"/>
  <meta name="360-site-verification" content="604a14b53c6b871206001285921e81d8" />
  <meta property="wb:webmaster" content="294ec9de89e7fadb" />
  <meta property="qc:admins" content="104102651453316562112116375" />
  <meta property="qc:admins" content="11635613706305617" />
  <meta property="qc:admins" content="1163561616621163056375" />
  <meta name="google-site-verification" content="6ARJIxhZLIgZT7J8MZkENr5mR0-CqshgzYyA3r3jBWU" />
  <meta http-equiv="mobile-agent" content="format=html5; url=https://www.jianshu.com/c/bDHhpK?order_by=commented_at&amp;page=1">

  <!-- Apple -->
  <meta name="apple-mobile-web-app-title" content="简书">

  

    <title>首页投稿（暂停使用，暂停投稿） - 专题 - 简书</title>

  <meta name="csrf-param" content="authenticity_token" />
<meta name="csrf-token" content="a4ApazjIM2tPxqhDfPPMhajeSS3Y2EqJ7yAo2Fly4slJMYHX6B82I3DtkBQtUfIXP7yJ18NHYckds+8Yx23t4w==" />

  <!--<script data-ad-client="ca-pub-3077285224019295" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>-->

  <link rel="stylesheet" media="all" href="https://cdn2.jianshu.io/assets/web-9af87d737cccdeba08d6.css" />
  
  <link rel="stylesheet" media="all" href="https://cdn2.jianshu.io/assets/web/pages/collections/show/entry-d39c06b5e570a1f17015.css" />

  <link href="https://cdn2.jianshu.io/assets/favicons/favicon-e743bfb1821442341c3ab15bdbe804f7ad97676bd07a770ccc9483473aa76f06.ico" rel="shortcut icon" type="image/x-icon">
      <link rel="apple-touch-icon-precomposed" href="https://cdn2.jianshu.io/assets/apple-touch-icons/57-a6f1f1ee62ace44f6dc2f6a08575abd3c3b163288881c78dd8d75247682a4b27.png" sizes="57x57" />
      <link rel="apple-touch-icon-precomposed" href="https://cdn2.jianshu.io/assets/apple-touch-icons/72-fb9834bcfce738fd7b9c5e31363e79443e09a81a8e931170b58bc815387c1562.png" sizes="72x72" />
      <link rel="apple-touch-icon-precomposed" href="https://cdn2.jianshu.io/assets/apple-touch-icons/76-49d88e539ff2489475d603994988d871219141ecaa0b1a7a9a1914f4fe3182d6.png" sizes="76x76" />
      <link rel="apple-touch-icon-precomposed" href="https://cdn2.jianshu.io/assets/apple-touch-icons/114-24252fe693524ed3a9d0905e49bff3cbd0228f25a320aa09053c2ebb4955de97.png" sizes="114x114" />
      <link rel="apple-touch-icon-precomposed" href="https://cdn2.jianshu.io/assets/apple-touch-icons/120-1bb7371f5e87f93ce780a5f1a05ff1b176828ee0d1d130e768575918a2e05834.png" sizes="120x120" />
      <link rel="apple-touch-icon-precomposed" href="https://cdn2.jianshu.io/assets/apple-touch-icons/152-bf209460fc1c17bfd3e2b84c8e758bc11ca3e570fd411c3bbd84149b97453b99.png" sizes="152x152" />

  <!-- Start of 访问统计 -->
    <script>
    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "//hm.baidu.com/hm.js?0c0e9d9b1e7d617b3e6842e85b9fb068";
      var s = document.getElementsByTagName("script")[0];
      s.parentNode.insertBefore(hm, s);
    })();
    (function () {
      var hm = document.createElement('script');
      hm.src = 'https://v1.cnzz.com/z_stat.php?id=1279807957&web_id=1279807957';
      var s = document.getElementsByTagName('script')[0];
      s.parentNode.insertBefore(hm, s);
    }());
  </script>

  <!-- End of 访问统计 -->
</head>

  <!-- 只给10%的用户添加代码 -->
  <!-- ###第四范式-智能推荐：代码直接复制 无需修改参数### -->
  <!-- ###功能：上报内容并反馈用户行为### -->
  <!--
  -->
  <body lang="zh-CN" class="reader-song-font">
    <!-- 全局顶部导航栏 -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="width-limit">
    <!-- 左上方 Logo -->
    <a class="logo" href="/"><img src="https://cdn2.jianshu.io/assets/web/nav-logo-4c7bbafe27adc892f3046e6978459bac.png" alt="Nav logo" /></a>

    <!-- 右上角 -->
      <!-- 未登录显示登录/注册/写文章 -->
      <a class="btn write-btn" target="_blank" href="/writer#/">
        <i class="iconfont ic-write"></i>写文章
</a>      <a class="btn sign-up" id="sign_up" href="/sign_up">注册</a>
      <a class="btn log-in" id="sign_in" href="/sign_in">登录</a>

    <!-- 如果用户登录，显示下拉菜单 -->

    <div id="view-mode-ctrl">
    </div>
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
      </div>
      <div class="collapse navbar-collapse" id="menu">
        <ul class="nav navbar-nav">
            <li class="tab ">
              <a href="/">
                <span class="menu-text">首页</span><i class="iconfont ic-navigation-discover menu-icon"></i>
</a>            </li>
            <li class="tab ">
              <a id="web-nav-app-download-btn" class="app-download-btn" href="/apps?utm_medium=desktop&amp;utm_source=navbar-apps"><span class="menu-text">下载App</span><i class="iconfont ic-navigation-download menu-icon"></i></a>
            </li>
            <li onclick="addPoint(event)" class="tab ">
              <a href="/techareas">
                <span class="menu-text">IT技术</span><i style="transform:scale(1.3)" class="iconfont ic-chengxuyuanzhuanqu menu-icon"></i>
</a>            </li>
          <li class="search">
            <form target="_blank" action="/search" accept-charset="UTF-8" method="get"><input name="utf8" type="hidden" value="&#x2713;" />
              <input type="text" name="q" id="q" value="" autocomplete="off" placeholder="搜索" class="search-input" />
              <a class="search-btn" href="javascript:void(null)"><i class="iconfont ic-search"></i></a>
</form>          </li>
        </ul>
          <div id="navbar-app-download"></div>
      </div>
    </div>
  </div>
</nav>
<script type="text/javascript">
function addPoint (e) {
  e.stopPropagation();
  JsSensor.trackEvent(SAEVENTS.PC_HEADER_TAB_CLICK,{tab:'程序员专区',place:'首页'});
}
</script>
    

<div class="container collection">
  <div class="row">
    <div class="col-xs-24 col-sm-16 main">
      <!-- 专题头部模块 -->
      <div class="main-top">
        <a class="avatar-collection" href="/c/bDHhpK">
          <img src="https://upload.jianshu.io/collections/images/47/%E9%A6%96%E9%A1%B5%E6%8A%95%E7%A8%BF.png?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240" alt="240" />
</a>        <div class="follow-button" props-data-following="false" props-data-collection-id="47"></div>
          <a class="btn btn-hollow" href="/sign_in?utm_medium=not-signed-in-contribute-button&amp;utm_source=desktop">投稿</a>

        <div class="title">
          <a class="name" href="/c/bDHhpK">首页投稿（暂停使用，暂停投稿）</a>
        </div>
        <div class="info">
          收录了250261篇文章 · 192458人关注
        </div>
      </div>
      <ul class="trigger-menu" data-pjax-container="#list-container"><li class="active"><a href="/c/bDHhpK?order_by=commented_at"><i class="iconfont ic-latestcomments"></i> 最新评论</a></li><li class=""><a href="/c/bDHhpK?order_by=added_at"><i class="iconfont ic-articles"></i> 最新收录</a></li><li class=""><a href="/c/bDHhpK?order_by=top"><i class="iconfont ic-hot"></i> 热门</a></li></ul>
      <div id="list-container">
        <!-- 文章列表模块 -->
<ul class="note-list" infinite-scroll-url="/c/bDHhpK?order_by=commented_at">
  
  

<li id="note-24229228" data-note-id="24229228" data-shock="0" class="">
  <div class="content">
    <a class="title" target="_blank" href="/p/0ec90b5b71a3">埋情葬爱（为了救弟弟，他倾家荡产人财两空，看不到任何希望）</a>
    <p class="abstract">
      这天法庭审理杀褚灵梦、裴飞龙一案，两名嫌疑人胡杰书、于剑飞轮流入庭陈述。胡杰书当庭翻供，不承认杀了人… 烟雨的辩护词:据胡杰书供述，他上夜班时，...
    </p>
    <div class="meta">
        <span class="jsd-meta">
          <i class="iconfont ic-paid1"></i> 9.1
        </span>
      <a class="nickname" target="_blank" href="/u/1d4f4b8b3d9f">马到成功程雨烟</a>
        <a target="_blank" href="/p/0ec90b5b71a3#comments">
          <i class="iconfont ic-list-comments"></i> 406
</a>      <span><i class="iconfont ic-list-like"></i> 125</span>
        <span><i class="iconfont ic-list-money"></i> 7</span>
    </div>
  </div>
</li>



  

<li id="note-24753245" data-note-id="24753245" data-shock="0" class="have-img">
    <a class="wrap-img" href="/p/fd87cb2f2a2b" target="_blank">
      <img data-echo="//upload-images.jianshu.io/upload_images/8785351-dbfdb651174c6816.png?imageMogr2/auto-orient/strip|imageView2/1/w/300/h/240" class="img-blur" src="//upload-images.jianshu.io/upload_images/8785351-dbfdb651174c6816.png?imageMogr2/auto-orient/strip|imageView2/1/w/150/h/120" alt="120" />
    </a>
  <div class="content">
    <a class="title" target="_blank" href="/p/fd87cb2f2a2b">埋情葬爱（一个唱红脸、一个唱白脸、凡事预留后手、用人得当，商战取胜之道）</a>
    <p class="abstract">
      烟雨发信息给剑仁:金银山说:&quot;一开始经理答应了大伙每个月多少工资，还说他们上晚班的中午没来的算旷工，旷工一天扣三天。后来换了(同公司)老板，经理...
    </p>
    <div class="meta">
        <span class="jsd-meta">
          <i class="iconfont ic-paid1"></i> 19.0
        </span>
      <a class="nickname" target="_blank" href="/u/1d4f4b8b3d9f">马到成功程雨烟</a>
        <a target="_blank" href="/p/fd87cb2f2a2b#comments">
          <i class="iconfont ic-list-comments"></i> 658
</a>      <span><i class="iconfont ic-list-like"></i> 160</span>
        <span><i class="iconfont ic-list-money"></i> 7</span>
    </div>
  </div>
</li>



    <div aria-label="3rd-ad">
    <script type="text/javascript" smua="d=p&amp;s=b&amp;u=u3179145&amp;w=625&amp;h=140" src="https://www.nkscdn.com/smu/o.js"></script>
    <script type="text/javascript">
     setTimeout(function(){
       if(window.JsSensor){
          JsSensor.trackEvent(SAEVENTS.PC_AD_SHOW, {
          page: '专题页',
          place: '信息流广告'+ 1,
          uid: 'u3179145'
        });
       }
     },1500)
    </script>
</div>
  

<li id="note-13804650" data-note-id="13804650" data-shock="0" class="">
  <div class="content">
    <a class="title" target="_blank" href="/p/18d691651ec9">【我的青春蜕变之旅】走在蜕变的路上</a>
    <p class="abstract">
      一颗天鹅蛋在鸭群中孵化长大，即使一直生活在鸭群中，它长大之后会是一只美丽的白天鹅，丑小鸭虽然一出生就受到同伴的冷落和欺负，让丑小鸭感到很自卑，但...
    </p>
    <div class="meta">
      <a class="nickname" target="_blank" href="/u/4dc9aa81354c">长翅膀的绵阳</a>
        <a target="_blank" href="/p/18d691651ec9#comments">
          <i class="iconfont ic-list-comments"></i> 5
</a>      <span><i class="iconfont ic-list-like"></i> 8</span>
    </div>
  </div>
</li>



  

<li id="note-14593031" data-note-id="14593031" data-shock="0" class="have-img">
    <a class="wrap-img" href="/p/89bd1bdc1148" target="_blank">
      <img data-echo="https://upload-images.jianshu.io/upload_images/4098035-26ef060e0c78edce.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/300/h/240" class="img-blur" src="https://upload-images.jianshu.io/upload_images/4098035-26ef060e0c78edce.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/150/h/120" alt="120" />
    </a>
  <div class="content">
    <a class="title" target="_blank" href="/p/89bd1bdc1148">春风十里不如你</a>
    <p class="abstract">
      你是铁人，我是春风，简友月未全满[https://www.jianshu.com/u/7091ebd18ca1]调侃：“春风十里柔情，铁人三生有...
    </p>
    <div class="meta">
        <span class="jsd-meta">
          <i class="iconfont ic-paid1"></i> 0.2
        </span>
      <a class="nickname" target="_blank" href="/u/9d17b455fc6d">一笑作春风</a>
        <a target="_blank" href="/p/89bd1bdc1148#comments">
          <i class="iconfont ic-list-comments"></i> 240
</a>      <span><i class="iconfont ic-list-like"></i> 124</span>
        <span><i class="iconfont ic-list-money"></i> 12</span>
    </div>
  </div>
</li>



  

<li id="note-1673306" data-note-id="1673306" data-shock="0" class="">
  <div class="content">
    <a class="title" target="_blank" href="/p/27de765cdb28">简友常见问题汇总</a>
    <p class="abstract">
      问：我在这里能干什么？ 答：打开简书APP就可以阅读简友们的文章了，可以给文章点赞、评论。遇到喜欢的作者你可以关注他以获得他的最新内容更新。如果...
    </p>
    <div class="meta">
        <span class="jsd-meta">
          <i class="iconfont ic-paid1"></i> 942.6
        </span>
      <a class="nickname" target="_blank" href="/u/y3Dbcz">简叔</a>
        <a target="_blank" href="/p/27de765cdb28#comments">
          <i class="iconfont ic-list-comments"></i> 15266
</a>      <span><i class="iconfont ic-list-like"></i> 36131</span>
        <span><i class="iconfont ic-list-money"></i> 223</span>
    </div>
  </div>
</li>



  

<li id="note-16720538" data-note-id="16720538" data-shock="0" class="have-img">
    <a class="wrap-img" href="/p/d94a72acd9ff" target="_blank">
      <img data-echo="//upload-images.jianshu.io/upload_images/4098035-8d0494a4be0c743d.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/300/h/240" class="img-blur" src="//upload-images.jianshu.io/upload_images/4098035-8d0494a4be0c743d.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/150/h/120" alt="120" />
    </a>
  <div class="content">
    <a class="title" target="_blank" href="/p/d94a72acd9ff">陶渊明：心为形役归去兮，桃花源里逍遥游</a>
    <p class="abstract">
      两千年前，陶渊明劈头一句喝问：田园将芜，胡不归？一下子让中国文人从狗零狗碎的官场抬起头来，遥望诗意的远方。从此，当我们在现世生活中被一地鸡毛的苟...
    </p>
    <div class="meta">
        <span class="jsd-meta">
          <i class="iconfont ic-paid1"></i> 3.2
        </span>
      <a class="nickname" target="_blank" href="/u/9d17b455fc6d">一笑作春风</a>
        <a target="_blank" href="/p/d94a72acd9ff#comments">
          <i class="iconfont ic-list-comments"></i> 162
</a>      <span><i class="iconfont ic-list-like"></i> 233</span>
        <span><i class="iconfont ic-list-money"></i> 4</span>
    </div>
  </div>
</li>



  

<li id="note-16035764" data-note-id="16035764" data-shock="0" class="have-img">
    <a class="wrap-img" href="/p/9b7edba6a094" target="_blank">
      <img data-echo="https://upload-images.jianshu.io/upload_images/4098035-c086745a3e4a9f07.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/300/h/240" class="img-blur" src="https://upload-images.jianshu.io/upload_images/4098035-c086745a3e4a9f07.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/150/h/120" alt="120" />
    </a>
  <div class="content">
    <a class="title" target="_blank" href="/p/9b7edba6a094">秦可卿：情天情海幻情深，一梦春尽落香尘</a>
    <p class="abstract">
      你来自幽深的天空，还是地狱？美啊！这又何妨？只要你的眼、你的笑、你的双足打开我爱而不识的无限之门！            ——《恶之花》 重重帘...
    </p>
    <div class="meta">
        <span class="jsd-meta">
          <i class="iconfont ic-paid1"></i> 0.5
        </span>
      <a class="nickname" target="_blank" href="/u/9d17b455fc6d">一笑作春风</a>
        <a target="_blank" href="/p/9b7edba6a094#comments">
          <i class="iconfont ic-list-comments"></i> 100
</a>      <span><i class="iconfont ic-list-like"></i> 166</span>
        <span><i class="iconfont ic-list-money"></i> 2</span>
    </div>
  </div>
</li>



    <div aria-label="3rd-ad">
    <script type="text/javascript" smua="d=p&amp;s=b&amp;u=u3179145&amp;w=625&amp;h=140" src="https://www.nkscdn.com/smu/o.js"></script>
    <script type="text/javascript">
     setTimeout(function(){
       if(window.JsSensor){
          JsSensor.trackEvent(SAEVENTS.PC_AD_SHOW, {
          page: '专题页',
          place: '信息流广告'+ 2,
          uid: 'u3179145'
        });
       }
     },1500)
    </script>
</div>
  

<li id="note-15772687" data-note-id="15772687" data-shock="0" class="">
  <div class="content">
    <a class="title" target="_blank" href="/p/4f3d1c19a6a0">黛玉来了</a>
    <p class="abstract">
      ＂且说黛玉自那日弃舟登岸时＂ 只一句，平平叙述，在我读之却犹如七彩礼花炸开。黛玉来了，大幕自此拉开，红楼之中的那人、那景，在寂寂空转经年之后，忽...
    </p>
    <div class="meta">
        <span class="jsd-meta">
          <i class="iconfont ic-paid1"></i> 9.8
        </span>
      <a class="nickname" target="_blank" href="/u/9292f1dcc44c">一棵开满鲜花的树</a>
        <a target="_blank" href="/p/4f3d1c19a6a0#comments">
          <i class="iconfont ic-list-comments"></i> 91
</a>      <span><i class="iconfont ic-list-like"></i> 58</span>
    </div>
  </div>
</li>



  

<li id="note-17609294" data-note-id="17609294" data-shock="0" class="have-img">
    <a class="wrap-img" href="/p/49043d8fb838" target="_blank">
      <img data-echo="https://upload-images.jianshu.io/upload_images/5796592-d8976757e785bb70.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/300/h/240" class="img-blur" src="https://upload-images.jianshu.io/upload_images/5796592-d8976757e785bb70.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/150/h/120" alt="120" />
    </a>
  <div class="content">
    <a class="title" target="_blank" href="/p/49043d8fb838">不夜谈之皇极星（03）苏十三</a>
    <p class="abstract">
      前情回顾：天诛令[https://www.jianshu.com/p/da68825741ff] 第三幕：苏十三 刘武觉得自己今天真是撞大运了。...
    </p>
    <div class="meta">
        <span class="jsd-meta">
          <i class="iconfont ic-paid1"></i> 0.9
        </span>
        <span class="paid-meta">
          <i class="iconfont ic-paid"></i>
          付费
        </span>
      <a class="nickname" target="_blank" href="/u/86b81ed8e35c">澜夜师兄</a>
        <a target="_blank" href="/p/49043d8fb838#comments">
          <i class="iconfont ic-list-comments"></i> 1
</a>      <span><i class="iconfont ic-list-like"></i> 13</span>
    </div>
  </div>
</li>



  

<li id="note-25245162" data-note-id="25245162" data-shock="0" class="have-img">
    <a class="wrap-img" href="/p/693072c5d92e" target="_blank">
      <img data-echo="//upload-images.jianshu.io/upload_images/7705786-6b9f43dc721084c3.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/300/h/240" class="img-blur" src="//upload-images.jianshu.io/upload_images/7705786-6b9f43dc721084c3.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/150/h/120" alt="120" />
    </a>
  <div class="content">
    <a class="title" target="_blank" href="/p/693072c5d92e">如何假装自己读懂了《时间简史》</a>
    <p class="abstract">
      什么！霍金他老人家都仙逝了，你还没看懂《时间简史》？作为一名当代精英，这实在是太丢人了，严重拖了人类进步的后腿！根据“死后地位自动升一级”公理，...
    </p>
    <div class="meta">
        <span class="jsd-meta">
          <i class="iconfont ic-paid1"></i> 95.1
        </span>
      <a class="nickname" target="_blank" href="/u/85e87737a013">北落西门</a>
        <a target="_blank" href="/p/693072c5d92e#comments">
          <i class="iconfont ic-list-comments"></i> 449
</a>      <span><i class="iconfont ic-list-like"></i> 2308</span>
        <span><i class="iconfont ic-list-money"></i> 7</span>
    </div>
  </div>
</li>




</ul>

      </div>
    </div>
    <div class="col-xs-24 col-sm-7 col-sm-offset-1 aside">
      <div data-vcomp="third-party-ad" props-data-smua="u2823532" props-data-page="专题页" props-data-place="侧边栏上方广告" props-data-script-url="https://www.nkscdn.com/smu/o.js" props-data-w="250" props-data-h="250" ></div>
        <p class="title">专题公告</p>
        <div class="description js-description">
          <p>原首页投稿专题</p>

<p>现暂停使用。</p>

<p>具体请查看：简书新版发现页文章推荐系统上线公告 <a href="https://www.jianshu.com/p/6c47b3244644">https://www.jianshu.com/p/6c47b3244644</a></p>
          
        </div>
      <div class="share">
        <span>分享到</span>
        <a class="option" href="javascript:void((function(s,d,e,r,l,p,t,z,c){var%20f=&#39;http://v.t.sina.com.cn/share/share.php?appkey=1881139527&#39;,u=z||d.location,p=[&#39;&amp;url=&#39;,e(u),&#39;&amp;title=&#39;,e(t||d.title),&#39;&amp;source=&#39;,e(r),&#39;&amp;sourceUrl=&#39;,e(l),&#39;&amp;content=&#39;,c||&#39;gb2312&#39;,&#39;&amp;pic=&#39;,e(p||&#39;&#39;)].join(&#39;&#39;);function%20a(){if(!window.open([f,p].join(&#39;&#39;),&#39;mb&#39;,[&#39;toolbar=0,status=0,resizable=1,width=440,height=430,left=&#39;,(s.width-440)/2,&#39;,top=&#39;,(s.height-430)/2].join(&#39;&#39;)))u.href=[f,p].join(&#39;&#39;);};if(/Firefox/.test(navigator.userAgent))setTimeout(a,0);else%20a();})(screen,document,encodeURIComponent,&#39;&#39;,&#39;&#39;,&#39;https://upload.jianshu.io/collections/images/47/%E9%A6%96%E9%A1%B5%E6%8A%95%E7%A8%BF.png&#39;, &#39;推荐专题《首页投稿（暂停使用，暂停投稿）》（ 分享自 @简书 ）&#39;,&#39;https://www.jianshu.com/c/bDHhpK?utm_campaign=maleskine&amp;utm_content=collection&amp;utm_medium=reader_share&amp;utm_source=weibo&#39;,&#39;页面编码gb2312|utf-8默认gb2312&#39;));"><i class="iconfont ic-share-weibo"></i></a>
        <a class="option" data-action="weixin-share"><i class="iconfont ic-share-wechat"></i></a>
        <a class="option" tabindex="0" data-toggle="popover" data-placement="bottom" data-html="true" data-trigger="focus" href="javascript:void(0);" data-content='
          <ul class="share-list">
            <li><a href="javascript:void(function(){var d=document,e=encodeURIComponent,r=&#39;http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=&#39;+e(&#39;https://www.jianshu.com/c/bDHhpK?utm_campaign=maleskine&amp;utm_content=collection&amp;utm_medium=reader_share&amp;utm_source=qzone&#39;)+&#39;&amp;title=&#39;+e(&#39;推荐专题《首页投稿（暂停使用，暂停投稿）》&#39;),x=function(){if(!window.open(r,&#39;qzone&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=600,height=600&#39;))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();"><i class="social-icon-sprite social-icon-zone"></i><span>分享到QQ空间</span></a></li>
            <li><a href="javascript:void(function(){var d=document,e=encodeURIComponent,r=&#39;https://twitter.com/share?url=&#39;+e(&#39;https://www.jianshu.com/c/bDHhpK?utm_campaign=maleskine&amp;utm_content=collection&amp;utm_medium=reader_share&amp;utm_source=twitter&#39;)+&#39;&amp;text=&#39;+e(&#39;推荐专题《首页投稿（暂停使用，暂停投稿）》（ 分享自 @jianshucom ）&#39;)+&#39;&amp;related=&#39;+e(&#39;jianshucom&#39;),x=function(){if(!window.open(r,&#39;twitter&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=600,height=600&#39;))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();"><i class="social-icon-sprite social-icon-twitter"></i><span>分享到Twitter</span></a></li>
            <li><a href="javascript:void(function(){var d=document,e=encodeURIComponent,r=&#39;https://www.facebook.com/dialog/share?app_id=483126645039390&amp;display=popup&amp;href=https://www.jianshu.com/c/bDHhpK?utm_campaign=maleskine&amp;utm_content=collection&amp;utm_medium=reader_share&amp;utm_source=facebook&#39;,x=function(){if(!window.open(r,&#39;facebook&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330&#39;))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();"><i class="social-icon-sprite social-icon-facebook"></i><span>分享到Facebook</span></a></li>
            <li><a href="javascript:void(function(){var d=document,e=encodeURIComponent,r=&#39;https://plus.google.com/share?url=&#39;+e(&#39;https://www.jianshu.com/c/bDHhpK?utm_campaign=maleskine&amp;utm_content=collection&amp;utm_medium=reader_share&amp;utm_source=google_plus&#39;),x=function(){if(!window.open(r,&#39;google_plus&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330&#39;))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();"><i class="social-icon-sprite social-icon-google"></i><span>分享到Google+</span></a></li>
            <li><a href="javascript:void(function(){var d=document,e=encodeURIComponent,s1=window.getSelection,s2=d.getSelection,s3=d.selection,s=s1?s1():s2?s2():s3?s3.createRange().text:&#39;&#39;,r=&#39;http://www.douban.com/recommend/?url=&#39;+e(&#39;https://www.jianshu.com/c/bDHhpK?utm_campaign=maleskine&amp;utm_content=collection&amp;utm_medium=reader_share&amp;utm_source=douban&#39;)+&#39;&amp;title=&#39;+e(&#39;首页投稿（暂停使用，暂停投稿）&#39;)+&#39;&amp;sel=&#39;+e(s)+&#39;&amp;v=1&#39;,x=function(){if(!window.open(r,&#39;douban&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330&#39;))location.href=r+&#39;&amp;r=1&#39;};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})()"><i class="social-icon-sprite social-icon-douban"></i><span>分享到豆瓣</span></a></li>
          </ul>
        '><i class="iconfont ic-share-more"></i></a>
      </div>
      <div class="side-list"></div>
      <div data-vcomp="third-party-ad" props-data-smua="u2823532" props-data-page="专题页"  props-data-place="侧边栏下方广告" props-data-script-url="https://www.nkscdn.com/smu/o.js" props-data-w="250" props-data-h="250" ></div>
    </div>
  </div>
</div>
<div data-vcomp="side-tool"></div>

<script type="application/json" data-name="collection">
  {"id":47,"slug":"bDHhpK","owner":{"id":259},"subscribers_count":192458}
</script>

<script type='application/json' data-name='uuid'>
  {"uuid":"3961da9a-d9c0-495b-8132-3ed28048a011"}
</script>

    <script type="application/json" data-name="page-data">{"user_signed_in":false,"locale":"zh-CN","os":"mac","read_mode":null,"read_font":null}</script>
    
    <script src="https://cdn2.jianshu.io/assets/babel-polyfill-82fc29a99e639a538b4a.js" crossorigin="anonymous"></script>
    <script src="https://cdn2.jianshu.io/assets/web-base-17e9d1a4bd6306e531f0.js" crossorigin="anonymous"></script>
<script src="https://cdn2.jianshu.io/assets/web-c1183e2437db016a37c9.js" crossorigin="anonymous"></script>
    
    <script src="https://cdn2.jianshu.io/assets/web/pages/collections/show/entry-cd317e7a69a44e6f9115.js" crossorigin="anonymous"></script>
    
  </body>
</html>

"""

comment_num = re.findall('<i.*?ic-list-comments">.*?</i>(.*?)</a>', str, re.S)
pass
