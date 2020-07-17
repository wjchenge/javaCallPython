package wjchenge.demo;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * 使用Apache Commons Exec调用python脚本
 * @author wjchenge@qq.com
 */
public class CommonsExecDemo {
    public static void main(String[] args) throws IOException {
        String line = "python " + resolvePythonScriptPath("hello.py");
        CommandLine cmdLine = CommandLine.parse(line);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(streamHandler);
        int exitCode = executor.execute(cmdLine);
        System.out.println("执行状态, 成功为0 , 非0为失败，结果为 = " + exitCode);
        System.out.println("执行结果： " + outputStream.toString());
    }

    private static String resolvePythonScriptPath(String filename) {
        File file = new File("src/main/resources/" + filename);
        return file.getAbsolutePath();
    }
}
