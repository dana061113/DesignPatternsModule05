package singleton;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private static final Object lock = new Object();
    private Map<String, String> settings;

    private ConfigurationManager() { settings = new HashMap<>(); }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) instance = new ConfigurationManager();
            }
        }
        return instance;
    }

    public void set(String key, String value) { settings.put(key, value); }

    public String get(String key) throws Exception {
        if (settings.containsKey(key)) return settings.get(key);
        throw new Exception("Настройка '" + key + "' не найдена!");
    }

    public void saveToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : settings.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        }
    }

    public void loadFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) throw new IOException("Файл конфигурации не найден!");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) settings.put(parts[0], parts[1]);
            }
        }
    }
}
