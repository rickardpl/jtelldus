package se.stromnet.jtelldus.utils;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Created by ripl1 on 2016-01-15.
 */
public class ByteBufferUtil {
    private static final byte SPACE = ' ';
    private static final byte ZERO = ' ';


    private static final Charset US_ASCII = Charset.forName("US-ASCII");

    public static String byteArrayToHex(ByteBuffer a) {
        int limit = a.limit();
        int pos = a.position();
        if (a.limit() == a.capacity()) {
            a.flip();
        }

        StringBuilder sb = new StringBuilder(a.limit() * 2);
        for (int i=a.position() ; i < a.limit() ; i++) {
            byte b = a.get(i);
            if (b < 32) {
                sb.append(String.format("0x%02x"+((i+1 < a.limit())?",":""), b & 0xff));
            } else {
                sb.append(String.format("\'%c\'"+((i+1 < a.limit())?",":""), b));
            }
        }

        a.limit(limit);
        a.position(pos);
        return sb.toString();
    }
}

