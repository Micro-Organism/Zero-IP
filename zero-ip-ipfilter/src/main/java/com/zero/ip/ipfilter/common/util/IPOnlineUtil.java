package com.zero.ip.ipfilter.common.util;

import com.zero.ip.ipfilter.domain.dto.CountryInfoDto;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class IPOnlineUtil {
    private static RestTemplate restTemplate;

    private final RestTemplate template;

    public static final String IP_API_URL = "http://ip-api.com/json/";

    public IPOnlineUtil(RestTemplate restTemplate) {
        this.template = restTemplate;
    }

    /**
     * init RestTemplate
     */
    @PostConstruct
    public void init() {
        setRestTemplate(this.template);
    }

    /**
     * init RestTemplate
     */
    private static void setRestTemplate(RestTemplate template) {
        restTemplate = template;
    }

    /**
     * get country by ip
     *
     * @param ip
     * @return
     */
    public static CountryInfoDto getCountryByIpOnline(String ip) {
        ResponseEntity<CountryInfoDto> entity = restTemplate.getForEntity(
                IP_API_URL + ip + "?lang=zh-CN",
                CountryInfoDto.class
        );
        return entity.getBody();


    }
}
