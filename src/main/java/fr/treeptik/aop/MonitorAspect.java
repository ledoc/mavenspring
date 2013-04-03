//package fr.treeptik.aop;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.JoinPoint.StaticPart;
//
//import fr.treeptik.model.Client;
//
//public class MonitorAspect {
//
//	public void before(JoinPoint joinpoint){ // dans JoinPoint, on a un tableau d'arguments passés à la méthode
//		
//		
//		Object[] objects=joinpoint.getArgs();
//		
//		if(objects[0] instanceof Client){
//			
//			Client client = (Client) objects[0];
//			System.out.println("Client + "+client.getName());
//		}
//		
//		System.out.println(joinpoint.getSignature().getClass());
//	}
//	
//	public void afterReturning(StaticPart staticPart, Object result){
//		System.out.println("after");
//			if(result instanceof Client){
//			
//			Client client = (Client) result;
//			System.out.println("Client + "+client.getId());
//			}
//		
//	}
//	
//	public void afterThrowing(Exception exception){
//		System.out.println("Exception : "+exception.getMessage());
//	}
//	
//	
//}
