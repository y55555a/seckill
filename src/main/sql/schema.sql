CREATE DATABASE seckill;
use seckill;
CREATE  TABLE  seckill(
seckill_id bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
name VARCHAR (120) NOT NULL COMMENT'商品名称',
number INT NOT NULL COMMENT'库存数量',
start_time TIMESTAMP NOT NULL COMMENT'秒杀开启时间',
end_time TIMESTAMP NOT NULL COMMENT'秒杀结束时间',
create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT'创建时间',
PRIMARY KEY (seckill_id),
KEY  idx_start_time(start_time),
KEY idx_end_time(end_time),
KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表'

insert into seckill(name,number,start_time,end_time)
VALUES
  ('1000元秒杀iphone',100,'2018-5-11 00:00:00','2030-5-23 00:00:00'),
  ('500元秒杀ipad',200,'2018-5-11 00:00:00','2030-5-23 00:00:00'),
  ('300元秒杀小米',300,'2030-5-11 00:00:00','2033-5-23 00:00:00'),
  ('100元秒杀红米',100,'2018-5-11 00:00:00','2019-5-23 00:00:00');

CREATE TABLE success_killed(
seckill_id bigint  NOT NULL COMMENT'秒杀商品id',
user_phone bigint  NOT NULL COMMENT'用户手机号',
state tinyint  NOT NULL DEFAULT -1 COMMENT'状态标识：-1无效，0成功,1已付款，2已发货',
create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT'创建时间',
PRIMARY KEY (seckill_id,user_phone),
KEY  idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表'

