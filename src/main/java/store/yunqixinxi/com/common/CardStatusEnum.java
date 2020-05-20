package store.yunqixinxi.com.common;

public enum CardStatusEnum {

    //会员卡状态 0正常 1挂失 2禁用 3注销
    NORMAL(0,"正常"),
    LOSS(1,"挂失"),
    FORBIDDEN(2,"禁用"),
    CANCEL(3,"注销");

    private Integer key;
    private String value;

    CardStatusEnum(Integer key,String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String getValue(Integer key) {
        for (CardStatusEnum e : CardStatusEnum.values()) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }
}
