package org.singledog.dogmall.core.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * MD5 util
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
public class MD5Util {

    public static String encrypt(String content, Charset charset) {
        if (content == null) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(content.getBytes(charset));
    }

    public static String encrypt(String content) {
        return encrypt(content, StandardCharsets.UTF_8);
    }
}
