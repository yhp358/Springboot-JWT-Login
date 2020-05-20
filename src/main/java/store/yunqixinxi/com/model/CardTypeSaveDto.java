package store.yunqixinxi.com.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

public class CardTypeSaveDto {

    @ApiModelProperty(value = "卡类名称",required = true)
    @NotBlank(message = "卡类名称不能为空")
    private String typeName;

    @ApiModelProperty(value = "开卡方式 1线下开卡 2注册开卡")
    private int openType;

    @ApiModelProperty(value = "卡类图片url")
    private String pictureUrl;

    @ApiModelProperty(value = "是否允许充值 0否 1是")
    private int valueCard;

    @ApiModelProperty(value = "开卡额度")
    private double minAmount;

    @ApiModelProperty(value = "是否允许积分 0否 1是")
    private int integralCard;

    @ApiModelProperty(value = "积分基数(多少元积一分)")
    private double integralBase;

    @ApiModelProperty(value = "是否允许积分清零 0否 1是")
    private int integralClear;

    @ApiModelProperty(value = "积分清零时间 MM-dd格式")
    private String integralClearTime;

    @ApiModelProperty(value = "是否允许折扣 0否 1是")
    private int discountCard;

    @ApiModelProperty(value = "会员折扣率百分比")
    private double discountRate;

    @ApiModelProperty(value = "是否允许限次 0否 1是")
    private int limitCard;

    @ApiModelProperty(value = "限用次数")
    private int limitTimes;

    @ApiModelProperty(value = "是否享受会员价 0否 1是")
    private int vipPrice;

    @ApiModelProperty(value = "是否支持微信 0否 1是")
    private int wechatUse;

    @ApiModelProperty(value = "有效期")
    private int validTime;

    @ApiModelProperty(value = "有效期单位 0永久 1天 2周 3月 4年")
    private int timeUnit;

    @ApiModelProperty(value = "使用说明")
    private String remark;

    @ApiModelProperty(value = "特权说明")
    private String privilege;

    @ApiModelProperty(value = "适用门店编号集合，英文逗号隔开",required = true)
    @NotBlank(message = "适用门店编号集合不能为空")
    private String useStoreCodes;

    @ApiModelProperty(value = "操作门店编号")
    private String operateStoreCode;

    @ApiModelProperty(value = "总店编号")
    private String storeCode;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getOpenType() {
        return openType;
    }

    public void setOpenType(int openType) {
        this.openType = openType;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getValueCard() {
        return valueCard;
    }

    public void setValueCard(int valueCard) {
        this.valueCard = valueCard;
    }

    public double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(double minAmount) {
        this.minAmount = minAmount;
    }

    public int getIntegralCard() {
        return integralCard;
    }

    public void setIntegralCard(int integralCard) {
        this.integralCard = integralCard;
    }

    public double getIntegralBase() {
        return integralBase;
    }

    public void setIntegralBase(double integralBase) {
        this.integralBase = integralBase;
    }

    public int getIntegralClear() {
        return integralClear;
    }

    public void setIntegralClear(int integralClear) {
        this.integralClear = integralClear;
    }

    public String getIntegralClearTime() {
        return integralClearTime;
    }

    public void setIntegralClearTime(String integralClearTime) {
        this.integralClearTime = integralClearTime;
    }

    public int getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(int discountCard) {
        this.discountCard = discountCard;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getLimitCard() {
        return limitCard;
    }

    public void setLimitCard(int limitCard) {
        this.limitCard = limitCard;
    }

    public int getLimitTimes() {
        return limitTimes;
    }

    public void setLimitTimes(int limitTimes) {
        this.limitTimes = limitTimes;
    }

    public int getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(int vipPrice) {
        this.vipPrice = vipPrice;
    }

    public int getWechatUse() {
        return wechatUse;
    }

    public void setWechatUse(int wechatUse) {
        this.wechatUse = wechatUse;
    }

    public int getValidTime() {
        return validTime;
    }

    public void setValidTime(int validTime) {
        this.validTime = validTime;
    }

    public int getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(int timeUnit) {
        this.timeUnit = timeUnit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getUseStoreCodes() {
        return useStoreCodes;
    }

    public void setUseStoreCodes(String useStoreCodes) {
        this.useStoreCodes = useStoreCodes;
    }

    public String getOperateStoreCode() {
        return operateStoreCode;
    }

    public void setOperateStoreCode(String operateStoreCode) {
        this.operateStoreCode = operateStoreCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
}
