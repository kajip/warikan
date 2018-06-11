package jp.co.biglobe.isp.util.graceful_shutdown;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * Graceful Shutdown を実行するシグナルハンドラの実装クラス。<br>
 *
 * * CentOS7以降で使う systemd や Docker は、システム停止時にJavaプロセスに対してTERMシグナルを送る
 * * Graceful Shutdownの対象は、非同期処理のスレッド（@Asyncつけるやつ）
 * * HTTP処理スレッド(http-nio-8080-exec-1)には、効果がない。内部的にタイムアウトする仕組みが用意されている可能性がある
 * * sun.miscパッケージは、今後のバージョンで廃止される可能性があるので切り出しておく
 * * context.close()メソッドは、各スレッドに割り込み（Thread.interrupt()）を入れてから全スレッドの停止を待つ。
 *interruptされたスレッドがI/O待ちなどでブロック中の場合、直ちに InterruptedExceptionをスローしてブロックが
 *   解除される
 * * SIGTERMはJavaで予約されているかもしれないので、別のシグナルに変更した方が良いかも。
 */
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GracefulShutdownHandler implements SignalHandler {

    private final static String DEFAULT_SIGNAL = "TERM";


    public static void regist(ConfigurableApplicationContext context, String signal) {
        Signal.handle(new Signal(signal), new GracefulShutdownHandler(context));
    }

    public static void regist(ConfigurableApplicationContext context) {
        GracefulShutdownHandler.regist(context, DEFAULT_SIGNAL);
    }


    private final ConfigurableApplicationContext context;

    /**
     * @param signal
     */
    @Override
    public void handle(Signal signal) {
        log.info("running:{}", context.isRunning());
        log.info("active:{}", context.isActive());

        if (context.isRunning()) {
            log.info("Graceful Shutdown...");
            context.close();
            log.info("Bye");
        }
    }
}
