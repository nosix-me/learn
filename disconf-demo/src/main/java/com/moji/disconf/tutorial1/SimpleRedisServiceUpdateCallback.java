package com.moji.disconf.tutorial1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.moji.disconf.util.SpringContextUtil;
import com.moji.disconf.config.Coefficients;

/**
 * 更新Redis配置时的回调函数
 *
 */
@Service
@Scope("singleton")
@DisconfUpdateService(classes={JedisConfig.class},itemKeys = { Coefficients.key })
public class SimpleRedisServiceUpdateCallback implements IDisconfUpdate {

    protected static final Logger LOGGER = LoggerFactory.getLogger(SimpleRedisServiceUpdateCallback.class);

    /**
     *
     */
    public void reload() throws Exception {
    	  LOGGER.info("############reloaded#############");
    	  SimpleRedisService simpleRedisService = SpringContextUtil.getApplicationContext().getBean("simpleRedisService", SimpleRedisService.class);
          simpleRedisService.changeJedis();
    }

}