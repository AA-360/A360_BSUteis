package com.automationanywhere.botcommand.samples.commands.utils;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class File {

    public File(){}

    public ArrayList<String> readFile(String file){
        ArrayList<String> buffer = new ArrayList<String>();
        try {
//            FileReader fr = new FileReader(file);
//            Scanner sc = new Scanner(fr);
//            while (sc.hasNextLine())
//                buffer.add(sc.nextLine());

            String content = Files.readString(Paths.get(file), StandardCharsets.UTF_8);
            for(String line: content.split("\n")){
                buffer.add(line);
            }

        }catch (IOException e) {
            System.out.println("Erro ao ler arquivo:" + e.getMessage());
        }
        return buffer;
    }

    public void WritetoFile(String file, List<String> text){
        String content = "";
        Charset charset = StandardCharsets.UTF_8;
        Path path;
        String buffer[];
        path = Paths.get(file);
        content = String.join("\n",text);

        try {
            Files.write(path, content.getBytes(charset));
        }catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo");
        }

    }
}
