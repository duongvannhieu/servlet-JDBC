package org.duongnhieu.models;

public class NewModel extends AbstractModel<NewModel>{
    private Long categoryId;
    private String categoryCode;
    private String title;
    private String shortDescription;
    private String thumbmail;
    private String content;

    public NewModel(){}

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setThumbmail(String thumbmail) {
        this.thumbmail = thumbmail;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getThumbmail() {
        return thumbmail;
    }

    public String getContent() {
        return content;
    }
}
