package store.yunqixinxi.com.common;

import io.swagger.annotations.ApiModelProperty;

public class PageDto {

    @ApiModelProperty("第几页")
    private Integer page;

    @ApiModelProperty("每页大小")
    private Integer pageSize;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
