package pear.gumeniuk.firebasejobdispatcher;

import android.util.Log;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

/**
 * Created by Ваня on 15.03.2017.
 */

public class DeviceService extends JobService {

    @Override
    public boolean onStartJob(JobParameters job) {

            Log.d("iterD", "working...");

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        Log.d("iterD", "stopped");
        return false;
    }
}
