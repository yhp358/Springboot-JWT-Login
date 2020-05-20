    package store.yunqixinxi.com.model;

    import com.fasterxml.jackson.annotation.JsonFormat;
    import io.swagger.annotations.ApiModelProperty;
    import store.yunqixinxi.com.common.BaseEntity;

    import javax.persistence.Column;
    import javax.persistence.Table;
    import java.util.Date;

    @Table(name = "card_type")
    public class CardType extends BaseEntity {

        @ApiModelProperty(value = "卡类名称")
        @Column(name = "type_name")
        private String typeName;

        @ApiModelProperty(value = "开卡方式 1线下开卡 2注册开卡")
        @Column(name = "open_type")
        private Integer openType;

        @ApiModelProperty(value = "卡类图片url")
        @Column(name = "picture_url")
        private String pictureUrl;

        @ApiModelProperty(value = "是否允许充值 0否 1是")
        @Column(name = "value_card")
        private Integer valueCard;

        @ApiModelProperty(value = "最低开卡额度")
        @Column(name = "min_amount")
        private Double minAmount;

        @ApiModelProperty(value = "是否允许积分 0否 1是")
        @Column(name = "integral_card")
        private Integer integralCard;

        @ApiModelProperty(value = "积分基数(多少元积一分)")
        @Column(name = "integral_base")
        private Double integralBase;

        @ApiModelProperty(value = "是否允许积分清零 0否 1是")
        @Column(name = "integral_clear")
        private Integer integralClear;

        @ApiModelProperty(value = "积分清零时间 MM-dd格式")
        @Column(name = "integral_clear_time")
        private String integralClearTime;

        @ApiModelProperty(value = "是否允许折扣 0否 1是")
        @Column(name = "discount_card")
        private Integer discountCard;

        @ApiModelProperty(value = "会员折扣率百分比")
        @Column(name = "discount_rate")
        private Double discountRate;

        @ApiModelProperty(value = "是否允许限次 0否 1是")
        @Column(name = "limit_card")
        private Integer limitCard;

        @ApiModelProperty(value = "限用次数")
        @Column(name = "limit_times")
        private Integer limitTimes;

        @ApiModelProperty(value = "是否享受会员价 0否 1是")
        @Column(name = "vip_price")
        private Integer vipPrice;

        @ApiModelProperty(value = "是否支持微信 0否 1是")
        @Column(name = "wechat_use")
        private Integer wechatUse;

        @ApiModelProperty(value = "有效期")
        @Column(name = "valid_time")
        private Integer validTime;

        @ApiModelProperty(value = "有效期单位 0永久 1天 2周 3月 4年")
        @Column(name = "time_unit")
        private Integer timeUnit;

        @ApiModelProperty(value = "使用说明")
        @Column(name = "remark")
        private String remark;

        @ApiModelProperty(value = "特权说明")
        @Column(name = "privilege")
        private String privilege;

        @ApiModelProperty(value = "适用门店编号集合，英文逗号隔开")
        @Column(name = "use_store_codes")
        private String useStoreCodes;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
        @ApiModelProperty(value = "操作时间")
        @Column(name = "operate_time")
        private Date operateTime;

        @ApiModelProperty(value = "操作门店编号")
        @Column(name = "operate_store_code")
        private String operateStoreCode;

        @ApiModelProperty(value = "总店编号")
        @Column(name = "store_code")
        private String storeCode;

        @ApiModelProperty(value = "删除标识 0正常 1逻辑删除",hidden = true)
        @Column(name = "yn")
        private Integer yn;

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

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public Integer getValueCard() {
            return valueCard;
        }

        public void setValueCard(Integer valueCard) {
            this.valueCard = valueCard;
        }

        public Double getMinAmount() {
            return minAmount;
        }

        public void setMinAmount(Double minAmount) {
            this.minAmount = minAmount;
        }

        public Integer getIntegralCard() {
            return integralCard;
        }

        public void setIntegralCard(Integer integralCard) {
            this.integralCard = integralCard;
        }

        public Double getIntegralBase() {
            return integralBase;
        }

        public void setIntegralBase(Double integralBase) {
            this.integralBase = integralBase;
        }

        public Integer getIntegralClear() {
            return integralClear;
        }

        public void setIntegralClear(Integer integralClear) {
            this.integralClear = integralClear;
        }

        public String getIntegralClearTime() {
            return integralClearTime;
        }

        public void setIntegralClearTime(String integralClearTime) {
            this.integralClearTime = integralClearTime;
        }

        public Integer getDiscountCard() {
            return discountCard;
        }

        public void setDiscountCard(Integer discountCard) {
            this.discountCard = discountCard;
        }

        public Double getDiscountRate() {
            return discountRate;
        }

        public void setDiscountRate(Double discountRate) {
            this.discountRate = discountRate;
        }

        public Integer getLimitCard() {
            return limitCard;
        }

        public void setLimitCard(Integer limitCard) {
            this.limitCard = limitCard;
        }

        public Integer getLimitTimes() {
            return limitTimes;
        }

        public void setLimitTimes(Integer limitTimes) {
            this.limitTimes = limitTimes;
        }

        public Integer getVipPrice() {
            return vipPrice;
        }

        public void setVipPrice(Integer vipPrice) {
            this.vipPrice = vipPrice;
        }

        public Integer getWechatUse() {
            return wechatUse;
        }

        public void setWechatUse(Integer wechatUse) {
            this.wechatUse = wechatUse;
        }

        public Integer getValidTime() {
            return validTime;
        }

        public void setValidTime(Integer validTime) {
            this.validTime = validTime;
        }

        public Integer getTimeUnit() {
            return timeUnit;
        }

        public void setTimeUnit(Integer timeUnit) {
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

        public Date getOperateTime() {
            return operateTime;
        }

        public void setOperateTime(Date operateTime) {
            this.operateTime = operateTime;
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

        public Integer getYn() {
            return yn;
        }

        public void setYn(Integer yn) {
            this.yn = yn;
        }

        @Override
        public String toString() {
            return "CardType{" +
                    "typeName='" + typeName + '\'' +
                    ", openType=" + openType +
                    ", pictureUrl='" + pictureUrl + '\'' +
                    ", valueCard=" + valueCard +
                    ", minAmount=" + minAmount +
                    ", integralCard=" + integralCard +
                    ", integralBase=" + integralBase +
                    ", integralClear=" + integralClear +
                    ", integralClearTime='" + integralClearTime + '\'' +
                    ", discountCard=" + discountCard +
                    ", discountRate=" + discountRate +
                    ", limitCard=" + limitCard +
                    ", limitTimes=" + limitTimes +
                    ", vipPrice=" + vipPrice +
                    ", wechatUse=" + wechatUse +
                    ", validTime=" + validTime +
                    ", timeUnit=" + timeUnit +
                    ", remark='" + remark + '\'' +
                    ", privilege='" + privilege + '\'' +
                    ", useStoreCodes='" + useStoreCodes + '\'' +
                    ", operateTime=" + operateTime +
                    ", operateStoreCode='" + operateStoreCode + '\'' +
                    ", storeCode='" + storeCode + '\'' +
                    ", yn=" + yn +
                    '}';
        }
    }
