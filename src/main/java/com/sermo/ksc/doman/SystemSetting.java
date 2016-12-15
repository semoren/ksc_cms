package com.sermo.ksc.doman;

import java.sql.Timestamp;

/**
 * @author sermo
 * @version 2016/12/15.
 */
public class SystemSetting {
    private String id;

    /**
     * 营业开始时间
     */
    private int bStart;

    /**
     * 营业结束时间
     */
    private int bEnd;

    /**
     * 送货开始时间
     */
    private int dStart;

    /**
     * 送货结束时间
     */
    private int dEnd;

    /**
     * 1-营业 0-歇业
     */
    private int state;

    private Timestamp time;

    /**
     * 用户协议
     */
    private String agreement;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getbStart() {
        return bStart;
    }

    public void setbStart(int bStart) {
        this.bStart = bStart;
    }

    public int getbEnd() {
        return bEnd;
    }

    public void setbEnd(int bEnd) {
        this.bEnd = bEnd;
    }

    public int getdStart() {
        return dStart;
    }

    public void setdStart(int dStart) {
        this.dStart = dStart;
    }

    public int getdEnd() {
        return dEnd;
    }

    public void setdEnd(int dEnd) {
        this.dEnd = dEnd;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }
}
