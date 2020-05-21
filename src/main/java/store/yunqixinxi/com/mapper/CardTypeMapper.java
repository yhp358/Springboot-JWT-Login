package store.yunqixinxi.com.mapper;

import org.springframework.stereotype.Repository;
import store.yunqixinxi.com.basemapper.BaseMapper;
import store.yunqixinxi.com.model.entity.CardType;
import store.yunqixinxi.com.model.dto.CardTypeQueryDto;

import java.util.List;

@Repository
public interface CardTypeMapper extends BaseMapper<CardType> {

    List<CardType> findList(CardTypeQueryDto dto);
}
