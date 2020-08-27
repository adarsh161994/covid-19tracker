package com.codingvizon.covid_19tracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL, false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough","Having a cough that gets more severe over time"))
        symptomsList.add(Model(R.drawable.fever,"Fever","A low-grade fever that gradually increases in temperature"))
//        symptomsList.add(Model(R.drawable.nose,"Runny Nose","about dry cough"))
        symptomsList.add(Model(R.drawable.sore_throat,"Sore Throat","A sore throat is a painful, dry, or scratchy feeling in the throat."))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter

        recyclerViewPrecautions.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL, false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.quarantine,"Stay Home","Stay home if you feel unwell."))
        precautionsList.add(Model(R.drawable.hand_wash,"Hand Wash","Clean your hands often. Use soap and water, or an alcohol-based hand rub."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance","Maintain a safe distance from anyone who is coughing or sneezing."))
//        precautionsList.add(Model(R.drawable.hand_sanitizer,"Hand \nSanitize","about dry cough"))

        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recyclerViewPrecautions.adapter = precautionsAdapter

        txtViewSymptoms.setOnClickListener{
            intent = Intent(this@MainActivity,SymptomsActivity::class.java)
            startActivity(intent)
        }

        btnKnowMore.setOnClickListener{
            intent = Intent(this@MainActivity,KnowMoreActivity::class.java)
            startActivity(intent)
        }

        txtViewPrecautions.setOnClickListener{
            intent = Intent(this@MainActivity,PrecautionsActivity::class.java)
            startActivity(intent)
        }

        getGlobalData()

    }

    fun getGlobalData(){
        val url:String ="https://corona.lmao.ninja/v2/all"
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> {

                var jsonObject = JSONObject(it.toString())

                //now set values in textview

                txtInfected.text = jsonObject.getString("cases")
                txtRecoverd.text = jsonObject.getString("recovered")
                txtDeceased.text = jsonObject.getString("deaths")
            },
            Response.ErrorListener {
                Toast.makeText(this@MainActivity,"Something went wrong",Toast.LENGTH_LONG).show()
                txtInfected.text = "-"
                txtRecoverd.text = "-"
                txtDeceased.text = "-"
            }
        )

        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)
    }

}
