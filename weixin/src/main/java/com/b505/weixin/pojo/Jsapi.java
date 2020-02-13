package com.b505.weixin.pojo;

/**
 * <p>b505信息科学研究所</p>
 * @Description 有关jsapi的四个屏障
 * @Creat date 2018-11-30 14:26
 * @author yulin
 */
public class Jsapi {

	private String appId; //应用ID 登录微信公众号管理平台可查询
	private String timestamp; //生成签名的时间戳
	private String nonceStr; //生成签名的随机字符串
	private String signature; //签名
	private String openId;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
}
