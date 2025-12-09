package com.example.testdemo;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author fanqibin
 * @date 2022/5/18
 * @project dbcloud-modules-btadmin
 */

public enum OpenType {
    ENT("企业", "BaseConstants.ACCOUNT_DOMAIN_BAITEN"),
    SCHOOL("高校", "BaseConstants.ACCOUNT_DOMAIN_BAITEN"),
    PLATFORM337_ENT("337企业", "BaseConstants.ACCOUNT_DOMAIN_BAITEN"),
    PLATFORM337_GOV("337政府", "BaseConstants.ACCOUNT_DOMAIN_BAITEN"),
    THIRD("第三方机构", "BaseConstants.ACCOUNT_DOMAIN_THIRD"),
    ;
    private String value;
    private String domain;

    OpenType(String value, String domain) {
        this.value = value;
        this.domain = domain;
    }

    public static void main(String[] args) {

        String currentYear = LocalDate.now().getYear() + "-01-01";
        System.out.println(currentYear);

    }
}
