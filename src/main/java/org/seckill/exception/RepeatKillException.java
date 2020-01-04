package org.seckill.exception;

import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;

/**
 * @Author y55555a
 * Date on 2020/1/4  7:54
 */
public class RepeatKillException extends SeckillException {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
