package org.cloud.shortlink.project.dto.resp;

import lombok.Data;

@Data
public class ShortLinkGroupCountRespDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 短链接数量
     */
    private Integer shortLinkCount;
}
