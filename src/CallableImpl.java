import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by nilajapatankar on 4/22/14.
 */
public class CallableImpl implements Runnable {

    EventHandler eventHandler;

    public CallableImpl(EventHandler handler) {
        eventHandler = handler;
    }

//    @Override
//    public void run() {
//        Thread t = new Thread();
//        t.start();
//        try {
//            t.sleep(10000);
//            eventHandler.SuccessCallBackMethod();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            eventHandler.FailureCallBackMethod();
//        }
//    }

    @Override
    public void run() {
        try {
            String url = "http://xplorationstudio.com/sample_images/products_json.json";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                eventHandler.SuccessCallBackMethod();
            } else {
                eventHandler.FailureCallBackMethod();
            }
        } catch (IOException e) {
            eventHandler.FailureCallBackMethod();
        }
    }
}
