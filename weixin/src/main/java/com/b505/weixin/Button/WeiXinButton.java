package com.b505.weixin.Button;

import com.b505.weixin.pojo.Button;
import com.b505.weixin.pojo.CommonButton;
import com.b505.weixin.pojo.ComplexButton;
import com.b505.weixin.pojo.Menu;
import com.b505.weixin.util.JsapiTicketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：自定义button
 * author:yulin
 * Create date 2020-2-7 20:29
 */
public class WeiXinButton {
    private static Logger log = LoggerFactory.getLogger(WeiXinButton.class);
    //这里的代码已经不需要了


    public static void main(String[] args){

        // 调用接口获取access_token
        String accesstoken= JsapiTicketUtil.getAccessToken();

        System.out.println( 1 );
        if (null != accesstoken) {
            // 调用接口创建菜单
            int result = JsapiTicketUtil.createMenu( getMenu(), accesstoken );

            // 判断菜单创建结果
            if (0 == result) {
              System.out.println( "111" );
                log.info( "菜单建立成功" );
            }else {
                log.info( "菜单建立失败" + result );
            }
        }
    }


    public static Menu getMenu() {

        CommonButton btn11 = new CommonButton();
        btn11.setName("左面菜单");
        btn11.setType("click");
        btn11.setKey("11");

        CommonButton btn21=new CommonButton();
        btn21.setName("中间菜单");
        btn21.setType("click");
        btn21.setKey("21");

        CommonButton btn31=new CommonButton();
        btn31.setName("右面子菜单");
        btn31.setType("view");
        btn31.setUrl("http://hyxw.work/servicefunctiontwo");


        ComplexButton mainBtn2=new ComplexButton();
        mainBtn2.setName("右面菜单");
        mainBtn2.setSub_button(new CommonButton[]{btn31});

        Menu menu = new Menu();
        menu.setButton(new Button[] {btn11, btn21,mainBtn2 });

        return menu;
    }}