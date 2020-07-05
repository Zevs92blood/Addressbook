package ru.stqa.pft.addressbook.generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.tech.GData;
import ru.stqa.pft.addressbook.tech.Konfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GGen {

    public static void main(String[] args) throws IOException {
        Konfig konf = new Konfig();
        int count = Integer.parseInt(konf.groupCount);
        File file = new File(konf.groupFile);

        List<GData> group = genGroups(count);
        saveAsJson(group, file);
    }

    private static void saveAsJson(List<GData> group, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(group);
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private static List<GData> genGroups(int count) {
        List<GData> group = new ArrayList<GData>();
        for (int i = 0; i < count; i++){
            group.add(new GData(String.format("test %s", i), String.format("h %s", i), String.format("f %s", i)));
        }
        return group;
    }

}
