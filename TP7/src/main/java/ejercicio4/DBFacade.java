package ejercicio4;
import java.util.List;
import java.util.Map;

public interface DBFacade {
    void open();
    List<Map<String, String>> queryResultAsAsociation(String sql);
    List<String[]> queryResultAsArray(String sql);
    void close();
    void execute(String sql);
}