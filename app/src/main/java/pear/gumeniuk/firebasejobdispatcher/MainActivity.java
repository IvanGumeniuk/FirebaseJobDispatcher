package pear.gumeniuk.firebasejobdispatcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Trigger;

public class MainActivity extends AppCompatActivity {

    Button button;
    FirebaseJobDispatcher dispatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(MainActivity.this));

        dispatcher.mustSchedule(
                dispatcher.newJobBuilder()
                        .setService(DeviceService.class)
                        .setTag("MyService")
                        .setRecurring(true)
                        .setTrigger(Trigger.executionWindow(1,2))
                        .build());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatcher.cancel("MyService");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dispatcher.cancelAll();
    }
}
