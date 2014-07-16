/**
 * Created by nilajapatankar on 4/22/14.
 */
public class EventHandler implements ICallable
{
    public EventHandler(){
    }

    public static void main(String[] args)
    {
        EventHandler myObject = new EventHandler();
        CallableImpl callable = new CallableImpl(myObject);
        System.out.println("Making a call....");
        Thread t1 = new Thread(callable,"Asynchronous Call");
        t1.start();
        System.out.println("Made Asynchronous Call.\nWaiting for response");
    }

    public void SuccessCallBackMethod() {
        System.out.println("Success");
    }

    public void FailureCallBackMethod() {
        System.out.println("Failure");
    }
}
