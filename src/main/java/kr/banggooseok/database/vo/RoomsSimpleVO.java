package kr.banggooseok.database.vo;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RoomsSimpleVO {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("trans_type")
    private int trans_type;

    @SerializedName("deposit")
    private int deposit;

    @SerializedName("fee")
    private int fee;

    @SerializedName("floor")
    private int floor;

    @SerializedName("const_type")
    private int const_type;

    @SerializedName("address")
    private String address;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("timestamp")
    private long timestamp;

    @SerializedName("trans_done")
    private boolean trans_done;

    @SerializedName("fav_count")
    private int fav_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(int trans_type) {
        this.trans_type = trans_type;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getConst_type() {
        return const_type;
    }

    public void setConst_type(int const_type) {
        this.const_type = const_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(String images) {
        List<String> imageList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(images, ";");

        while (stringTokenizer.hasMoreTokens()) {
            imageList.add(stringTokenizer.nextToken());
        }

        this.images = imageList;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp.toInstant().toEpochMilli();
    }

    public boolean isTrans_done() {
        return trans_done;
    }

    public void setTrans_done(boolean trans_done) {
        this.trans_done = trans_done;
    }

    public int getFav_count() {
        return fav_count;
    }

    public void setFav_count(int fav_count) {
        this.fav_count = fav_count;
    }

}
