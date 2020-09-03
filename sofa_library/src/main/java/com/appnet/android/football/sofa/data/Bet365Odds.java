package com.appnet.android.football.sofa.data;

import java.util.List;

public class Bet365Odds {
    private List<OddsItem> live;
    private String name;
    private List<OddsItem> regular;
    private String sourceId;

    public String getSourceId() {
        return this.sourceId;
    }

    public List<OddsItem> getRegular() {
        return this.regular;
    }

    public List<OddsItem> getLive() {
        return this.live;
    }

    public String getName() {
        if (this.name == null) {
            this.name = "";
        }
        return this.name;
    }
}
