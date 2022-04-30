package com.guozhe.practice.notify;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author guozhe
 */
@Data
public class FtNotifyResponse implements NotifyResponse {

    public static final int SUCCESS_CODE_NO = 0;

    @JsonProperty("pushid")
    private String pushId;

    @JsonProperty("readkey")
    private String readKey;

    private String error;

    private int errno;

}
