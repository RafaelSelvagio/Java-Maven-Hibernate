package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Classe utilitária para simplificar a configuração e uso de 
 * logging com Log4j2.
 */
public class LoggerUtil {
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    /**
     * Registra uma mensagem informativa no log.
     * @param message A mensagem informativa a ser registrada.
     */
    public static void logInfo(String message) {
        logger.info(message);
    }

    /**
     * Registra uma mensagem de erro no log juntamente com uma exceção.
     * @param message   A mensagem de erro a ser registrada.
     * @param throwable A exceção relacionada ao erro.
     */
    public static void logError(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}