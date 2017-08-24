package com.origin.sc.frame;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @description 拼接参数
 * @antuor Yoke
 * @date 2017/8/24 10:15
 */

public class FormatUtils {

    public static String formatGetParams(String url, Map<String, Object> params) {
        // StringBuilder是用来组拼请求地址和参数
        try {
            StringBuilder sb = new StringBuilder();
            if (params == null) {
                return url;
            }
            sb.append(url).append("?");
            if (params != null && params.size() != 0) {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    // 如果请求参数中有中文，需要进行URLEncoder编码 utf8
                    sb.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(), "utf-8"));
                    sb.append("&");
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
