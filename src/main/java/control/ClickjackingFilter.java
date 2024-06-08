package control;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClickjackingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Aggiungi gli header anti-clickjacking
        httpResponse.setHeader("X-Frame-Options", "DENY"); // Impedisce il framing di pagine
        httpResponse.setHeader("Content-Security-Policy", "frame-ancestors 'none'"); // Non permette il framing da nessuna origine

        chain.doFilter(request, response);
    }

    // Implementazioni degli altri metodi dell'interfaccia Filter
}
