package com.example.demo.utils;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @Author: joy
 * @Date: 2019/7/16 10:22
 */
@Component
public class CommonUtils {
    /**
     * 在列表map中的key转成驼峰
     *
     * @param list
     * @return
     */
    public static List<Map<String, Object>> listToHump(List<Map<String, Object>> list) {
        List<Map<String, Object>> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> newMap = new HashMap<>();
            Iterator<Map.Entry<String, Object>> iterator = list.get(i).entrySet().iterator();
            Map.Entry<String, Object> entry;
            while (iterator.hasNext()) {
                entry = iterator.next();
                // 往newMap中放入新的Entry
                newMap.put(lineToHump(entry.getKey()), entry.getValue());
                // 删除老的Entry
                iterator.remove();
            }

            list2.add(newMap);
        }

        return list2;
    }

    /**
     * 下划线转驼峰
     *
     * @param str 需要转换的字符串
     * @return 转换完成的字符串
     */
    public static String lineToHump(String str) {
        // 正则
        Pattern linePattern = compile("_(\\w)");
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
