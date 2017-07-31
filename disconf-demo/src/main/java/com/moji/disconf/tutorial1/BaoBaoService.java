package com.moji.disconf.tutorial1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moji.disconf.config.Coefficients;

/**
 * 金融宝服务，计算一天赚多少钱
 *
 * @version 2014-5-16
 */
@Service
public class BaoBaoService {

    protected static final Logger LOGGER = LoggerFactory
            .getLogger(BaoBaoService.class);

    @Autowired
    private Coefficients coefficients;

    /**
     *
     *
     * @return
     */
    public double calcMoney() {
        return 10000 * coefficients.getDiscount();
    }

}