package mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.commons.io.IOUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {

    private static final long serialVersionUID = -8378070660296513701L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("hello");
        writer.println(Hello.class.getClassLoader().getResource(IOUtils.class.getName().replace('.', '/').concat(".class")));
        ClassLoader classLoader = IOUtils.class.getClassLoader();
        writer.println(System.identityHashCode(classLoader) + " " + classLoader);
        InputStream inputStream = Hello.class.getResourceAsStream("myresource.txt");
        if (inputStream != null) {
            try {
                writer.println(new BufferedReader(new InputStreamReader(inputStream)).readLine());
            } finally {
                inputStream.close();
            }
        }
    }

}
