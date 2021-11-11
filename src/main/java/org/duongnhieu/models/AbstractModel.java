package org.duongnhieu.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
    private Long id;
    private Timestamp createddate;
    private Timestamp modifieddate;
    private String createdby;
    private String modifiedby;
    private Long[] ids;
    private List<T> listResult = new ArrayList<>();

    public AbstractModel(){}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setModifieddate(Timestamp modifieddate) {
        this.modifieddate = modifieddate;
    }

    public String getModifiedby() {
        return modifiedby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Timestamp getModifieddate() {
        return modifieddate;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

    public Long[] getIds() {
        return ids;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

    public List<T> getListResult() {
        return listResult;
    }
}
