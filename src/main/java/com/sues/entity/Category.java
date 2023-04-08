package com.sues.entity;

public class Category {
    private String ID;                //分类ID
    private String OwnerID;           //分类所有者ID
    private String Name;              //分类名称
    private String Type;              //分类类型
    private String Status;            //分类状态
    private String CreatedAt;         //分类创建时间
    private String UpdatedAt;         //分类更新时间

    public Category() {
    }

    public Category(String ID, String ownerID, String name, String type, String status, String createdAt, String updatedAt) {
        this.ID = ID;
        OwnerID = ownerID;
        Name = name;
        Type = type;
        Status = status;
        CreatedAt = createdAt;
        UpdatedAt = updatedAt;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(String ownerID) {
        OwnerID = ownerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        UpdatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Category{" +
                "ID='" + ID + '\'' +
                ", OwnerID='" + OwnerID + '\'' +
                ", Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Status='" + Status + '\'' +
                ", CreatedAt='" + CreatedAt + '\'' +
                ", UpdatedAt='" + UpdatedAt + '\'' +
                '}';
    }
}
