package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent()
        intent.setClass(this, LoginActivity().javaClass)
        startActivity(intent)

    }


}
