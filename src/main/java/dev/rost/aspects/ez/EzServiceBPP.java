package dev.rost.aspects.ez;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
class EzServiceBPP implements BeanPostProcessor {

    private static final String ezServiceBeanName = "ezServiceImpl";
    private static EzInfo ezInfo;


    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (ezServiceBeanName.equals(beanName))
            ezInfo = new EzInfo(bean.getClass(), bean.getClass().getInterfaces());
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, String beanName) throws BeansException {
        if (beanName.equals("ezServiceImpl"))
            return Enhancer.create(ezInfo.clazz, ezInfo.interfaces, (MethodInterceptor) (obj, method, args, proxy) -> {
                System.out.println("EzService#proxyMethodInvocation");
                return proxy.invoke(bean, args);
            });

        return bean;
    }


    record EzInfo(Class<?> clazz, Class<?>[] interfaces) {}
}
