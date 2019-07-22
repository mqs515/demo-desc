package com.test.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.demo.bo.PageInfo;
import com.test.demo.bo.Result;
import com.test.demo.commmon.RandomMsg;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestCommon {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void test01(){

        for (int i = 0; i <10; i++){
            RandomMsg randomMsg = new RandomMsg();
            String s = randomMsg.randomDesc();
            System.out.println(s);
        }

    }


    @Test
    public void test(){
        String json = "{\n" +
                "  \"data\": {\n" +
                "    \"pageInfo\": {\n" +
                "      \"isLastPage\": false,\n" +
                "      \"pageIndex\": 1,\n" +
                "      \"pageSize\": 2,\n" +
                "      \"total\": 339,\n" +
                "      \"pageTotal\": 170,\n" +
                "      \"lastPage\": false\n" +
                "    },\n" +
                "    \"result\": [\n" +
                "      {\n" +
                "        \"batchId\": 21,\n" +
                "        \"tag\": \"2019女装潮流前线\",\n" +
                "        \"catLeafName\": null,\n" +
                "        \"catName\": null,\n" +
                "        \"freeShipment\": null,\n" +
                "        \"hGoodRate\": null,\n" +
                "        \"hPayRate30\": null,\n" +
                "        \"iRfdRate\": null,\n" +
                "        \"isPrepay\": null,\n" +
                "        \"itemUrl\": \"https://detail.tmall.com/item.htm?id=569318273772\",\n" +
                "        \"materialLibType\": null,\n" +
                "        \"nick\": \"拉夏贝尔官方旗舰\",\n" +
                "        \"itemId\": null,\n" +
                "        \"imageUrl\": null,\n" +
                "        \"provcity\": \"浙江 杭州\",\n" +
                "        \"ratesum\": null,\n" +
                "        \"reservePrice\": \"469\",\n" +
                "        \"sellerId\": 2146742267,\n" +
                "        \"shopDsr\": null,\n" +
                "        \"smallImages\": null,\n" +
                "        \"title\": \"冷淡风裙子女夏季2019新款韩版修身显瘦收腰a字裙条纹短袖连衣裙\",\n" +
                "        \"userType\": 1,\n" +
                "        \"volume\": 18,\n" +
                "        \"zkFinalPrice\": \"299\",\n" +
                "        \"maxCommissionRate\": \"3.25\",\n" +
                "        \"couponStartTime\": \"2019-05-29\",\n" +
                "        \"couponEndTime\": \"2019-06-18\",\n" +
                "        \"couponInfo\": \"满100元减20元\",\n" +
                "        \"irfdRate\": null,\n" +
                "        \"hgoodRate\": null,\n" +
                "        \"hpayRate30\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"batchId\": 21,\n" +
                "        \"tag\": \"2019女装潮流前线\",\n" +
                "        \"catLeafName\": null,\n" +
                "        \"catName\": null,\n" +
                "        \"freeShipment\": null,\n" +
                "        \"hGoodRate\": null,\n" +
                "        \"hPayRate30\": null,\n" +
                "        \"iRfdRate\": null,\n" +
                "        \"isPrepay\": null,\n" +
                "        \"itemUrl\": \"https://detail.tmall.com/item.htm?id=586964942389\",\n" +
                "        \"materialLibType\": null,\n" +
                "        \"nick\": \"拉夏贝尔官方旗舰\",\n" +
                "        \"itemId\": null,\n" +
                "        \"imageUrl\": null,\n" +
                "        \"provcity\": \"浙江 杭州\",\n" +
                "        \"ratesum\": null,\n" +
                "        \"reservePrice\": \"369\",\n" +
                "        \"sellerId\": 2146742267,\n" +
                "        \"shopDsr\": null,\n" +
                "        \"smallImages\": null,\n" +
                "        \"title\": \"千鸟格短裙包臀A字裙2019夏季新款女装ins风高腰一片式绑带半身裙\",\n" +
                "        \"userType\": 1,\n" +
                "        \"volume\": 18,\n" +
                "        \"zkFinalPrice\": \"169\",\n" +
                "        \"maxCommissionRate\": \"3.25\",\n" +
                "        \"couponStartTime\": \"2019-05-29\",\n" +
                "        \"couponEndTime\": \"2019-06-18\",\n" +
                "        \"couponInfo\": \"满100元减20元\",\n" +
                "        \"irfdRate\": null,\n" +
                "        \"hgoodRate\": null,\n" +
                "        \"hpayRate30\": null\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"status\": 1000,\n" +
                "  \"message\": \"操作成功!\",\n" +
                "  \"serverTime\": 1559629784242\n" +
                "}";
        // 解析
        JSONObject jsonObject = JSON.parseObject(json);
        String resultsJson = jsonObject.getString("data");
        JSONObject resultJson = JSON.parseObject(resultsJson);

        /**
         * TODO 以下是使用的Maven依赖为1.2.8
         * TODO toJavaList方法没有啦
         * 解析成list
         */
        String resultArray = resultJson.getString("result");
        List<Result> results = JSONObject.parseArray(resultArray, Result.class);
        /**
         * TODO 以下是使用的Maven依赖为1.2.58
         */
//        List<Result> weatherData = resultArray.toJavaList(Result.class);
//        System.out.println(weatherData);
        // 解析分页数据【解析成对象】
        JSONObject pageInfo = (JSONObject) resultJson.get("pageInfo");
        PageInfo user = JSON.toJavaObject(pageInfo,PageInfo.class);

        System.out.println(user);
        System.out.println(results);
    }


    @Test
    public void testJson(){
        String json = "{\"pageInfo\":{\"isLastPage\":false,\"pageIndex\":0,\"pageSize\":2,\"total\":3131,\"pageTotal\":1566,\"lastPage\":false},\"result\":[{\"batchId\":15,\"tag\":\"2019新款女装\",\"catLeafName\":null,\"catName\":null,\"freeShipment\":null,\"hGoodRate\":null,\"hPayRate30\":null,\"iRfdRate\":null,\"isPrepay\":null,\"itemUrl\":\"https://item.taobao.com/item.htm?id=590583771100\",\"materialLibType\":null,\"nick\":\"RUI WANG 独立设计\",\"itemId\":null,\"imageUrl\":null,\"provcity\":\"湖北 武汉\",\"ratesum\":null,\"reservePrice\":\"298\",\"sellerId\":372014325,\"shopDsr\":null,\"smallImages\":null,\"title\":\"RUI WANG 春季新款复古网红西装女竖条纹宽松休闲慵懒显瘦短外套\",\"userType\":0,\"volume\":0,\"zkFinalPrice\":\"298\",\"maxCommissionRate\":\"3.25\",\"couponStartTime\":\"\",\"couponEndTime\":\"\",\"couponInfo\":\"\",\"hpayRate30\":null,\"irfdRate\":null,\"hgoodRate\":null},{\"batchId\":15,\"tag\":\"2019新款女装\",\"catLeafName\":null,\"catName\":null,\"freeShipment\":null,\"hGoodRate\":null,\"hPayRate30\":null,\"iRfdRate\":null,\"isPrepay\":null,\"itemUrl\":\"https://item.taobao.com/item.htm?id=591239068722\",\"materialLibType\":null,\"nick\":\"RUI WANG 独立设计\",\"itemId\":null,\"imageUrl\":null,\"provcity\":\"湖北 武汉\",\"ratesum\":null,\"reservePrice\":\"188\",\"sellerId\":372014325,\"shopDsr\":null,\"smallImages\":null,\"title\":\"RUI WANG 豹纹吊带连衣裙2019性感开叉港味内搭女神范裙子夏网红\",\"userType\":0,\"volume\":3,\"zkFinalPrice\":\"188\",\"maxCommissionRate\":\"3.25\",\"couponStartTime\":\"\",\"couponEndTime\":\"\",\"couponInfo\":\"\",\"hpayRate30\":null,\"irfdRate\":null,\"hgoodRate\":null}]}";
        JSONObject jsonObject = JSON.parseObject(json);
        // 解析商品数据【解析成list】
        String resultArray = jsonObject.getString("result");
        List<Result> results = JSONObject.parseArray(resultArray, Result.class);
        // 解析分页数据【解析成对象】
        JSONObject pageInfo = (JSONObject) jsonObject.get("pageInfo");
        PageInfo page = JSON.toJavaObject(pageInfo,PageInfo.class);

        System.out.println(results);
        System.out.println(page);
    }
}
