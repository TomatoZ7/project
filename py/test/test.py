# -*- coding:utf-8 -*-

import re
import os
from lxml import etree

str = """
<!DOCTYPE html>
<html lang="zh-CN" class="ua-mac ua-webkit">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="renderer" content="webkit">
    <meta name="referrer" content="always">
    <meta name="google-site-verification" content="ok0wCgT20tBBgo9_zat2iAcimtN4Ftf5ccsh092Xeyw" />
    <title>
    We Sing. We Dance. We Steal Things. (豆瓣)
</title>
    
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="Sun, 6 Mar 2005 01:00:00 GMT">
    
    <meta http-equiv="mobile-agent" content="format=html5; url=https://m.douban.com/music/subject/2995812">
    
    
    <meta property="og:title" content="We Sing. We Dance. We Steal Things." />
    <meta property="og:description" content="沉淀一年，回归简单生活，用全新能量在第三张原创专辑当中活出自我l 部落格女孩Colbie Caillat、心灵投手James Morrison诚意跨刀献声！出生自维吉尼亚的一个朴实小镇的Jason M..." />
    <meta property="og:site_name" content="豆瓣" />
    <meta property="og:url" content="https://music.douban.com/subject/2995812/" />
    <meta property="og:image" content="https://img2.doubanio.com/view/subject/m/public/s2967252.jpg" />
    <meta property="og:type" content="music.album" />
        <meta property="music:musician" content="Jason Mraz" />
    


    <script >var _head_start = new Date();</script>
    <script src="https://img3.doubanio.com/f/music/b66ed708717bf0b4a005a4d0113af8843ef3b8ff/js/music/lib/jquery-1.11.0.min.js"></script>
    <script src="https://img3.doubanio.com/f/music/dcd7ea79bfc24a0b5d9a280a8ca59acceddd56be/js/music/lib/jquery-migrate-1.2.1.js"></script>
    <script src="https://img3.doubanio.com/f/shire/22ee83f45f94c7a90e73e0ee4acd18f902a6991f/js/douban.js"></script>
    <script src="https://img3.doubanio.com/f/shire/2c0c1c6b83f9a457b0f38c38a32fc43a42ec9bad/js/do.js" data-cfg-autoload="false"></script>
    <link href="https://img3.doubanio.com/f/shire/2feae483592bf2d2bd17a378097d4246ef1ebeaa/css/douban.css" rel="stylesheet" type="text/css">
    <link href="https://img3.doubanio.com/f/music/ea0c776c52fba60e24e92ea802336c1fe9697ff4/css/music/init.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
    
        a:link { color: #259; }
        a:visited { color: #769; }
        a:hover { color: #fff; }
        a:active { color: #fff; }
        
    </style>
    
    <script src="https://img3.doubanio.com/f/shire/2c0c1c6b83f9a457b0f38c38a32fc43a42ec9bad/js/do.js" data-cfg-corelib="false"></script>
    <script type="text/javascript">
        Do.add('dialog-css', {
            path: 'https://img3.doubanio.com/f/shire/8377b9498330a2e6f056d863987cc7a37eb4d486/css/ui/dialog.css',
            type: 'css'
        })
        Do.add('dialog', {
            path: 'https://img3.doubanio.com/f/shire/bc881a837a728ab82aa01d653b1c180190bb5a5d/js/ui/dialog.js',
            type: 'js',
            requires: ['dialog-css']
        })
    </script>
    
  <script type='text/javascript'>
  var _vwo_code = (function() {
    var account_id = 249272,
      settings_tolerance = 0,
      library_tolerance = 2500,
      use_existing_jquery = false,
      // DO NOT EDIT BELOW THIS LINE
      f=false,d=document;return{use_existing_jquery:function(){return use_existing_jquery;},library_tolerance:function(){return library_tolerance;},finish:function(){if(!f){f=true;var a=d.getElementById('_vis_opt_path_hides');if(a)a.parentNode.removeChild(a);}},finished:function(){return f;},load:function(a){var b=d.createElement('script');b.src=a;b.type='text/javascript';b.innerText;b.onerror=function(){_vwo_code.finish();};d.getElementsByTagName('head')[0].appendChild(b);},init:function(){settings_timer=setTimeout('_vwo_code.finish()',settings_tolerance);var a=d.createElement('style'),b='body{opacity:0 !important;filter:alpha(opacity=0) !important;background:none !important;}',h=d.getElementsByTagName('head')[0];a.setAttribute('id','_vis_opt_path_hides');a.setAttribute('type','text/css');if(a.styleSheet)a.styleSheet.cssText=b;else a.appendChild(d.createTextNode(b));h.appendChild(a);this.load('//dev.visualwebsiteoptimizer.com/j.php?a='+account_id+'&u='+encodeURIComponent(d.URL)+'&r='+Math.random());return settings_timer;}};}());

  +function () {
    var bindEvent = function (el, type, handler) {
        var $ = window.jQuery || window.Zepto || window.$
       if ($ && $.fn && $.fn.on) {
           $(el).on(type, handler)
       } else if($ && $.fn && $.fn.bind) {
           $(el).bind(type, handler)
       } else if (el.addEventListener){
         el.addEventListener(type, handler, false);
       } else if (el.attachEvent){
         el.attachEvent("on" + type, handler);
       } else {
         el["on" + type] = handler;
       }
     }

    var _origin_load = _vwo_code.load
    _vwo_code.load = function () {
      var args = [].slice.call(arguments)
      bindEvent(window, 'load', function () {
        _origin_load.apply(_vwo_code, args)
      })
    }
  }()

  _vwo_settings_timer = _vwo_code.init();
  </script>

    

    <link rel="stylesheet" href="https://img3.doubanio.com/misc/mixed_static/2ba0a1b17d66c650.css">
    <script></script>

    <link rel="shortcut icon" href="https://img3.doubanio.com/favicon.ico" type="image/x-icon">
</head>

<body>
  
    <script type="text/javascript">var _body_start = new Date();</script>
    
   



    <link href="//img3.doubanio.com/dae/accounts/resources/d3e2921/shire/bundle.css" rel="stylesheet" type="text/css">



<div id="db-global-nav" class="global-nav">
  <div class="bd">
    
<div class="top-nav-info">
  <ul>
    <li>
    <a id="top-nav-doumail-link" href="https://www.douban.com/doumail/">豆邮</a>
    </li>
    <li class="nav-user-account">
      <a target="_blank" href="https://accounts.douban.com/passport/setting/" class="bn-more">
        <span>豆友197956574的帐号</span><span class="arrow"></span>
      </a>
      <div class="more-items">
        <table cellpadding="0" cellspacing="0">
          <tbody>
            <tr>
              <td>
                <a href="https://www.douban.com/mine/">个人主页</a>
              </td>
            </tr>
            <tr>
              <td>
                <a target="_blank" href="https://www.douban.com/mine/orders/">我的订单</a>
              </td>
            </tr>
            <tr>
              <td>
                <a target="_blank" href="https://www.douban.com/mine/wallet/">我的钱包</a>
              </td>
            </tr>
            <tr>
              <td>
                <a target="_blank" href="https://accounts.douban.com/passport/setting/">帐号管理</a>
              </td>
            </tr>
            <tr>
              <td>
                <a href="https://www.douban.com/accounts/logout?source=music&ck=2tyY">退出</a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </li>
  </ul>
</div>

  <div class="top-nav-reminder">
    <a href="https://www.douban.com/notification/" class="lnk-remind">提醒</a>
    <div id="top-nav-notimenu" class="more-items">
      <div class="bd">
        <p>加载中...</p>
      </div>
    </div>
  </div>

    <div class="top-nav-doubanapp">
  <a href="https://www.douban.com/doubanapp/app?channel=top-nav" class="lnk-doubanapp">下载豆瓣客户端</a>
  <div id="doubanapp-tip">
    <a href="https://www.douban.com/doubanapp/app?channel=qipao" class="tip-link">豆瓣 <span class="version">6.0</span> 全新发布</a>
    <a href="javascript: void 0;" class="tip-close">×</a>
  </div>
  <div id="top-nav-appintro" class="more-items">
    <p class="appintro-title">豆瓣</p>
    <p class="qrcode">扫码直接下载</p>
    <div class="download">
      <a href="https://www.douban.com/doubanapp/redirect?channel=top-nav&direct_dl=1&download=iOS">iPhone</a>
      <span>·</span>
      <a href="https://www.douban.com/doubanapp/redirect?channel=top-nav&direct_dl=1&download=Android" class="download-android">Android</a>
    </div>
  </div>
</div>

    


<div class="global-nav-items">
  <ul>
    <li class="">
      <a href="https://www.douban.com" target="_blank" data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-main&quot;,&quot;uid&quot;:&quot;197956574&quot;}">豆瓣</a>
    </li>
    <li class="">
      <a href="https://book.douban.com" target="_blank" data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-book&quot;,&quot;uid&quot;:&quot;197956574&quot;}">读书</a>
    </li>
    <li class="">
      <a href="https://movie.douban.com" target="_blank" data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-movie&quot;,&quot;uid&quot;:&quot;197956574&quot;}">电影</a>
    </li>
    <li class="on">
      <a href="https://music.douban.com"  data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-music&quot;,&quot;uid&quot;:&quot;197956574&quot;}">音乐</a>
    </li>
    <li class="">
      <a href="https://www.douban.com/location" target="_blank" data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-location&quot;,&quot;uid&quot;:&quot;197956574&quot;}">同城</a>
    </li>
    <li class="">
      <a href="https://www.douban.com/group" target="_blank" data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-group&quot;,&quot;uid&quot;:&quot;197956574&quot;}">小组</a>
    </li>
    <li class="">
      <a href="https://read.douban.com&#47;?dcs=top-nav&amp;dcm=douban" target="_blank" data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-read&quot;,&quot;uid&quot;:&quot;197956574&quot;}">阅读</a>
    </li>
    <li class="">
      <a href="https://douban.fm&#47;?from_=shire_top_nav" target="_blank" data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-fm&quot;,&quot;uid&quot;:&quot;197956574&quot;}">FM</a>
    </li>
    <li class="">
      <a href="https://time.douban.com&#47;?dt_time_source=douban-web_top_nav" target="_blank" data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-time&quot;,&quot;uid&quot;:&quot;197956574&quot;}">时间</a>
    </li>
    <li class="">
      <a href="https://market.douban.com&#47;?utm_campaign=douban_top_nav&amp;utm_source=douban&amp;utm_medium=pc_web" target="_blank" data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-market&quot;,&quot;uid&quot;:&quot;197956574&quot;}">豆品</a>
    </li>
  </ul>
</div>

  </div>
</div>
<script>
  ;window._GLOBAL_NAV = {
    USER_ID: "197956574",
    UPLOAD_AUTH_TOKEN: "197956574:da9e01adb70019628f51296b80c325ff4e2a9a73",
    SSE_TOKEN: "8527f3d10fea750ddb0cda52a6d330d974450a54",
    SSE_TIMESTAMP: "1639360630",
    DOUBAN_URL: "https://www.douban.com",
    N_NEW_NOTIS: 0,
    N_NEW_DOUMAIL: 0
  };
</script>



    <script src="//img3.doubanio.com/dae/accounts/resources/d3e2921/shire/bundle.js" defer="defer"></script>




      



    <link href="//img3.doubanio.com/dae/accounts/resources/d3e2921/music/bundle.css" rel="stylesheet" type="text/css">




<div id="db-nav-music" class="nav">
  <div class="nav-wrap">
  <div class="nav-primary">
    <div class="nav-logo">
      <a href="https:&#47;&#47;music.douban.com">豆瓣音乐</a>
    </div>
    <div class="nav-search">
      <form action="https:&#47;&#47;search.douban.com&#47;music/subject_search" method="get">
        <fieldset>
          <legend>搜索：</legend>
          <label for="inp-query">
          </label>
          <div class="inp"><input id="inp-query" name="search_text" size="22" maxlength="60" placeholder="唱片名、表演者、条码、ISRC" value=""></div>
          <div class="inp-btn"><input type="submit" value="搜索"></div>
          <input type="hidden" name="cat" value="1003" />
        </fieldset>
      </form>
    </div>
  </div>
  </div>
  <div class="nav-secondary">
    

<div class="nav-items">
  <ul>
    <li    ><a href="https://music.douban.com/mine"
     >我听</a>
    </li>
    <li    ><a href="https://music.douban.com/artists/"
     >音乐人</a>
    </li>
    <li    ><a href="https://music.douban.com/topics/"
     >专题</a>
    </li>
    <li    ><a href="https://music.douban.com/chart"
     >排行榜</a>
    </li>
    <li    ><a href="https://music.douban.com/tag/"
     >分类浏览</a>
    </li>
    <li    ><a href="https://music.douban.com/review/latest/"
     >乐评</a>
    </li>
    <li    ><a href="https://douban.fm/?from_=music_nav"
     >豆瓣FM</a>
    </li>
    <li    ><a href="https://douban.fm/explore/songlists/"
     >歌单</a>
    </li>
    <li    ><a href="https://music.douban.com/annual/2020?source=navigation"
            target="_blank"
     >2020年度榜单</a>
    </li>
  </ul>
</div>

    <a href="https://music.douban.com/annual/2020?source=music_navigation" class="musicannual"></a>
  </div>
</div>

<script id="suggResult" type="text/x-jquery-tmpl">
  <li data-link="{{= url}}">
            <a href="{{= url}}" onclick="moreurl(this, {from:'music_search_sugg', query:'{{= keyword }}', subject_id:'{{= id}}', i: '{{= index}}', type: '{{= type}}'})">
            <img src="{{= pic}}" width="40" />
            <div>
                <em>{{= title}}</em>
                {{if type == "m"}}
                    <span>(艺术家)</span>
                {{else type == "a"}}
                    <span>(音乐人)</span>
                {{else type == "d"}}
                    <span>(DJ)</span>
                {{else type == "l"}}
                    <span>(厂牌)</span>
                {{/if}}
                {{if other_title}}
                    <span>其他名称：{{= other_title}}</span>
                {{/if}}
                {{if performer}}
                    <p>表演者：{{= performer}}</p>
                {{/if}}
                {{if cn_name}}
                    <p>{{= cn_name}}</p>
                {{/if}}
                {{if en_name}}
                    <p>{{= en_name}}</p>
                {{/if}}
            </div>
        </a>
        </li>
  </script>




    <script src="//img3.doubanio.com/dae/accounts/resources/d3e2921/music/bundle.js" defer="defer"></script>





    
    <div id="wrapper">
        

        <h1>
            <span>We Sing. We Dance. We Steal Things.</span>
            <div class="clear"></div>
        </h1>
        
<div id="content">
    
    <div class="grid-16-8 clearfix">
        
        
        <div class="article">
               

    

    <div class="indent">
        <div class="subjectwrap clearfix">
            


<div class="subject clearfix">
    <div id="mainpic">
        <span class="ckd-collect">
            <a class="nbg" href="https://img2.doubanio.com/view/subject/m/public/s2967252.jpg"
            title="点击看大图">
                <img src="https://img2.doubanio.com/view/subject/m/public/s2967252.jpg"
                    alt="We Sing. We Dance. We Steal Things." rel="v:photo"/>
            </a>
        </span>
        <br/>

                    <p class="gact"><a href="https://music.douban.com/subject/2995812/edit">更新描述或封面</a></p>
            

<div class="infobox" style="">
    <div class="bd">
        <div class="start_radio">
                <a target="_fm" href="https://douban.fm/?cid=22009&amp;from_=music_subject">
                <img height="14" src="https://img3.doubanio.com/f/music/2306dcd67c23f9b28b6657dadef088a7e9ab1357/pics/music/subject/start-fm-logo.png" alt="FM">
                听相似歌曲
            </a>
        </div>
    </div>
</div>



    </div>

    <div id="info" class="ckd-collect">
        

                
                    <span>
                        <span class="pl">
                            表演者:
                                    
                                    <a href="/search?q=Jason+Mraz&amp;sid=2995812">Jason Mraz</a>
                        </span>
                    </span>
                    
                    <br/>
                
                    
    
    <span class="pl">流派:</span>&nbsp;民谣
    <br />

                
                    
    
    <span class="pl">专辑类型:</span>&nbsp;Import
    <br />

                
                    
    
    <span class="pl">介质:</span>&nbsp;Audio CD
    <br />

                
                    
    
    <span class="pl">发行时间:</span>&nbsp;2008-05-13
    <br />

                
                    
    
    <span class="pl">出版者:</span>&nbsp;Atlantic/WEA
    <br />

                
                    
    
    <span class="pl">唱片数:</span>&nbsp;1
    <br />

                
                        
    
    <span class="pl">条形码:</span>&nbsp;0075678994753
    <br />

                
                    
    
    <span class="pl">ISRC(中国):</span>&nbsp;CNE040444800
    <br />


            
            <span class="pl">其他版本:</span>&nbsp;
            <a href="https://music.douban.com/subject/3271818/">We Sing, We Dance, We Steal Things. Limited Edition CD/DVD Set</a>
            （<a href="/albums/126233">全部</a>）
            <br>
    </div>
</div>



                

    
    <div id="interest_sectl">
        <div class="rating_wrap clearbox" rel="v:rating">
            <div class="rating_logo">豆瓣评分</div>
            <div class="rating_self clearfix" typeof="v:Rating">
                <strong class="ll rating_num" property="v:average">9.1</strong>
                <span property="v:best" content="10.0"></span>
                <div class="rating_right ">
                    <div class="ll bigstar45"></div>
                    <div class="rating_sum">
                            <a href="comments" class="rating_people"><span property="v:votes">114825</span>人评价</a>
                    </div>
                </div>
            </div>

                
                    
                    
    <span class="stars5 starstop" title="力荐">
        5星
    </span>

                    
    <div class="power" style="width:64px"></div>

                    <span class="rating_per">62.0%</span>
                    <br>
                    
                    
    <span class="stars4 starstop" title="推荐">
        4星
    </span>

                    
    <div class="power" style="width:33px"></div>

                    <span class="rating_per">32.0%</span>
                    <br>
                    
                    
    <span class="stars3 starstop" title="还行">
        3星
    </span>

                    
    <div class="power" style="width:5px"></div>

                    <span class="rating_per">5.6%</span>
                    <br>
                    
                    
    <span class="stars2 starstop" title="较差">
        2星
    </span>

                    
    <div class="power" style="width:0px"></div>

                    <span class="rating_per">0.2%</span>
                    <br>
                    
                    
    <span class="stars1 starstop" title="很差">
        1星
    </span>

                    
    <div class="power" style="width:0px"></div>

                    <span class="rating_per">0.1%</span>
                    <br>
        </div>
            
    </div>





        </div>

            



<div id="interest_sect_level" class="clearfix">
    
        <a href="https://music.douban.com/subject/2995812/?interest=wish&amp;ck=2tyY"
           rel="nofollow" class="collect_btn colbutt ll"
           name="pbtn-2995812-wish">
            <span>想听</span>
        </a>
        <a href="https://music.douban.com/subject/2995812/?interest=do&amp;ck=2tyY"
           rel="nofollow" class="collect_btn colbutt ll"
           name="pbtn-2995812-do">
            <span>在听</span>
        </a>
        <a href="https://music.douban.com/subject/2995812/?interest=collect&amp;ck=2tyY"
           rel="nofollow" class="collect_btn colbutt ll"
           name="pbtn-2995812-collect">
            <span>听过</span>
        </a>

        <div class="ll j a_stars">
            
    
    评价:
    <span id="rating">
        <span id="stars" data-solid="https://img3.doubanio.com/f/shire/5a2327c04c0c231bced131ddf3f4467eb80c1c86/pics/rating_icons/star_onmouseover.png" data-hollow="https://img3.doubanio.com/f/shire/2520c01967207a1735171056ec588c8c1257e5f8/pics/rating_icons/star_hollow_hover.png" data-solid-2x="https://img3.doubanio.com/f/shire/7258904022439076d57303c3b06ad195bf1dc41a/pics/rating_icons/star_onmouseover@2x.png" data-hollow-2x="https://img3.doubanio.com/f/shire/95cc2fa733221bb8edd28ad56a7145a5ad33383e/pics/rating_icons/star_hollow_hover@2x.png">
                    <a href="javascript:;" class="j a_collect_btn" name="pbtn-2995812-collect-1">

            <img src="https://img3.doubanio.com/f/shire/2520c01967207a1735171056ec588c8c1257e5f8/pics/rating_icons/star_hollow_hover.png" id="star1" width="16" height="16" /></a>                    <a href="javascript:;" class="j a_collect_btn" name="pbtn-2995812-collect-2">

            <img src="https://img3.doubanio.com/f/shire/2520c01967207a1735171056ec588c8c1257e5f8/pics/rating_icons/star_hollow_hover.png" id="star2" width="16" height="16" /></a>                    <a href="javascript:;" class="j a_collect_btn" name="pbtn-2995812-collect-3">

            <img src="https://img3.doubanio.com/f/shire/2520c01967207a1735171056ec588c8c1257e5f8/pics/rating_icons/star_hollow_hover.png" id="star3" width="16" height="16" /></a>                    <a href="javascript:;" class="j a_collect_btn" name="pbtn-2995812-collect-4">

            <img src="https://img3.doubanio.com/f/shire/2520c01967207a1735171056ec588c8c1257e5f8/pics/rating_icons/star_hollow_hover.png" id="star4" width="16" height="16" /></a>                    <a href="javascript:;" class="j a_collect_btn" name="pbtn-2995812-collect-5">

            <img src="https://img3.doubanio.com/f/shire/2520c01967207a1735171056ec588c8c1257e5f8/pics/rating_icons/star_hollow_hover.png" id="star5" width="16" height="16" /></a>        </span>
        <span id="rateword" class="pl"></span>
        <input id="n_rating" type="hidden" value="" />
    </span>

        </div>




<style type="text/css">
    a.colbutt { color: #000000; }
</style>
</div>





        



<div class="gtleft">
    <ul class="ul_subject_menu bicelink color_gray pt6 clearfix">
            <li>
                    <img src="https://img3.doubanio.com/f/shire/cc03d0fcf32b7ce3af7b160a0b85e5e66b47cc42/pics/short-comment.gif" />&nbsp;
                    <a href="javascript:;" class="collect_btn" name="pbtn-2995812-collect" rel="nofollow">写短评</a>
            </li>
            <li>
                    <img src="https://img3.doubanio.com/f/shire/5bbf02b7b5ec12b23e214a580b6f9e481108488c/pics/add-review.gif" />&nbsp;
                    <a class="" href="https://music.douban.com/subject/2995812/new_review" rel="nofollow">写乐评</a>
            </li>
            <li>
                    
                    


    <div class="doulist-add-btn">
  

  

  
  <a href="javascript:void(0)"
     data-id="2995812"
     data-cate="1003"
     data-canview="True"
     data-url="https://music.douban.com/subject/2995812/"
     data-catename="唱片"
     data-link="https://www.douban.com/people/197956574/doulists/all?add=2995812&amp;cat=1003"
     data-title="We Sing. We Dance. We Steal Things."
     data-picture="https://img2.doubanio.com/view/subject/m/public/s2967252.jpg"
     class="lnk-doulist-add"
     onclick="moreurl(this, { 'from':'doulist-btn-1003-2995812-197956574'})">
      <i></i>添加到豆列
  </a>
    </div>

            </li>
            
            
    
    <li class="rec" id="W-197956574">
        <a href= "#" data-type="W" data-url="https://music.douban.com/subject/2995812/" data-desc="" data-title="专辑《We Sing. We Dance. We Steal Things.》 (来自豆瓣) " data-pic="https://img2.doubanio.com/view/subject/m/public/s2967252.jpg" class="bn-sharing ">分享到</a> &nbsp;&nbsp;
    </li>
    <script>
    if (!window.DoubanShareMenuList) {
        window.DoubanShareMenuList = [];
    }
    var __cache_url = __cache_url || {};
    (function(u){
        if(__cache_url[u]) return;
        __cache_url[u] = true;
        window.DoubanShareIcons = 'https://img3.doubanio.com/f/shire/3c8da10d6081bd1b2d13d3733b2ac201535c5d0f/pics/ic_shares2.png';
        var initShareButton = function() {
          $.ajax({url:u,dataType:'script',cache:true});
        };
        if (typeof Do == 'function' && 'ready' in Do) {
          Do('https://img3.doubanio.com/f/shire/8377b9498330a2e6f056d863987cc7a37eb4d486/css/ui/dialog.css',
            'https://img3.doubanio.com/f/shire/bc881a837a728ab82aa01d653b1c180190bb5a5d/js/ui/dialog.js',
            initShareButton);
        } else if(typeof Douban == 'object' && 'loader' in Douban) {
          Douban.loader.batch(
            'https://img3.doubanio.com/f/shire/8377b9498330a2e6f056d863987cc7a37eb4d486/css/ui/dialog.css',
            'https://img3.doubanio.com/f/shire/bc881a837a728ab82aa01d653b1c180190bb5a5d/js/ui/dialog.js'
          ).done(initShareButton);
        }
    })('https://img3.doubanio.com/f/shire/64044c0cde0c2bbf9c3eb94e57da6070d0340c4b/js/lib/sharebutton.js');
    </script>

    </ul>
</div>
    







    <script>
        var rec_url = 'https://www.douban.com/share/recommend?'
    </script>
        <script type="text/javascript" src="https://img3.doubanio.com/f/shire/9238d0db7d5fc042186ec54ebc5b4e64653f5e46/js/dshare.js"></script>

    <div class="rec-sec">

    <span class="rec">

<a data-user_id="197956574" href="https://www.douban.com/share/recommend?sanity_key=_e7243&amp;apikey=&amp;object_kind=1003&amp;name=We+Sing.+We+Dance.+We+Steal+Things.&amp;image=https%3A%2F%2Fimg2.doubanio.com%2Fview%2Fsubject%2Fs%2Fpublic%2Fs2967252.jpg&amp;target_action=0&amp;redir=https%3A%2F%2Fmusic.douban.com%2Fsubject%2F2995812%2F&amp;object_id=2995812&amp;heading=%E6%8E%A8%E8%8D%90%E5%88%B0%E8%B1%86%E7%93%A3&amp;target_type=rec&amp;btn_text=%E6%8E%A8%E8%8D%90&amp;href=https%3A%2F%2Fmusic.douban.com%2Fsubject%2F2995812%2F&amp;action_props=%7B%22subject_url%22%3A%22https%3A%5C%2F%5C%2Fmusic.douban.com%5C%2Fsubject%5C%2F2995812%5C%2F%22%2C%22subject_title%22%3A%22We+Sing.+We+Dance.+We+Steal+Things.%22%7D&amp;curl=&amp;type=music&amp;properties=%7B%22rating%22%3A%229.1%22%7D&amp;desc=Jason+Mraz+%2F+Import+%2F+2008-05-13+%2F+Atlantic%2FWEA+%2F+Audio+CD" share-id="2995812" data-mode="plain" data-name="We Sing. We Dance. We Steal Things." data-type="music" data-desc="Jason Mraz / Import / 2008-05-13 / Atlantic/WEA / Audio CD" data-href="https://music.douban.com/subject/2995812/" data-image="https://img2.doubanio.com/view/subject/s/public/s2967252.jpg" data-properties="{&#34;rating&#34;:&#34;9.1&#34;}" data-redir="https://music.douban.com/static/dshare_proxy.html" data-text="" data-apikey="" data-curl="" data-count="10" data-object_kind="1003" data-object_id="2995812" data-target_type="rec" data-target_action="0" data-action_props="{&#34;subject_url&#34;:&#34;https:\/\/music.douban.com\/subject\/2995812\/&#34;,&#34;subject_title&#34;:&#34;We Sing. We Dance. We Steal Things.&#34;}" data-btn_text="推荐" data-heading="推荐到豆瓣" data-sanity_key="_e7243" class="lnk-sharing lnk-douban-sharing">推荐</a>
</span>
</div>


    </div>
    <br clear="all"/>

    <div id="collect_form_2995812"></div>

    <div class="related_info">
        





    
    <h2>
        简介
            &nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;
    </h2>

    <div class="indent" id="link-report">
            
                <span class="short">
                    <span property="v:summary">　　沉淀一年，回归简单生活，用全新能量在第三张原创专辑当中活出自我l 部落格女孩Colbie Caillat、心灵投手James Morrison诚意跨刀献声！出生自维吉尼亚的一个朴实小镇的Jason Mraz，在纽约念大学的时候主修音乐剧，有一天他拿起吉他，突然发现自己的天命，于是便在毕业之后，跑到圣地亚哥当起街头艺人。在那段时期，他和自称是灵媒的流浪汉，成为心灵伙伴，他也开始四处流浪探索人生，并在这过程当中，很幸运地遇到生命中的贵人--知名音乐人鼓手Toca Rivera，两人一同演出的精彩现场表演，也成为当时美国西岸网络间，最广为流传的行家级必备珍藏。Jason Mraz这位出色的素人歌手，在2002顺利获得唱片合约，推出首张专辑“Waiting For My Rocket To Come”，专辑一推出，随即攻下全美热门潜力榜亚军，并获得了白金...</span>
                    <a href="javascript:void(0)" class="j a_show_full">(展开全部)</a>
                </span>
                <span class="all hidden">　　沉淀一年，回归简单生活，用全新能量在第三张原创专辑当中活出自我l 部落格女孩Colbie Caillat、心灵投手James Morrison诚意跨刀献声！出生自维吉尼亚的一个朴实小镇的Jason Mraz，在纽约念大学的时候主修音乐剧，有一天他拿起吉他，突然发现自己的天命，于是便在毕业之后，跑到圣地亚哥当起街头艺人。在那段时期，他和自称是灵媒的流浪汉，成为心灵伙伴，他也开始四处流浪探索人生，并在这过程当中，很幸运地遇到生命中的贵人--知名音乐人鼓手Toca Rivera，两人一同演出的精彩现场表演，也成为当时美国西岸网络间，最广为流传的行家级必备珍藏。Jason Mraz这位出色的素人歌手，在2002顺利获得唱片合约，推出首张专辑“Waiting For My Rocket To Come”，专辑一推出，随即攻下全美热门潜力榜亚军，并获得了白金销售认证，当中的「The Remedy (I Won’t Worry)」、「You and I Both」也都成为传唱度极高的单曲。2005发行第二张原创大碟“Mr. A-Z”，甫发行即空降美国告示牌TOP5，而Jason擅长把玩文字的创意，也在这张专辑里作了更淋漓尽致的发挥。在发行了两张专辑、参加无数场现场表演、以及一连串的宣传行程之后，Jason决定把时间留给自己，他想利用一年的时间，让自己回归到一般生活里。他不打算安排任何的工作行程，只想简单地逛逛杂货店、亲手喂猫咪、自己洗衣服、照顾花园里的草木等…。在回归简单生活的几个月之后，奇妙的事发生了，源源不绝的创作灵感，不停自脑中满溢出来，Jason在这休息的过程里，慢慢地从自我了解到自我强化，一直到自我成长，而这些崭新的音乐能量，自然而然地汇集结成第三张原创专辑“We Sing, We Dance, We Steal Things”！ 「Make It Mine」作了有一点戏剧化的开场，积极的喜悦、真挚的热情、无虑的自在，我们都感受到了；如果想把大自然写成一首歌，「I`m Yours」就是最好的问候语，而Jason Mraz则会是最佳的翻译官，这首歌早已透过网络的传递，让许多人补充满满的好心情；部落格女孩Colbie Caillat(寇比凯蕾)和Jason Mraz的温暖情歌「Lucky」，让幸福以最简单的方式，提供随身携带的服务；心灵投手James Morrison和Jason Mraz，用彼此不同的声线，编织出「Details In The Fabric」的纹理分明；「The Dynamo Of Volition」一边在舌尖按下快转键，Jason一边大玩特玩他刚刚发现、叫做Acid Jazz的新玩具；带着简单的吉他声，一同来到夕阳满溢的时间回廊里，逆着时光前进的方向走，一个男人拉开身体的拉炼，发现里面住着一位受了伤的小男孩，双手紧握着「Love For A Child」这张泛黄的相片；十指轻敲浅岸水面，阵阵钢琴音符像连漪散开，令人心醉神迷，不知不觉走向水中央，「If It Kills Me」随着弦乐交织成的漩涡，一同慢慢陷入灭顶终点；爱的瞬间就像一场美丽核爆，而被毁灭后的世界荒芜残破，铺天盖地的寂寞尘埃，散落空中慢速纷飞，「Beautiful Mess」沙哑地叙述这场，无力招架、没有筹码的连锁效应！每个人的心里都住着一个孩子，曾经不想长大的Jason Mraz，这一次他终于弯下腰来，牵起那个跟他有着一样微笑的孩子，手拉着手一起走出自在的步伐。</span>
                
    <script type="text/javascript" src="https://img3.doubanio.com/f/shire/bc7a779ea587a4a077edb3b6121316f65febbd13/js/report_dialog.js"></script>
    <link rel="stylesheet" type="text/css" href="https://img3.doubanio.com/f/shire/23ff197799d608be56df5dfefb4974fa33f4579b/css/report_dialog.css" />

    

    

            <br/>
    </div>




        



<link rel="stylesheet" href="https://img3.doubanio.com/f/verify/16c7e943aee3b1dc6d65f600fcc0f6d62db7dfb4/entry_creator/dist/author_subject/style.css">
<div id="author_subject" class="author-wrapper">
    <div class="loading"></div>
</div>
<script>
    var answerObj = {
        TYPE: 'music',
        SUBJECT_ID: '2995812',
        ISALL: 'False' || false,
        USER_ID: '197956574'
    }
</script>
<script src="https://img3.doubanio.com/f/music/61252f2f9b35f08b37f69d17dfe48310dd295347/js/music/lib/react/bundle.js"></script>
<script type="text/javascript" src="https://img3.doubanio.com/f/verify/ac140ef86262b845d2be7b859e352d8196f3f6d4/entry_creator/dist/author_subject/index.js"></script> 

        









            
            <div class="">
                
    <h2>
        曲目
            &nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;
    </h2>

                    <div class="track-list">
                        <div class="indent">
                            <div class="">
                                1. Make it Mine<br/>2. I'm Yours<br/>3. Lucky featuring Colbie Caillat<br/>4. Butterfly<br/>5. Live High<br/>6. Love for a Child<br/>7. Details In Fabric featuring James Morrison<br/>8. Coyotes<br/>9. Only Human<br/>10. The Dynamo of Volition<br/>11. If It Kills Me<br/>12. A Beautiful Mess
                            </div>
                        </div>
                    </div>
                </div>
                

<br clear="all">

    
    
    
    
    
    <link href="https://img3.doubanio.com/f/music/89e93100dcacde1f28063e94b853016333a3e2d6/css/music/player_button.css" rel="stylesheet" type="text/css">
        <div id="db-rec-artist-section" class="block5 subject_show knnlike">
            
    <h2>
        喜欢听&#34;We Sing. We Dance. We Steal Things.&#34;的人也喜欢的音乐人
            &nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;
    </h2>

            <div class="content clearfix">
                    
                    
                    <dl class="subject-rec-list" style="">
                        <dt class="artist-rec" data-sids="[&#34;17572&#34;, &#34;17524&#34;, &#34;25043&#34;]">
                                <a href="https://site.douban.com/owlcity/">
                                    <img class="m_sub_img" src="https://img3.doubanio.com/view/site/large/public/570676803fc6f60.jpg" width="115"/>
                                </a>
                                <div class="player-round-btn-bg">
                                    <p>试听热门歌曲</p>
                                    <span class="span-player-round-btn">
                                        <i class="icon-player-round-btn"></i>
                                    </span>
                                </div>
                        </dt>
                        <dd>
                            <a href="https://site.douban.com/owlcity/" target="_blank">Owl City</a>
                        </dd>
                    </dl>
                    
                    
                    <dl class="subject-rec-list" style="">
                        <dt class="artist-rec" data-sids="[&#34;6656&#34;, &#34;7412&#34;, &#34;50674&#34;]">
                                <a href="https://site.douban.com/maximilian/">
                                    <img class="m_sub_img" src="https://img1.doubanio.com/view/site/large/public/3e24af0d9145f08.jpg" width="115"/>
                                </a>
                                <div class="player-round-btn-bg">
                                    <p>试听热门歌曲</p>
                                    <span class="span-player-round-btn">
                                        <i class="icon-player-round-btn"></i>
                                    </span>
                                </div>
                        </dt>
                        <dd>
                            <a href="https://site.douban.com/maximilian/" target="_blank">麦斯米兰</a>
                        </dd>
                    </dl>
                    
                    
                    <dl class="subject-rec-list" style="">
                        <dt class="artist-rec" data-sids="[&#34;67660&#34;, &#34;69978&#34;, &#34;78018&#34;]">
                                <a href="https://site.douban.com/omnipotent/">
                                    <img class="m_sub_img" src="https://img9.doubanio.com/view/site/large/public/2ce3b2eead0e546.jpg" width="115"/>
                                </a>
                                <div class="player-round-btn-bg">
                                    <p>试听热门歌曲</p>
                                    <span class="span-player-round-btn">
                                        <i class="icon-player-round-btn"></i>
                                    </span>
                                </div>
                        </dt>
                        <dd>
                            <a href="https://site.douban.com/omnipotent/" target="_blank">万能青年旅店</a>
                        </dd>
                    </dl>
                    
                    
                    <dl class="subject-rec-list" style="">
                        <dt class="artist-rec" data-sids="[&#34;105636&#34;, &#34;12070&#34;, &#34;10146&#34;]">
                                <a href="https://site.douban.com/waawei/">
                                    <img class="m_sub_img" src="https://img1.doubanio.com/view/site/large/public/583f7202930b23c.jpg" width="115"/>
                                </a>
                                <div class="player-round-btn-bg">
                                    <p>试听热门歌曲</p>
                                    <span class="span-player-round-btn">
                                        <i class="icon-player-round-btn"></i>
                                    </span>
                                </div>
                        </dt>
                        <dd>
                            <a href="https://site.douban.com/waawei/" target="_blank">魏如萱(waa)</a>
                        </dd>
                    </dl>
                    
                    
                    <dl class="subject-rec-list" style="margin-right:0px">
                        <dt class="artist-rec" data-sids="[&#34;446119&#34;, &#34;34146&#34;, &#34;10422&#34;]">
                                <a href="https://site.douban.com/thelifejourney/">
                                    <img class="m_sub_img" src="https://img1.doubanio.com/view/site/large/public/3fb2252e7a35ec9.jpg" width="115"/>
                                </a>
                                <div class="player-round-btn-bg">
                                    <p>试听热门歌曲</p>
                                    <span class="span-player-round-btn">
                                        <i class="icon-player-round-btn"></i>
                                    </span>
                                    <span class="span-fleece-id"></span>
                                </div>
                        </dt>
                        <dd>
                            <a href="https://site.douban.com/thelifejourney/" target="_blank">旅行団</a>
                        </dd>
                    </dl>
                        <dl class="clear"></dl>
            </div>
        </div>
        




        



        
            <div id="db-rec-section" class="block5 subject_show knnlike">
                
    <h2>
        喜欢听&#34;We Sing. We Dance. We Steal Things.&#34;的人也喜欢的唱片
            &nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;
    </h2>

                <div class="content clearfix">
                        
                        
                        <dl class="subject-rec-list" style="">
                            <dt>
                                    <a href="https://music.douban.com/subject/1823439/"><img class="m_sub_img" src="https://img2.doubanio.com/view/subject/m/public/s2761461.jpg" width="115" /></a>
                            </dt>
                            <dd>
                                <a href="https://music.douban.com/subject/1823439/" class="">Mr. A-Z</a>
                            </dd>
                        </dl>
                        
                        
                        <dl class="subject-rec-list" style="">
                            <dt>
                                    <a href="https://music.douban.com/subject/3097879/"><img class="m_sub_img" src="https://img2.doubanio.com/view/subject/m/public/s9074663.jpg" width="115" /></a>
                            </dt>
                            <dd>
                                <a href="https://music.douban.com/subject/3097879/" class="">I&#39;m Yours</a>
                            </dd>
                        </dl>
                        
                        
                        <dl class="subject-rec-list" style="">
                            <dt>
                                    <a href="https://music.douban.com/subject/1394590/"><img class="m_sub_img" src="https://img1.doubanio.com/view/subject/m/public/s2838077.jpg" width="115" /></a>
                            </dt>
                            <dd>
                                <a href="https://music.douban.com/subject/1394590/" class="">O</a>
                            </dd>
                        </dl>
                        
                        
                        <dl class="subject-rec-list" style="">
                            <dt>
                                    <a href="https://music.douban.com/subject/1401550/"><img class="m_sub_img" src="https://img2.doubanio.com/view/subject/m/public/s1461123.jpg" width="115" /></a>
                            </dt>
                            <dd>
                                <a href="https://music.douban.com/subject/1401550/" class="">Back To Bedlam</a>
                            </dd>
                        </dl>
                        
                        
                        <dl class="subject-rec-list" style="margin-right:0px">
                            <dt>
                                    <a href="https://music.douban.com/subject/3040149/"><img class="m_sub_img" src="https://img9.doubanio.com/view/subject/m/public/s3054604.jpg" width="115" /></a>
                            </dt>
                            <dd>
                                <a href="https://music.douban.com/subject/3040149/" class="">Viva La Vida</a>
                            </dd>
                        </dl>
                            <dl class="clear"></dl>
                        
                        
                        <dl class="subject-rec-list" style="">
                            <dt>
                                    <a href="https://music.douban.com/subject/1396380/"><img class="m_sub_img" src="https://img2.doubanio.com/view/subject/m/public/s1485602.jpg" width="115" /></a>
                            </dt>
                            <dd>
                                <a href="https://music.douban.com/subject/1396380/" class="">American Idiot</a>
                            </dd>
                        </dl>
                        
                        
                        <dl class="subject-rec-list" style="">
                            <dt>
                                    <a href="https://music.douban.com/subject/2131368/"><img class="m_sub_img" src="https://img3.doubanio.com/view/subject/m/public/s2821080.jpg" width="115" /></a>
                            </dt>
                            <dd>
                                <a href="https://music.douban.com/subject/2131368/" class="">Once (Soundtrack)</a>
                            </dd>
                        </dl>
                        
                        
                        <dl class="subject-rec-list" style="">
                            <dt>
                                    <a href="https://music.douban.com/subject/1395432/"><img class="m_sub_img" src="https://img1.doubanio.com/view/subject/m/public/s4346679.jpg" width="115" /></a>
                            </dt>
                            <dd>
                                <a href="https://music.douban.com/subject/1395432/" class="">In Between Dreams</a>
                            </dd>
                        </dl>
                        
                        
                        <dl class="subject-rec-list" style="">
                            <dt>
                                    <a href="https://music.douban.com/subject/3184419/"><img class="m_sub_img" src="https://img9.doubanio.com/view/subject/m/public/s3259484.jpg" width="115" /></a>
                            </dt>
                            <dd>
                                <a href="https://music.douban.com/subject/3184419/" class="">Lenka</a>
                            </dd>
                        </dl>
                        
                        
                        <dl class="subject-rec-list" style="margin-right:0px">
                            <dt>
                                    <a href="https://music.douban.com/subject/1968390/"><img class="m_sub_img" src="https://img2.doubanio.com/view/subject/m/public/s2657592.jpg" width="115" /></a>
                            </dt>
                            <dd>
                                <a href="https://music.douban.com/subject/1968390/" class="">Life In Cartoon Motion</a>
                            </dd>
                        </dl>
                            <dl class="clear"></dl>
                </div>
            </div>








            




    <div id='comments-section'>
        <link rel="stylesheet" href="https://img3.doubanio.com/f/music/16c2b96ce936f65269d562970bdfd7b3572ffec9/css/music/lib/subject-comments/comments-section.css"/>
        <link rel="stylesheet" href="https://img3.doubanio.com/f/music/40a95eb84962f5da4ee5eb92095d09bf843be68b/css/music/lib/subject-comments/comments.css"/>
        <div class="mod-hd">
            
            <a class="redbutt rr collect_btn" href="https://music.douban.com/subject/2995812/?interest=collect&amp;ck=2tyY" name="pbtn-2995812-collect"><span>我来说两句</span></a>
                
    <h2>
        短评
            &nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;
            <span class="pl">&nbsp;(
                
                    <a href="https://music.douban.com/subject/2995812/comments/" target="_self">全部 9957 条</a>
                ) </span>
    </h2>

        </div>
        <div class="nav-tab">
            
    <div class="tabs-wrapper  line">
        <a class="short-comment-tabs on-tab" 
            href="https://music.douban.com/subject/2995812/comments?sort=new_score" 
            data-tab="new_score">热门</a>
        <span>/</span>
        <a class="short-comment-tabs " 
            href="https://music.douban.com/subject/2995812/comments?sort=time" 
            data-tab="time">最新</a>
        <span>/</span>
        <a class="short-comment-tabs " 
            href="https://music.douban.com/subject/2995812/comments?sort=follows" 
            data-tab="follows">好友</a>
    </div>

        </div>
        <div id="comment-list-wrapper" class="indent">
            
  
  <div class="comment-list new_score show" id="new_score">
      <ul>
          
  <li class="comment-item" data-cid="40383167">
    <div class="comment">
      <h3>
        <span class="comment-vote">
          <span id="c-40383167" class="vote-count">3</span>
            <a href="javascript:;" id="btn-40383167" class="j vote-comment" data-cid="40383167">有用</a>
        </span>
        <span class="comment-info">
          <a href="https://www.douban.com/people/claire1212/">Claire</a>
            <span class="user-stars allstar40 rating" title="推荐"></span>
          <span class="comment-time">2009-04-07 21:36:28</span>
        </span>
      </h3>
      <p class="comment-content">
      
        <span class="short">听Jason Mraz是一件快乐的事情。</span>
      </p>
    </div>
  </li>

          
  <li class="comment-item" data-cid="217679218">
    <div class="comment">
      <h3>
        <span class="comment-vote">
          <span id="c-217679218" class="vote-count">6</span>
            <a href="javascript:;" id="btn-217679218" class="j vote-comment" data-cid="217679218">有用</a>
        </span>
        <span class="comment-info">
          <a href="https://www.douban.com/people/dennisummer/">夏日扬帆</a>
            <span class="user-stars allstar50 rating" title="力荐"></span>
          <span class="comment-time">2010-02-16 09:06:17</span>
        </span>
      </h3>
      <p class="comment-content">
      
        <span class="short">好多歌都听了无数次[i&#39;m yours,lusky,butterfly,love for a child]</span>
      </p>
    </div>
  </li>

          
  <li class="comment-item" data-cid="88194201">
    <div class="comment">
      <h3>
        <span class="comment-vote">
          <span id="c-88194201" class="vote-count">0</span>
            <a href="javascript:;" id="btn-88194201" class="j vote-comment" data-cid="88194201">有用</a>
        </span>
        <span class="comment-info">
          <a href="https://www.douban.com/people/charlotte9014/">夏夏夏</a>
            <span class="user-stars allstar50 rating" title="力荐"></span>
          <span class="comment-time">2009-01-15 17:57:32</span>
        </span>
      </h3>
      <p class="comment-content">
      
        <span class="short">太棒啦</span>
      </p>
    </div>
  </li>

          
  <li class="comment-item" data-cid="47530874">
    <div class="comment">
      <h3>
        <span class="comment-vote">
          <span id="c-47530874" class="vote-count">4</span>
            <a href="javascript:;" id="btn-47530874" class="j vote-comment" data-cid="47530874">有用</a>
        </span>
        <span class="comment-info">
          <a href="https://www.douban.com/people/xiaojiong/">小水</a>
            <span class="user-stars allstar20 rating" title="较差"></span>
          <span class="comment-time">2008-07-12 15:24:20</span>
        </span>
      </h3>
      <p class="comment-content">
      
        <span class="short">为什么大家都喜欢。。。弄不懂了</span>
      </p>
    </div>
  </li>

          
  <li class="comment-item" data-cid="233000869">
    <div class="comment">
      <h3>
        <span class="comment-vote">
          <span id="c-233000869" class="vote-count">9</span>
            <a href="javascript:;" id="btn-233000869" class="j vote-comment" data-cid="233000869">有用</a>
        </span>
        <span class="comment-info">
          <a href="https://www.douban.com/people/trampolin/">蹦床</a>
            <span class="user-stars allstar30 rating" title="还行"></span>
          <span class="comment-time">2010-03-25 12:44:55</span>
        </span>
      </h3>
      <p class="comment-content">
      
        <span class="short">也就人长得还行吧，反正我就知道民谣类专辑豆瓣上星评肯定特高，还有dream pop之类的</span>
      </p>
    </div>
  </li>

      </ul>
  </div>
  
<script type="text/javascript" src="https://img3.doubanio.com/f/shire/bc7a779ea587a4a077edb3b6121316f65febbd13/js/report_dialog.js"></script>
<link rel="stylesheet" type="text/css" href="https://img3.doubanio.com/f/shire/23ff197799d608be56df5dfefb4974fa33f4579b/css/report_dialog.css" />
<style>
      #comments .comment-report { float: right; margin-left: 10px; bottom: 8px; }
    #comments .comment-report { font-size: 12px; visibility: hidden; }
    #comments .comment-report a { color: #BBB; }
    #comments .comment-report a:hover { color: #FFF; background-color: #BBB; }
    
</style>
<script>
    function ADD_REPORT () {
        var div = ".comment"
        $('.comment-item '.concat(div)).append('<div class="comment-report"><a rel="nofollow" href="#">投诉</a></div>');
    }
    Do = (typeof Do === 'undefined')? $ : Do;
    Do(function(){
        $("body").delegate(".comment-item", 'mouseenter mouseleave', function (e) {
          switch (e.type) {
            case "mouseenter":
              $(this).find(".comment-report").css('visibility', 'visible');
              break;
            case "mouseleave":
              $(this).find(".comment-report").css('visibility', 'hidden');
              break;
          }
        });
        $("body").delegate(".comment-report a", 'click', function (e) {
            e.preventDefault();
            var opt = "comment_id";
            var obj = $(e.target).closest('.comment-item');
            var cid = obj.data("cid");
            var url = "https://music.douban.com/subject/2995812/?".concat(opt, '=', cid);
            if (window.generate_report_dialog) {
                generate_report_dialog({ report_url: url, type: ['subject', 'comment'] });
            } else {
                window.location.href = url;
            }
        });

        ADD_REPORT();
    });
</script>


            
  
  <div class="comment-list time hide" id="time">
      <ul>
          
  <li class="comment-item" data-cid="2670964370">
    <div class="comment">
      <h3>
        <span class="comment-vote">
          <span id="c-2670964370" class="vote-count">0</span>
            <a href="javascript:;" id="btn-2670964370" class="j vote-comment" data-cid="2670964370">有用</a>
        </span>
        <span class="comment-info">
          <a href="https://www.douban.com/people/133728122/">微笑的迪妮莎</a>
            <span class="user-stars allstar40 rating" title="推荐"></span>
          <span class="comment-time">2021-12-04 20:29:16</span>
        </span>
      </h3>
      <p class="comment-content">
      
        <span class="short">民谣爆米花音乐</span>
      </p>
    </div>
  </li>

          
  <li class="comment-item" data-cid="53949146">
    <div class="comment">
      <h3>
        <span class="comment-vote">
          <span id="c-53949146" class="vote-count">0</span>
            <a href="javascript:;" id="btn-53949146" class="j vote-comment" data-cid="53949146">有用</a>
        </span>
        <span class="comment-info">
          <a href="https://www.douban.com/people/2180096/">tina</a>
            <span class="user-stars allstar50 rating" title="力荐"></span>
          <span class="comment-time">2021-11-04 17:18:44</span>
        </span>
      </h3>
      <p class="comment-content">
      
        <span class="short">We Sing, We Dance, We Steal Things</span>
      </p>
    </div>
  </li>

          
  <li class="comment-item" data-cid="3128815957">
    <div class="comment">
      <h3>
        <span class="comment-vote">
          <span id="c-3128815957" class="vote-count">0</span>
            <a href="javascript:;" id="btn-3128815957" class="j vote-comment" data-cid="3128815957">有用</a>
        </span>
        <span class="comment-info">
          <a href="https://www.douban.com/people/MrBeanXi2000/">我是一个啦啦啦</a>
            <span class="user-stars allstar40 rating" title="推荐"></span>
          <span class="comment-time">2021-11-29 16:25:14</span>
        </span>
      </h3>
      <p class="comment-content">
      
        <span class="short">I’m yours </span>
      </p>
    </div>
  </li>

          
  <li class="comment-item" data-cid="1670919569">
    <div class="comment">
      <h3>
        <span class="comment-vote">
          <span id="c-1670919569" class="vote-count">0</span>
            <a href="javascript:;" id="btn-1670919569" class="j vote-comment" data-cid="1670919569">有用</a>
        </span>
        <span class="comment-info">
          <a href="https://www.douban.com/people/142909736/">牧屿</a>
            <span class="user-stars allstar50 rating" title="力荐"></span>
          <span class="comment-time">2021-11-20 14:26:30</span>
        </span>
      </h3>
      <p class="comment-content">
      
        <span class="short">I feel your whisper across the sea </span>
      </p>
    </div>
  </li>

          
  <li class="comment-item" data-cid="3098634321">
    <div class="comment">
      <h3>
        <span class="comment-vote">
          <span id="c-3098634321" class="vote-count">0</span>
            <a href="javascript:;" id="btn-3098634321" class="j vote-comment" data-cid="3098634321">有用</a>
        </span>
        <span class="comment-info">
          <a href="https://www.douban.com/people/230130423/">移动的哈尔</a>
            <span class="user-stars allstar50 rating" title="力荐"></span>
          <span class="comment-time">2021-11-06 01:12:41</span>
        </span>
      </h3>
      <p class="comment-content">
      
        <span class="short">lucky真浪漫</span>
      </p>
    </div>
  </li>

      </ul>
  </div>
  
<script type="text/javascript" src="https://img3.doubanio.com/f/shire/bc7a779ea587a4a077edb3b6121316f65febbd13/js/report_dialog.js"></script>
<link rel="stylesheet" type="text/css" href="https://img3.doubanio.com/f/shire/23ff197799d608be56df5dfefb4974fa33f4579b/css/report_dialog.css" />
<style>
      #comments .comment-report { float: right; margin-left: 10px; bottom: 8px; }
    #comments .comment-report { font-size: 12px; visibility: hidden; }
    #comments .comment-report a { color: #BBB; }
    #comments .comment-report a:hover { color: #FFF; background-color: #BBB; }
    
</style>
<script>
    function ADD_REPORT () {
        var div = ".comment"
        $('.comment-item '.concat(div)).append('<div class="comment-report"><a rel="nofollow" href="#">投诉</a></div>');
    }
    Do = (typeof Do === 'undefined')? $ : Do;
    Do(function(){
        $("body").delegate(".comment-item", 'mouseenter mouseleave', function (e) {
          switch (e.type) {
            case "mouseenter":
              $(this).find(".comment-report").css('visibility', 'visible');
              break;
            case "mouseleave":
              $(this).find(".comment-report").css('visibility', 'hidden');
              break;
          }
        });
        $("body").delegate(".comment-report a", 'click', function (e) {
            e.preventDefault();
            var opt = "comment_id";
            var obj = $(e.target).closest('.comment-item');
            var cid = obj.data("cid");
            var url = "https://music.douban.com/subject/2995812/?".concat(opt, '=', cid);
            if (window.generate_report_dialog) {
                generate_report_dialog({ report_url: url, type: ['subject', 'comment'] });
            } else {
                window.location.href = url;
            }
        });

        ADD_REPORT();
    });
</script>


                
  
  <div class="comment-list follows hide" id="follows">
      
      <ul>
        <li class="comment-item">
        <p class="blank-tip">你关注的人还没有写短评呢</p>
        </li>
      </ul>
  </div>
  
<script type="text/javascript" src="https://img3.doubanio.com/f/shire/bc7a779ea587a4a077edb3b6121316f65febbd13/js/report_dialog.js"></script>
<link rel="stylesheet" type="text/css" href="https://img3.doubanio.com/f/shire/23ff197799d608be56df5dfefb4974fa33f4579b/css/report_dialog.css" />
<style>
      #comments .comment-report { float: right; margin-left: 10px; bottom: 8px; }
    #comments .comment-report { font-size: 12px; visibility: hidden; }
    #comments .comment-report a { color: #BBB; }
    #comments .comment-report a:hover { color: #FFF; background-color: #BBB; }
    
</style>
<script>
    function ADD_REPORT () {
        var div = ".comment"
        $('.comment-item '.concat(div)).append('<div class="comment-report"><a rel="nofollow" href="#">投诉</a></div>');
    }
    Do = (typeof Do === 'undefined')? $ : Do;
    Do(function(){
        $("body").delegate(".comment-item", 'mouseenter mouseleave', function (e) {
          switch (e.type) {
            case "mouseenter":
              $(this).find(".comment-report").css('visibility', 'visible');
              break;
            case "mouseleave":
              $(this).find(".comment-report").css('visibility', 'hidden');
              break;
          }
        });
        $("body").delegate(".comment-report a", 'click', function (e) {
            e.preventDefault();
            var opt = "comment_id";
            var obj = $(e.target).closest('.comment-item');
            var cid = obj.data("cid");
            var url = "https://music.douban.com/subject/2995812/?".concat(opt, '=', cid);
            if (window.generate_report_dialog) {
                generate_report_dialog({ report_url: url, type: ['subject', 'comment'] });
            } else {
                window.location.href = url;
            }
        });

        ADD_REPORT();
    });
</script>


        </div>
            <p>&gt; <a href="https://music.douban.com/subject/2995812/comments/">更多短评 9957 条</a></p>
        <script src="https://img3.doubanio.com/f/music/6eba6f43fb7592ab783e390f654c0d6a96b1598e/js/music/lib/subject-comments/comments-section.js"></script>
        <script>
            (function () {
                if (window.SUBJECT_COMMENTS_SECTION) {
                    // tab handler
                    SUBJECT_COMMENTS_SECTION.createTabHandler();
                    // expand handler
                    SUBJECT_COMMENTS_SECTION.createExpandHandler({
                        root: document.getElementById('comment-list-wrapper'),
                    });
                    // vote handler
                    SUBJECT_COMMENTS_SECTION.createVoteHandler({
                        api: '/j/comment/:id/vote',
                        root: document.getElementById('comment-list-wrapper'),
                        voteSelector: '.vote-comment',
                        textSelector: '.vote-count',
                        afterVote: function (elem) {
                            var parentNode = elem.parentNode;
                            var successElem = document.createElement('span');
                            successElem.innerHTML = '已投票';
                            parentNode.removeChild(elem);
                            parentNode.appendChild(successElem);
                        }
                    });
                }
            })()
        </script>
    </div>


            

<link rel="stylesheet" href="https://img3.doubanio.com/misc/mixed_static/59d264aa9a705a7a.css">

<section class="topics mod">
    <header>
        <h2>
            We Sing. We Dance. We Steal Things.的话题 · · · · · ·
            <span class="pl">( <span class="gallery_topics">全部 <span id="topic-count"></span> 条</span> )</span>
        </h2>
    </header>

    




<section class="subject-topics">
    <div class="topic-guide" id="topic-guide">
        <img class="ic_question" src="//img3.doubanio.com/f/ithildin/b1a3edea3d04805f899e9d77c0bfc0d158df10d5/pics/export/icon_question.png">
        <div class="tip_content">
            <div class="tip_title">什么是话题</div>
            <div class="tip_desc">
                <div>无论是一部作品、一个人，还是一件事，都往往可以衍生出许多不同的话题。将这些话题细分出来，分别进行讨论，会有更多收获。</div>
            </div>
        </div>
        <img class="ic_guide" src="//img3.doubanio.com/f/ithildin/529f46d86bc08f55cd0b1843d0492242ebbd22de/pics/export/icon_guide_arrow.png">
        <img class="ic_close" id="topic-guide-close" src="//img3.doubanio.com/f/ithildin/2eb4ad488cb0854644b23f20b6fa312404429589/pics/export/close@3x.png">
    </div>

    <div id="topic-items"></div>

    <script>
        window.subject_id = 2995812;
        window.join_label_text = '写乐评参与';

        window.topic_display_count = 4;
        window.topic_item_display_count = 1;
        window.no_content_fun_call_name = "no_topic";

        window.guideNode = document.getElementById('topic-guide');
        window.guideNodeClose = document.getElementById('topic-guide-close');
    </script>
    
        <link rel="stylesheet" href="https://img3.doubanio.com/f/ithildin/f731c9ea474da58c516290b3a6b1dd1237c07c5e/css/export/subject_topics.css">
        <script src="https://img3.doubanio.com/f/ithildin/d3590fc6ac47b33c804037a1aa7eec49075428c8/js/export/moment-with-locales-only-zh.js"></script>
        <script src="https://img3.doubanio.com/f/ithildin/c600fdbe69e3ffa5a3919c81ae8c8b4140e99a3e/js/export/subject_topics.js"></script>

</section>

    <script>
        function no_topic(){
            $('#content .topics').remove();
        }
    </script>
</section>
    <section id="reviews-wrapper" class="reviews mod music-content">
        <header>
            
                <a href="new_review" rel="nofollow" class="create-review redbutt rr "
                    data-isverify="True"
                    data-verify-url="https://www.douban.com/accounts/phone/verify?redir=https://music.douban.com/subject/2995812/new_review">
                    <span>我要写乐评</span>
                </a>
            <h2>
                We Sing. We Dance. We Steal Things.的乐评 · · · · · ·
                <span class="pl">( <a href="reviews">全部 244 条</a> )</span>
            </h2>
        </header>

        

<style>
#gallery-topics-selection {
  position: fixed;
  width: 595px;
  padding: 40px 40px 33px 40px;
  background: #fff;
  border-radius: 10px;
  box-shadow: 0 2px 16px 0 rgba(0, 0, 0, 0.2);
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  z-index: 9999;
}
#gallery-topics-selection h1 {
  font-size: 18px;
  color: #007722;
  margin-bottom: 36px;
  padding: 0;
  line-height: 28px;
  font-weight: normal;
}
#gallery-topics-selection .gl_topics {
  border-bottom: 1px solid #dfdfdf;
  max-height: 298px;
  overflow-y: scroll;
}
#gallery-topics-selection .topic {
  margin-bottom: 24px;
}
#gallery-topics-selection .topic_name {
  font-size: 15px;
  color: #333;
  margin: 0;
  line-height: inherit;
}
#gallery-topics-selection .topic_meta {
  font-size: 13px;
  color: #999;
}
#gallery-topics-selection .topics_skip {
  display: block;
  cursor: pointer;
  font-size: 16px;
  color: #3377AA;
  text-align: center;
  margin-top: 33px;
}
#gallery-topics-selection .topics_skip:hover {
  background: transparent;
}
#gallery-topics-selection .close_selection {
  position: absolute;
  width: 30px;
  height: 20px;
  top: 46px;
  right: 40px;
  background: #fff;
  color: #999;
  text-align: right;
}
#gallery-topics-selection .close_selection:hover{
  background: #fff;
  color: #999;
}
</style>




            <div class="review_filter">
                <a href="javascript:;;" class="cur" data-sort="">热门</a> &#047;
                <a href="javascript:;;" data-sort="time">最新</a> &#047;
                <a href="javascript:;;" data-sort="follow">好友</a>
            </div>
            <script>
                var cur_sort = '';
                $('#reviews-wrapper .review_filter a').on('click', function () {
                    var sort = $(this).data('sort');
                    if(sort === cur_sort) return;

                    if(sort === 'follow' && false){
                        window.location.href = '//www.douban.com/accounts/login?source=movie';
                        return;
                    }

                    if($('#reviews-wrapper .review_filter').data('doing')) return;
                    $('#reviews-wrapper .review_filter').data('doing', true);

                    cur_sort = sort;

                    $('#reviews-wrapper .review_filter a').removeClass('cur');
                    $(this).addClass('cur');

                    $.getJSON('reviews', { sort: sort }, function(res){
                        $('#reviews-wrapper .review-list').remove();
                        $('#reviews-wrapper [href="reviews?sort=follow"]').parent().remove();
                        $('#reviews-wrapper .review_filter').after(res.html);
                        $('#reviews-wrapper .review_filter').data('doing', false);
                        $('#reviews-wrapper .review_filter').removeData('doing');

                        if(res.count === 0){
                            $('#reviews-wrapper .review-list').html('<span class="no-review">你关注的人还没写过长评</span>');
                        }
                    });
                });
            </script>


            



<div class="review-list  ">
        
    

        
    
    <div data-cid="1394986">
        <div class="main review-item" id="1394986">

            
    
    <header class="main-hd">
        <a href="https://www.douban.com/people/muyi/" class="avator">
            <img width="24" height="24" src="https://img2.doubanio.com/icon/u1159954-1.jpg">
        </a>

        <a href="https://www.douban.com/people/muyi/" class="name">muyi</a>

            <span class="allstar50 main-title-rating" title="力荐"></span>

        <span content="2008-06-01" class="main-meta">2008-06-01 00:43:06</span>


    </header>


            <div class="main-bd">

                <h2><a href="https://music.douban.com/review/1394986/">字字珠玑Jason Mraz</a></h2>

                <div id="review_1394986_short" class="review-short" data-rid="1394986">
                    <div class="short-content">

                        第三张专辑了，jason mraz也应该已经不是那个双手插在口袋里站在街边等着自己的火箭来的男孩了。从最初的waiting for my rocket to come 到 mr a-z 再到今年的 we sing, we dance, we steal things。依稀觉得他从自我的成长到生活的理解再到更加诚恳的关切。不管是lucky里的情...

                        &nbsp;(<a href="javascript:;" id="toggle-1394986-copy" class="unfold" title="展开">展开</a>)
                    </div>
                </div>

                <div id="review_1394986_full" class="hidden">
                    <div id="review_1394986_full_content" class="full-content"></div>
                </div>

                <div class="action">
                    <a href="javascript:;" class="action-btn up" data-rid="1394986" title="有用">
                        <img src="https://img3.doubanio.com/f/zerkalo/536fd337139250b5fb3cf9e79cb65c6193f8b20b/pics/up.png" />
                        <span id="r-useful_count-1394986">
                                413
                        </span>
                    </a>
                    <a href="javascript:;" class="action-btn down" data-rid="1394986" title="没用">
                        <img src="https://img3.doubanio.com/f/zerkalo/68849027911140623cf338c9845893c4566db851/pics/down.png" />
                        <span id="r-useless_count-1394986">
                                6
                        </span>
                    </a>
                    <a href="https://music.douban.com/review/1394986/#comments" class="reply ">97回应</a>

                    <a href="javascript:;;" class="fold hidden">收起</a>
                </div>
            </div>
        </div>
    </div>

        
    
    <div data-cid="1477750">
        <div class="main review-item" id="1477750">

            
    
    <header class="main-hd">
        <a href="https://www.douban.com/people/1888222/" class="avator">
            <img width="24" height="24" src="https://img9.doubanio.com/icon/u1888222-15.jpg">
        </a>

        <a href="https://www.douban.com/people/1888222/" class="name">小宇宙燃烧！</a>

            <span class="allstar50 main-title-rating" title="力荐"></span>

        <span content="2008-08-23" class="main-meta">2008-08-23 14:24:57</span>


    </header>


            <div class="main-bd">

                <h2><a href="https://music.douban.com/review/1477750/">我只是晒着太阳 便感觉拥有了全世界</a></h2>

                <div id="review_1477750_short" class="review-short" data-rid="1477750">
                    <div class="short-content">

                          第一次听到《Lucky》大约是在凌晨一点左右，由于反复思考着如何在这假期的末尾赶完堆积如山的作业而辗转反侧。好不容易在这辗转的过程中找到一个舒服的姿势入梦，却在听到这首歌的时候硬分出了6分神智保持清醒，然后听到他们一起唱到：   I&#39;m lucky I&#39;m in love with my best...

                        &nbsp;(<a href="javascript:;" id="toggle-1477750-copy" class="unfold" title="展开">展开</a>)
                    </div>
                </div>

                <div id="review_1477750_full" class="hidden">
                    <div id="review_1477750_full_content" class="full-content"></div>
                </div>

                <div class="action">
                    <a href="javascript:;" class="action-btn up" data-rid="1477750" title="有用">
                        <img src="https://img3.doubanio.com/f/zerkalo/536fd337139250b5fb3cf9e79cb65c6193f8b20b/pics/up.png" />
                        <span id="r-useful_count-1477750">
                                410
                        </span>
                    </a>
                    <a href="javascript:;" class="action-btn down" data-rid="1477750" title="没用">
                        <img src="https://img3.doubanio.com/f/zerkalo/68849027911140623cf338c9845893c4566db851/pics/down.png" />
                        <span id="r-useless_count-1477750">
                                9
                        </span>
                    </a>
                    <a href="https://music.douban.com/review/1477750/#comments" class="reply ">114回应</a>

                    <a href="javascript:;;" class="fold hidden">收起</a>
                </div>
            </div>
        </div>
    </div>

        
    
    <div data-cid="1533110">
        <div class="main review-item" id="1533110">

            
    
    <header class="main-hd">
        <a href="https://www.douban.com/people/tangmenxiaosan/" class="avator">
            <img width="24" height="24" src="https://img3.doubanio.com/icon/u1225645-130.jpg">
        </a>

        <a href="https://www.douban.com/people/tangmenxiaosan/" class="name">奎斯Chris</a>

            <span class="allstar50 main-title-rating" title="力荐"></span>

        <span content="2008-10-23" class="main-meta">2008-10-23 00:56:14</span>


    </header>


            <div class="main-bd">

                <h2><a href="https://music.douban.com/review/1533110/">我的High歌之王</a></h2>

                <div id="review_1533110_short" class="review-short" data-rid="1533110">
                    <div class="short-content">

                        爱上某个事物，真的只是一瞬间的事情。 那时是初夏，夜晚的大街上还有点嘈杂。有一个声音从音响里传来，欢快又随性，他唱“嘟哔嘟哔嘟”，然后学意大利大舌头唱“叭啦叭叭叭”。 那时有一个女孩儿坐在我的房间里，她说，天气真热。其实天气并不是真的热。 那时我们在听的一首歌...

                        &nbsp;(<a href="javascript:;" id="toggle-1533110-copy" class="unfold" title="展开">展开</a>)
                    </div>
                </div>

                <div id="review_1533110_full" class="hidden">
                    <div id="review_1533110_full_content" class="full-content"></div>
                </div>

                <div class="action">
                    <a href="javascript:;" class="action-btn up" data-rid="1533110" title="有用">
                        <img src="https://img3.doubanio.com/f/zerkalo/536fd337139250b5fb3cf9e79cb65c6193f8b20b/pics/up.png" />
                        <span id="r-useful_count-1533110">
                                147
                        </span>
                    </a>
                    <a href="javascript:;" class="action-btn down" data-rid="1533110" title="没用">
                        <img src="https://img3.doubanio.com/f/zerkalo/68849027911140623cf338c9845893c4566db851/pics/down.png" />
                        <span id="r-useless_count-1533110">
                                6
                        </span>
                    </a>
                    <a href="https://music.douban.com/review/1533110/#comments" class="reply ">34回应</a>

                    <a href="javascript:;;" class="fold hidden">收起</a>
                </div>
            </div>
        </div>
    </div>

        
    
    <div data-cid="1988570">
        <div class="main review-item" id="1988570">

            
    
    <header class="main-hd">
        <a href="https://www.douban.com/people/briggtta/" class="avator">
            <img width="24" height="24" src="https://img1.doubanio.com/icon/u2383159-8.jpg">
        </a>

        <a href="https://www.douban.com/people/briggtta/" class="name">CHI</a>

            <span class="allstar50 main-title-rating" title="力荐"></span>

        <span content="2009-04-24" class="main-meta">2009-04-24 20:36:33</span>


    </header>


            <div class="main-bd">

                <h2><a href="https://music.douban.com/review/1988570/">we think we were ,but we are not</a></h2>

                <div id="review_1988570_short" class="review-short" data-rid="1988570">
                    <div class="short-content">

                        以为背起行囊竖起拇指就能任意揽到免费的车辆，其实只有出租车会偶尔停下，把我们当成进城找工打的对象。 以为坐在一辆破卡车后面吹着风摆着头看过往的风景很有形象，其实只有大风吹乱了头发，沙尘灌满了眼眶。 以为多点头死眨眼就能把到辣妹流口水，其实她身边的男人早想把我...

                        &nbsp;(<a href="javascript:;" id="toggle-1988570-copy" class="unfold" title="展开">展开</a>)
                    </div>
                </div>

                <div id="review_1988570_full" class="hidden">
                    <div id="review_1988570_full_content" class="full-content"></div>
                </div>

                <div class="action">
                    <a href="javascript:;" class="action-btn up" data-rid="1988570" title="有用">
                        <img src="https://img3.doubanio.com/f/zerkalo/536fd337139250b5fb3cf9e79cb65c6193f8b20b/pics/up.png" />
                        <span id="r-useful_count-1988570">
                                106
                        </span>
                    </a>
                    <a href="javascript:;" class="action-btn down" data-rid="1988570" title="没用">
                        <img src="https://img3.doubanio.com/f/zerkalo/68849027911140623cf338c9845893c4566db851/pics/down.png" />
                        <span id="r-useless_count-1988570">
                                2
                        </span>
                    </a>
                    <a href="https://music.douban.com/review/1988570/#comments" class="reply ">33回应</a>

                    <a href="javascript:;;" class="fold hidden">收起</a>
                </div>
            </div>
        </div>
    </div>

        
    
    <div data-cid="2283851">
        <div class="main review-item" id="2283851">

            
    
    <header class="main-hd">
        <a href="https://www.douban.com/people/liberal/" class="avator">
            <img width="24" height="24" src="https://img2.doubanio.com/icon/u3142606-63.jpg">
        </a>

        <a href="https://www.douban.com/people/liberal/" class="name">Lance</a>

            <span class="allstar50 main-title-rating" title="力荐"></span>

        <span content="2009-08-29" class="main-meta">2009-08-29 22:08:40</span>


    </header>


            <div class="main-bd">

                <h2><a href="https://music.douban.com/review/2283851/">重听Jason Mraz &lt;We Sing, We Dance, We Steal Things&gt;</a></h2>

                <div id="review_2283851_short" class="review-short" data-rid="2283851">
                    <div class="short-content">

                        北京从昨晚开始入秋了。  昨天晚上九点到凌晨五点一直在长安街参加国庆游行的第一次彩排，同宿舍的人一回到床上倒头便睡。睡到一半，被冻醒，后知后觉地把被子扯过来盖上，便暖暖地继续睡了。下午三点才醒。  于是出门开始加了件薄薄的小开衫，室友甚至还感冒了。     我最喜欢...

                        &nbsp;(<a href="javascript:;" id="toggle-2283851-copy" class="unfold" title="展开">展开</a>)
                    </div>
                </div>

                <div id="review_2283851_full" class="hidden">
                    <div id="review_2283851_full_content" class="full-content"></div>
                </div>

                <div class="action">
                    <a href="javascript:;" class="action-btn up" data-rid="2283851" title="有用">
                        <img src="https://img3.doubanio.com/f/zerkalo/536fd337139250b5fb3cf9e79cb65c6193f8b20b/pics/up.png" />
                        <span id="r-useful_count-2283851">
                                87
                        </span>
                    </a>
                    <a href="javascript:;" class="action-btn down" data-rid="2283851" title="没用">
                        <img src="https://img3.doubanio.com/f/zerkalo/68849027911140623cf338c9845893c4566db851/pics/down.png" />
                        <span id="r-useless_count-2283851">
                                1
                        </span>
                    </a>
                    <a href="https://music.douban.com/review/2283851/#comments" class="reply ">35回应</a>

                    <a href="javascript:;;" class="fold hidden">收起</a>
                </div>
            </div>
        </div>
    </div>

        
    
    <div data-cid="1569618">
        <div class="main review-item" id="1569618">

            
    
    <header class="main-hd">
        <a href="https://www.douban.com/people/lola-chang/" class="avator">
            <img width="24" height="24" src="https://img2.doubanio.com/icon/u3234458-2.jpg">
        </a>

        <a href="https://www.douban.com/people/lola-chang/" class="name">水蟹</a>

            <span class="allstar50 main-title-rating" title="力荐"></span>

        <span content="2008-11-29" class="main-meta">2008-11-29 11:56:00</span>


    </header>


            <div class="main-bd">

                <h2><a href="https://music.douban.com/review/1569618/">一种情感</a></h2>

                <div id="review_1569618_short" class="review-short" data-rid="1569618">
                    <div class="short-content">

                           听到他的声音比较晚，却是立即被征服了。这张专辑是我听他的开端所以有着不一样的感情。应此即使是再后来去搜索他的另外专辑时，总也少了那份感觉。这便是一见钟情哦。《Lucky》里那种甜腻的感觉至今仍在我耳边回荡，愉悦地，痒痒地~~呵呵~~

                        &nbsp;(<a href="javascript:;" id="toggle-1569618-copy" class="unfold" title="展开">展开</a>)
                    </div>
                </div>

                <div id="review_1569618_full" class="hidden">
                    <div id="review_1569618_full_content" class="full-content"></div>
                </div>

                <div class="action">
                    <a href="javascript:;" class="action-btn up" data-rid="1569618" title="有用">
                        <img src="https://img3.doubanio.com/f/zerkalo/536fd337139250b5fb3cf9e79cb65c6193f8b20b/pics/up.png" />
                        <span id="r-useful_count-1569618">
                        </span>
                    </a>
                    <a href="javascript:;" class="action-btn down" data-rid="1569618" title="没用">
                        <img src="https://img3.doubanio.com/f/zerkalo/68849027911140623cf338c9845893c4566db851/pics/down.png" />
                        <span id="r-useless_count-1569618">
                        </span>
                    </a>
                    <a href="https://music.douban.com/review/1569618/#comments" class="reply ">0回应</a>

                    <a href="javascript:;;" class="fold hidden">收起</a>
                </div>
            </div>
        </div>
    </div>

        
    
    <div data-cid="2720361">
        <div class="main review-item" id="2720361">

            
    
    <header class="main-hd">
        <a href="https://www.douban.com/people/seoyoungeun/" class="avator">
            <img width="24" height="24" src="https://img1.doubanio.com/icon/u4021144-7.jpg">
        </a>

        <a href="https://www.douban.com/people/seoyoungeun/" class="name">英恩</a>

            <span class="allstar50 main-title-rating" title="力荐"></span>

        <span content="2009-11-07" class="main-meta">2009-11-07 20:31:18</span>


    </header>


            <div class="main-bd">

                <h2><a href="https://music.douban.com/review/2720361/">I wait for you, I promise you</a></h2>

                <div id="review_2720361_short" class="review-short" data-rid="2720361">
                    <div class="short-content">

                        听了整整两个小时的LUCKY，是故意也好，是纵情也罢，间歇性的矫情又开始无法抑制地发作，听着这样的一首歌，很难不写点什么。  你不总是知道自己应该遇到什么样的人。是不是能遇到一个初见就觉双膝发软的人，是不是能遇到一个让你辗转反侧飞蛾扑火的人。 这些终是不重要的。 爱...

                        &nbsp;(<a href="javascript:;" id="toggle-2720361-copy" class="unfold" title="展开">展开</a>)
                    </div>
                </div>

                <div id="review_2720361_full" class="hidden">
                    <div id="review_2720361_full_content" class="full-content"></div>
                </div>

                <div class="action">
                    <a href="javascript:;" class="action-btn up" data-rid="2720361" title="有用">
                        <img src="https://img3.doubanio.com/f/zerkalo/536fd337139250b5fb3cf9e79cb65c6193f8b20b/pics/up.png" />
                        <span id="r-useful_count-2720361">
                                25
                        </span>
                    </a>
                    <a href="javascript:;" class="action-btn down" data-rid="2720361" title="没用">
                        <img src="https://img3.doubanio.com/f/zerkalo/68849027911140623cf338c9845893c4566db851/pics/down.png" />
                        <span id="r-useless_count-2720361">
                        </span>
                    </a>
                    <a href="https://music.douban.com/review/2720361/#comments" class="reply ">21回应</a>

                    <a href="javascript:;;" class="fold hidden">收起</a>
                </div>
            </div>
        </div>
    </div>

        
    
    <div data-cid="1426914">
        <div class="main review-item" id="1426914">

            
    
    <header class="main-hd">
        <a href="https://www.douban.com/people/edchan/" class="avator">
            <img width="24" height="24" src="https://img9.doubanio.com/icon/u1560240-16.jpg">
        </a>

        <a href="https://www.douban.com/people/edchan/" class="name">beglobetrotter</a>

            <span class="allstar50 main-title-rating" title="力荐"></span>

        <span content="2008-07-02" class="main-meta">2008-07-02 23:01:04</span>


    </header>


            <div class="main-bd">

                <h2><a href="https://music.douban.com/review/1426914/">Jason Mraz自画像素描</a></h2>

                <div id="review_1426914_short" class="review-short" data-rid="1426914">
                    <div class="short-content">

                        动手给自己ps了一张自画像的素描, 效果未如预期, 笔触总显生硬, 不自然. 不自然的东西让外人觉得矫情是小事,而让自己不愉快则是大事. 完全与初衷南辕北辙. 所以, 把脸裁了, 干脆. 其实, 也并非什么事都要大动干戈. 眼前就摆着一张似自画像素描的小品音乐专辑We Sing,We Dance,W...

                        &nbsp;(<a href="javascript:;" id="toggle-1426914-copy" class="unfold" title="展开">展开</a>)
                    </div>
                </div>

                <div id="review_1426914_full" class="hidden">
                    <div id="review_1426914_full_content" class="full-content"></div>
                </div>

                <div class="action">
                    <a href="javascript:;" class="action-btn up" data-rid="1426914" title="有用">
                        <img src="https://img3.doubanio.com/f/zerkalo/536fd337139250b5fb3cf9e79cb65c6193f8b20b/pics/up.png" />
                        <span id="r-useful_count-1426914">
                                4
                        </span>
                    </a>
                    <a href="javascript:;" class="action-btn down" data-rid="1426914" title="没用">
                        <img src="https://img3.doubanio.com/f/zerkalo/68849027911140623cf338c9845893c4566db851/pics/down.png" />
                        <span id="r-useless_count-1426914">
                        </span>
                    </a>
                    <a href="https://music.douban.com/review/1426914/#comments" class="reply ">1回应</a>

                    <a href="javascript:;;" class="fold hidden">收起</a>
                </div>
            </div>
        </div>
    </div>

        
    
    <div data-cid="3246264">
        <div class="main review-item" id="3246264">

            
    
    <header class="main-hd">
        <a href="https://www.douban.com/people/Louischen/" class="avator">
            <img width="24" height="24" src="https://img9.doubanio.com/icon/u39385813-16.jpg">
        </a>

        <a href="https://www.douban.com/people/Louischen/" class="name">飕</a>

            <span class="allstar50 main-title-rating" title="力荐"></span>

        <span content="2010-05-07" class="main-meta">2010-05-07 11:59:12</span>


    </header>


            <div class="main-bd">

                <h2><a href="https://music.douban.com/review/3246264/">力荐</a></h2>

                <div id="review_3246264_short" class="review-short" data-rid="3246264">
                    <div class="short-content">

                        没见过Jason Mraz的样貌 只在电台听过他的歌，轻快跳跃的歌 瞬间征服了车载音响及车里的人们 LUCKY I&#39;M YOURS TRY TRY 都是蛮不错的歌 

                        &nbsp;(<a href="javascript:;" id="toggle-3246264-copy" class="unfold" title="展开">展开</a>)
                    </div>
                </div>

                <div id="review_3246264_full" class="hidden">
                    <div id="review_3246264_full_content" class="full-content"></div>
                </div>

                <div class="action">
                    <a href="javascript:;" class="action-btn up" data-rid="3246264" title="有用">
                        <img src="https://img3.doubanio.com/f/zerkalo/536fd337139250b5fb3cf9e79cb65c6193f8b20b/pics/up.png" />
                        <span id="r-useful_count-3246264">
                                6
                        </span>
                    </a>
                    <a href="javascript:;" class="action-btn down" data-rid="3246264" title="没用">
                        <img src="https://img3.doubanio.com/f/zerkalo/68849027911140623cf338c9845893c4566db851/pics/down.png" />
                        <span id="r-useless_count-3246264">
                        </span>
                    </a>
                    <a href="https://music.douban.com/review/3246264/#comments" class="reply ">19回应</a>

                    <a href="javascript:;;" class="fold hidden">收起</a>
                </div>
            </div>
        </div>
    </div>

        
    
    <div data-cid="3665700">
        <div class="main review-item" id="3665700">

            
    
    <header class="main-hd">
        <a href="https://www.douban.com/people/willbrighter/" class="avator">
            <img width="24" height="24" src="https://img1.doubanio.com/icon/user_normal.jpg">
        </a>

        <a href="https://www.douban.com/people/willbrighter/" class="name">[已注销]</a>

            <span class="allstar50 main-title-rating" title="力荐"></span>

        <span content="2010-09-10" class="main-meta">2010-09-10 23:54:41</span>


    </header>


            <div class="main-bd">

                <h2><a href="https://music.douban.com/review/3665700/">我们  A   Beautiful   Mess</a></h2>

                <div id="review_3665700_short" class="review-short" data-rid="3665700">
                    <div class="short-content">

                        译得不好，请见谅。        You’ve got the best of both worlds   你在两个世界里都能自由自在 You’re the kind of girl who can take down a man,  你是那种可以让一个男人彻底颓废的女孩  And lift him back up again   也可以让他重新振作 You are strong but you’re ne...

                        &nbsp;(<a href="javascript:;" id="toggle-3665700-copy" class="unfold" title="展开">展开</a>)
                    </div>
                </div>

                <div id="review_3665700_full" class="hidden">
                    <div id="review_3665700_full_content" class="full-content"></div>
                </div>

                <div class="action">
                    <a href="javascript:;" class="action-btn up" data-rid="3665700" title="有用">
                        <img src="https://img3.doubanio.com/f/zerkalo/536fd337139250b5fb3cf9e79cb65c6193f8b20b/pics/up.png" />
                        <span id="r-useful_count-3665700">
                                5
                        </span>
                    </a>
                    <a href="javascript:;" class="action-btn down" data-rid="3665700" title="没用">
                        <img src="https://img3.doubanio.com/f/zerkalo/68849027911140623cf338c9845893c4566db851/pics/down.png" />
                        <span id="r-useless_count-3665700">
                        </span>
                    </a>
                    <a href="https://music.douban.com/review/3665700/#comments" class="reply ">1回应</a>

                    <a href="javascript:;;" class="fold hidden">收起</a>
                </div>
            </div>
        </div>
    </div>




    

    

    <script type="text/javascript" src="https://img3.doubanio.com/misc/mixed_static/1668fc2cf9285c4b.js"></script>
    <!-- COLLECTED CSS -->
</div>








                <p class="pl">
                    &gt;
                    <a href="reviews">
                        更多乐评
                            244篇
                    </a>
                </p>
    </section>
<!-- COLLECTED JS -->

        <br/>
            



    
    <h2>
        &#34;We Sing. We Dance. We Steal Things.&#34;的论坛
            &nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;
    </h2>

    <div id="db-discussion-section" class="indent">
        
    <table class="olt">
        <tr><td><td><td><td></tr>
                
                <tr>
                    <td class="pl">
                        <a href="https://music.douban.com/subject/2995812/discussion/615130693/" title="为什么这张专辑是豆瓣打分人数最多的专辑？">为什么这张专辑是豆瓣打分人数最多的专辑？</a></td><td class="pl">来自<a href="https://www.douban.com/people/154128275/">Chinese-Idiot</a>
                    </td>
                    <td class="pl">6 回应</td>
                    <td class="pl">2021-07-06 21:08:00</td>
                </tr>
                
                <tr>
                    <td class="pl">
                        <a href="https://music.douban.com/subject/2995812/discussion/614885138/" title="网易云音乐爱好分享群">网易云音乐爱好分享群</a></td><td class="pl">来自<a href="https://www.douban.com/people/108113484/">南面的风</a>
                    </td>
                    <td class="pl">34 回应</td>
                    <td class="pl">2020-12-03 20:23:14</td>
                </tr>
                
                <tr>
                    <td class="pl">
                        <a href="https://music.douban.com/subject/2995812/discussion/616616994/" title="Jason">Jason</a></td><td class="pl">来自<a href="https://www.douban.com/people/145810276/">Amour0920</a>
                    </td>
                    <td class="pl"></td>
                    <td class="pl">2020-04-03 20:24:28</td>
                </tr>
                
                <tr>
                    <td class="pl">
                        <a href="https://music.douban.com/subject/2995812/discussion/616557852/" title="如果一个普通酷狗玩家听他的第一个专辑会怎么样？">如果一个普通酷狗玩家听他的第一个专辑会怎么样？</a></td><td class="pl">来自<a href="https://www.douban.com/people/210855868/">溯渚 ོ</a>
                    </td>
                    <td class="pl"></td>
                    <td class="pl">2020-02-19 18:28:08</td>
                </tr>
                
                <tr>
                    <td class="pl">
                        <a href="https://music.douban.com/subject/2995812/discussion/616450761/" title="周杰伦的第二张真是牛逼到没朋友">周杰伦的第二张真是牛逼到没朋友</a></td><td class="pl">来自<a href="https://www.douban.com/people/205140488/">🕊</a>
                    </td>
                    <td class="pl"></td>
                    <td class="pl">2019-10-10 13:50:12</td>
                </tr>
    </table>

            <p class="pl" align="right">&gt; <a href="https://music.douban.com/subject/2995812/discussion/">浏览更多话题</a></p>
    </div>





    </div>

        </div>
        <div class="aside">
                




    <div id="dale_music_subject_top_right"></div>
<div id="dale_music_channel_right_mini"></div>
<div id="dale_music_subject_top_middle"></div>

        




<div id="db-tags-section" class="blank20">
    
    <h2>
        豆瓣成员常用的标签(共2129个)
            &nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;
    </h2>

    <div class="tags-body">
            <a class="music-tags" href="/tag/JasonMraz">JasonMraz</a>
            <a class="music-tags" href="/tag/民谣">民谣</a>
            <a class="music-tags" href="/tag/欧美">欧美</a>
            <a class="music-tags" href="/tag/folk">folk</a>
            <a class="music-tags" href="/tag/美国">美国</a>
            <a class="music-tags" href="/tag/Jason_Mraz">Jason_Mraz</a>
            <a class="music-tags" href="/tag/Pop">Pop</a>
            <a class="music-tags" href="/tag/2008">2008</a>
    </div>
</div>


        




    <h2>以下豆列推荐 · · · · · ·
            <span class="pl">(<a href="https://music.douban.com/subject/2995812/doulists">全部</a>)</span>
    </h2>
    <div id="db-doulist-section" class="indent">
        
    <ul class="bs">
        <li>
            <a href="https://www.douban.com/doulist/571347/" target="_blank">这些专辑，据说可以让我们听一辈子。</a>
                <span class="pl">(maze)</span>
        </li>
        <li>
            <a href="https://www.douban.com/doulist/136189/" target="_blank">08值得一品的专辑们</a>
                <span class="pl">(鸟先生在睡觉)</span>
        </li>
        <li>
            <a href="https://www.douban.com/doulist/177049/" target="_blank">｜五颗星经典系列｜音乐｜</a>
                <span class="pl">(蜜蜂)</span>
        </li>
        <li>
            <a href="https://www.douban.com/doulist/75700/" target="_blank">首首动听</a>
                <span class="pl">(～tulipj～)</span>
        </li>
        <li>
            <a href="https://www.douban.com/doulist/118078/" target="_blank">穿越时间，穿越地域，穿越种族，让我爱上你</a>
                <span class="pl">([已注销])</span>
        </li>
    </ul>

    </div>




        



<h2>谁听这张唱片?</h2>
<div class="indent" id="collector">
    
        
    
    
    
            
                <div class="ll">
                    <a href="https://www.douban.com/people/62059267/"><img src="https://img1.doubanio.com/icon/u62059267-7.jpg" class="pil" alt="阿尔贝张花"/></a>
                </div>
                <div style="padding-left:60px;">
                    <a href="https://www.douban.com/people/62059267/">阿尔贝张花</a>
                    <br/>
                    <div class="pl ll">今天凌晨听过</div>
                    <span class="allstar50" title="力荐"></span><br/>
                </div>
                <div class="clear"></div>
                <br/>
                <div class="ul" style="margin-bottom:12px;"></div>
                
            
                <div class="ll">
                    <a href="https://www.douban.com/people/156920429/"><img src="https://img3.doubanio.com/icon/u156920429-20.jpg" class="pil" alt="IZ*ONE 宁艺卓"/></a>
                </div>
                <div style="padding-left:60px;">
                    <a href="https://www.douban.com/people/156920429/">IZ*ONE 宁艺卓</a>
                    <br/>
                    <div class="pl ll">今天凌晨听过</div>
                    <br/>
                </div>
                <div class="clear"></div>
                <br/>
                <div class="ul" style="margin-bottom:12px;"></div>
                
            
                <div class="ll">
                    <a href="https://www.douban.com/people/139979417/"><img src="https://img9.doubanio.com/icon/u139979417-6.jpg" class="pil" alt="Isle"/></a>
                </div>
                <div style="padding-left:60px;">
                    <a href="https://www.douban.com/people/139979417/">Isle</a>
                    <br/>
                    <div class="pl ll">昨天听过</div>
                    <span class="allstar30" title="还行"></span><br/>
                        
                        <span class="pl">tags:JasonMraz Folk</span>
                </div>
                <div class="clear"></div>
                <br/>
                <div class="ul" style="margin-bottom:12px;"></div>
                
            
                <div class="ll">
                    <a href="https://www.douban.com/people/139956203/"><img src="https://img9.doubanio.com/icon/u139956203-14.jpg" class="pil" alt="杰特Jet"/></a>
                </div>
                <div style="padding-left:60px;">
                    <a href="https://www.douban.com/people/139956203/">杰特Jet</a>
                    <br/>
                    <div class="pl ll">昨天听过</div>
                    <span class="allstar20" title="较差"></span><br/>
                </div>
                <div class="clear"></div>
                <br/>
                <div class="ul" style="margin-bottom:12px;"></div>
                



         
            <p class="pl">&gt; 
                <a href="https://music.douban.com/subject/2995812/comments?status=N">23963人在听</a>
            </p>
         
            <p class="pl">&gt; 
                <a href="https://music.douban.com/subject/2995812/comments?status=P">127913人听过</a>
            </p>
         
            <p class="pl">&gt; 
                <a href="https://music.douban.com/subject/2995812/comments?status=F">33892人想听</a>
            </p>
</div>








    

<!-- douban ad begin -->
<div id="dale_music_subject_middle_right"></div>
<script type="text/javascript">
    (function (global) {
        if(!document.getElementsByClassName) {
            document.getElementsByClassName = function(className) {
                return this.querySelectorAll("." + className);
            };
            Element.prototype.getElementsByClassName = document.getElementsByClassName;

        }
        var articles = global.document.getElementsByClassName('article'),
            asides = global.document.getElementsByClassName('aside');

        if (articles.length > 0 && asides.length > 0 && articles[0].offsetHeight >= asides[0].offsetHeight) {
            (global.DoubanAdSlots = global.DoubanAdSlots || []).push('dale_music_subject_middle_right');
        }
    })(this);
</script>
<!-- douban ad end -->



        




        





<div class="indent">
    <ul class="bs">
        <li>
            
            <a href="https://music.douban.com/subject/2995812/offers">36张二手唱片欲转让</a>
            (0.00
                    至 500元以上)
        </li>
        <li>
                <a href='https://music.douban.com/subject/2995812/new_offer' class="rr ">&gt; 点这儿转让</a>

                有33892人想听,手里有一张闲着?
        </li>
    </ul>
</div>


    


<p class="pl">订阅关于We Sing. We Dance. We Steal Things.的评论: <br/><span class="feed">
    <a href="https://music.douban.com/feed/subject/2995812/reviews"> feed: rss 2.0</a></span></p>



        </div>
        <div class="extra">
            
    

<!-- douban ad begin -->
<div id="dale_music_subject_bottom_super_banner"></div>
<script type="text/javascript">
    (function (global) {
        var body = global.document.body,
            html = global.document.documentElement;

        var height = Math.max(body.scrollHeight, body.offsetHeight, html.clientHeight, html.scrollHeight, html.offsetHeight);
        if (height >= 2000) {
            (global.DoubanAdSlots = global.DoubanAdSlots || []).push('dale_music_subject_bottom_super_banner');
        }
    })(this);
</script>
<!-- douban ad end -->



        </div>
    </div>
</div>

        
<div id="footer">
    
<span id="icp" class="fleft gray-link">
    &copy; 2005－2021 douban.com, all rights reserved 北京豆网科技有限公司
</span>

<a href="https://www.douban.com/hnypt/variformcyst.py" style="display: none;"></a>

<span class="fright">
    <a href="https://www.douban.com/about">关于豆瓣</a>
    · <a href="https://www.douban.com/jobs">在豆瓣工作</a>
    · <a href="https://www.douban.com/about?topic=contactus">联系我们</a>
    · <a href="https://www.douban.com/about/legal">法律声明</a>
    
    · <a href="https://help.douban.com/?app=music" target="_blank">帮助中心</a>
    · <a href="https://douban.fm/app">手机音乐</a>
    · <a href="https://www.douban.com/partner/">豆瓣广告</a>
</span>

</div>

    </div>
    <script type="text/javascript" src="https://img3.doubanio.com/misc/mixed_static/2136b4e19768d1c2.js"></script><script type="text/javascript">
        Do = (typeof Do === 'undefined')? $ : Do;
        Do(function() {
            var reportDiv = "#link-report".concat("");
            $("body").delegate(reportDiv, 'mouseenter mouseleave', function(e){
                switch (e.type) {
                    case "mouseenter":
                        $(this).find(".report").css('visibility', 'visible');
                        break;
                    case "mouseleave":
                        $(this).find(".report").css('visibility', 'hidden');
                        break;
                }
            });
            
            $(reportDiv).delegate(".report a", 'click', function(e) {
                e.preventDefault();
                var auditUrl = "https://www.douban.com/misc/audit_report?url=",
                    opt = "";
                var obj = $(e.target).closest(reportDiv);
                var target_id = obj.length !== 0 ? obj.data("id") : undefined;
                var params = (opt && target_id) ? '?'.concat(opt, '=', target_id) : '';
                var url = "https://music.douban.com/subject/2995812/".concat(params);
                    var reasons = null;
                var is_group_member = false;

                generate_report_dialog({
                    report_url: url,
                    reasons: reasons,
                    group_id: '',
                    topic_id: String(target_id),
                    is_group_member: is_group_member
                });
            });

            $(reportDiv).append('<div class="report"><a rel="nofollow" href="javascript:void(0)">投诉</a></div>');
        });
    </script><script type="text/javascript" src="https://img3.doubanio.com/misc/mixed_static/278b01d62006bf2.js"></script>
    
    
    <script type="text/javascript">
        Do('dialog', function() {
            $('.collect_btn').each(function(){
                Douban.init_collect_btn(this);
            });
        });
    </script>

    








    
<script type="text/javascript">
    (function (global) {
        var newNode = global.document.createElement('script'),
            existingNode = global.document.getElementsByTagName('script')[0],
            adSource = '//erebor.douban.com/',
            userId = '197956574',
            browserId = 'Lqusl1jjSk8',
            criteria = '7:JasonMraz|7:民谣|7:欧美|7:folk|7:美国|7:Jason_Mraz|7:Pop|7:2008|7:Jason|7:Mraz|3:/subject/2995812/',
            preview = '',
            debug = false,
            adSlots = ['dale_music_subject_top_right', 'dale_music_channel_right_mini', 'dale_music_subject_top_middle'];

        global.DoubanAdRequest = {src: adSource, uid: userId, bid: browserId, crtr: criteria, prv: preview, debug: debug};
        global.DoubanAdSlots = (global.DoubanAdSlots || []).concat(adSlots);

        newNode.setAttribute('type', 'text/javascript');
        newNode.setAttribute('src', '//img1.doubanio.com/MnJwNGlleS9mL2FkanMvY2M1OGQyNTQ2N2I2YmQzOTlmNTliMGJiMjI4MWRhZTlkNTNjYTFkZC9hZC5yZWxlYXNlLmpz');
        newNode.setAttribute('async', true);
        existingNode.parentNode.insertBefore(newNode, existingNode);
    })(this);
</script>












    
    









<!-- Google Tag Manager -->
<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-5WP579" height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src='//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);})(window,document,'script','dataLayer','GTM-5WP579');</script>
<!-- End Google Tag Manager -->


<script type="text/javascript">
var _paq = _paq || [];
_paq.push(['trackPageView']);
_paq.push(['enableLinkTracking']);
(function() {
    var p=(('https:' == document.location.protocol) ? 'https' : 'http'), u=p+'://fundin.douban.com/';
    _paq.push(['setTrackerUrl', u+'piwik']);
    _paq.push(['setSiteId', '100001']);
    var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
    g.type='text/javascript';
    g.defer=true;
    g.async=true;
    g.src=p+'://img3.doubanio.com/dae/fundin/piwik.js';
    s.parentNode.insertBefore(g,s);
})();
</script>

<script type="text/javascript">
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-7019765-1']);
_gaq.push(['_setCampNameKey', 'dcn']);
_gaq.push(['_setCampSourceKey', 'dcs']);
_gaq.push(['_setCampMediumKey', 'dcm']);
_gaq.push(['_setCampTermKey', 'dct']);
_gaq.push(['_setCampContentKey', 'dcc']);
_gaq.push(['_addOrganic', 'baidu', 'word']);
_gaq.push(['_addOrganic', 'soso', 'w']);
_gaq.push(['_addOrganic', '3721', 'name']);
_gaq.push(['_addOrganic', 'youdao', 'q']);
_gaq.push(['_addOrganic', 'so.360.cn', 'q']);
_gaq.push(['_addOrganic', 'vnet', 'kw']);
_gaq.push(['_addOrganic', 'sogou', 'query']);
_gaq.push(['_addIgnoredOrganic', '豆瓣']);
_gaq.push(['_addIgnoredOrganic', 'douban']);
_gaq.push(['_addIgnoredOrganic', '豆瓣网']);
_gaq.push(['_addIgnoredOrganic', 'www.douban.com']);
_gaq.push(['_setDomainName', '.douban.com']);


    _gaq.push(['_setCustomVar', 1, 'responsive_view_mode', 'desktop', 3]);

_gaq.push(['_trackPageview']);
_gaq.push(['_trackPageLoadTime']);
    _gaq.push(['_setVar', '19795']);

window._ga_init = function() {
    var ga = document.createElement('script');
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    ga.setAttribute('async', 'true');
    document.documentElement.firstChild.appendChild(ga);
};
if (window.addEventListener) {
    window.addEventListener('load', _ga_init, false);
} else {
    window.attachEvent('onload', _ga_init);
}
</script>





    <!-- dae-web-music--default-59fcc66485-6fx2f-->

  <script>_SPLITTEST=''</script>
</body>

</html>




"""

publish_time = re.findall('<span class="pl">发行时间:</span>&nbsp;(.*?)<br />', str, re.S)[0].strip()
print(publish_time)

