package cubex.mahesh.googleplacestest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Spinner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var sp1:Spinner? = null
    var lview:ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp1 = findViewById(R.id.sp1)
        lview = findViewById(R.id.lview)
    }

    fun  search(v:View)
    {
        var r = Retrofit.Builder().
                baseUrl("https://maps.googleapis.com/").
                addConverterFactory(GsonConverterFactory.create()).
                build()

        var api =  r.create(PlacesAPI ::class.java)

       var call = api.getPlaces(sp1?.selectedItem.toString())
        
        call.enqueue(object :Callback<Places>{
            override fun onFailure(call: Call<Places>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<Places>?,
                                    response: Response<Places>?) {

             var places =   response?.body()
             var list = places?.results

                lview?.setAdapter(
                        MyAdapter(this@MainActivity,list))

            }

        })

    }
}
