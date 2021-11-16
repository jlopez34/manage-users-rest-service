package com.nisum.manage.users.model;

import com.nisum.manage.users.entity.Phone;
import com.opengamma.strata.collect.ArgChecker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@AllArgsConstructor
public class PhoneRequest {
    public String number;
    public String cityCode;
    public String countryCode;

    public PhoneRequest() {
    }

    public Phone toEntity() {
        Phone phone = new Phone();
        BeanUtils.copyProperties(this, phone);
        return phone;
    }

    public static PhoneRequest of(Phone phone) {
        ArgChecker.notNull(phone, "phone");
        PhoneRequest dto = new PhoneRequest();
        BeanUtils.copyProperties(phone, dto);
        return dto;
    }
}
