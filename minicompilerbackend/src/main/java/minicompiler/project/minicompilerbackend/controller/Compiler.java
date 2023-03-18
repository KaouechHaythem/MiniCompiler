package minicompiler.project.minicompilerbackend.controller;

import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController()
@RequestMapping("api/v1/compiler")
public class Compiler {
    @PostMapping("/compile")
    public String executeCommand(@RequestBody(required = false) String content) {
        if (content!=null) {
            String command = "C:\\Users\\ASUS\\Desktop\\Work\\MiniCompiler\\helper\\a.exe < C:\\Users\\ASUS\\Desktop\\Work\\MiniCompiler\\helper\\mon_programme.txt";

            String fileName = "C:\\Users\\ASUS\\Desktop\\Work\\MiniCompiler\\helper\\mon_programme.txt"; // Replace with your desired file name

            try {
                File file = new File(fileName);
                FileWriter writer = new FileWriter(file);
                writer.write(content);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
            try {
                Process process = Runtime.getRuntime()
                        .exec(String.format("cmd.exe /c " + command));
                InputStream inputStream = process.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder output = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
                process.waitFor();
                return output.toString();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return "Error executing command: " + e.getMessage();
            }
        }
        else {
            return"";
        }
    }
}

