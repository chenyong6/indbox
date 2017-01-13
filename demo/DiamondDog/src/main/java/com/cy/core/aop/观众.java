package com.cy.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
@Aspect
@Component("观众")
public class 观众 {

	@Pointcut("execution(* com.cy.core.service.aop.楼主able.play(..))")
	public void aspect() { // <co id="co_definePointcut"/>
	}
	/**
	 * and && or || not !
	 *
	 * args() 参数
	 * bean() bean
	 * @param str
	 */
	@Before("aspect() && args(str) ")
	public void takeSeats(JoinPoint joinPoint,String str) { // <co id="co_takeSeatsBefore"/>
		System.err.println("joinPoint: "+joinPoint);
		System.out.println("搬凳子."+str);
	}

	@Before("aspect()")
	public void turnOffCellPhones() { // <co id="co_turnOffCellPhonesBefore"/>
		System.out.println("The audience is turning off their cellphones");
	}

	@AfterReturning("aspect()")
	public void applaud() { // <co id="co_applaudAfter"/>
		System.out.println("CLAP CLAP CLAP CLAP CLAP");
	}

	@AfterThrowing("aspect()")
	public void demandRefund() { // <co id="co_demandRefundAfterException"/>
		System.out.println("Boo! We want our money back!");
	}
	@Around("aspect()")
	public void Around(ProceedingJoinPoint joinpoint) { // <co id="co_demandRefundAfterException"/>
		
		try {
			System.err.println("before around");
			joinpoint.proceed();
			System.err.println("after around");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
