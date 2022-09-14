package com.mike.post.output;

import com.mike.post.model.News;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class WriterToFile {

    public void writeNewsToFile(final News[] newsArray) {
        try(FileWriter fw = new FileWriter(new File("result.txt"))) {
            for (News news : newsArray) {
                fw.write(String.valueOf(news));
                fw.write("\n");
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
