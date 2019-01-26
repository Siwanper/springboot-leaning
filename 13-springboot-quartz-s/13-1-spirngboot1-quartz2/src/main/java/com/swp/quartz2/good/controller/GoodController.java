package com.swp.quartz2.good.controller;

import com.swp.quartz2.good.model.GoodInfoEntity;
import com.swp.quartz2.good.service.GoodInfoService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-24 11:54 AM
 */
@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodInfoService goodInfoService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Long save(GoodInfoEntity goodInfoEntity) throws SchedulerException {
        return goodInfoService.saveGood(goodInfoEntity);
    }

    @RequestMapping(value = "/seckill", method = RequestMethod.POST)
    public Long seckill(Long goodId) throws SchedulerException {
        return goodInfoService.seckillGood(goodId);
    }
}
