package com.rolosdev.seminarioproject.entity.entityHelp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaptchaResponse{
    private boolean success;
    private String hostname;
    private String challenge_ts;
    
    @JsonProperty("error-codes")
    private String[] errorcodes;

    public String[] getErrorcodes() {
        return errorcodes;
    }
    public void setErrorcodes(String[] errorcodes) {
        this.errorcodes = errorcodes;
    }
    public String getHostname() {
        return hostname;
    }
    public String getChallenge_ts() {
        return challenge_ts;
    }
    public void setChallenge_ts(String challenge_ts) {
        this.challenge_ts = challenge_ts;
    }
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
    public boolean isSucess() {
        return success;
    }
    public void setSucess(boolean sucess) {
        this.success = sucess;
    }
    
}
