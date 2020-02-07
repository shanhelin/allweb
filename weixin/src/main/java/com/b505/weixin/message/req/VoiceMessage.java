package com.b505.weixin.message.req;

/**
 * 描述：音频消息
 * author：yulin
 * Create date 2020-2-7 20:05
 */
public class VoiceMessage extends BaseMessage
{ // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
