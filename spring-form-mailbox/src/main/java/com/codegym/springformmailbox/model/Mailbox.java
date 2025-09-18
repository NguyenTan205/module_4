package com.codegym.springformmailbox.model;

public class Mailbox {
    private String languages;
    private int pageSize;
    private boolean spamsFilter;
    private String signature;

    public Mailbox() {
    }

    public Mailbox(String languages, int pageSize, boolean spamsFilter, String signature) {
        this.setLanguages(languages);
        this.setPageSize(pageSize);
        this.setSpamsFilter(spamsFilter);
        this.setSignature(signature);
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Mailbox{" +
                "languages='" + languages + '\'' +
                ", pageSize=" + pageSize +
                ", spamsFilter=" + spamsFilter +
                ", signature='" + signature + '\'' +
                '}';
    }
}
