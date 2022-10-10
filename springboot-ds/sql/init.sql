
drop table if exists order_detail;
drop table if exists order_master;
drop table if exists product_info;
-- 商品
create table `product_info`
(
    `product_id`          int(18) not null AUTO_INCREMENT comment '商品主键',
    `product_name`        varchar(64)  not null comment '商品名称',
    `product_price`       decimal(8,2) not null comment '单价',
    `product_description` varchar(256) comment '描述',
    `product_status`      tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
    `create_time`         timestamp    not null default current_timestamp comment '创建时间',
    `create_user`         varchar(10)  not null comment '创建人',
    `update_time`         timestamp    not null default current_timestamp on update current_timestamp comment '修改时间',
    `update_user`         varchar(10)  not null comment '修改人',
    PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 订单
create table `order_master`
(
    `order_id`     int(18) not null AUTO_INCREMENT comment '订单主键',
    `buyer_name`   varchar(32)  not null comment '买家名字',
    `buyer_phone`  varchar(32)  not null comment '买家电话',
    `order_amount` decimal(8,2) not null comment '总金额',
    `status`       tinyint(3) not null default '0' comment '订单状态',
    `create_time`  timestamp    not null default current_timestamp comment '创建时间',
    `create_user`  varchar(10)  not null comment '创建人',
    `update_time`  timestamp    not null default current_timestamp on update current_timestamp comment '修改时间',
    `update_user`  varchar(10)  not null comment '修改人',
    primary key (`order_id`),
    key            `idx_buyer_openid` (`buyer_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 订单详情
create table `order_detail`
(
    `detail_id`      int(18) not null AUTO_INCREMENT comment '详情主键',
    `order_id`       int(18) not null comment '订单主键',
    `product_id`     int(18) not null comment '商品主键',
    `product_name`   varchar(64)  not null comment '商品名称',
    `product_price`  decimal(8,2) not null comment '当前价格',
    `product_number` int          not null comment '数量',
    `create_time`    timestamp    not null default current_timestamp comment '创建时间',
    `create_user`    varchar(10)  not null comment '创建人',
    `update_time`    timestamp    not null default current_timestamp on update current_timestamp comment '修改时间',
    `update_user`    varchar(10)  not null comment '修改人',
    primary key (`detail_id`),
    key              `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `order_master`
VALUES ('1', 'bug生产车间员工', '15666666666', 200.00, 0, '2020-04-13 21:07:28', 'admin', '2020-04-13 13:08:20', 'admin');

INSERT INTO `order_detail`
VALUES ('1', '1', '1', '泡脚', 50.00, 1, '2020-04-13 21:09:50', 'admin', '2020-04-13 21:10:59', 'admin');
INSERT INTO `order_detail`
VALUES ('2', '1', '2', '中式推拿', 150.00, 1, '2020-04-13 21:09:50', 'admin', '2020-04-13 21:10:59', 'admin');

INSERT INTO `product_info`
VALUES ('1', '泡脚', 100.00, '中药泡脚加按摩', 0, '2020-04-13 21:05:04', 'admin', '2020-04-13 13:11:33', 'admin');
INSERT INTO `product_info`
VALUES ('2', '中式推拿', 150.00, '推拿60分钟', 0, '2020-04-13 21:05:04', 'admin', '2020-04-13 13:11:40', 'admin');
COMMIT;