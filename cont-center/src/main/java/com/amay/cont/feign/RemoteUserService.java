package com.amay.cont.feign;

import com.amay.cont.entity.MyUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "user-center",configuration = AmayFeignConfiguration.class)
@FeignClient(name = "user-center")
public interface RemoteUserService {
    @GetMapping("myUser/selectOne/{userId}")
    MyUser selectOne(@PathVariable("userId") Integer userid);
}
