package com.swp.quartz2.good.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 描述:
 * 商品信息
 *
 * @outhor ios
 * @create 2019-01-24 11:09 AM
 */

@Table(name = "basic_good_info")
@Entity
@Data
public class GoodInfoEntity {

    /**
     * 商品编号
     */
    @Id
    @GeneratedValue
    @Column(name = "bgi_id")
    private Long id;
    /**
     * 商品名称
     */
    @Column(name = "bgi_name")
    private String name;
    /**
     * 商品价格
     */
    @Column(name = "bgi_price")
    private BigDecimal price;
    /**
     * 商品单位
     */
    @Column(name = "bgi_unit")
    private String unit;

    // @Data 相当于setter getter toString

}
