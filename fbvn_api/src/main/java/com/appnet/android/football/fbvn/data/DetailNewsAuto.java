package com.appnet.android.football.fbvn.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailNewsAuto {
    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("meta")
    @Expose
    private MetaDetailNewsAuto metaDetailNewsAuto;

    @SerializedName("content")
    @Expose
    private List<ContentDetailNewsAuto> contentDetailNewsAuto;

    public String getSource() {
        return source;
    }

    public MetaDetailNewsAuto getMetaDetailNewsAuto() {
        return metaDetailNewsAuto;
    }

    public List<ContentDetailNewsAuto> getContentDetailNewsAuto() {
        return contentDetailNewsAuto;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setMetaDetailNewsAuto(MetaDetailNewsAuto metaDetailNewsAuto) {
        this.metaDetailNewsAuto = metaDetailNewsAuto;
    }

    public void setContentDetailNewsAuto(List<ContentDetailNewsAuto> contentDetailNewsAuto) {
        this.contentDetailNewsAuto = contentDetailNewsAuto;
    }
}
