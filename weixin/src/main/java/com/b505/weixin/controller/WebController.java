package com.b505.weixin.controller;

import com.b505.weixin.pojo.SNSUserInfo;
import com.b505.weixin.pojo.WeixinOauth2Token;
import com.b505.weixin.util.AdvancedUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class WebController {

    /**
     * 描述：跳转界面
     * author：yulin
     * Createa date 2020-2-12 11:25
     */
    @RequestMapping("text")
    public String text(){
        return "text";
    }

    /**
     * 描述：获取微信用户的网页授权
     * 接口地址：https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx41c9f671d9c6355f&redirect_uri=http%3a%2f%2f39.105.65.69%2ftext1&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect
     * author：yulin
     * Create date 2020-2-21 12:22
     */
    @RequestMapping("/text1")
    public String text1(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("gb2312");
        response.setCharacterEncoding("gb2312");

        //用户同意授权
        String code =request.getParameter("code");

        if(!"authdeny".equals(code)){


            WeixinOauth2Token weixinOauth2Token= AdvancedUtil.getOauth2AccessToken("wx41c9f671d9c6355f","bad1b7703b0195a7ba94001cc455d1e7",code);
            //网页授权接口访问凭证
            String accessToken=weixinOauth2Token.getAccessToken();
            //用户标识
            String openId=weixinOauth2Token.getOpenId();
            //获取用户信息
            SNSUserInfo snsUserInfo=AdvancedUtil.getSNSUserInfo(accessToken,openId);

            System.out.println("--------------------------------------------用户的城市在"+snsUserInfo.getCity());


            return "text";
        }


        return "error1";

    }

}
