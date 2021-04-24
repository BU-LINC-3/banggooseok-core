package kr.banggooseok.database.vo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RoomsVO extends RoomsSimpleVO {

    @SerializedName("user_id")
    private long user_id;

    @SerializedName("description")
    private String description;

    @SerializedName("manage_fee")
    private int manage_fee;

    @SerializedName("manage_tags")
    private List<String> manage_tags;

    @SerializedName("const_floor")
    private int const_floor;

    @SerializedName("valid_dimen")
    private float valid_dimen;

    @SerializedName("supply_dimen")
    private float supply_dimen;

    @SerializedName("avail_date")
    private long avail_date;

    @SerializedName("options")
    private List<String> options;

    @SerializedName("elevator")
    private boolean elevator;

    @SerializedName("parking")
    private int parking;

    @SerializedName("temp_sys")
    private int temp_sys;

    @SerializedName("contact")
    private String contact;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getManage_fee() {
        return manage_fee;
    }

    public void setManage_fee(int manage_fee) {
        this.manage_fee = manage_fee;
    }

    // TODO: DB INSERT 처리
    public List<String> getManage_tags() {
        return manage_tags;
    }

    public void setManage_tags(String manage_tags) {
        List<String> manageList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(manage_tags, ";");

        while (stringTokenizer.hasMoreTokens()) {
            manageList.add(stringTokenizer.nextToken());
        }

        this.manage_tags = manageList;
    }

    public int getConst_floor() {
        return const_floor;
    }

    public void setConst_floor(int const_floor) {
        this.const_floor = const_floor;
    }

    public float getValid_dimen() {
        return valid_dimen;
    }

    public void setValid_dimen(float valid_dimen) {
        this.valid_dimen = valid_dimen;
    }

    public float getSupply_dimen() {
        return supply_dimen;
    }

    public void setSupply_dimen(float supply_dimen) {
        this.supply_dimen = supply_dimen;
    }

    public long getAvail_date() {
        return avail_date;
    }

    public void setAvail_date(long avail_date) {
        this.avail_date = avail_date;
    }

    // TODO: DB INSERT 처리
    public List<String> getOptions() {
        return options;
    }

    public void setOptions(String options) {
        List<String> optionList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(options, ";");

        while (stringTokenizer.hasMoreTokens()) {
            optionList.add(stringTokenizer.nextToken());
        }

        this.options = optionList;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public int getTemp_sys() {
        return temp_sys;
    }

    public void setTemp_sys(int temp_sys) {
        this.temp_sys = temp_sys;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
