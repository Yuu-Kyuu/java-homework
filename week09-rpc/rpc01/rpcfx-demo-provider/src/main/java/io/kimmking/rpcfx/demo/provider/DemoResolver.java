package io.kimmking.rpcfx.demo.provider;

import io.kimmking.rpcfx.api.RpcfxResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DemoResolver implements RpcfxResolver, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object resolve(String serviceClass) {
        //所谓的反射
        try {
            Class<?> serviceClazz = Class.forName(serviceClass);
            return applicationContext.getBean(serviceClazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
        //return this.applicationContext.getBean(serviceClass);
    }
}
