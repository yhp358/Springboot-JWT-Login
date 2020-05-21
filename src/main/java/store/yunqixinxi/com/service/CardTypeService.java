package store.yunqixinxi.com.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.yunqixinxi.com.mapper.CardTypeMapper;
import store.yunqixinxi.com.model.entity.CardType;
import store.yunqixinxi.com.model.dto.CardTypeQueryDto;
import store.yunqixinxi.com.model.dto.CardTypeSaveDto;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class CardTypeService {

    @Autowired
    private CardTypeMapper mapper;

    public List<CardType> findList(CardTypeQueryDto dto){
        return mapper.findList(dto);
    }

    /**
     * 新增卡类
     * @param dto
     */
    public void save(CardTypeSaveDto dto) {
        //取出总店编号
        String storeCode = dto.getStoreCode();
        //取出卡类名称
        String typeName = dto.getTypeName();
        //判断此卡是否存在
        if(findCountByTypeName(storeCode,typeName,0)>0){
            throw new IllegalArgumentException("卡类名称已经存在");
        }
        CardType cardType = new CardType();
        BeanUtils.copyProperties(dto,cardType);
        cardType.setOperateTime(new Date());

        mapper.insertSelective(cardType);
    }

    /**
     * 根据门店编号和卡类名称查询记录数
     * @param StoreCode
     * @param typeName
     * @param excludeId
     * @return
     */
    public int findCountByTypeName(String StoreCode,String typeName,int excludeId){
        Example example = new Example(CardType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("storeCode",StoreCode);
        criteria.andEqualTo("typeName",typeName);
        criteria.andEqualTo("yn",0);
        criteria.andNotEqualTo("id",excludeId);
        return mapper.selectCountByExample(example);
    }


}
