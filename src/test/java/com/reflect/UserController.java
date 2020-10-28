package com.reflect;

public class UserController {
    @Autowired
    private UserService userService;

    private Integer integer;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
