
package pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Promotions {

    @SerializedName("featured_apps")
    @Expose
    private List<FeaturedApp> featuredApps = null;

    @SerializedName("more_apps")
    @Expose
    private List<MoreApps> moreApps = null;

    public List<MoreApps> getMoreApps() {
        return moreApps;
    }

    public void setMoreApps(List<MoreApps> moreApps) {
        this.moreApps = moreApps;
    }

    public List<FeaturedApp> getFeaturedApps() {
        return featuredApps;
    }

    public void setFeaturedApps(List<FeaturedApp> featuredApps) {
        this.featuredApps = featuredApps;
    }

}
