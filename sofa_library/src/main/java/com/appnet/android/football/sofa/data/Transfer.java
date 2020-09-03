package com.appnet.android.football.sofa.data;

public class Transfer {
    private int type;
    private long transferFee;
    private String transferFeeDescription;
    private long transferDateTimestamp;
    private Team from;
    private Team to;

    public int getType() {
        return type;
    }

    public long getTransferFee() {
        return transferFee;
    }

    public String getTransferFeeDescription() {
        return transferFeeDescription;
    }

    public long getTransferDateTimestamp() {
        return transferDateTimestamp*1000;
    }

    public Team getFrom() {
        return from;
    }

    public Team getTo() {
        return to;
    }
}
