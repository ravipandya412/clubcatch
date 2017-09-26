package com.pkr.clubcatch;

public class Contact__modelclass {
    String Name;
    String Phone_num;

    public Contact__modelclass(String Name, String Phone_num) {
        this.Name = Name;
        this.Phone_num = Phone_num;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPhone() {
        return this.Phone_num;
    }

    public void setPhone(String phone) {
        this.Phone_num = phone;
    }
}
