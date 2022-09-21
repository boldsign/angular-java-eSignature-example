package com.boldsign.demo.models.boldsignModel;

public class FormField {
    public String id;
    public String fieldType;
    public boolean isRequired;
    public String value;
    public int pageNumber;
    public FieldPosition bounds;

    public FormField(String id, String fieldType, boolean isRequired, String value, int pageNumber,
            FieldPosition bounds) {
        this.id = id;
        this.fieldType = fieldType;
        this.isRequired = isRequired;
        this.value = value;
        this.pageNumber = pageNumber;
        this.bounds = bounds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public FieldPosition getBounds() {
        return bounds;
    }

    public void setBounds(FieldPosition bounds) {
        this.bounds = bounds;
    }

}
