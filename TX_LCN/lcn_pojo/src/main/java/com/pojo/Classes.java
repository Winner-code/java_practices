package com.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Classes implements Serializable {
    private Long id;
    private String className;
    private Date createDate = new Date();

    public Classes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classes classes = (Classes) o;
        return Objects.equals(id, classes.id) &&
                Objects.equals(className, classes.className) &&
                Objects.equals(createDate, classes.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, className, createDate);
    }
}
