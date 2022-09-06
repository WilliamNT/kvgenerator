package KV;

public class KVFile {
    // Basic
    public final String mapName;
    private String body;

    // Terrorist
    public Terrorist terrorist;

    // Counter terrorist
    public CounterTerrorist counterTerrorist;

    public KVFile(String mapName) {
        this.mapName = mapName;
    }
}
