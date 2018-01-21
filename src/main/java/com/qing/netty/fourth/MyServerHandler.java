package com.qing.netty.fourth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2010-2017 Sanfangda team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>@description : com.qing.netty.fourth</li>
 * <li>@version     : 1.0</li>
 * <li>@creation    : 2018年01月21日</li>
 * <li>@author     : fanrenqing</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;

            String idleType = "";
            switch (event.state()) {
                case READER_IDLE:
                    idleType = "读空闲";
                    break;
                case WRITER_IDLE:
                    idleType = "写空闲";
                    break;
                case ALL_IDLE:
                    idleType = "读写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress()+" 超时事件："+idleType);
        }
    }
}
