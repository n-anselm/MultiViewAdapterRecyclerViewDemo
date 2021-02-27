package com.anselmdevelopment.multiviewadapterrecyclerviewdemo;

class RecycleItem {

    private String viewType;
    private String text;

    public RecycleItem(String viewType, String text) {
        this.viewType = viewType;
        this.text = text;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
