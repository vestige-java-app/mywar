package mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class Hello extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("hello");
        writer.println(IOUtils.class);
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
