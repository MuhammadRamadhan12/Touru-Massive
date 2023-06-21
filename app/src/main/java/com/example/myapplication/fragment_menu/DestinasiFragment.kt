package com.example.myapplication.fragment_menu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
<<<<<<< HEAD
=======
import android.widget.Toast
>>>>>>> 871b5c5 (destinasi dan login)
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.DestinasiModel
import com.example.myapplication.DetailDestinasi
import com.example.myapplication.R
import com.example.myapplication.adapter.DestinasiAdapter
import com.example.myapplication.find
<<<<<<< HEAD
=======
import com.example.myapplication.model.Data
import com.example.myapplication.model.DataDestination
>>>>>>> 871b5c5 (destinasi dan login)
import com.example.myapplication.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DestinasiFragment : Fragment() {
    private val TAG: String = "DestinasiFragment"
<<<<<<< HEAD
    lateinit var destinasiAdapter: DestinasiAdapter
=======
    private  lateinit var destinasiAdapter: DestinasiAdapter
>>>>>>> 871b5c5 (destinasi dan login)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destinasi, container, false)


    }

    private fun setupRecyclerView() {
        val recyclerView by lazy { find<RecyclerView>(R.id.rv_heroes) }
        destinasiAdapter = DestinasiAdapter(arrayListOf(), object : DestinasiAdapter.OnAdapterListener {
<<<<<<< HEAD
            override fun onClick(results: DestinasiModel.Result) {
                startActivity(
                    Intent(activity, DetailDestinasi::class.java)
                        .putExtra("intent_image", results.image)
                        .putExtra("intent_title", results.title)
=======
            override fun onClick(results:DataDestination) {
                startActivity(
                    Intent(activity, DetailDestinasi::class.java)
                        .putExtra("intent_photo", results.photo)
                        .putExtra("intent_title", results.title)
                        .putExtra("intent_desc", results.desc)
                        .putExtra("intent_city", results.city)
                        .putExtra("intent_localprice", results.localPrice)
                        .putExtra("intent_interprice", results.interPrice)
>>>>>>> 871b5c5 (destinasi dan login)
                )
            }

        })
        recyclerView.apply {
            recyclerView.layoutManager = GridLayoutManager(context,2, GridLayoutManager.VERTICAL, false)
            recyclerView.adapter = destinasiAdapter

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onStart()
        setupRecyclerView()
        getDataFromApi()


    }
    private fun getDataFromApi() {
        val progressBar = view?.findViewById<ProgressBar>(R.id.progressBar)
        progressBar!!.visibility = View.VISIBLE
        ApiService.endPoint.getData()
            .enqueue(object : Callback<DestinasiModel>{
                override fun onResponse(
                    call: Call<DestinasiModel>,
                    response: Response<DestinasiModel>)
                {
                    progressBar.visibility = View.GONE
                    if (response.isSuccessful) {
<<<<<<< HEAD
                        showData(response.body()!!)
=======
                        Toast.makeText(context, "Destinasi ${response.body()}", Toast.LENGTH_SHORT).show()
                        if(response.body()!= null) showData(response.body()!!)
>>>>>>> 871b5c5 (destinasi dan login)
                    }
                }

                override fun onFailure(call: Call<DestinasiModel>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    printLog("on Failure : $t")
                }

            })

    }
    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

<<<<<<< HEAD
    private fun showData(data: DestinasiModel) {
        val results = data.result
=======
    fun showData(data: DestinasiModel) {
        val results:ArrayList<DataDestination> = arrayListOf()
        results.addAll(data.data)
>>>>>>> 871b5c5 (destinasi dan login)
        destinasiAdapter.setData(results)
    }
}


