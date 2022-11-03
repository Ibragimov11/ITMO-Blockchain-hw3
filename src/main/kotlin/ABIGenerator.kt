import org.web3j.codegen.SolidityFunctionWrapperGenerator
import java.io.File
import java.io.IOException
import java.nio.file.Paths

/**
 *@author Said Ibragimov on 04.11.2022 00:57
 */

fun main() {
    val exchangeRateFile = Paths.get("src/main/resources/abi/exchange_rate.json").toFile()

    try {
        SolidityFunctionWrapperGenerator(
            null,
            exchangeRateFile,
            File("src/main/java"),
            exchangeRateFile.nameWithoutExtension
                .split('_')
                .joinToString(separator = "") {
                    it.first().uppercase() + it.drop(1)
                },
            "abi",
            true,
            false,
            20
        ).generate()
    } catch (e: IOException) {
        println(e.message)
    } catch (e: ClassNotFoundException) {
        println(e.message)
    }
}