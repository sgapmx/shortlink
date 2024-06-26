public class ShardingSphereTableSQLGenerator {
    public static final String userTable =
            """
            CREATE TABLE `t_user_%d` (
              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
              `username` varchar(256) DEFAULT NULL COMMENT '用户名',
              `password` varchar(512) DEFAULT NULL COMMENT '密码',
              `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
              `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
              `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
              `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
              `update_time` datetime DEFAULT NULL COMMENT '修改时间',
              `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
              PRIMARY KEY (`id`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
            """;

    public static final String linkTable =
            """
            CREATE TABLE `t_link_%d` (
              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
              `domain` varchar(128) DEFAULT NULL COMMENT '域名',
              `short_uri` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
              `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
              `origin_url` varchar(1024) DEFAULT NULL COMMENT '原始链接',
              `click_num` int(11) DEFAULT NULL COMMENT '点击量',
              `gid` varchar(32) DEFAULT 'default' COMMENT '分组标识',
              `enable_status` tinyint(1) DEFAULT NULL COMMENT '启用标识 0：已启用 1：未启用',
              `created_type` tinyint(1) DEFAULT NULL COMMENT '创建类型 0：接口 1：控制台',
              `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：用户自定义',
              `valid_date` datetime DEFAULT NULL COMMENT '有效期',
              `describe` varchar(1024) DEFAULT NULL COMMENT '描述',
              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
              `update_time` datetime DEFAULT NULL COMMENT '修改时间',
              `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
              `total_pv` int(11) DEFAULT '0' COMMENT '历史PV',
              `total_uv` int(11) DEFAULT '0' COMMENT '历史UV',
              `total_uip` int(11) DEFAULT '0' COMMENT '历史UIP',
              PRIMARY KEY (`id`),
              UNIQUE KEY `idx_unique_full_short_url` (`full_short_url`) USING BTREE
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
            """;

    public static final String groupTable =
            """
            CREATE TABLE `t_group_%d` (
              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
              `gid` varchar(32) DEFAULT NULL COMMENT '分组标识',
              `name` varchar(64) DEFAULT NULL COMMENT '分组名称',
              `username` varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
              `sort_order` int(3) DEFAULT NULL COMMENT '分组排序',
              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
              `update_time` datetime DEFAULT NULL COMMENT '修改时间',
              `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
              PRIMARY KEY (`id`),
              UNIQUE KEY `idx_unique_username_gid` (`gid`,`username`) USING BTREE
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
            """;

    public static final String linkGoToTable =
            """
            CREATE TABLE `t_link_goto_%d` (
              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
              `gid` varchar(32) DEFAULT 'default' COMMENT '分组标识',
              `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
              PRIMARY KEY (`id`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
            """;

    public static final String linkStatsTodayTable =
            """
            CREATE TABLE `t_link_stats_today_%d` (
              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
              `gid` varchar(32) DEFAULT 'default' COMMENT '分组标识',
              `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
              `date` date DEFAULT NULL COMMENT '日期',
              `today_pv` int(11) DEFAULT '0' COMMENT '今日PV',
              `today_uv` int(11) DEFAULT '0' COMMENT '今日UV',
              `today_uip` int(11) DEFAULT '0' COMMENT '今日IP数',
              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
              `update_time` datetime DEFAULT NULL COMMENT '修改时间',
              `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
              PRIMARY KEY (`id`),
              UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`gid`,`date`) USING BTREE
            ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
            """;

    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.printf((linkStatsTodayTable) + "%n", i);
        }
    }
}
