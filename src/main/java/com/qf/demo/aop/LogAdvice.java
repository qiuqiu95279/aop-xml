package com.qf.demo.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//拦截器
public class LogAdvice {
    /**
     * 前置通知
     * @param jp
     */
    public void before(JoinPoint jp){
        //获取被拦截下来的方法名称
        String name = jp.getSignature().getName();
        System.out.println(name+"这个方法开始执行了..");
    }

    /**
     * 后置通知
     * @param jp
     */
    public void after(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name+"这个方法结束了.");
    }

    /**
     * 异常通知 被拦截方法抛出异常时触发
     * 这里的参数类型就表示 能被捕获的参数类型
     * @param jp
     * @param e
     */
    public void ex(JoinPoint jp,Exception e){
        String name = jp.getSignature().getName();
        int a=1/0;
        //getMessage()获取异常
        System.out.println(name+"这个方法抛出了"+e.getMessage()+"异常");
    }

    /** 返回通知
     *  返回通知不管是不是void都会返回 如果是viod则返回null  此void指minus()方法中的void
     *  如果返回值的类型和你增强方法中的类型不一致则不返回 通常增强方法用 objcet则表示所有返回类型都返回  包括void
     * @param jp
     * @param o
     */
    public void returning(JoinPoint jp,Object o){
        String name = jp.getSignature().getName();
        System.out.println(name+"这是这个方法的返回结果为"+o);


    }

    /**
     * 环绕通知
     *
     *   //proceed()方法之前的为前置通知
     * @param pjp
     * @return
     */
    public Object around(ProceedingJoinPoint pjp){
        try {
            System.out.println("前置通知");
            //表示让目标方法继续向下执行
            //类似于 Object result= method.invoke(o,args)
            Object proceed = pjp.proceed();//这个的返回值就是返回通知
            System.out.println("后置通知");
            return proceed;
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("异常通知");
        }
        return null;

    }
}
