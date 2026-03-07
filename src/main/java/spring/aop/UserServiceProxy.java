package spring.aop;

/**
 * UserService 目标对象
 * UserServiceProxy 代理对象
 */
public class UserServiceProxy extends UserService{

    /** 目标对象 也就是通过UserService类推断构造方法实例化出来的对象，进行了依赖注入、初始化等步骤的对象*/
    UserService target;

    @Override
    void test() {
        // 执行 @Before
        target.test();
        // 执行 @After
    }
}


class UserService{

    void test(){
        System.out.println("UserService.test()");
    }
}