# GithubTrends

NullPointer Stack Trace

2019-11-29 12:36:02.356 14341-14341/? E/Zygote: isWhitelistProcess - Process is Whitelisted
2019-11-29 12:36:02.359 14341-14341/? E/Zygote: accessInfo : 1
2019-11-29 12:36:07.279 14341-14341/com.kunalrai.githubtrends E/RecyclerView: No adapter attached; skipping layout
2019-11-29 12:36:12.636 14341-14341/com.kunalrai.githubtrends E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.kunalrai.githubtrends, PID: 14341
    kotlin.KotlinNullPointerException
        at com.kunalrai.githubtrends.ListFragment$onCreateView$1.onChanged(ListFragment.kt:47)
        at com.kunalrai.githubtrends.ListFragment$onCreateView$1.onChanged(ListFragment.kt:16)
        at androidx.lifecycle.LiveData.considerNotify(LiveData.java:131)
        at androidx.lifecycle.LiveData.dispatchingValue(LiveData.java:149)
        at androidx.lifecycle.LiveData.setValue(LiveData.java:307)
        at androidx.lifecycle.MutableLiveData.setValue(MutableLiveData.java:50)
        at com.kunalrai.githubtrends.ListViewModel$loadRepos$1.onResponse(ListViewModel.kt:29)
        at retrofit2.ExecutorCallAdapterFactory$ExecutorCallbackCall$1$1.run(ExecutorCallAdapterFactory.java:71)
        at android.os.Handler.handleCallback(Handler.java:873)
        at android.os.Handler.dispatchMessage(Handler.java:99)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7078)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:494)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:974)
