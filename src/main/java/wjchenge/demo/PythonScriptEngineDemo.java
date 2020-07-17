package wjchenge.demo;

import org.python.core.Options;

import javax.script.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

/**
 * 使用JSR-223脚本引擎调用python脚本
 * @author wjchenge@qq.com
 */
public class PythonScriptEngineDemo {

    public static void main(String[] args) throws IOException, ScriptException {
        StringWriter writer = new StringWriter();
        ScriptContext context = new SimpleScriptContext();
        context.setWriter(writer);

        ScriptEngineManager manager = new ScriptEngineManager();
        Options.importSite = false;
        ScriptEngine engine = manager.getEngineByName("python");
        engine.eval(new FileReader(Utils.resolvePythonScriptPath("hello.py")), context);
        System.out.println("执行结果: " + writer.toString());
    }


}
