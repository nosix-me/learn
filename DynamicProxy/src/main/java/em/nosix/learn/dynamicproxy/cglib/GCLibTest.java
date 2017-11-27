package em.nosix.learn.dynamicproxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;


class SubClass implements MethodInterceptor {
	
	/**
	 * cglib动态代理
		1、 CGlib是一个强大的,高性能,高质量的Code生成类库。它可以在运行期扩展Java类与实现Java接口。 
		2、 用CGlib生成代理类是目标类的子类。 
		3、 用CGlib生成 代理类不需要接口 
		4、 用CGLib生成的代理类重写了父类的各个方法。 
		5、 拦截器中的intercept方法内容正好就是代理类中的方法体
	 */
	//代理类需要代理的方法
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		
		System.out.println("MethodInterceptor start..."); 
		proxy.invokeSuper(obj,args); 
		System.out.println("MethodInterceptor ending..."); 
        
		return null;
	}

}

//被代理的类
class SuperClass {
	
	public void hello(String name) {
		System.out.println("hello, " + name);
	}
	
	public void bye(String name) {
		System.out.println("bye, " + name);
	}
}

//过滤器-只对被代理类的bye()方法进行增强
class ProxyFilter implements CallbackFilter{  
	
	@Override
    public int accept(Method arg0) {  
        if("bye".equalsIgnoreCase(arg0.getName())) {
        	return 0;  
        } 
        return 1;  
    }  
  
}

public class GCLibTest {
	
	public static void main(String args[]) {
		
		Enhancer enhancer = new Enhancer(); 
        enhancer.setSuperclass(SuperClass.class); //设置被代理的类
        enhancer.setCallbacks(new Callback[]{new SubClass(),NoOp.INSTANCE}); //根据SubClass中的实现对方法进行增强
        enhancer.setCallbackFilter(new ProxyFilter()); //使用过滤器
        SuperClass create = (SuperClass)enhancer.create();
        
        create.hello("ken");
        
        //使用enhancer产生的代理类不需要修改SuperClass类中的代码，就可以对bye()进行增强
        create.bye("ken"); 
	}
}