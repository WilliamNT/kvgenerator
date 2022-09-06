import KV.CounterTerrorist;
import KV.KVBuilder;
import KV.Terrorist;

public class Main {
    public static void main(String[] args) {

        // This is just a simple demo. Feel free to wrap all this with a GUI or a commandline parser.
        KVBuilder kvBuilder = new KVBuilder("awp_lego_2");
        kvBuilder
                .setTerroristType(Terrorist.Leet)
                .setCounterTerroristType(CounterTerrorist.FBI)
                .build();
    }
}
