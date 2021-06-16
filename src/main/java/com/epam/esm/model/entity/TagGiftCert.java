package com.epam.esm.model.entity;

import java.util.Objects;

/**
 * The class of gift certificate with tag
 */
public class TagGiftCert {

    private String name;
    private String certName;
    private int price;
    private int duration;
    private String description;
    private String createDate;
    private String lastUpdateDate;

    public TagGiftCert() {
    }

    public TagGiftCert(String name, String certName, int price, int duration, String description, String createDate, String lastUpdateDate) {
        this.name = name;
        this.certName = certName;
        this.price = price;
        this.duration = duration;
        this.description = description;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagGiftCert that = (TagGiftCert) o;
        return price == that.price && duration == that.duration && name.equals(that.name) && certName.equals(that.certName) && Objects.equals(description, that.description) && createDate.equals(that.createDate) && lastUpdateDate.equals(that.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, certName, price, duration, description, createDate, lastUpdateDate);
    }

    @Override
    public String toString() {
        return "TagGiftCert{" +
                "name='" + name + '\'' +
                ", cert_name='" + certName + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", create_date='" + createDate + '\'' +
                ", last_update_date='" + lastUpdateDate + '\'' +
                '}';
    }
}
