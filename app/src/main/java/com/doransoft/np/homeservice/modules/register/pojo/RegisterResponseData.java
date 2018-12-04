package com.doransoft.np.homeservice.modules.register.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class RegisterResponseData implements Parcelable {
    public static final Creator<RegisterResponseData> CREATOR = new Creator<RegisterResponseData>() {
        @Override
        public RegisterResponseData createFromParcel(Parcel source) {
            RegisterResponseData var = new RegisterResponseData();
            var.country = source.readString();
            var.user_type = source.readString();
            var.address = source.readString();
            var.activation_code = source.readString();
            var.phone = source.readString();
            var.l_name = source.readString();
            var.api_token = source.readString();
            var.f_name = source.readString();
            var.created_at = source.readString();
            var._id = source.readString();
            var.email = source.readString();
            var.status = source.readString();
            return var;
        }

        @Override
        public RegisterResponseData[] newArray(int size) {
            return new RegisterResponseData[size];
        }
    };
    private String country;
    private String user_type;
    private String address;
    private String activation_code;
    private String phone;
    private String l_name;
    private String api_token;
    private String f_name;
    private String created_at;
    private String _id;
    private String email;
    private String status;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUser_type() {
        return this.user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getActivation_code() {
        return this.activation_code;
    }

    public void setActivation_code(String activation_code) {
        this.activation_code = activation_code;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getL_name() {
        return this.l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getApi_token() {
        return this.api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public String getF_name() {
        return this.f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.country);
        dest.writeString(this.user_type);
        dest.writeString(this.address);
        dest.writeString(this.activation_code);
        dest.writeString(this.phone);
        dest.writeString(this.l_name);
        dest.writeString(this.api_token);
        dest.writeString(this.f_name);
        dest.writeString(this.created_at);
        dest.writeString(this._id);
        dest.writeString(this.email);
        dest.writeString(this.status);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
