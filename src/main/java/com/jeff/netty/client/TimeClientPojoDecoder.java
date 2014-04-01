/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeff.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 *
 * @author winnie
 */
public class TimeClientPojoDecoder extends ByteToMessageDecoder{
    
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        out.add(new UnixTime(in.readInt()));
    }
    
}
