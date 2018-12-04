package com.doransoft.np.homeservice.modules.register.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class RegisterResponse implements Parcelable {
    public static final Creator<RegisterResponse> CREATOR = new Creator<RegisterResponse>() {
        @Override
        public RegisterResponse createFromParcel(Parcel source) {
            RegisterResponse var = new RegisterResponse();
            var.data = source.readParcelable(RegisterResponseData.class.getClassLoader());
            var.message = source.readParcelable(Object.class.getClassLoader());
            var.status = source.readString();
            return var;
        }

        @Override
        public RegisterResponse[] newArray(int size) {
            return new RegisterResponse[size];
        }
    };
    private RegisterResponseData data;
    private String message;
    private String status;

    public RegisterResponseData getData() {
        return this.data;
    }

    public void setData(RegisterResponseData data) {
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
