package com.itbank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 스프링 4에서는 extends HandlerInterceptorAdapter
// 스프링 5에서는 implements HandlerInterceptor
// HandlerInterceptor는 인터페이스이지만, 내부 함수가 default 키워드로 처리되어 있다
// 인터페이스에서 default 함수는 바디를 가질 수 있다
// 미구현된 메서드만 구현하면 된다.
// 추상 메서드가 아니라서 모든 메서드를 의무적으로 오버라이딩 할 필요는 없다

public class LoginInterceptor implements HandlerInterceptor{
	// 1.preHandler : 요청이 컨트롤러의 함수(Handler)에 도달하기 전에 작동
	// 2.postHandle : 요청이  컨트롤러의 함수(Handler)에 도달하여 실행된 이후 view(jsp)로 넘어가기 전에 작동한다
	// 3.afterCompletion :요청이 컨트롤러의 함수(Handler)에 도달하여 view(jsp)가 실행이 된 이후 작동한다
	
	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// preHandler : 요청이 컨트롤러에 도착하기 전에 요청을 가로채서 작업을 수행한다
		// 반환값에 따라 예정된 내용을 그대로 처리할지, 다른 내용을 수행할지 결정한다
		// (참, 거짓)으로 판별
		System.out.println("1.preHandle");
		HttpSession session = request.getSession();	
	
		String url = request.getRequestURL().toString();
		System.out.println("url : " + url);
		
		if(session.getAttribute("login") == null) {			// 만약 세션에 로그인이 없으면
			String cpath = request.getContextPath();
			response.sendRedirect(cpath + "/member/login?url=" + url);	// 멤버에 로그인으로 이동
			System.out.println("로그인상태가 아니므로, 로그인 페이지로 이동합니다\n");
			return false;									// 진행을 중단한다 // controller 함수를 실행하지 않음
		}	
		return true;										// 계속 진행 	// controller 함수를 실행
	}
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
		// JSP 페이지에 넘겨 줄수있다	
		// 컨트롤러의 처리가 끝났고, JSP로 넘어가기 전에 작동한다
		// JSP로 forward가 이루어지기 전에, request, cookie, session 등에서 필요한 값을 확인하고 판별하여
		// ModelAndView를 이용하여 특정 데이터를 넣어주는데 활용할 수 있다
		// header.jsp를 사용할 수도 있지만, 모든 페이지에 영향을 주기 때문에 일부 페이지에만 적용하기 쉽지 않다
		System.out.println("2. postHandle");
		mav.addObject("test1", "Hello, Interceptor");
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 사용자에게 JSP의 화면이 모두 전달되고 응답이 완료된 후 작동한다
		// 만약, 예외가 발생했다면 혹은, 예외가 특정 타입의 예외라면 로그에 기록하거나 알림을 처리할 수 있다
		// @ExceptionHandler, @ControllerAdvice 가 예외를 처리하는데 특화되어 있다
		// Log4j와 같은 로그 라이브러리가 있다
		// 그렇기에 그다지 사용하지 않는다
		System.out.println("3. afterCompletion");
	}
	
	
	
	
	
}
