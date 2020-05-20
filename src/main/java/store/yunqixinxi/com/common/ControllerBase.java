package store.yunqixinxi.com.common;

import com.github.pagehelper.util.StringUtil;
import store.yunqixinxi.com.config.StoreConsts;

import javax.servlet.http.HttpServletRequest;

public class ControllerBase extends LoggerBase {
    protected String getCompanyCode(HttpServletRequest request) {
        String companyCode = (String)request.getAttribute(StoreConsts.KEY_COMPANY_CODE);
        //companyCode = "474213237840281600";
        return companyCode;
    }

    protected String getStoreCode(HttpServletRequest request) {
        String storeCode = (String)request.getAttribute(StoreConsts.KEY_STORE_CODE);
        //storeCode = "474213237840281600";
        return storeCode;
    }

    protected String getStoreName(HttpServletRequest request) {
        String storeName = (String)request.getAttribute(StoreConsts.KEY_STORE_NAME);
        //storeName = "七月七日晴";
        return storeName;
    }

    protected Integer getIsCompany(HttpServletRequest request) {
        Integer isCompany = (Integer) request.getAttribute(StoreConsts.KEY_IS_COMPANY);
        //isCompany = 0;
        return isCompany;
    }

    protected Integer getMemberChainType(HttpServletRequest request) {
        Integer memberChainType = (Integer) request.getAttribute(StoreConsts.KEY_MEMBER_CHAIN_TYPE);
        //memberChainType = 0;
        return memberChainType;
    }

    protected String getUseStoreCodes(HttpServletRequest request,String useStoreCodes) {
        String storeCode = getStoreCode(request); //门店编号
        if (StringUtil.isEmpty(useStoreCodes)) {
            useStoreCodes = storeCode;
        } else if (!useStoreCodes.contains(storeCode)) {
            useStoreCodes = storeCode + "," + useStoreCodes;
        }
        return useStoreCodes;
    }
}
