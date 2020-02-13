package com.b505.weixin.pojo;

import java.util.List;

/**
 * 通过网页授权查找用户的信息
 * @author yulin
 * @date 2018-4-4 21：46
 */
public class SNSUserInfo {
     public SNSUserInfo(String openId, String nickname, int sex, String country,
			String province, String city, String headImgUrl,
			List<String> privilegeList) {
		super();
		this.openId = openId;
		this.nickname = nickname;
		this.sex = sex;
		this.country = country;
		this.province = province;
		this.city = city;
		this.headImgUrl = headImgUrl;
		this.privilegeList = privilegeList;
	}
     public SNSUserInfo(){

     }
	//用户标识
	private String openId;
	//用户昵称
	private String nickname;
	//性别 （1是男性 2是女性 3是未知）
	private int sex;
	//国家
	private String country;
	//省份
	private String province;
	//城市
	private String city;
	//用户头像链接
	private String headImgUrl;
	//用户特权信息
	private List<String> privilegeList;
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public List<String> getPrivilegeList() {
		return privilegeList;
	}
	public void setPrivilegeList(List<String> privilegeList) {
		this.privilegeList = privilegeList;
	}


}
