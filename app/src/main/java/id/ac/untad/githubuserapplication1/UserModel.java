package id.ac.untad.githubuserapplication1;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
    private int avatar;
    private String nama;
    private String username;
    private String company;
    private String location;
    private String repository;
    private String followers;
    private String following;

    public UserModel() {
    }

    protected UserModel(Parcel in) {
        this.avatar = in.readInt();
        this.nama = in.readString();
        this.username = in.readString();
        this.company = in.readString();
        this.location = in.readString();
        this.repository = in.readString();
        this.followers = in.readString();
        this.following = in.readString();
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.avatar);
        dest.writeString(this.nama);
        dest.writeString(this.username);
        dest.writeString(this.company);
        dest.writeString(this.location);
        dest.writeString(this.repository);
        dest.writeString(this.followers);
        dest.writeString(this.following);
    }
}