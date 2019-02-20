package com.swp.oauth2.service.impl;

import com.swp.oauth2.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-20 5:02 PM
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getWeatherWithCityName(String cityName) {
        // 请求连接
        String url = "http://wthrcdn.etouch.cn/weather_mini?city=" + cityName;
        // 请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity entity = new HttpEntity(headers);

        String body = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();

        return body;
    }
}
