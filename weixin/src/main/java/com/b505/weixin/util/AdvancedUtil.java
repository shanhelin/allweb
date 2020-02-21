package com.b505.weixin.util;

import com.b505.weixin.pojo.SNSUserInfo;
import com.b505.weixin.pojo.WeixinOauth2Token;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class AdvancedUtil {

    public static Logger logger = LoggerFactory.getLogger(AdvancedUtil.class);


    /**
     * 获取网页授权凭证
     * @param appId 公众号的唯一标识
     * @param appSecret 公众号的密匙
     * @param code
     * @return WeixinAouth2Token
     *
     */
    public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code){

        WeixinOauth2Token wat=null;
        //拼接请求信息
        String requestUrl ="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

        requestUrl=requestUrl.replace("APPID",appId);
        requestUrl=requestUrl.replace("SECRET",appSecret);
        requestUrl=requestUrl.replace("CODE",code);
        //获取网页授权的凭证
        JSONObject jsonObject =JsapiTicketUtil.httpRequest(requestUrl,"GET",null);

        if(null!=jsonObject){

            try {
                wat=new WeixinOauth2Token();
                wat.setAccessToken(jsonObject.getString("access_token"));
                wat.setExpiresIn(jsonObject.getInt("expires_in"));
                wat.setRefreshToken(jsonObject.getString("refresh_token"));
                wat.setOpenId(jsonObject.getString("openid"));
                wat.setScope(jsonObject.getString("scope"));

            } catch (Exception e) {
                // TODO: handle exception
                wat=null;
                int errorCode=jsonObject.getInt("errcode");
                String errorMsg=jsonObject.getString("errmsg");
                logger.error("获取网络授权失败  errcode:{} errmsg:{}",errorCode,errorMsg);

            }

        }
        return wat;
    }

    /**
     * 通过网页授权获取用户的信息
     *
     * @param accessToken 网页授权接口调用凭证
     * @param openId 用户标识
     *
     */
    @SuppressWarnings({"deprecation","unchecked"})
    public static SNSUserInfo getSNSUserInfo(String accessToken, String openId){

        SNSUserInfo snsuserInfo=null;
        //拼接请求地址
        String requestUrl="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
        requestUrl =requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        //通过网页授权获取用户的信息
        JSONObject jsonObject=JsapiTicketUtil.httpRequest(requestUrl, "GET", null);
        if(null!=jsonObject){
            try {
                snsuserInfo=new SNSUserInfo();
                //用户标识
                snsuserInfo.setOpenId(jsonObject.getString("openid"));
                //昵称
                snsuserInfo.setNickname(jsonObject.getString("nickname"));
                //性别（1是男性 2是女性 0是未知）
                snsuserInfo.setSex(jsonObject.getInt("sex"));
                //用户所在的国家
                snsuserInfo.setCountry(jsonObject.getString("country"));
                //用户所在的省份
                snsuserInfo.setProvince(jsonObject.getString("province"));
                //用户所在的城市
                snsuserInfo.setCity(jsonObject.getString("city"));
                //用户头像
                snsuserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
                //用户特权信息
                snsuserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class) );
                System.out.println("-----------------------------------------openid="+snsuserInfo.getOpenId());

            } catch (Exception e) {
                // TODO: handle exception
                snsuserInfo=null;
                int errorCode=jsonObject.getInt("errcode");
                String errorMsg=jsonObject.getString("errmsg");
                logger.error("获取用户信息失败  errcode:{} errmsg:{}",errorCode,errorMsg);
            }
        }

        return snsuserInfo;
    }



}
