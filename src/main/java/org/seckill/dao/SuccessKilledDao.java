package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * @Author y55555a
 * Date on 2020/1/2  16:42
 */
public interface SuccessKilledDao {
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

//    /**
//     *
//     * @param seckillId
//     * @param userPhone
//     * @return
//     */
//    int insertSuccessKilled(long seckillId, long userPhone);

    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
//
//    /**
//     *
//     * @param seckillId
//     * @param userPhone
//     * @return
//     */
//    SuccessKilled queryByIdWithSeckill(long seckillId, long userPhone);
}
