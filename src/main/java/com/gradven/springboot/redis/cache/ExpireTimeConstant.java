package com.gradven.springboot.redis.cache;

/**
 * Created by liuhangjun on 2017/9/7.
 */
public interface ExpireTimeConstant {
    
    Long NONE = 0L; // "无固定期限"
    
    
    Long ONE_SEC = 1L; // "1秒钟"
    
    
    Long FIVE_SEC = 5L;  //  "5秒钟"
    
    Long TEN_SEC = 10L;  //  "10秒钟"
    
    
    Long HALF_A_MIN = 30L;  //  "30秒钟"
    
    
    Long ONE_MIN = 60L;  //  "1分钟"
    
    
    Long FIVE_MIN = 5 * 60L;  //  "5分钟"
    
    
    Long TEN_MIN = 10 * 60L;  //  "10分钟"
    
    
    Long TWENTY_MIN = 20 * 60L;  //  "20分钟"
    
    
    Long HALF_AN_HOUR = 30 * 60L;  //  "30分钟"
    
    
    Long ONE_HOUR = 60 * 60L;  //  "1小时"
    
    
    Long SIX_HOUR = 6 * 60 * 60L;  //  "6小时"
    
    
    Long TWELVE_HOUR = 12 * 60 * 60L;  //  "12小时"
    
    
    Long ONE_DAY = 24 * 60 * 60L;  //  "1天"
    
    
    Long ONE_MON = 30 * 24 * 60 * 60L;  //  "1个月"
    
    
    Long ONE_YEAR = 365 * 24 * 60 * 60L;  //  "1年"
    
}
