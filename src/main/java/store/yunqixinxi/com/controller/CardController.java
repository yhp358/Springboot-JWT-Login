package store.yunqixinxi.com.controller;

import com.eheart.common.entity.RRGenerator;
import com.eheart.common.entity.RestResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import store.yunqixinxi.com.common.ControllerBase;
import store.yunqixinxi.com.model.CardType;
import store.yunqixinxi.com.model.CardTypeQueryDto;
import store.yunqixinxi.com.model.CardTypeSaveDto;
import store.yunqixinxi.com.service.CardTypeService;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "会员卡类管理")
@RestController
@RequestMapping("api/cardtype")
public class CardController extends ControllerBase {

    @Autowired
    private CardTypeService cardTypeService;

    @ApiOperation(value="会员卡类列表查询", notes="会员卡类列表查询")
    @RequestMapping(value = "findlist",method = RequestMethod.GET)
    public RestResult<List<CardType>> cardTypeQuery(@RequestBody CardTypeQueryDto dto){
        try {
            if(dto.getPage() != null && dto.getPageSize() != null){
                Page page = PageHelper.startPage(dto.getPage(), dto.getPageSize());
            }
            List<CardType> list = cardTypeService.findList(dto);
            System.out.println(list);
            return RRGenerator.success(list);
        } catch (Exception e) {
            logger.info("查询会员卡类别失败: {} "+e.getMessage());
            return RRGenerator.error("查询会员卡类别失败");
        }
    }

    @RequestMapping(value = "/addCardType",method = RequestMethod.POST)
    @ApiOperation(value = "新增会员卡类",notes = "新增会员卡类")
    public RestResult<String> insert(@Valid @RequestBody CardTypeSaveDto dto, HttpServletRequest request){
        try {
            dto.setStoreCode("10000003");
            dto.setOperateStoreCode("10000003");
            //dto.setUseStoreCodes(getUseStoreCodes(request,dto.getUseStoreCodes()));
            cardTypeService.save(dto);
            return RRGenerator.success("创建会员卡成功");
        } catch (Exception e) {
            logger.error("添加会员卡失败"+e.getMessage());
            return RRGenerator.error(e.getMessage());
        }
    }
}

