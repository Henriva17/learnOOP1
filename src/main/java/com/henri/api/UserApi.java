package com.henri.api;

import com.henri.enums.Role;
import com.henri.model.User;
import com.henri.service.UserImplement;

/**
 * <blockquote><pre>
 * Author   : @Dountio
 * LinkedIn : @SidofDountio
 * GitHub   : @SidofDountio
 * Version  : V1.0
 * Email    : sidofdountio406@gmail.com
 * Since    : 3/25/26
 * </blockquote></pre>
 */


public class UserApi {

    private UserImplement  userImplement;
    User AMINA = new User();
    //User Mike = new User();

    public UserApi(UserImplement userImplement) {
        this.userImplement = userImplement;
    }


}
