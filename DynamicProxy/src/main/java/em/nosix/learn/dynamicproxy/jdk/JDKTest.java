package em.nosix.learn.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class JDKTest {
	
	/**
	 *
	 * 1、因为利用JDKProxy生成的代理类实现了接口，所以目标类中所有的方法在代理类中都有。 
	   2、生成的代理类的所有的方法都拦截了目标类的所有的方法。而拦截器中invoke方法的内容正好就是代理类的各个方法的组成体。 
	   3、利用JDKProxy方式必须有接口的存在。 
	   4、invoke方法中的三个参数可以访问目标类的被调用方法的API、被调用方法的参数、被调用方法的返回类型。
	 */
    public static void main(String[] args) { 
		UserService userService = new UserServiceImpl();  
		InvocationHandler invocationHandler = new UserServiceHandler(userService); 
		UserService userServiceProxy = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),  
                userService.getClass().getInterfaces(), invocationHandler);  
        System.out.println(userServiceProxy.getName());  
        System.out.println(userServiceProxy.getAge());  
	}

}
interface UserService {
	String getName();
	String getAge();
}
class UserServiceImpl implements UserService{

	@Override
	public String getName() {
		System.out.println("----getName----");
		return "nosix";
	}

	@Override
	public String getAge() {
		System.out.println("----getAge----");
		return "18";
	}
}

class UserServiceHandler implements InvocationHandler {

	private Object target;
	public UserServiceHandler() {
		super();
	}
	public UserServiceHandler(Object target) {
		this.target = target;
	}
	@Override
	public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
		if("getName".equals(method.getName())) {
			System.out.println("++++++before " + method.getName() + "++++++");  
            Object result = method.invoke(target, args);  
            System.out.println("++++++after " + method.getName() + "++++++");  
            return result;  
		} else {
			 Object result = method.invoke(target, args);  
	            return result; 
		}
	}
	
}


