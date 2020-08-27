package com.codingvizon.covid_19tracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class PrecautionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precautions)

        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayout.VERTICAL, false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.quarantine,"Stay Home","Stay home if you feel unwell."))
        precautionsList.add(Model(R.drawable.hand_wash,"Hand Wash","Clean your hands often. Use soap and water, or an alcohol-based hand rub."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance","Maintain a safe distance from anyone who is coughing or sneezing."))
        precautionsList.add(Model(R.drawable.hand_sanitizer,"Use Sanitizer","Clean any objects you touch a lot. Use disinfectants on objects like phones, computers, utensils, dishware, and doorknobs."))
        precautionsList.add(Model(R.drawable.medical_mask,"Use Mask","Cover your mouth with a tissue or the inside of your elbow whenever you sneeze or cough."))
        precautionsList.add(Model(R.drawable.avoid_touching,"Avoid Touching","Don’t touch your eyes, nose or mouth."))

        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recyclerView.adapter = precautionsAdapter
    }
}
