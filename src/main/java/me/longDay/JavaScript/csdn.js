// ==UserScript==
// @name         CSDN 体验优化
// @namespace    longday
// @version      0.2
// @description  优化CSDN的非登录状态下的文章体验
// @author       longday
// @match        *://blog.csdn.net/*/article/details/*
// @match        *://bbs.csdn.net/topics/*
// @match        *://www.zhihu.com/question/*
// @grant        none
// @icon         none
// @run-at       document-end
// ==/UserScript==

(function () {
    'use strict';
    //code start

    //执行次数
    let curCnt = 0;
    //最大执行次数
    let maxCnt = 666;

    //CSDN DOM常量 均为CSS选择器
    //存放多个CSS选择字符串的数组
    let hideCssList = [];
    let csdnWebUrl = "blog.csdn.net";
    //弹出框: 继续浏览器浏览或是跳转APP浏览
    const gotoAppOrBrowser = "weixin-shadowbox wap-shadowbox";
    hideCssList.push(gotoAppOrBrowser);
    //浮动的跳转APP按钮
    const gotoAppOrBrowserFlow = "feed-Sign-span";
    hideCssList.push(gotoAppOrBrowserFlow);
    //点击阅读全文按钮及其遮挡背景
    const clickToReadAllBtn = "readall_box";
    hideCssList.push(clickToReadAllBtn);
    //删除该DOM的style以展开全文
    const expandArticle = "article_content";
    //关注展开按钮
    hideCssList.push("hide-article-box");
    //前往APP按钮
    hideCssList.push("btn_open_app_prompt_div");


    // 知乎DOM常量 均为CSS选择器
    let zhWebUrl = "www.zhihu.com";
    let zhHideCssList = [];
    //展开文章按钮
    zhHideCssList.push("Button ContentItem-rightButton ContentItem-expandButton Button--plain")

    // 展开文章，删除该DOM的style和class以展开全文
    let zhExpandArticle = "RichContent-inner RichContent-inner--collapsed"


    //平台判断
    let isMobile = /Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent);
    let webHostUrl = location.hostname
    if (isMobile) {
        let timerId = setInterval(() => {
            curCnt++;
            //CSDN
            if(webHostUrl === csdnWebUrl){
                printMsg("CSDN优化检测...")
                //隐藏按钮
                if (hideCssList.length > 0) {
                    hideElements(hideCssList)
                }
                //展开文章
                expandHideArticle(expandArticle)
            }
            //知乎
            else if (webHostUrl === zhWebUrl){
                printMsg("知乎优化检测...")
                //隐藏按钮
                hideElements(zhHideCssList);
                //展开文章
                expandHideArticle(zhExpandArticle);
            }

        }, 2000)
        //最大执行次数 默认666次 大概20分钟内都会检测执行
        if (curCnt > maxCnt) {
            clearInterval(timerId)
        }
    } else {
        //这里可以写针对PC端的代码
        printMsg("PC端暂时未支持");
    }

    function printMsg(msg) {
        console.log(msg);
    }

    function hideOneElement(cssChoice) {
        let element = document.getElementsByClassName(cssChoice)[0];
        if (element && element instanceof Element) {
            element.remove();
        }
    }

    function hideElements(cssList) {
        for (let i = 0; i < cssList.length; i++) {
            hideOneElement(cssList[i]);
        }
    }

    function expandHideArticle(cssChoice) {
        let element = document.getElementsByClassName(cssChoice)[0];
        if (element && element instanceof Element) {
            element.removeAttribute("style");
            element.removeAttribute("class")
        }
    }

    function expandHideArticles(cssList){
        for (let i = 0; i < cssList.length; i++) {
            expandHideArticle(cssList[i]);
        }
    }
    //code end
})();