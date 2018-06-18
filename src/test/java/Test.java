import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2010-2017 Sanfangda team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>@description : PACKAGE_NAME</li>
 * <li>@version     : 1.0</li>
 * <li>@creation    : 2018年03月04日</li>
 * <li>@author     : fanrenqing</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
public class Test {

    public static void main(String[] args) {

        try {
            System.out.println("start");
            Process pr = Runtime.getRuntime().exec("python E:\\PycharmProjects\\thrift_demo\\python_client.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
