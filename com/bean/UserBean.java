package com.bean;

public class UserBean {
    String FROM_REQUEST;
    public String GRP_SMS;
    String LATITUDE;
    String LOGIN;
    String LONGITUDE;
    String SMS;
    public String SMS_WHO;
    String TO;
    String TO_REQUEST;
    String WHO;
    String WHOM;
    String WHOM_LOCATION;

    public String getWHOM_LOCATION() {
        return this.WHOM_LOCATION;
    }

    public void setWHOM_LOCATION(String wHOM_LOCATION) {
        this.WHOM_LOCATION = wHOM_LOCATION;
    }

    public String getLATITUDE() {
        return this.LATITUDE;
    }

    public void setLATITUDE(String lATITUDE) {
        this.LATITUDE = lATITUDE;
    }

    public String getLONGITUDE() {
        return this.LONGITUDE;
    }

    public void setLONGITUDE(String lONGITUDE) {
        this.LONGITUDE = lONGITUDE;
    }

    public String getTO_REQUEST() {
        return this.TO_REQUEST;
    }

    public void setTO_REQUEST(String tO_REQUEST) {
        this.TO_REQUEST = tO_REQUEST;
    }

    public String getFROM_REQUEST() {
        return this.FROM_REQUEST;
    }

    public void setFROM_REQUEST(String fROM_REQUEST) {
        this.FROM_REQUEST = fROM_REQUEST;
    }

    public String getWHO() {
        return this.WHO;
    }

    public void setWHO(String wHO) {
        this.WHO = wHO;
    }

    public String getWHOM() {
        return this.WHOM;
    }

    public void setWHOM(String wHOM) {
        this.WHOM = wHOM;
    }

    public String getTO() {
        return this.TO;
    }

    public void setTO(String tO) {
        this.TO = tO;
    }

    public String getLOGIN() {
        return this.LOGIN;
    }

    public void setLOGIN(String lOGIN) {
        this.LOGIN = lOGIN;
    }

    public String getSMS() {
        return this.SMS;
    }

    public void setSMS(String sMS) {
        this.SMS = sMS;
    }

    public String getGRP_SMS() {
        return this.GRP_SMS;
    }

    public void setGRP_SMS(String gRP_SMS) {
        this.GRP_SMS = gRP_SMS;
    }

    public String getSMS_WHO() {
        return this.SMS_WHO;
    }

    public void setSMS_WHO(String sMS_WHO) {
        this.SMS_WHO = sMS_WHO;
    }
}
