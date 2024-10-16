package ticket;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TicketTest {
    public static void main(String[] args) {
       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/ticket/lifecycle.xml");
//      ApplicationContext로도 받을 수 있음
//       ApplicationContext ctx = 
//    		   new ClassPathXmlApplicationContext("classpath:/springbasic/lifecycle.xml");

      
       Ticket ticket = (Ticket) ctx.getBean("ticket");
       System.out.println(ticket);
       ctx.close();
    }
}
