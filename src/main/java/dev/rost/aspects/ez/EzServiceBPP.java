package dev.rost.aspects.ez;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;



@Component
class EzServiceBPP implements BeanPostProcessor {


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return beanName.equals("ezService")
                ? Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("EzService#proxyMethodInvocation");
                    return method.invoke(bean, args);
                }
                : bean;
    }
}
