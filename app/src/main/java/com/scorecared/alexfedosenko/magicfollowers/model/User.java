package com.scorecared.alexfedosenko.magicfollowers.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("id")
    private String mId;

    @SerializedName(value = "username", alternate = "screen_name")
    private String mName;

    @SerializedName(value = "full_name", alternate = "name")
    private String mFullName;

    @SerializedName(value = "profile_picture", alternate = "profile_image_url")
    private String mProfilePicture;

    public User() {
    }

    public User(String id, String name, String fullName, String profilePicture) {
        this.mId = id;
        this.mName = name;
        this.mFullName = fullName;
        this.mProfilePicture = profilePicture;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDisplayName() {
        return mFullName;
    }

    public String getProfileImageUrl() {
        return mProfilePicture;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + mId + '\'' +
                ",name='" + mName + '\'' +
                ",fullName='" + mFullName + '\'' +
                ",profilePicture='" + mProfilePicture + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mId);
        dest.writeString(this.mName);
        dest.writeString(this.mProfilePicture);
        dest.writeString(this.mFullName);
    }

    protected User(Parcel in) {
        this.mId = in.readString();
        this.mName = in.readString();
        this.mProfilePicture = in.readString();
        this.mFullName = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
