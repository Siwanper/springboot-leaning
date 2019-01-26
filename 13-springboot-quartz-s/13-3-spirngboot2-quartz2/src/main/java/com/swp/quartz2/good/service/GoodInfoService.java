package com.swp.quartz2.good.service;

import com.swp.quartz2.good.model.GoodInfoEntity;
import org.quartz.SchedulerException;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-24 11:33 AM
 */
public interface GoodInfoService {

    public Long saveGood(GoodInfoEntity goodInfoEntity) throws SchedulerException;

}
