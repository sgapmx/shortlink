package org.cloud.shortlink.project.dto.resp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 批量创建短链接时，返回的Excel的列信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortLinkBaseInfoRespDTO {

    /**
     * 描述信息
     */
    @ExcelProperty("标题")
    @ColumnWidth(40)
    private String describe;

    /**
     * 短链接
     */
    @ExcelProperty("短链接")
    @ColumnWidth(40)
    private String fullShortUrl;

    /**
     * 原始链接
     */
    @ExcelProperty("原始链接")
    @ColumnWidth(80)
    private String originUrl;
}
