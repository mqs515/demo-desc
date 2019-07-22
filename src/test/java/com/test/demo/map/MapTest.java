package com.test.demo.map;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.test.demo.domain.People;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.SocketUtils;
import org.springframework.util.StringUtils;
import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;
import sun.security.util.AuthResources_it;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class MapTest {

    private MultiValueMap<String, String> map;

    @Before
    public void setUp(){
        map = new LinkedMultiValueMap();
    }

    /**
     * MultiValueMap
     */
    @Test
    public void testMultiValueMap(){
        map.add("key", "value1");
        map.add("key", "value2");
        System.out.println(map.get("key"));
        List<String> keyList = map.get("key");
        System.out.println(keyList);
    }

    /**
     * 截取字符串
     */
    @Test
    public void test(){
        String str = "https://item.taobao.com/item.htm?spm=a219t.7900221/10.1998910419.d30ccd691.17d575a5u82Z8v&id=588564589741";
        String[] split = str.split("id=");
        String s = split[1];
        System.out.println(s);
    }


    private static final Pattern TB_ITEM_ID = Pattern.compile("(.+)?id=(.+)");

    /**
     * 使用正则截取字符串
     */
    @Test
    public void resolveTbItemId(){
        String str = "https://item.taobao.com/item.htm?spm=a219t.7900221/10.1998910419.d30ccd691.17d575a5u82Z8v&id=588564589741";
        if (StringUtils.isEmpty(str)){
            System.out.println("========" + "参数为空");
        }
        Matcher matcher = TB_ITEM_ID.matcher(str);
        if (matcher.find()) {
            String tbItem = matcher.group(2);
            System.out.println(tbItem);
        }
    }


    /**
     * 拼接字符串
     */
    private static final String LOVE_YOU = "姓名：{name}\n家庭住址：{address}\n爱好：{hobby}";
    @Test
    public void testReplace(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "张三");
        map.put("address", "杭州市西湖区");
        map.put("hobby", "足球、羽毛球、篮球");
        String str = LOVE_YOU;
        for (String key : map.keySet()) {
            str = str.replace("{" + key + "}", map.get(key));
        }
        System.out.println(str);
    }

    /**
     * 拼接xml文件
     * <tbk_item_get_response>
     *     <results>
     *         <n_tbk_item>
     *         </n_tbk_item>
     *     </results>
     *     <total_results>100</total_results>
     * </tbk_item_get_response>
     */
    @Test
    public void testStr(){
        StringBuilder sb = new StringBuilder();
        sb.append("<tbk_item_get_response>\n");
        sb.append("\t<results>\n");
        sb.append("\t\t<n_tbk_item>\n");
        sb.append("\t\t</n_tbk_item>\n");
        sb.append("\t<results>\n");
        sb.append("\t<total_results>");
        sb.append(100);
        sb.append("</total_results>\n");
        sb.append("</tbk_item_get_response>");

        System.out.println(sb.toString());
    }

    @Test
    public void testFilter(){
        ArrayList<People> list = new ArrayList<>();

        People people1 = new People();
        people1.setName("qqq");
        people1.setAge(11);
        people1.setAddress("河南");
        list.add(people1);

        People people2 = new People();
        people2.setName("www");
        people2.setAge(12);
        people2.setAddress("河北");
        list.add(people2);

        People people3 = new People();
        people3.setName("eee");
        people3.setAge(13);
        people3.setAddress("河西");
        list.add(people3);

        People people4 = new People();
        people4.setName(null);
        people4.setAge(13);
        people4.setAddress("河shan");
        list.add(people4);

        ArrayList<String> objects = new ArrayList<>();
        for (People people : list) {
            if (people.getName() != null){
                objects.add(people.getName());
            }
        }
        System.out.println(objects);

        List<String> collect = list.stream().filter(a -> a.getName() != null).map(people -> people.getName()).collect(Collectors.toList());
        System.out.println(collect);

        Map<String, People> collect1 = list.stream().collect(Collectors.toMap(People::getName, a -> a));
        for (String s : collect1.keySet()) {
            System.out.println(s  + "==========" + collect1.get(s));
        }

        People people = collect1.get(5);
        System.out.println(people);

    }


    @Test
    public void test11(){
        try {
            // 时间戳转日期
            Date date = new Date(1560422580);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(date);
            Date parse = sdf.parse(format);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long ss = System.currentTimeMillis();
        System.out.println(ss);
        System.out.println(ss/1000);
        Date date = new Date(ss);
        Date date1 = new Date(ss / 1000*1000);
        System.out.println(date);
        System.out.println(date1);
    }


    @Test
    public void test12(){
        int top = 2;
        switch (top){
            case 1:
            case 2:
            case 3:
                System.out.println(top);
                break;
        }
    }
    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    private static Calendar getCalendar(Calendar c) {
        if (c == null) {
            c = getCalendar();
        }
        return c;
    }

    public static Calendar before(Calendar c, long offset) {
        Calendar calendar = getCalendar(c);
        calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
        return calendar;
    }

    public static Calendar after(Calendar c, long offset) {
        Calendar calendar = getCalendar(c);
        calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
        return calendar;
    }

    /**
     * 得到指定或者当前时间前n天的Calendar
     * @param c
     * @param n
     * @return
     */
    public static Calendar beforeDay(Calendar c, int n) {
        // 偏移量，给定n天的毫秒数
        long offset = (long) n * 24 * 60 * 60 * 1000;
        return before(c, offset);
    }

    /**
     * 得到指定或者当前时间前n天的Calendar
     * @param c
     * @param n
     * @return
     */
    public static Calendar afterDay(Calendar c, int n) {
        // 偏移量，给定n天的毫秒数
        long offset = (long) n * 24 * 60 * 60 * 1000;
        return before(c, offset);
    }

    @Test
    public void test13(){
        Date time1 = beforeDay(Calendar.getInstance(), 7).getTime();
        long time = beforeDay(Calendar.getInstance(), 7).getTimeInMillis();
        System.out.println(time);
        System.out.println(time1);
        System.out.println("==============================");
        Date time3 = afterDay(Calendar.getInstance(), 3).getTime();
        long time4 = afterDay(Calendar.getInstance(), 3).getTimeInMillis();
        System.out.println(time3);
        System.out.println(time4 );
    }


}
