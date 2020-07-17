package wjchenge.demo;

import java.io.IOException;
import java.util.List;

/**
 * 使用ProcessBuilder调用python脚本
 * @author wjchenge@qq.com
 */
public class ProcessBuilderDemo {

    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("python",
                Utils.resolvePythonScriptPath("hello.py"));
//        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        List<String> results = Utils.readProcessOutput(process.getInputStream());
        System.out.println("results = " + results);
        List<String> errMsg = Utils.readProcessOutput(process.getErrorStream());
        System.out.println("errMsg = " + errMsg);
    }

}
