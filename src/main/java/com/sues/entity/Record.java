package com.sues.entity;

public class Record {
    private String ID;                //记录ID
    private String OwnerID;           //记录所有者ID
    private String AccountID;         //记录账户ID
    private String CategoryID;        //记录分类ID
    private String Amount;            //记录金额
    private String Type;              //记录类型
    private String Note;              //记录备注
    private String Status;            //记录状态
    private String CreatedAt;         //记录创建时间
    private String UpdatedAt;         //记录更新时间

    public Record() {
    }

    public Record(String ID, String ownerID, String accountID, String categoryID, String amount, String type, String note, String status, String createdAt, String updatedAt) {
        this.ID = ID;
        OwnerID = ownerID;
        AccountID = accountID;
        CategoryID = categoryID;
        Amount = amount;
        Type = type;
        Note = note;
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

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
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
        return "Record{" +
                "ID='" + ID + '\'' +
                ", OwnerID='" + OwnerID + '\'' +
                ", AccountID='" + AccountID + '\'' +
                ", CategoryID='" + CategoryID + '\'' +
                ", Amount='" + Amount + '\'' +
                ", Type='" + Type + '\'' +
                ", Note='" + Note + '\'' +
                ", Status='" + Status + '\'' +
                ", CreatedAt='" + CreatedAt + '\'' +
                ", UpdatedAt='" + UpdatedAt + '\'' +
                '}';
    }
}
