package org.seckill.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author y55555a
 * Date on 2020/1/4  10:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})

public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);

    }

    @Test
    public void getById() {
        long id = 1007;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }
//
//    @Test
//    public void exportSeckillUrl() {
//        long id = 1004;
//        Exposer exposer = seckillService.exportSeckillUrl(id);
//        logger.info("exposer={}", exposer);
//        //Exposer{
//        //exposed=true,
//        //md5='27296259d33703dd04dbd778f7ea13a4',
//        //seckillId=1004, now=0, start=0, end=0}
//    }
//
//    @Test
//    public void executeSeckill() {
//        long id = 1004;
//        long phone = 18729280315L;
//        String md5 = "27296259d33703dd04dbd778f7ea13a4";
//        SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
//        logger.info("result={}", execution);
//}
    @Test
    public void testSeckillLogic() throws Exception{
        long id = 1005;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer={}", exposer);
            long phone = 18729280315L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
                logger.info("result={}", execution);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            }
        } else {
            //秒杀未开启
            logger.warn("exposer={}", exposer);
        }
    }
}