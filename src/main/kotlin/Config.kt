import org.json.JSONObject
import java.nio.file.Files
import java.nio.file.Paths

/**
 *@author Said Ibragimov on 03.11.2022 23:10
 */

object Config {
    private const val CONFIG_PATH = "src/main/resources/config.json"
    private val config: JSONObject = JSONObject(String(Files.readAllBytes(Paths.get(CONFIG_PATH))))

    val nodeUrl: String = config.getString("node_url")
    private val abi: JSONObject = config.getJSONObject("abi")
    val oracles: Map<String, String> = abi
        .keySet()
        .associateWith { abi.getString(it) }
}
