package com.lzx.spring;

public class TestMain {

    public static void main(String[] args) throws Exception {
        // xml配置读取
//        ClassPathXmlApplicationContext context
//                = new ClassPathXmlApplicationContext("spring/spring-study.xml");
//        TestService serviceImpl = (TestService) context.getBean("serviceImpl1");
//        serviceImpl.print();

        // java配置读取
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
//        TestService bean = applicationContext.getBean(TestServiceImpl2.class);
//        bean.print();

        // aop配置使用
//        System.out.println("========aop one======");
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
//        AopTest aopTest = applicationContext.getBean(AopTest.class);
//        aopTest.print();
//        System.out.println("========aop two======");
//        BookOperation book = applicationContext.getBean(BookOperation.class);
//        book.insert();

//        System.out.println("======AOP JDBC========");
//        EmployeeDAO dao = applicationContext.getBean(EmployeeDAO.class);
//
//        List<Employee> employees = dao.selectAll();
//        System.out.println(employees.size());

        // System.out.println(dao.insert());

    }
}
