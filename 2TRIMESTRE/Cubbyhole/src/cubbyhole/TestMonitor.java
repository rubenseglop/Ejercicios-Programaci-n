package cubbyhole;

public class TestMonitor {

    public static void main(String[] args) {
        CubbyHole cubohole = new CubbyHole();
        Productor p = new Productor(cubohole, 1000);
        Consumidor c = new Consumidor(cubohole, 2000);
        p.start();
        c.start();
    }
}
