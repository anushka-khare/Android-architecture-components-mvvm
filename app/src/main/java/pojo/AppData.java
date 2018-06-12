
package pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppData {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("promotions")
    @Expose
    private Promotions promotions;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Promotions getPromotions() {
        return promotions;
    }

    public void setPromotions(Promotions promotions) {
        this.promotions = promotions;
    }

}
