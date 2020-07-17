package wjchenge.demo;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.util.Properties;

/**
 * 使用PythonInterpretor类访问变量的值
 * @author wjchenge@qq.com
 */
public class PythonInterpreterNumbersAddedDemo {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("python.import.site", "false");
        PythonInterpreter.initialize(System.getProperties(), props, null);
        try (PythonInterpreter pyInterp = new PythonInterpreter()) {
            pyInterp.exec("x = 10 + 10");
            PyObject x = pyInterp.get("x");
            System.out.println("执行结果: " + x.asInt());
        }
    }
}
