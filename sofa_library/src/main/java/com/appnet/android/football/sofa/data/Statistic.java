package com.appnet.android.football.sofa.data;

import java.util.List;

public class Statistic {
    private List<Period> periods;

    public List<Period> getPeriods() {
        return periods;
    }

    public Period getAll() {
        if(periods == null || periods.size() == 0) {
            return null;
        }
        for(Period period : periods) {
            if("ALL".equalsIgnoreCase(period.getPeriod())) {
                return period;
            }
        }
        return null;
    }

    public static class Period {

        private String period;
        private List<Group> groups;

        public String getPeriod() {
            return period;
        }

        public List<Group> getGroups() {
            return groups;
        }
    }

    public static class Group {
        private String groupName;
        private List<Item> statisticsItems;

        public String getGroupName() {
            return groupName;
        }

        public List<Item> getStatisticsItems() {
            return statisticsItems;
        }
    }

    public static class Item {
        private String name;
        private String home;
        private String away;
        private int compareCode;

        public String getName() {
            return name;
        }

        public String getHome() {
            return home;
        }

        public String getAway() {
            return away;
        }

        public int getCompareCode() {
            return compareCode;
        }
    }
}
