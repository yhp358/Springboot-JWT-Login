package store.yunqixinxi.com.model.common;

import java.io.Serializable;

public class TokenModel implements Serializable {

    private String tokenId;
    private String username;
    private String storecode;
    private String storename;

    @Override
    public String toString() {
        return "TokenModel{" +
                "tokenId='" + tokenId + '\'' +
                ", username='" + username + '\'' +
                ", storecode='" + storecode + '\'' +
                ", storename='" + storename + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    private String telephone;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStorecode() {
        return storecode;
    }

    public void setStorecode(String storecode) {
        this.storecode = storecode;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
