package org.cloud.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.cloud.shortlink.project.dao.entity.ShortLinkNetworkStatsDO;

/**
 * 访问网络监控持久层
 */
public interface ShortLinkNetworkStatsMapper extends BaseMapper<ShortLinkNetworkStatsDO> {

    /**
     * 记录访问设备监控数据
     */
    @Insert(
        """
        INSERT INTO t_link_network_stats (full_short_url, gid, date, cnt, network, create_time, update_time, del_flag)
        VALUES (#{shortLinkNetworkStats.fullShortUrl}, #{shortLinkNetworkStats.gid}, #{shortLinkNetworkStats.date}, #{shortLinkNetworkStats.cnt}, #{shortLinkNetworkStats.network}, NOW(), NOW(), 0)
        ON DUPLICATE KEY UPDATE
        cnt = cnt +  #{shortLinkNetworkStats.cnt};
        """
    )
    void shortLinkNetworkStats(@Param("shortLinkNetworkStats") ShortLinkNetworkStatsDO shortLinkNetworkStatsDO);
}
