package org.cloud.shortlink.admin.dto.req;

import lombok.Data;

/**
 * 回收站移除功能
 */
@Data
public class RecycleBinClearReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}
