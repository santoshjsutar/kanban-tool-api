package com.techdotsanjs.kanbantoolapi.model;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", nullable = false, insertable = false, updatable = false, columnDefinition = "datetime default current_timestamp")
    private Date createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on", columnDefinition = "datetime null on update current_timestamp")
    private Date updatedOn;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "bit default 0")
    private Boolean isDeleted = false;
    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
