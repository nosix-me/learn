package com.moji.disconf.tutorial1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 演示分布式配置文件、分布式配置的更新Demo
 *
 */
@Service
public class DisconfDemoTask {

    protected static final Logger LOGGER = LoggerFactory
            .getLogger(DisconfDemoTask.class);

    @Autowired
    private SimpleRedisService simpleRedisService;
    @Autowired
    private BaoBaoService baoBaoService;

    @Autowired
    private JedisConfig jedisConfig;

    private static final String REDIS_KEY = "disconf_key";

    /**
     *
     */
    public int run() {

        try {

            while (true) {
                System.out.println(simpleRedisService.getKey(REDIS_KEY) +"##"+baoBaoService.calcMoney());
                LOGGER.info(("redis( " + jedisConfig.getHost() + ","
                        + jedisConfig.getPort() + ")  get key: " + REDIS_KEY));
                Thread.sleep(1000);
                
            }
        } catch (Exception e) {

            LOGGER.error(e.toString(), e);
        }

        return 0;
    }
}