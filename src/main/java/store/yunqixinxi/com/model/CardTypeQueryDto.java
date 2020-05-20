package store.yunqixinxi.com.model;

import io.swagger.annotations.ApiModelProperty;
import store.yunqixinxi.com.common.PageDto;

public class CardTypeQueryDto extends PageDto {

    @ApiModelProperty(value = "总店编号")
    private String storeCode;

    @ApiModelProperty(value = "操作门店编号")
    private String operateStoreCode;

    @ApiModelProperty(value = "卡类名称")
    private String typeName;

    @ApiModelProperty(value = "开卡方式 1线下开卡 2注册开卡")
    private Integer openType;

    @ApiModelProperty(value = "是否允许充值 0否 1是")
    private Integer valueCard;

    @ApiModelProperty(value = "是否享受会员价 0否 1是")
    private Integer vipPrice;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getOperateStoreCode() {
        return operateStoreCode;
    }

    public void setOperateStoreCode(String operateStoreCode) {
        this.operateStoreCode = operateStoreCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getOpenType() {
        return openType;
    }

    public void setOpenType(Integer openType) {
        this.openType = openType;
    }

    public Integer getValueCard() {
        return valueCard;
    }

    public void setValueCard(Integer valueCard) {
        this.valueCard = valueCard;
    }

    public Integer getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(Integer vipPrice) {
        this.vipPrice = vipPrice;
    }
}