// ==UserScript==
// @name         CSDN 体验优化 Pro
// @namespace    longday
// @version      0.3
// @description  优化CSDN的非登录状态下的文章体验
// @author       longday
// @match        *://blog.csdn.net/*/article/details/*
// @match        *://bbs.csdn.net/topics/*
// @match        *://www.zhihu.com/*
// @match        *://www.jianshu.com/p/*
// @icon         none
// @run-at       document-end
// ==/UserScript==

(function () {
    'use strict';
    //code start

    const rules = [
        {
            // 知乎 - 移动端页面
            reg: /^http(s)?:\/\/(www\.)?zhihu\.com\/(question\/\d+|tardis\/\w+)/i,
            remove: ['.RichContent--unescapable.is-collapsed .ContentItem-rightButton'],
            content: [
                '.Body--Mobile .RichContent.is-collapsed .RichContent-inner',
                '.RichContent--unescapable.is-collapsed .RichContent-inner',
                '.App',
            ],
            style: `
                .RichContent.is-collapsed {
                  cursor: auto !important;
                }
                .RichContent--unescapable.is-collapsed .RichContent-inner {
                  -webkit-mask-image: none !important;
                  mask-image: none !important;
                }`,
        },
        {
            // 简书移动版
            reg: /^http(s)?:\/\/(www+\.)?jianshu\.com\/p\/\w+/i,
                remove: ['#note-show .content .show-content-free .collapse-tips','.download-app-guidance','.comment-open-app-btn-wrap','.footer-wrap'],
            content: ['#note-show .content .show-content-free .collapse-free-content'],
        },
        {
            // CSDN 博客 - PC & 移动端页面
            reg: /^http(s)?:\/\/blog\.csdn\.net\/[^/]+\/article\/details\/\d+/i,
               remove: [ '.readall_box', '.weixin-shadowbox','.btn_open_app_prompt_div'],
            content: ['#article_content', '#article .article_content'],
        },
        {
            // CSDN 论坛 - PC & 移动端页面
            reg: /^http(s)?:\/\/bbs\.csdn\.net\/topics\/\d+/i,
            remove: ['.hide_topic_box', '.readall_wrap', '#writeGuide'],
            content: ['.container-box .bbs_detail_wrap', '.first_show'],
        },
    ]


    for (const rule of rules) {
        console.log("ld")
        console.log("ld"+window.location.href)
        console.log("ld:b:"+rule.reg.test(window.location.href))
        if (rule.reg.test(window.location.href)) {
            const removeEls = rule.remove;
            const contentEls = rule.content;
            gM_addStyle(
                (rule.remove ? removeEls + `{display: none !important;}\n`: ``) +
                (rule.content ? contentEls + ` { height: auto !important; max-height: none !important; }\n` : ``) +
                (rule.style ? rule.style : ``)
            );
            console.log("ld:func")
            if (typeof rule.script === 'function') {
                console.log("ld:function")
                window.addEventListener('load', rule.script);
            }
            break;
        }
    }

    function gM_addStyle(aCss){
        'use strict';
        let head = document.getElementsByTagName('head')[0];
        if (head) {
            let style = document.createElement('style');
            style.setAttribute('type', 'text/css');
            style.textContent = aCss;
            head.appendChild(style);
            return style;
        }
        return null;
    }
    //code end
})();