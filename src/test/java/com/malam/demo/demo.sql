CREATE TABLE `access_ip_control_config` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标准ID' ,
`ip`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作ip' ,
`uri`  varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'http请求uri' ,
`access_count_duration`  bigint(20) NOT NULL DEFAULT 0 COMMENT '请求统计时间' ,
`access_count_max`  int(11) NOT NULL DEFAULT 0 COMMENT '最大请求数' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
COMMENT='IP访问控制'
AUTO_INCREMENT=7
ROW_FORMAT=COMPACT
;



INSERT INTO `access_ip_control_config` (`id`, `ip`, `uri`, `access_count_duration`, `access_count_max`) VALUES (1, '127.0.0.3', '/web/commJson/headerData', 10000, 10);
INSERT INTO `access_ip_control_config` (`id`, `ip`, `uri`, `access_count_duration`, `access_count_max`) VALUES (3, '127.0.0.4', '/', 1111, 11);
INSERT INTO `access_ip_control_config` (`id`, `ip`, `uri`, `access_count_duration`, `access_count_max`) VALUES (4, '127.0.0.1', '1481801224417', 1000, 100);
INSERT INTO `access_ip_control_config` (`id`, `ip`, `uri`, `access_count_duration`, `access_count_max`) VALUES (5, '127.0.0.1', '1481801251836', 1000, 100);
INSERT INTO `access_ip_control_config` (`id`, `ip`, `uri`, `access_count_duration`, `access_count_max`) VALUES (6, '127.0.0.1', '1481801271308', 1000, 100);
