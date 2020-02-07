package com.b505.weixin.message.req;


/**
 * 描述：图片消息
 * author：yulin
 * Create date 2020-2-7 20:05
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
