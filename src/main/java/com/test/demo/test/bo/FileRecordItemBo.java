package com.test.demo.test.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：miaoqs
 * @date ：2019-06-04 10:25
 * @description：文件上传商品
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FileRecordItemBo implements Serializable {

    public PageResult.PageInfo pageInfo;

    public List<RecordItemBo> result;

    @Data
    public static class RecordItemBo{
//        @ApiModelProperty(value = "批次id", dataType = "long")
        public Long batchId;

//        @ApiModelProperty(value = "分类标签", dataType = "string")
        public String tag;

//        @ApiModelProperty(value = "叶子类目名称", dataType = "string")
        public String catLeafName;

//        @ApiModelProperty(value = "一级类目名称", dataType = "string")
        public String catName;

//        @ApiModelProperty(value = "是否包邮", dataType = "boolean")
        public Boolean freeShipment;

//        @ApiModelProperty(value = "好评率是否高于行业均值", dataType = "boolean")
        public Boolean hGoodRate;

//        @ApiModelProperty(value = "成交转化是否高于行业均值", dataType = "boolean")
        public Boolean hPayRate30;

//        @ApiModelProperty(value = "退款率是否低于行业均值", dataType = "boolean")
        public Boolean iRfdRate;

//        @ApiModelProperty(value = "是否加入消费者保障", dataType = "boolean")
        public Boolean isPrepay;

//        @ApiModelProperty(value = "商品链接", dataType = "string")
        public String itemUrl;

//        @ApiModelProperty(value = "商品库类型，支持多库类型输出，以“，”区分，1:营销商品主推库", dataType = "string")
        public String materialLibType;

//        @ApiModelProperty(value = "店铺名称", dataType = "string")
        public String nick;

//        @ApiModelProperty(value = "商品id", dataType = "long")
        public Long itemId;

//        @ApiModelProperty(value = "商品主图", dataType = "string")
        public String imageUrl;

//        @ApiModelProperty(value = "宝贝所在地", dataType = "string")
        public String provcity;

//        @ApiModelProperty(value = "卖家等级", dataType = "long")
        public Long ratesum;

//        @ApiModelProperty(value = "商品一口价格", dataType = "string")
        public String reservePrice;

//        @ApiModelProperty(value = "卖家id", dataType = "long")
        public Long sellerId;

//        @ApiModelProperty(value = "店铺dsr 评分", dataType = "long")
        public Long shopDsr;

//        @ApiModelProperty(value = "商品小图", dataType = "string")
        public String smallImages;

//        @ApiModelProperty(value = "商品标题", dataType = "string")
        public String title;

//        @ApiModelProperty(value = "卖家类型，0表示集市，1表示商城", dataType = "long")
        public Long userType;

//        @ApiModelProperty(value = "30天销量", dataType = "long")
        public Long volume;

//        @ApiModelProperty(value = "商品折扣价格", dataType = "string")
        public String zkFinalPrice;

//        @ApiModelProperty(value = "优惠券金额", dataType = "string")
        public String maxCommissionRate;

//        @ApiModelProperty(value = "优惠券开始时间", dataType = "string")
        public String couponStartTime;

//        @ApiModelProperty(value = "优惠券结束时间", dataType = "string")
        public String couponEndTime;

//        @ApiModelProperty(value = "优惠券描述", dataType = "string")
        public String couponInfo;
    }

}
