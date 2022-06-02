package com.util;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/5/1
 */
public class UtilTest {

    @Test
    public void demo1(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("pan","213");
        map.put("qing","xu");


        Object generate = PropertyUtils.generate(map);
        System.out.println(generate);
    }

    @Test
    public void demo2(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("100");
        strings.add("323");
        List<Integer> integers = Arrays.asList(strings.stream()
                .toArray(Integer[]::new));
        System.out.println(integers);

    }


    @Test
    public void demo3(){
        String rule = "^[\\\\u4e00-\\\\u9fa5]{0,}$";
        System.out.println(Pattern.matches(rule,"潘"));
    }


    @Test
    public void demo4(){
        String data = "['',['aaa','bbb'],'aaa',['aaaa','bbbb','cccc']]";
        List<String> strings = stringToList(data);
        System.out.println(strings);

    }

    public List<String>  stringToList(String data){
        if ( StringUtils.isBlank(data)){
            return null;
        }
        // 去除多余的 [] 和 '
        String[] split = data.replace("[", "")
                .replace("]", "")
                .replace("'", "")
                .split(",");
        if (split.length == 1){
            return Arrays.asList(split[0]);
        }

        HashSet<String> set = new HashSet<>();
        for (String each : split) {
            if( !StringUtils.isBlank(each)){
                set.add(each);
            }
        }

        return set.stream().collect(Collectors.toList());
    }



    @Test
    public void demo5(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        System.out.println(objectObjectHashMap.get(null));
    }


    @Test
    public void demo6(){
        LinkedList<String> strings = new LinkedList<>();
        strings.add("a");
        strings.add("b");
        strings.add(" ");
        strings.add("d");
        strings.add("as");
        strings.forEach(each->{
            if (StringUtils.isBlank(each)){
                strings.remove(each);
            }
        });

    }

    @Test
    public void demo7(){
        System.out.println(LocalDateTime.now());
    }


    @Test
    public void demo8(){
        String value = "13673500122";
        String rule = "(^|[^\\d])((13[0-9])|(14(0|[5-7]|9))|(15([0-3]|[5-9]))|(16(2|[5-7]))|(17[0-8])|(18[0-9])|(19([0-3]|[5-9])))\\d{8}($|[^\\d])";
        System.out.println(Pattern.matches(rule, value));
    }


    @Test
    public void demo9(){
        String rule = "^[A-Za-z0-9\\-\\.\\,]+$";
        System.out.println(Pattern.matches(rule,"www.baidu.com,  ajsda,asnkdn.asjfio"));
    }


    @Test
    public void demo10(){
        HashSet<String> importAppSysNameSet = new HashSet<>();
        importAppSysNameSet.add("pan");
        System.out.println(importAppSysNameSet.contains("aaa"));
    }

    @Test
    public void demo11() throws ParseException {
        String dt="Thu May 28 18:23:17 CST 2015";
        SimpleDateFormat sdf_right = new SimpleDateFormat("EEE dd-MMM-yyyy HH:mm",Locale.ENGLISH);
        System.out.println(sdf_right.parse(dt));
    }

    @Test
    public void demo12() throws ParseException {
        String dt="Thu May 28 18:23:17 CST 2015";
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }

    @Test
    public void demo13(){
        Date date = new Date("Fri May 13 00:00:00 CST 2022");
        System.out.println(date);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println(format);
    }

    @Test
    public void demo14(){
        System.out.println("aaaa".contains("a"));
    }

    @Test
    public void demo15(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getDayOfWeek().getValue());
        //System.out.println(now.getHour());
        System.out.println(DayOfWeek.SUNDAY.getValue());
    }

    @Test
    public void demo16(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("pan");
        strings.add("pan");
        strings.add("pan");
        strings.add("pan");
        System.out.println(strings.toString());
    }

    @Test
    public void demo17(){
        String s = "panqingxu";
        System.out.println(s.subSequence(0,100));
    }

    @Test
    public void demo18(){
        System.out.println(Integer.valueOf(23/6));
    }






















}
