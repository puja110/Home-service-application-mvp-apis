package com.doransoft.np.homeservice.modules.login.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginResponse implements Parcelable {
    public static final Creator<LoginResponse> CREATOR = new Creator<LoginResponse>() {
        @Override
        public LoginResponse createFromParcel(Parcel source) {
            LoginResponse var = new LoginResponse();
            var.data = source.readParcelable(LoginResponseData.class.getClassLoader());
            var.message = source.readParcelable(Object.class.getClassLoader());
            var.status = source.readString();
            return var;
        }

        @Override
        public LoginResponse[] newArray(int size) {
            return new LoginResponse[size];
        }
    };
    private LoginResponseData data;
    private String message;
    private String status;

    public LoginResponseData getData() {
        return this.data;
    }

    public void setData(LoginResponseData data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
        dest.writeString(this.status);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
