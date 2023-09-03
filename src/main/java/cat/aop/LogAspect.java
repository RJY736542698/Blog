package cat.aop;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 这是一个演示AOP编程用的切面,实现AOP编程,可以在这里进行全局的日志处理,或进行一些全局统计,等等
 * 注意,要在springmvc-xml 配置  <aop:aspectj-autoproxy  /> ,还要配置 log4j.properties
 */
@Aspect @Component  
public class LogAspect {
	 Logger log=Logger.getLogger(LogAspect.class);

	@Pointcut("execution(* cat.controller.*.*(..))")  //切入点
	private void anyMethodAAA() {}

	@Around("anyMethodAAA()")
	public Object aroundMethod(ProceedingJoinPoint point) {
		Object result=null;
		
		log.trace("环绕通知: 前置通知触发了,并在这里记录了日志");
		String methodName=point.getSignature().getName();
		log.info("当前被拦到的方法是:"+methodName);
		
		try {
			result = point.proceed();
		}
		catch(Throwable ex) {
			log.error("环绕通知: 例外通知触发了,并在这里记录了日志");
			ex.printStackTrace();
		}
		finally {
			log.info("环绕通知: 最终通知触发了,并在这里记录了日志");
		}
		
		log.info("环绕通知: 后置通知触发了,并在这里记录了日志");
		
		return  result;
	}
}

/* 附: 下面是log4j日志的格式:
		%n- 换行
		%m - 日志内容
		%p - 日志级别(FATAL, ERROR, WARN, INFO, DEBUG or custom)
		%r - 程序启动到现在的毫秒数
		%% - percent sign in output
		%t - 当前线程名
		%d - 日期和时间，常用的格式有 %d{DATE}, %d{ABSOLUTE}, %d{HH:mm:ss,SSS},
		%F - java源文件名
		%L - java源码行数
		%C - java类名,%C{1} 输出最后一个元素
		%M-java方法名
		%l - 同 %F%L%C%M
*/


