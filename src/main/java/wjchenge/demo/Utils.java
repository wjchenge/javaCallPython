package wjchenge.demo;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 工具类
 * @author wjchenge@qq.com
 */
public class Utils {

    private Utils() {
    }

    public static String resolvePythonScriptPath(String filename) {
        File file = new File("src/main/resources/" + filename);
        return file.getAbsolutePath();
    }

    public static List<String> readProcessOutput(InputStream inputStream) throws IOException {
        try (BufferedReader output = new BufferedReader(new InputStreamReader(inputStream))) {
            return output.lines()
                    .collect(Collectors.toList());
        }
    }

    public static void listEngines() {
        ScriptEngineManager manager = new ScriptEngineManager();
        List<ScriptEngineFactory> engines = manager.getEngineFactories();

        for (ScriptEngineFactory engine : engines) {
            System.out.println("Engine name:" + engine.getEngineName());
            System.out.println("Version: " + engine.getEngineVersion());
            System.out.println("Language: " + engine.getLanguageName());

            System.out.println("Short Names:");
            for (String names : engine.getNames()) {
                System.out.println(names);
            }
        }
    }
}
