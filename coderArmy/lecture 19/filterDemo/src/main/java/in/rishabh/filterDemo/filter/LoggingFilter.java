package in.rishabh.filterDemo.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain)

            throws IOException, ServletException 
    {
        System.out.println("Loggin Filter started");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Loggin Filter finished");
    }

}
