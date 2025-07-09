package helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonExtracter {

    public static List<String> extractJsonPaths(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File(filePath));
        List<String> paths = new ArrayList<>();
        collectPaths(root, "", paths);
        return paths;
    }

    private static void collectPaths(JsonNode node, String currentPath, List<String> paths) {
        if (node.isObject()) {
            Iterator<String> fieldNames = node.fieldNames();
            while (fieldNames.hasNext()) {
                String field = fieldNames.next();
                collectPaths(node.get(field), currentPath.isEmpty() ? field : currentPath + "." + field, paths);
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                collectPaths(node.get(i), currentPath + "[" + i + "]", paths);
            }
        } else {
            paths.add(currentPath);
        }
    }
}
