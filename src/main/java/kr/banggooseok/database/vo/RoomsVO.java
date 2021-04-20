package kr.banggooseok.database.vo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RoomsVO {

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

    @SerializedName("const_type")
    private int const_type;

    @SerializedName("floor")
    private int floor;

    @SerializedName("address")
    private String address;

    @SerializedName("images")
    private List<String> images;

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

    public int getConst_type() {
        return const_type;
    }

    public void setConst_type(int const_type) {
        this.const_type = const_type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
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
}
