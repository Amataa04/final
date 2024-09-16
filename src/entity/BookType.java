package entity;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BookType implements  IBookManagement {
    private int TypeId;
    private String TypeName;
    private String description;
    private boolean IsDeleted;

    public BookType() {
    }

    public BookType(int typeId, String typeName, String description, boolean isDeleted) {
        TypeId = typeId;
        TypeName = typeName;
        this.description = description;
        IsDeleted = isDeleted;
    }

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return IsDeleted;
    }

    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }
    @Override
    public void displayData(){
        System.out.println("TypeId: " + TypeId);
        System.out.println("TypeName: " + TypeName);
        System.out.println("Description: " + description);
        System.out.println("IsDeleted: " + (IsDeleted ? "true" : "false"));
        System.out.println("-------------------------------------------");
    }
    @Override
    public void inputData(Scanner sc){
        System.out.println("Nhap ten loai sach: ");
        TypeName = sc.nextLine();
        System.out.println("Nhap mo ta");
        this.description = sc.nextLine();
        System.out.println("Nhap trang thai(true/false): ");
        IsDeleted = Boolean.parseBoolean(sc.nextLine());
    }
}
