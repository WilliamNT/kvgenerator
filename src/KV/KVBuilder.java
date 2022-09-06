package KV;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class KVBuilder {
    private KVFile kvFile;

    public KVBuilder(String mapName) {
        kvFile = new KVFile(mapName);
    }

    public KVBuilder setTerroristType(Terrorist type) {
        switch (type) {
            case Anarchist -> kvFile.terrorist = Terrorist.Anarchist;
            case Balkan -> kvFile.terrorist = Terrorist.Balkan;
            case Leet -> kvFile.terrorist = Terrorist.Leet;
            case Phoenix -> kvFile.terrorist = Terrorist.Phoenix;
            case Pirate -> kvFile.terrorist = Terrorist.Pirate;
            case Professional -> kvFile.terrorist = Terrorist.Professional;
            case Separatist -> kvFile.terrorist = Terrorist.Separatist;
        }
        return this;
    }

    public KVBuilder setCounterTerroristType(CounterTerrorist type) {
        switch (type) {
            case FBI -> kvFile.counterTerrorist = CounterTerrorist.FBI;
            case GIGN -> kvFile.counterTerrorist = CounterTerrorist.GIGN;
            case GSG -> kvFile.counterTerrorist = CounterTerrorist.GSG;
            case IDF -> kvFile.counterTerrorist = CounterTerrorist.IDF;
            case SAS -> kvFile.counterTerrorist = CounterTerrorist.SAS;
            case Seals -> kvFile.counterTerrorist = CounterTerrorist.Seals;
            case SWAT -> kvFile.counterTerrorist = CounterTerrorist.SWAT;
        }
        return this;
    }

    public void build() {
        String content = String.format("""
                "%s"
                {
                \t"name"\t\t"%s"
                \t"t_arms"\t\"models/weapons/t_arms.mdl"
                \t"t_models"
                %s
                \t"ct_arms"\t"models/weapons/ct_arms.mdl"
                \t"ct_models"
                %s
                }
                """,
                kvFile.mapName,
                kvFile.mapName,
                getAppropriateTerroristModel(),
                getAppropriateCounterTerroristModel()
        );

        try {
            FileWriter fileWriter = new FileWriter(System.getProperty("user.home") + String.format("/Desktop/%s.kv", kvFile.mapName));
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAppropriateTerroristModel() {
        switch (kvFile.terrorist) {
            case Anarchist -> { return Model.Anarchist; }
            case Balkan -> { return Model.Balkan; }
            case Leet -> { return Model.Leet; }
            case Phoenix -> { return Model.Phoenix; }
            case Pirate -> { return Model.Pirate; }
            case Professional -> { return Model.Professional; }
            case Separatist -> { return Model.Separatist; }
        }
        return null;
    }

    private String getAppropriateCounterTerroristModel() {
        switch (kvFile.counterTerrorist) {
            case FBI -> { return Model.FBI; }
            case GIGN -> { return Model.GIGN; }
            case GSG -> { return Model.GSG; }
            case IDF -> { return Model.IDF; }
            case SAS -> { return Model.SAS; }
            case Seals -> { return Model.SEALS; }
            case SWAT -> { return Model.SWAT; }
        }
        return null;
    }
}
