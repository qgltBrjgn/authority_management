package com.qglt.test.aop;

import com.qglt.test.annotation.RequestPermission;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.List;

@Component
@Aspect
public class PermissionAdaptor {
    //准备session
    @Autowired
    private HttpSession httpSession;
    //通知切入点
    @Pointcut("@annotation(com.qglt.test.annotation.RequestPermission)")
    public void cut(){}
    //环绕切入
    @Around("cut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        //获取切入点方法签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        //获取方法
        Method method = methodSignature.getMethod();
        //获取方法权限
        RequestPermission permission = method.getAnnotation(RequestPermission.class);
        //获取方法权限码
        String aclValue = permission.aclValue();
        //获取session中的权限码
        List<String> permissions = (List<String>) httpSession.getAttribute("permissions");
        System.out.println("===========");
        System.out.println(permissions.toString());
        System.out.println("===========");
        //验证从session中获取的权限码列表中是否包含当前获取方法的权限码
        if (CollectionUtils.isEmpty(permissions)||permissions == null||!permissions.contains(aclValue)){
            //没有当前方法权限码则抛运行异常
            throw new RuntimeException("没有权限");
        }
        //有当前方法权限码则继续进行
        result = pjp.proceed();
        return result;
    }
}
