package org.duongnhieu.models;

public class CategoryModel extends AbstractModel<CategoryModel>{
    private String name;
    private String code;

    public CategoryModel(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
