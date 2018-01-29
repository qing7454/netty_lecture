package com.qing.netty.six;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2010-2017 Sanfangda team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>@description : com.qing.netty.six</li>
 * <li>@version     : 1.0</li>
 * <li>@creation    : 2018年01月28日</li>
 * <li>@author     : fanrenqing</li>
 * </ul>
 * 模拟数据包
 * <p>****************************************************************************</p>
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.MyMessage myMessage = null;
        int ret = new Random().nextInt(3);//一定要setDataType，否则会报错
        if (ret == 0) {
            MyDataInfo.Person person = MyDataInfo.Person.newBuilder().
                    setName("范任清").setAge(22).setAddress("广州").build();
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersonType).setPerson(person).build();
        } else if (1 == ret) {
            MyDataInfo.Dog dog = MyDataInfo.Dog.newBuilder().
                    setName("单身狗").setAge(2).build();
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType).setDog(dog).build();
        } else {
            MyDataInfo.Cat cat = MyDataInfo.Cat.newBuilder().
                    setName("天猫").setCity("杭州").build();
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.CatType).setCat(cat).build();
        }

        ctx.channel().writeAndFlush(myMessage);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("close");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("远程主机强迫关闭了一个现有的连接。");
        System.out.println(cause);
        ctx.close();
    }
}
