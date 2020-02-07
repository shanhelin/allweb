package com.b505.weixin.message.req;


/**
 * 描述：文本消息
 * author：yulin
 * Create date 2020-2-7 20:05
 */
public class TextMessage extends BaseMessage
{
	 // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
