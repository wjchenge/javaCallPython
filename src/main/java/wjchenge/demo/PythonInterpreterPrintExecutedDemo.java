package wjchenge.demo;

import org.python.util.PythonInterpreter;

import java.io.StringWriter;
import java.util.Properties;

/**
 * 使用PythonInterpretor直接嵌入脚本语言
 * @author wjchenge@qq.com
 */
public class PythonInterpreterPrintExecutedDemo {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("python.import.site", "false");
        PythonInterpreter.initialize(System.getProperties(), props, null);
        try (PythonInterpreter pyInterp = new PythonInterpreter()) {
            StringWriter output = new StringWriter();
            pyInterp.setOut(output);
            pyInterp.exec("print('Hello jython')");
            System.out.println("执行结果: " + output.toString());
        }
    }
}
