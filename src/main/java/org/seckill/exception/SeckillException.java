package org.seckill.exception;

/**
 * 秒杀相关业务异常
 * @Author y55555a
 * Date on 2020/1/4  7:55
 */
public class SeckillException extends RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
