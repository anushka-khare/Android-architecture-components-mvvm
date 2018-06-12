
package pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeaturedApp {

    @SerializedName("ios_id")
    @Expose
    private Integer iosId;
    @SerializedName("is_active")
    @Expose
    private Integer isActive;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("app_name")
    @Expose
    private String appName;
    @SerializedName("super_theme")
    @Expose
    private String superTheme;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("product_line")
    @Expose
    private String productLine;
    @SerializedName("android_id")
    @Expose
    private String androidId;
    @SerializedName("app_category")
    @Expose
    private String appCategory;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("app_id")
    @Expose
    private Integer appId;
    @SerializedName("kids_flag")
    @Expose
    private Integer kidsFlag;

    public Integer getIosId() {
        return iosId;
    }

    public void setIosId(Integer iosId) {
        this.iosId = iosId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getSuperTheme() {
        return superTheme;
    }

    public void setSuperTheme(String superTheme) {
        this.superTheme = superTheme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getAppCategory() {
        return appCategory;
    }

    public void setAppCategory(String appCategory) {
        this.appCategory = appCategory;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getKidsFlag() {
        return kidsFlag;
    }

    public void setKidsFlag(Integer kidsFlag) {
        this.kidsFlag = kidsFlag;
    }

}
