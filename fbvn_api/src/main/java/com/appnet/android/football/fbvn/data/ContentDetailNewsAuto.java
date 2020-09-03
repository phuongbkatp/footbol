package com.appnet.android.football.fbvn.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ContentDetailNewsAuto {
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("link")
    @Expose
    private String linkImg;
    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("tableHead")
    @Expose
    private List<String> rowHeaderList;
    @SerializedName("tableRow")
    @Expose
    private List<List<String>> cellList;

    @SerializedName("head")
    @Expose
    private boolean head;

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public List<ColumnHeader> getRowHeaderList() {
        List<ColumnHeader> list = new ArrayList<>();
        for (String header : rowHeaderList) {
            list.add(new ColumnHeader(header));
        }
        return list;
    }


    public List<List<Cell>> getCellList() {
        int x = cellList.size();
        List<List<Cell>> list = new ArrayList<>(x);
        for (int i = 0 ; i < cellList.size(); i++) {
            List<String> list1 = cellList.get(i);
            List<Cell> temp = new ArrayList<>();
            String cell = "";
            for (int j = 0; j < list1.size(); j++) {
                 cell = list1.get(j);
                temp.add(new Cell(cell));
            }
            //list.get(i).add(new Cell(cell));
            list.add(temp);
        }

        return list;
    }

    public boolean isHead() {
        return head;
    }

    public void setHead(boolean head) {
        this.head = head;
    }
}
