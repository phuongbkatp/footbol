package com.appnet.android.football.sofa.data;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TableRowsData {
    private String name;
    private List<TableRow> tableRows;
    private LinkedHashMap<Integer, Promotion> promotions;
    private transient List<Integer> promotionKeys;

    public List<TableRow> getTableRows() {
        return tableRows;
    }

    public String getName() {
        return name;
    }

    public HashMap<Integer, Promotion> getPromotions() {
        return promotions;
    }

    public List<Integer> getPromotionKeys() {
        if(promotionKeys == null) {
            promotionKeys = new ArrayList<>();
            if(promotions != null) {
                for(Map.Entry<Integer, Promotion> entry : promotions.entrySet()){
                    if(!"Relegation".equalsIgnoreCase(entry.getValue().getName())) {
                        promotionKeys.add(entry.getKey());
                    }
                }
            }
            Collections.sort(promotionKeys);
        }
        return promotionKeys;
    }
}
