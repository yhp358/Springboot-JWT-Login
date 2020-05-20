package store.yunqixinxi.com.common;

public enum TestEnum {
    RED("红色"),
    BLACK("黑色"),

    WRITE("白色"),

    YELLOW("黄色"),
    BLUE("蓝色");
    private String color;

    TestEnum(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "TestEnum{" +
                "color='" + color + '\'' +
                '}';
    }
}
