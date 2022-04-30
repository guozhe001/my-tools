package com.guozhe.practice.notify;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author guozhe
 */
@Data
@AllArgsConstructor
public class FtNotifyRequest implements NotifyRequest {
    /**
     * 标题
     */
    private String title;
    /**
     * 通知内容
     */
    private String desp;
}
