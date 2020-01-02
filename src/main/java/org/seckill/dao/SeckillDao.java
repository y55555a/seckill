package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * @Author y55555a
 * Date on 2020/1/2  16:39
 */
public interface SeckillDao {
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
    //    /**
//     *
//     * @param seckillId
//     * @param killTime
//     * @return
//     */
//    int reduceNumber(long seckillId, Date killTime);
//
    Seckill queryById(long seckillId);
    //
//    /**
//     *
//     * @param seckillid
//     * @return
//     */
//    Seckill queryById(long seckillid);
//
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
/*

    /**
     *
     * @param offset
     * @param limit
     * @return
     * /
    List<Seckill> queryAll(int offset, int limit);
*/
}
